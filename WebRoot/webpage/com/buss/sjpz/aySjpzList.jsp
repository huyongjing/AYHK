<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="aySjpzList" checkbox="true" fitColumns="false" title="" actionUrl="aySjpzController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="流程状态"  field="bpmStatus"    queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>--%>
   <t:dgCol title="年份"  field="year"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="月份"  field="month"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="中心"  field="zx"  dictionary="AY_ZXPZ,zxbm,zx" align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="状态"  field="tjzt" formatterjs="formatt"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="250" align="center"></t:dgCol>
   <t:dgFunOpt title="课程填报" funname="tjkc(id,zx)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#0"></t:dgFunOpt>
   <t:dgFunOpt title="课程填报" funname="tjkc(id,zx)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt>
 <%--  <t:dgFunOpt title="查看" funname="chakan(id,zx)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt> --%>
   <t:dgFunOpt title="查看" funname="chakan(id,zx)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
 <%--  <t:dgFunOpt title="查看" funname="chakan(id,zx)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#3"></t:dgFunOpt> --%>
  <t:dgFunOpt title="提交" funname="tijiao(id)" urlfont=" fa fa-download" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt> 
 <%--  <t:dgFunOpt title="驳回" funname="bohui(id)" urlfont=" fa fa-remove" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="通过" funname="doOk(id)" urlfont=" fa fa-remove" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt> --%>

   <t:dgDelOpt title="删除" url="aySjpzController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="aySjpzController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="aySjpzController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
    <t:dgToolBar title="批量删除"  icon="icon-remove" url="aySjpzController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
    <t:dgToolBar title="查看" icon="icon-search" url="aySjpzController.do?goUpdate" funname="detail"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sjpz/aySjpzList.js"></script>		
 <script type="text/javascript">
     function formatt(rec, val, index) {
         if (rec === null || rec == "null"||rec == 0) {
             return "未提交";
         } else if(rec === 1 || rec == "1"){
             return "已保存";
         } else if(rec === 2 || rec == "2") {
             return "已提交";
         }
         else if(rec === 3 || rec == "3") {
             return "已通过";
         }else {
             return rec;
         }
     }
     function tijiao(id) {
         $.dialog.confirm('确定提交吗?', function(r) {
             $.ajax({
                 url:"aySjpzController.do?doTijiao",
                 data:{'id':id},
                 type:"Post",
                 dataType:"json",
                 success:function(data){
                     tip(data.msg);
                     reloadTable();
                     frameElement.api.close();
                 },
                 error:function(data){
                     $.messager.alert('错误',data.msg);
                 }
             });
         });
     }
     function bohui(id) {
         $.dialog.confirm('确定驳回吗?', function(r) {
             $.ajax({
                 url:"aySjpzController.do?doBohui",
                 data:{'id':id},
                 type:"Post",
                 dataType:"json",
                 success:function(data){
                     tip(data.msg);
                     reloadTable();
                     frameElement.api.close();
                 },
                 error:function(data){
                     $.messager.alert('错误',data.msg);
                 }
             });
         });
     }
     function doOk(id) {
         $.dialog.confirm('确定通过吗?', function(r) {
             $.ajax({
                 url:"aySjpzController.do?doAgree",
                 data:{'id':id},
                 type:"Post",
                 dataType:"json",
                 success:function(data){
                     tip(data.msg);
                     reloadTable();
                     frameElement.api.close();
                 },
                 error:function(data){
                     $.messager.alert('错误',data.msg);
                 }
             });
         });
     }
     function tjkc(sjid,zxid) {
         openwindow("课程管理","ayKcxxController.do?list&sjid="+sjid+"&zxid="+zxid,"","1500","700");
     }
     function chakan(sjid,zxid) {
         openwindow("课程查看","ayKcxxController.do?listChakan&sjid="+sjid+"&zxid="+zxid,"","1500","700");
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#aySjpzListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#aySjpzListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'aySjpzController.do?upload', "aySjpzList");
}

//导出
function ExportXls() {
	JeecgExcelExport("aySjpzController.do?exportXls","aySjpzList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("aySjpzController.do?exportXlsByT","aySjpzList");
}
 </script>