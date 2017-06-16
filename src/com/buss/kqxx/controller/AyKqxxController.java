package com.buss.kqxx.controller;


import com.buss.gz.entity.AyGzEntity;
import com.buss.jx.entity.AyJxEntity;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.kqsj.entity.AyKqsjEntity;
import com.buss.kqxx.entity.AyKqxxEntity;
import com.buss.kqxx.entity.AyKqxxEntityPage;
import com.buss.kqxx.service.AyKqxxServiceI;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 考勤信息表
 * @author caozengling
 * @date 2017-03-15 14:47:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayKqxxController")
public class AyKqxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyKqxxController.class);

	@Autowired
	private AyKqxxServiceI ayKqxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 考勤信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		AyJxsjEntity ayKqsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
//		if("0".equals(ayKqsjEntity.getTjzt3())){
//			List<AyKqxxEntity> ayKcxxEntityList1=systemService.findHql("FROM AyKqxxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
//			for (AyKqxxEntity ayKqxxEntity : ayKcxxEntityList1) {
//				systemService.delete(ayKqxxEntity);
//			}
//		}
		List<AyKqxxEntity> ayKcxxEntityList=systemService.findHql("FROM AyKqxxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
		
		if(ayKcxxEntityList.size()==0){
			List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where 1=1 and zxbm=? and yglx <>? and yglx <> ? and zzzt=?",zxid,"劳务员工","劳务实习","在职");
			for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
				AyKqxxEntity ayKqxxEntity = new AyKqxxEntity();
				ayKqxxEntity.setXm(aYgjbxxlists.getXm());
				ayKqxxEntity.setSjpzid(sjpzid);
				ayKqxxEntity.setYgxxid(aYgjbxxlists.getId());
				ayKqxxEntity.setZxbm(zxid);
				ayKqxxEntity.setYglx(aYgjbxxlists.getYglx());
				ayKqxxEntity.setDyycq(ayKqsjEntity.getDyycq());
				ayKqxxEntity.setFdj(Double.valueOf(ayKqsjEntity.getFdj()));
				ayKqxxEntity.setZfbtbz(aYgjbxxlists.getZfbt());
				systemService.save(ayKqxxEntity);
			}
		}
		return new ModelAndView("com/buss/kqxx/ayKqxxList");
	}
	/**
	 * 考勤信息表列表查看 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		return new ModelAndView("com/buss/kqxx/ayKqxxListChakan");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(AyKqxxEntity ayKqxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyKqxxEntity.class, dataGrid);
		String sjpzid = request.getParameter("sjpzid");
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKqxx, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(!StringUtil.isEmpty(sjpzid)){
				cq.eq("sjpzid", sjpzid);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayKqxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考勤信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyKqxxEntity ayKqxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayKqxx = systemService.getEntity(AyKqxxEntity.class, ayKqxx.getId());
		message = "考勤信息表删除成功";
		try{
			ayKqxxService.delete(ayKqxx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考勤信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤信息表删除成功";
		try{
			for(String id:ids.split(",")){
				AyKqxxEntity ayKqxx = systemService.getEntity(AyKqxxEntity.class, 
				id
				);
				ayKqxxService.delete(ayKqxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考勤信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyKqxxEntity ayKqxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤信息表添加成功";
		try{
			ayKqxxService.save(ayKqxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 保存新增/更新的行数据
	 * @param page
	 * @return
	 */
	@RequestMapping(params = "saveRows")
	@ResponseBody
	public AjaxJson saveRows(AyKqxxEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyKqxxEntity> ayKqxEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		String sjpzid= "";//年月id
		String zxid = "";
		if(CollectionUtils.isNotEmpty(ayKqxEntity)){
			sjpzid = ayKqxEntity.get(0).getSjpzid();
			AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
			zxid = ayJxsjEntity.getZxbm();
			for(AyKqxxEntity ayKqxxEntitys:ayKqxEntity){
				if (StringUtil.isNotEmpty(ayKqxxEntitys.getId())) {
					AyKqxxEntity t =systemService.get(AyKqxxEntity.class, ayKqxxEntitys.getId());
					try {
						message = "提交成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayKqxxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayKqxxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt3 = 1 where id=" + "'"+ayKqxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
			//修改考勤后，更新工资
			List<AyGzEntity> ayGzEntityList1 = systemService.findHql("FROM AyGzEntity where sjpzid=? and zxbm=?", sjpzid, zxid);
			for (AyGzEntity ayGzEntity : ayGzEntityList1) {
				AyYgjbxxEntity aYgjbxxlists = systemService.getEntity(AyYgjbxxEntity.class, ayGzEntity.getYgxxid());
				List<AyKqxxEntity> ayKqxxEntitylist = systemService.findHql("FROM AyKqxxEntity where sjpzid =? and ygxxid =? and zxbm = ?", sjpzid, aYgjbxxlists.getId(),ayJxsjEntity.getZxbm());
				if(ayKqxxEntitylist!=null){
		        	if(ayKqxxEntitylist.size()==1){
		        		AyKqxxEntity ayKqxxEntity = ayKqxxEntitylist.get(0);
		        		
		        		//缺勤扣款
		        		String jbgz = aYgjbxxlists.getJbgz();
		        		String dyycq = ayKqxxEntity.getDyycq();
		        		Double bjts = ayKqxxEntity.getBj();
		        		Double sjts = ayKqxxEntity.getSj();
		        		if(StringUtil.isEmpty(jbgz)){
		        			jbgz = "0";
		        		}
		        		if(StringUtil.isEmpty(dyycq)){
		        			dyycq = "0";
		        		}
		        		if(bjts==null){
		        			bjts = 0.0;
		        		}
		        		if(sjts==null){
		        			sjts = 0.0;
		        		}
		        		double jbgz_d = Double.valueOf(jbgz);
		        		double dyycq_d = Double.valueOf(dyycq);
		        		
		        		double qqkk_d = (-1)*(jbgz_d/dyycq_d * bjts * 0.5 + jbgz_d/dyycq_d * sjts);
		        		
		        		ayGzEntity.setQqkk(String.valueOf(qqkk_d));
		        		
		        		//餐费补助
		        		//20170515，餐费补助修改计算公式为：按天*实际出勤
//		        		String cfbz = ayGzsjEntity.getCf();
//		        		String cbts = ayKqxxEntity.getCb();
		        		String cfbz = aYgjbxxlists.getCfbz();
		        		Double sjcq = ayKqxxEntity.getSjcq();
		        		if(sjcq==null){
		        			sjcq = 0.00;
		        		}
		        		if(StringUtil.isEmpty(cfbz)){
		        			cfbz = "0";
		        		}
		        		
		        		double cfbz_f = Double.valueOf(cfbz);
//		        		float cbts_f = Float.valueOf(cbts);
		        		
		        		double cb_f = cfbz_f*sjcq;
		        		ayGzEntity.setCfbz(String.valueOf(cb_f));
		        		
		        		//交通补助
		        		//20170515，交通补助修改计算公式为：按月/应出勤*实际出勤
		        		String jtbz = aYgjbxxlists.getJtbz();
//		        		String jtts = ayKqxxEntity.getJtb();
		        		if(StringUtil.isEmpty(jtbz)){
		        			jtbz = "0";
		        		}
//		        		if(StringUtil.isEmpty(jtts)){
//		        			jtts = "0";
//		        		}
		        		double jtbz_f = (Double.valueOf(jtbz)/dyycq_d)*sjcq;
		        		ayGzEntity.setJtbz(String.valueOf(jtbz_f));
		        		
		        		//通讯补助
		        		String txbz_s = aYgjbxxlists.getTxbz();
		        		if(StringUtil.isEmpty(txbz_s)){
		        			txbz_s = "0";
		        		}
		        		ayGzEntity.setTxbz(txbz_s);
		        		
		        		//出差补助 = 出差补助*出差天数
		        		String ccbz_s = aYgjbxxlists.getCcbz();
		        		if(StringUtil.isEmpty(ccbz_s)){
		        			ccbz_s = "0";
		        		}
		        		double ccts = ayKqxxEntity.getCc();
		        		
		        		double ccbz = Double.valueOf(ccbz_s)*ccts;
		        		ayGzEntity.setCcbz(String.valueOf(ccbz));
		        		
		        		//住房补助
		        		//如果住房补助为0，则为0，
		        		//如果住房补助>0，则实际出勤/当月应出勤<0.5,为住房补助费用*实际出勤/当月应出勤
		        		//如果住房补助>0，则实际出勤/当月应出勤>=0.5,为住房补助费用
		        		String zfbt_s = aYgjbxxlists.getZfbt();
		        		
		        		if(StringUtil.isEmpty(zfbt_s)){
		        			zfbt_s = "0";
		        		}
		        		
		        		
		        		double bilv = sjcq/dyycq_d;
		        		
		        		double zfbz_d = 0.0;
		        		
		        		if(bilv<0.5){
		        			zfbz_d = bilv*Double.valueOf(zfbt_s);
		        		}else{
		        			zfbz_d = Double.valueOf(zfbt_s);
		        		}
		        		
		        		ayGzEntity.setZfbz(String.valueOf(zfbz_d));

		        		
		        		
		        	}
				}
				systemService.saveOrUpdate(ayGzEntity);
				systemService.updateBySqlString("update AY_JXSJ set tjzt6 = 0 where id=" + "'"+sjpzid+"'");//更新当月的提交状态
			}
		}
		return j;

	}
	
	@RequestMapping(params = "submitRows")
	@ResponseBody
	public AjaxJson submitRows(AyKqxxEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyKqxxEntity> ayKqxEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayKqxEntity)){
			for(AyKqxxEntity ayKqxxEntitys:ayKqxEntity){
				if (StringUtil.isNotEmpty(ayKqxxEntitys.getId())) {
					AyKqxxEntity t =systemService.get(AyKqxxEntity.class, ayKqxxEntitys.getId());
					try {
						message = "提交成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayKqxxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayKqxxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt3 = 2 where id=" + "'"+ayKqxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;

	}
	
	/**
	 * 更新考勤信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyKqxxEntity ayKqxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤信息表更新成功";
		AyKqxxEntity t = ayKqxxService.get(AyKqxxEntity.class, ayKqxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayKqxx, t);
			ayKqxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考勤信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考勤信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyKqxxEntity ayKqxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKqxx.getId())) {
			ayKqxx = ayKqxxService.getEntity(AyKqxxEntity.class, ayKqxx.getId());
			req.setAttribute("ayKqxxPage", ayKqxx);
		}
		return new ModelAndView("com/buss/kqxx/ayKqxx-add");
	}
	/**
	 * 考勤信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyKqxxEntity ayKqxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKqxx.getId())) {
			ayKqxx = ayKqxxService.getEntity(AyKqxxEntity.class, ayKqxx.getId());
			req.setAttribute("ayKqxxPage", ayKqxx);
		}
		return new ModelAndView("com/buss/kqxx/ayKqxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayKqxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyKqxxEntity ayKqxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyKqxxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKqxx, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyKqxxEntity> ayKqxxs = this.ayKqxxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"考勤信息表");
		modelMap.put(NormalExcelConstants.CLASS,AyKqxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考勤信息表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayKqxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyKqxxEntity ayKqxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"考勤信息表");
    	modelMap.put(NormalExcelConstants.CLASS,AyKqxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考勤信息表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<AyKqxxEntity> listAyKqxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyKqxxEntity.class,params);
				for (AyKqxxEntity ayKqxx : listAyKqxxEntitys) {
					ayKqxxService.save(ayKqxx);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<AyKqxxEntity> list() {
		List<AyKqxxEntity> listAyKqxxs=ayKqxxService.getList(AyKqxxEntity.class);
		return listAyKqxxs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyKqxxEntity task = ayKqxxService.get(AyKqxxEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyKqxxEntity ayKqxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKqxxEntity>> failures = validator.validate(ayKqxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKqxxService.save(ayKqxx);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayKqxx.getId();
		URI uri = uriBuilder.path("/rest/ayKqxxController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyKqxxEntity ayKqxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKqxxEntity>> failures = validator.validate(ayKqxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKqxxService.saveOrUpdate(ayKqxx);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		ayKqxxService.deleteEntityById(AyKqxxEntity.class, id);
	}
}
