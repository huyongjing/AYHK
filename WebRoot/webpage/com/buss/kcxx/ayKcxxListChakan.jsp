<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<input type="hidden" value="${sjpzid}" id="riqiid"  />
<t:datagrid name="kcxxList" title="" actionUrl="ayKcxxController.do?datagrid&sjpzid=${sjpzid}"
            idField="id" queryMode="group" checkbox="true" onLoadSuccess="onload">
    <t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="主键" field="ygxxid" hidden="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="主键" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
    <%--<t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>--%>
    <t:dgCol title="姓名" field="xm" align="center" queryMode="single" width="100"></t:dgCol>
    <t:dgCol title="课程名" field="kcmc" align="center" queryMode="single" width="150"></t:dgCol>
    <t:dgCol title="课程系数" field="kcxs" align="center" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="课程时间" field="kcsj" align="center" queryMode="single" extendParams="editor:'numberbox'" width="120"></t:dgCol>
    <t:dgCol title="课程合计" field="kchj" align="center" queryMode="single" extendParams="editor:'numberbox'" width="120"></t:dgCol>
    <t:dgCol title="个人合计" field="grhj" align="center" queryMode="single" extendParams="editor:{type:'numberbox',options:{precision:2}}" width="120"></t:dgCol>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
    <%--<t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit"  funname="editRow"></t:dgToolBar>--%>
   <%-- <t:dgToolBar operationCode="save" title="保存" icon="icon-save" url="kcxxController.do?saveRows" funname="saveData"></t:dgToolBar>--%>
    <%--<t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" funname="editRow"></t:dgToolBar>--%>
</t:datagrid>
<script type="text/javascript">
    function onload() {
     $('#kcxxList').datagrid("autoMergeCells", ['xm','sfzh']);
        mergeGRHJ();
    }
    
    function mergeGRHJ(){
    	 var rows = $('#kcxxList').datagrid("getRows");
    	 var temp = '';
    	 var num = 0;
    	 for (var i = 0; i < rows.length; i++) {
    	 	temp = rows[0]['ygxxid'];
    	 	if(rows[i]['ygxxid']==temp){
    	 		num = num+1;
    	 	}
    	 }
    	 if(num!=0){
    	 	var data = $('#kcxxList').datagrid('getData');
	    	 for(var i=0;i<=data.total;i++){
	    	 	if(i%num==0){
	    	 		$('#kcxxList').datagrid('mergeCells',{
		    	 		index:i,
	    	 			field:'grhj',
	    	 			width:100,
	    	 			rowspan:num
    	 			});
	    	 	}
	    	 }
    	 }
    }
    
    //指定列求和
    function compute(colName) {
        var rows = $('#kcxxList').datagrid('getRows');
        var total = 0;
        //不计算最后行 rows.length-1
        for (var i = 0; i < rows.length; i++) {
            var t = rows[i][colName];
            if (t == '' || t == 'null') {
            } else {
                total += parseFloat(rows[i][colName]);
            }
        }
        if (total) {
            total = total;
        }
        return total.toFixed(2);
    }

    function formatt(rec, val, index) {
        if (rec === null || rec == "null") {
            return "0";
        } else {
            return rec;
        }
    }



    //添加行
    function addRow(title, addurl, gname) {
        $('#' + gname).datagrid('appendRow', {});
        var editIndex = $('#' + gname).datagrid('getRows').length - 1;
        $('#' + gname).datagrid('selectRow', editIndex)
            .datagrid('beginEdit', editIndex);
    }
    //保存数据
    function saveData(title, addurl, gname) {
        /*if (!endEdit(gname))
         return false;*/
        var rows = $('#' + gname).datagrid("getChanges", "inserted");
        var uprows = $('#' + gname).datagrid("getChanges", "updated");
        var rows = $('#kcxxList').datagrid("getRows");
        rows = rows.concat(uprows);
        if (rows.length <= 0) {
            tip("没有需要保存的数据！");
            return false;
        }
        var rows1 = $('#kcxxList').datagrid('getRows');
        var result = {};
        for (var i = 0; i < rows.length; i++) {
            for (var d in rows[i]) {
                result["demos[" + i + "]." + d] = rows[i][d];
                // alert(rows[i][d]);

            }
        }
       // alert(JSON.stringify(result));
        //var rows = $('#kcxxList').datagrid('getRows')//获取当前的数据行
        $.ajax({
            url: "${pageContext.request.contextPath}/" + addurl,
            type: "post",
            data: result,
            dataType: "json",
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
    //结束编辑
    function endEdit(gname) {
        var editIndex = $('#' + gname).datagrid('getRows').length - 1;
        for (var i = 0; i <= editIndex; i++) {
            if ($('#' + gname).datagrid('validateRow', i))
                $('#' + gname).datagrid('endEdit', i);
            else
                return false;
        }
        return true;
    }
    //编辑行
    function editRow(title, addurl, gname) {
        var rows = $('#' + gname).datagrid("getChecked");
        alert(JSON.stringify(rows));
        if (rows.length == 0) {
            tip("请选择条目");
            return false;
        }
        for (var i = 0; i < rows.length; i++) {
            var index = $('#' + gname).datagrid('getRowIndex', rows[i]);
            $('#' + gname).datagrid('beginEdit', index);
        }
    }
    //取消编辑
    function reject(title, addurl, gname) {
        $('#kcxxList').datagrid('clearChecked');
        $('#kcxxList').datagrid('rejectChanges');

    }
    
    $.extend($.fn.datagrid.methods, {
        autoMergeCells : function (jq, fields) {
            return jq.each(function () {
                var target = $(this);
                if (!fields) {
                    fields = target.datagrid("getColumnFields");
                }
                var rows = target.datagrid("getRows");
                var i = 0,
                    j = 0,
                    temp = {};
                for (i; i < rows.length; i++) {
                    var row = rows[i];
                    j = 0;
                    for (j; j < fields.length; j++) {
                        var field = fields[j];
                        var tf = temp[field];
                        if (!tf) {
                            tf = temp[field] = {};
                            tf[row[field]] = [i];
                        } else {
                            var tfv = tf[row[field]];
                            if (tfv) {
                                tfv.push(i);
                            } else {
                                tfv = tf[row[field]] = [i];
                            }
                        }
                    }
                }
                $.each(temp, function (field, colunm) {
                    $.each(colunm, function () {
                        var group = this;

                        if (group.length > 1) {
                            var before,
                                after,
                                megerIndex = group[0];
                            for (var i = 0; i < group.length; i++) {
                                before = group[i];
                                after = group[i + 1];
                                if (after && (after - before) == 1) {
                                    continue;
                                }
                                var rowspan = before - megerIndex + 1;
                                if (rowspan > 1) {
                                    target.datagrid('mergeCells', {
                                        index : megerIndex,
                                        field : field,
                                        rowspan : rowspan
                                    });
                                }
                                if (after && (after - before) != 1) {
                                    megerIndex = after;
                                }
                            }
                        }
                    });
                });
            });
        }
    });
    
    
    
    //导出
	function ExportXls() {
	    var sjpz = $("#riqiid").val();
		JeecgExcelExport("ayKcxxController.do?exportXls&sjpzid="+sjpz,"kcxxList");
	}
</script>

