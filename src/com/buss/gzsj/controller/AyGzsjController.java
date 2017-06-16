package com.buss.gzsj.controller;
import com.buss.gz.entity.AyGzEntity;
import com.buss.gzsj.entity.AyGzsjEntity;
import com.buss.gzsj.service.AyGzsjServiceI;
import com.buss.kqxx.entity.AyKqxxEntity;
import com.buss.sjpz.entity.AySjpzEntity;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: 工资时间表
 * @author caozengling
 * @date 2017-03-23 14:56:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayGzsjController")
public class AyGzsjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyGzsjController.class);

	@Autowired
	private AyGzsjServiceI ayGzsjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 工资时间表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/gzsj/ayGzsjList");
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
	public void datagrid(AyGzsjEntity ayGzsj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyGzsjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGzsj, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayGzsjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工资时间表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyGzsjEntity ayGzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayGzsj = systemService.getEntity(AyGzsjEntity.class, ayGzsj.getId());
		message = "工资时间表删除成功";
		try{
			List<AyGzEntity> gz= systemService.findHql("from AyGzEntity where sjpzid=?",ayGzsj.getId());
			for (AyGzEntity ayGzEntity : gz) {
				systemService.delete(ayGzEntity);
			}
			ayGzsjService.delete(ayGzsj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资时间表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除工资时间表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资时间表删除成功";
		try{
			for(String id:ids.split(",")){
				AyGzsjEntity ayGzsj = systemService.getEntity(AyGzsjEntity.class, 
				id
				);
				ayGzsjService.delete(ayGzsj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "工资时间表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		System.out.println(j.toString());
		return j;
	}


	/**
	 * 添加工资时间表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyGzsjEntity ayGzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资时间表添加成功";
		try{
			List<AyGzsjEntity> aySjpzlist = systemService.findHql("from AyGzsjEntity where month =? and year =? and zxbm = ?",ayGzsj.getMonth(),ayGzsj.getYear(),ayGzsj.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "本月工资已存在";
				}else{
	                ayGzsj.setTjzt("0");
					ayGzsjService.save(ayGzsj);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
				
			}else{
				ayGzsj.setTjzt("0");
				ayGzsjService.save(ayGzsj);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			message = "工资时间表添加失败";
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
	public AjaxJson doBohui(AyGzsjEntity ayGzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_GZSJ set tjzt = 0 where id=" + "'"+ayGzsj.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资驳回失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 通过
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAgree")
	@ResponseBody
	public AjaxJson doAgree(AyGzsjEntity ayGzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_GZSJ set tjzt =3 where id=" + "'"+ayGzsj.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资通过失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 更新工资时间表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyGzsjEntity ayGzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资时间表更新成功";
		AyGzsjEntity t = ayGzsjService.get(AyGzsjEntity.class, ayGzsj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayGzsj, t);
			ayGzsjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "工资时间表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 工资时间表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyGzsjEntity ayGzsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGzsj.getId())) {
			ayGzsj = ayGzsjService.getEntity(AyGzsjEntity.class, ayGzsj.getId());
			req.setAttribute("ayGzsjPage", ayGzsj);
		}
		return new ModelAndView("com/buss/gzsj/ayGzsj-add");
	}
	/**
	 * 工资时间表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyGzsjEntity ayGzsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGzsj.getId())) {
			ayGzsj = ayGzsjService.getEntity(AyGzsjEntity.class, ayGzsj.getId());
			req.setAttribute("ayGzsjPage", ayGzsj);
		}
		return new ModelAndView("com/buss/gzsj/ayGzsj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayGzsjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyGzsjEntity ayGzsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyGzsjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGzsj, request.getParameterMap());
		List<AyGzsjEntity> ayGzsjs = this.ayGzsjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"工资时间表");
		modelMap.put(NormalExcelConstants.CLASS,AyGzsjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("工资时间表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayGzsjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyGzsjEntity ayGzsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"工资时间表");
    	modelMap.put(NormalExcelConstants.CLASS,AyGzsjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("工资时间表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyGzsjEntity> listAyGzsjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyGzsjEntity.class,params);
				for (AyGzsjEntity ayGzsj : listAyGzsjEntitys) {
					ayGzsjService.save(ayGzsj);
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
	public List<AyGzsjEntity> list() {
		List<AyGzsjEntity> listAyGzsjs=ayGzsjService.getList(AyGzsjEntity.class);
		return listAyGzsjs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyGzsjEntity task = ayGzsjService.get(AyGzsjEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyGzsjEntity ayGzsj, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGzsjEntity>> failures = validator.validate(ayGzsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGzsjService.save(ayGzsj);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayGzsj.getId();
		URI uri = uriBuilder.path("/rest/ayGzsjController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyGzsjEntity ayGzsj) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGzsjEntity>> failures = validator.validate(ayGzsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGzsjService.saveOrUpdate(ayGzsj);
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
		ayGzsjService.deleteEntityById(AyGzsjEntity.class, id);
	}
}
