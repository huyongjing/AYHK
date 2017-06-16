<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<link id="easyuiTheme" rel="stylesheet" href="plug-in/easyui/themes/metrole/easyui.css" type="text/css"></link>
<link id="easyuiTheme" rel="stylesheet" href="plug-in/easyui/themes/metrole/main.css" type="text/css"></link>
<link id="easyuiTheme" rel="stylesheet" href="plug-in/easyui/themes/metrole/icon.css" type="text/css"></link>
<link rel="stylesheet" type="text/css" href="plug-in/accordion/css/accordion.css">
<link rel="stylesheet" type="text/css" href="plug-in/accordion/css/icons.css">
<script type="text/javascript" src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
<script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
<script type="text/javascript" src="plug-in/easyui/extends/datagrid-scrollview.js"></script>
<script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="plug-in/tools/css/metrole/common.css" type="text/css"></link>
<link rel="stylesheet" href="plug-in/ace/css/font-awesome.css" type="text/css"></link>
<script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js?skin=metrole"></script>
<script type="text/javascript" src="plug-in/ace/js/bootstrap-tab.js"></script>
<script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
<script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
<script type="text/javascript" src="plug-in/jquery-plugs/hftable/jquery-hftable.js"></script>
<script type="text/javascript" src="plug-in/tools/json2.js"></script>


