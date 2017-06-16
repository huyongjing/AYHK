<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayGsbzList" checkbox="true" fitColumns="false" title="个税标准" actionUrl="ayGsbzController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"   queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
   <t:dgCol title="等级"  field="dj"    queryMode="single" align="center" width="120"></t:dgCol>
   <t:dgCol title="等级开始金额"  field="ksje"  align="right"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="等级结束金额"  field="jsje"  align="right"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="税率"  field="sl"    queryMode="single" align="right" width="120"></t:dgCol>
   <t:dgCol title="速算扣除数"  field="sskcs"    queryMode="single" align="right"  width="120"></t:dgCol>
   <t:dgCol title="说明"  field="sm"    queryMode="single"  width="250"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ayGsbzController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayGsbzController.do?goAdd" funname="add" width="800"  ></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayGsbzController.do?goUpdate" funname="update" width="800" ></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayGsbzController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayGsbzController.do?goUpdate" funname="detail" width="800"></t:dgToolBar>
<%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/gsbz/ayGsbzList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayGsbzListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayGsbzListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayGsbzController.do?upload', "ayGsbzList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayGsbzController.do?exportXls","ayGsbzList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayGsbzController.do?exportXlsByT","ayGsbzList");
}
 </script>