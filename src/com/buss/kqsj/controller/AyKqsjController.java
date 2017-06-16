package com.buss.kqsj.controller;

import com.buss.kqsj.entity.AyKqsjEntity;
import com.buss.kqsj.service.AyKqsjServiceI;
import com.buss.kqxx.entity.AyKqxxEntity;
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
 * @Description: 考勤时间配置
 * @author caozengling
 * @date 2017-03-20 15:12:39
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayKqsjController")
public class AyKqsjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyKqsjController.class);

	@Autowired
	private AyKqsjServiceI ayKqsjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 考勤时间配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/kqsj/ayKqsjList");
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
	public void datagrid(AyKqsjEntity ayKqsj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyKqsjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKqsj, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayKqsjService.getDataGridReturn(cq, true);
		/*List<AyKqsjEntity> sjpzs =dataGrid.getResults();
		List<Map<String,Object>> newdata = new ArrayList<Map<String,Object>>();
		for(AyKqsjEntity sjpz:sjpzs){
			Map<String,Object> map= new HashedMap();
			map.put("id",sjpz.getId());
			map.put("year",sjpz.getYear());
			map.put("month",sjpz.getMonth());
			map.put("tjzt",sjpz.getTjzt());
			List<AyZxpzEntity> xm= systemService.findHql("from AyZxpzEntity where zxbm=?",sjpz.getZxbm());
			if(xm.size()>0){
				map.put("zxbm",xm.get(0).getZx());
			}
			newdata.add(map);
		}
		dataGrid.setResults(newdata);*/
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考勤时间配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyKqsjEntity ayKqsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayKqsj = systemService.getEntity(AyKqsjEntity.class, ayKqsj.getId());
		message = "考勤时间配置删除成功";
		try{
			List<AyKqxxEntity> xm= systemService.findHql("from AyKqxxEntity where sjpzid=?",ayKqsj.getId());
			for (AyKqxxEntity ayKqxxEntity : xm) {
				systemService.delete(ayKqxxEntity);
			}
			ayKqsjService.delete(ayKqsj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤时间配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考勤时间配置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤时间配置删除成功";
		try{
			for(String id:ids.split(",")){
				AyKqsjEntity ayKqsj = systemService.getEntity(AyKqsjEntity.class, 
				id
				);
				ayKqsjService.delete(ayKqsj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤时间配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考勤时间配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyKqsjEntity ayKqsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤时间配置添加成功";
		try{
			List<AyKqsjEntity> aySjpzlist = systemService.findHql("from AyKqsjEntity where month =? and year =? and zxbm = ?",ayKqsj.getMonth(),ayKqsj.getYear(),ayKqsj.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "考勤新增失败，已存在本月考勤";
				}else{
	                ayKqsj.setTjzt("0");
	                if(StringUtil.isEmpty(ayKqsj.getDyycq())){
	                	ayKqsj.setDyycq("0");
	                }
	                if(StringUtil.isEmpty(ayKqsj.getFdj())){
	                	ayKqsj.setFdj("0");
	                }
	                if(StringUtil.isEmpty(ayKqsj.getCf())){
	                	ayKqsj.setCf("0");
	                }
	                if(StringUtil.isEmpty(ayKqsj.getJt())){
	                	ayKqsj.setJt("0");
	                }
					ayKqsjService.save(ayKqsj);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}else{
				ayKqsj.setTjzt("0");
				ayKqsjService.save(ayKqsj);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}

		}catch(Exception e){
			e.printStackTrace();
			message = "考勤时间配置添加失败";
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
	public AjaxJson doTijiao(AyKqsjEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_KQSJ set tjzt = 2 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
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
	public AjaxJson doBohui(AyKqsjEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驳回成功";
		try{
			systemService.updateBySqlString("update AY_KQSJ set tjzt = 0 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
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
	 * 更新考勤时间配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyKqsjEntity ayKqsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "考勤时间配置更新成功";
		AyKqsjEntity t = ayKqsjService.get(AyKqsjEntity.class, ayKqsj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayKqsj, t);
			ayKqsjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考勤时间配置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考勤时间配置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyKqsjEntity ayKqsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKqsj.getId())) {
			ayKqsj = ayKqsjService.getEntity(AyKqsjEntity.class, ayKqsj.getId());
			req.setAttribute("ayKqsjPage", ayKqsj);
		}
		return new ModelAndView("com/buss/kqsj/ayKqsj-add");
	}
	/**
	 * 考勤时间配置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyKqsjEntity ayKqsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayKqsj.getId())) {
			ayKqsj = ayKqsjService.getEntity(AyKqsjEntity.class, ayKqsj.getId());
			req.setAttribute("ayKqsjPage", ayKqsj);
		}
		return new ModelAndView("com/buss/kqsj/ayKqsj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayKqsjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyKqsjEntity ayKqsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyKqsjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKqsj, request.getParameterMap());
		List<AyKqsjEntity> ayKqsjs = this.ayKqsjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"考勤时间配置");
		modelMap.put(NormalExcelConstants.CLASS,AyKqsjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考勤时间配置列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayKqsjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyKqsjEntity ayKqsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"考勤时间配置");
    	modelMap.put(NormalExcelConstants.CLASS,AyKqsjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考勤时间配置列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyKqsjEntity> listAyKqsjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyKqsjEntity.class,params);
				for (AyKqsjEntity ayKqsj : listAyKqsjEntitys) {
					ayKqsjService.save(ayKqsj);
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
	public List<AyKqsjEntity> list() {
		List<AyKqsjEntity> listAyKqsjs=ayKqsjService.getList(AyKqsjEntity.class);
		return listAyKqsjs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyKqsjEntity task = ayKqsjService.get(AyKqsjEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyKqsjEntity ayKqsj, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKqsjEntity>> failures = validator.validate(ayKqsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKqsjService.save(ayKqsj);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayKqsj.getId();
		URI uri = uriBuilder.path("/rest/ayKqsjController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyKqsjEntity ayKqsj) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyKqsjEntity>> failures = validator.validate(ayKqsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayKqsjService.saveOrUpdate(ayKqsj);
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
		ayKqsjService.deleteEntityById(AyKqsjEntity.class, id);
	}
}
