<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<t:datagrid name="kcxxList" title="" actionUrl="ayKcxxController.do?datagrid&sjpzid=${sjpzid}"
            idField="id" queryMode="group" checkbox="true" onLoadSuccess="onload" pageSize="200">
    <t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="主键" field="ygxxid" hidden="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="主键" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="姓名" field="xm" align="center" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="身份证号" field="sfzh" align="center" queryMode="single" width="100"></t:dgCol>
    <t:dgCol title="课程名" field="kcmc" align="center" queryMode="single" width="120"></t:dgCol>
    <t:dgCol title="课程系数" field="kcxs" align="center" queryMode="single" width="60"></t:dgCol>
    <t:dgCol title="课程时间" field="kcsj" align="center" queryMode="single" extendParams="editor:{type:'numberbox',options:{precision:2}}" width="120"></t:dgCol>
    <t:dgCol title="课程合计" field="kchj" align="center" queryMode="single" extendParams="editor:{type:'numberbox',options:{precision:2}}" width="120"></t:dgCol>
    <t:dgCol title="个人合计" field="grhj" align="center" queryMode="single" extendParams="editor:{type:'numberbox',options:{precision:2}}" width="120"></t:dgCol>
    <%--<t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit"  funname="editRow"></t:dgToolBar>--%>
    <t:dgToolBar operationCode="save" title="保存" icon="icon-save" url="kcxxController.do?saveRows" funname="saveData"></t:dgToolBar>
    <%--<t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" funname="editRow"></t:dgToolBar>--%>
</t:datagrid>
<script type="text/javascript">
    function onload() {
        changeEditGrid();
        $('#kcxxList').datagrid("autoMergeCells", ['xm','sfzh']);
        mergeGRHJ();
    }
    var map = [];
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
    function appendTotal() {
        var total = compute('kchj');
        var rows = $('#kcxxList').datagrid('getRows');
        //alert(total);
        if (!total) {
            total = "0.00";
        }
        // 更新页脚行并载入新数据$
        $('#kcxxList').datagrid('reloadFooter', [
            {
                kcsj: '<b> 合计：</b> ',
                kchj: total
            }
        ]);
    }
    function formatt(rec, val, index) {
        if (rec === null || rec == "null") {
            return "0";
        } else {
            return rec;
        }
    }
    function changeEditGrid() {
        var grid = $('#kcxxList');
        //var rows=grid.datagrid('getRows');
        var rows = $('#kcxxList').datagrid("getRows");
        
        //var columns = $('#kcxxList').datagrid("options").columns; 
        //alert(rows.length);
        //alert(rows[1][rowFildName]);
        // var startIndex=0;
        // var endIndex=0;
        if (rows.length < 1) {
            return;
        }
        var temp = '';
	   	 var num = 0;
	   	 for (var i = 0; i < rows.length; i++) {
	   	 	temp = rows[0]['ygxxid'];
	   	 	if(rows[i]['ygxxid']==temp){
	   	 		num = num+1;
	   	 	}
	   	 }
        
        $.each(rows, function (i, row) {
            $('#kcxxList').datagrid('beginEdit', i);
            var ed_fx = $('#kcxxList').datagrid('getEditor', {index: i, field: 'kcsj'});
            var ed_hj = $('#kcxxList').datagrid('getEditor', {index: i, field: 'kchj'});
            var ed_gr = $('#kcxxList').datagrid('getEditor', {index: i, field: 'grhj'});
            //只读
            $(ed_hj.target).attr("disabled", "disabled");
            //$(ed_gr.target).attr("disabled", "disabled");
            /* $('#kcxxList').datagrid('updateRow',{
             index: i,
             row: {
             kchj: ''
             }
             });*/
            /*var ed_pfbz = $('#kcxxList').datagrid('getEditor', {index:i,field:'pfbz'});
             var ed_sz = $('#kcxxList').datagrid('getEditor', {index:i,field:'sz'});
             var ed_ckz = $('#kcxxList').datagrid('getEditor', {index:i,field:'ckz'});
             var ed_df = $('#kcxxList').datagrid('getEditor', {index:i,field:'df'});*/
            // $(ed.target).datebox('setValue', '5/4/2012');
             
             ed_hj.target.bind('focus', function () {//绑定获取焦点事件
                 return false;
             });
             
             onpaste="return false";
            ed_fx.target.bind('change', function () {//绑定失去焦点事件
                var t_xs = row.kcxs;
                var t_kcsj = this.value;
                if(t_kcsj<0){
                	t_kcsj = 0;
                }
                $(ed_fx.target).attr("value", t_kcsj);
                //alert(JSON.stringify(row));
                row.kcsj = t_kcsj;
                row.kchj = (t_xs * t_kcsj).toFixed(2);
                
                //alert(JSON.stringify(row));

                //row[columns[0][i].field]=新的值;
                //row.kchj = 
				// 刷新该行, 只有刷新了才有效果
				//$('#kcxxList').datagrid('refreshRow', i);
                /*
                $('#kcxxList').datagrid('updateRow', {
                    index: i,
                    row: row
                });
                */
                $(ed_hj.target).attr("disabled", "");
                $(ed_hj.target).attr("value", row.kchj);
                $(ed_hj.target).attr("disabled", "disabled");
                
                
                for (var m = 0; m < rows.length; m++) {
               		if(m%num==0){
	                	var total = 0;
				        
				        for (var j = m; j < m+num; j++) {
				            var t = rows[j]['kchj'];
				            if (t == '' || t == 'null') {
				            } else {
				                total += parseFloat(rows[j]['kchj']);
				            }
				        }
				        if (total) {
				            total = total;
				        }
				        total = total.toFixed(2);
				        var temp_gr = $('#kcxxList').datagrid('getEditor', {index: m, field: 'grhj'});
				         $(temp_gr.target).attr("value", total);
				         $(temp_gr.target).attr("disabled", "disabled");
                     }
                }
                appendTotal();

            });
        });
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
        
        
        var temp = '';
	   	 var num = 0;
	   	 for (var i = 0; i < rows.length; i++) {
	   	 	temp = rows[0]['ygxxid'];
	   	 	if(rows[i]['ygxxid']==temp){
	   	 		num = num+1;
	   	 	}
	   	 }
        for (var m = 0; m < rows.length; m++) {
               		if(m%num==0){
	                	var total = 0;
				        
				        for (var j = m; j < m+num; j++) {
				            var t = rows[j]['kchj'];
				            if (t == '' || t == 'null') {
				            } else {
				                total += parseFloat(rows[j]['kchj']);
				            }
				        }
				        if (total) {
				            total = total;
				        }
				        total = total.toFixed(2);
				        var temp_gr = $('#kcxxList').datagrid('getEditor', {index: m, field: 'grhj'});
				         map.push({id:rows[m]['ygxxid'],name:total});
                     }
                }
        
        
        //rows = rows.concat(uprows);
        if (rows.length <= 0) {
            tip("没有需要保存的数据！");
            return false;
        }
        //alert(JSON.stringify(map));
        var rows1 = $('#kcxxList').datagrid('getRows');
        var result = {};
        for (var i = 0; i < rows.length; i++) {
            for (var d in rows[i]) {
            	if(d=="grhj"){
            		var ygid = rows[i]['ygxxid'];
            		for(var m =0;m<map.length;m++){
            			if(ygid==map[m].id){
            				result["demos[" + i + "]." + d] = map[m].name;
            			}
            		}
            	}else{
            		result["demos[" + i + "]." + d] = rows[i][d];
            	}
            }
        }
        //alert(JSON.stringify(result));return;
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


</script>

