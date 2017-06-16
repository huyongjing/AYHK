package com.buss.tbxs.entity;

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
 * @Description: 填报系数
 * @author caozengling
 * @date 2017-03-20 17:29:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ay_tbxs", schema = "")
@SuppressWarnings("serial")
public class AyTbxsEntity implements java.io.Serializable {
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
	/**中心*/
	@Excel(name="中心")
	private java.lang.String zx;
	@Excel(name="户口类型")
	private java.lang.String hklx;
	/**养老保险公司承担部分*/
	@Excel(name="养老保险公司承担部分")
	private java.lang.String ylbxgscd;
	/**失业保险公司承担部分*/
	@Excel(name="失业保险公司承担部分")
	private java.lang.String sybxgscdbf1;
	/**医疗保险公司承担部分*/
	@Excel(name="医疗保险公司承担部分")
	private java.lang.String ylbxgscdbf1;
	/**工伤保险公司承担部分*/
	@Excel(name="工伤保险公司承担部分")
	private java.lang.String gsbxgscdbf;
	/**生育保险公司承担部分*/
	@Excel(name="生育保险公司承担部分")
	private java.lang.String sybxgscdbf;
	/**住房公积金公司承担部分*/
	@Excel(name="住房公积金公司承担部分")
	private java.lang.String zfgjjgscdbf;
	/**养老保险个人承担部分*/
	@Excel(name="养老保险个人承担部分")
	private java.lang.String ylbxgrcdbf;
	/**失业保险个人承担部分*/
	@Excel(name="失业保险个人承担部分")
	private java.lang.String sybxgrcdbf2;
	/**医疗保险个人承担部分*/
	@Excel(name="医疗保险个人承担部分")
	private java.lang.String ylbxgrcdbf2;
	/**工伤保险个人承担部分*/
	@Excel(name="工伤保险个人承担部分")
	private java.lang.String gsbxgrcdbf;
	/**生育保险个人承担部分*/
	@Excel(name="生育保险个人承担部分")
	private java.lang.String sybxgrcdbf;
	/**住房公积金个人承担部分*/
	@Excel(name="住房公积金个人承担部分")
	private java.lang.String zfgjjgrcdbf;
	/**个人医疗补充保险*/
	@Excel(name="个人医疗补充保险")
	private java.lang.String gsylbc;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	@Excel(name="系数类型")
	private java.lang.String xzxs;
	
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
	@Column(name ="CREATE_DATE",nullable=true)
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
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  中心
	 */
	@Column(name ="ZX",nullable=true,length=32)
	public java.lang.String getZx(){
		return this.zx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中心
	 */
	public void setZx(java.lang.String zx){
		this.zx = zx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  养老保险公司承担部分
	 */
	@Column(name ="YLBXGSCD",nullable=true,length=32)
	public java.lang.String getYlbxgscd(){
		return this.ylbxgscd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  养老保险公司承担部分
	 */
	public void setYlbxgscd(java.lang.String ylbxgscd){
		this.ylbxgscd = ylbxgscd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  失业保险公司承担部分
	 */
	@Column(name ="SYBXGSCDBF1",nullable=true,length=32)
	public java.lang.String getSybxgscdbf1(){
		return this.sybxgscdbf1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  失业保险公司承担部分
	 */
	public void setSybxgscdbf1(java.lang.String sybxgscdbf1){
		this.sybxgscdbf1 = sybxgscdbf1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医疗保险公司承担部分
	 */
	@Column(name ="YLBXGSCDBF1",nullable=true,length=32)
	public java.lang.String getYlbxgscdbf1(){
		return this.ylbxgscdbf1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医疗保险公司承担部分
	 */
	public void setYlbxgscdbf1(java.lang.String ylbxgscdbf1){
		this.ylbxgscdbf1 = ylbxgscdbf1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工伤保险公司承担部分
	 */
	@Column(name ="GSBXGSCDBF",nullable=true,length=32)
	public java.lang.String getGsbxgscdbf(){
		return this.gsbxgscdbf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工伤保险公司承担部分
	 */
	public void setGsbxgscdbf(java.lang.String gsbxgscdbf){
		this.gsbxgscdbf = gsbxgscdbf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生育保险公司承担部分
	 */
	@Column(name ="SYBXGSCDBF",nullable=true,length=32)
	public java.lang.String getSybxgscdbf(){
		return this.sybxgscdbf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生育保险公司承担部分
	 */
	public void setSybxgscdbf(java.lang.String sybxgscdbf){
		this.sybxgscdbf = sybxgscdbf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住房公积金公司承担部分
	 */
	@Column(name ="ZFGJJGSCDBF",nullable=true,length=32)
	public java.lang.String getZfgjjgscdbf(){
		return this.zfgjjgscdbf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房公积金公司承担部分
	 */
	public void setZfgjjgscdbf(java.lang.String zfgjjgscdbf){
		this.zfgjjgscdbf = zfgjjgscdbf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  养老保险个人承担部分
	 */
	@Column(name ="YLBXGRCDBF",nullable=true,length=32)
	public java.lang.String getYlbxgrcdbf(){
		return this.ylbxgrcdbf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  养老保险个人承担部分
	 */
	public void setYlbxgrcdbf(java.lang.String ylbxgrcdbf){
		this.ylbxgrcdbf = ylbxgrcdbf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  失业保险个人承担部分
	 */
	@Column(name ="SYBXGRCDBF2",nullable=true,length=32)
	public java.lang.String getSybxgrcdbf2(){
		return this.sybxgrcdbf2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  失业保险个人承担部分
	 */
	public void setSybxgrcdbf2(java.lang.String sybxgrcdbf2){
		this.sybxgrcdbf2 = sybxgrcdbf2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医疗保险个人承担部分
	 */
	@Column(name ="YLBXGRCDBF2",nullable=true,length=32)
	public java.lang.String getYlbxgrcdbf2(){
		return this.ylbxgrcdbf2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医疗保险个人承担部分
	 */
	public void setYlbxgrcdbf2(java.lang.String ylbxgrcdbf2){
		this.ylbxgrcdbf2 = ylbxgrcdbf2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住房公积金个人承担部分
	 */
	@Column(name ="ZFGJJGRCDBF",nullable=true,length=32)
	public java.lang.String getZfgjjgrcdbf(){
		return this.zfgjjgrcdbf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房公积金个人承担部分
	 */
	public void setZfgjjgrcdbf(java.lang.String zfgjjgrcdbf){
		this.zfgjjgrcdbf = zfgjjgrcdbf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人医疗补充保险
	 */
	@Column(name ="GSYLBC",nullable=true,length=32)
	public java.lang.String getGsylbc(){
		return this.gsylbc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人医疗补充保险
	 */
	public void setGsylbc(java.lang.String gsylbc){
		this.gsylbc = gsylbc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	@Column(name ="GSBXGRCDBF",nullable=true,length=32)
	public java.lang.String getGsbxgrcdbf() {
		return gsbxgrcdbf;
	}

	public void setGsbxgrcdbf(java.lang.String gsbxgrcdbf) {
		this.gsbxgrcdbf = gsbxgrcdbf;
	}
	@Column(name ="SYBXGRCDBF",nullable=true,length=32)
	public java.lang.String getSybxgrcdbf() {
		return sybxgrcdbf;
	}

	public void setSybxgrcdbf(java.lang.String sybxgrcdbf) {
		this.sybxgrcdbf = sybxgrcdbf;
	}
	@Column(name ="HKLX",nullable=true,length=32)
	public java.lang.String getHklx() {
		return hklx;
	}

	public void setHklx(java.lang.String hklx) {
		this.hklx = hklx;
	}

	public java.lang.String getXzxs() {
		return xzxs;
	}

	public void setXzxs(java.lang.String xzxs) {
		this.xzxs = xzxs;
	}
	
	
	
}
