<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
    <input type="hidden" id = "lwmze" value="${lwmze}" />
        <t:datagrid name="ayLwgzList" checkbox="true" fitColumns="false" title="劳务工资"
                    actionUrl="ayLwgzController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group"
                    onLoadSuccess="onload">
            <t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属部门" field="sysOrgCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属公司" field="sysCompanyCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="流程状态" field="bpmStatus" hidden="true" queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>
            <t:dgCol title="姓名" field="xm" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="身份证号" field="sfzh" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="基本工资" field="jbgz" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="其他补贴" field="bt" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="合计" field="hj" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="免征额" field="mze" queryMode="single" width="120" extendParams="editor:'numberbox'"></t:dgCol>
            <t:dgCol title="实纳税所得额" field="snssde" queryMode="single" width="120" extendParams="editor:'numberbox'"></t:dgCol>
            <t:dgCol title="税率" field="sl" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="个人所得税" field="grsds" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="税后工资" field="shgz" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="其他" field="qt" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="实发工资" field="sfgz" queryMode="single" width="120" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="银行帐号" field="yhzh" queryMode="single" width="180" extendParams="editor:'numberbox'"></t:dgCol>
            <t:dgCol title="时间id" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="中心" field="zxbm" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="员工id" field="ygxxid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
            <%-- <t:dgDelOpt title="删除" url="ayLwgzController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
             <t:dgToolBar title="录入" icon="icon-add" url="ayLwgzController.do?goAdd" funname="add" width="800"></t:dgToolBar>--%>
            <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayLwgzController.do?goUpdate" funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayLwgzController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="ayLwgzController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
        </t:datagrid>
    </div>
</div>

<script type="text/javascript">
    function onload() {
        //changeEditGrid();
    }
    function changeEditGrid() {
        var grid = $('#ayLwgzList');
        //var rows=grid.datagrid('getRows');
        var rows = $('#ayLwgzList').datagrid("getRows");
        if (rows.length < 1) {
            return;
        }
        $.each(rows, function (i, row) {
            $('#ayLwgzList').datagrid('beginEdit', i);
            jisuangongzi(i,row);
             //基本工资
            var jbgz = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'jbgz'});
            //补贴
            var bt = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'bt'});
            //餐补
            var cb = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'cb'});
            //免征额
            var mze = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'mze'});
            //税率
            var sl = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'sl'});
            //其他
            var qt = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'qt'});
            jbgz.target.bind('change', function () {jisuangongzi(i,row);});
            cb.target.bind('change', function () {jisuangongzi(i,row);});
            bt.target.bind('change', function () {jisuangongzi(i,row);});
            mze.target.bind('change', function () {jisuangongzi(i,row);});
            sl.target.bind('change', function () {jisuangongzi(i,row);});
            qt.target.bind('change', function () {jisuangongzi(i,row);});
            
        });
    }
    
    //计算工资
    function jisuangongzi(i,row){
    	//免征额
            var mze = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'mze'});
            var mze_temp = $(mze.target).val();
            if(mze_temp==""||mze_temp==null){
            	//$(mze.target).attr("value", $("#lwmze").val());
            }
            
            //税率
            var sl = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'sl'});
            var sl_temp = $(sl.target).val();
            
           
            //基本工资
            var jbgz = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'jbgz'});
            //补贴
            var bt = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'bt'});
            //餐补
            var cb = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'cb'});
            //合计
            var hj = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'hj'});
            //实纳税所得额
            var snssde = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'snssde'}); 
            //个人所得税
            var grsds = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'grsds'});
            //税后工资
            var shgz = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'shgz'});
            //其他
            var qt = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'qt'});
            //实发工资
            var sfgz = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'sfgz'});
            //银行帐号
            var yhzh = $('#ayLwgzList').datagrid('getEditor', {index: i, field: 'yhzh'});
            
            
            var t_jbgz=parseFloat($(jbgz.target).val())||0;
            var t_bt=parseFloat($(bt.target).val())||0;
            var t_cb = parseFloat($(cb.target).val())||0;
            row.hj=t_jbgz+t_bt+t_cb;
            $(hj.target).attr("value", row.hj);
            var mze_1 = parseFloat($(mze.target).val())||0;
            row.snssde = row.hj - mze_1;
            $(snssde.target).attr("value", row.snssde);
            //个人所得税=实纳所得额*税率
            var sl_1 = parseFloat($(sl.target).val())||0;
            row.grsds = row.snssde * sl_1;
            $(grsds.target).attr("value", row.grsds);
            //税后工资= 合计-个人所得税
            row.shgz = row.hj - row.grsds;
            $(shgz.target).attr("value", row.shgz);
            //实发工资 = 税后工资 + 其他
            var t_qt = parseFloat($(qt.target).val())||0;
            row.sfgz = row.shgz + t_qt;
            $(sfgz.target).attr("value", row.sfgz);
            
            //只读
            $(hj.target).attr("disabled", "disabled");
            $(snssde.target).attr("disabled", "disabled");
            $(grsds.target).attr("disabled", "disabled");
            $(shgz.target).attr("disabled", "disabled");
            $(sfgz.target).attr("disabled", "disabled");
            $(mze.target).attr("disabled", "disabled");
            $(jbgz.target).attr("disabled", "disabled");
            $(yhzh.target).attr("disabled", "disabled");
    }
    
    //保存数据
    function saveData(title, addurl, gname) {
        var editIndex = $('#' + gname).datagrid('getRows').length - 1;
        for (var i = 0; i <= editIndex; i++) {
            if ($('#' + gname).datagrid('validateRow', i))
                $('#' + gname).datagrid('endEdit', i);

            var rows = $('#ayLwgzList').datagrid("getRows");
            //alert(JSON.stringify(rows));
            if (rows.length <= 0) {
                tip("没有需要保存的数据！");
                return false;
            }
            var result = {};
            for (var i = 0; i < rows.length; i++) {
                for (var d in rows[i]) {
               		if(d=="createDate"||d=="updateDate"){
               			var temp = rows[i][d];
               			temp = temp.split(".")[0];
               			rows[i][d] = temp;
               		}
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
                            , yes: function (index) {
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
            $("#ayGzListtb").find("input[name='createDate']").attr("class", "Wdate").click(function () {
                WdatePicker({dateFmt: 'yyyy-MM-dd'});
            });
            $("#ayGzListtb").find("input[name='updateDate']").attr("class", "Wdate").click(function () {
                WdatePicker({dateFmt: 'yyyy-MM-dd'});
            });
        });
    }
    $(document).ready(function () {
        //给时间控件加上样式
        $("#ayLwgzListtb").find("input[name='createDate']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#ayLwgzListtb").find("input[name='updateDate']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
    });


    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'ayLwgzController.do?upload', "ayLwgzList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("ayLwgzController.do?exportXls", "ayLwgzList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("ayLwgzController.do?exportXlsByT", "ayLwgzList");
    }
</script>