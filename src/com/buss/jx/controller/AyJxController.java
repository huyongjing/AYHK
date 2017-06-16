package com.buss.jx.controller;

import com.buss.gzsj.entity.AyGzsjEntity;
import com.buss.jx.entity.AyJxEntity;
import com.buss.jx.entity.AyJxEntityPage;
import com.buss.jx.service.AyJxServiceI;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.kcxx.entity.AyKcxxEntity;
import com.buss.sjpz.entity.AySjpzEntity;
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
 * @Description: 绩效表
 * @author caozengling
 * @date 2017-03-23 11:19:25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayJxController")
public class AyJxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyJxController.class);

	@Autowired
	private AyJxServiceI ayJxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 绩效表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		
		
		AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
		if("0".equals(ayJxsjEntity.getTjzt2())){
			List<AyJxEntity> ayJxEntityList1=systemService.findHql("FROM AyJxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
			for (AyJxEntity ayJxEntity : ayJxEntityList1) {
				systemService.delete(ayJxEntity);
			}
		}
		
		List<AyJxEntity> ayJxEntityList=systemService.findHql("FROM AyJxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
		
		if(ayJxEntityList.size()==0){
			List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where 1=1 and zxbm=? and yglx <>? and yglx <> ? and zzzt = ?",zxid,"劳务员工","劳务实习","在职");
			for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
				AyJxEntity ayJxEntity = new AyJxEntity();
				ayJxEntity.setXm(aYgjbxxlists.getXm());
				ayJxEntity.setSjpzid(sjpzid);
				ayJxEntity.setYgxxid(aYgjbxxlists.getId());
				ayJxEntity.setZxbm(zxid);
				
				
				float kszs_f = 0;
				
				//查询该月份课程信息
				//先查对应月份的时间ID，再根据ID，用户，计算出 课时总数
//				List<AySjpzEntity> aySjpzEntitylist=systemService.findHql("from AySjpzEntity where 1=1 and zxbm=? and year=? and month =?",zxid,ayJxsjEntity.getYear(),ayJxsjEntity.getMonth());
				List<AyJxsjEntity> aySjpzEntitylist=systemService.findHql("from AyJxsjEntity where 1=1 and zxbm=? and year=? and month =?",zxid,ayJxsjEntity.getYear(),ayJxsjEntity.getMonth());
				if(aySjpzEntitylist!=null){
					if(aySjpzEntitylist.size()==1){
						AyJxsjEntity aySjpzEntity = aySjpzEntitylist.get(0);
						List<AyKcxxEntity> ayKcxxEntityList=systemService.findHql("from AyKcxxEntity where 1=1 and zxbm=? and sjpzid=? and ygxxid =?",aySjpzEntity.getZxbm(),aySjpzEntity.getId(),aYgjbxxlists.getId());
						for (AyKcxxEntity ayKcxxEntity : ayKcxxEntityList) {
							String kchj_s = ayKcxxEntity.getKchj();
							if(StringUtil.isEmpty(kchj_s)){
								kchj_s = "0";
							}
							float kchj = Float.parseFloat(kchj_s);
							kszs_f = kszs_f + kchj;
						}
						ayJxEntity.setKszs(String.valueOf(kszs_f));
					}
				}
				
				//设置达标课时数
				String dbdss = ayJxsjEntity.getDbkss();
				if(StringUtil.isEmpty(dbdss)){
					dbdss = "0";
				}
				ayJxEntity.setDbkss(dbdss);
				//设置第一档课时费
				String ksf1 = ayJxsjEntity.getKsf();
				if(StringUtil.isEmpty(ksf1)){
					ksf1 = "0";
				}
				ayJxEntity.setKsf(ksf1);
				//设置第二档课时费
				String ksf2 = ayJxsjEntity.getKsf2();
				if(StringUtil.isEmpty(ksf2)){
					ksf2 = "0";
				}
				ayJxEntity.setKsf2(ksf2);
				//设置第三档课时费
				String ksf3 = ayJxsjEntity.getKsf3();
				if(StringUtil.isEmpty(ksf3)){
					ksf3 = "0";
				}
				ayJxEntity.setKsf3(ksf3);
				
				//设置达标奖金 
				ayJxEntity.setDbjj("0");
				
				//设置超出课时数 = 课时总数>=达标课时数?(课时总数 -达标课时数 ):0
				float cckss_f = 0;
				if(kszs_f>=Float.parseFloat(dbdss)){
					float cckss_f_2 = kszs_f - Float.parseFloat(dbdss);
					cckss_f = (float)(Math.round(cckss_f_2*100))/100;
					//如果课时总数>=达标课时数，设置达标奖金
					ayJxEntity.setDbjj(ayJxsjEntity.getDbjj());
				}
				ayJxEntity.setCckss(String.valueOf(cckss_f));
				
				//设置第一档课时数 = 超出课时数>10？10：超出课时数
				float kss1 =  cckss_f > 10 ? 10:cckss_f;
				ayJxEntity.setDydkss(String.valueOf(kss1));
				//设置第一档课时奖金 = 第一档课时数 * 第一档课时费
				float ksjj1 = Float.parseFloat(ksf1) * kss1;
				ayJxEntity.setKsjj(String.valueOf(ksjj1));
				
				//设置第二档课时数
				float k_temp = cckss_f - kss1;
				float kss2 =  k_temp >= 10 ? 10:k_temp;
				ayJxEntity.setDedkss2(String.valueOf(kss2));
				//设置第二档课时奖金 = 第二档课时数 * 第二档课时费
				float ksjj2 = Float.parseFloat(ksf2) * kss2;
				ayJxEntity.setKsjj2(String.valueOf(ksjj2));
				
				//设置第三档课时数 = 超出课时数 - 第一档课时数 - 第二档课时数
				float kss3 = cckss_f - kss1 - kss2;
				ayJxEntity.setDsdkss3(String.valueOf(kss3));
				//设置第三档课时奖金 = 第三档课时数 * 第三档课时费
				float ksjj3 = Float.parseFloat(ksf3) * kss3;
				ayJxEntity.setKsjj3(String.valueOf(ksjj3));
				
				//设置课时费合计 = 第一档课时奖金 + 第二档课时奖金 + 第三档课时奖金
				float ksfhj = ksjj1 + ksjj2 + ksjj3;
				ayJxEntity.setKsfhj(String.valueOf(ksfhj));
				
				systemService.save(ayJxEntity);
				
				
			}
			
		}
		systemService.updateBySqlString("update AY_JXSJ set tjzt2 = 2 where id=" + "'"+sjpzid+"'");//更新当月的提交状态
		return new ModelAndView("com/buss/jx/ayJxList");
	}
	
	
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		request.setAttribute("zxid",zxid);
		//查看考勤表 是否存在 本月  本中心 重复数据
		return new ModelAndView("com/buss/jx/ayJxListChakan");
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
	public void datagrid(AyJxEntity ayJx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AyJxEntity.class, dataGrid);
		String sjpzid = request.getParameter("sjpzid");
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayJx, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(!StringUtil.isEmpty(sjpzid)){
				cq.eq("sjpzid", sjpzid);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayJxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除绩效表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayJx = systemService.getEntity(AyJxEntity.class, ayJx.getId());
		message = "绩效表删除成功";
		try{
			ayJxService.delete(ayJx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除绩效表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绩效表删除成功";
		try{
			for(String id:ids.split(",")){
				AyJxEntity ayJx = systemService.getEntity(AyJxEntity.class, 
				id
				);
				ayJxService.delete(ayJx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加绩效表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绩效表添加成功";
		try{
			ayJxService.save(ayJx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效表添加失败";
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
	public AjaxJson saveRows(AyJxEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyJxEntity> ayJxEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayJxEntity)){
			for(AyJxEntity ayJxEntitys:ayJxEntity){
				if (StringUtil.isNotEmpty(ayJxEntitys.getId())) {
					AyJxEntity t =systemService.get(AyJxEntity.class, ayJxEntitys.getId());
					try {
						message = "提交成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayJxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "提交成功";
					systemService.save(ayJxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt2 = 1 where id=" + "'"+ayJxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;
	}
	
	
	@RequestMapping(params = "submitRows")
	@ResponseBody
	public AjaxJson submitRows(AyJxEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyJxEntity> ayJxEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayJxEntity)){
			for(AyJxEntity ayJxEntitys:ayJxEntity){
				if (StringUtil.isNotEmpty(ayJxEntitys.getId())) {
					AyJxEntity t =systemService.get(AyJxEntity.class, ayJxEntitys.getId());
					try {
						message = "提交成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayJxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "提交成功";
					systemService.save(ayJxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt2 = 2 where id=" + "'"+ayJxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
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
	public AjaxJson doTijiao(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, ayJx.getId());
			if("0".equals(ayJxsjEntity.getTjzt1())){
				message = "课程尚未保存";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt2())){
				message = "请先查看绩效";	
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt3())){
				message = "考勤尚未保存";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt4())){
				message = "请先查看社保公积金";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt5())){
				message = "请先查看劳务工资";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt6())){
				message = "请先保存工资";
				j.setMsg(message);
				return j;
			}
			
			systemService.updateBySqlString("update AY_JXSJ set tjzt = 1 where id=" + "'"+ayJx.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "绩效提交失败";
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
	public AjaxJson doBohui(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_JXSJ set tjzt = 0,tjzt1 = 1,tjzt2 = 1,tjzt3 = 1,tjzt4 = 1,tjzt5 = 1,tjzt6 = 1 where id=" + "'"+ayJx.getId()+"'");//更新当月的提交状态
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
	public AjaxJson doAgree(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			systemService.updateBySqlString("update AY_JXSJ set tjzt = 2,tjzt1 = 2,tjzt2 = 2,tjzt3 = 2,tjzt4 = 2,tjzt5 = 2,tjzt6 = 2 where id=" + "'"+ayJx.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资通过失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	@RequestMapping(params = "doCheck")
	@ResponseBody
	public AjaxJson doCheck(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		try{
			AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, ayJx.getId());
			if("0".equals(ayJxsjEntity.getTjzt1())){
				message = "请先保存课程信息";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt2())){
				message = "请先查看绩效信息";	
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt3())){
				message = "请先保存考勤信息";
				j.setMsg(message);
				return j;
			}
			if("0".equals(ayJxsjEntity.getTjzt4())){
				message = "请先查看社保公积金信息";
				j.setMsg(message);
				return j;
			}
			message = "cantijiao";
			
		}catch(Exception e){
			e.printStackTrace();
			message = "前提条件检查失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	/**
	 * 更新绩效表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyJxEntity ayJx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绩效表更新成功";
		AyJxEntity t = ayJxService.get(AyJxEntity.class, ayJx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayJx, t);
			ayJxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "绩效表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 绩效表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyJxEntity ayJx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayJx.getId())) {
			ayJx = ayJxService.getEntity(AyJxEntity.class, ayJx.getId());
			req.setAttribute("ayJxPage", ayJx);
		}
		return new ModelAndView("com/buss/jx/ayJx-add");
	}
	/**
	 * 绩效表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyJxEntity ayJx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayJx.getId())) {
			ayJx = ayJxService.getEntity(AyJxEntity.class, ayJx.getId());
			req.setAttribute("ayJxPage", ayJx);
		}
		return new ModelAndView("com/buss/jx/ayJx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayJxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyJxEntity ayJx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyJxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayJx, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyJxEntity> ayJxs = this.ayJxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"绩效表");
		modelMap.put(NormalExcelConstants.CLASS,AyJxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("绩效表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayJxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyJxEntity ayJx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"绩效表");
    	modelMap.put(NormalExcelConstants.CLASS,AyJxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("绩效表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyJxEntity> listAyJxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyJxEntity.class,params);
				for (AyJxEntity ayJx : listAyJxEntitys) {
					ayJxService.save(ayJx);
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