<script type="text/javascript">$(function () {
    storage = $.localStorage;
    if (!storage) storage = $.cookieStorage;
    $('#jeecgDemoList2').datagrid({
        idField: 'id',
        title: '行编辑',
        url: 'kcxxController.do?datagrid&field=id,kcmc,userName,xshj,createDate,email,age,salary,birthday,sex,',
        fit: true,
        queryParams: {},
        loadMsg: '数据加载中...',
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        sortOrder: 'asc',
        rownumbers: true,
        singleSelect: false,
        fitColumns: true,
        striped: true,
        showFooter: true,
        frozenColumns: [[{field: 'ck', checkbox: 'true'},]],
        columns: [[
            {field: 'id', title: '编号', hidden: true, sortable: true},
            {field: 'userName', title: '用户名', editor: 'text', sortable: true,width:50},
            {field: 'kcmc', title: '课程名称', editor: 'text', sortable: true,width:50},
            {field: 'xshj', title: '系数合计', sortable: true,width:50},
        ]],
        onLoadSuccess: function (data) {
            $("#jeecgDemoList2").datagrid("clearSelections");
        },
        onClickRow: function (rowIndex, rowData) {
            rowid = rowData.id;
            gridname = 'jeecgDemoList2';
        }
    });
    $('#jeecgDemoList2').datagrid('getPager').pagination({
        beforePageText: '',
        afterPageText: '/{pages}',
        displayMsg: '{from}-{to}共 {total}条',
        showPageList: true,
        showRefresh: true
    });
    $('#jeecgDemoList2').datagrid('getPager').pagination({
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            $(this).pagination('loaded');
        }
    });
    try {
        restoreheader();
    } catch (ex) {
    }
});
function reloadTable() {
    try {
        $('#' + gridname).datagrid('reload');
        $('#' + gridname).treegrid('reload');
    } catch (ex) {
    }
}
function reloadjeecgDemoList2() {
    $('#jeecgDemoList2').datagrid('reload');
}
function getjeecgDemoList2Selected(field) {
    return getSelected(field);
}
function getSelected(field) {
    var row = $('#' + gridname).datagrid('getSelected');
    if (row != null) {
        value = row[field];
    } else {
        value = '';
    }
    return value;
}
function getjeecgDemoList2Selections(field) {
    var ids = [];
    var rows = $('#jeecgDemoList2').datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids.push(rows[i][field]);
    }
    ids.join(',');
    return ids;
}
;
function getSelectRows() {
    return $('#jeecgDemoList2').datagrid('getChecked');
}
function saveHeader() {
    var columnsFields = null;
    var easyextends = false;
    try {
        columnsFields = $('#jeecgDemoList2').datagrid('getColumns');
        easyextends = true;
    } catch (e) {
        columnsFields = $('#jeecgDemoList2').datagrid('getColumnFields');
    }
    var cols = storage.get('jeecgDemoList2hiddenColumns');
    var init = true;
    if (cols) {
        init = false;
    }
    var hiddencolumns = [];
    for (var i = 0; i < columnsFields.length; i++) {
        if (easyextends) {
            hiddencolumns.push({field: columnsFields[i].field, hidden: columnsFields[i].hidden});
        } else {
            var columsDetail = $('#jeecgDemoList2').datagrid("getColumnOption", columnsFields[i]);
            if (init) {
                hiddencolumns.push({
                    field: columsDetail.field,
                    hidden: columsDetail.hidden,
                    visible: (columsDetail.hidden == true ? false : true)
                });
            } else {
                for (var j = 0; j < cols.length; j++) {
                    if (cols[j].field == columsDetail.field) {
                        hiddencolumns.push({
                            field: columsDetail.field,
                            hidden: columsDetail.hidden,
                            visible: cols[j].visible
                        });
                    }
                }
            }
        }
    }
    storage.set('jeecgDemoList2hiddenColumns', JSON.stringify(hiddencolumns));
}
function isShowBut() {
    var isShowSearchId = $('#isShowSearchId').val();
    if (isShowSearchId == "true") {
        $("#searchColums").hide();
        $('#isShowSearchId').val("false");
        $('#columsShow').remove("src");
        $('#columsShow').attr("src", "plug-in/easyui/themes/default/images/accordion_expand.png");
    } else {
        $("#searchColums").show();
        $('#isShowSearchId').val("true");
        $('#columsShow').remove("src");
        $('#columsShow').attr("src", "plug-in/easyui/themes/default/images/accordion_collapse.png");
    }
}
function restoreheader() {
    var cols = storage.get('jeecgDemoList2hiddenColumns');
    if (!cols)return;
    for (var i = 0; i < cols.length; i++) {
        try {
            if (cols.visible != false) $('#jeecgDemoList2').datagrid((cols[i].hidden == true ? 'hideColumn' : 'showColumn'), cols[i].field);
        } catch (e) {
        }
    }
}
function resetheader() {
    var cols = storage.get('jeecgDemoList2hiddenColumns');
    if (!cols)return;
    for (var i = 0; i < cols.length; i++) {
        try {
            $('#jeecgDemoList2').datagrid((cols.visible == false ? 'hideColumn' : 'showColumn'), cols[i].field);
        } catch (e) {
        }
    }
}
function jeecgDemoList2search() {
    try {
        if (!$("#jeecgDemoList2Form").Validform({tiptype: 3}).check()) {
            return false;
        }
    } catch (e) {
    }
    if (true) {
        var queryParams = $('#jeecgDemoList2').datagrid('options').queryParams;
        $('#jeecgDemoList2tb').find('*').each(function () {
            queryParams[$(this).attr('name')] = $(this).val();
        });
        $('#jeecgDemoList2').datagrid({
            url: 'jeecgDemoController.do?datagrid&field=id,userName,mobilePhone,officePhone,createDate,createDate_begin,createDate_end,email,age,salary,birthday,sex,',
            pageNumber: 1
        });
    }
}
function dosearch(params) {
    var jsonparams = $.parseJSON(params);
    $('#jeecgDemoList2').datagrid({
        url: 'jeecgDemoController.do?datagrid&field=id,userName,mobilePhone,officePhone,createDate,createDate_begin,createDate_end,email,age,salary,birthday,sex,',
        queryParams: jsonparams
    });
}
function jeecgDemoList2searchbox(value, name) {
    var queryParams = $('#jeecgDemoList2').datagrid('options').queryParams;
    queryParams[name] = value;
    queryParams.searchfield = name;
    $('#jeecgDemoList2').datagrid('reload');
}
$('#jeecgDemoList2searchbox').searchbox({
    searcher: function (value, name) {
        jeecgDemoList2searchbox(value, name);
    }, menu: '#jeecgDemoList2mm', prompt: '请输入查询关键字'
});
function EnterPress(e) {
    var e = e || window.event;
    if (e.keyCode == 13) {
        jeecgDemoList2search();
    }
}
function searchReset(name) {
    $("#" + name + "tb").find(":input").val("");
    var queryParams = $('#jeecgDemoList2').datagrid('options').queryParams;
    $('#jeecgDemoList2tb').find('*').each(function () {
        queryParams[$(this).attr('name')] = $(this).val();
    });
    $('#jeecgDemoList2').datagrid({
        url: 'jeecgDemoController.do?datagrid&field=id,userName,mobilePhone,officePhone,createDate,createDate_begin,createDate_end,email,age,salary,birthday,sex,',
        pageNumber: 1
    });
}</script>
<table width="100%" id="jeecgDemoList2" toolbar="#jeecgDemoList2tb"></table>
<div id="jeecgDemoList2tb" style="padding:3px; height: auto">
    <div name="searchColums" id="searchColums"><input id="isShowSearchId" type="hidden" value="false"/><input
            id="_sqlbuilder" name="sqlbuilder" type="hidden"/>
        <form onkeydown='if(event.keyCode==13){jeecgDemoList2search();return false;}' id='jeecgDemoList2Form'>
            <link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css">
            <link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css">
            <script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
            <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
            <script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
            <span style="display:-moz-inline-box;display:inline-block;"><span
                    style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                    title="用户名">用户名：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                                  name="userName" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="电话号码">电话号码：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                                name="mobilePhone" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="办公电话">办公电话：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                                name="officePhone" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="邮箱">邮箱：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                            name="email" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="年龄">年龄：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                            name="age" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="工资">工资：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                            name="salary" class="inuptxt" style="width: 100px"/></span><span
                style="display:-moz-inline-box;display:inline-block;"><span
                style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
                title="生日">生日：</span><input onkeypress="EnterPress(event)" onkeydown="EnterPress()" type="text"
                                            name="birthday" class="inuptxt" style="width: 100px"/></span></form>
    </div>
    <div style="height:30px;" class="datagrid-toolbar"><span style="float:left;"><a href="#" class="easyui-linkbutton"
                                                                                    plain="true" icon="icon-add"
                                                                                    onclick="addRow('录入','null','jeecgDemoList2',null,null)">录入</a><a
            href="#" class="easyui-linkbutton" plain="true" icon="icon-edit"
            onclick="editRow('编辑','null','jeecgDemoList2',null,null)">编辑</a><a href="#" class="easyui-linkbutton"
                                                                               plain="true" icon="icon-save"
                                                                               onclick="saveData('保存','jeecgDemoController.do?saveRows','jeecgDemoList2')">保存</a><a
            href="#" class="easyui-linkbutton" plain="true" icon="icon-undo"
            onclick="reject('取消编辑','null','jeecgDemoList2',null,null)">取消编辑</a></span><span style="float:right"><a
            href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="jeecgDemoList2search()">查询</a><a href="#"
                                                                                                               class="easyui-linkbutton"
                                                                                                               iconCls="icon-reload"
                                                                                                               onclick="searchReset('jeecgDemoList2')">重置</a></span>
    </div>
    <script type="text/javascript">
        //添加行
        function addRow(title, addurl, gname) {
            $('#' + gname).datagrid('appendRow', {});
            var editIndex = $('#' + gname).datagrid('getRows').length - 1;
            $('#' + gname).datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
        }
        //保存数据
        function saveData(title, addurl, gname) {
            if (!endEdit(gname))
                return false;
            alert(addurl);
            var rows = $('#' + gname).datagrid("getChanges", "inserted");

            var uprows = $('#' + gname).datagrid("getChanges", "updated");
            rows = rows.concat(uprows);
            if (rows.length <= 0) {
                tip("没有需要保存的数据！");
                return false;
            }
            var result = {};
            for (var i = 0; i < rows.length; i++) {
                for (var d in rows[i]) {
                    result["demos[" + i + "]." + d] = rows[i][d];
                }
            }
            alert(result);
            $.ajax({
                url: addurl,
                type: "post",
                data: result,
                dataType: "json",
                success: function (data) {
                    tip(data.msg);
                    if (data.success) {
                        reloadTable();
                    }
                }
            })
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
            $('#' + gname).datagrid('clearChecked');
            $('#' + gname).datagrid('rejectChanges');


        }
    </script>
</div>