package com.buss.jx.service.impl;
import com.buss.jx.service.AyJxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.jx.entity.AyJxEntity;
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

@Service("ayJxService")
@Transactional
public class AyJxServiceImpl extends CommonServiceImpl implements AyJxServiceI {

	
 	public void delete(AyJxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyJxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyJxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyJxEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyJxEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyJxEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyJxEntity t){
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
		map.put("sjkszs", t.getSjkszs());
		map.put("jxxs", t.getJxxs());
		map.put("jxkss", t.getJxkss());
		map.put("cpep", t.getCpep());
		map.put("cpgxs", t.getCpgxs());
		map.put("cpgks", t.getCpgks());
		map.put("vbpg", t.getVbpg());
		map.put("vpgxs", t.getVpgxs());
		map.put("vpgks", t.getVpgks());
		map.put("kszs", t.getKszs());
		map.put("dbkss", t.getDbkss());
		map.put("dbjj", t.getDbjj());
		map.put("cckss", t.getCckss());
		map.put("dydkss", t.getDydkss());
		map.put("ksf", t.getKsf());
		map.put("ksjj", t.getKsjj());
		map.put("dedkss2", t.getDedkss2());
		map.put("ksf2", t.getKsf2());
		map.put("ksjj2", t.getKsjj2());
		map.put("dsdkss3", t.getDsdkss3());
		map.put("ksf3", t.getKsf3());
		map.put("ksjj3", t.getKsjj3());
		map.put("ksfhj", t.getKsfhj());
		map.put("zxbm", t.getZxbm());
		map.put("sjpzid", t.getSjpzid());
		map.put("ygxxid", t.getYgxxid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,AyJxEntity t){
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
 		sql  = sql.replace("#{sjkszs}",String.valueOf(t.getSjkszs()));
 		sql  = sql.replace("#{jxxs}",String.valueOf(t.getJxxs()));
 		sql  = sql.replace("#{jxkss}",String.valueOf(t.getJxkss()));
 		sql  = sql.replace("#{cpep}",String.valueOf(t.getCpep()));
 		sql  = sql.replace("#{cpgxs}",String.valueOf(t.getCpgxs()));
 		sql  = sql.replace("#{cpgks}",String.valueOf(t.getCpgks()));
 		sql  = sql.replace("#{vbpg}",String.valueOf(t.getVbpg()));
 		sql  = sql.replace("#{vpgxs}",String.valueOf(t.getVpgxs()));
 		sql  = sql.replace("#{vpgks}",String.valueOf(t.getVpgks()));
 		sql  = sql.replace("#{kszs}",String.valueOf(t.getKszs()));
 		sql  = sql.replace("#{dbkss}",String.valueOf(t.getDbkss()));
 		sql  = sql.replace("#{dbjj}",String.valueOf(t.getDbjj()));
 		sql  = sql.replace("#{cckss}",String.valueOf(t.getCckss()));
 		sql  = sql.replace("#{dydkss}",String.valueOf(t.getDydkss()));
 		sql  = sql.replace("#{ksf}",String.valueOf(t.getKsf()));
 		sql  = sql.replace("#{ksjj}",String.valueOf(t.getKsjj()));
 		sql  = sql.replace("#{dedkss2}",String.valueOf(t.getDedkss2()));
 		sql  = sql.replace("#{ksf2}",String.valueOf(t.getKsf2()));
 		sql  = sql.replace("#{ksjj2}",String.valueOf(t.getKsjj2()));
 		sql  = sql.replace("#{dsdkss3}",String.valueOf(t.getDsdkss3()));
 		sql  = sql.replace("#{ksf3}",String.valueOf(t.getKsf3()));
 		sql  = sql.replace("#{ksjj3}",String.valueOf(t.getKsjj3()));
 		sql  = sql.replace("#{ksfhj}",String.valueOf(t.getKsfhj()));
 		sql  = sql.replace("#{zxbm}",String.valueOf(t.getZxbm()));
 		sql  = sql.replace("#{sjpzid}",String.valueOf(t.getSjpzid()));
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