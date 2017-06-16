<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>绩效时间表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayJxsjController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${ayJxsjPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayJxsjPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayJxsjPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayJxsjPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayJxsjPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayJxsjPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayJxsjPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayJxsjPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayJxsjPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayJxsjPage.bpmStatus }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								年份:
							</label>
						</td>
						<td class="value">
						     	 <input id="year" name="year" type="text" style="width: 150px" class="inputxt"  value='${ayJxsjPage.year}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年份</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								月份:
							</label>
						</td>
						<td class="value">
						     	 <input id="month" name="month" type="text" style="width: 150px" class="inputxt"  value='${ayJxsjPage.month}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月份</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								中心:
							</label>
						</td>
						<td class="value">
						     	 <input id="zxbm" name="zxbm" type="text" style="width: 150px" class="inputxt"  value='${ayJxsjPage.zxbm}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中心</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提交状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="tjzt" name="tjzt" type="text" style="width: 150px" class="inputxt"  value='${ayJxsjPage.tjzt}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提交状态</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/jxsj/ayJxsj.js"></script>		
