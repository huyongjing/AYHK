<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayJxsjList" checkbox="true" fitColumns="false" title="" actionUrl="ayJxsjController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="yincang">
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
   <t:dgCol title="年份"  field="year"    queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="月份"  field="month"    queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm" dictionary="AY_ZXPZ,zxbm,zx" queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="达标课时数"  field="dbkss"    queryMode="single" hidden="true"  width="60"></t:dgCol>
   <t:dgCol title="达标奖金"  field="dbjj"    queryMode="single" hidden="true" width="60"></t:dgCol>
   <t:dgCol title="第一档课时费"  field="ksf"    queryMode="single" hidden="true" width="80"></t:dgCol>
   <t:dgCol title="第一档课时费"  field="ksf2"    queryMode="single" hidden="true" width="80"></t:dgCol>
   <t:dgCol title="第一档课时费"  field="ksf3"    queryMode="single" hidden="true" width="80"></t:dgCol>
   <t:dgCol title="状态"  field="tjzt"  formatterjs="formatt"  queryMode="single" width="60" align="center"></t:dgCol>
   <t:dgCol title="状态1"  field="tjzt1"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="状态2"  field="tjzt2"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="状态3"  field="tjzt3"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="状态4"  field="tjzt4"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="状态5"  field="tjzt5"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="状态6"  field="tjzt6"  formatterjs="formatt"  queryMode="single" hidden="true" width="120" align="center"></t:dgCol>
   <t:dgCol title="按钮权限"  field="ckqx"  hidden="true"  queryMode="single" width="120" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="700"></t:dgCol>
   
   <t:dgFunOpt title="课时填报" funname="kctb(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="课时查看" funname="kcck(id,zxbm)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="绩效查看" funname="jxtb(id,zxbm,tjzt1)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="绩效查看" funname="jxck(id,zxbm,tjzt1)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="考勤填报" funname="kqtb(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="考勤查看" funname="kqck(id,zxbm)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="社保公积金查看" funname="gjjtb(id,zxbm)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="社保公积金查看" funname="gjjck(id,zxbm)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="劳务工资查看" funname="lwtb(id,zxbm)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="劳务工资查看" funname="lwck(id,zxbm)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="工资填报" funname="gztb(id,zxbm,tjzt2,tjzt3,tjzt4)" urlfont="fa fa-gavel" urlclass="ace_button" exp="tjzt#ne#2"></t:dgFunOpt>
   <t:dgFunOpt title="工资查看" funname="gzck(id,zxbm,tjzt2,tjzt3,tjzt4)" urlfont="fa fa-copy" urlclass="ace_button" exp="tjzt#eq#2"></t:dgFunOpt>
   <t:dgFunOpt title="提交" funname="tijiao(id)" urlfont=" fa fa-download" urlclass="ace_button" exp="tjzt#eq#0" ></t:dgFunOpt>
   <t:dgFunOpt title="驳回" funname="bohui(id)" urlfont=" fa fa-remove" urlclass="ace_button" exp="ckqx#eq#AY_JJHSH" ></t:dgFunOpt>
   <t:dgFunOpt title="通过" funname="doOk(id)" urlfont=" fa fa-gavel" urlclass="ace_button" exp="ckqx#eq#AY_JJHSH" ></t:dgFunOpt>
   <t:dgDelOpt title="删除" url="ayJxsjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" exp="tjzt#ne#2"/>
 <%--  <t:dgDelOpt title="删除" url="ayJxsjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" exp="tjzt#eq#1"/> --%>
   
   <t:dgToolBar title="录入" icon="icon-add" url="ayJxsjController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayJxsjController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayJxsjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayJxsjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/jxsj/ayJxsjList.js"></script>		
 <script type="text/javascript">
 	function yincang(){
 		
 	}
     function formatt(rec, val, index) {
         if (rec === null || rec == "null"||rec == 0) {
             return "未提交";
         } else if(rec === 1 || rec == "1"){
             return "待审核";
         } else if(rec === 2 || rec == "2") {
             return "已通过";
         }else {
             return rec;
         }
     }
     
     function tijiao(id) {
         $.dialog.confirm('确定提交吗?', function(r) {
             $.ajax({
                 url:"ayJxController.do?doTijiao",
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
                 url:"ayJxController.do?doBohui",
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
                 url:"ayJxController.do?doAgree",
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
     function kctb(sjid,zxid) {
         openwindow("课程管理","ayKcxxController.do?list&sjid="+sjid+"&zxid="+zxid,"","100%","100%");
     }
     function kcck(sjid,zxid) {
         openwindow("课程查看","ayKcxxController.do?listChakan&sjid="+sjid+"&zxid="+zxid,"","100%","100%");
     }
     function jxtb(sjid,zxid,tjzt1) {
     	 if(tjzt1!="1"){
     	 	tip("请先保存课程信息!");
     	 	return;
     	 }
         openwindow("绩效查询","ayJxController.do?list&sjid="+sjid+"&zxbm="+zxid,"","100%","100%");
     }
     function jxck(sjid,zxid,tjzt1) {
         openwindow("绩效查询","ayJxController.do?listChakan&sjid="+sjid+"&zxid="+zxid,"","100%","100%");
     }
     function kqtb(sjid,zxbm) {
         openwindow("考勤管理","ayKqxxController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function kqck(sjid,zxbm) {
         openwindow("考勤查看","ayKqxxController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function gjjtb(sjid,zxbm) {
         openwindow("社保公积金查询","ayShgjjController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function gjjck(sjid,zxbm) {
         openwindow("社保公积金查询","ayShgjjController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function lwtb(sjid,zxbm) {
         openwindow("劳务工资管理","ayLwgzController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function lwck(sjid,zxbm) {
         openwindow("劳务工资查看","ayLwgzController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
     function gztb(sjid,zxbm,tjzt2,tjzt3,tjzt4) {
     	$.ajax({
                 url:"ayJxController.do?doCheck",
                 data:{'id':sjid},
                 type:"Post",
                 dataType:"json",
                 success:function(data){
                 	if(data.msg=="cantijiao"){
                 		openwindow("工资管理","ayGzController.do?list&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
                 	}else{
                 		 tip(data.msg);
                 		 reloadTable();
                     	 frameElement.api.close();
                 	}
                 },
                 error:function(data){
                     $.messager.alert('错误',data.msg);
                 }
             });
         
     }
     function gzck(sjid,zxbm,tjzt2,tjzt3,tjzt4) {
     if(tjzt2!="2"){
     		tip("请先查看绩效信息!");
     	 	return;
     	}
     	if(tjzt3!="2"){
     		tip("请先保存考勤信息!");
     	 	return;
     	}
     	if(tjzt4!="2"){
     		tip("请先查看社保公积金信息!");
     	 	return;
     	}
         openwindow("工资查看","ayGzController.do?listChakan&sjid="+sjid+"&zxbm="+zxbm,"","100%","100%");
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayJxsjListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayJxsjListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayJxsjController.do?upload', "ayJxsjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayJxsjController.do?exportXls","ayJxsjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayJxsjController.do?exportXlsByT","ayJxsjList");
}
 </script>