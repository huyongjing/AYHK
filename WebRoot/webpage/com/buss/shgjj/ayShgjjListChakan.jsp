<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <input type="hidden" value="${sjpzid}" id="riqiid"  />
  <t:datagrid name="ayShgjjList" checkbox="true" fitColumns="false" title="社会公积金" actionUrl="ayShgjjController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group" onLoadSuccess="onload">
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
   <t:dgCol title="姓名"  field="xm"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="岗位"  field="gw"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="员工类型"  field="yglx"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="养老保险基数"  field="ylbxjs" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="其他四险基数"  field="qtsxjs"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公积金基数"  field="gjjjs"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="养老保险公司承担部分"  field="ylbxgscd"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="失业保险公司承担部分"  field="sybxgscdbf1"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="医疗保险公司承担部分"  field="ylbxgscdbf1"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="工伤保险公司承担部分"  field="gsbxgscdbf"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="生育保险公司承担部分"  field="sybxgscdbf"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金公司承担部分"  field="zfgjjgscdbf"    queryMode="single"  width="135"></t:dgCol>
   <t:dgCol title="养老保险个人承担部分"  field="ylbxgrcdbf"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="失业保险个人承担部分"  field="sybxgrcdbf2"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="医疗保险个人承担部分"  field="ylbxgrcdbf2"    queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金个人承担部分"  field="zfgjjgrcdbf"    queryMode="single"  width="135"></t:dgCol>
   <t:dgCol title="住房公积金合计"  field="zfgjjhj"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="保险合计"  field="bxhj"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="220"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm" hidden="true"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="员工id"  field="ygxxid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间id"  field="sjpzid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
  <%-- <t:dgToolBar title="保存" icon="icon-add" url="ayShgjjController.do?saveRows" funname="saveData" width="800"></t:dgToolBar>--%>
   <%--<t:dgDelOpt title="删除" url="ayShgjjController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayShgjjController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayShgjjController.do?goUpdate" funname="update" width="800"></t:dgToolBar>--%>
  <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayShgjjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayShgjjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/shgjj/ayShgjjList.js"></script>		
 <script type="text/javascript">
     function onload() {
         changeEditGrid();
     }


     //保存数据
     function saveData(title, addurl, gname) {
         var editIndex = $('#' + gname).datagrid('getRows').length - 1;
         for (var i = 0; i <= editIndex; i++) {
             if ($('#' + gname).datagrid('validateRow', i))
                 $('#' + gname).datagrid('endEdit', i);
         }
         var rows = $('#ayShgjjList').datagrid("getRows");
         //rows = rows.concat(rows);
         if (rows.length <= 0) {
             tip("没有需要保存的数据！");
             return false;
         }
         var result =  {};
         for (var i = 0; i < rows.length; i++) {
             for (var d in rows[i]) {
                 result["demos[" + i + "]." + d] = rows[i][d];

             }
         }
         $.ajax({
             url: "${pageContext.request.contextPath}/" + addurl,
             type: "post",
             data: result,
             dataType: "json",
             //contentType:"application/json",
             success: function (data) {
                 if (data.success) {
                     layer.open({
                         icon: 1,
                         content: '保存成功'
                         ,yes: function(index){
                             reloadTable();
                             var win = frameElement.api.opener;
                             win.reloadTable();
                             frameElement.api.close();
                         }
                     });
                 }
             }
         });
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayShgjjListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayShgjjListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayShgjjController.do?upload', "ayShgjjList");
}

//导出
function ExportXls() {
    var sjpz = $("#riqiid").val();
	JeecgExcelExport("ayShgjjController.do?exportXls&sjpzid="+sjpz,"ayShgjjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayShgjjController.do?exportXlsByT","ayShgjjList");
}
 </script>