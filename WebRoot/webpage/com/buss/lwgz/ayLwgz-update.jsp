<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>劳务工资</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayLwgzController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${ayLwgzPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayLwgzPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayLwgzPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayLwgzPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayLwgzPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayLwgzPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayLwgzPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayLwgzPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayLwgzPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayLwgzPage.bpmStatus }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayLwgzPage.sjpzid }">
					<input id="zxbm" name="zxbm" type="hidden" value="${ayLwgzPage.zxbm }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayLwgzPage.ygxxid }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.xm}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						     	 <input id="sfzh" name="sfzh" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.sfzh}'>
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
						     	 <input id="jbgz" name="jbgz" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.jbgz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">基本工资</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								补贴:
							</label>
						</td>
						<td class="value">
						     	 <input id="bt" name="bt" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.bt}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">补贴</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合计:
							</label>
						</td>
						<td class="value">
						     	 <input id="hj" name="hj" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.hj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合计</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								免征额:
							</label>
						</td>
						<td class="value">
						     	 <input id="mze" name="mze" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.mze}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">免征额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实纳税所得额:
							</label>
						</td>
						<td class="value">
						     	 <input id="snssde" name="snssde" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.snssde}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实纳税所得额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								税率:
							</label>
						</td>
						<td class="value">
						     	 <input id="sl" name="sl" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.sl}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								个人所得税:
							</label>
						</td>
						<td class="value">
						     	 <input id="grsds" name="grsds" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.grsds}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人所得税</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								税后工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="shgz" name="shgz" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.shgz}'>
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
						     	 <input id="qt" name="qt" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.qt}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实发工资:
							</label>
						</td>
						<td class="value">
						     	 <input id="sfgz" name="sfgz" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.sfgz}'>
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
						     	 <input id="yhzh" name="yhzh" type="text" style="width: 150px" class="inputxt"  value='${ayLwgzPage.yhzh}'>
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
  <script src = "webpage/com/buss/lwgz/ayLwgz.js"></script>		
