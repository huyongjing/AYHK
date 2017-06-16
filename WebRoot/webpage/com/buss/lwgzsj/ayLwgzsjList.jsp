<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayLwgzsjList" checkbox="true" fitColumns="false" title="" actionUrl="ayLwgzsjController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
   <t:dgCol title="年份"  field="year"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月份"  field="month"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm"  dictionary="AY_ZXPZ,zxbm,zx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="提交状态"  field="tjzt"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt title="劳务填报" funname="tjlw(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#0"></t:dgFunOpt>
   <t:dgFunOpt title="查看" funname="chakan(id,zxbm)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt>
   <t:dgFunOpt title="查看" funname="chakan(id,zxbm)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgDelOpt title="删除" url="ayLwgzsjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayLwgzsjController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayLwgzsjController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayLwgzsjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayLwgzsjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/lwgzsj/ayLwgzsjList.js"></script>		
 <script type="text/javascript">
     function tjlw(sjid,zxbm) {
         openwindow("劳务工资管理","ayLwgzController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayLwgzsjListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayLwgzsjListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
 function chakan(sjid,zxbm) {
         openwindow("劳务工资查看","ayLwgzController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayLwgzsjController.do?upload', "ayLwgzsjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayLwgzsjController.do?exportXls","ayLwgzsjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayLwgzsjController.do?exportXlsByT","ayLwgzsjList");
}
 </script>