package com.buss.gjjsj.controller;

import com.buss.gjjsj.entity.AyGjjsjEntity;
import com.buss.gjjsj.service.AyGjjsjServiceI;
import com.buss.shgjj.entity.AyShgjjEntity;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 社会公积金时间
 * @author caozengling
 * @date 2017-03-20 16:04:30
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayGjjsjController")
public class AyGjjsjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyGjjsjController.class);

	@Autowired
	private AyGjjsjServiceI ayGjjsjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 社会公积金时间列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/gjjsj/ayGjjsjList");
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
	public void datagrid(AyGjjsjEntity ayGjjsj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyGjjsjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGjjsj, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayGjjsjService.getDataGridReturn(cq, true);
		/*List<AyGjjsjEntity> sjpzs =dataGrid.getResults();
		List<Map<String,Object>> newdata = new ArrayList<Map<String,Object>>();
		for(AyGjjsjEntity sjpz:sjpzs){
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
	 * 删除社会公积金时间
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyGjjsjEntity ayGjjsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayGjjsj = systemService.getEntity(AyGjjsjEntity.class, ayGjjsj.getId());
		message = "社会公积金时间删除成功";
		try{
			List<AyShgjjEntity> ayShgjjEntitylist = systemService.findHql("from AyShgjjEntity where sjpzid=?",ayGjjsj.getId());
			if(ayShgjjEntitylist!=null){
				for (AyShgjjEntity ayShgjjEntity : ayShgjjEntitylist) {
					systemService.delete(ayShgjjEntity);
				}
			}
			ayGjjsjService.delete(ayGjjsj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金时间删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除社会公积金时间
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金时间删除成功";
		try{
			for(String id:ids.split(",")){
				AyGjjsjEntity ayGjjsj = systemService.getEntity(AyGjjsjEntity.class, 
				id
				);
				ayGjjsjService.delete(ayGjjsj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金时间删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加社会公积金时间
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyGjjsjEntity ayGjjsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金时间添加成功";
		try{
			List<AyGjjsjEntity> aySjpzlist = systemService.findHql("from AyGjjsjEntity where month =? and year =? and zxbm = ?",ayGjjsj.getMonth(),ayGjjsj.getYear(),ayGjjsj.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "本月已存在";
				}else{
					ayGjjsj.setTjzt("0");
					ayGjjsjService.save(ayGjjsj);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}else{
				ayGjjsj.setTjzt("0");
				ayGjjsjService.save(ayGjjsj);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金时间添加失败";
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
	public AjaxJson doTijiao(AyGjjsjEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_GJJSJ set tjzt = 2 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
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
	 * 添加提交
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBohui")
	@ResponseBody
	public AjaxJson doBohui(AyGjjsjEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_GJJSJ set tjzt = 0 where id=" + "'"+aySjpz.getId()+"'");//更新当月的提交状态
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
	 * 更新社会公积金时间
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyGjjsjEntity ayGjjsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金时间更新成功";
		AyGjjsjEntity t = ayGjjsjService.get(AyGjjsjEntity.class, ayGjjsj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayGjjsj, t);
			ayGjjsjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "社会公积金时间更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 社会公积金时间新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyGjjsjEntity ayGjjsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGjjsj.getId())) {
			ayGjjsj = ayGjjsjService.getEntity(AyGjjsjEntity.class, ayGjjsj.getId());
			req.setAttribute("ayGjjsjPage", ayGjjsj);
		}
		return new ModelAndView("com/buss/gjjsj/ayGjjsj-add");
	}
	/**
	 * 社会公积金时间编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyGjjsjEntity ayGjjsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGjjsj.getId())) {
			ayGjjsj = ayGjjsjService.getEntity(AyGjjsjEntity.class, ayGjjsj.getId());
			Date date = ayGjjsj.getUpdateDate();
			Date date1 = ayGjjsj.getCreateDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			String time1 = sdf.format(date1);
			try {
				Date newDate = sdf.parse(time);
				Date newDate1 = sdf.parse(time1);
				ayGjjsj.setCreateDate(newDate1);
				ayGjjsj.setUpdateDate(newDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("ayGjjsjPage", ayGjjsj);
		}
		return new ModelAndView("com/buss/gjjsj/ayGjjsj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayGjjsjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyGjjsjEntity ayGjjsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyGjjsjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGjjsj, request.getParameterMap());
		List<AyGjjsjEntity> ayGjjsjs = this.ayGjjsjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"社会公积金时间");
		modelMap.put(NormalExcelConstants.CLASS,AyGjjsjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社会公积金时间列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayGjjsjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyGjjsjEntity ayGjjsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"社会公积金时间");
    	modelMap.put(NormalExcelConstants.CLASS,AyGjjsjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社会公积金时间列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyGjjsjEntity> listAyGjjsjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyGjjsjEntity.class,params);
				for (AyGjjsjEntity ayGjjsj : listAyGjjsjEntitys) {
					ayGjjsjService.save(ayGjjsj);
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
	public List<AyGjjsjEntity> list() {
		List<AyGjjsjEntity> listAyGjjsjs=ayGjjsjService.getList(AyGjjsjEntity.class);
		return listAyGjjsjs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyGjjsjEntity task = ayGjjsjService.get(AyGjjsjEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyGjjsjEntity ayGjjsj, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGjjsjEntity>> failures = validator.validate(ayGjjsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGjjsjService.save(ayGjjsj);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayGjjsj.getId();
		URI uri = uriBuilder.path("/rest/ayGjjsjController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyGjjsjEntity ayGjjsj) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGjjsjEntity>> failures = validator.validate(ayGjjsj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGjjsjService.saveOrUpdate(ayGjjsj);
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
		ayGjjsjService.deleteEntityById(AyGjjsjEntity.class, id);
	}
}
