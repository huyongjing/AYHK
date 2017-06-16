package com.buss.lwgz.service.impl;
import com.buss.lwgz.service.AyLwgzServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.lwgz.entity.AyLwgzEntity;
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

@Service("ayLwgzService")
@Transactional
public class AyLwgzServiceImpl extends CommonServiceImpl implements AyLwgzServiceI {

	
 	public void delete(AyLwgzEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyLwgzEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyLwgzEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyLwgzEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyLwgzEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyLwgzEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyLwgzEntity t){
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
		map.put("sfzh", t.getSfzh());
		map.put("jbgz", t.getJbgz());
		map.put("bt", t.getBt());
		map.put("hj", t.getHj());
		map.put("mze", t.getMze());
		map.put("snssde", t.getSnssde());
		map.put("sl", t.getSl());
		map.put("grsds", t.getGrsds());
		map.put("shgz", t.getShgz());
		map.put("qt", t.getQt());
		map.put("sfgz", t.getSfgz());
		map.put("yhzh", t.getYhzh());
		map.put("sjpzid", t.getSjpzid());
		map.put("zxbm", t.getZxbm());
		map.put("ygxxid", t.getYgxxid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,AyLwgzEntity t){
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
 		sql  = sql.replace("#{sfzh}",String.valueOf(t.getSfzh()));
 		sql  = sql.replace("#{jbgz}",String.valueOf(t.getJbgz()));
 		sql  = sql.replace("#{bt}",String.valueOf(t.getBt()));
 		sql  = sql.replace("#{hj}",String.valueOf(t.getHj()));
 		sql  = sql.replace("#{mze}",String.valueOf(t.getMze()));
 		sql  = sql.replace("#{snssde}",String.valueOf(t.getSnssde()));
 		sql  = sql.replace("#{sl}",String.valueOf(t.getSl()));
 		sql  = sql.replace("#{grsds}",String.valueOf(t.getGrsds()));
 		sql  = sql.replace("#{shgz}",String.valueOf(t.getShgz()));
 		sql  = sql.replace("#{qt}",String.valueOf(t.getQt()));
 		sql  = sql.replace("#{sfgz}",String.valueOf(t.getSfgz()));
 		sql  = sql.replace("#{yhzh}",String.valueOf(t.getYhzh()));
 		sql  = sql.replace("#{sjpzid}",String.valueOf(t.getSjpzid()));
 		sql  = sql.replace("#{zxbm}",String.valueOf(t.getZxbm()));
 		sql  = sql.replace("#{ygxxid}",String.valueOf(t.getYgxxid()));
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