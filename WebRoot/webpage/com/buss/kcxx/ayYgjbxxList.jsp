<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ayYgjbxxList" checkbox="true" fitColumns="false" title="员工基本信息" actionUrl="ayKcxxController.do?datagridyg" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="姓名"  field="xm"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="xb"  query="true"  queryMode="single" dictionary="sex"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="sfzh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位"  field="zw"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="sr" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="入职日期"  field="rzrq"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在职状态"  field="zzzt"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="hyzk"    queryMode="single"  width="120"></t:dgCol>
   &lt;%&ndash;<t:dgCol title="审核状态"  field="shzt"    queryMode="single"  width="120"></t:dgCol>&ndash;%&gt;
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="填写人"  field="txr"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="填表时间"  field="tbsj"  formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt title="添加课程" funname="tjkc(id)" urlclass="ace_button"  urlfont="fa fa-gavel"></t:dgFunOpt>
   <%--<t:dgDelOpt title="删除" url="ayYgjbxxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ayYgjbxxController.do?goAdd" funname="add" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ayYgjbxxController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayYgjbxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ayYgjbxxController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/ygjbxx/ayYgjbxxList.js"></script>		
 <script type="text/javascript">
  function tjkc(ygid) {
      $.dialog.setting.zIndex = getzIndex(true);//只要弹窗在下边就加这个就都能解决
      //windowapi.close();//代办关闭父窗口
      layer.confirm("点击确认后添加已选择的员工信息课程，确认添加?", function () {
          $.ajax({
              url: 'ayKcxxController.do?doAddkc',
              type: 'post',
              data: {ygid: ygid},
              dataType: 'json',
              success: function (response) {
                  if (response.msg != null && response.msg != "") {
                      layer.msg(response.msg, {
                          time: 0 //不自动关闭
                          ,btn: ['确定'], yes: function (index) {
                              frameElement.api.close();
                              layer.close(index);
                              parentWin.reloadTable();
                          }});
                  }
              }
          });
          //window.location = "zjrzController.do?doDaiban&id="+id+"&fwlist="+fwlist;
      });
  }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ayYgjbxxListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ayYgjbxxListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
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