package com.buss.kqxx.service.impl;
import com.buss.kqxx.service.AyKqxxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.kqxx.entity.AyKqxxEntity;
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

@Service("ayKqxxService")
@Transactional
public class AyKqxxServiceImpl extends CommonServiceImpl implements AyKqxxServiceI {

	
 	public void delete(AyKqxxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(AyKqxxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AyKqxxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(AyKqxxEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(AyKqxxEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(AyKqxxEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(AyKqxxEntity t){
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
		map.put("yglx", t.getYglx());
		map.put("dyycq", t.getDyycq());
		map.put("sjcq", t.getSjcq());
		map.put("cc", t.getCc());
		map.put("jxr", t.getJxr());
		map.put("cb", t.getCb());
		map.put("jtb", t.getJtb());
		map.put("zfbtbz", t.getZfbtbz());
		map.put("zfb", t.getZfb());
		map.put("fdj", t.getFdj());
		map.put("wrz", t.getWrz());
		map.put("bj", t.getBj());
		map.put("sj", t.getSj());
		map.put("tx", t.getTx());
		map.put("dxnj", t.getDxnj());
		map.put("dnnj", t.getDnnj());
		map.put("dnsynj", t.getDnsynj());
		map.put("jbrq", t.getJbrq());
		map.put("jbsy", t.getJbsy());
		map.put("jbts", t.getJbts());
		map.put("syjb", t.getSyjb());
		map.put("bz", t.getBz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,AyKqxxEntity t){
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
 		sql  = sql.replace("#{yglx}",String.valueOf(t.getYglx()));
 		sql  = sql.replace("#{dyycq}",String.valueOf(t.getDyycq()));
 		sql  = sql.replace("#{sjcq}",String.valueOf(t.getSjcq()));
 		sql  = sql.replace("#{cc}",String.valueOf(t.getCc()));
 		sql  = sql.replace("#{jxr}",String.valueOf(t.getJxr()));
 		sql  = sql.replace("#{cb}",String.valueOf(t.getCb()));
 		sql  = sql.replace("#{jtb}",String.valueOf(t.getJtb()));
 		sql  = sql.replace("#{zfbtbz}",String.valueOf(t.getZfbtbz()));
 		sql  = sql.replace("#{zfb}",String.valueOf(t.getZfb()));
 		sql  = sql.replace("#{fdj}",String.valueOf(t.getFdj()));
 		sql  = sql.replace("#{wrz}",String.valueOf(t.getWrz()));
 		sql  = sql.replace("#{bj}",String.valueOf(t.getBj()));
 		sql  = sql.replace("#{sj}",String.valueOf(t.getSj()));
 		sql  = sql.replace("#{tx}",String.valueOf(t.getTx()));
 		sql  = sql.replace("#{dxnj}",String.valueOf(t.getDxnj()));
 		sql  = sql.replace("#{dnnj}",String.valueOf(t.getDnnj()));
 		sql  = sql.replace("#{dnsynj}",String.valueOf(t.getDnsynj()));
 		sql  = sql.replace("#{jbrq}",String.valueOf(t.getJbrq()));
 		sql  = sql.replace("#{jbsy}",String.valueOf(t.getJbsy()));
 		sql  = sql.replace("#{jbts}",String.valueOf(t.getJbts()));
 		sql  = sql.replace("#{syjb}",String.valueOf(t.getSyjb()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
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