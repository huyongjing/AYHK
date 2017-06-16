package com.buss.tbxs.service.impl;
import com.buss.tbxs.service.AyTbxsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.tbxs.entity.AyTbxsEntity;
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

@Service("ayTbxsService")
@Transactional
public class AyTbxsServiceImpl extends CommonServiceImpl implements AyTbxsServiceI {

	
 	public void delete(AyTbxsEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyTbxsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyTbxsEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyTbxsEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyTbxsEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyTbxsEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyTbxsEntity t){
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
		map.put("zx", t.getZx());
		map.put("ylbxgscd", t.getYlbxgscd());
		map.put("sybxgscdbf1", t.getSybxgscdbf1());
		map.put("ylbxgscdbf1", t.getYlbxgscdbf1());
		map.put("gsbxgscdbf", t.getGsbxgscdbf());
		map.put("sybxgscdbf", t.getSybxgscdbf());
		map.put("zfgjjgscdbf", t.getZfgjjgscdbf());
		map.put("ylbxgrcdbf", t.getYlbxgrcdbf());
		map.put("sybxgrcdbf2", t.getSybxgrcdbf2());
		map.put("ylbxgrcdbf2", t.getYlbxgrcdbf2());
		map.put("zfgjjgrcdbf", t.getZfgjjgrcdbf());
		map.put("gsylbc", t.getGsylbc());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,AyTbxsEntity t){
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
 		sql  = sql.replace("#{zx}",String.valueOf(t.getZx()));
 		sql  = sql.replace("#{ylbxgscd}",String.valueOf(t.getYlbxgscd()));
 		sql  = sql.replace("#{sybxgscdbf1}",String.valueOf(t.getSybxgscdbf1()));
 		sql  = sql.replace("#{ylbxgscdbf1}",String.valueOf(t.getYlbxgscdbf1()));
 		sql  = sql.replace("#{gsbxgscdbf}",String.valueOf(t.getGsbxgscdbf()));
 		sql  = sql.replace("#{sybxgscdbf}",String.valueOf(t.getSybxgscdbf()));
 		sql  = sql.replace("#{zfgjjgscdbf}",String.valueOf(t.getZfgjjgscdbf()));
 		sql  = sql.replace("#{ylbxgrcdbf}",String.valueOf(t.getYlbxgrcdbf()));
 		sql  = sql.replace("#{sybxgrcdbf2}",String.valueOf(t.getSybxgrcdbf2()));
 		sql  = sql.replace("#{ylbxgrcdbf2}",String.valueOf(t.getYlbxgrcdbf2()));
 		sql  = sql.replace("#{zfgjjgrcdbf}",String.valueOf(t.getZfgjjgrcdbf()));
 		sql  = sql.replace("#{gsylbc}",String.valueOf(t.getGsylbc()));
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