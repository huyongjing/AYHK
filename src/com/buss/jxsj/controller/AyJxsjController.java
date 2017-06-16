package com.buss.jxsj.controller;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.jxsj.service.AyJxsjServiceI;
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
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
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
 * @Description: 绩效时间表
 * @author caozengling
 * @date 2017-03-23 11:19:39
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayJxsjController")
public class AyJxsjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyJxsjController.class);

	@Autowired
	private AyJxsjServiceI ayJxsjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 绩效时间表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/jxsj/ayJxsjList");
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
	public void datagrid(AyJxsjEntity ayJxsj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyJxsjEntity.class, dataGrid);
		//查询条件组装器
		boolean isSH = false;
		boolean isZX = false;
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayJxsj, request.getParameterMap());
		try{
			TSUser user = ResourceUtil.getSessionUserName();
			List<TSRoleUser> roleUserList = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			
			for (TSRoleUser tsRoleUser : roleUserList) {
				if("AY_ZX".equals(tsRoleUser.getTSRole().getRoleCode())){
					isZX = true;
				}
				if("AY_JJHSH".equals(tsRoleUser.getTSRole().getRoleCode())){
					isSH = true;
				}
			}
			//如果是审核人员
			if(isSH){
				cq.notEq("tjzt", "0");
			}
			//如果是中心人员
			if(isZX&&!isSH){
				List<TSUserOrg> userOrgList = systemService.findByProperty(TSUserOrg.class, "tsUser.id", user.getId());
				if(userOrgList!=null&&userOrgList.size()>0){
					TSUserOrg tuo = userOrgList.get(0);
					cq.eq("zxbm", tuo.getTsDepart().getOrgCode());
				}
			}
			//既不是审核，又不是中心
			if(!(isSH||isZX)){
				cq.isNull("id");
			}
			
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayJxsjService.getDataGridReturn(cq, true);
		
		List<AyJxsjEntity> ayJxsjEntityList = dataGrid.getResults();
		List<AyJxsjEntity> newDate = new ArrayList<AyJxsjEntity>();
		for (AyJxsjEntity ayJxsjEntity : ayJxsjEntityList) {
			if(isSH && "1".equals(ayJxsjEntity.getTjzt())){
				ayJxsjEntity.setCkqx("AY_JJHSH");
			}
			newDate.add(ayJxsjEntity);
		}
		dataGrid.setResults(newDate);
		
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除绩效时间表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyJxsjEntity ayJxsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayJxsj = systemService.getEntity(AyJxsjEntity.class, ayJxsj.getId());
		message = "绩效时间表删除成功";
		try{
			systemService.updateBySqlString("delete from AY_JX where sjpzid =" + "'"+ayJxsj.getId()+"'");//更新当月的提交状态
			ayJxsjService.delete(ayJxsj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效时间表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除绩效时间表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绩效时间表删除成功";
		try{
			for(String id:ids.split(",")){
				AyJxsjEntity ayJxsj = systemService.getEntity(AyJxsjEntity.class, 
				id
				);
				ayJxsjService.delete(ayJxsj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效时间表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加绩效时间表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyJxsjEntity ayJxsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资时间添加成功";
		try{
			List<AyJxsjEntity> aySjpzlist = systemService.findHql("from AyJxsjEntity where month =? and year =? and zxbm = ?",ayJxsj.getMonth(),ayJxsj.getYear(),ayJxsj.getZxbm());
			if(aySjpzlist!=null){
				if(aySjpzlist.size()>0){
					message = "本月绩效已存在";
				}else{
	                ayJxsj.setTjzt("0");
	                ayJxsj.setTjzt1("0");
	                ayJxsj.setTjzt2("0");
	                ayJxsj.setTjzt3("0");
	                ayJxsj.setTjzt4("0");
	                ayJxsj.setTjzt5("0");
	                ayJxsj.setTjzt6("0");
					ayJxsjService.save(ayJxsj);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}else{
				ayJxsj.setTjzt("0");
				ayJxsjService.save(ayJxsj);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
			message = "工资时间添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新绩效时间表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyJxsjEntity ayJxsj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绩效时间表更新成功";
		AyJxsjEntity t = ayJxsjService.get(AyJxsjEntity.class, ayJxsj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayJxsj, t);
			ayJxsjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "绩效时间表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 绩效时间表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyJxsjEntity ayJxsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayJxsj.getId())) {
			ayJxsj = ayJxsjService.getEntity(AyJxsjEntity.class, ayJxsj.getId());
			req.setAttribute("ayJxsjPage", ayJxsj);
		}
		TSUser user = ResourceUtil.getSessionUserName();
		List<TSUserOrg> userOrgList = this.systemService.findByProperty(TSUserOrg.class, "tsUser.id", user.getId());
		if(userOrgList!=null&&userOrgList.size()>0){
			TSUserOrg tuo = userOrgList.get(0);
			ayJxsj.setZxbm(tuo.getTsDepart().getOrgCode());
			req.setAttribute("defaultzxbm", tuo.getTsDepart().getOrgCode());
		}
		
		return new ModelAndView("com/buss/jxsj/ayJxsj-add");
	}
	/**
	 * 绩效时间表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyJxsjEntity ayJxsj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayJxsj.getId())) {
			ayJxsj = ayJxsjService.getEntity(AyJxsjEntity.class, ayJxsj.getId());
			req.setAttribute("ayJxsjPage", ayJxsj);
		}
		return new ModelAndView("com/buss/jxsj/ayJxsj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayJxsjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyJxsjEntity ayJxsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyJxsjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayJxsj, request.getParameterMap());
		List<AyJxsjEntity> ayJxsjs = this.ayJxsjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"绩效时间表");
		modelMap.put(NormalExcelConstants.CLASS,AyJxsjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("绩效时间表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayJxsjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyJxsjEntity ayJxsj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"绩效时间表");
    	modelMap.put(NormalExcelConstants.CLASS,AyJxsjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("绩效时间表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyJxsjEntity> listAyJxsjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyJxsjEntity.class,params);
				for (AyJxsjEntity ayJxsj : listAyJxsjEntitys) {
					ayJxsjService.save(ayJxsj);
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
