<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工资表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayGzController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${ayGzPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayGzPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayGzPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayGzPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayGzPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayGzPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayGzPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayGzPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayGzPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayGzPage.bpmStatus }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayGzPage.sjpzid }">
					<input id="zxbm" name="zxbm" type="hidden" value="${ayGzPage.zxbm }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayGzPage.ygxxid }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.xm}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								岗位:
							</label>
						</td>
						<td class="value">
						     	 <input id="gw" name="gw" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gw}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								员工类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="yglx" name="yglx" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.yglx}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">员工类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						     	 <input id="sfzh" name="sfzh" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sfzh}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								基本工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="jbgz" name="jbgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.jbgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">基本工资</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								岗位工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="gwgz" name="gwgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gwgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位工资</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								职称工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="zcgz" name="zcgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.zcgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称工资</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								年资工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="nzgz" name="nzgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.nzgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年资工资</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								绩效工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="jxgz" name="jxgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.jxgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效工资</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								管理绩效:
							</label>
						</td>
						<td class="value">
						     	 <input id="gljx" name="gljx" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gljx}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理绩效</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课时奖励:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksjl" name="ksjl" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ksjl}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖励</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								全勤奖:
							</label>
						</td>
						<td class="value">
						     	 <input id="qqj" name="qqj" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.qqj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">全勤奖</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								缺勤扣款:
							</label>
						</td>
						<td class="value">
						     	 <input id="qqkk" name="qqkk" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.qqkk}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">缺勤扣款</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								餐费补助:
							</label>
						</td>
						<td class="value">
						     	 <input id="cfbz" name="cfbz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.cfbz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">餐费补助</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								交通补助:
							</label>
						</td>
						<td class="value">
						     	 <input id="jtbz" name="jtbz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.jtbz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交通补助</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								住房补助:
							</label>
						</td>
						<td class="value">
						     	 <input id="zfbz" name="zfbz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.zfbz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房补助</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								应发工资总额:
							</label>
						</td>
						<td class="value">
						     	 <input id="yfgzze" name="yfgzze" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.yfgzze}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应发工资总额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								养老保险基数:
							</label>
						</td>
						<td class="value">
						     	 <input id="ylbxjs" name="ylbxjs" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ylbxjs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险基数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								其他四险基数:
							</label>
						</td>
						<td class="value">
						     	 <input id="qtsxjs" name="qtsxjs" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.qtsxjs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他四险基数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								公积金基数:
							</label>
						</td>
						<td class="value">
						     	 <input id="gjjjs" name="gjjjs" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gjjjs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公积金基数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								养老保险公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="ylbxgscd" name="ylbxgscd" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ylbxgscd}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险公司承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								失业保险公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="sybxgscdbf1" name="sybxgscdbf1" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sybxgscdbf1}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险公司承担部分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								医疗保险公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="ylbxgscdbf1" name="ylbxgscdbf1" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ylbxgscdbf1}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险公司承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								工伤保险公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="gsbxgscdbf" name="gsbxgscdbf" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gsbxgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工伤保险公司承担部分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生育保险公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="sybxgscdbf" name="sybxgscdbf" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sybxgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生育保险公司承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								住房公积金公司承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="zfgjjgscdbf" name="zfgjjgscdbf" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.zfgjjgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金公司承担部分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								养老保险个人承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="ylbxgrcdbf" name="ylbxgrcdbf" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ylbxgrcdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险个人承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								失业保险个人承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="sybxgrcdbf2" name="sybxgrcdbf2" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sybxgrcdbf2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险个人承担部分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								医疗保险个人承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="ylbxgrcdbf2" name="ylbxgrcdbf2" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ylbxgrcdbf2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险个人承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								个人医疗补充保险:
							</label>
						</td>
						<td class="value">
						     	 <input id="gsylbc" name="gsylbc" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gsylbc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人医疗补充保险</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								住房公积金个人承担部分:
							</label>
						</td>
						<td class="value">
						     	 <input id="zfgjjgrcdbf" name="zfgjjgrcdbf" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.zfgjjgrcdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金个人承担部分</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								公司承担合计:
							</label>
						</td>
						<td class="value">
						     	 <input id="gscdhj" name="gscdhj" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.gscdhj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司承担合计</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								个人承担合计:
							</label>
						</td>
						<td class="value">
						     	 <input id="grcdhj" name="grcdhj" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.grcdhj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人承担合计</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								应纳税所得额:
							</label>
						</td>
						<td class="value">
						     	 <input id="ynssde" name="ynssde" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.ynssde}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应纳税所得额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								免征额:
							</label>
						</td>
						<td class="value">
						     	 <input id="mze" name="mze" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.mze}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">免征额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实纳税所得额:
							</label>
						</td>
						<td class="value">
						     	 <input id="snssde" name="snssde" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.snssde}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实纳税所得额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								税率:
							</label>
						</td>
						<td class="value">
						     	 <input id="sl" name="sl" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sl}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								速算扣除:
							</label>
						</td>
						<td class="value">
						     	 <input id="sskc" name="sskc" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sskc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">速算扣除</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								个人所得税:
							</label>
						</td>
						<td class="value">
						     	 <input id="grsds" name="grsds" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.grsds}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人所得税</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								税后工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="shgz" name="shgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.shgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税后工资</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								其他:
							</label>
						</td>
						<td class="value">
						     	 <input id="qt" name="qt" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.qt}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实发工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="sfgz" name="sfgz" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.sfgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实发工资</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								银行帐号:
							</label>
						</td>
						<td class="value">
						     	 <input id="yhzh" name="yhzh" type="text" style="width: 150px" class="inputxt"  value='${ayGzPage.yhzh}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行帐号</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/gz/ayGz.js"></script>		
