<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayKcpzList" checkbox="true" fitColumns="false" title="" actionUrl="ayKcpzController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"   hidden="true"  queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
   <t:dgCol title="课程编码"  field="kcbm"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="课程名称"  field="kcmc"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中心"  field="zx"    queryMode="single"  formatterjs="renderText" width="120" ></t:dgCol>
   <t:dgCol title="系数"  field="xs"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt title="设置课程" funname="szkc(id)" urlclass="ace_button" urlfont="fa fa-download"></t:dgFunOpt>
  <%-- <t:dgDelOpt title="删除" url="ayKcpzController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayKcpzController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayKcpzController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayKcpzController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayKcpzController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
 <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
  function szkc(id) {
      var kcid = '${kcid}';
      layer.confirm("添加已选择信息课程，确认添加?", function () {
          $.ajax({
              url: 'ayKcxxController.do?doUpKc',
              type: 'post',
              data: {kcid: kcid,id:id},
              dataType: 'json',
              success: function (response) {
                  if (response.msg != null && response.msg != "") {
                      layer.msg(response.msg, {
                          time: 0 //不自动关闭
                          , btn: ['确定'], yes: function (index) {
                              frameElement.api.close();
                              layer.close(index);
                              parentWin.reloadTable();
                          }
                      });
                  }
              }
          });
          //window.location = "zjrzController.do?doDaiban&id="+id+"&fwlist="+fwlist;
      });

  }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayKcpzListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayKcpzListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 var json = '${allCenters}';
 var jsonObject = JSON.parse(json);
 //转换函数
 function renderText(v,row,index){
     var s = "";
     if(v){
         s =  jsonObject[v];
     }
     return s;
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ayKcpzController.do?upload', "ayKcpzList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ayKcpzController.do?exportXls","ayKcpzList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ayKcpzController.do?exportXlsByT","ayKcpzList");
}
 </script>