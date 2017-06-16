package com.buss.jx.entity;

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
 * @Description: 绩效表
 * @author caozengling
 * @date 2017-03-23 11:19:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_JX", schema = "")
@SuppressWarnings("serial")
public class AyJxEntity implements java.io.Serializable {
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
	/**实际课时总数*/
	//@Excel(name="实际课时总数")
	private java.lang.String sjkszs;
	/**绩效系数*/
	//@Excel(name="绩效系数")
	private java.lang.String jxxs;
	/**绩效课时数*/
	//@Excel(name="绩效课时数")
	private java.lang.String jxkss;
	/**cpep评估*/
	//@Excel(name="cpep评估")
	private java.lang.String cpep;
	/**c评估系数*/
	//@Excel(name="c评估系数")
	private java.lang.String cpgxs;
	/**c评估课时*/
	//@Excel(name="c评估课时")
	private java.lang.String cpgks;
	/**VB评估*/
	//@Excel(name="VB评估")
	private java.lang.String vbpg;
	/**v评估系数*/
	//@Excel(name="v评估系数")
	private java.lang.String vpgxs;
	/**v评估课时*/
	//@Excel(name="v评估课时")
	private java.lang.String vpgks;
	/**课时总数*/
	@Excel(name="课时总数")
	private java.lang.String kszs;
	/**达标课时数*/
	@Excel(name="达标课时数")
	private java.lang.String dbkss;
	/**达标奖金*/
	@Excel(name="达标奖金")
	private java.lang.String dbjj;
	/**超出课时数*/
	@Excel(name="超出课时数")
	private java.lang.String cckss;
	/**第一档课时数*/
	@Excel(name="第一档课时数")
	private java.lang.String dydkss;
	/**课时费*/
	@Excel(name="课时费")
	private java.lang.String ksf;
	/**课时奖金*/
	@Excel(name="课时奖金")
	private java.lang.String ksjj;
	/**第二档课时数*/
	@Excel(name="第二档课时数")
	private java.lang.String dedkss2;
	/**课时费*/
	@Excel(name="课时费")
	private java.lang.String ksf2;
	/**课时奖金*/
	@Excel(name="课时奖金")
	private java.lang.String ksjj2;
	/**第三档课时数*/
	@Excel(name="第三档课时数")
	private java.lang.String dsdkss3;
	/**课时费*/
	@Excel(name="课时费")
	private java.lang.String ksf3;
	/**课时奖金*/
	@Excel(name="课时奖金")
	private java.lang.String ksjj3;
	/**课时费合计*/
	@Excel(name="课时费合计")
	private java.lang.String ksfhj;
	/**中心*/
	private java.lang.String zxbm;
	/**时间id*/
	private java.lang.String sjpzid;
	/**员工信息id*/
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
	 *@return: java.lang.String  实际课时总数
	 */
	@Column(name ="SJKSZS",nullable=true,length=32)
	public java.lang.String getSjkszs(){
		return this.sjkszs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际课时总数
	 */
	public void setSjkszs(java.lang.String sjkszs){
		this.sjkszs = sjkszs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  绩效系数
	 */
	@Column(name ="JXXS",nullable=true,length=32)
	public java.lang.String getJxxs(){
		return this.jxxs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  绩效系数
	 */
	public void setJxxs(java.lang.String jxxs){
		this.jxxs = jxxs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  绩效课时数
	 */
	@Column(name ="JXKSS",nullable=true,length=32)
	public java.lang.String getJxkss(){
		return this.jxkss;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  绩效课时数
	 */
	public void setJxkss(java.lang.String jxkss){
		this.jxkss = jxkss;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cpep评估
	 */
	@Column(name ="CPEP",nullable=true,length=32)
	public java.lang.String getCpep(){
		return this.cpep;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cpep评估
	 */
	public void setCpep(java.lang.String cpep){
		this.cpep = cpep;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  c评估系数
	 */
	@Column(name ="CPGXS",nullable=true,length=32)
	public java.lang.String getCpgxs(){
		return this.cpgxs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  c评估系数
	 */
	public void setCpgxs(java.lang.String cpgxs){
		this.cpgxs = cpgxs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  c评估课时
	 */
	@Column(name ="CPGKS",nullable=true,length=32)
	public java.lang.String getCpgks(){
		return this.cpgks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  c评估课时
	 */
	public void setCpgks(java.lang.String cpgks){
		this.cpgks = cpgks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  VB评估
	 */
	@Column(name ="VBPG",nullable=true,length=32)
	public java.lang.String getVbpg(){
		return this.vbpg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  VB评估
	 */
	public void setVbpg(java.lang.String vbpg){
		this.vbpg = vbpg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  v评估系数
	 */
	@Column(name ="VPGXS",nullable=true,length=32)
	public java.lang.String getVpgxs(){
		return this.vpgxs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  v评估系数
	 */
	public void setVpgxs(java.lang.String vpgxs){
		this.vpgxs = vpgxs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  v评估课时
	 */
	@Column(name ="VPGKS",nullable=true,length=32)
	public java.lang.String getVpgks(){
		return this.vpgks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  v评估课时
	 */
	public void setVpgks(java.lang.String vpgks){
		this.vpgks = vpgks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时总数
	 */
	@Column(name ="KSZS",nullable=true,length=32)
	public java.lang.String getKszs(){
		return this.kszs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时总数
	 */
	public void setKszs(java.lang.String kszs){
		this.kszs = kszs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  达标课时数
	 */
	@Column(name ="DBKSS",nullable=true,length=32)
	public java.lang.String getDbkss(){
		return this.dbkss;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  达标课时数
	 */
	public void setDbkss(java.lang.String dbkss){
		this.dbkss = dbkss;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  达标奖金
	 */
	@Column(name ="DBJJ",nullable=true,length=32)
	public java.lang.String getDbjj(){
		return this.dbjj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  达标奖金
	 */
	public void setDbjj(java.lang.String dbjj){
		this.dbjj = dbjj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  超出课时数
	 */
	@Column(name ="CCKSS",nullable=true,length=32)
	public java.lang.String getCckss(){
		return this.cckss;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  超出课时数
	 */
	public void setCckss(java.lang.String cckss){
		this.cckss = cckss;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第一档课时数
	 */
	@Column(name ="DYDKSS",nullable=true,length=32)
	public java.lang.String getDydkss(){
		return this.dydkss;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第一档课时数
	 */
	public void setDydkss(java.lang.String dydkss){
		this.dydkss = dydkss;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时费
	 */
	@Column(name ="KSF",nullable=true,length=32)
	public java.lang.String getKsf(){
		return this.ksf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时费
	 */
	public void setKsf(java.lang.String ksf){
		this.ksf = ksf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时奖金
	 */
	@Column(name ="KSJJ",nullable=true,length=32)
	public java.lang.String getKsjj(){
		return this.ksjj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时奖金
	 */
	public void setKsjj(java.lang.String ksjj){
		this.ksjj = ksjj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第二档课时数
	 */
	@Column(name ="DEDKSS2",nullable=true,length=32)
	public java.lang.String getDedkss2(){
		return this.dedkss2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第二档课时数
	 */
	public void setDedkss2(java.lang.String dedkss2){
		this.dedkss2 = dedkss2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时费
	 */
	@Column(name ="KSF2",nullable=true,length=32)
	public java.lang.String getKsf2(){
		return this.ksf2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时费
	 */
	public void setKsf2(java.lang.String ksf2){
		this.ksf2 = ksf2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时奖金
	 */
	@Column(name ="KSJJ2",nullable=true,length=32)
	public java.lang.String getKsjj2(){
		return this.ksjj2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时奖金
	 */
	public void setKsjj2(java.lang.String ksjj2){
		this.ksjj2 = ksjj2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三档课时数
	 */
	@Column(name ="DSDKSS3",nullable=true,length=32)
	public java.lang.String getDsdkss3(){
		return this.dsdkss3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三档课时数
	 */
	public void setDsdkss3(java.lang.String dsdkss3){
		this.dsdkss3 = dsdkss3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时费
	 */
	@Column(name ="KSF3",nullable=true,length=32)
	public java.lang.String getKsf3(){
		return this.ksf3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时费
	 */
	public void setKsf3(java.lang.String ksf3){
		this.ksf3 = ksf3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时奖金
	 */
	@Column(name ="KSJJ3",nullable=true,length=32)
	public java.lang.String getKsjj3(){
		return this.ksjj3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时奖金
	 */
	public void setKsjj3(java.lang.String ksjj3){
		this.ksjj3 = ksjj3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课时费合计
	 */
	@Column(name ="KSFHJ",nullable=true,length=32)
	public java.lang.String getKsfhj(){
		return this.ksfhj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课时费合计
	 */
	public void setKsfhj(java.lang.String ksfhj){
		this.ksfhj = ksfhj;
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
	 *@return: java.lang.String  员工信息id
	 */
	@Column(name ="YGXXID",nullable=true,length=32)
	public java.lang.String getYgxxid(){
		return this.ygxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  员工信息id
	 */
	public void setYgxxid(java.lang.String ygxxid){
		this.ygxxid = ygxxid;
	}
}
