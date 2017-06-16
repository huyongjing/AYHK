<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
    <input type="hidden" value="${sjpzid}" id="riqiid"  />
        <t:datagrid name="ayKqxxList" checkbox="true" fitColumns="false" title="考勤信息表"
                    actionUrl="ayKqxxController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group"
                    onLoadSuccess="onload">
            <t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="时间主键" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single"
                     width="120"></t:dgCol>
            <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single"
                     width="120"></t:dgCol>
            <t:dgCol title="所属部门" field="sysOrgCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属公司" field="sysCompanyCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <%--<t:dgCol title="流程状态"  field="bpmStatus"    queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>--%>
            <t:dgCol title="姓名" field="xm" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="员工类型" field="yglx" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="当月应出勤(天)" field="dyycq" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="实际出勤(天)" field="sjcq" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="出差(天)" field="cc" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="计薪日(天)" field="jxr" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="餐补(天)" field="cb" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="交通补(天)" field="jtb" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="住房补贴标准" field="zfbtbz" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="住房补(天)" field="zfb" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="法定假或公休带薪假(天)" field="fdj" queryMode="single" width="135" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="未入职或离职(天)" field="wrz" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="病假(天)" field="bj" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="事假(天)" field="sj" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="调休(天)" field="tx" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="带薪年假(天)" field="dxnj" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="当年年假(天)" field="dnnj" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <%--<t:dgCol title="当年剩余年假(天)" field="dnsynj" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="加班日期" field="jbrq" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="加班事由" field="jbsy" queryMode="single" width="120" extendParams="editor:'text'" ></t:dgCol>--%>
            <t:dgCol title="加班天数" field="jbts" queryMode="single" width="120"  extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="剩余加班(天)" field="syjb" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="备注" field="bz" queryMode="single" width="330" extendParams="editor:'text'" ></t:dgCol>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="ayKqxxController.do?doDel&id={id}" urlclass="ace_button" urlfont="fa-trash-o"/>--%>
            <%--<t:dgToolBar title="保存" icon="icon-add" url="ayKqxxController.do?saveRows" funname="saveData" width="800"></t:dgToolBar>--%>
           <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="ayKqxxController.do?goUpdate" funname="update" width="800"></t:dgToolBar>
            <t:dgToolBar title="批量删除" icon="icon-remove" url="ayKqxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
            --%><%--<t:dgToolBar title="查看" icon="icon-search" url="ayKqxxController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
        </t:datagrid>
    </div>
</div>
<script src="webpage/com/buss/kqxx/ayKqxxList.js"></script>
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

        /*if (!endEdit(gname))
         return false;*/
       //   var rows = $('#' + gname).datagrid("getChanges", "inserted");
       // var uprows = $('#' + gname).datagrid("getChanges", "updated");
        var rows = $('#ayKqxxList').datagrid("getRows");
        //rows = rows.concat(rows);
        if (rows.length <= 0) {
            tip("没有需要保存的数据！");
            return false;
        }
        var result =  {};
        //var rows1 = $('#ayKqxxList').datagrid('getRows');
       // var resultList = [];
        for (var i = 0; i < rows.length; i++) {
            for (var d in rows[i]) {
                result["demos[" + i + "]." + d] = rows[i][d];

            }
        }


//        var rows = $('#ayKqxxList').datagrid('getRows')//获取当前的数据行
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
    $(document).ready(function () {
        //给时间控件加上样式
        $("#ayKqxxListtb").find("input[name='createDate']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#ayKqxxListtb").find("input[name='updateDate']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
    });


    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'ayKqxxController.do?upload', "ayKqxxList");
    }

    //导出
    function ExportXls() {
    	var sjpz = $("#riqiid").val();
        JeecgExcelExport("ayKqxxController.do?exportXls&sjpzid="+sjpz, "ayKqxxList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("ayKqxxController.do?exportXlsByT", "ayKqxxList");
    }
</script>