package com.buss.ygjbxx.service.impl;
import com.buss.ygjbxx.service.AyYgjbxxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.ygjbxx.entity.AyYgjbxxEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("ayYgjbxxService")
@Transactional
public class AyYgjbxxServiceImpl extends CommonServiceImpl implements AyYgjbxxServiceI {

	
 	public void delete(AyYgjbxxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyYgjbxxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyYgjbxxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyYgjbxxEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyYgjbxxEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyYgjbxxEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyYgjbxxEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("xm", t.getXm());
		map.put("xb", t.getXb());
		map.put("sfzh", t.getSfzh());
		map.put("sr", t.getSr());
		map.put("zw", t.getZw());
		map.put("rzrq", t.getRzrq());
		map.put("zzzt", t.getZzzt());
		map.put("hyzk", t.getHyzk());
		map.put("shzt", t.getShzt());
		map.put("bz", t.getBz());
		map.put("txr", t.getTxr());
		map.put("tbsj", t.getTbsj());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,AyYgjbxxEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{xm}",String.valueOf(t.getXm()));
 		sql  = sql.replace("#{xb}",String.valueOf(t.getXb()));
 		sql  = sql.replace("#{sfzh}",String.valueOf(t.getSfzh()));
 		sql  = sql.replace("#{sr}",String.valueOf(t.getSr()));
 		sql  = sql.replace("#{zw}",String.valueOf(t.getZw()));
 		sql  = sql.replace("#{rzrq}",String.valueOf(t.getRzrq()));
 		sql  = sql.replace("#{zzzt}",String.valueOf(t.getZzzt()));
 		sql  = sql.replace("#{hyzk}",String.valueOf(t.getHyzk()));
 		sql  = sql.replace("#{shzt}",String.valueOf(t.getShzt()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{txr}",String.valueOf(t.getTxr()));
 		sql  = sql.replace("#{tbsj}",String.valueOf(t.getTbsj()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}