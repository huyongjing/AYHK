package com.buss.jxsj.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 绩效时间表
 * @author caozengling
 * @date 2017-03-23 11:19:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_JXSJ", schema = "")
@SuppressWarnings("serial")
public class AyJxsjEntity implements java.io.Serializable {
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
	/**年份*/
	@Excel(name="年份")
	private java.lang.String year;
	/**月份*/
	@Excel(name="月份")
	private java.lang.String month;
	/**中心*/
	@Excel(name="中心")
	private java.lang.String zxbm;
	/**提交状态*/
	@Excel(name="提交状态")
	private java.lang.String tjzt;
	@Excel(name="达标课时数")
	private java.lang.String dbkss;
	@Excel(name="课时费")
	private java.lang.String ksf;
	@Excel(name="课时费")
	private java.lang.String ksf2;
	@Excel(name="课时费")
	private java.lang.String ksf3;
	private java.lang.String dbjj;
	
	private java.lang.String ckqx;
	
	
	/**当月应出勤*/
	private java.lang.String dyycq;
	/** 法定假期*/
	private java.lang.String fdj;
	/**餐费补助*/
	private java.lang.String cf;
	/**交通补助*/
	private java.lang.String jt;
	
	@Excel(name="提交状态")
	private java.lang.String tjzt1;
	@Excel(name="提交状态")
	private java.lang.String tjzt2;
	@Excel(name="提交状态")
	private java.lang.String tjzt3;
	@Excel(name="提交状态")
	private java.lang.String tjzt4;
	@Excel(name="提交状态")
	private java.lang.String tjzt5;
	@Excel(name="提交状态")
	private java.lang.String tjzt6;
	
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
	 *@return: java.lang.String  年份
	 */
	@Column(name ="YEAR",nullable=true,length=32)
	public java.lang.String getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年份
	 */
	public void setYear(java.lang.String year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月份
	 */
	@Column(name ="MONTH",nullable=true,length=32)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中心
	 */
	@Column(name ="ZXBM",nullable=true,length=32)
	public java.lang.String getZxbm(){
		return this.zxbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中心
	 */
	public void setZxbm(java.lang.String zxbm){
		this.zxbm = zxbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交状态
	 */
	@Column(name ="TJZT",nullable=true,length=32)
	public java.lang.String getTjzt(){
		return this.tjzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交状态
	 */
	public void setTjzt(java.lang.String tjzt){
		this.tjzt = tjzt;
	}
	@Column(name ="KSF",nullable=true,length=32)
	public java.lang.String getKsf() {
		return ksf;
	}

	public void setKsf(java.lang.String ksf) {
		this.ksf = ksf;
	}
	@Column(name ="KSF2",nullable=true,length=32)
	public java.lang.String getKsf2() {
		return ksf2;
	}

	public void setKsf2(java.lang.String ksf2) {
		this.ksf2 = ksf2;
	}
	@Column(name ="KSF3",nullable=true,length=32)
	public java.lang.String getKsf3() {
		return ksf3;
	}

	public void setKsf3(java.lang.String ksf3) {
		this.ksf3 = ksf3;
	}
	@Column(name ="DBKSS",nullable=true,length=32)
	public java.lang.String getDbkss() {
		return dbkss;
	}

	public void setDbkss(java.lang.String dbkss) {
		this.dbkss = dbkss;
	}
	@Column(name ="DBJJ",nullable=true,length=32)
	public java.lang.String getDbjj() {
		return dbjj;
	}

	public void setDbjj(java.lang.String dbjj) {
		this.dbjj = dbjj;
	}

	public java.lang.String getDyycq() {
		return dyycq;
	}

	public void setDyycq(java.lang.String dyycq) {
		this.dyycq = dyycq;
	}

	public java.lang.String getFdj() {
		return fdj;
	}

	public void setFdj(java.lang.String fdj) {
		this.fdj = fdj;
	}

	public java.lang.String getCf() {
		return cf;
	}

	public void setCf(java.lang.String cf) {
		this.cf = cf;
	}

	public java.lang.String getJt() {
		return jt;
	}

	public void setJt(java.lang.String jt) {
		this.jt = jt;
	}

	public java.lang.String getTjzt1() {
		return tjzt1;
	}

	public void setTjzt1(java.lang.String tjzt1) {
		this.tjzt1 = tjzt1;
	}

	public java.lang.String getTjzt2() {
		return tjzt2;
	}

	public void setTjzt2(java.lang.String tjzt2) {
		this.tjzt2 = tjzt2;
	}

	public java.lang.String getTjzt3() {
		return tjzt3;
	}

	public void setTjzt3(java.lang.String tjzt3) {
		this.tjzt3 = tjzt3;
	}

	public java.lang.String getTjzt4() {
		return tjzt4;
	}

	public void setTjzt4(java.lang.String tjzt4) {
		this.tjzt4 = tjzt4;
	}

	public java.lang.String getTjzt5() {
		return tjzt5;
	}

	public void setTjzt5(java.lang.String tjzt5) {
		this.tjzt5 = tjzt5;
	}

	public java.lang.String getTjzt6() {
		return tjzt6;
	}

	public void setTjzt6(java.lang.String tjzt6) {
		this.tjzt6 = tjzt6;
	}

	public java.lang.String getCkqx() {
		return ckqx;
	}

	public void setCkqx(java.lang.String ckqx) {
		this.ckqx = ckqx;
	}
	
}
