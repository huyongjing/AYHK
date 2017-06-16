package com.buss.lwgz.entity;

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
 * @Description: 劳务工资
 * @author caozengling
 * @date 2017-03-23 15:12:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_LWGZ", schema = "")
@SuppressWarnings("serial")
public class AyLwgzEntity implements java.io.Serializable {
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
	/**身份证号*/
	@Excel(name="身份证号")
	private java.lang.String sfzh;
	/**基本工资*/
	@Excel(name="基本工资")
	private java.lang.String jbgz;
	/**补贴*/
	@Excel(name="补贴")
	private java.lang.String bt;
	/**餐补*/
	@Excel(name="餐补")
	private java.lang.String cb;
	/**合计*/
	@Excel(name="合计")
	private java.lang.String hj;
	/**免征额*/
	@Excel(name="免征额")
	private java.lang.String mze;
	/**实纳税所得额*/
	@Excel(name="实纳税所得额")
	private java.lang.String snssde;
	/**税率*/
	@Excel(name="税率")
	private java.lang.String sl;
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
	 *@return: java.lang.String  补贴
	 */
	@Column(name ="BT",nullable=true,length=32)
	public java.lang.String getBt(){
		return this.bt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  补贴
	 */
	public void setBt(java.lang.String bt){
		this.bt = bt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合计
	 */
	@Column(name ="HJ",nullable=true,length=32)
	public java.lang.String getHj(){
		return this.hj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合计
	 */
	public void setHj(java.lang.String hj){
		this.hj = hj;
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

	@Column(name ="CB",nullable=true,length=32)
	public java.lang.String getCb() {
		return cb;
	}

	public void setCb(java.lang.String cb) {
		this.cb = cb;
	}
	
	
	
}
