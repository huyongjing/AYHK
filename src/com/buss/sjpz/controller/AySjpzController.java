package com.buss.sjpz.controller;

import com.buss.kcxx.entity.AyKcxxEntity;
import com.buss.sjpz.entity.AySjpzEntity;
import com.buss.sjpz.service.AySjpzServiceI;
import com.buss.zxpz.entity.AyZxpzEntity;

import org.apache.commons.collections.map.HashedMap;
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
 * @Description: 课程信息的时间配置表
 * @author caozengling
 * @date 2017-03-09 14:39:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/aySjpzController")
public class AySjpzController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AySjpzController.class);

	@Autowired
	private AySjpzServiceI aySjpzService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 时间配置表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/sjpz/aySjpzList");
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
	public void datagrid(AySjpzEntity aySjpz,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AySjpzEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aySjpz, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.aySjpzService.getDataGridReturn(cq, true);
		List<AySjpzEntity> sjpzs =dataGrid.getResults();
		List<Map<String,Object>> newdata = new ArrayList<Map<String,Object>>();
		for(AySjpzEntity sjpz:sjpzs){
			Map<String,Object> map= new HashedMap();
			map.put("id",sjpz.getId());
			map.put("year",sjpz.getYear());
			map.put("month",sjpz.getMonth());
			map.put("tjzt",sjpz.getTjzt());
			map.put("zx",sjpz.getZxbm());
			/*List<AyZxpzEntity> xm= systemService.findHql("from AyZxpzEntity where zxbm=?",sjpz.getZxbm());
			if(xm.size()>0){
				map.put("zx",xm.get(0).getZx());
			}*/
			newdata.add(map);
		}
	/*	Collections.sort(newdata, new Comparator<AySjpzEntity>() {
			@Override
			public int compare(AySjpzEntity user1, AySjpzEntity user2) {
				int zsr1 = user1.getMonth() ? 0:Integer.parseInt(user1.getMonth());
				int zsr2 = user2.getMonth() ? 0:Integer.parseInt(user2.getMonth());
				return zsr1>zsr2?1:-1;
			}

		});*/
		dataGrid.setResults(newdata);

		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除时间配置表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		aySjpz = systemService.getEntity(AySjpzEntity.class, aySjpz.getId());
		message = "时间配置表删除成功";
		try{
			
			List<AyKcxxEntity> kc= systemService.findHql("from AyKcxxEntity where sjpzid=?",aySjpz.getId());
			for (AyKcxxEntity ayKcxxEntity : kc) {
				systemService.delete(ayKcxxEntity);
			}
			
			aySjpzService.delete(aySjpz);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除时间配置表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "时间配置表删除成功";
		try{
			for(String id:ids.split(",")){
				AySjpzEntity aySjpz = systemService.getEntity(AySjpzEntity.class, 
				id
				);
				aySjpzService.delete(aySjpz);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加时间配置表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "时间配置表添加成功";
		try{
			
			List<AySjpzEntity> aySjpzlist = systemService.findHql("from AySjpzEntity where month =? and year =? and zxbm = ?",aySjpz.getMonth(),aySjpz.getYear(),aySjpz.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "新增课程失败，本月课程已存在";
				}else{
					aySjpz.setTjzt("0");//未提交的状态
					aySjpzService.save(aySjpz);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}else{
				aySjpz.setTjzt("0");//未提交的状态
				aySjpzService.save(aySjpz);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加提交
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doTijiao")
	@ResponseBody
	public AjaxJson doTijiao(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_SJPZ set tjzt = 2 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 驳回
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBohui")
	@ResponseBody
	public AjaxJson doBohui(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_SJPZ set tjzt = 0 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 驳回
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAgree")
	@ResponseBody
	public AjaxJson doAgree(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_SJPZ set tjzt =3 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "时间配置表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新时间配置表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AySjpzEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "时间配置表更新成功";
		AySjpzEntity t = aySjpzService.get(AySjpzEntity.class, aySjpz.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(aySjpz, t);
			aySjpzService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "时间配置表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 时间配置表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AySjpzEntity aySjpz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aySjpz.getId())) {
			aySjpz = aySjpzService.getEntity(AySjpzEntity.class, aySjpz.getId());
			req.setAttribute("aySjpzPage", aySjpz);
		}
		return new ModelAndView("com/buss/sjpz/aySjpz-add");
	}
	/**
	 * 时间配置表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AySjpzEntity aySjpz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aySjpz.getId())) {
			aySjpz = aySjpzService.getEntity(AySjpzEntity.class, aySjpz.getId());
			req.setAttribute("aySjpzPage", aySjpz);
		}
		return new ModelAndView("com/buss/sjpz/aySjpz-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","aySjpzController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AySjpzEntity aySjpz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AySjpzEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aySjpz, request.getParameterMap());
		List<AySjpzEntity> aySjpzs = this.aySjpzService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"时间配置表");
		modelMap.put(NormalExcelConstants.CLASS,AySjpzEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("时间配置表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,aySjpzs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AySjpzEntity aySjpz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"时间配置表");
    	modelMap.put(NormalExcelConstants.CLASS,AySjpzEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("时间配置表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AySjpzEntity> listAySjpzEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AySjpzEntity.class,params);
				for (AySjpzEntity aySjpz : listAySjpzEntitys) {
					aySjpzService.save(aySjpz);
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
	public List<AySjpzEntity> list() {
		List<AySjpzEntity> listAySjpzs=aySjpzService.getList(AySjpzEntity.class);
		return listAySjpzs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AySjpzEntity task = aySjpzService.get(AySjpzEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AySjpzEntity aySjpz, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AySjpzEntity>> failures = validator.validate(aySjpz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			aySjpzService.save(aySjpz);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = aySjpz.getId();
		URI uri = uriBuilder.path("/rest/aySjpzController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AySjpzEntity aySjpz) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AySjpzEntity>> failures = validator.validate(aySjpz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			aySjpzService.saveOrUpdate(aySjpz);
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
		aySjpzService.deleteEntityById(AySjpzEntity.class, id);
	}
}
