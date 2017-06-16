package com.buss.kcxx.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 课程信息
 * @author caozengling
 * @date 2017-03-14 14:28:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_KCXX", schema = "")
@SuppressWarnings("serial")
public class AyKcxxEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**课程名*/
	@Excel(name="课程名")
	private java.lang.String kcmc;
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String xm;
	/**姓名*/
	@Excel(name="身份证号")
	private java.lang.String sfzh;
	
	@Excel(name="个人合计")
	private java.lang.String grhj;
	/**课程系数*/
	@Excel(name="课程系数")
	private java.lang.String kcxs;
	/**课程时间*/
	@Excel(name="课程时间")
	private java.lang.String kcsj;
	/**课程合计*/
	@Excel(name="课程合计")
	private java.lang.String kchj;
	/**员工基本信息id*/
	@Excel(name="员工基本信息id")
	private java.lang.String ygxxid;
	/**时间配置id*/
	@Excel(name="课程时间")
	private java.lang.String sjpzid;
	/**中心*/
	@Excel(name="中心")
	private java.lang.String zxbm;
	
	

	
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
	 *@return: java.lang.String  课程名
	 */
	@Column(name ="KCMC",nullable=true,length=32)
	public java.lang.String getKcmc(){
		return this.kcmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程名
	 */
	public void setKcmc(java.lang.String kcmc){
		this.kcmc = kcmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程系数
	 */
	@Column(name ="KCXS",nullable=true,length=32)
	public java.lang.String getKcxs(){
		return this.kcxs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程系数
	 */
	public void setKcxs(java.lang.String kcxs){
		this.kcxs = kcxs;
	}

	public String getYgxxid() {
		return ygxxid;
	}

	public void setYgxxid(String ygxxid) {
		this.ygxxid = ygxxid;
	}

	public String getKcsj() {
		return kcsj;
	}

	public void setKcsj(String kcsj) {
		this.kcsj = kcsj;
	}

	public String getSjpzid() {
		return sjpzid;
	}

	public void setSjpzid(String sjpzid) {
		this.sjpzid = sjpzid;
	}

	public String getKchj() {
		return kchj;
	}

	public void setKchj(String kchj) {
		this.kchj = kchj;
	}

	public String getZxbm() {
		return zxbm;
	}

	public void setZxbm(String zxbm) {
		this.zxbm = zxbm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public java.lang.String getGrhj() {
		return grhj;
	}

	public void setGrhj(java.lang.String grhj) {
		this.grhj = grhj;
	}
	
	
}
