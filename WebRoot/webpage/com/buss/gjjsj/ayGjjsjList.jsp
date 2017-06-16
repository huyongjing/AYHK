<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayGjjsjList" checkbox="true" fitColumns="false" title="" actionUrl="ayGjjsjController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"   hidden="true"  queryMode="single" dictionary="bpm_status" width="80"></t:dgCol>
   <t:dgCol title="年份"  field="year"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="月份"  field="month"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm"  align="center" dictionary="AY_ZXPZ,zxbm,zx"   queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="状态"  field="tjzt" align="center" formatterjs="formatt" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="250" align="center"></t:dgCol>

   <t:dgFunOpt title="社保填报" funname="tjgjj(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#0" ></t:dgFunOpt>
   <t:dgFunOpt title="社保填报" funname="tjgjj(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#1" ></t:dgFunOpt>
<%--   <t:dgFunOpt title="查看" funname="chakan(id,zxbm)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt> --%>
   <t:dgFunOpt title="查看" funname="chakan(id,zxbm)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="提交" funname="tijiao(id)" urlfont=" fa fa-download" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt>
  <%-- <t:dgFunOpt title="驳回" funname="bohui(id)" urlfont=" fa fa-remove" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt> --%>

   <t:dgDelOpt title="删除" url="ayGjjsjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" />
   <t:dgToolBar title="录入" icon="icon-add" url="ayGjjsjController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayGjjsjController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayGjjsjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayGjjsjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/gjjsj/ayGjjsjList.js"></script>		
 <script type="text/javascript">
     function formatt(rec, val, index) {
         if (rec === null || rec == "null"||rec == 0) {
             return "未提交";
         } else if(rec === 1 || rec == "1"){
             return "已保存";
         } else if(rec === 2 || rec == "2") {
             return "已提交";
         }else {
             return rec;
         }
     }
     function tjgjj(sjid,zxbm) {
         openwindow("公积金管理","ayShgjjController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }
     function chakan(sjid,zxbm) {
         openwindow("公积金查看","ayShgjjController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }


     function tijiao(id) {
         $.dialog.confirm('确定提交吗?', function(r) {
             $.ajax({
                 url:"ayGjjsjController.do?doTijiao",
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
                 url:"ayGjjsjController.do?doBohui",
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
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayGjjsjListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayGjjsjListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayGjjsjController.do?upload', "ayGjjsjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayGjjsjController.do?exportXls","ayGjjsjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayGjjsjController.do?exportXlsByT","ayGjjsjList");
}
 </script>