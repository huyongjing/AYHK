<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="ayKqxxList" checkbox="true" fitColumns="false" title="考勤信息表"
                    actionUrl="ayKqxxController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group"
                    onLoadSuccess="onload">
            <t:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="时间主键" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人名称" field="createName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称" field="createBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人名称" field="updateName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称" field="updateBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新日期" field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属部门" field="sysOrgCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属公司" field="sysCompanyCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <%--<t:dgCol title="流程状态"  field="bpmStatus"    queryMode="single" dictionary="bpm_status" width="120"></t:dgCol>--%>
            <t:dgCol title="姓名" field="xm" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="员工类型" field="yglx" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="当月应出勤(天)" field="dyycq" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="实际出勤(天)" field="sjcq" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="出差(天)" field="cc" extendParams="editor:'numberbox'" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="计薪日(天)" field="jxr" queryMode="single" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="餐补(天)" field="cb" queryMode="single" hidden="true" width="120" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="交通补(天)" field="jtb" queryMode="single" hidden="true" width="120" extendParams="editor:'numberbox'" ></t:dgCol>  
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
            <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="ayKqxxController.do?doDel&id={id}" urlclass="ace_button" urlfont="fa-trash-o"/>--%>
            <t:dgToolBar title="保存" icon="icon-add" url="ayKqxxController.do?saveRows" funname="saveData" width="800"></t:dgToolBar>
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
    function changeEditGrid() {
        var grid = $('#ayKqxxList');
        //var rows=grid.datagrid('getRows');
        var rows = $('#ayKqxxList').datagrid("getRows");

        //var columns = $('#kcxxList').datagrid("options").columns;
        //alert(rows.length);
        //alert(rows[1][rowFildName]);
        // var startIndex=0;
        // var endIndex=0;
        if (rows.length < 1) {
            return;
        }
        $.each(rows, function (i, row) {
            $('#ayKqxxList').datagrid('beginEdit', i);
            var dyycq = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'dyycq'});
            var fdj = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'fdj'});
            var wrz = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'wrz'});
            var bj = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'bj'});
            var sj = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'sj'});
            var tx = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'tx'});
            var dxnj = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'dxnj'});
            var dnnj = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'dnnj'});
            var jbts = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'jbts'});
            var syjb = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'syjb'});
            var jxr = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'jxr'});
            var cc = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'cc'});
            var jtb = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'jtb'});//交通补
            var cb = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'cb'});//餐补
            var zfb = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'zfb'});//住房补

            var sjcq = $('#ayKqxxList').datagrid('getEditor', {index: i, field: 'sjcq'});
            if($(fdj.target).val()==null||$(fdj.target).val()==""||$(fdj.target).val()==0){
                $(fdj.target).attr("value", 0);
            }
            if($(wrz.target).val()==null||$(wrz.target).val()==""||$(wrz.target).val()==0){
                $(wrz.target).attr("value", 0);
            }
            if($(bj.target).val()==null||$(bj.target).val()==""||$(bj.target).val()==0){
                $(bj.target).attr("value", 0);
            }
            if($(sj.target).val()==null||$(sj.target).val()==""||$(sj.target).val()==0){
                $(sj.target).attr("value", 0);
            }
            if($(tx.target).val()==null||$(tx.target).val()==""||$(tx.target).val()==0){
                $(tx.target).attr("value", 0);
            }
            if($(dxnj.target).val()==null||$(dxnj.target).val()==""||$(dxnj.target).val()==0){
                $(dxnj.target).attr("value", 0);
            }
            if($(dnnj.target).val()==null||$(dnnj.target).val()==""||$(dnnj.target).val()==0){
                $(dnnj.target).attr("value", 0);
            }
            if($(jbts.target).val()==null||$(jbts.target).val()==""||$(jbts.target).val()==0){
                $(jbts.target).attr("value", 0);
            }
            if($(syjb.target).val()==null||$(syjb.target).val()==""||$(syjb.target).val()==0){
                $(syjb.target).attr("value", 0);
            }
            if($(cc.target).val()==null||$(cc.target).val()==""||$(cc.target).val()==0){
                $(cc.target).attr("value", 0);
            }

            //var test = 0;
            //alert($(sjcq.target).val());

           /* if(t_fdj==null||t_fdj==NaN){
                $(t_fdj.target).attr("value", test);
            }
            if(t_wrz==null||t_wrz==NaN){
                $(t_wrz.target).attr("value", test);
            }
            if(t_bj==null||t_bj==NaN){
                $(t_bj.target).attr("value", test);
            }
            if(t_sj==null||t_sj==NaN){
                $(t_sj.target).attr("value", test);
            }
            if(t_tx==null||t_tx==NaN){
                $(t_tx.target).attr("value", test);
            }
            if(t_dxnj==null||t_dxnj==NaN){
                $(t_dxnj.target).attr("value", test);
            }*/


			
            // dyycq_input.getAttribute("dyycq_input");
            //$(dyycq.target).attr("value");

            // dyycq_input.value;


            //只读
            $(dyycq.target).attr("disabled", "disabled");
            $(sjcq.target).attr("disabled", "disabled");
            $(jxr.target).attr("disabled", "disabled");
            $(cb.target).attr("disabled", "disabled");
            $(jtb.target).attr("disabled", "disabled");
            $(zfb.target).attr("disabled", "disabled");
            $(fdj.target).attr("disabled", "disabled");
            
            //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            
            
            
           
           /* cc.target.bind('focus', function () {//绑定获取焦点事件
                return false;
            });*/
            dyycq.target.bind('change', function () {//绑定失去焦点事件

                /* var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj-t_sj-t_tx-t_dxnj;
                //计薪日
                row.jxr=t_dyycq-t_wrz-t_bj-t_sj;
                $(jxr.target).attr("value", row.jxr);
                //住房补
                row.zfb=t_dyycq-t_sj;
                $(zfb.target).attr("value", row.zfb);

                $(sjcq.target).attr("value", row.sjcq); */
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
                //当月应出勤渲染
            });
            fdj.target.bind('change', function () {//绑定失去焦点事件
                /* var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj-t_sj-t_tx-t_dxnj;
                $(sjcq.target).attr("value", row.sjcq); */
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            if(v_fdj<0){
            	v_fdj = 0;
            }
            if(v_fdj>v_sjcq){
            	v_fdj = v_sjcq;
            }
            $(fdj.target).attr("value", v_fdj);
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            });
            wrz.target.bind('change', function () {//未入职绑定失去焦点事件
               /*  var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row

                row.sjcq=t_dyycq-t_fdj-t_wrz;


                row.jxr=t_dyycq-t_wrz;
                $(sjcq.target).attr("value", row.sjcq);//实际出勤
                $(jxr.target).attr("value", row.jxr);//计薪日 */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0;
            if(v_wrz<0){
            	v_wrz = 0;
            }
            if(v_wrz>v_sjcq){
            	v_wrz = v_sjcq;
            }
            $(wrz.target).attr("value", v_wrz); 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            });
            bj.target.bind('change', function () {//病假绑定失去焦点事件
                /* var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj;

                $(sjcq.target).attr("value", row.sjcq);
                //计薪日
                row.jxr=t_dyycq-t_wrz-t_bj;
                $(jxr.target).attr("value", row.jxr); */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            if(v_bj<0){
            	v_bj = 0;
            }
            if(v_bj>v_sjcq){
            	v_bj = v_sjcq;
            }
            $(bj.target).attr("value", v_bj); 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
           //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            });
            sj.target.bind('change', function () {//事假绑定失去焦点事件
                /* var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj-t_sj;

                //计薪日
                row.jxr=t_dyycq-t_wrz-t_bj-t_sj;
                $(jxr.target).attr("value", row.jxr);
                //住房补
                row.zfb=t_dyycq-t_sj;
                $(zfb.target).attr("value", row.zfb);
                $(sjcq.target).attr("value", row.sjcq); */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;
            if(v_sj<0){
            	v_sj = 0;
            }
            if(v_sj>v_sjcq){
            	v_sj = v_sjcq;
            }
            $(sj.target).attr("value", v_sj);  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
           //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            });
            tx.target.bind('change', function () {//调休绑定失去焦点事件
               /*  var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj-t_sj-t_tx;
                $(sjcq.target).attr("value", row.sjcq); */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            if(v_tx<0){
            	v_tx = 0;
            }
            if(v_tx>v_sjcq){
            	v_tx = v_sjcq;
            }
            $(tx.target).attr("value", v_tx);
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
                
            });
            dxnj.target.bind('change', function () {//带薪绑定失去焦点事件
                /* var t_dyycq=parseFloat($(dyycq.target).val());
                var t_fdj=parseFloat($(fdj.target).val())||0;
                var t_wrz=parseFloat($(wrz.target).val())||0;
                var t_bj=parseFloat($(bj.target).val())||0;
                var t_sj=parseFloat($(sj.target).val())||0;
                var t_tx=parseFloat($(tx.target).val())||0;
                var t_dxnj=parseFloat($(dxnj.target).val())||0;
                //TODO update grid row
                row.sjcq=t_dyycq-t_fdj-t_wrz-t_bj-t_sj-t_tx-t_dxnj;
                $(sjcq.target).attr("value", row.sjcq); */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            if(v_dxnj<0){
            	v_dxnj = 0;
            }
            if(v_dxnj>v_sjcq){
            	v_dxnj = v_sjcq;
            }
            $(dxnj.target).attr("value", v_dxnj); 
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
                
            });
            cc.target.bind('change', function () {//绑定失去焦点事件
                /* var t_sjcq=parseFloat($(sjcq.target).val())||0;
                var t_cc=parseFloat($(cc.target).val())||0;
                row.cb=t_sjcq-t_cc;
                row.jtb=t_sjcq-t_cc;
                $(cb.target).attr("value", row.cb);
                $(jtb.target).attr("value", row.jtb); */
                
                 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            if(v_cc<0){
            	v_cc = 0;
            }
            if(v_cc>v_sjcq){
            	v_cc = v_sjcq;
            }
            $(cc.target).attr("value", v_cc);
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
                

            });
            jtb.target.bind('change', function () {//绑定失去焦点事件
               /*  var t_sjcq=parseFloat($(sjcq.target).val())||0;
                var t_cc=parseFloat($(cc.target).val())||0;
                row.jtb=t_sjcq-t_cc;
                $(jtb.target).attr("value", row.jtb);
 */
 
 				 //当月应出勤
            var v_dyycq = parseFloat($(dyycq.target).val())||0;
            //实际出勤
            var v_sjcq = parseFloat($(sjcq.target).val())||0;
            //出差
            var v_cc = parseFloat($(cc.target).val())||0;
            //计薪日
            var v_jxr = parseFloat($(jxr.target).val())||0;
            //餐补(天)
            var v_cb = parseFloat($(cb.target).val())||0;
            //交通补
            var v_jtb = parseFloat($(jtb.target).val())||0;
            //住房补
            var v_zfb = parseFloat($(zfb.target).val())||0;  
            //法定假
            var v_fdj = parseFloat($(fdj.target).val())||0; 
            //未入职
            var v_wrz = parseFloat($(wrz.target).val())||0; 
            //病假
            var v_bj = parseFloat($(bj.target).val())||0; 
            //事假
            var v_sj = parseFloat($(sj.target).val())||0;  
            //调休
            var v_tx = parseFloat($(tx.target).val())||0;
            //带薪年假
            var v_dxnj = parseFloat($(dxnj.target).val())||0;
            
            //实际出勤 = 应出勤-法定-未入职-病假-事假-调休-年假
            row.sjcq = v_dyycq - v_fdj - v_wrz - v_bj - v_sj - v_tx - v_dxnj;
            if(row.sjcq<0){row.sjcq = 0;}
            $(sjcq.target).attr("value", row.sjcq);
            
            //计薪日 = 应出勤-未入职-病假-事假
            row.jxr = v_dyycq - v_wrz - v_bj - v_sj;
            if(row.jxr<0){row.jxr = 0;}
            $(jxr.target).attr("value", row.jxr);
            
            //餐补 = 实际出勤 - 出差
            row.cb = row.sjcq - v_cc;
            if(row.cb<0){row.cb = 0;}
            $(cb.target).attr("value", row.cb);
            //交通补 = 计薪日
            row.jtb = row.jxr;
            $(jtb.target).attr("value", row.jtb);
            //住房补 = 计薪日
            row.zfb = row.jxr;
            $(zfb.target).attr("value", row.zfb);
            });

           /*  var t_sjcq=Number($(sjcq.target).val())||0;
            var t_cc=Number($(cc.target).val())||0;
            row.cb=t_sjcq-t_cc;
            row.jtb=t_sjcq-t_cc;
            $(cb.target).attr("value", row.cb);
            $(jtb.target).attr("value", row.jtb); */


        });
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
        JeecgExcelExport("ayKqxxController.do?exportXls", "ayKqxxList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("ayKqxxController.do?exportXlsByT", "ayKqxxList");
    }
</script>