package com.buss.shgjj.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 社会公积金
 * @author caozengling
 * @date 2017-03-20 17:54:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_SHGJJ", schema = "")
@SuppressWarnings("serial")
public class AyShgjjEntity implements java.io.Serializable {
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
	/**岗位*/
	@Excel(name="岗位")
	private java.lang.String gw;
	/**员工类型*/
	@Excel(name="员工类型")
	private java.lang.String yglx;
	/**养老保险基数*/
	@Excel(name="养老保险基数")
	private java.lang.String ylbxjs;
	/**其他四险基数*/
	@Excel(name="其他四险基数")
	private java.lang.String qtsxjs;
	/**公积金基数*/
	@Excel(name="公积金基数")
	private java.lang.String gjjjs;
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
	/**个人医疗补充保险*/
	@Excel(name="个人医疗补充保险")
	private java.lang.String gsylbc;
	/**住房公积金个人承担部分*/
	@Excel(name="住房公积金个人承担部分")
	private java.lang.String zfgjjgrcdbf;
	/**住房公积金合计*/
	@Excel(name="住房公积金合计")
	private java.lang.String zfgjjhj;
	/**保险合计*/
	@Excel(name="保险合计")
	private java.lang.String bxhj;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	/**中心*/
	@Excel(name="中心")
	private java.lang.String zxbm;
	/**员工id*/
	private java.lang.String ygxxid;
	/**时间id*/
	private java.lang.String sjpzid;
	
	/**工伤保险个人承担部分*/
	@Excel(name="工伤保险个人承担部分")
	private java.lang.String gsbxgrcdbf;
	/**生育保险个人承担部分*/
	@Excel(name="生育保险个人承担部分")
	private java.lang.String sybxgrcdbf;
	
	
	private java.lang.String yanglgsbili;
	private java.lang.String yilgsbili;
	private java.lang.String gongsgsbili;
	private java.lang.String shiygsbili;
	private java.lang.String shengygsbili;
	private java.lang.String gongjjgsbili;
	private java.lang.String yanglgrbili;
	private java.lang.String yilgrbili;
	private java.lang.String gongsgrbili;
	private java.lang.String shiygrbili;
	private java.lang.String shengygrbili;
	private java.lang.String gongjjgrbili;
	
