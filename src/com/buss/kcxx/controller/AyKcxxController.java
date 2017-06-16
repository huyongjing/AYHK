package com.buss.kcxx.controller;

import com.buss.kcpz.entity.AyKcpzEntity;
import com.buss.kcxx.entity.AyKcxxEntity;
import com.buss.kcxx.service.AyKcxxServiceI;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.*;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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
 * @Description: 课程信息
 * @author caozengling
 * @date 2017-03-14 14:28:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayKcxxController")
public class AyKcxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyKcxxController.class);

	@Autowired
	private AyKcxxServiceI ayKcxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 课程信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxid");
		request.setAttribute("sjpzid",sjpzid);
		//TODO  根据 列表 row  年 月 、中心 去做操作  操作标识 add 和 update
		//TODO  判断年月中心有没有数据

		List<Object> newdata = new ArrayList<>();
		List<AyKcxxEntity> ayKcxxEntityList=systemService.findHql("FROM AyKcxxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
		//TODO 新增： 判断上月份的有没有数据  有：没有
		if(ayKcxxEntityList.size()==0){
			List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where 1=1 and zxbm=? and yglx <>? and yglx <> ? and yglx <> ? and zzzt=?",zxid,"劳务员工","劳务实习","离职员工","在职");
			List<AyKcpzEntity> kcxxlist=systemService.findHql("from AyKcpzEntity where 1=1 and zx=?",zxid);
			for(AyKcpzEntity ayKcpzlists:kcxxlist){
				for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
					AyKcxxEntity ayKcxxEntity = new AyKcxxEntity();
					ayKcxxEntity.setKcmc(ayKcpzlists.getKcmc());
					ayKcxxEntity.setKcxs(ayKcpzlists.getXs());
					ayKcxxEntity.setYgxxid(aYgjbxxlists.getId());
					ayKcxxEntity.setSfzh(aYgjbxxlists.getSfzh());
					ayKcxxEntity.setZxbm(zxid);
					ayKcxxEntity.setXm(aYgjbxxlists.getXm());
					ayKcxxEntity.setSjpzid(sjpzid);
					systemService.save(ayKcxxEntity);
				}
			}

		}
		return new ModelAndView("com/buss/kcxx/ayKcxxList");
	}

	/**
	 * 课程查看信息列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxid");
		request.setAttribute("sjpzid",sjpzid);
		//TODO  根据 列表 row  年 月 、中心 去做操作  操作标识 add 和 update
		//TODO  判断年月中心有没有数据
		//TODO 新增： 判断上月份的有没有数据  有：没有

		return new ModelAndView("com/buss/kcxx/ayKcxxListChakan");
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
	public void datagrid(AyKcxxEntity ayKcxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyKcxxEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKcxx, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(!StringUtil.isEmpty(sjpzid)){
				cq.eq("sjpzid", sjpzid);
			}
			cq.addOrder("xm", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayKcxxService.getDataGridReturn(cq, true);
		/*List<AyKcxxEntity> ayYgjbxxs =dataGrid.getResults();
		List<Object> newdata = new ArrayList<Object>();
		for(AyKcxxEntity ayYgjbxxf:ayYgjbxxs){
			Map<String,Object> map= new HashedMap();
			map.put("id",ayYgjbxxf.getId());
			map.put("kcmc",ayYgjbxxf.getKcmc());
			map.put("kcxs",ayYgjbxxf.getKcxs());
			map.put("sjpzid",ayYgjbxxf.getSjpzid());//保存时间表id
			map.put("ygxxid",ayYgjbxxf.getYgxxid());//保存时间表id
			List<AyYgjbxxEntity> xm= systemService.findHql("from AyYgjbxxEntity where id=?",ayYgjbxxf.getYgxxid());
			if(StringUtil.isNotEmpty(xm)){
				map.put("xm",xm.get(0).getXm());
			}
			newdata.add(map);
		}
		dataGrid.setResults(newdata);*/
		TagUtil.datagrid(response, dataGrid);
	}


	/**
	 * easyui 课程信息添加用户信息
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagridyg")
	public void datagridyg(AyYgjbxxEntity ayYgjbxx, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyYgjbxxEntity.class, dataGrid);
		if("0".equals(ayYgjbxx.getXb())){
			ayYgjbxx.setXb("男性");
		}if("1".equals(ayYgjbxx.getXb())){
			ayYgjbxx.setXb("女性");
		}else {

		}
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayYgjbxx, request.getParameterMap());
		try{
			//自定义追加查询条件
			String ids1 = "402881235aa7c6b4015aa7fa7a67000f,402881235aa7c6b4015aa7fa7a67000y";
			List<String> ids = systemService.findListbySql("SELECT  DISTINCT(ygxxid) FROM `ay_kcxx`");
			for(String id:ids){
				cq.notEq("id",id);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		/*List<AyYgjbxxEntity> ayYgjbxxs =dataGrid.getResults();
		List<Object> newdata = new ArrayList<Object>();
		Map<String,Object> map= new HashedMap();
		for(AyYgjbxxEntity ayYgjbxxf:ayYgjbxxs){
			map.put("sr",ayYgjbxxf.getSr());
			newdata.add(map);
		}
		dataGrid.setResults(newdata);*/
		/*Map<String,Object> newdata = new HashMap<String,Object>();*/
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除课程信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyKcxxEntity ayKcxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayKcxx = systemService.getEntity(AyKcxxEntity.class, ayKcxx.getId());
		message = "课程信息删除成功";
		try{
			ayKcxxService.delete(ayKcxx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "课程信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除课程信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "课程信息删除成功";
		try{
			for(String id:ids.split(",")){
				AyKcxxEntity ayKcxx = systemService.getEntity(AyKcxxEntity.class, 
				id
				);
				ayKcxxService.delete(ayKcxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "课程信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加课程信息配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyKcxxEntity ayKcxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "课程信息添加成功";
		try{
			ayKcxxService.save(ayKcxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "课程信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 添加课程信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAddkc")
	@ResponseBody
	public AjaxJson doAddkc(AyKcxxEntity ayKcxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		String ygid = request.getParameter("ygid");
		message = "课程信息添加成功";
		try{
			ayKcxx.setYgxxid(ygid);
			ayKcxxService.save(ayKcxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "课程信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 课程信息添加页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goAddkc")
	public ModelAndView goAddkc(AyKcxxEntity ayKcxx, HttpServletRequest req) {
		Map<String,String> allCenters = ResourceUtil.allCenters;
		String json = JSONHelper.map2json(allCenters);
		String kcid = req.getParameter("kcid");
		req.setAttribute("allCenters",json);
		req.setAttribute("kcid",kcid);
		return new ModelAndView("com/buss/kcxx/ayKcpzList");
	}
	
	/**
	 * 更新课程信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyKcxxEntity ayKcxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "课程信息更新成功";
		AyKcxxEntity t = ayKcxxService.get(AyKcxxEntity.class, ayKcxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayKcxx, t);
			ayKcxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "课程信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新课程信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpKc")
	@ResponseBody
	public AjaxJson doUpKc(AyKcxxEntity ayKcxx, HttpServletRequest request) {
		String message = null;
		String kcid = request.getParameter("kcid");
		String id = request.getParameter("id");
		AjaxJson j = new AjaxJson();
		message = "课程信息更新成功";
		AyKcxxEntity t = ayKcxxService.get(AyKcxxEntity.class, kcid);
		AyKcpzEntity ayKcpz = systemService.getEntity(AyKcpzEntity.class, id);
		try {
			t.setKcmc(ayKcpz.getKcmc());
			t.setId(kcid);
			t.setKcxs(ayKcpz.getXs());
			//MyBeanUtils.copyBeanNotNull2Bean(ayKcxx, t);
			ayKcxxService.save(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "课程信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 课程信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyKcxxEntity ayKcxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKcxx.getId())) {
			ayKcxx = ayKcxxService.getEntity(AyKcxxEntity.class, ayKcxx.getId());
			req.setAttribute("ayKcxxPage", ayKcxx);
		}
		return new ModelAndView("com/buss/kcxx/ayYgjbxxList");
	}
	/**
	 * 课程信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyKcxxEntity ayKcxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKcxx.getId())) {
			ayKcxx = ayKcxxService.getEntity(AyKcxxEntity.class, ayKcxx.getId());
			req.setAttribute("ayKcxxPage", ayKcxx);
		}
		return new ModelAndView("com/buss/kcxx/ayKcxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayKcxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyKcxxEntity ayKcxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyKcxxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKcxx, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyKcxxEntity> ayKcxxs = this.ayKcxxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"课程信息");
		modelMap.put(NormalExcelConstants.CLASS,AyKcxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("课程信息列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayKcxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyKcxxEntity ayKcxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"课程信息");
    	modelMap.put(NormalExcelConstants.CLASS,AyKcxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("课程信息列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyKcxxEntity> listAyKcxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyKcxxEntity.class,params);
				for (AyKcxxEntity ayKcxx : listAyKcxxEntitys) {
					ayKcxxService.save(ayKcxx);
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
	public List<AyKcxxEntity> list() {
		List<AyKcxxEntity> listAyKcxxs=ayKcxxService.getList(AyKcxxEntity.class);
		return listAyKcxxs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyKcxxEntity task = ayKcxxService.get(AyKcxxEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyKcxxEntity ayKcxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKcxxEntity>> failures = validator.validate(ayKcxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKcxxService.save(ayKcxx);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayKcxx.getId();
		URI uri = uriBuilder.path("/rest/ayKcxxController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyKcxxEntity ayKcxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKcxxEntity>> failures = validator.validate(ayKcxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKcxxService.saveOrUpdate(ayKcxx);
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
		ayKcxxService.deleteEntityById(AyKcxxEntity.class, id);
	}
}
