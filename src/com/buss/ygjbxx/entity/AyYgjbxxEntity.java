package com.buss.ygjbxx.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 员工基本信息
 * @author caozengling
 * @date 2017-03-07 15:58:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_YGJBXX", schema = "")
@SuppressWarnings("serial")
public class AyYgjbxxEntity implements java.io.Serializable {
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
	/**姓名*/
	@Excel(name="姓名")
	private java.lang.String xm;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String xb;
	/**员工类型*/
	@Excel(name="员工类型")
	private java.lang.String yglx;
	/**身份证号*/
	@Excel(name="身份证号")
	private java.lang.String sfzh;
	/**深户*/
	@Excel(name="户口类型")
	private java.lang.String sfsh;
	/**银行帐号*/
	@Excel(name="身份证号")
	private java.lang.String yhzh;
	/**生日*/
	@Excel(name="生日",format = "yyyy-MM-dd")
	private java.util.Date sr;
	/**职位*/
	@Excel(name="职位")
	private java.lang.String zw;
	/**入职日期*/
	@Excel(name="入职日期")
	private java.lang.String rzrq;
	/**在职状态*/
	@Excel(name="在职状态")
	private java.lang.String zzzt;
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String hyzk;
	/**住房补贴*/
	@Excel(name="住房补贴")
	private java.lang.String zfbt;
	/**审核状态*/
	@Excel(name="审核状态")
	private java.lang.String shzt;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	/**填写人*/
	@Excel(name="填写人")
	private java.lang.String txr;
	/**填表时间*/
	@Excel(name="填表时间",format = "yyyy-MM-dd")
	private java.util.Date tbsj;
	/**中心编码*/
	@Excel(name="中心编码")
	private java.lang.String zxbm;
	/**入职转正日期*/
	@Excel(name="入职转正日期")
	private java.lang.String rzzzrq;
	/**合同到期日*/
	@Excel(name="合同到期日")
	private java.lang.String htdqr;
	/**合同续签时间*/
	@Excel(name="合同续签时间")
	private java.lang.String htxqsj;
	/**基本工资*/
	@Excel(name="基本工资")
	private java.lang.String jbgz;
	/**岗位工资*/
	@Excel(name="岗位工资")
	private java.lang.String gwgz;
	/**职称工资*/
	@Excel(name="职称工资")
	private java.lang.String zcgz;
	/**年资工资*/
	@Excel(name="年资工资")
	private java.lang.String nzgz;
	/**绩效工资*/
	@Excel(name="绩效工资")
	private java.lang.String jxgz;
	@Excel(name="养老保险基数")
	private java.lang.String ylbxjs;
	/**其他四险基数*/
	@Excel(name="其他四险基数")
	private java.lang.String qtsxjs;
	/**公积金基数*/
	@Excel(name="公积金基数")
	private java.lang.String gjjjs;
	@Excel(name="选择系数")
	private java.lang.String xzxs;
	
