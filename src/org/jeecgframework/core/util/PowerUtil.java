package org.jeecgframework.core.util;

import java.util.List;

import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
import org.jeecgframework.web.system.service.SystemService;

/**
 * 权限工具类
 * @author wanlian
 *
 */
public class PowerUtil {
	/**
	 * 一般用户 ，无任何权限 0
	 */
	public static int  ROLE_USER = 0;
	/**
	 * 分区用户 ，查看、填报权限 1
	 */
	public static int  ROLE_FX_USER = 1;
	/**
	 * 分区用户 ，查看、填报 、审核权限 2
	 */
	public static int  ROLE_JJH = 2;
	/**
	 * 超级管理员  所有权限 3
	 */
	public static int  ROLE_SYSADMIN = 3;
	
	/**
	 * 无所属分区
	 */
	public static String  NON_FQ = "NO";
	
	
	/**
	 * 全部所属分区
	 */
	public static String  ALL_FQ = "ALL";
	
	
	private static SystemService getSystemService() {
		SystemService systemService = ApplicationContextUtil.getContext().getBean(SystemService.class);

		return systemService;
	}
	
	 /**
     * 获取当前人id
     * @return
     */
	public static String getCurrUserId() {
		TSUser user = ResourceUtil.getSessionUserName();
		return user.getId();
	}
	 /**
     * 获取当前真实姓名
     * @return
     */
	public static String getCurrRealName() {
		TSUser user = ResourceUtil.getSessionUserName();
		return user.getRealName();
	}
	
	
	
	 /**
     * 获取当前名称
     * @return
     */
	public static String getCurrUserName() {
		TSUser user = ResourceUtil.getSessionUserName();
		return user.getUserName();
	}
		
	/**
     * 获取当前人机构
     * @return
     */
	public static String getCurrdepartIds() {
		//String departs = "";
		TSUser user = ResourceUtil.getSessionUserName();
		TSDepart depart = user.getCurrentDepart();
		/*
		 * List<TSUserOrg> userOrgs = user.getUserOrgList();
		 * if(userOrgs!=null&&userOrgs.size()>0){ for (TSUserOrg org : userOrgs)
		 * { departs = departs + "," + org.getId(); }
		 * 
		 * } if (departs.length() > 0) { departs = departs.substring(1); }
		 */
		return depart.getOrgCode();
	}
	
	  /**
     * 获取当前人角色
     * @return
     */
	public static String getCurrRoleIds() {
		SystemService systemService = getSystemService();
		String roles = "";
		String userid = getCurrUserId();
		List<TSRoleUser> roleUsers = systemService.findHql("from TSRoleUser where userid = ? ", userid);
		for (TSRoleUser role : roleUsers) {
			//roles = roles + "," + role.getId();
			roles = roles + "," + role.getTSRole().getRoleCode();
		}
		if (roles.length() > 0) {
			roles = roles.substring(1);
		}
		return roles;
	}
	
	/**
	 * 获取当前用户角色等级
	 * @return
	 */
	public static  int  getPowerLevel(){
		String roles = getCurrRoleIds().toUpperCase();
		roles = "," + roles + ",";
		if(roles.contains(",ADMIN,")||roles.contains(",DEV,")){
			return  ROLE_SYSADMIN;
		}else if(roles.contains(",AY_GLRY,")){
			return  ROLE_JJH;
		}else if(roles.contains(",AY_ZX,")){
			return  ROLE_FX_USER;
		}
		return ROLE_USER;
	}

	
	/**
	 * 获取当前用户所属分区
	 * @return
	 */
	public static  String   getFQ(){
		int level = getPowerLevel();
		if(level > ROLE_FX_USER){
			return ALL_FQ;
		}else if(level==ROLE_FX_USER){
			return getCurrdepartIds();
		}		
		return NON_FQ;
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	private static TSUser getCurrUser(){
		TSUser currUser = null;
		try{
			currUser = ResourceUtil.getSessionUserName();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		return currUser;
		
	}
	

}
