<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayShgjjList" checkbox="true" fitColumns="false" title="社保公积金" actionUrl="ayShgjjController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group" onLoadSuccess="onload">
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
   <t:dgCol title="姓名"  field="xm"    queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="岗位"  field="gw" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="员工类型"  field="yglx"    queryMode="single"  width="90"></t:dgCol>
   <t:dgCol title="户口类型"  field="hklx"    queryMode="single"  width="90"></t:dgCol>
   <t:dgCol title="养老保险基数"  field="ylbxjs" extendParams="editor:'numberbox'"   queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="其他四险基数"  field="qtsxjs"  extendParams="editor:'numberbox'"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="公积金基数"  field="gjjjs"  extendParams="editor:'numberbox'"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="养老保险公司承担部分"  field="ylbxgscd"   extendParams="editor:{type:'numberbox',options:{precision:2}}"   queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="失业保险公司承担部分"  field="sybxgscdbf1"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="医疗保险公司承担部分"  field="ylbxgscdbf1"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="工伤保险公司承担部分"  field="gsbxgscdbf"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="生育保险公司承担部分"  field="sybxgscdbf"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="住房公积金公司承担部分"  field="zfgjjgscdbf"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="养老保险个人承担部分"  field="ylbxgrcdbf"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="失业保险个人承担部分"  field="sybxgrcdbf2"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="医疗保险个人承担部分"  field="ylbxgrcdbf2"    extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="150"></t:dgCol>
   
   <t:dgCol title="工伤保险个人承担部分"  field="gsbxgrcdbf"    extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="生育保险个人承担部分"  field="sybxgrcdbf"    extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="医疗保险个人补充部分"  field="gsylbc"    extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="住房公积金个人承担部分"  field="zfgjjgrcdbf"   extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="150"></t:dgCol>
   
   <t:dgCol title="养老公司比例"  field="yanglgsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"   queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="失业公司比例"  field="shiygsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="医疗公司比例"  field="yilgsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="工伤公司比例"  field="gongsgsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="生育公司比例"  field="shengygsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金公司比例"  field="gongjjgsbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="135"></t:dgCol>
   <t:dgCol title="养老个人比例"  field="yanglgrbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="失业个人比例"  field="shiygrbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="医疗个人比例"  field="yilgrbili"  hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="工伤个人比例"  field="gongsgrbili"  hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="生育个人比例"  field="shengygrbili"  hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}" queryMode="single"  width="130"></t:dgCol>
   <t:dgCol title="住房公积金个比例"  field="gongjjgrbili" hidden="true"  extendParams="editor:{type:'numberbox',options:{precision:2}}"  queryMode="single"  width="135"></t:dgCol>
   
   <t:dgCol title="住房公积金合计"  field="zfgjjhj" extendParams="editor:{type:'numberbox',options:{precision:2}}"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="保险合计"  field="bxhj"   extendParams="editor:{type:'numberbox',options:{precision:2}}"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  extendParams="editor:'text'"  queryMode="single"  width="220"></t:dgCol>
   <t:dgCol title="中心"  field="zxbm"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="员工id"  field="ygxxid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间id"  field="sjpzid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
 <%--  <t:dgToolBar title="保存" icon="icon-add" url="ayShgjjController.do?saveRows" funname="saveData" width="800"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-ok" url="ayShgjjController.do?submitRows" funname="saveData" width="800"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-add" url="ayShgjjController.do?doTiJiao" funname="saveData" width="800"></t:dgToolBar> --%>
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
         //changeEditGrid();
     }
     function changeEditGrid() {
         var grid = $('#ayShgjjList');

         var rows = $('#ayShgjjList').datagrid("getRows");

         if (rows.length < 1) {
             return;
         }
         $.each(rows, function (i, row) {
             $('#ayShgjjList').datagrid('beginEdit', i);
             var ylbxjs = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'ylbxjs'});
             var qtsxjs = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'qtsxjs'});
             var gjjjs = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gjjjs'});
             var ylbxgscd = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'ylbxgscd'});
             var sybxgscdbf1 = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'sybxgscdbf1'});
             var ylbxgscdbf1 = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'ylbxgscdbf1'});
             var gsbxgscdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gsbxgscdbf'});
             var sybxgscdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'sybxgscdbf'});
             var zfgjjgscdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'zfgjjgscdbf'});
             var ylbxgrcdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'ylbxgrcdbf'});
             var sybxgrcdbf2 = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'sybxgrcdbf2'});
             var ylbxgrcdbf2 = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'ylbxgrcdbf2'});
             var zfgjjgrcdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'zfgjjgrcdbf'});
             
             var gsbxgrcdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gsbxgrcdbf'});
             var sybxgrcdbf = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'sybxgrcdbf'});
             
             
             var yanglgsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'yanglgsbili'});
             var shiygsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'shiygsbili'});
             var yilgsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'yilgsbili'});
             var gongsgsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gongsgsbili'});
             var shengygsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'shengygsbili'});
             var gongjjgsbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gongjjgsbili'});
             var yanglgrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'yanglgrbili'});
             var shiygrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'shiygrbili'});
             var yilgrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'yilgrbili'});
             var gongsgrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gongsgrbili'});
             var shengygrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'shengygrbili'});
             var gongjjgrbili = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gongjjgrbili'});
             
             var bxhj = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'bxhj'});
             var zfgjjhj = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'zfgjjhj'});
             var gsylbc = $('#ayShgjjList').datagrid('getEditor', {index: i, field: 'gsylbc'});
             //if($(gsylbc.target).val()==null||$(gsylbc.target).val()==""||$(gsylbc.target).val()==0){
             //    $(gsylbc.target).attr("value", 3);
             //}
             //只读
             $(ylbxgscd.target).attr("disabled", "disabled");
             $(sybxgscdbf1.target).attr("disabled", "disabled");
             $(ylbxgscdbf1.target).attr("disabled", "disabled");
             $(gsbxgscdbf.target).attr("disabled", "disabled");
             $(sybxgscdbf.target).attr("disabled", "disabled");
             $(zfgjjgscdbf.target).attr("disabled", "disabled");
             $(ylbxgrcdbf.target).attr("disabled", "disabled");
             $(sybxgrcdbf2.target).attr("disabled", "disabled");
             $(ylbxgrcdbf2.target).attr("disabled", "disabled");
             $(zfgjjgrcdbf.target).attr("disabled", "disabled");
             $(bxhj.target).attr("disabled", "disabled");
             $(zfgjjhj.target).attr("disabled", "disabled");
             $(gsbxgrcdbf.target).attr("disabled", "disabled");
             $(sybxgrcdbf.target).attr("disabled", "disabled");
             
             
             
              var t_ylbxjs=parseFloat($(ylbxjs.target).val())||0;
                 
                 var t_yanglgsbili = parseFloat($(yanglgsbili.target).val())||0;
                 var t_yanglgrbili = parseFloat($(yanglgrbili.target).val())||0;
                 row.ylbxgscd=(t_ylbxjs*t_yanglgsbili/100).toFixed(2);
                 row.ylbxgrcdbf=(t_ylbxjs*t_yanglgrbili/100).toFixed(2);
                 $(ylbxgrcdbf.target).attr("value", row.ylbxgrcdbf);
                 $(ylbxgscd.target).attr("value", row.ylbxgscd);
                 
                  var t_qtsxjs=parseFloat($(qtsxjs.target).val())||0;
                 var t_shiygsbili = parseFloat($(shiygsbili.target).val())||0;
                 var t_shiygrbili = parseFloat($(shiygrbili.target).val())||0;
                 var t_yilgsbili = parseFloat($(yilgsbili.target).val())||0;
                 var t_yilgrbili = parseFloat($(yilgrbili.target).val())||0;
                 var t_gongsgsbili = parseFloat($(gongsgsbili.target).val())||0;
                 var t_gongsgrbili = parseFloat($(gongsgrbili.target).val())||0;
                 var t_shengygsbili = parseFloat($(shengygsbili.target).val())||0;
                 var t_shengygrbili = parseFloat($(shengygrbili.target).val())||0;
                 //失业公司
                 row.sybxgscdbf1 = (t_qtsxjs*t_shiygsbili/100).toFixed(2);
                 //医疗公司
                 row.ylbxgscdbf1 = (t_qtsxjs*t_yilgsbili/100).toFixed(2);
                 //工伤公司
                 row.gsbxgscdbf = (t_qtsxjs * t_gongsgsbili/100).toFixed(2);
                 //生育公司
                 row.sybxgscdbf = (t_qtsxjs* t_shengygsbili/100).toFixed(2);
                 //失业个人
                 row.sybxgrcdbf2 = (t_qtsxjs*t_shiygrbili/100).toFixed(2);
                 //医疗个人
                 row.ylbxgrcdbf2 = (t_qtsxjs*t_yilgrbili/100).toFixed(2);
                 //工伤个人
                 row.gsbxgrcdbf = (t_qtsxjs*t_gongsgrbili/100).toFixed(2);
                 //生育个人
                 row.sybxgrcdbf = (t_qtsxjs*t_shengygrbili/100).toFixed(2);
               
                 $(sybxgscdbf1.target).attr("value",row.sybxgscdbf1);
                 $(ylbxgscdbf1.target).attr("value",row.ylbxgscdbf1);
                 $(gsbxgscdbf.target).attr("value",row.gsbxgscdbf);
                 $(sybxgscdbf.target).attr("value",row.sybxgscdbf);
                 $(sybxgrcdbf2.target).attr("value",row.sybxgrcdbf2);
                 $(ylbxgrcdbf2.target).attr("value",row.ylbxgrcdbf2);
                 $(gsbxgrcdbf.target).attr("value",row.gsbxgrcdbf);
                 $(sybxgrcdbf.target).attr("value",row.sybxgrcdbf);
                 //保险合计
                 var t_ylbxgscd=parseFloat($(ylbxgscd.target).val())||0;
                 var t_sybxgscdbf1=parseFloat($(sybxgscdbf1.target).val())||0;
                 var t_ylbxgscdbf1=parseFloat($(ylbxgscdbf1.target).val())||0;
                 var t_gsbxgscdbf=parseFloat($(gsbxgscdbf.target).val())||0;
                 var t_sybxgscdbf=parseFloat($(sybxgscdbf.target).val())||0;
                 var t_ylbxgrcdbf=parseFloat($(ylbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf2=parseFloat($(sybxgrcdbf2.target).val())||0;
                 var t_ylbxgrcdbf2=parseFloat($(ylbxgrcdbf2.target).val())||0;
                 
                 var t_gsbxgrcdbf=parseFloat($(gsbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf=parseFloat($(sybxgrcdbf.target).val())||0;
                 
                 row.bxhj=t_ylbxgscd+t_sybxgscdbf1+t_ylbxgscdbf1+t_gsbxgscdbf+t_sybxgscdbf+t_ylbxgrcdbf+t_sybxgrcdbf2+t_ylbxgrcdbf2+t_gsbxgrcdbf+t_sybxgrcdbf;
                 $(bxhj.target).attr("value", row.bxhj);
             
             
             	var t_gjjjs=parseFloat($(gjjjs.target).val())||0;
                 
                 var t_gongjjgsbili = parseFloat($(gongjjgsbili.target).val())||0;
                 var t_gongjjgrbili = parseFloat($(gongjjgrbili.target).val())||0;
                 
                 row.zfgjjgscdbf=(t_gjjjs*t_gongjjgsbili/100).toFixed(2);
                 $(zfgjjgscdbf.target).attr("value", row.zfgjjgscdbf);
                 row.zfgjjgrcdbf=(t_gjjjs*t_gongjjgrbili/100).toFixed(2);
                 $(zfgjjgrcdbf.target).attr("value", row.zfgjjgrcdbf);
                 //保险合计
                 var t_ylbxgscd=parseFloat($(ylbxgscd.target).val())||0;
                 var t_sybxgscdbf1=parseFloat($(sybxgscdbf1.target).val())||0;
                 var t_ylbxgscdbf1=parseFloat($(ylbxgscdbf1.target).val())||0;
                 var t_gsbxgscdbf=parseFloat($(gsbxgscdbf.target).val())||0;
                 var t_sybxgscdbf=parseFloat($(sybxgscdbf.target).val())||0;
                 var t_ylbxgrcdbf=parseFloat($(ylbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf2=parseFloat($(sybxgrcdbf2.target).val())||0;
                 var t_ylbxgrcdbf2=parseFloat($(ylbxgrcdbf2.target).val())||0;
                 
                 var t_gsbxgrcdbf=parseFloat($(gsbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf=parseFloat($(sybxgrcdbf.target).val())||0;
                 
                 row.bxhj=t_ylbxgscd+t_sybxgscdbf1+t_ylbxgscdbf1+t_gsbxgscdbf+t_sybxgscdbf+t_ylbxgrcdbf+t_sybxgrcdbf2+t_ylbxgrcdbf2+t_gsbxgrcdbf+t_sybxgrcdbf;
                 $(bxhj.target).attr("value", row.bxhj);
                 //公积金合计
                 var t_zfgjjgscdbf=parseFloat($(zfgjjgscdbf.target).val())||0;
                 var t_zfgjjgrcdbf=parseFloat($(zfgjjgrcdbf.target).val())||0;
                 row.zfgjjhj=t_zfgjjgscdbf+t_zfgjjgrcdbf;
                 $(zfgjjhj.target).attr("value", row.zfgjjhj);


             //qtsxjs.target.bind('focus', function () {//绑定获取焦点事件
             //    return false;
             //});
             ylbxjs.target.bind('change', function () {//养老保险基数
                 var t_ylbxjs=parseFloat($(ylbxjs.target).val())||0;
                 
                 var t_yanglgsbili = parseFloat($(yanglgsbili.target).val())||0;
                 var t_yanglgrbili = parseFloat($(yanglgrbili.target).val())||0;
                 row.ylbxgscd=(t_ylbxjs*t_yanglgsbili/100).toFixed(2);
                 row.ylbxgrcdbf=(t_ylbxjs*t_yanglgrbili/100).toFixed(2);
                 $(ylbxgrcdbf.target).attr("value", row.ylbxgrcdbf);
                 $(ylbxgscd.target).attr("value", row.ylbxgscd);
                 
                 
                 //保险合计
                 var t_ylbxgscd=parseFloat($(ylbxgscd.target).val())||0;
                 var t_sybxgscdbf1=parseFloat($(sybxgscdbf1.target).val())||0;
                 var t_ylbxgscdbf1=parseFloat($(ylbxgscdbf1.target).val())||0;
                 var t_gsbxgscdbf=parseFloat($(gsbxgscdbf.target).val())||0;
                 var t_sybxgscdbf=parseFloat($(sybxgscdbf.target).val())||0;
                 var t_ylbxgrcdbf=parseFloat($(ylbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf2=parseFloat($(sybxgrcdbf2.target).val())||0;
                 var t_ylbxgrcdbf2=parseFloat($(ylbxgrcdbf2.target).val())||0;
                 
                 var t_gsbxgrcdbf=parseFloat($(gsbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf=parseFloat($(sybxgrcdbf.target).val())||0;
                 
                 row.bxhj=t_ylbxgscd+t_sybxgscdbf1+t_ylbxgscdbf1+t_gsbxgscdbf+t_sybxgscdbf+t_ylbxgrcdbf+t_sybxgrcdbf2+t_ylbxgrcdbf2+t_gsbxgrcdbf+t_sybxgrcdbf;
                 $(bxhj.target).attr("value", row.bxhj);

             });
             qtsxjs.target.bind('change', function () {//其他四险
                 var t_qtsxjs=parseFloat($(qtsxjs.target).val())||0;
                 var t_shiygsbili = parseFloat($(shiygsbili.target).val())||0;
                 var t_shiygrbili = parseFloat($(shiygrbili.target).val())||0;
                 var t_yilgsbili = parseFloat($(yilgsbili.target).val())||0;
                 var t_yilgrbili = parseFloat($(yilgrbili.target).val())||0;
                 var t_gongsgsbili = parseFloat($(gongsgsbili.target).val())||0;
                 var t_gongsgrbili = parseFloat($(gongsgrbili.target).val())||0;
                 var t_shengygsbili = parseFloat($(shengygsbili.target).val())||0;
                 var t_shengygrbili = parseFloat($(shengygrbili.target).val())||0;
                 //失业公司
                 row.sybxgscdbf1 = (t_qtsxjs*t_shiygsbili/100).toFixed(2);
                 //医疗公司
                 row.ylbxgscdbf1 = (t_qtsxjs*t_yilgsbili/100).toFixed(2);
                 //工伤公司
                 row.gsbxgscdbf = (t_qtsxjs * t_gongsgsbili/100).toFixed(2);
                 //生育公司
                 row.sybxgscdbf = (t_qtsxjs* t_shengygsbili/100).toFixed(2);
                 //失业个人
                 row.sybxgrcdbf2 = (t_qtsxjs*t_shiygrbili/100).toFixed(2);
                 //医疗个人
                 row.ylbxgrcdbf2 = (t_qtsxjs*t_yilgrbili/100).toFixed(2);
                 //工伤个人
                 row.gsbxgrcdbf = (t_qtsxjs*t_gongsgrbili/100).toFixed(2);
                 //生育个人
                 row.sybxgrcdbf = (t_qtsxjs*t_shengygrbili/100).toFixed(2);
               
                 $(sybxgscdbf1.target).attr("value",row.sybxgscdbf1);
                 $(ylbxgscdbf1.target).attr("value",row.ylbxgscdbf1);
                 $(gsbxgscdbf.target).attr("value",row.gsbxgscdbf);
                 $(sybxgscdbf.target).attr("value",row.sybxgscdbf);
                 $(sybxgrcdbf2.target).attr("value",row.sybxgrcdbf2);
                 $(ylbxgrcdbf2.target).attr("value",row.ylbxgrcdbf2);
                 $(gsbxgrcdbf.target).attr("value",row.gsbxgrcdbf);
                 $(sybxgrcdbf.target).attr("value",row.sybxgrcdbf);
                 //保险合计
                 var t_ylbxgscd=parseFloat($(ylbxgscd.target).val())||0;
                 var t_sybxgscdbf1=parseFloat($(sybxgscdbf1.target).val())||0;
                 var t_ylbxgscdbf1=parseFloat($(ylbxgscdbf1.target).val())||0;
                 var t_gsbxgscdbf=parseFloat($(gsbxgscdbf.target).val())||0;
                 var t_sybxgscdbf=parseFloat($(sybxgscdbf.target).val())||0;
                 var t_ylbxgrcdbf=parseFloat($(ylbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf2=parseFloat($(sybxgrcdbf2.target).val())||0;
                 var t_ylbxgrcdbf2=parseFloat($(ylbxgrcdbf2.target).val())||0;
                 
                 var t_gsbxgrcdbf=parseFloat($(gsbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf=parseFloat($(sybxgrcdbf.target).val())||0;
                 
                 row.bxhj=t_ylbxgscd+t_sybxgscdbf1+t_ylbxgscdbf1+t_gsbxgscdbf+t_sybxgscdbf+t_ylbxgrcdbf+t_sybxgrcdbf2+t_ylbxgrcdbf2+t_gsbxgrcdbf+t_sybxgrcdbf;
                 $(bxhj.target).attr("value", row.bxhj);


             });
             gjjjs.target.bind('change', function () {//公积金基数
                 var t_gjjjs=parseFloat($(gjjjs.target).val())||0;
                 
                 var t_gongjjgsbili = parseFloat($(gongjjgsbili.target).val())||0;
                 var t_gongjjgrbili = parseFloat($(gongjjgrbili.target).val())||0;
                 
                 row.zfgjjgscdbf=(t_gjjjs*t_gongjjgsbili/100).toFixed(2);
                 $(zfgjjgscdbf.target).attr("value", row.zfgjjgscdbf);
                 row.zfgjjgrcdbf=(t_gjjjs*t_gongjjgrbili/100).toFixed(2);
                 $(zfgjjgrcdbf.target).attr("value", row.zfgjjgrcdbf);
                 //保险合计
                 var t_ylbxgscd=parseFloat($(ylbxgscd.target).val())||0;
                 var t_sybxgscdbf1=parseFloat($(sybxgscdbf1.target).val())||0;
                 var t_ylbxgscdbf1=parseFloat($(ylbxgscdbf1.target).val())||0;
                 var t_gsbxgscdbf=parseFloat($(gsbxgscdbf.target).val())||0;
                 var t_sybxgscdbf=parseFloat($(sybxgscdbf.target).val())||0;
                 var t_ylbxgrcdbf=parseFloat($(ylbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf2=parseFloat($(sybxgrcdbf2.target).val())||0;
                 var t_ylbxgrcdbf2=parseFloat($(ylbxgrcdbf2.target).val())||0;
                 
                 var t_gsbxgrcdbf=parseFloat($(gsbxgrcdbf.target).val())||0;
                 var t_sybxgrcdbf=parseFloat($(sybxgrcdbf.target).val())||0;
                 
                 row.bxhj=t_ylbxgscd+t_sybxgscdbf1+t_ylbxgscdbf1+t_gsbxgscdbf+t_sybxgscdbf+t_ylbxgrcdbf+t_sybxgrcdbf2+t_ylbxgrcdbf2+t_gsbxgrcdbf+t_sybxgrcdbf;
                 $(bxhj.target).attr("value", row.bxhj);
                 //公积金合计
                 var t_zfgjjgscdbf=parseFloat($(zfgjjgscdbf.target).val())||0;
                 var t_zfgjjgrcdbf=parseFloat($(zfgjjgrcdbf.target).val())||0;
                 row.zfgjjhj=t_zfgjjgscdbf+t_zfgjjgrcdbf;
                 $(zfgjjhj.target).attr("value", row.zfgjjhj);
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

             };
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
	JeecgExcelExport("ayShgjjController.do?exportXls","ayShgjjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayShgjjController.do?exportXlsByT","ayShgjjList");
}
 </script>