	private java.lang.String hklx;
	
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
	 *@return: java.lang.String  岗位
	 */
	@Column(name ="GW",nullable=true,length=32)
	public java.lang.String getGw(){
		return this.gw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位
	 */
	public void setGw(java.lang.String gw){
		this.gw = gw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  员工类型
	 */
	@Column(name ="YGLX",nullable=true,length=32)
	public java.lang.String getYglx(){
		return this.yglx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  员工类型
	 */
	public void setYglx(java.lang.String yglx){
		this.yglx = yglx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  养老保险基数
	 */
	@Column(name ="YLBXJS",nullable=true,length=32)
	public java.lang.String getYlbxjs(){
		return this.ylbxjs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  养老保险基数
	 */
	public void setYlbxjs(java.lang.String ylbxjs){
		this.ylbxjs = ylbxjs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他四险基数
	 */
	@Column(name ="QTSXJS",nullable=true,length=32)
	public java.lang.String getQtsxjs(){
		return this.qtsxjs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他四险基数
	 */
	public void setQtsxjs(java.lang.String qtsxjs){
		this.qtsxjs = qtsxjs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公积金基数
	 */
	@Column(name ="GJJJS",nullable=true,length=32)
	public java.lang.String getGjjjs(){
		return this.gjjjs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公积金基数
	 */
	public void setGjjjs(java.lang.String gjjjs){
		this.gjjjs = gjjjs;
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
	 *@return: java.lang.String  住房公积金合计
	 */
	@Column(name ="ZFGJJHJ",nullable=true,length=32)
	public java.lang.String getZfgjjhj(){
		return this.zfgjjhj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房公积金合计
	 */
	public void setZfgjjhj(java.lang.String zfgjjhj){
		this.zfgjjhj = zfgjjhj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保险合计
	 */
	@Column(name ="BXHJ",nullable=true,length=32)
	public java.lang.String getBxhj(){
		return this.bxhj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保险合计
	 */
	public void setBxhj(java.lang.String bxhj){
		this.bxhj = bxhj;
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
	 *@return: java.lang.String  员工id
	 */
	@Column(name ="YGXXID",nullable=true,length=32)
	public java.lang.String getYgxxid(){
		return this.ygxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  员工id
	 */
	public void setYgxxid(java.lang.String ygxxid){
		this.ygxxid = ygxxid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  时间id
	 */
	@Column(name ="SJPZID",nullable=true,length=32)
	public java.lang.String getSjpzid(){
		return this.sjpzid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  时间id
	 */
	public void setSjpzid(java.lang.String sjpzid){
		this.sjpzid = sjpzid;
	}

	public String getGsylbc() {
		return gsylbc;
	}

	public void setGsylbc(String gsylbc) {
		this.gsylbc = gsylbc;
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
	@Column(name ="YANGLGSBILI",nullable=true,length=32)
	public java.lang.String getYanglgsbili() {
		return yanglgsbili;
	}

	public void setYanglgsbili(java.lang.String yanglgsbili) {
		this.yanglgsbili = yanglgsbili;
	}
	@Column(name ="YILGSBILI",nullable=true,length=32)
	public java.lang.String getYilgsbili() {
		return yilgsbili;
	}

	public void setYilgsbili(java.lang.String yilgsbili) {
		this.yilgsbili = yilgsbili;
	}
	@Column(name ="GONGSGSBILI",nullable=true,length=32)
	public java.lang.String getGongsgsbili() {
		return gongsgsbili;
	}

	public void setGongsgsbili(java.lang.String gongsgsbili) {
		this.gongsgsbili = gongsgsbili;
	}
	@Column(name ="SHIYGSBILI",nullable=true,length=32)
	public java.lang.String getShiygsbili() {
		return shiygsbili;
	}

	public void setShiygsbili(java.lang.String shiygsbili) {
		this.shiygsbili = shiygsbili;
	}
	@Column(name ="SHENGYGSBILI",nullable=true,length=32)
	public java.lang.String getShengygsbili() {
		return shengygsbili;
	}

	public void setShengygsbili(java.lang.String shengygsbili) {
		this.shengygsbili = shengygsbili;
	}
	@Column(name ="GONGJJGSBILI",nullable=true,length=32)
	public java.lang.String getGongjjgsbili() {
		return gongjjgsbili;
	}

	public void setGongjjgsbili(java.lang.String gongjjgsbili) {
		this.gongjjgsbili = gongjjgsbili;
	}
	@Column(name ="YANGLGRBILI",nullable=true,length=32)
	public java.lang.String getYanglgrbili() {
		return yanglgrbili;
	}

	public void setYanglgrbili(java.lang.String yanglgrbili) {
		this.yanglgrbili = yanglgrbili;
	}
	@Column(name ="YILGRBILI",nullable=true,length=32)
	public java.lang.String getYilgrbili() {
		return yilgrbili;
	}

	public void setYilgrbili(java.lang.String yilgrbili) {
		this.yilgrbili = yilgrbili;
	}
	@Column(name ="GONGSGRBILI",nullable=true,length=32)
	public java.lang.String getGongsgrbili() {
		return gongsgrbili;
	}

	public void setGongsgrbili(java.lang.String gongsgrbili) {
		this.gongsgrbili = gongsgrbili;
	}
	@Column(name ="SHIYGRBILI",nullable=true,length=32)
	public java.lang.String getShiygrbili() {
		return shiygrbili;
	}

	public void setShiygrbili(java.lang.String shiygrbili) {
		this.shiygrbili = shiygrbili;
	}
	@Column(name ="SHENGYGRBILI",nullable=true,length=32)
	public java.lang.String getShengygrbili() {
		return shengygrbili;
	}

	public void setShengygrbili(java.lang.String shengygrbili) {
		this.shengygrbili = shengygrbili;
	}
	@Column(name ="GONGJJGRBILI",nullable=true,length=32)
	public java.lang.String getGongjjgrbili() {
		return gongjjgrbili;
	}

	public void setGongjjgrbili(java.lang.String gongjjgrbili) {
		this.gongjjgrbili = gongjjgrbili;
	}
	@Column(name ="HKLX",nullable=true,length=32)
	public java.lang.String getHklx() {
		return hklx;
	}

	public void setHklx(java.lang.String hklx) {
		this.hklx = hklx;
	}
	
	
	
}
