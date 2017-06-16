package com.buss.lwgzsj.controller;
import com.buss.lwgz.entity.AyLwgzEntity;
import com.buss.lwgzsj.entity.AyLwgzsjEntity;
import com.buss.lwgzsj.service.AyLwgzsjServiceI;
import com.buss.shgjj.entity.AyShgjjEntity;

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
 * @Description: 劳务工资时间
 * @author caozengling
 * @date 2017-03-23 15:12:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayLwgzsjController")
public class AyLwgzsjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyLwgzsjController.class);

	@Autowired
	private AyLwgzsjServiceI ayLwgzsjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 劳务工资时间列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/lwgzsj/ayLwgzsjList");
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
	public void datagrid(AyLwgzsjEntity ayLwgzsj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyLwgzsjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayLwgzsj, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayLwgzsjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除劳务工资时间
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyLwgzsjEntity ayLwgzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayLwgzsj = systemService.getEntity(AyLwgzsjEntity.class, ayLwgzsj.getId());
		message = "劳务工资时间删除成功";
		try{
			List<AyLwgzEntity> ayLwgzEntitylist = systemService.findHql("from AyLwgzEntity where sjpzid=?",ayLwgzsj.getId());
			if(ayLwgzEntitylist!=null){
				for (AyLwgzEntity ayLwgzEntity : ayLwgzEntitylist) {
					systemService.delete(ayLwgzEntity);
				}
			}
			ayLwgzsjService.delete(ayLwgzsj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资时间删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除劳务工资时间
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资时间删除成功";
		try{
			for(String id:ids.split(",")){
				AyLwgzsjEntity ayLwgzsj = systemService.getEntity(AyLwgzsjEntity.class, 
				id
				);
				ayLwgzsjService.delete(ayLwgzsj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资时间删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加劳务工资时间
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyLwgzsjEntity ayLwgzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资时间添加成功";
		try{
			List<AyLwgzsjEntity> aySjpzlist = systemService.findHql("from AyLwgzsjEntity where month =? and year =? and zxbm = ?",ayLwgzsj.getMonth(),ayLwgzsj.getYear(),ayLwgzsj.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "本月劳务工资已存在";
				}else{
	                ayLwgzsj.setTjzt("0");
					ayLwgzsjService.save(ayLwgzsj);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}else{
				ayLwgzsj.setTjzt("0");
				ayLwgzsjService.save(ayLwgzsj);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "劳务工资时间添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新劳务工资时间
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyLwgzsjEntity ayLwgzsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "劳务工资时间更新成功";
		AyLwgzsjEntity t = ayLwgzsjService.get(AyLwgzsjEntity.class, ayLwgzsj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayLwgzsj, t);
			ayLwgzsjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "劳务工资时间更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 劳务工资时间新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyLwgzsjEntity ayLwgzsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayLwgzsj.getId())) {
			ayLwgzsj = ayLwgzsjService.getEntity(AyLwgzsjEntity.class, ayLwgzsj.getId());
			req.setAttribute("ayLwgzsjPage", ayLwgzsj);
		}
		return new ModelAndView("com/buss/lwgzsj/ayLwgzsj-add");
	}
	/**
	 * 劳务工资时间编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyLwgzsjEntity ayLwgzsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayLwgzsj.getId())) {
			ayLwgzsj = ayLwgzsjService.getEntity(AyLwgzsjEntity.class, ayLwgzsj.getId());
			req.setAttribute("ayLwgzsjPage", ayLwgzsj);
		}
		return new ModelAndView("com/buss/lwgzsj/ayLwgzsj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayLwgzsjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyLwgzsjEntity ayLwgzsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyLwgzsjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayLwgzsj, request.getParameterMap());
		List<AyLwgzsjEntity> ayLwgzsjs = this.ayLwgzsjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"劳务工资时间");
		modelMap.put(NormalExcelConstants.CLASS,AyLwgzsjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("劳务工资时间列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayLwgzsjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyLwgzsjEntity ayLwgzsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"劳务工资时间");
    	modelMap.put(NormalExcelConstants.CLASS,AyLwgzsjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("劳务工资时间列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyLwgzsjEntity> listAyLwgzsjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyLwgzsjEntity.class,params);
				for (AyLwgzsjEntity ayLwgzsj : listAyLwgzsjEntitys) {
					ayLwgzsjService.save(ayLwgzsj);
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

}
