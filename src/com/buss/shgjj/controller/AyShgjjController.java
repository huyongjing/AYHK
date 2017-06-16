package com.buss.shgjj.controller;

import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.shgjj.entity.AyShgjjEntity;
import com.buss.shgjj.entity.AyShgjjEntityPage;
import com.buss.shgjj.service.AyShgjjServiceI;
import com.buss.tbxs.entity.AyTbxsEntity;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 社会公积金
 * @author caozengling
 * @date 2017-03-20 17:54:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayShgjjController")
public class AyShgjjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyShgjjController.class);

	@Autowired
	private AyShgjjServiceI ayShgjjService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 社会公积金列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
		if("0".equals(ayJxsjEntity.getTjzt4())){
			List<AyShgjjEntity> ayShgjjEntityist1=systemService.findHql("FROM AyShgjjEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
			for (AyShgjjEntity ayShgjjEntity : ayShgjjEntityist1) {
				systemService.delete(ayShgjjEntity);
			}
		}
		List<AyShgjjEntity> ayShgjjEntityist=systemService.findHql("FROM AyShgjjEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
		if(ayShgjjEntityist.size()==0){
			List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where 1=1 and zxbm=? and yglx <>? and yglx <> ? and yglx <> ? and zzzt=?",zxid,"劳务员工","劳务实习","离职员工","在职");
			
			
			for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
				AyShgjjEntity ayShgjjEntity = new AyShgjjEntity();
				ayShgjjEntity.setXm(aYgjbxxlists.getXm());
				ayShgjjEntity.setSjpzid(sjpzid);
				ayShgjjEntity.setYgxxid(aYgjbxxlists.getId());
				ayShgjjEntity.setZxbm(zxid);
				ayShgjjEntity.setHklx(aYgjbxxlists.getSfsh());
				ayShgjjEntity.setYglx(aYgjbxxlists.getYglx());
				ayShgjjEntity.setGw(aYgjbxxlists.getZw());
				//养老保险基数
				ayShgjjEntity.setYlbxjs(aYgjbxxlists.getYlbxjs());
				//其他四险基数
				ayShgjjEntity.setQtsxjs(aYgjbxxlists.getQtsxjs());
				//公积金基数
				ayShgjjEntity.setGjjjs(aYgjbxxlists.getGjjjs());
				//填报系数
				List<AyTbxsEntity> ayTbxsEntityList = systemService.findHql("from AyTbxsEntity where 1=1 and zx=? and hklx=? ",zxid,aYgjbxxlists.getSfsh());
				if(ayTbxsEntityList!=null&&ayTbxsEntityList.size()>0){
					AyTbxsEntity t = ayTbxsEntityList.get(0);
					ayShgjjEntity.setYanglgrbili(t.getYlbxgrcdbf());
					ayShgjjEntity.setYilgrbili(t.getYlbxgrcdbf2());
					ayShgjjEntity.setYanglgsbili(t.getYlbxgscd());
					ayShgjjEntity.setYilgsbili(t.getYlbxgscdbf1());
					
					ayShgjjEntity.setShiygrbili(t.getSybxgrcdbf2());
					ayShgjjEntity.setShengygsbili(t.getSybxgscdbf());
					ayShgjjEntity.setShiygsbili(t.getSybxgscdbf1());
					ayShgjjEntity.setShengygrbili(t.getSybxgrcdbf());
					
					ayShgjjEntity.setGongsgrbili(t.getGsbxgrcdbf());
					ayShgjjEntity.setGongsgsbili(t.getGsbxgscdbf());
					
					ayShgjjEntity.setGongjjgrbili(t.getZfgjjgrcdbf());
					ayShgjjEntity.setGongjjgsbili(t.getZfgjjgscdbf());
					//个人医疗保险补充
					
					ayShgjjEntity.setGsylbc(t.getGsylbc());
					
					
					
					DecimalFormat df = new DecimalFormat("#0.00");
					//失业公司
					String qtsxjs_s = aYgjbxxlists.getQtsxjs();
					if(StringUtil.isEmpty(qtsxjs_s)){
						qtsxjs_s = "0";
					}
					String shiygsbili_s = t.getSybxgscdbf1();
					if(StringUtil.isEmpty(shiygsbili_s)){
						shiygsbili_s = "0";
					}
					double shiyebili = Double.valueOf(shiygsbili_s);
					double qtsxjs = Double.valueOf(qtsxjs_s);
					double shiygs = shiyebili * qtsxjs/100;
					ayShgjjEntity.setSybxgscdbf1(df.format(shiygs));
					
					//失业个人
					String shiygrbili_s = t.getSybxgrcdbf2();
					if(StringUtil.isEmpty(shiygrbili_s)){
						shiygrbili_s = "0";
					}
					double shiygrbili = Double.valueOf(shiygrbili_s);
					double shiyegr = shiygrbili*qtsxjs/100;
					ayShgjjEntity.setSybxgrcdbf2(df.format(shiyegr));
					
					//医疗公司
					String yilgsbili_s = t.getYlbxgscdbf1();
					if(StringUtil.isEmpty(yilgsbili_s)){
						yilgsbili_s = "0";
					}
					double yilgsbili = Double.valueOf(yilgsbili_s);
					double yilgs = yilgsbili*qtsxjs/100;
					ayShgjjEntity.setYlbxgscdbf1(df.format(yilgs));
					
					//医疗个人
					String yilgrbili_s = t.getYlbxgrcdbf2();
					if(StringUtil.isEmpty(yilgrbili_s)){
						yilgrbili_s = "0";
					}
					double yilgrbili = Double.valueOf(yilgrbili_s);
					double yilgr = yilgrbili*qtsxjs/100;
					ayShgjjEntity.setYlbxgrcdbf2(df.format(yilgr));
					
					//工伤公司
					String gongsgsbili_s = t.getGsbxgscdbf();
					if(StringUtil.isEmpty(gongsgsbili_s)){
						gongsgsbili_s = "0";
					}
					double gongsgsbili = Double.valueOf(gongsgsbili_s);
					double gongsgs = gongsgsbili * qtsxjs/100;
					ayShgjjEntity.setGsbxgscdbf(df.format(gongsgs));
					
					//工伤个人
					String gongsgrbili_s = t.getGsbxgrcdbf();
					if(StringUtil.isEmpty(gongsgrbili_s)){
						gongsgrbili_s = "0";
					}
					double gongsgrbili = Double.valueOf(gongsgrbili_s);
					double gongsgr = gongsgrbili*qtsxjs/100;
					if(gongsgr==0){
						gongsgr = 0.00;
					}
					ayShgjjEntity.setGsbxgrcdbf(df.format(gongsgr));
					
					//生育公司
					String shengygsbili_s = t.getSybxgscdbf();
					if(StringUtil.isEmpty(shengygsbili_s)){
						shengygsbili_s = "0";
					}
					double shengygsbili = Double.valueOf(shengygsbili_s);
					double shengygs = shengygsbili*qtsxjs/100;
					ayShgjjEntity.setSybxgscdbf(df.format(shengygs));
					
					//生育个人
					String shengygrbili_s = t.getSybxgrcdbf();
					if(StringUtil.isEmpty(shengygrbili_s)){
						shengygrbili_s = "0";
					}
					double shengygrbili = Double.valueOf(shengygrbili_s);
					double shengygr = shengygrbili*qtsxjs/100;
					if(shengygr==0){
						shengygr = 0.00;
					}
					ayShgjjEntity.setSybxgrcdbf(df.format(shengygr));
					
					//养老公司
					String ylbxjx_s = aYgjbxxlists.getYlbxjs();
					if(StringUtil.isEmpty(ylbxjx_s)){
						ylbxjx_s = "0";
					}
					double ylbxjx = Double.valueOf(ylbxjx_s);
					String yanglgsbili_s = t.getYlbxgscd();
					if(StringUtil.isEmpty(yanglgsbili_s)){
						yanglgsbili_s = "0";
					}
					double yanglgsbili = Double.valueOf(yanglgsbili_s);
					double yanglgs = yanglgsbili*ylbxjx/100;
					ayShgjjEntity.setYlbxgscd(df.format(yanglgs));
					
					//养老个人
					String yanglgrbili_s = t.getYlbxgrcdbf();
					if(StringUtil.isEmpty(yanglgrbili_s)){
						yanglgrbili_s = "0";
					}
					double yanglgrbili = Double.valueOf(yanglgrbili_s);
					double yanglgr = yanglgrbili*ylbxjx/100;
					ayShgjjEntity.setYlbxgrcdbf(df.format(yanglgr));
					
					//保险合计
					double bxhj = shiygs + shiyegr + yilgs + yilgr + gongsgs + gongsgr + shengygs + shengygr + yanglgs + yanglgr;
					ayShgjjEntity.setBxhj(df.format(bxhj));
					
					//公积金公司
					String gongjjjx_s = aYgjbxxlists.getGjjjs();
					if(StringUtil.isEmpty(gongjjjx_s)){
						gongjjjx_s = "0";
					}
					double gongjjjx = Double.valueOf(gongjjjx_s);
					String gongjjgsbili_s = t.getZfgjjgscdbf();
					if(StringUtil.isEmpty(gongjjgsbili_s)){
						gongjjgsbili_s = "0";
					}
					double gongjjgsbili = Double.valueOf(gongjjgsbili_s);
					double gongjjgs = gongjjgsbili*gongjjjx/100;
					ayShgjjEntity.setZfgjjgscdbf(df.format(gongjjgs));
					
					//公积金个人
					String gongjjgrbili_s = t.getZfgjjgrcdbf();
					if(StringUtil.isEmpty(gongjjgrbili_s)){
						gongjjgrbili_s = "0";
					}
					double gongjjgrbili = Double.valueOf(gongjjgrbili_s);
					double gongjjgr = gongjjgrbili*gongjjjx/100;
					ayShgjjEntity.setZfgjjgrcdbf(df.format(gongjjgr));
					
					//公积金合计
					double gjjhj = gongjjgs + gongjjgr;
					ayShgjjEntity.setZfgjjhj(df.format(gjjhj));
							
				}else{
					System.out.println("未配置对应系数！");
				}
				systemService.save(ayShgjjEntity);
			}
			
		}
		//加载系数
//		AyTbxsEntity ayTbxsEntity = systemService.findUniqueByProperty(AyTbxsEntity.class,"zx",zxid);
//		request.setAttribute("tbxs",ayTbxsEntity); 
		systemService.updateBySqlString("update AY_JXSJ set tjzt4 = 2 where id=" + "'"+sjpzid+"'");//更新当月的提交状态
		return new ModelAndView("com/buss/shgjj/ayShgjjList");
	}
	/**
	 * 社会公积金列表 查看页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		request.setAttribute("zxid",zxid);
		//查看考勤表 是否存在 本月  本中心 重复数据
		return new ModelAndView("com/buss/shgjj/ayShgjjListChakan");
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
	public void datagrid(AyShgjjEntity ayShgjj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyShgjjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayShgjj, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(!StringUtil.isEmpty(sjpzid)){
				cq.eq("sjpzid", sjpzid);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayShgjjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除社会公积金
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyShgjjEntity ayShgjj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayShgjj = systemService.getEntity(AyShgjjEntity.class, ayShgjj.getId());
		message = "社会公积金删除成功";
		try{
			ayShgjjService.delete(ayShgjj);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除社会公积金
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金删除成功";
		try{
			for(String id:ids.split(",")){
				AyShgjjEntity ayShgjj = systemService.getEntity(AyShgjjEntity.class, id);
				ayShgjjService.delete(ayShgjj);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加社会公积金
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyShgjjEntity ayShgjj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金添加成功";
		try{
			ayShgjjService.save(ayShgjj);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "社会公积金添加失败";
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
	public AjaxJson saveRows(AyShgjjEntityPage page, HttpServletRequest request) {
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyShgjjEntity> ayShgjjEntity = page.getDemos();
		AjaxJson j = new AjaxJson();
		if (CollectionUtils.isNotEmpty(ayShgjjEntity)) {
			for (AyShgjjEntity ayShgjjEntitys : ayShgjjEntity) {
				if (StringUtil.isNotEmpty(ayShgjjEntitys.getId())) {
					AyShgjjEntity t = systemService.get(AyShgjjEntity.class, ayShgjjEntitys.getId());
					try {
						message = "更新成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayShgjjEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayShgjjEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt4 = 1 where id=" + "'" + ayShgjjEntity.get(0).getSjpzid() + "'");//更新当月的提交状态
		}
		return j;
	}
	
	@RequestMapping(params = "submitRows")
	@ResponseBody
	public AjaxJson submitRows(AyShgjjEntityPage page, HttpServletRequest request) {
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyShgjjEntity> ayShgjjEntity = page.getDemos();
		AjaxJson j = new AjaxJson();
		if (CollectionUtils.isNotEmpty(ayShgjjEntity)) {
			for (AyShgjjEntity ayShgjjEntitys : ayShgjjEntity) {
				if (StringUtil.isNotEmpty(ayShgjjEntitys.getId())) {
					AyShgjjEntity t = systemService.get(AyShgjjEntity.class, ayShgjjEntitys.getId());
					try {
						message = "更新成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayShgjjEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayShgjjEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt4 = 2 where id=" + "'" + ayShgjjEntity.get(0).getSjpzid() + "'");//更新当月的提交状态
		}
		return j;
	}
	
	
	
	/**
	 * 保存新增/更新的行数据
	 * @param page
	 * @return
	 */
	@RequestMapping(params = "doTiJiao")
	@ResponseBody
	public AjaxJson doTiJiao(AyShgjjEntityPage page, HttpServletRequest request) {
		String message = null;
		List<AyShgjjEntity> ayShgjjEntity = page.getDemos();
		AjaxJson j = new AjaxJson();
		if (CollectionUtils.isNotEmpty(ayShgjjEntity)) {
			for (AyShgjjEntity ayShgjjEntitys : ayShgjjEntity) {
				if (StringUtil.isNotEmpty(ayShgjjEntitys.getId())) {
					AyShgjjEntity t = systemService.get(AyShgjjEntity.class, ayShgjjEntitys.getId());
					try {
						message = "更新成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayShgjjEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayShgjjEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_GJJSJ set tjzt = 1 where id=" + "'" + ayShgjjEntity.get(0).getSjpzid() + "'");//更新当月的提交状态
		}
		return j;
	}
	
	
	
	/**
	 * 更新社会公积金
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyShgjjEntity ayShgjj, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "社会公积金更新成功";
		AyShgjjEntity t = ayShgjjService.get(AyShgjjEntity.class, ayShgjj.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayShgjj, t);
			ayShgjjService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "社会公积金更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 社会公积金新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyShgjjEntity ayShgjj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayShgjj.getId())) {
			ayShgjj = ayShgjjService.getEntity(AyShgjjEntity.class, ayShgjj.getId());
			req.setAttribute("ayShgjjPage", ayShgjj);
		}
		return new ModelAndView("com/buss/shgjj/ayShgjj-add");
	}
	/**
	 * 社会公积金编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyShgjjEntity ayShgjj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayShgjj.getId())) {
			ayShgjj = ayShgjjService.getEntity(AyShgjjEntity.class, ayShgjj.getId());
			req.setAttribute("ayShgjjPage", ayShgjj);
		}
		return new ModelAndView("com/buss/shgjj/ayShgjj-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayShgjjController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyShgjjEntity ayShgjj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyShgjjEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayShgjj, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyShgjjEntity> ayShgjjs = this.ayShgjjService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"社会公积金");
		modelMap.put(NormalExcelConstants.CLASS,AyShgjjEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社会公积金列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayShgjjs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyShgjjEntity ayShgjj,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"社会公积金");
    	modelMap.put(NormalExcelConstants.CLASS,AyShgjjEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("社会公积金列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyShgjjEntity> listAyShgjjEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyShgjjEntity.class,params);
				for (AyShgjjEntity ayShgjj : listAyShgjjEntitys) {
					ayShgjjService.save(ayShgjj);
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
	public List<AyShgjjEntity> list() {
		List<AyShgjjEntity> listAyShgjjs=ayShgjjService.getList(AyShgjjEntity.class);
		return listAyShgjjs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyShgjjEntity task = ayShgjjService.get(AyShgjjEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyShgjjEntity ayShgjj, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyShgjjEntity>> failures = validator.validate(ayShgjj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayShgjjService.save(ayShgjj);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayShgjj.getId();
		URI uri = uriBuilder.path("/rest/ayShgjjController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyShgjjEntity ayShgjj) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyShgjjEntity>> failures = validator.validate(ayShgjj);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayShgjjService.saveOrUpdate(ayShgjj);
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
		ayShgjjService.deleteEntityById(AyShgjjEntity.class, id);
	}
}
