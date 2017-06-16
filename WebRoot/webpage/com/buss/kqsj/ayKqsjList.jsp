<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayKqsjList" checkbox="true" fitColumns="false" title="" actionUrl="ayKqsjController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间主键"  field="sjpzid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
   <t:dgCol title="年份"  field="year"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="月份"  field="month"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="当月应出勤(天)"  field="dyycq"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="法定假期(天)"  field="fdj"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="餐费补助(/天)"  field="cf"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="交通补助(/月)"  field="jt"  align="center"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm" align="center" dictionary="AY_ZXPZ,zxbm,zx"    queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="状态"  field="tjzt" align="center" formatterjs="formatt"   queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="250" align="center"></t:dgCol>
   <t:dgFunOpt title="考勤填报" funname="tjkq(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#0" ></t:dgFunOpt>
   <t:dgFunOpt title="考勤填报" funname="tjkq(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#eq#1" ></t:dgFunOpt>
   <t:dgFunOpt title="查看" funname="chakan(id,zxbm)" urlfont=" fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="提交" funname="tijiao(id)" urlfont=" fa fa-download" urlclass="ace_button" exp="tjzt#eq#1"></t:dgFunOpt>
  <%-- <t:dgFunOpt title="驳回" funname="bohui(id)" urlfont=" fa fa-remove" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt> --%>
   <t:dgDelOpt title="删除" url="ayKqsjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" />
   <t:dgToolBar title="录入" icon="icon-add" url="ayKqsjController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayKqsjController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayKqsjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayKqsjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/kqsj/ayKqsjList.js"></script>		
 <script type="text/javascript">
     function formatt(rec, val, index) {
         if (rec === null || rec == "null"||rec == 0) {
             return "未提交";
         } else if(rec === 1 || rec == "1"){
             return "已保存";
         } else if(rec === 2 || rec == "2") {
             return "已提交";
         }else if(rec === 3 || rec == "3") {
             return "已通过";
         }else {
             return rec;
         }
     }

     function tijiao(id) {
         $.dialog.confirm('确定提交吗?', function(r) {
             $.ajax({
                 url:"ayKqsjController.do?doTijiao",
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
                 url:"ayKqsjController.do?doBohui",
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
     function tjkq(sjid,zxbm) {
         openwindow("考勤管理","ayKqxxController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }
     function chakan(sjid,zxbm) {
         openwindow("考勤查看","ayKqxxController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","1500","700");
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayKqsjListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayKqsjListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayKqsjController.do?upload', "ayKqsjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayKqsjController.do?exportXls","ayKqsjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayKqsjController.do?exportXlsByT","ayKqsjList");
}
 </script>