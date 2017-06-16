package com.buss.gsbz.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 个税标准
 * @author caozengling
 * @date 2017-03-07 19:14:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_GSBZ", schema = "")
@SuppressWarnings("serial")
public class AyGsbzEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**等级*/
	@Excel(name="等级")
	private java.lang.String dj;
	/**等级开始金额*/
	@Excel(name="等级开始金额")
	private java.lang.String ksje;
	/**等级结束金额*/
	@Excel(name="等级结束金额")
	private java.lang.String jsje;
	/**税率*/
	@Excel(name="税率")
	private java.lang.String sl;
	/**速算扣除数*/
	@Excel(name="速算扣除数")
	private java.lang.String sskcs;
	/**说明*/
	@Excel(name="说明")
	private java.lang.String sm;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级
	 */
	@Column(name ="DJ",nullable=true,length=32)
	public java.lang.String getDj(){
		return this.dj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级
	 */
	public void setDj(java.lang.String dj){
		this.dj = dj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  等级开始金额
	 */
	@Column(name ="KSJE",nullable=true,scale=2,length=32)
	public java.lang.String getKsje(){
		return this.ksje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  等级开始金额
	 */
	public void setKsje(java.lang.String ksje){
		this.ksje = ksje;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级结束金额
	 */
	@Column(name ="JSJE",nullable=true,length=32)
	public java.lang.String getJsje(){
		return this.jsje;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级结束金额
	 */
	public void setJsje(java.lang.String jsje){
		this.jsje = jsje;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  税率
	 */
	@Column(name ="SL",nullable=true,scale=2,length=32)
	public java.lang.String getSl(){
		return this.sl;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  税率
	 */
	public void setSl(java.lang.String sl){
		this.sl = sl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  速算扣除数
	 */
	@Column(name ="SSKCS",nullable=true,scale=2,length=32)
	public java.lang.String getSskcs(){
		return this.sskcs;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  速算扣除数
	 */
	public void setSskcs(java.lang.String sskcs){
		this.sskcs = sskcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  说明
	 */
	@Column(name ="SM",nullable=true,length=500)
	public java.lang.String getSm(){
		return this.sm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  说明
	 */
	public void setSm(java.lang.String sm){
		this.sm = sm;
	}
}
