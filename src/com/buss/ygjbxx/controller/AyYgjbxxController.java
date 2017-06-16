package com.buss.ygjbxx.controller;
import com.buss.gsbz.entity.AyGsbzEntity;
import com.buss.gz.entity.AyGzEntity;
import com.buss.gzsj.entity.AyGzsjEntity;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.kqxx.entity.AyKqxxEntity;
import com.buss.lwgz.entity.AyLwgzEntity;
import com.buss.shgjj.entity.AyShgjjEntity;
import com.buss.tbxs.entity.AyTbxsEntity;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import com.buss.ygjbxx.service.AyYgjbxxServiceI;
import com.buss.zxpz.entity.AyZxpzEntity;

import java.util.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
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

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: 员工基本信息
 * @author caozengling
 * @date 2017-03-07 15:58:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayYgjbxxController")
public class AyYgjbxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyYgjbxxController.class);

	@Autowired
	private AyYgjbxxServiceI ayYgjbxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 员工基本信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/ygjbxx/ayYgjbxxList");
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
	public void datagrid(AyYgjbxxEntity ayYgjbxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
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
			/*String ids = "402881235aa7c6b4015aa7fa7a67000f,402881235aa7c6b4015aa7fa7a67000y";
			for(String id:ids.split(",")){
				cq.notEq("id",id);
			}*/

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayYgjbxxService.getDataGridReturn(cq, true);
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
	 * 删除员工基本信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyYgjbxxEntity ayYgjbxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayYgjbxx = systemService.getEntity(AyYgjbxxEntity.class, ayYgjbxx.getId());
		message = "员工基本信息删除成功";
		try{
			ayYgjbxxService.delete(ayYgjbxx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "员工基本信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除员工基本信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "员工基本信息删除成功";
		try{
			for(String id:ids.split(",")){
				AyYgjbxxEntity ayYgjbxx = systemService.getEntity(AyYgjbxxEntity.class, id);
				ayYgjbxxService.delete(ayYgjbxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "员工基本信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加员工基本信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyYgjbxxEntity ayYgjbxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "员工基本信息添加成功";
		try{
			ayYgjbxxService.save(ayYgjbxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "员工基本信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doShenhe")
	@ResponseBody
	public AjaxJson doShenhe(AyYgjbxxEntity ayYgjbxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核成功";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format( new Date());
			systemService.updateBySqlString("update AY_YGJBXX set zzzt = '在职',rzrq = '"+date+"' where id=" + "'"+ayYgjbxx.getId()+"'");//更新当月的提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 更新员工基本信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyYgjbxxEntity ayYgjbxx, HttpServletRequest request) {
		String zx = request.getParameter("zx");
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "员工基本信息更新成功";
		AyYgjbxxEntity t1 = ayYgjbxxService.get(AyYgjbxxEntity.class, ayYgjbxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayYgjbxx, t1);
			ayYgjbxxService.saveOrUpdate(t1);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "员工基本信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		List<AyJxsjEntity> ayJxsjEntities = systemService.findHql("FROM AyJxsjEntity where tjzt<>2");
		for (AyJxsjEntity ayJxsjEntity : ayJxsjEntities) {
			//更新考勤
			List<AyKqxxEntity> ayKqxxEntities = systemService.findHql("FROM AyKqxxEntity where SJPZID=? and YGXXID=?",ayJxsjEntity.getId(),ayYgjbxx.getId());
			if(ayKqxxEntities!=null){
				if(ayKqxxEntities.size()==1){
					AyKqxxEntity ayKqxxEntity = ayKqxxEntities.get(0);
					ayKqxxEntity.setXm(ayYgjbxx.getXm());
					ayKqxxEntity.setSjpzid(ayJxsjEntity.getId());
					ayKqxxEntity.setYgxxid(ayYgjbxx.getId());
					ayKqxxEntity.setZxbm(ayJxsjEntity.getZxbm());
					ayKqxxEntity.setYglx(ayYgjbxx.getYglx());
					ayKqxxEntity.setDyycq(ayJxsjEntity.getDyycq());
					ayKqxxEntity.setFdj(Double.valueOf(ayJxsjEntity.getFdj()));
					ayKqxxEntity.setZfbtbz(ayYgjbxx.getZfbt());
					systemService.saveOrUpdate(ayKqxxEntity);
					systemService.updateBySqlString("update AY_JXSJ set tjzt3 = 0 where id=" + "'"+ayJxsjEntity.getId()+"'");//更新当月的提交状态
				}
			}
			//更新个人公积金
			updateGJJ(ayYgjbxx, ayJxsjEntity);
			//更新劳务工资
			updateLwgz(ayYgjbxx, request, ayJxsjEntity);
			//更新工资
			List<AyGzEntity> ayGzEntityList = systemService.findHql("FROM AyGzEntity where sjpzid=? and ygxxid=?", ayJxsjEntity.getId(), ayYgjbxx.getId());
			if(ayGzEntityList!=null){
				if(ayGzEntityList.size()==1){
					AyGzEntity ayGzEntity = ayGzEntityList.get(0);
					//更新个人信息
					ayGzEntity.setXm(ayYgjbxx.getXm());
		            ayGzEntity.setYhzh(ayYgjbxx.getYhzh());
		            ayGzEntity.setYgxxid(ayYgjbxx.getId());
		            ayGzEntity.setYglx(ayYgjbxx.getYglx());
		            ayGzEntity.setSfzh(ayYgjbxx.getSfzh());
		            ayGzEntity.setJbgz(ayYgjbxx.getJbgz());
		            ayGzEntity.setGwgz(ayYgjbxx.getGwgz());
		            ayGzEntity.setZcgz(ayYgjbxx.getZcgz());
		            ayGzEntity.setNzgz(ayYgjbxx.getNzgz());
//		            ayGzEntity.setJxgz(aYgjbxxlists.getJxgz());
		            ayGzEntity.setGw(ayYgjbxx.getZw());
					//更新公积金
					ayGzEntity = putGjj(ayJxsjEntity, ayYgjbxx, ayGzEntity);
					//更新考勤
					ayGzEntity = putKaoQin(ayJxsjEntity, ayYgjbxx, ayGzEntity);
					systemService.saveOrUpdate(ayGzEntity);
					systemService.updateBySqlString("update AY_JXSJ set tjzt6 = 0 where id=" + "'"+ayJxsjEntity+"'");//更新当月的提交状态
				}
			}
		}
		j.setMsg(message);
		return j;
	}
	
	
	private AyGzEntity putGjj(AyJxsjEntity ayGzsjEntity, AyYgjbxxEntity aYgjbxxlists,
			AyGzEntity ayGzEntity) {
//		List<AyGjjsjEntity> ayGjjsjEntitylist = systemService.findHql("FROM AyGjjsjEntity where month =? and year =? and zxbm = ?", ayGzsjEntity.getMonth(), ayGzsjEntity.getYear(),ayGzsjEntity.getZxbm());
//		if(ayGjjsjEntitylist!=null){
//			if(ayGjjsjEntitylist.size()==1){
//				AyGjjsjEntity ayGjjsjEntity_shijian = ayGjjsjEntitylist.get(0);
		    	//根据月公积金ID和用户ID获取社保公积金数据
		    	List<AyShgjjEntity> ayShgjjEntitylist = systemService.findHql("FROM AyShgjjEntity where sjpzid =? and ygxxid =? and zxbm = ?", ayGzsjEntity.getId(), aYgjbxxlists.getId(),ayGzsjEntity.getZxbm());
		    	if(ayShgjjEntitylist!=null){
		    		if(ayShgjjEntitylist.size()==1){
		    			AyShgjjEntity t = ayShgjjEntitylist.get(0);
		    			//养老保险基数
		    			ayGzEntity.setYlbxjs(t.getYlbxjs());
		    			//四险保险基数
		    			ayGzEntity.setQtsxjs(t.getQtsxjs());
		    			//公积金基数
		    			ayGzEntity.setGjjjs(t.getGjjjs());
		    			//养老公司
		    			ayGzEntity.setYlbxgscd(t.getYlbxgscd());
		    			//失业公司
		    			ayGzEntity.setSybxgscdbf1(t.getSybxgscdbf1());
		    			//医疗公司
		    			ayGzEntity.setYlbxgscdbf1(t.getYlbxgscdbf1());
		    			//工伤公司
		    			ayGzEntity.setGsbxgscdbf(t.getGsbxgscdbf());
		    			//生育公司
		    			ayGzEntity.setSybxgscdbf(t.getSybxgscdbf());
		    			//公积金公司
		    			ayGzEntity.setZfgjjgscdbf(t.getZfgjjgscdbf());
		    			//养老个人
		    			ayGzEntity.setYlbxgrcdbf(t.getYlbxgrcdbf());
		    			//医疗个人
		    			ayGzEntity.setYlbxgrcdbf2(t.getYlbxgrcdbf2());
		    			//失业个人
		    			ayGzEntity.setSybxgrcdbf2(t.getSybxgrcdbf2());
		    			//工伤个人
		    			ayGzEntity.setGsbxgrcdbf(t.getGsbxgrcdbf());
		    			//生育个人
		    			ayGzEntity.setSybxgrcdbf(t.getSybxgrcdbf());
		    			//公积金个人
		    			ayGzEntity.setZfgjjgrcdbf(t.getZfgjjgrcdbf());
		    			//医疗个人补充
		    			ayGzEntity.setGsylbc(t.getGsylbc());
		    			//公司承担合计
		    			String yanglao_gs = t.getYlbxgscd();
		    			String shiye_gs = t.getSybxgscdbf1();
		    			String yiliao_gs = t.getYlbxgscdbf1();
		    			String gongshang_gs = t.getGsbxgscdbf();
		    			String shengyu_gs = t.getSybxgscdbf();
		    			String gongjj_gs = t.getZfgjjgscdbf();
		    			
		    			if(StringUtil.isEmpty(yanglao_gs)){
		    				yanglao_gs = "0";
		    			}
		    			if(StringUtil.isEmpty(shiye_gs)){
		    				shiye_gs = "0";
		    			}
		    			if(StringUtil.isEmpty(yiliao_gs)){
		    				yiliao_gs = "0";
		    			}
		    			if(StringUtil.isEmpty(gongshang_gs)){
		    				gongshang_gs = "0";
		    			}
		    			if(StringUtil.isEmpty(shengyu_gs)){
		    				shengyu_gs = "0";
		    			}
		    			if(StringUtil.isEmpty(gongjj_gs)){
		    				gongjj_gs = "0";
		    			}
		    			float gscdhj_f = Float.parseFloat(yanglao_gs) + Float.parseFloat(shiye_gs) + Float.parseFloat(yiliao_gs) 
		    					+ Float.parseFloat(gongshang_gs) + Float.parseFloat(shengyu_gs) + Float.parseFloat(gongjj_gs);
		    			ayGzEntity.setGscdhj(String.valueOf(gscdhj_f));
		    			//个人承担合计
		    			String yanglao_gr = t.getYlbxgrcdbf();
		    			String shiye_gr = t.getSybxgrcdbf2();
		    			String yiliao_gr = t.getYlbxgrcdbf2();
		    			String gongshang_gr = t.getGsbxgrcdbf();
		    			String shengyu_gr = t.getSybxgrcdbf();
		    			String gongjj_gr = t.getZfgjjgrcdbf();
		    			String yiliao_bc = t.getGsylbc();
		    			
		    			if(StringUtil.isEmpty(yanglao_gr)){
		    				yanglao_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(shiye_gr)){
		    				shiye_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(yiliao_gr)){
		    				yiliao_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(gongshang_gr)){
		    				gongshang_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(shengyu_gr)){
		    				shengyu_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(gongjj_gr)){
		    				gongjj_gr = "0";
		    			}
		    			if(StringUtil.isEmpty(yiliao_bc)){
		    				yiliao_bc = "0";
		    			}
		    			float grcdhj_f = Float.parseFloat(yanglao_gr) + Float.parseFloat(shiye_gr) + Float.parseFloat(yiliao_gr) 
		    					+ Float.parseFloat(gongshang_gr) + Float.parseFloat(shengyu_gr) + Float.parseFloat(gongjj_gr)
		    					+ Float.parseFloat(yiliao_bc);
		    			ayGzEntity.setGrcdhj(String.valueOf(grcdhj_f));
		    			
		    		}
		    	}
//			}
//			
//		}
		return ayGzEntity;
	}

	private AyGzEntity putKaoQin(AyJxsjEntity ayGzsjEntity,
			AyYgjbxxEntity aYgjbxxlists, AyGzEntity ayGzEntity) {
//		List<AyKqsjEntity> ayKqsjEntitylist = systemService.findHql("FROM AyKqsjEntity where month =? and year =? and zxbm = ?", ayGzsjEntity.getMonth(), ayGzsjEntity.getYear(),ayGzsjEntity.getZxbm());
//		if(ayKqsjEntitylist!=null){
//			if(ayKqsjEntitylist.size()==1){
//				AyKqsjEntity ayKqsjEntity = ayKqsjEntitylist.get(0);
				List<AyKqxxEntity> ayKqxxEntitylist = systemService.findHql("FROM AyKqxxEntity where sjpzid =? and ygxxid =? and zxbm = ?", ayGzsjEntity.getId(), aYgjbxxlists.getId(),ayGzsjEntity.getZxbm());
				if(ayKqxxEntitylist!=null){
		        	if(ayKqxxEntitylist.size()==1){
		        		AyKqxxEntity ayKqxxEntity = ayKqxxEntitylist.get(0);
		        		
		        		//缺勤扣款
		        		String jbgz = aYgjbxxlists.getJbgz();
		        		String dyycq = ayKqxxEntity.getDyycq();
		        		Double bjts = ayKqxxEntity.getBj();
		        		Double sjts = ayKqxxEntity.getSj();
		        		if(StringUtil.isEmpty(jbgz)){
		        			jbgz = "0";
		        		}
		        		if(StringUtil.isEmpty(dyycq)){
		        			dyycq = "0";
		        		}
		        		if(bjts==null){
		        			bjts = 0.0;
		        		}
		        		if(sjts==null){
		        			sjts = 0.0;
		        		}
		        		double jbgz_d = Double.valueOf(jbgz);
		        		double dyycq_d = Double.valueOf(dyycq);
		        		
		        		double qqkk_d = (-1)*(jbgz_d/dyycq_d * bjts * 0.5 + jbgz_d/dyycq_d * sjts);
		        		
		        		ayGzEntity.setQqkk(String.valueOf(qqkk_d));
		        		
		        		//餐费补助
		        		//20170515，餐费补助修改计算公式为：按天*实际出勤
//		        		String cfbz = ayGzsjEntity.getCf();
//		        		String cbts = ayKqxxEntity.getCb();
		        		String cfbz = aYgjbxxlists.getCfbz();
		        		Double sjcq = ayKqxxEntity.getSjcq();
		        		if(sjcq==null){
		        			sjcq = 0.00;
		        		}
		        		if(StringUtil.isEmpty(cfbz)){
		        			cfbz = "0";
		        		}
		        		
		        		double cfbz_f = Double.valueOf(cfbz);
//		        		float cbts_f = Float.valueOf(cbts);
		        		
		        		double cb_f = cfbz_f*sjcq;
		        		ayGzEntity.setCfbz(String.valueOf(cb_f));
		        		
		        		//交通补助
		        		//20170515，交通补助修改计算公式为：按月/应出勤*实际出勤
		        		String jtbz = aYgjbxxlists.getJtbz();
//		        		String jtts = ayKqxxEntity.getJtb();
		        		if(StringUtil.isEmpty(jtbz)){
		        			jtbz = "0";
		        		}
//		        		if(StringUtil.isEmpty(jtts)){
//		        			jtts = "0";
//		        		}
		        		double jtbz_f = (Double.valueOf(jtbz)/dyycq_d)*sjcq;
		        		ayGzEntity.setJtbz(String.valueOf(jtbz_f));
		        		
		        		//通讯补助
		        		String txbz_s = aYgjbxxlists.getTxbz();
		        		if(StringUtil.isEmpty(txbz_s)){
		        			txbz_s = "0";
		        		}
		        		ayGzEntity.setTxbz(txbz_s);
		        		
		        		//出差补助 = 出差补助*出差天数
		        		String ccbz_s = aYgjbxxlists.getCcbz();
		        		if(StringUtil.isEmpty(ccbz_s)){
		        			ccbz_s = "0";
		        		}
		        		double ccts = ayKqxxEntity.getCc();
		        		
		        		double ccbz = Double.valueOf(ccbz_s)*ccts;
		        		ayGzEntity.setCcbz(String.valueOf(ccbz));
		        		
		        		//住房补助
		        		//如果住房补助为0，则为0，
		        		//如果住房补助>0，则实际出勤/当月应出勤<0.5,为住房补助费用*实际出勤/当月应出勤
		        		//如果住房补助>0，则实际出勤/当月应出勤>=0.5,为住房补助费用
		        		String zfbt_s = aYgjbxxlists.getZfbt();
		        		
		        		if(StringUtil.isEmpty(zfbt_s)){
		        			zfbt_s = "0";
		        		}
		        		
		        		
		        		double bilv = sjcq/dyycq_d;
		        		
		        		double zfbz_d = 0.0;
		        		
		        		if(bilv<0.5){
		        			zfbz_d = bilv*Double.valueOf(zfbt_s);
		        		}else{
		        			zfbz_d = Double.valueOf(zfbt_s);
		        		}
		        		
		        		ayGzEntity.setZfbz(String.valueOf(zfbz_d));

		        		
		        		
		        	}
				}
//			}
//		}
		return ayGzEntity;
	}
	
	private void updateLwgz(AyYgjbxxEntity ayYgjbxx,
			HttpServletRequest request, AyJxsjEntity ayJxsjEntity) {
		List<AyLwgzEntity> ayLwgzEntities = systemService.findHql("FROM AyLwgzEntity where sjpzid=? and ygxxid=?",ayJxsjEntity.getId(),ayYgjbxx.getId());
		DecimalFormat df  = new DecimalFormat("###.00");
		if(ayLwgzEntities!=null){
			if(ayLwgzEntities.size()==1){
				AyLwgzEntity ayLwgzEntity = ayLwgzEntities.get(0);
				ayLwgzEntity.setXm(ayYgjbxx.getXm());
				ayLwgzEntity.setSjpzid(ayJxsjEntity.getId());
				ayLwgzEntity.setSfzh(ayYgjbxx.getSfzh());
				ayLwgzEntity.setYhzh(ayYgjbxx.getYhzh());
				ayLwgzEntity.setYgxxid(ayYgjbxx.getId());
				ayLwgzEntity.setZxbm(ayJxsjEntity.getZxbm());
				ayLwgzEntity.setJbgz(ayYgjbxx.getJbgz());
				//其他补贴
				String qtbt = ayYgjbxx.getQtbt();
				if(StringUtil.isEmpty(qtbt)){
					qtbt = "0";
				}
				ayLwgzEntity.setBt(qtbt);
				
				//合计 = 基本工资 + 其他补贴
				String jbgz_s = ayYgjbxx.getJbgz();
				if(StringUtil.isEmpty(jbgz_s)){
					jbgz_s = "0";
				}
				double jbgz = Double.valueOf(jbgz_s);
				String qtbt_s = ayYgjbxx.getQtbt();
				if(StringUtil.isEmpty(qtbt_s)){
					qtbt_s = "0";
				}
				double qtbt_d = Double.valueOf(qtbt);
				
				double hj_d = jbgz + qtbt_d;
				ayLwgzEntity.setHj(df.format(hj_d));
				
				String mze_s = "0";
				//免征额
				List<AyZxpzEntity> ayZxpzEntityList = systemService.findHql("FROM AyZxpzEntity where zxbm=?", ayJxsjEntity.getZxbm());
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
				String qt = ayYgjbxx.getQt();
				if(StringUtil.isEmpty(qt)){
					qt = "0";
				}
				ayLwgzEntity.setQt(qt);
				double qt_d = Double.valueOf(qt);
				
				//实发工资 = 税后工资 + 其他
				double sfgz = shgz + qt_d;
				ayLwgzEntity.setSfgz(df.format(sfgz));
				
				systemService.saveOrUpdate(ayLwgzEntity);
			}
		}
	}

	private void updateGJJ(AyYgjbxxEntity ayYgjbxx, AyJxsjEntity ayJxsjEntity) {
		List<AyShgjjEntity> ayShgjjEntityist=systemService.findHql("FROM AyShgjjEntity where sjpzid=? and ygxxid=?",ayJxsjEntity.getId(),ayYgjbxx.getId());
		if(ayShgjjEntityist!=null){
			if(ayShgjjEntityist.size()==1){
				AyShgjjEntity ayShgjjEntity = ayShgjjEntityist.get(0);
				ayShgjjEntity.setXm(ayYgjbxx.getXm());
				ayShgjjEntity.setSjpzid(ayJxsjEntity.getId());
				ayShgjjEntity.setYgxxid(ayYgjbxx.getId());
				ayShgjjEntity.setZxbm(ayJxsjEntity.getZxbm());
				ayShgjjEntity.setHklx(ayYgjbxx.getSfsh());
				ayShgjjEntity.setYglx(ayYgjbxx.getYglx());
				ayShgjjEntity.setGw(ayYgjbxx.getZw());
				//养老保险基数
				ayShgjjEntity.setYlbxjs(ayYgjbxx.getYlbxjs());
				//其他四险基数
				ayShgjjEntity.setQtsxjs(ayYgjbxx.getQtsxjs());
				//公积金基数
				ayShgjjEntity.setGjjjs(ayYgjbxx.getGjjjs());
				//填报系数
				List<AyTbxsEntity> ayTbxsEntityList = systemService.findHql("from AyTbxsEntity where 1=1 and zx=? and hklx=? ",ayJxsjEntity.getZxbm(),ayYgjbxx.getSfsh());
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
					String qtsxjs_s = ayYgjbxx.getQtsxjs();
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
					String ylbxjx_s = ayYgjbxx.getYlbxjs();
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
					String gongjjjx_s = ayYgjbxx.getGjjjs();
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
	}
	

	/**
	 * 员工基本信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyYgjbxxEntity ayYgjbxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayYgjbxx.getId())) {
			ayYgjbxx = ayYgjbxxService.getEntity(AyYgjbxxEntity.class, ayYgjbxx.getId());
			req.setAttribute("ayYgjbxxPage", ayYgjbxx);
		}
		return new ModelAndView("com/buss/ygjbxx/ayYgjbxx-add");
	}
	/**
	 * 员工基本信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyYgjbxxEntity ayYgjbxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayYgjbxx.getId())) {
			ayYgjbxx = ayYgjbxxService.getEntity(AyYgjbxxEntity.class, ayYgjbxx.getId());
			ayYgjbxx.setUpdateDate(null);
			req.setAttribute("ayYgjbxxPage", ayYgjbxx);
		}
		return new ModelAndView("com/buss/ygjbxx/ayYgjbxx-update");
	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayYgjbxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyYgjbxxEntity ayYgjbxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyYgjbxxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayYgjbxx, request.getParameterMap());
		List<AyYgjbxxEntity> ayYgjbxxs = this.ayYgjbxxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"员工基本信息");
		modelMap.put(NormalExcelConstants.CLASS,AyYgjbxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("员工基本信息列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayYgjbxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyYgjbxxEntity ayYgjbxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"员工基本信息");
    	modelMap.put(NormalExcelConstants.CLASS,AyYgjbxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("员工基本信息列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyYgjbxxEntity> listAyYgjbxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyYgjbxxEntity.class,params);
				for (AyYgjbxxEntity ayYgjbxx : listAyYgjbxxEntitys) {
					ayYgjbxxService.save(ayYgjbxx);
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
	public List<AyYgjbxxEntity> list() {
		List<AyYgjbxxEntity> listAyYgjbxxs=ayYgjbxxService.getList(AyYgjbxxEntity.class);
		return listAyYgjbxxs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyYgjbxxEntity task = ayYgjbxxService.get(AyYgjbxxEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyYgjbxxEntity ayYgjbxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyYgjbxxEntity>> failures = validator.validate(ayYgjbxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayYgjbxxService.save(ayYgjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayYgjbxx.getId();
		URI uri = uriBuilder.path("/rest/ayYgjbxxController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyYgjbxxEntity ayYgjbxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyYgjbxxEntity>> failures = validator.validate(ayYgjbxx);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayYgjbxxService.saveOrUpdate(ayYgjbxx);
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
		ayYgjbxxService.deleteEntityById(AyYgjbxxEntity.class, id);
	}
}
