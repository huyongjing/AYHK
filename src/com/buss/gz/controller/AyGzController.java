package com.buss.gz.controller;

import com.buss.gjjsj.entity.AyGjjsjEntity;
import com.buss.gsbz.entity.AyGsbzEntity;
import com.buss.gz.entity.AyGzEntity;
import com.buss.gz.entity.AyGzEntityPage;
import com.buss.gz.service.AyGzServiceI;
import com.buss.gzsj.entity.AyGzsjEntity;
import com.buss.jx.entity.AyJxEntity;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.kqsj.entity.AyKqsjEntity;
import com.buss.kqxx.entity.AyKqxxEntity;
import com.buss.shgjj.entity.AyShgjjEntity;
import com.buss.sjpz.entity.AySjpzEntity;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import com.buss.zxpz.entity.AyZxpzEntity;

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
import org.json.JSONArray;
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
 * @Description: 工资表
 * @author caozengling
 * @date 2017-03-23 14:56:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ayGzController")
public class AyGzController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AyGzController.class);

	@Autowired
	private AyGzServiceI ayGzService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 工资表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
        String sjpzid = request.getParameter("sjid");//年月id
        String zxid = request.getParameter("zxbm");
        request.setAttribute("sjpzid", sjpzid);
        //
        AyJxsjEntity ayGzsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
        
        if(ayGzsjEntity==null){
    	  return new ModelAndView("com/buss/gz/ayGzList");
        }