	/** 餐费补贴*/
	private java.lang.String cfbz;
	/** 交通补贴*/
	private java.lang.String jtbz;
	/** 通讯补贴*/
	private java.lang.String txbz;
	/** 出差补贴*/
	private java.lang.String ccbz;
	/** 其他补贴*/
	private java.lang.String qtbt;
	/** 其他*/
	private java.lang.String qt;
	
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="XM",nullable=true,length=32)
	public java.lang.String getXm(){
		return this.xm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setXm(java.lang.String xm){
		this.xm = xm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="XB",nullable=true,length=32)
	public java.lang.String getXb(){
		return this.xb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setXb(java.lang.String xb){
		this.xb = xb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="SFZH",nullable=true,length=36)
	public java.lang.String getSfzh(){
		return this.sfzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setSfzh(java.lang.String sfzh){
		this.sfzh = sfzh;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生日
	 */
	@Column(name ="SR",nullable=true,length=32)
	public java.util.Date getSr(){
		return this.sr;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setSr(java.util.Date sr){
		this.sr = sr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位
	 */
	@Column(name ="ZW",nullable=true,length=32)
	public java.lang.String getZw(){
		return this.zw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位
	 */
	public void setZw(java.lang.String zw){
		this.zw = zw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入职日期
	 */
	@Column(name ="RZRQ",nullable=true,length=32)
	public java.lang.String getRzrq(){
		return this.rzrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入职日期
	 */
	public void setRzrq(java.lang.String rzrq){
		this.rzrq = rzrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在职状态
	 */
	@Column(name ="ZZZT",nullable=true,length=32)
	public java.lang.String getZzzt(){
		return this.zzzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在职状态
	 */
	public void setZzzt(java.lang.String zzzt){
		this.zzzt = zzzt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */
	@Column(name ="HYZK",nullable=true,length=32)
	public java.lang.String getHyzk(){
		return this.hyzk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setHyzk(java.lang.String hyzk){
		this.hyzk = hyzk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */
	@Column(name ="SHZT",nullable=true,length=32)
	public java.lang.String getShzt(){
		return this.shzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setShzt(java.lang.String shzt){
		this.shzt = shzt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=32)
	public java.lang.String getBz(){
		return this.bz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(java.lang.String bz){
		this.bz = bz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  填写人
	 */
	@Column(name ="TXR",nullable=true,length=32)
	public java.lang.String getTxr(){
		return this.txr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  填写人
	 */
	public void setTxr(java.lang.String txr){
		this.txr = txr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  填表时间
	 */
	@Column(name ="TBSJ",nullable=true,length=32)
	public java.util.Date getTbsj(){
		return this.tbsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  填表时间
	 */
	public void setTbsj(java.util.Date tbsj){
		this.tbsj = tbsj;
	}

	public String getZxbm() {
		return zxbm;
	}

	public void setZxbm(String zxbm) {
		this.zxbm = zxbm;
	}

	public String getZfbt() {
		return zfbt;
	}

	public void setZfbt(String zfbt) {
		this.zfbt = zfbt;
	}

	public String getYglx() {
		return yglx;
	}

	public void setYglx(String yglx) {
		this.yglx = yglx;
	}

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getSfsh() {
		return sfsh;
	}

	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}

	public String getRzzzrq() {
		return rzzzrq;
	}

	public void setRzzzrq(String rzzzrq) {
		this.rzzzrq = rzzzrq;
	}

	public String getHtdqr() {
		return htdqr;
	}

	public void setHtdqr(String htdqr) {
		this.htdqr = htdqr;
	}

	public String getHtxqsj() {
		return htxqsj;
	}

	public void setHtxqsj(String htxqsj) {
		this.htxqsj = htxqsj;
	}

	public String getJbgz() {
		return jbgz;
	}

	public void setJbgz(String jbgz) {
		this.jbgz = jbgz;
	}

	public String getGwgz() {
		return gwgz;
	}

	public void setGwgz(String gwgz) {
		this.gwgz = gwgz;
	}

	public String getZcgz() {
		return zcgz;
	}

	public void setZcgz(String zcgz) {
		this.zcgz = zcgz;
	}

	public String getNzgz() {
		return nzgz;
	}

	public void setNzgz(String nzgz) {
		this.nzgz = nzgz;
	}

	public String getJxgz() {
		return jxgz;
	}

	public void setJxgz(String jxgz) {
		this.jxgz = jxgz;
	}

	public java.lang.String getYlbxjs() {
		return ylbxjs;
	}

	public void setYlbxjs(java.lang.String ylbxjs) {
		this.ylbxjs = ylbxjs;
	}

	public java.lang.String getQtsxjs() {
		return qtsxjs;
	}

	public void setQtsxjs(java.lang.String qtsxjs) {
		this.qtsxjs = qtsxjs;
	}

	public java.lang.String getGjjjs() {
		return gjjjs;
	}

	public void setGjjjs(java.lang.String gjjjs) {
		this.gjjjs = gjjjs;
	}

	public java.lang.String getXzxs() {
		return xzxs;
	}

	public void setXzxs(java.lang.String xzxs) {
		this.xzxs = xzxs;
	}

	public java.lang.String getCfbz() {
		return cfbz;
	}

	public void setCfbz(java.lang.String cfbz) {
		this.cfbz = cfbz;
	}

	public java.lang.String getJtbz() {
		return jtbz;
	}

	public void setJtbz(java.lang.String jtbz) {
		this.jtbz = jtbz;
	}

	public java.lang.String getTxbz() {
		return txbz;
	}

	public void setTxbz(java.lang.String txbz) {
		this.txbz = txbz;
	}

	public java.lang.String getCcbz() {
		return ccbz;
	}

	public void setCcbz(java.lang.String ccbz) {
		this.ccbz = ccbz;
	}

	public java.lang.String getQtbt() {
		return qtbt;
	}

	public void setQtbt(java.lang.String qtbt) {
		this.qtbt = qtbt;
	}

	public java.lang.String getQt() {
		return qt;
	}

	public void setQt(java.lang.String qt) {
		this.qt = qt;
	}
	
	
}
