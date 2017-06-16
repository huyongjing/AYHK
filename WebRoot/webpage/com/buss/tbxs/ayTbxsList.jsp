<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayTbxsList" checkbox="true" fitColumns="false" title="填报系数" actionUrl="ayTbxsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中心"  field="zx" query="true" dictionary="AY_ZXPZ,zxbm,zx"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="系数类型"  field="hklx" queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="养老保险公司承担部分"  field="ylbxgscd"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="失业保险公司承担部分"  field="sybxgscdbf1"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="医疗保险公司承担部分"  field="ylbxgscdbf1"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="工伤保险公司承担部分"  field="gsbxgscdbf"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="生育保险公司承担部分"  field="sybxgscdbf"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金公司承担部分"  field="zfgjjgscdbf"    queryMode="group"  width="135"></t:dgCol>
   <t:dgCol title="养老保险个人承担部分"  field="ylbxgrcdbf"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="失业保险个人承担部分"  field="sybxgrcdbf2"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="医疗保险个人承担部分"  field="ylbxgrcdbf2"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="工伤保险个人承担部分"  field="gsbxgrcdbf"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="生育保险个人承担部分"  field="sybxgrcdbf"    queryMode="group"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金个人承担部分"  field="zfgjjgrcdbf"    queryMode="group"  width="135"></t:dgCol>
   <t:dgCol title="个人医疗补充保险"  field="gsylbc"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ayTbxsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayTbxsController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayTbxsController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="ayTbxsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayTbxsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/tbxs/ayTbxsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayTbxsListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayTbxsListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayTbxsListtb").find("input[name='updateDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayTbxsListtb").find("input[name='updateDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayTbxsController.do?upload', "ayTbxsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayTbxsController.do?exportXls","ayTbxsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayTbxsController.do?exportXlsByT","ayTbxsList");
}
 </script>