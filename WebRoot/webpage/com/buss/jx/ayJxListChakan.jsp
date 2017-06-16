<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <input type="hidden" value="${sjpzid}" id="riqiid"  />
  <t:datagrid name="ayJxList" checkbox="true" fitColumns="false" title="绩效表" actionUrl="ayJxController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group" onLoadSuccess="onload">
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
   <t:dgCol title="姓名"  field="xm"    queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="实际课时总数"  field="sjkszs" hidden="true" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="绩效系数"  field="jxxs" hidden="true" extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="绩效课时数"  field="jxkss" hidden="true" extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="C_PEP评估"  field="cpep" hidden="true" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="评估系数"  field="cpgxs" hidden="true" extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="评估课时"  field="cpgks" hidden="true" extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="VB评估"  field="vbpg" hidden="true"  extendParams="editor:'numberbox'" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="评估系数"  field="vpgxs" hidden="true" extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="评估课时"  field="vpgks" hidden="true"   extendParams="editor:'numberbox'" queryMode="single"  width="120"></t:dgCol>  
   <t:dgCol title="课时总数"  field="kszs" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="达标课时数"  field="dbkss"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="达标奖金"  field="dbjj"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="超出课时数"  field="cckss"    extendParams="editor:'numberbox'" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="第一档课时数"  field="dydkss"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时费"  field="ksf"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时奖金"  field="ksjj"   extendParams="editor:'numberbox'" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="第二档课时数"  field="dedkss2"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时费"  field="ksf2" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时奖金"  field="ksjj2"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="第三档课时数"  field="dsdkss3"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时费"  field="ksf3" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时奖金"  field="ksjj3" extendParams="editor:'numberbox'"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课时费合计"  field="ksfhj"  extendParams="editor:'numberbox'"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间id"  field="sjpzid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="员工信息id"  field="ygxxid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <%--<t:dgDelOpt title="删除" url="ayJxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="ayJxController.do?goAdd" funname="add" width="800"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayJxController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayJxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayJxController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/jx/ayJxList.js"></script>		
 <script type="text/javascript">
     function onload() {
        // changeEditGrid();
     }
     function changeEditGrid() {
         var grid = $('#ayJxList');

         var rows = $('#ayJxList').datagrid("getRows");

         if (rows.length < 1) {
             return;
         }
         $.each(rows, function (i, row) {
             $('#ayJxList').datagrid('beginEdit', i);
             var sjkszs = $('#ayJxList').datagrid('getEditor', {index: i, field: 'sjkszs'});
             var jxxs = $('#ayJxList').datagrid('getEditor', {index: i, field: 'jxxs'});
             var jxkss = $('#ayJxList').datagrid('getEditor', {index: i, field: 'jxkss'});
             var cpep = $('#ayJxList').datagrid('getEditor', {index: i, field: 'cpep'});
             var cpgxs = $('#ayJxList').datagrid('getEditor', {index: i, field: 'cpgxs'});
             var cpgks = $('#ayJxList').datagrid('getEditor', {index: i, field: 'cpgks'});
             var vbpg = $('#ayJxList').datagrid('getEditor', {index: i, field: 'vbpg'});
             var vpgxs = $('#ayJxList').datagrid('getEditor', {index: i, field: 'vpgxs'});
             var vpgks = $('#ayJxList').datagrid('getEditor', {index: i, field: 'vpgks'});
             var kszs = $('#ayJxList').datagrid('getEditor', {index: i, field: 'kszs'});
             var dbjj = $('#ayJxList').datagrid('getEditor', {index: i, field: 'dbjj'});
             var dbkss = $('#ayJxList').datagrid('getEditor', {index: i, field: 'dbkss'});
             var cckss = $('#ayJxList').datagrid('getEditor', {index: i, field: 'cckss'});
             var dydkss = $('#ayJxList').datagrid('getEditor', {index: i, field: 'dydkss'});
             var ksf = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksf'});
             var ksjj = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksjj'});
             var dedkss2 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'dedkss2'});
             var ksf2 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksf2'});
             var ksjj2 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksjj2'});
             var dsdkss3 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'dsdkss3'});
             var ksf3 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksf3'});
             var ksjj3 = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksjj3'});
             var ksfhj = $('#ayJxList').datagrid('getEditor', {index: i, field: 'ksfhj'});
             //加载默认数据
             if($(jxxs.target).val()==null||$(jxxs.target).val()==""||$(jxxs.target).val()==0){
                 $(jxxs.target).attr("value", 1);
             }
             if($(cpgxs.target).val()==null||$(cpgxs.target).val()==""||$(cpgxs.target).val()==0){
                 $(cpgxs.target).attr("value", 1.5);
             }
             if($(vpgxs.target).val()==null||$(vpgxs.target).val()==""||$(vpgxs.target).val()==0){
                 $(vpgxs.target).attr("value", 1.5);
             }
             if($(dbkss.target).val()==null||$(dbkss.target).val()==""||$(dbkss.target).val()==0){
                 $(dbkss.target).attr("value", 70);
             }
             if($(ksf.target).val()==null||$(ksf.target).val()==""||$(ksf.target).val()==0){
                 $(ksf.target).attr("value", 30);
             }
             if($(ksf2.target).val()==null||$(ksf2.target).val()==""||$(ksf2.target).val()==0){
                 $(ksf2.target).attr("value", 50);
             }
             if($(ksf3.target).val()==null||$(ksf3.target).val()==""||$(ksf3.target).val()==0){
                 $(ksf3.target).attr("value", 70);
             }
             //只读
             $(jxxs.target).attr("disabled", "disabled");
             $(jxkss.target).attr("disabled", "disabled");
             $(cpgxs.target).attr("disabled", "disabled");
             $(cpgks.target).attr("disabled", "disabled");
             $(vpgxs.target).attr("disabled", "disabled");
             $(vpgks.target).attr("disabled", "disabled");
             $(kszs.target).attr("disabled", "disabled");
             $(dbjj.target).attr("disabled", "disabled");
             $(dbkss.target).attr("disabled", "disabled");

             /*sjkszs.target.bind('focus', function () {//绑定获取焦点事件
                 return false;
             });*/

             sjkszs.target.bind('change', function () {
                 var  t_sjkszs=parseFloat($(sjkszs.target).val())||0;
                 var  t_jxxs=parseFloat($(jxxs.target).val())||0;
                 row.jxkss=t_sjkszs*t_jxxs;
                 $(jxkss.target).attr("value", row.jxkss);
                 //课程合计
                 var  t_jxkss=parseFloat($(jxkss.target).val())||0;
                 var  t_cpgks=parseFloat($(cpgks.target).val())||0;
                 var  t_vpgks=parseFloat($(vpgks.target).val())||0;
                 row.kszs=t_jxkss+t_cpgks+t_vpgks;
                 $(kszs.target).attr("value", row.kszs);
                 //达标奖金
                 if(row.kszs>=70){
                     $(dbjj.target).attr("value", 500);
                 }else{
                     $(dbjj.target).attr("value", 0);
                 }
                 //超出课时数
                 var  t_dbkss=parseFloat($(dbkss.target).val())||0;
                 if(row.kszs-t_dbkss>=0){
                     $(cckss.target).attr("value", row.kszs-t_dbkss);
                 }else{
                     $(cckss.target).attr("value", 0);
                 }
                 //第一档课时数
                 var  t_cckss=parseFloat($(cckss.target).val())||0;
                 if(t_cckss>10){
                     $(dydkss.target).attr("value", 10);
                 }else {
                     $(dydkss.target).attr("value", t_cckss);
                 }
                 //第一档课时奖金
                 var  t_dydkss=parseFloat($(dydkss.target).val())||0;
                 var  t_ksf=parseFloat($(ksf.target).val())||0;
                 row.ksjj=t_ksf*t_dydkss;
                 $(ksjj.target).attr("value", row.ksjj);
                 //第二档课时数
                 if(t_cckss-t_dydkss>=10){
                     $(dedkss2.target).attr("value", 10);
                 }else {
                     $(dedkss2.target).attr("value", t_cckss-t_dydkss);
                 }
                 //第二档课时奖金
                 var  t_dedkss2=parseFloat($(dedkss2.target).val())||0;
                 var  t_ksf2=parseFloat($(ksf2.target).val())||0;
                 row.ksjj2=t_ksf2*t_dedkss2;
                 $(ksjj2.target).attr("value", row.ksjj2);
                 //第三档课时数
                 $(dsdkss3.target).attr("value", t_cckss-t_dydkss-t_dedkss2);
                 //第三档课时奖金
                 var  t_ksf3=parseFloat($(ksf3.target).val())||0;
                 var  t_dsdkss3=parseFloat($(dsdkss3.target).val())||0;
                 row.ksjj3=t_ksf3*t_dsdkss3;
                 $(ksjj3.target).attr("value", row.ksjj3);
                 //课时费合计
                 $(ksfhj.target).attr("value", row.ksjj+row.ksjj2+row.ksjj3);
             });
             cpep.target.bind('change', function () {
                 var  t_cpep=parseFloat($(cpep.target).val())||0;
                 var  t_cpgxs=parseFloat($(cpgxs.target).val())||0;
                 row.cpgks=t_cpep*t_cpgxs;
                 $(cpgks.target).attr("value", row.cpgks);
                 //课程合计
                 var  t_jxkss=parseFloat($(jxkss.target).val())||0;
                 var  t_cpgks=parseFloat($(cpgks.target).val())||0;
                 var  t_vpgks=parseFloat($(vpgks.target).val())||0;
                 row.kszs=t_jxkss+t_cpgks+t_vpgks;
                 $(kszs.target).attr("value", row.kszs);
                 //达标奖金
                 if(row.kszs>=70){
                     $(dbjj.target).attr("value", 500);
                 }else{
                     $(dbjj.target).attr("value", 0);
                 }
                 //超出课时数
                 var  t_dbkss=parseFloat($(dbkss.target).val())||0;
                 if(row.kszs-t_dbkss>=0){
                     $(cckss.target).attr("value", row.kszs-t_dbkss);
                 }else{
                     $(cckss.target).attr("value", 0);
                 }
                 //第一档课时数
                 var  t_cckss=parseFloat($(cckss.target).val())||0;
                 if(t_cckss>10){
                     $(dydkss.target).attr("value", 10);
                 }else {
                     $(dydkss.target).attr("value", t_cckss);
                 }
                 //第一档课时奖金
                 var  t_dydkss=parseFloat($(dydkss.target).val())||0;
                 var  t_ksf=parseFloat($(ksf.target).val())||0;
                 row.ksjj=t_ksf*t_dydkss;
                 $(ksjj.target).attr("value", row.ksjj);
                 //第二档课时数
                 if(t_cckss-t_dydkss>=10){
                     $(dedkss2.target).attr("value", 10);
                 }else {
                     $(dedkss2.target).attr("value", t_cckss-t_dydkss);
                 }
                 //第二档课时奖金
                 var  t_dedkss2=parseFloat($(dedkss2.target).val())||0;
                 var  t_ksf2=parseFloat($(ksf2.target).val())||0;
                 row.ksjj2=t_ksf2*t_dedkss2;
                 $(ksjj2.target).attr("value", row.ksjj2);
                 //第三档课时数
                 $(dsdkss3.target).attr("value", t_cckss-t_dydkss-t_dedkss2);
                 //第三档课时奖金
                 var  t_ksf3=parseFloat($(ksf3.target).val())||0;
                 var  t_dsdkss3=parseFloat($(dsdkss3.target).val())||0;
                 row.ksjj3=t_ksf3*t_dsdkss3;
                 $(ksjj3.target).attr("value", row.ksjj3);
                 //课时费合计
                 $(ksfhj.target).attr("value", row.ksjj+row.ksjj2+row.ksjj3);

             });
             vbpg.target.bind('change', function () {
                 var  t_vbpg=parseFloat($(vbpg.target).val())||0;
                 var  t_vpgxs=parseFloat($(vpgxs.target).val())||0;
                 row.vpgks=t_vbpg*t_vpgxs;
                 $(vpgks.target).attr("value", row.vpgks);
                 //课程合计
                 var  t_jxkss=parseFloat($(jxkss.target).val())||0;
                 var  t_cpgks=parseFloat($(cpgks.target).val())||0;
                 var  t_vpgks=parseFloat($(vpgks.target).val())||0;
                 row.kszs=t_jxkss+t_cpgks+t_vpgks;
                 $(kszs.target).attr("value", row.kszs);
                 //达标奖金
                 if(row.kszs>=70){
                     $(dbjj.target).attr("value", 500);
                 }else{
                     $(dbjj.target).attr("value", 0);
                 }
                 //超出课时数
                 var  t_dbkss=parseFloat($(dbkss.target).val())||0;
                 if(row.kszs-t_dbkss>=0){
                     $(cckss.target).attr("value", row.kszs-t_dbkss);
                 }else{
                     $(cckss.target).attr("value", 0);
                 }
                 //第一档课时数
                 var  t_cckss=parseFloat($(cckss.target).val())||0;
                 if(t_cckss>10){
                     $(dydkss.target).attr("value", 10);
                 }else {
                     $(dydkss.target).attr("value", t_cckss);
                 }
                 //第一档课时奖金
                 var  t_dydkss=parseFloat($(dydkss.target).val())||0;
                 var  t_ksf=parseFloat($(ksf.target).val())||0;
                 row.ksjj=t_ksf*t_dydkss;
                 $(ksjj.target).attr("value", row.ksjj);
                 //第二档课时数
                 if(t_cckss-t_dydkss>=10){
                     $(dedkss2.target).attr("value", 10);
                 }else {
                     $(dedkss2.target).attr("value", t_cckss-t_dydkss);
                 }
                 //第二档课时奖金
                 var  t_dedkss2=parseFloat($(dedkss2.target).val())||0;
                 var  t_ksf2=parseFloat($(ksf2.target).val())||0;
                 row.ksjj2=t_ksf2*t_dedkss2;
                 $(ksjj2.target).attr("value", row.ksjj2);
                 //第三档课时数
                 $(dsdkss3.target).attr("value", t_cckss-t_dydkss-t_dedkss2);
                 //第三档课时奖金
                 var  t_ksf3=parseFloat($(ksf3.target).val())||0;
                 var  t_dsdkss3=parseFloat($(dsdkss3.target).val())||0;
                 row.ksjj3=t_ksf3*t_dsdkss3;
                 $(ksjj3.target).attr("value", row.ksjj3);
                 //课时费合计
                 $(ksfhj.target).attr("value", row.ksjj+row.ksjj2+row.ksjj3);
             });
         });
     }
     //保存数据
     function saveData(title, addurl, gname) {
         var editIndex = $('#' + gname).datagrid('getRows').length - 1;
         for (var i = 0; i <= editIndex; i++) {
             if ($('#' + gname).datagrid('validateRow', i))
                 $('#' + gname).datagrid('endEdit', i);
         }
         var rows = $('#ayJxList').datagrid("getRows");
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
 			$("#ayJxListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayJxListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayJxController.do?upload', "ayJxList");
}

//导出
function ExportXls() {
 var sjpz = $("#riqiid").val();
	JeecgExcelExport("ayJxController.do?exportXls&sjpzid="+sjpz,"ayJxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayJxController.do?exportXlsByT","ayJxList");
}
 </script>