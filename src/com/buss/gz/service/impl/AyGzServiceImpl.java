package com.buss.gz.service.impl;
import com.buss.gz.service.AyGzServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.gz.entity.AyGzEntity;
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

@Service("ayGzService")
@Transactional
public class AyGzServiceImpl extends CommonServiceImpl implements AyGzServiceI {

	
 	public void delete(AyGzEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyGzEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyGzEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyGzEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyGzEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyGzEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyGzEntity t){
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
		map.put("gw", t.getGw());
		map.put("yglx", t.getYglx());
		map.put("sfzh", t.getSfzh());
		map.put("jbgz", t.getJbgz());
		map.put("gwgz", t.getGwgz());
		map.put("zcgz", t.getZcgz());
		map.put("nzgz", t.getNzgz());
		map.put("jxgz", t.getJxgz());
		map.put("gljx", t.getGljx());
		map.put("ksjl", t.getKsjl());
		map.put("qqj", t.getQqj());
		map.put("qqkk", t.getQqkk());
		map.put("cfbz", t.getCfbz());
		map.put("jtbz", t.getJtbz());
		map.put("zfbz", t.getZfbz());
		map.put("yfgzze", t.getYfgzze());
		map.put("ylbxjs", t.getYlbxjs());
		map.put("qtsxjs", t.getQtsxjs());
		map.put("gjjjs", t.getGjjjs());
		map.put("ylbxgscd", t.getYlbxgscd());
		map.put("sybxgscdbf1", t.getSybxgscdbf1());
		map.put("ylbxgscdbf1", t.getYlbxgscdbf1());
		map.put("gsbxgscdbf", t.getGsbxgscdbf());
		map.put("sybxgscdbf", t.getSybxgscdbf());
		map.put("zfgjjgscdbf", t.getZfgjjgscdbf());
		map.put("ylbxgrcdbf", t.getYlbxgrcdbf());
		map.put("sybxgrcdbf2", t.getSybxgrcdbf2());
		map.put("ylbxgrcdbf2", t.getYlbxgrcdbf2());
		map.put("gsylbc", t.getGsylbc());
		map.put("zfgjjgrcdbf", t.getZfgjjgrcdbf());
		map.put("gscdhj", t.getGscdhj());
		map.put("grcdhj", t.getGrcdhj());
		map.put("ynssde", t.getYnssde());
		map.put("mze", t.getMze());
		map.put("snssde", t.getSnssde());
		map.put("sl", t.getSl());
		map.put("sskc", t.getSskc());
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
 	public String replaceVal(String sql,AyGzEntity t){
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
 		sql  = sql.replace("#{gw}",String.valueOf(t.getGw()));
 		sql  = sql.replace("#{yglx}",String.valueOf(t.getYglx()));
 		sql  = sql.replace("#{sfzh}",String.valueOf(t.getSfzh()));
 		sql  = sql.replace("#{jbgz}",String.valueOf(t.getJbgz()));
 		sql  = sql.replace("#{gwgz}",String.valueOf(t.getGwgz()));
 		sql  = sql.replace("#{zcgz}",String.valueOf(t.getZcgz()));
 		sql  = sql.replace("#{nzgz}",String.valueOf(t.getNzgz()));
 		sql  = sql.replace("#{jxgz}",String.valueOf(t.getJxgz()));
 		sql  = sql.replace("#{gljx}",String.valueOf(t.getGljx()));
 		sql  = sql.replace("#{ksjl}",String.valueOf(t.getKsjl()));
 		sql  = sql.replace("#{qqj}",String.valueOf(t.getQqj()));
 		sql  = sql.replace("#{qqkk}",String.valueOf(t.getQqkk()));
 		sql  = sql.replace("#{cfbz}",String.valueOf(t.getCfbz()));
 		sql  = sql.replace("#{jtbz}",String.valueOf(t.getJtbz()));
 		sql  = sql.replace("#{zfbz}",String.valueOf(t.getZfbz()));
 		sql  = sql.replace("#{yfgzze}",String.valueOf(t.getYfgzze()));
 		sql  = sql.replace("#{ylbxjs}",String.valueOf(t.getYlbxjs()));
 		sql  = sql.replace("#{qtsxjs}",String.valueOf(t.getQtsxjs()));
 		sql  = sql.replace("#{gjjjs}",String.valueOf(t.getGjjjs()));
 		sql  = sql.replace("#{ylbxgscd}",String.valueOf(t.getYlbxgscd()));
 		sql  = sql.replace("#{sybxgscdbf1}",String.valueOf(t.getSybxgscdbf1()));
 		sql  = sql.replace("#{ylbxgscdbf1}",String.valueOf(t.getYlbxgscdbf1()));
 		sql  = sql.replace("#{gsbxgscdbf}",String.valueOf(t.getGsbxgscdbf()));
 		sql  = sql.replace("#{sybxgscdbf}",String.valueOf(t.getSybxgscdbf()));
 		sql  = sql.replace("#{zfgjjgscdbf}",String.valueOf(t.getZfgjjgscdbf()));
 		sql  = sql.replace("#{ylbxgrcdbf}",String.valueOf(t.getYlbxgrcdbf()));
 		sql  = sql.replace("#{sybxgrcdbf2}",String.valueOf(t.getSybxgrcdbf2()));
 		sql  = sql.replace("#{ylbxgrcdbf2}",String.valueOf(t.getYlbxgrcdbf2()));
 		sql  = sql.replace("#{gsylbc}",String.valueOf(t.getGsylbc()));
 		sql  = sql.replace("#{zfgjjgrcdbf}",String.valueOf(t.getZfgjjgrcdbf()));
 		sql  = sql.replace("#{gscdhj}",String.valueOf(t.getGscdhj()));
 		sql  = sql.replace("#{grcdhj}",String.valueOf(t.getGrcdhj()));
 		sql  = sql.replace("#{ynssde}",String.valueOf(t.getYnssde()));
 		sql  = sql.replace("#{mze}",String.valueOf(t.getMze()));
 		sql  = sql.replace("#{snssde}",String.valueOf(t.getSnssde()));
 		sql  = sql.replace("#{sl}",String.valueOf(t.getSl()));
 		sql  = sql.replace("#{sskc}",String.valueOf(t.getSskc()));
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