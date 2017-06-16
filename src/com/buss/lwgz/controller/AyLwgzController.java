package com.buss.lwgz.controller;

import com.buss.gsbz.entity.AyGsbzEntity;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.lwgz.entity.AyLwgzEntity;
import com.buss.lwgz.entity.AyLwgzEntityPage;
import com.buss.lwgz.service.AyLwgzServiceI;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import com.buss.zxpz.entity.AyZxpzEntity;

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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 劳务工资
 * @author caozengling
 * @date 2017-03-23 15:12:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayLwgzController")
public class AyLwgzController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyLwgzController.class);

	@Autowired
	private AyLwgzServiceI ayLwgzService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 劳务工资列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
		if("0".equals(ayJxsjEntity.getTjzt5())){
			List<AyLwgzEntity> ayKcxxEntityList1=systemService.findHql("FROM AyLwgzEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
			for (AyLwgzEntity ayLwgzEntity : ayKcxxEntityList1) {
				systemService.delete(ayLwgzEntity);
			}
		}
		DecimalFormat df  = new DecimalFormat("###.00");
		List<AyLwgzEntity> ayKcxxEntityList=systemService.findHql("FROM AyLwgzEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
		if(ayKcxxEntityList.size()==0){
			List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where (yglx=? or yglx=?) and zxbm=? and zzzt=?","劳务员工","劳务实习",zxid,"在职");
			for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
				AyLwgzEntity ayLwgzEntity = new AyLwgzEntity();
				ayLwgzEntity.setXm(aYgjbxxlists.getXm());
				ayLwgzEntity.setSjpzid(sjpzid);
				ayLwgzEntity.setSfzh(aYgjbxxlists.getSfzh());
				ayLwgzEntity.setYhzh(aYgjbxxlists.getYhzh());
				ayLwgzEntity.setYgxxid(aYgjbxxlists.getId());
				ayLwgzEntity.setZxbm(zxid);
				ayLwgzEntity.setJbgz(aYgjbxxlists.getJbgz());
				//其他补贴
				String qtbt = aYgjbxxlists.getQtbt();
				if(StringUtil.isEmpty(qtbt)){
					qtbt = "0";
				}
				ayLwgzEntity.setBt(qtbt);
				
				//合计 = 基本工资 + 其他补贴
				String jbgz_s = aYgjbxxlists.getJbgz();
				if(StringUtil.isEmpty(jbgz_s)){
					jbgz_s = "0";
				}
				double jbgz = Double.valueOf(jbgz_s);
				String qtbt_s = aYgjbxxlists.getQtbt();
				if(StringUtil.isEmpty(qtbt_s)){
					qtbt_s = "0";
				}
				double qtbt_d = Double.valueOf(qtbt);
				
				double hj_d = jbgz + qtbt_d;
				ayLwgzEntity.setHj(df.format(hj_d));
				
				String mze_s = "0";
				//免征额
				List<AyZxpzEntity> ayZxpzEntityList = systemService.findHql("FROM AyZxpzEntity where zxbm=?", zxid);
				if(ayZxpzEntityList!=null&&ayZxpzEntityList.size()>0){
					AyZxpzEntity t = ayZxpzEntityList.get(0);
					request.setAttribute("lwmze", t.getLwmze());
					ayLwgzEntity.setMze(t.getLwmze());
					mze_s = t.getLwmze();
				}
				
				//实纳税所得额 = 合计 - 免征额
				double mze = Double.valueOf(mze_s);
				double snsde = hj_d - mze;
				ayLwgzEntity.setSnssde(df.format(snsde));
				
				String sl_s = "0";
				String sskc = "0";
				//税率
				List<AyGsbzEntity> ayGsbzEntitylist = systemService.findHql("from AyGsbzEntity");
				for (AyGsbzEntity ayGsbzEntity : ayGsbzEntitylist) {
					double ks = Double.valueOf(ayGsbzEntity.getKsje());
					double js = Double.valueOf(ayGsbzEntity.getJsje());
					if(snsde>ks&&snsde<=js){
						sl_s = ayGsbzEntity.getSl();
						sskc = ayGsbzEntity.getSskcs();
					}
				}
				double sl_d = Double.valueOf(sl_s);
				double sskc_d = Double.valueOf(sskc);
				ayLwgzEntity.setSl(sl_s);
				
				//个人所得税 = 实纳税所得额 * 税率 /100 - 速算扣除数
				double grsds = (snsde * sl_d) /100 - sskc_d;
				ayLwgzEntity.setGrsds(df.format(grsds));
				
				//税后工资 = 合计 - 个人所得税
				double shgz = hj_d - grsds;
				ayLwgzEntity.setShgz(df.format(shgz));
				
				//其他
				String qt = aYgjbxxlists.getQt();
				if(StringUtil.isEmpty(qt)){
					qt = "0";
				}
				ayLwgzEntity.setQt(qt);
				double qt_d = Double.valueOf(qt);
				
				//实发工资 = 税后工资 + 其他
				double sfgz = shgz + qt_d;
				ayLwgzEntity.setSfgz(df.format(sfgz));
				
				systemService.save(ayLwgzEntity);
			}
		}
		systemService.updateBySqlString("update AY_JXSJ set tjzt5 = 2 where id=" + "'"+sjpzid+"'");//更新当月的提交状态
		return new ModelAndView("com/buss/lwgz/ayLwgzList");
	}
	
	/**
	 * 劳务工资列表 查看页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		request.setAttribute("zxid",zxid);
		
		return new ModelAndView("com/buss/lwgz/ayLwgzListChakan");
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
	public void datagrid(AyLwgzEntity ayLwgz,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyLwgzEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayLwgz, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("sjpzid", sjpzid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayLwgzService.getDataGridReturn(cq, true);
		List<AyLwgzEntity> ayLwgzEntitys =dataGrid.getResults();
		List<Object> newdata = new ArrayList<Object>();
//		for(AyLwgzEntity ayLwgzEntity:ayLwgzEntitys){
//			Map<String,Object> map= new HashedMap();
//			map.put("id",ayLwgzEntity.getId());
//			List<AyYgjbxxEntity> ayYgjbxxEntity= systemService.findHql("from AyYgjbxxEntity where id=?",ayLwgzEntity.getYgxxid());
//			if(ayYgjbxxEntity.size()>0){
//				map.put("xm",ayYgjbxxEntity.get(0).getXm());
//				map.put("sfzh",ayYgjbxxEntity.get(0).getSfzh());
//			}
//			List<AyGzEntity> ayGzEntity= systemService.findHql("from AyGzEntity where ygxxid=?",ayLwgzEntity.getYgxxid());
//			if(ayGzEntity.size()>0){
//				map.put("jbgz",ayGzEntity.get(0).getJbgz());
//				map.put("mze",ayGzEntity.get(0).getMze());
//				map.put("snssde",ayGzEntity.get(0).getSnssde());
//				map.put("sl",ayGzEntity.get(0).getSl());
//				map.put("grsds",ayGzEntity.get(0).getGrsds());
//				map.put("shgz",ayGzEntity.get(0).getShgz());
//				map.put("qt",ayGzEntity.get(0).getQt());
//				map.put("sfgz",ayGzEntity.get(0).getSfgz());
//				map.put("yhzh",ayGzEntity.get(0).getYhzh());
//			}else{
//				map.put("jbgz",ayLwgzEntity.getJbgz());
//				map.put("mze",ayLwgzEntity.getMze());
//				map.put("snssde",ayLwgzEntity.getSnssde());
//				map.put("sl",ayLwgzEntity.getSl());
//				map.put("grsds",ayLwgzEntity.getGrsds());
//				map.put("shgz",ayLwgzEntity.getShgz());
//				map.put("qt",ayLwgzEntity.getQt());
//				map.put("sfgz",ayLwgzEntity.getSfgz());
//				map.put("yhzh",ayLwgzEntity.getYhzh());
//			}
//			map.put("bt",ayLwgzEntity.getBt());
//			map.put("hj",ayLwgzEntity.getHj());
//			newdata.add(map);
//
//		}
		
//		dataGrid.setResults(newdata);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除劳务工资
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyLwgzEntity ayLwgz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayLwgz = systemService.getEntity(AyLwgzEntity.class, ayLwgz.getId());
		message = "劳务工资删除成功";
		try{
			ayLwgzService.delete(ayLwgz);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除劳务工资
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资删除成功";
		try{
			for(String id:ids.split(",")){
				AyLwgzEntity ayLwgz = systemService.getEntity(AyLwgzEntity.class, 
				id
				);
				ayLwgzService.delete(ayLwgz);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加劳务工资
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyLwgzEntity ayLwgz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资添加成功";
		try{
			ayLwgzService.save(ayLwgz);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资添加失败";
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
	public AjaxJson saveRows(AyLwgzEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyLwgzEntity> ayLwgzEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayLwgzEntity)){
			for(AyLwgzEntity aLwgzEntitys:ayLwgzEntity){
				if (StringUtil.isNotEmpty(aLwgzEntitys.getId())) {
					AyLwgzEntity t =systemService.get(AyLwgzEntity.class, aLwgzEntitys.getId());
					try {
						message = "保存成功";
						MyBeanUtils.copyBeanNotNull2Bean(aLwgzEntitys, t);
						if("".equals(t.getBt())){
							t.setBt("0");
						}
						if("".equals(t.getCb())){
							t.setCb("0");
						}
						if("".equals(t.getQt())){
							t.setQt("0");
						}
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(aLwgzEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt5 = 1 where id=" + "'"+ayLwgzEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;
	}
	
	 /* 保存新增/更新的行数据
	 * @param page
	 * @return
	 */
	@RequestMapping(params = "doTiJiao")
	@ResponseBody
	public AjaxJson doTiJiao(AyLwgzEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyLwgzEntity> ayLwgzEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayLwgzEntity)){
			for(AyLwgzEntity aLwgzEntitys:ayLwgzEntity){
				if (StringUtil.isNotEmpty(aLwgzEntitys.getId())) {
					AyLwgzEntity t =systemService.get(AyLwgzEntity.class, aLwgzEntitys.getId());
					try {
						message = "提交成功";
						MyBeanUtils.copyBeanNotNull2Bean(aLwgzEntitys, t);
						if("".equals(t.getBt())){
							t.setBt("0");
						}
						if("".equals(t.getCb())){
							t.setCb("0");
						}
						if("".equals(t.getQt())){
							t.setQt("0");
						}
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(aLwgzEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt5 = 2 where id=" + "'"+ayLwgzEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;
	}
	
	
	/**
	 * 更新劳务工资
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyLwgzEntity ayLwgz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资更新成功";
		AyLwgzEntity t = ayLwgzService.get(AyLwgzEntity.class, ayLwgz.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayLwgz, t);
			ayLwgzService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "劳务工资更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 劳务工资新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyLwgzEntity ayLwgz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayLwgz.getId())) {
			ayLwgz = ayLwgzService.getEntity(AyLwgzEntity.class, ayLwgz.getId());
			req.setAttribute("ayLwgzPage", ayLwgz);
		}
		return new ModelAndView("com/buss/lwgz/ayLwgz-add");
	}
	/**
	 * 劳务工资编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyLwgzEntity ayLwgz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayLwgz.getId())) {
			ayLwgz = ayLwgzService.getEntity(AyLwgzEntity.class, ayLwgz.getId());
			req.setAttribute("ayLwgzPage", ayLwgz);
		}
		return new ModelAndView("com/buss/lwgz/ayLwgz-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayLwgzController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyLwgzEntity ayLwgz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyLwgzEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayLwgz, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyLwgzEntity> ayLwgzs = this.ayLwgzService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"劳务工资");
		modelMap.put(NormalExcelConstants.CLASS,AyLwgzEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("劳务工资列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayLwgzs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyLwgzEntity ayLwgz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"劳务工资");
    	modelMap.put(NormalExcelConstants.CLASS,AyLwgzEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("劳务工资列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyLwgzEntity> listAyLwgzEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyLwgzEntity.class,params);
				for (AyLwgzEntity ayLwgz : listAyLwgzEntitys) {
					ayLwgzService.save(ayLwgz);
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
	public List<AyLwgzEntity> list() {
		List<AyLwgzEntity> listAyLwgzs=ayLwgzService.getList(AyLwgzEntity.class);
		return listAyLwgzs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyLwgzEntity task = ayLwgzService.get(AyLwgzEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyLwgzEntity ayLwgz, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyLwgzEntity>> failures = validator.validate(ayLwgz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayLwgzService.save(ayLwgz);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayLwgz.getId();
		URI uri = uriBuilder.path("/rest/ayLwgzController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyLwgzEntity ayLwgz) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyLwgzEntity>> failures = validator.validate(ayLwgz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayLwgzService.saveOrUpdate(ayLwgz);
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
		ayLwgzService.deleteEntityById(AyLwgzEntity.class, id);
	}
}