//        if("0".equals(ayGzsjEntity.getTjzt6())){
//        	List<AyGzEntity> ayGzEntityList1 = systemService.findHql("FROM AyGzEntity where sjpzid=? and zxbm=?", sjpzid, zxid);
//        	for (AyGzEntity ayGzEntity : ayGzEntityList1) {
//        		systemService.delete(ayGzEntity);
//			}
//        }
        
        
        List<AyZxpzEntity> ayZxpzEntitylist1 = systemService.findHql("FROM AyZxpzEntity where zxbm = ?", ayGzsjEntity.getZxbm());
        if(ayZxpzEntitylist1!=null){
        	if(ayZxpzEntitylist1.size()==1){
        		AyZxpzEntity t = ayZxpzEntitylist1.get(0);
        		request.setAttribute("yczd", t.getYczd());
        	}
        	
        }
        
        
        //工资相关：个人信息，社保公积金，个税，考勤，课程
        List<AyGzEntity> ayGzEntityList = systemService.findHql("FROM AyGzEntity where sjpzid=? and zxbm=?", sjpzid, zxid);
        if (ayGzEntityList.size() == 0) {
            List<AyYgjbxxEntity> aYgjbxxlist = systemService.findHql("from AyYgjbxxEntity where 1=1 and zxbm=? and yglx <>? and yglx <> ? and yglx <> ? and zzzt=?",zxid,"劳务员工","劳务实习","离职员工","在职");
            for (AyYgjbxxEntity aYgjbxxlists : aYgjbxxlist) {
                AyGzEntity ayGzEntity = new AyGzEntity();
                ayGzEntity.setXm(aYgjbxxlists.getXm());
                ayGzEntity.setSjpzid(sjpzid);
                ayGzEntity.setYhzh(aYgjbxxlists.getYhzh());
                ayGzEntity.setYgxxid(aYgjbxxlists.getId());
                ayGzEntity.setZxbm(zxid);
                ayGzEntity.setYglx(aYgjbxxlists.getYglx());
                ayGzEntity.setSfzh(aYgjbxxlists.getSfzh());
                ayGzEntity.setJbgz(aYgjbxxlists.getJbgz());
                ayGzEntity.setGwgz(aYgjbxxlists.getGwgz());
                ayGzEntity.setZcgz(aYgjbxxlists.getZcgz());
                ayGzEntity.setNzgz(aYgjbxxlists.getNzgz());
//                ayGzEntity.setJxgz(aYgjbxxlists.getJxgz());
                ayGzEntity.setGw(aYgjbxxlists.getZw());
                
                //公积金
                //获取某月公积金ID
                ayGzEntity = putGjj(ayGzsjEntity, aYgjbxxlists, ayGzEntity);
                //考勤相关
                ayGzEntity = putKaoQin(ayGzsjEntity, aYgjbxxlists, ayGzEntity);
                //免征额
                List<AyZxpzEntity> ayZxpzEntitylist = systemService.findHql("FROM AyZxpzEntity where zxbm = ?", ayGzsjEntity.getZxbm());
                if(ayZxpzEntitylist!=null){
                	if(ayZxpzEntitylist.size()==1){
                		AyZxpzEntity t = ayZxpzEntitylist.get(0);
                		String mze = t.getZsmze();
                		if(StringUtil.isEmpty(mze)){
                			mze = "0";
                		}
                		ayGzEntity.setMze(mze);
                	}
                	
                }
                //绩效相关
//                List<AyJxsjEntity> ayJxsjEntitylist = systemService.findHql("FROM AyJxsjEntity where month =? and year =? and zxbm = ?", ayGzsjEntity.getMonth(), ayGzsjEntity.getYear(),ayGzsjEntity.getZxbm());
//                if(ayJxsjEntitylist!=null){
//                	if(ayJxsjEntitylist.size()==1){
//                		AyJxsjEntity ayJxsjEntity = ayJxsjEntitylist.get(0);
                		List<AyJxEntity> ayJxEntitylist = systemService.findHql("FROM AyJxEntity where sjpzid =? and ygxxid =? and zxbm = ?", ayGzsjEntity.getId(), aYgjbxxlists.getId(),ayGzsjEntity.getZxbm());
                		if(ayJxEntitylist!=null){
                			if(ayJxEntitylist.size()==1){
                				AyJxEntity ayJxEntity = ayJxEntitylist.get(0);
                				//设置绩效工资(对应绩效里的达标奖金)
                				ayGzEntity.setJxgz(ayJxEntity.getDbjj());
                				//设置课时奖励(对应绩效里的课时费合计)
                				ayGzEntity.setKsjl(ayJxEntity.getKsfhj());
                			}
                		}
//                	}else{
//                		System.out.println("请确保该地区中心有且仅有一条绩效信息！");
//                	}
//                }else{
//                	System.out.println("该地区中心尚未提交绩效信息！");
//                }
                
                
                systemService.save(ayGzEntity);
            }
        } else {
           //更新逻辑
        }
            //加载个税标准
            List<AyGsbzEntity> ayGsbzEntitylist = systemService.findHql("from AyGsbzEntity");
            if(ayGsbzEntitylist!=null){
            	if(ayGsbzEntitylist.size()>0){
            		for (AyGsbzEntity t: ayGsbzEntitylist) {
            			t.setBpmStatus(null);
            			t.setCreateBy(null);
            			t.setCreateDate(null);
            			t.setCreateName(null);
            			t.setSm(null);
            			t.setSysCompanyCode(null);
            			t.setSysOrgCode(null);
            			t.setUpdateBy(null);
            			t.setUpdateDate(null);
            			t.setUpdateName(null);
					}
            		JSONArray jsonArray = new JSONArray(ayGsbzEntitylist);
                    request.setAttribute("gsbz", jsonArray.toString());
            	}
            }
            
            return new ModelAndView("com/buss/gz/ayGzList");

    }

	/**
	 * 设置考勤信息
	 * @param ayGzsjEntity
	 * @param aYgjbxxlists
	 * @param ayGzEntity
	 */
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

	/**
	 * 设置公积金信息
	 * @param ayGzsjEntity
	 * @param aYgjbxxlists
	 * @param ayGzEntity
	 */
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
	
	/**
	 * 工资列表 查看页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listChakan")
	public ModelAndView listChakan(HttpServletRequest request) {
		String sjpzid= request.getParameter("sjid");//年月id
		String zxid = request.getParameter("zxbm");
		request.setAttribute("sjpzid",sjpzid);
		request.setAttribute("zxid",zxid);
		List<AyZxpzEntity> ayZxpzEntitylist1 = systemService.findHql("FROM AyZxpzEntity where zxbm = ?", zxid);
        if(ayZxpzEntitylist1!=null){
        	if(ayZxpzEntitylist1.size()==1){
        		AyZxpzEntity t = ayZxpzEntitylist1.get(0);
        		request.setAttribute("yczd", t.getYczd());
        	}
        	
        }
		//查看考勤表 是否存在 本月  本中心 重复数据
		return new ModelAndView("com/buss/gz/ayGzListChaKan");
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
	public void datagrid(AyGzEntity ayGz,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sjpzid = request.getParameter("sjpzid");
		CriteriaQuery cq = new CriteriaQuery(AyGzEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGz, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(!StringUtil.isEmpty(sjpzid)){
				cq.eq("sjpzid", sjpzid);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ayGzService.getDataGridReturn(cq, true);
		List<AyGzEntity> ayYgjbxxs =dataGrid.getResults();
		List<Object> newdata = new ArrayList<Object>();
//		for(int i=0;i<ayYgjbxxs.size();i++){
//			Map<String,Object> map= new HashedMap();
//			AyGzEntity ayGzEntity=ayYgjbxxs.get(i);
//			map.put("id",ayGzEntity.getId());
//			map.put("sjpzid",ayGzEntity.getSjpzid());//保存时间表id
//
//			List<AyYgjbxxEntity> ayYgjbxxEntity= systemService.findHql("from AyYgjbxxEntity where id=?",ayGzEntity.getYgxxid());
//			if(ayYgjbxxEntity.size()>0){
//				map.put("gw",ayYgjbxxEntity.get(0).getZw());
//				map.put("yglx",ayYgjbxxEntity.get(0).getYglx());
//				map.put("sfzh",ayYgjbxxEntity.get(0).getSfzh());
//			}
//            map.put("jbgz",ayGzEntity.getJbgz());
//            map.put("gwgz",ayGzEntity.getGwgz());
//			map.put("zcgz",ayGzEntity.getZcgz());
//			map.put("nzgz",ayGzEntity.getNzgz());
//			map.put("gljx",ayGzEntity.getGljx());
//			map.put("qqj",ayGzEntity.getQqj());
//			map.put("qqkk",ayGzEntity.getQqkk());
//
//			map.put("yfgzze",ayYgjbxxs.get(i).getYfgzze());
//			//社会公积金
//			List<AyShgjjEntity> ayShgjjEntity= systemService.findHql("from AyShgjjEntity where ygxxid=?",ayGzEntity.getYgxxid());
//			if(ayShgjjEntity.size()>0){
//				map.put("ylbxjs",ayShgjjEntity.get(0).getYlbxjs());
//				map.put("qtsxjs",ayShgjjEntity.get(0).getQtsxjs());
//				map.put("gjjjs",ayShgjjEntity.get(0).getGjjjs());
//				map.put("ylbxgscd",ayShgjjEntity.get(0).getYlbxgscd());
//				map.put("sybxgscdbf1",ayShgjjEntity.get(0).getSybxgscdbf1());
//				map.put("ylbxgscdbf1",ayShgjjEntity.get(0).getYlbxgscdbf1());
//				map.put("gsbxgscdbf",ayShgjjEntity.get(0).getGsbxgscdbf());
//				map.put("sybxgscdbf",ayShgjjEntity.get(0).getSybxgscdbf());
//				map.put("zfgjjgscdbf",ayShgjjEntity.get(0).getZfgjjgscdbf());
//				map.put("ylbxgrcdbf",ayShgjjEntity.get(0).getYlbxgrcdbf());
//				map.put("sybxgrcdbf2",ayShgjjEntity.get(0).getSybxgrcdbf2());
//				map.put("ylbxgrcdbf2",ayShgjjEntity.get(0).getYlbxgrcdbf2());
//				map.put("zfgjjgrcdbf",ayShgjjEntity.get(0).getZfgjjgrcdbf());
//				map.put("gsylbc",ayShgjjEntity.get(0).getGsylbc());
//				//公司承担合计
//				Float gscdhjs=Float.valueOf(ayShgjjEntity.get(0).getYlbxgscd())
//						+Float.valueOf(ayShgjjEntity.get(0).getSybxgscdbf1())
//						+Float.valueOf(ayShgjjEntity.get(0).getYlbxgscdbf1())
//						+Float.valueOf(ayShgjjEntity.get(0).getGsbxgscdbf())
//						+Float.valueOf(ayShgjjEntity.get(0).getSybxgscdbf())
//						+Float.valueOf(ayShgjjEntity.get(0).getZfgjjgscdbf());
//				map.put("gscdhj",gscdhjs);
//				//个人承担合计
//				Float grcdhj=Float.valueOf(ayShgjjEntity.get(0).getYlbxgrcdbf())
//						+Float.valueOf(ayShgjjEntity.get(0).getSybxgrcdbf2())
//						+Float.valueOf(ayShgjjEntity.get(0).getYlbxgrcdbf2())
//						+Float.valueOf(ayShgjjEntity.get(0).getZfgjjgrcdbf())
//						+Float.valueOf(ayShgjjEntity.get(0).getGsylbc());
//				map.put("grcdhj",grcdhj);
//			}
//			map.put("ynssde",ayGzEntity.getYnssde());
//			map.put("mze",ayGzEntity.getMze());
//			map.put("snssde",ayGzEntity.getSnssde());
//			map.put("sl",ayGzEntity.getSl());
//			map.put("sskc",ayGzEntity.getSskc());
//			map.put("grsds",ayGzEntity.getGrsds());
//			map.put("shgz",ayGzEntity.getShgz());
//			map.put("qt",ayGzEntity.getQt());
//			map.put("sfgz",ayGzEntity.getSfgz());
//			map.put("yhzh",ayGzEntity.getYhzh());
//			map.put("zxbm",ayGzEntity.getZxbm());
//			map.put("ygxxid",ayGzEntity.getYgxxid());
//            map.put("xm",ayGzEntity.getXm());

			//绩效
//			List<AyJxEntity> jx= systemService.findHql("from AyJxEntity where ygxxid=?",ayGzEntity.getYgxxid());
//			if(jx.size()>0){
//				if(jx.get(0).getDbjj()==null){
//					map.put("jxgz",ayGzEntity.getJxgz());
//				}else{
//					map.put("jxgz",jx.get(0).getDbjj());//绩效工资
//				}
//				if(jx.get(0).getKsfhj()==null){
//					map.put("ksjl",ayGzEntity.getKsjl());//课时奖励
//				}else {
//					map.put("ksjl",jx.get(0).getKsfhj());//课时奖励
//				}
//			}
			//考勤
//			List<AyKqxxEntity> kq= systemService.findHql("from AyKqxxEntity where ygxxid=?",ayGzEntity.getYgxxid());
//			if(kq.size()>0){
//				DecimalFormat df2  = new DecimalFormat("###.00");
//				map.put("dyycq",kq.get(0).getDyycq());//当月应出勤
//				map.put("bj",kq.get(0).getBj());//病假
//				map.put("sj",kq.get(0).getSj());//事假
//				//map.put("cb",kq.get(0).getCb());//餐补
//				Float dyycq=Float.valueOf(kq.get(0).getDyycq());
//				Float cb =Float.valueOf(kq.get(0).getCb());
//				Float jtbz = Float.valueOf(kq.get(0).getJtb());
//				map.put("cfbz",df2.format((400/dyycq)*cb));//餐补合计
//				map.put("jtbz",df2.format((200/dyycq)*jtbz));//交通补助
//				Float zfb = Float.valueOf(kq.get(0).getZfb());
//				//Float jtbtbz = Float.valueOf(kq.get(0).getZfbtbz());
//				if(zfb>dyycq/2||zfb==dyycq){
//					map.put("zfbz",kq.get(0).getZfbtbz());//住房补助
//				}
//				if(zfb<dyycq/2){
//					Float zfbtbz = Float.valueOf(kq.get(0).getZfbtbz());
//					map.put("zfbz",zfbtbz/dyycq*zfb);//住房补助
//				}
//
//
//			}
//			newdata.add(map);
//		}
//		dataGrid.setResults(newdata);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工资表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AyGzEntity ayGz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		ayGz = systemService.getEntity(AyGzEntity.class, ayGz.getId());
		message = "工资表删除成功";
		try{
			List<AyGzEntity> gzlist= systemService.findHql("from AyGzEntity where ygxxid=?",ayGz.getYgxxid());
			for (AyGzEntity ayGzEntity : gzlist) {
				systemService.delete(ayGzEntity);
			}
			ayGzService.delete(ayGz);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除工资表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资表删除成功";
		try{
			for(String id:ids.split(",")){
				AyGzEntity ayGz = systemService.getEntity(AyGzEntity.class, 
				id
				);
				ayGzService.delete(ayGz);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "工资表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工资表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AyGzEntity ayGz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资表添加成功";
		try{
			ayGzService.save(ayGz);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "工资表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 总体添加提交
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doTijiao")
	@ResponseBody
	public AjaxJson doTijiao(AyGjjsjEntity aySjpz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		String year=request.getParameter("year");
		String month = request.getParameter("month");
		String zxbm = request.getParameter("zxbm");
		message = "提交成功";
		try{
			List<AySjpzEntity> kcxxList= systemService.findHql("from AySjpzEntity where year=? and month=? and tjzt =2 and zxbm=?",year,month,zxbm);
			if(!(kcxxList!=null&&kcxxList.size()==1)){
				message = month+"月份课程信息未提交!";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				return j;
			}
			List<Object> kqxxList= systemService.findHql("from AyKqsjEntity where year=? and month=? and tjzt=2 and zxbm=?",year,month,zxbm);
			if(!(kqxxList!=null&&kqxxList.size()==1)){
				message = month+"月份考勤未提交!";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				return j;
			}
			List<Object> gjjList= systemService.findHql("from AyGjjsjEntity where year=? and month=? and tjzt=2 and zxbm=?",year,month,zxbm);
			if(!(gjjList!=null&&gjjList.size()==1)){
				message = month+"月份公积金未提交!";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				return j;
			}
			List<Object> jxList= systemService.findHql("from AyJxsjEntity where year=? and month=? and (tjzt=1 or tjzt=2) and zxbm=?",year,month,zxbm);
			if(!(jxList!=null&&jxList.size()==1)){
				message = month+"月份绩效未提交!";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				return j;
			}
			systemService.updateBySqlString("update AY_GZSJ set tjzt = 2 where year=" + "'"+year+"'" + "and month="+month+"" + "and zxbm="+zxbm+"");//更新当月的工资提交状态
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
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
	public AjaxJson saveRows(AyGzEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyGzEntity> ayGzEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayGzEntity)){
			for(AyGzEntity ayKqxxEntitys:ayGzEntity){
				if (StringUtil.isNotEmpty(ayKqxxEntitys.getId())) {
					AyGzEntity t =systemService.get(AyGzEntity.class, ayKqxxEntitys.getId());
					try {
						message = "更新成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayKqxxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayKqxxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt6 = 2 where id=" + "'"+ayGzEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;
	}
	
	
	@RequestMapping(params = "submitRows")
	@ResponseBody
	public AjaxJson submitRows(AyGzEntityPage page, HttpServletRequest request){
		String message = null;
		String kcxs = request.getParameter("kcxs");
		List<AyGzEntity> ayGzEntity=page.getDemos();
		AjaxJson j = new AjaxJson();
		if(CollectionUtils.isNotEmpty(ayGzEntity)){
			for(AyGzEntity ayKqxxEntitys:ayGzEntity){
				if (StringUtil.isNotEmpty(ayKqxxEntitys.getId())) {
					AyGzEntity t =systemService.get(AyGzEntity.class, ayKqxxEntitys.getId());
					try {
						message = "更新成功";
						MyBeanUtils.copyBeanNotNull2Bean(ayKqxxEntitys, t);
						systemService.saveOrUpdate(t);
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					message = "添加成功";
					systemService.save(ayKqxxEntitys);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}
			}
			systemService.updateBySqlString("update AY_JXSJ set tjzt6 = 2 where id=" + "'"+ayGzEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
		}
		return j;
	}
	
	/**
	 * 更新工资表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AyGzEntity ayGz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "工资表更新成功";
		AyGzEntity t = ayGzService.get(AyGzEntity.class, ayGz.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ayGz, t);
			ayGzService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "工资表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 工资表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AyGzEntity ayGz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGz.getId())) {
			ayGz = ayGzService.getEntity(AyGzEntity.class, ayGz.getId());
			req.setAttribute("ayGzPage", ayGz);
		}
		return new ModelAndView("com/buss/gz/ayGz-add");
	}
	/**
	 * 工资表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AyGzEntity ayGz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ayGz.getId())) {
			ayGz = ayGzService.getEntity(AyGzEntity.class, ayGz.getId());
			req.setAttribute("ayGzPage", ayGz);
		}
		return new ModelAndView("com/buss/gz/ayGz-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","ayGzController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AyGzEntity ayGz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AyGzEntity.class, dataGrid);
		String sjpzid = request.getParameter("sjpzid");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayGz, request.getParameterMap());
		if(!StringUtil.isEmpty(sjpzid)){
			cq.eq("sjpzid", sjpzid);
		}
		cq.add();
		List<AyGzEntity> ayGzs = this.ayGzService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"工资表");
		modelMap.put(NormalExcelConstants.CLASS,AyGzEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("工资表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,ayGzs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AyGzEntity ayGz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"工资表");
    	modelMap.put(NormalExcelConstants.CLASS,AyGzEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("工资表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<AyGzEntity> listAyGzEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AyGzEntity.class,params);
				for (AyGzEntity ayGz : listAyGzEntitys) {
					ayGzService.save(ayGz);
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
	public List<AyGzEntity> list() {
		List<AyGzEntity> listAyGzs=ayGzService.getList(AyGzEntity.class);
		return listAyGzs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		AyGzEntity task = ayGzService.get(AyGzEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody AyGzEntity ayGz, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGzEntity>> failures = validator.validate(ayGz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGzService.save(ayGz);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = ayGz.getId();
		URI uri = uriBuilder.path("/rest/ayGzController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody AyGzEntity ayGz) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AyGzEntity>> failures = validator.validate(ayGz);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			ayGzService.saveOrUpdate(ayGz);
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
		ayGzService.deleteEntityById(AyGzEntity.class, id);
	}
}
