<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>课程信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayKcxxController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${ayKcxxPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayKcxxPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayKcxxPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayKcxxPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayKcxxPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayKcxxPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayKcxxPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayKcxxPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayKcxxPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayKcxxPage.bpmStatus }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								课程名:
							</label>
						</td>
						<td class="value">
						     	 <input id="kcmc" name="kcmc" type="text" style="width: 150px" class="inputxt"  value='${ayKcxxPage.kcmc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课程名</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课程系数:
							</label>
						</td>
						<td class="value">
						     	 <input id="kcxs" name="kcxs" type="text" style="width: 150px" class="inputxt"  value='${ayKcxxPage.kcxs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课程系数</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/kcxx/ayKcxx.js"></script>		
