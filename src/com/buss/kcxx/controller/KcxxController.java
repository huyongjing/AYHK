package com.buss.kcxx.controller;

import com.buss.gz.entity.AyGzEntity;
import com.buss.jx.entity.AyJxEntity;
import com.buss.jxsj.entity.AyJxsjEntity;
import com.buss.kcpz.controller.AyKcpzController;
import com.buss.kcpz.entity.AyKcpzEntity;
import com.buss.kcxx.entity.AyKcxxEntity;
import com.buss.kcxx.entity.AyKcxxEntityPage;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import com.buss.zxpz.entity.AyZxpzEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 课程信息
 * Created by caozengling on 2017/3/9.
 */
@Controller
@RequestMapping("/kcxxController")
public class KcxxController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(AyKcpzController.class);
    @Autowired
    private SystemService systemService;
    @Autowired
    private Validator validator;
    /**
     * 课程信息首页 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goKcxxIndex")
    public ModelAndView goKcxxIndex(DataGrid dataGrid,AyZxpzEntity ayZxpz,HttpServletRequest request) {
        CriteriaQuery cq = new CriteriaQuery(AyZxpzEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayZxpz, request.getParameterMap());
        try{
            //自定义追加查询条件
            //cq.eq("zxbm","1");//北京中心
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        List<AyZxpzEntity> ayZxpzlist = dataGrid.getResults();
        request.setAttribute("datalist",ayZxpzlist);
        return new ModelAndView("/com/buss/kcxx/KcxxIndex");
    }

    /**
     * 课程列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "Kclist")
    public ModelAndView Kclist(HttpServletRequest request) {


        return new ModelAndView("com/buss/kcxx/KcxxList");
    }
    /**
     * easyui 课程信息 用户列表 list
     *
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(AyKcpzEntity ayKzpz, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(AyKcpzEntity.class, dataGrid);
        String sjpzid= request.getParameter("sjpzid");
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ayKzpz, request.getParameterMap());
        try{
            //自定义追加查询条件
            //cq.eq("zx","1");//中心类型
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        List<AyKcpzEntity> ayKcpzlist = dataGrid.getResults();
        List<Object> newdata = new ArrayList<>();
        List<AyYgjbxxEntity> aYgjbxxlist=systemService.findHql("from AyYgjbxxEntity where 1=1");
        List<AyYgjbxxEntity> kcxxlist=systemService.findHql("from AyKcxxEntity where 1=1");
        int xszs = 0;//统计系数汇总
        for(AyKcpzEntity ayKcpzlists:ayKcpzlist){
            for(AyYgjbxxEntity aYgjbxxlists:aYgjbxxlist){
                Map<String,Object> map = new HashedMap();
                map.put("id",ayKcpzlists.getId());
                map.put("ygxxid",aYgjbxxlists.getId());
                map.put("kcmc",ayKcpzlists.getKcmc());
                map.put("kcxs",ayKcpzlists.getXs());
                map.put("xm",aYgjbxxlists.getXm());
                map.put("sjpzid",sjpzid);//保存时间表id
                newdata.add(map);
                //xszs=xszs+Integer.parseInt(ayKcpzlists.getXs());
            }
        }

        dataGrid.setResults(newdata);
        //dataGrid.setFooter("kcmc:系数合计汇总,kcxs:"+xszs);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 保存新增/更新的行数据
     * @param page
     * @return
     */
    @RequestMapping(params = "saveRows")
    @ResponseBody
    public AjaxJson saveRows(AyKcxxEntityPage page, HttpServletRequest request){
        String message = null;
        String kcxs = request.getParameter("kcxs");
        List<AyKcxxEntity> ayKcxxEntity=page.getDemos();
        AjaxJson j = new AjaxJson();
        String sjpzid= "";//年月id
		String zxid = "";
        if(CollectionUtils.isNotEmpty(ayKcxxEntity)){
        	sjpzid = ayKcxxEntity.get(0).getSjpzid();
        	AyJxsjEntity ayJxsjEntity = systemService.getEntity(AyJxsjEntity.class, sjpzid);
        	zxid = ayJxsjEntity.getZxbm();
            for(AyKcxxEntity ayKcxxEntitys:ayKcxxEntity){
                if (StringUtil.isNotEmpty(ayKcxxEntitys.getId())) {
                    AyKcxxEntity t =systemService.get(AyKcxxEntity.class, ayKcxxEntitys.getId());
                    try {
                        message = "更新成功";
                        MyBeanUtils.copyBeanNotNull2Bean(ayKcxxEntitys, t);
                        systemService.saveOrUpdate(t);
                        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    message = "添加成功";
                    systemService.save(ayKcxxEntitys);
                    systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
                }
            }
//                systemService.updateBySqlString("update AY_SJPZ set tjzt = 1 where id=" + "'"+ayKcxxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
                systemService.updateBySqlString("update AY_JXSJ set tjzt1 = 1 where id=" + "'"+ayKcxxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
            
                
            //修改课时后，修改对应的绩效信息，并修改工资
            List<AyJxEntity> ayJxEntityList=systemService.findHql("FROM AyJxEntity where sjpzid=? and zxbm=?",sjpzid,zxid);
            
            if(ayJxEntityList!=null){
            	for (AyJxEntity ayJxEntity : ayJxEntityList) {
            		float kszs_f = 0;
    				
    				//查询该月份课程信息
    				//先查对应月份的时间ID，再根据ID，用户，计算出 课时总数
//    				List<AySjpzEntity> aySjpzEntitylist=systemService.findHql("from AySjpzEntity where 1=1 and zxbm=? and year=? and month =?",zxid,ayJxsjEntity.getYear(),ayJxsjEntity.getMonth());
    				List<AyJxsjEntity> aySjpzEntitylist=systemService.findHql("from AyJxsjEntity where 1=1 and zxbm=? and year=? and month =?",zxid,ayJxsjEntity.getYear(),ayJxsjEntity.getMonth());
    				if(aySjpzEntitylist!=null){
    					if(aySjpzEntitylist.size()==1){
    						AyJxsjEntity aySjpzEntity = aySjpzEntitylist.get(0);
    						List<AyKcxxEntity> ayKcxxEntityList=systemService.findHql("from AyKcxxEntity where 1=1 and zxbm=? and sjpzid=? and ygxxid =?",aySjpzEntity.getZxbm(),aySjpzEntity.getId(),ayJxEntity.getYgxxid());
    						for (AyKcxxEntity ayKcxxEntity1 : ayKcxxEntityList) {
    							String kchj_s = ayKcxxEntity1.getKchj();
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
    				
    				systemService.saveOrUpdate(ayJxEntity);
				}
            	
            }
            
            //修改工资
            List<AyGzEntity> ayGzEntityList1 = systemService.findHql("FROM AyGzEntity where sjpzid=? and zxbm=?", sjpzid, zxid);
            for (AyGzEntity ayGzEntity : ayGzEntityList1) {
            	List<AyJxEntity> ayJxEntitylist = systemService.findHql("FROM AyJxEntity where sjpzid =? and ygxxid =? and zxbm = ?", ayJxsjEntity.getId(), ayGzEntity.getYgxxid(),ayJxsjEntity.getZxbm());
        		if(ayJxEntitylist!=null){
        			if(ayJxEntitylist.size()==1){
        				AyJxEntity ayJxEntity = ayJxEntitylist.get(0);
        				//设置绩效工资(对应绩效里的达标奖金)
        				ayGzEntity.setJxgz(ayJxEntity.getDbjj());
        				//设置课时奖励(对应绩效里的课时费合计)
        				ayGzEntity.setKsjl(ayJxEntity.getKsfhj());
        			}
        		}
        		systemService.saveOrUpdate(ayGzEntity);
			}
            systemService.updateBySqlString("update AY_JXSJ set tjzt6 = 0 where id=" + "'"+ayKcxxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
            
        }
        return j;
    }
    
    
    /**
     * 保存新增/更新的行数据
     * @param page
     * @return
     */
    @RequestMapping(params = "submitRows")
    @ResponseBody
    public AjaxJson submitRows(AyKcxxEntityPage page, HttpServletRequest request){
        String message = null;
        String kcxs = request.getParameter("kcxs");
        List<AyKcxxEntity> ayKcxxEntity=page.getDemos();
        AjaxJson j = new AjaxJson();
        if(CollectionUtils.isNotEmpty(ayKcxxEntity)){
            for(AyKcxxEntity ayKcxxEntitys:ayKcxxEntity){
                if (StringUtil.isNotEmpty(ayKcxxEntitys.getId())) {
                    AyKcxxEntity t =systemService.get(AyKcxxEntity.class, ayKcxxEntitys.getId());
                    try {
                        message = "提交成功";
                        MyBeanUtils.copyBeanNotNull2Bean(ayKcxxEntitys, t);
                        systemService.saveOrUpdate(t);
                        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    message = "提交成功";
                    systemService.save(ayKcxxEntitys);
                    systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
                }
            }
//                systemService.updateBySqlString("update AY_SJPZ set tjzt = 1 where id=" + "'"+ayKcxxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
                systemService.updateBySqlString("update AY_JXSJ set tjzt1 = 2 where id=" + "'"+ayKcxxEntity.get(0).getSjpzid()+"'");//更新当月的提交状态
        }
        return j;
    }
    

}
