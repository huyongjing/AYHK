package com.buss.kqxx.entity;

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
 * @Description: 考勤信息表
 * @author caozengling
 * @date 2017-03-15 14:47:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "AY_KQXX", schema = "")
@SuppressWarnings("serial")
public class AyKqxxEntity implements java.io.Serializable {
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
	/**员工类型*/
	@Excel(name="员工类型")
	private java.lang.String yglx;
	/**当月应出勤*/
	@Excel(name="当月应出勤")
	private java.lang.String dyycq;
	/**实际出勤*/
	@Excel(name="实际出勤")
	private java.lang.Double sjcq;
	/**出差*/
	@Excel(name="出差")
	private java.lang.Double cc;
	/**计薪日*/
	@Excel(name="计薪日")
	private java.lang.Double jxr;
	/**餐补*/
	@Excel(name="餐补")
	private java.lang.String cb;
	/**交通补*/
	@Excel(name="交通补")
	private java.lang.String jtb;
	/**住房补贴标准*/
	@Excel(name="住房补贴标准")
	private java.lang.String zfbtbz;
	/**住房补*/
	@Excel(name="住房补")
	private java.lang.String zfb;
	/**法定假或公休带薪假*/
	@Excel(name="法定假或公休带薪假")
	private java.lang.Double fdj;
	/**未入职或离职*/
	@Excel(name="未入职或离职")
	private java.lang.Double wrz;
	/**病假 */
	@Excel(name="病假 ")
	private java.lang.Double bj;
	/**事假 */
	@Excel(name="事假 ")
	private java.lang.Double sj;
	/**调休*/
	@Excel(name="调休")
	private java.lang.Double tx;
	/**带薪年假*/
	@Excel(name="带薪年假")
	private java.lang.Double dxnj;
	/**当年年假*/
	@Excel(name="当年年假")
	private java.lang.Double dnnj;
	/**当年剩余年假*/
	@Excel(name="当年剩余年假")
	private java.lang.Double dnsynj;
	/**加班日期*/
	@Excel(name="加班日期")
	private java.lang.String jbrq;
	/**加班事由*/
	@Excel(name="加班事由")
	private java.lang.String jbsy;
	/**加班天数*/
	@Excel(name="加班天数")
	private java.lang.String jbts;
	/**剩余加班*/
	@Excel(name="剩余加班")
	private java.lang.Double syjb;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String bz;
	/**中心*/
	@Excel(name="中心")
	private java.lang.String zxbm;
	/**员工基本信息id*/
	@Excel(name="员工基本信息id")
	private java.lang.String ygxxid;
	/**时间配置id*/
	@Excel(name="课程时间")
	private java.lang.String sjpzid;
	
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
	 *@return: java.lang.String  当月应出勤
	 */
	@Column(name ="DYYCQ",nullable=true,length=32)
	public java.lang.String getDyycq(){
		return this.dyycq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当月应出勤
	 */
	public void setDyycq(java.lang.String dyycq){
		this.dyycq = dyycq;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际出勤
	 */
	@Column(name ="SJCQ",nullable=true,scale=1,length=32)
	public java.lang.Double getSjcq(){
		return this.sjcq;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际出勤
	 */
	public void setSjcq(java.lang.Double sjcq){
		this.sjcq = sjcq;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  出差
	 */
	@Column(name ="CC",nullable=true,scale=1,length=32)
	public java.lang.Double getCc(){
		return this.cc;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  出差
	 */
	public void setCc(java.lang.Double cc){
		this.cc = cc;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  计薪日
	 */
	@Column(name ="JXR",nullable=true,scale=1,length=32)
	public java.lang.Double getJxr(){
		return this.jxr;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  计薪日
	 */
	public void setJxr(java.lang.Double jxr){
		this.jxr = jxr;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  餐补
	 */
	@Column(name ="CB",nullable=true,scale=1,length=32)
	public java.lang.String getCb(){
		return this.cb;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  餐补
	 */
	public void setCb(java.lang.String cb){
		this.cb = cb;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  交通补
	 */
	@Column(name ="JTB",nullable=true,scale=1,length=32)
	public java.lang.String getJtb(){
		return this.jtb;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  交通补
	 */
	public void setJtb(java.lang.String jtb){
		this.jtb = jtb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住房补贴标准
	 */
	@Column(name ="ZFBTBZ",nullable=true,length=32)
	public java.lang.String getZfbtbz(){
		return this.zfbtbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房补贴标准
	 */
	public void setZfbtbz(java.lang.String zfbtbz){
		this.zfbtbz = zfbtbz;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  住房补
	 */
	@Column(name ="ZFB",nullable=true,scale=1,length=32)
	public java.lang.String getZfb(){
		return this.zfb;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  住房补
	 */
	public void setZfb(java.lang.String zfb){
		this.zfb = zfb;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  法定假或公休带薪假
	 */
	@Column(name ="FDJ",nullable=true,scale=1,length=32)
	public java.lang.Double getFdj(){
		return this.fdj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  法定假或公休带薪假
	 */
	public void setFdj(java.lang.Double fdj){
		this.fdj = fdj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  未入职或离职
	 */
	@Column(name ="WRZ",nullable=true,scale=1,length=32)
	public java.lang.Double getWrz(){
		return this.wrz;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  未入职或离职
	 */
	public void setWrz(java.lang.Double wrz){
		this.wrz = wrz;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  病假 
	 */
	@Column(name ="BJ",nullable=true,scale=1,length=32)
	public java.lang.Double getBj(){
		return this.bj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  病假 
	 */
	public void setBj(java.lang.Double bj){
		this.bj = bj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  事假 
	 */
	@Column(name ="SJ",nullable=true,scale=1,length=32)
	public java.lang.Double getSj(){
		return this.sj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  事假 
	 */
	public void setSj(java.lang.Double sj){
		this.sj = sj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  调休
	 */
	@Column(name ="TX",nullable=true,scale=1,length=32)
	public java.lang.Double getTx(){
		return this.tx;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  调休
	 */
	public void setTx(java.lang.Double tx){
		this.tx = tx;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  带薪年假
	 */
	@Column(name ="DXNJ",nullable=true,scale=1,length=32)
	public java.lang.Double getDxnj(){
		return this.dxnj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  带薪年假
	 */
	public void setDxnj(java.lang.Double dxnj){
		this.dxnj = dxnj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  当年年假
	 */
	@Column(name ="DNNJ",nullable=true,scale=1,length=32)
	public java.lang.Double getDnnj(){
		return this.dnnj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  当年年假
	 */
	public void setDnnj(java.lang.Double dnnj){
		this.dnnj = dnnj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  当年剩余年假
	 */
	@Column(name ="DNSYNJ",nullable=true,scale=1,length=32)
	public java.lang.Double getDnsynj(){
		return this.dnsynj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  当年剩余年假
	 */
	public void setDnsynj(java.lang.Double dnsynj){
		this.dnsynj = dnsynj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  加班日期
	 */
	@Column(name ="JBRQ",nullable=true,length=32)
	public java.lang.String getJbrq(){
		return this.jbrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  加班日期
	 */
	public void setJbrq(java.lang.String jbrq){
		this.jbrq = jbrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  加班事由
	 */
	@Column(name ="JBSY",nullable=true,length=32)
	public java.lang.String getJbsy(){
		return this.jbsy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  加班事由
	 */
	public void setJbsy(java.lang.String jbsy){
		this.jbsy = jbsy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  加班天数
	 */
	@Column(name ="JBTS",nullable=true,length=32)
	public java.lang.String getJbts(){
		return this.jbts;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  加班天数
	 */
	public void setJbts(java.lang.String jbts){
		this.jbts = jbts;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  剩余加班
	 */
	@Column(name ="SYJB",nullable=true,scale=1,length=32)
	public java.lang.Double getSyjb(){
		return this.syjb;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  剩余加班
	 */
	public void setSyjb(java.lang.Double syjb){
		this.syjb = syjb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=500)
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

	public String getZxbm() {
		return zxbm;
	}

	public void setZxbm(String zxbm) {
		this.zxbm = zxbm;
	}

	public String getYgxxid() {
		return ygxxid;
	}

	public void setYgxxid(String ygxxid) {
		this.ygxxid = ygxxid;
	}

	public String getSjpzid() {
		return sjpzid;
	}

	public void setSjpzid(String sjpzid) {
		this.sjpzid = sjpzid;
	}
}
