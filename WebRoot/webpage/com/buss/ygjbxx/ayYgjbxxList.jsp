<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayYgjbxxList" checkbox="true" fitColumns="false" title="员工基本信息" actionUrl="ayYgjbxxController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="姓名"  field="xm"  align="center" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="xb"  align="center"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="sfzh" align="center" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="sr" align="center" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位"  field="zw"  align="center" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入职日期"  field="rzrq"  align="center"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在职状态"  field="zzzt"  align="center" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="hyzk"  align="center"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="审核状态"  field="shzt"    queryMode="single"  width="120"></t:dgCol>--%>
 <%--  <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>--%>
   <t:dgCol title="填写人"  field="txr" align="center" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="填表时间"  field="tbsj" align="center" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="120"></t:dgCol>
   <t:dgDelOpt title="删除" url="ayYgjbxxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="审核通过" funname="shenhe(id)" urlfont=" fa fa-download" urlclass="ace_button" exp="zzzt#eq#未入职"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="ayYgjbxxController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayYgjbxxController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayYgjbxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayYgjbxxController.do?goUpdate" funname="detail" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/ygjbxx/ayYgjbxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayYgjbxxListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayYgjbxxListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 function shenhe(id) {
         $.dialog.confirm('确定该员工通过审核并入职吗?', function(r) {
             $.ajax({
                 url:"ayYgjbxxController.do?doShenhe",
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
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayYgjbxxController.do?upload', "ayYgjbxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayYgjbxxController.do?exportXls","ayYgjbxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayYgjbxxController.do?exportXlsByT","ayYgjbxxList");
}
 </script>