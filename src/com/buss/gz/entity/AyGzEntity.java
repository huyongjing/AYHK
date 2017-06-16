package com.buss.gz.entity;

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
 * @Description: 工资表
 * @author caozengling
 * @date 2017-03-23 14:56:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_GZ", schema = "")
@SuppressWarnings("serial")
public class AyGzEntity implements java.io.Serializable {
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
	/**身份证号*/
	@Excel(name="身份证号")
	private java.lang.String sfzh;
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
	/**管理绩效*/
	@Excel(name="管理绩效")
	private java.lang.String gljx;
	/**课时奖励*/
	@Excel(name="课时奖励")
	private java.lang.String ksjl;
	/**全勤奖*/
	@Excel(name="全勤奖")
	private java.lang.String qqj;
	/**缺勤扣款*/
	@Excel(name="缺勤扣款")
	private java.lang.String qqkk;
	/**餐费补助*/
	@Excel(name="餐费补助")
	private java.lang.String cfbz;
	/**交通补助*/
	@Excel(name="交通补助")
	private java.lang.String jtbz;
	
	/**通讯补助*/
	@Excel(name="通讯补助")
	private java.lang.String txbz;
	/**出差补助*/
	@Excel(name="出差补助")
	private java.lang.String ccbz;
	
	
	/**住房补助*/
	@Excel(name="住房补助")
	private java.lang.String zfbz;
	/**应发工资总额*/
	@Excel(name="应发工资总额")
	private java.lang.String yfgzze;
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
	/**工伤保险个人承担部分*/
	@Excel(name="工伤保险个人承担部分")
	private java.lang.String gsbxgrcdbf;
	/**生育保险个人承担部分*/
	@Excel(name="生育保险个人承担部分")
	private java.lang.String sybxgrcdbf;
	/**个人医疗补充保险*/
	@Excel(name="个人医疗补充保险")
	private java.lang.String gsylbc;
	/**住房公积金个人承担部分*/
	@Excel(name="住房公积金个人承担部分")
	private java.lang.String zfgjjgrcdbf;
	/**公司承担合计*/
	@Excel(name="公司承担合计")
	private java.lang.String gscdhj;
	/**个人承担合计*/
	@Excel(name="个人承担合计")
	private java.lang.String grcdhj;
	/**应纳税所得额*/
	@Excel(name="应纳税所得额")
	private java.lang.String ynssde;
	/**免征额*/
	@Excel(name="免征额")
	private java.lang.String mze;
	/**实纳税所得额*/
	@Excel(name="实纳税所得额")
	private java.lang.String snssde;
	/**税率*/
	@Excel(name="税率")
	private java.lang.String sl;
	/**速算扣除*/
	@Excel(name="速算扣除")
	private java.lang.String sskc;
	/**个人所得税*/
	@Excel(name="个人所得税")
	private java.lang.String grsds;
	/**税后工资*/
	@Excel(name="税后工资")
	private java.lang.String shgz;
	/**其他*/
	@Excel(name="其他")
	private java.lang.String qt;
	/**实发工资*/
	@Excel(name="实发工资")
	private java.lang.String sfgz;
	/**银行帐号*/
	@Excel(name="银行帐号")
	private java.lang.String yhzh;
	/**时间id*/
	private java.lang.String sjpzid;
	/**中心*/
	private java.lang.String zxbm;
	/**员工id*/
	private java.lang.String ygxxid;
	
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
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="SFZH",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本工资
	 */
	@Column(name ="JBGZ",nullable=true,length=32)
	public java.lang.String getJbgz(){
		return this.jbgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本工资
	 */
	public void setJbgz(java.lang.String jbgz){
		this.jbgz = jbgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位工资
	 */
	@Column(name ="GWGZ",nullable=true,length=32)
	public java.lang.String getGwgz(){
		return this.gwgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位工资
	 */
	public void setGwgz(java.lang.String gwgz){
		this.gwgz = gwgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职称工资
	 */
	@Column(name ="ZCGZ",nullable=true,length=32)
	public java.lang.String getZcgz(){
		return this.zcgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称工资
	 */
	public void setZcgz(java.lang.String zcgz){
		this.zcgz = zcgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年资工资
	 */
	@Column(name ="NZGZ",nullable=true,length=32)
	public java.lang.String getNzgz(){
		return this.nzgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年资工资
	 */
	public void setNzgz(java.lang.String nzgz){
		this.nzgz = nzgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  绩效工资
	 */
	@Column(name ="JXGZ",nullable=true,length=32)
	public java.lang.String getJxgz(){
		return this.jxgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  绩效工资
	 */
	public void setJxgz(java.lang.String jxgz){
		this.jxgz = jxgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理绩效
	 */
	@Column(name ="GLJX",nullable=true,length=32)
	public java.lang.String getGljx(){
		return this.gljx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理绩效
	 */
	public void setGljx(java.lang.String gljx){
		this.gljx = gljx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时奖励
	 */
	@Column(name ="KSJL",nullable=true,length=32)
	public java.lang.String getKsjl(){
		return this.ksjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时奖励
	 */
	public void setKsjl(java.lang.String ksjl){
		this.ksjl = ksjl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  全勤奖
	 */
	@Column(name ="QQJ",nullable=true,length=32)
	public java.lang.String getQqj(){
		return this.qqj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  全勤奖
	 */
	public void setQqj(java.lang.String qqj){
		this.qqj = qqj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缺勤扣款
	 */
	@Column(name ="QQKK",nullable=true,length=32)
	public java.lang.String getQqkk(){
		return this.qqkk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缺勤扣款
	 */
	public void setQqkk(java.lang.String qqkk){
		this.qqkk = qqkk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  餐费补助
	 */
	@Column(name ="CFBZ",nullable=true,length=32)
	public java.lang.String getCfbz(){
		return this.cfbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  餐费补助
	 */
	public void setCfbz(java.lang.String cfbz){
		this.cfbz = cfbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交通补助
	 */
	@Column(name ="JTBZ",nullable=true,length=32)
	public java.lang.String getJtbz(){
		return this.jtbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交通补助
	 */
	public void setJtbz(java.lang.String jtbz){
		this.jtbz = jtbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住房补助
	 */
	@Column(name ="ZFBZ",nullable=true,length=32)
	public java.lang.String getZfbz(){
		return this.zfbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房补助
	 */
	public void setZfbz(java.lang.String zfbz){
		this.zfbz = zfbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应发工资总额
	 */
	@Column(name ="YFGZZE",nullable=true,length=32)
	public java.lang.String getYfgzze(){
		return this.yfgzze;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应发工资总额
	 */
	public void setYfgzze(java.lang.String yfgzze){
		this.yfgzze = yfgzze;
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
	 *@return: java.lang.String  公司承担合计
	 */
	@Column(name ="GSCDHJ",nullable=true,length=32)
	public java.lang.String getGscdhj(){
		return this.gscdhj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司承担合计
	 */
	public void setGscdhj(java.lang.String gscdhj){
		this.gscdhj = gscdhj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人承担合计
	 */
	@Column(name ="GRCDHJ",nullable=true,length=32)
	public java.lang.String getGrcdhj(){
		return this.grcdhj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人承担合计
	 */
	public void setGrcdhj(java.lang.String grcdhj){
		this.grcdhj = grcdhj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应纳税所得额
	 */
	@Column(name ="YNSSDE",nullable=true,length=32)
	public java.lang.String getYnssde(){
		return this.ynssde;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应纳税所得额
	 */
	public void setYnssde(java.lang.String ynssde){
		this.ynssde = ynssde;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  免征额
	 */
	@Column(name ="MZE",nullable=true,length=32)
	public java.lang.String getMze(){
		return this.mze;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  免征额
	 */
	public void setMze(java.lang.String mze){
		this.mze = mze;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实纳税所得额
	 */
	@Column(name ="SNSSDE",nullable=true,length=32)
	public java.lang.String getSnssde(){
		return this.snssde;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实纳税所得额
	 */
	public void setSnssde(java.lang.String snssde){
		this.snssde = snssde;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税率
	 */
	@Column(name ="SL",nullable=true,length=32)
	public java.lang.String getSl(){
		return this.sl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税率
	 */
	public void setSl(java.lang.String sl){
		this.sl = sl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  速算扣除
	 */
	@Column(name ="SSKC",nullable=true,length=32)
	public java.lang.String getSskc(){
		return this.sskc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  速算扣除
	 */
	public void setSskc(java.lang.String sskc){
		this.sskc = sskc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人所得税
	 */
	@Column(name ="GRSDS",nullable=true,length=32)
	public java.lang.String getGrsds(){
		return this.grsds;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人所得税
	 */
	public void setGrsds(java.lang.String grsds){
		this.grsds = grsds;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税后工资
	 */
	@Column(name ="SHGZ",nullable=true,length=32)
	public java.lang.String getShgz(){
		return this.shgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税后工资
	 */
	public void setShgz(java.lang.String shgz){
		this.shgz = shgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="QT",nullable=true,length=32)
	public java.lang.String getQt(){
		return this.qt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setQt(java.lang.String qt){
		this.qt = qt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实发工资
	 */
	@Column(name ="SFGZ",nullable=true,length=32)
	public java.lang.String getSfgz(){
		return this.sfgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实发工资
	 */
	public void setSfgz(java.lang.String sfgz){
		this.sfgz = sfgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行帐号
	 */
	@Column(name ="YHZH",nullable=true,length=32)
	public java.lang.String getYhzh(){
		return this.yhzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行帐号
	 */
	public void setYhzh(java.lang.String yhzh){
		this.yhzh = yhzh;
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
	
	
}
