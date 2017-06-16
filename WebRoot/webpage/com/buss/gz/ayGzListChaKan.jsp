<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src="<%=basePath%>/plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="ayGzList" checkbox="true" fitColumns="false" title="工资表"
                    actionUrl="ayGzController.do?datagrid&sjpzid=${sjpzid}" idField="id" fit="true" queryMode="group" onLoadSuccess="onload" >
            <input type="hidden" value="${sjpzid}" id="riqiid"/>
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
          <!--   <t:dgCol title="当月应出勤" field="dyycq" queryMode="single" hidden="true" width="120"  align="center" extendParams="editor:'numberbox'"  ></t:dgCol>
            <t:dgCol title="病假" field="bj" queryMode="single"  hidden="true" width="120" align="center" extendParams="editor:'numberbox'"></t:dgCol>
            <t:dgCol title="事假" field="sj" queryMode="single"  hidden="true" width="120" align="center" extendParams="editor:'numberbox'"></t:dgCol>
            <t:dgCol title="餐补" field="cb" queryMode="single"  hidden="true" width="120" align="center" extendParams="editor:'numberbox'"></t:dgCol>  -->
            <t:dgCol title="姓名" field="xm" queryMode="single" width="70" align="center" frozenColumn="true"></t:dgCol>
            <t:dgCol title="岗位" field="gw" queryMode="single" width="70" align="center"></t:dgCol>
            <t:dgCol title="员工类型" field="yglx" queryMode="single" width="70" formatterjs="formatt" align="center"></t:dgCol>
            <t:dgCol title="身份证号" field="sfzh" queryMode="single" width="150"></t:dgCol>
            <t:dgCol title="基本工资" field="jbgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="岗位工资" field="gwgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="职称工资" field="zcgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="年资工资" field="nzgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="绩效工资" field="jxgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="管理绩效" field="gljx" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="课时奖励" field="ksjl" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="全勤奖"  field="qqj" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="缺勤扣款" field="qqkk" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="餐费补助" field="cfbz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="交通补助" field="jtbz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="通讯补助" field="txbz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="出差补助" field="ccbz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="住房补助" field="zfbz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="应发工资总额" field="yfgzze" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="养老保险基数" field="ylbxjs" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="其他四险基数" field="qtsxjs" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="公积金基数" field="gjjjs" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="养老保险公司承担部分" field="ylbxgscd" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="失业保险公司承担部分" field="sybxgscdbf1" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="医疗保险公司承担部分" field="ylbxgscdbf1" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="工伤保险公司承担部分" field="gsbxgscdbf" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="生育保险公司承担部分" field="sybxgscdbf" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="住房公积金公司承担部分" field="zfgjjgscdbf" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="养老保险个人承担部分" field="ylbxgrcdbf" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="失业保险个人承担部分" field="sybxgrcdbf2" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="医疗保险个人承担部分" field="ylbxgrcdbf2" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="个人医疗补充保险" field="gsylbc" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="住房公积金个人承担部分" field="zfgjjgrcdbf" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="公司承担合计" field="gscdhj" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="个人承担合计" field="grcdhj" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="应纳税所得额" field="ynssde" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="免征额" field="mze" queryMode="single" width="60" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="实纳税所得额" field="snssde" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="税率" field="sl" queryMode="single" width="60" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="速算扣除" field="sskc" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="个人所得税" field="grsds" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="税后工资" field="shgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="其他" field="qt" queryMode="single" width="60" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="实发工资" field="sfgz" queryMode="single" width="80" extendParams="editor:{type:'numberbox',options:{precision:2}}"></t:dgCol>
            <t:dgCol title="银行帐号" field="yhzh" queryMode="single" width="220" extendParams="editor:'numberbox'" ></t:dgCol>
            <t:dgCol title="时间id" field="sjpzid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="中心" field="zxbm" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="员工id" field="ygxxid" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
            <%--<t:dgDelOpt title="删除" url="ayGzController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
            <%-- <t:dgToolBar title="录入" icon="icon-add" url="ayGzController.do?goAdd" funname="add" width="800"></t:dgToolBar>--%>
            <%--<t:dgToolBar title="编辑" icon="icon-edit" url="ayGzController.do?goUpdate" funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除"  icon="icon-remove" url="ayGzController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="ayGzController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
        </t:datagrid>
    </div>
</div>

<script type="text/javascript">
    function formatt(rec, val, index) {
        if (rec == null || rec == "null") {
            return "";
        } else {
            return rec;
        }
    }
    function onload() {
       //changeEditGrid();
       hideColumn();
    }
    
    function hideColumn(){
    	var yczd = '<%=request.getAttribute("yczd")%>';
    	if(yczd){
    		if(yczd.indexOf(','>-1)){
    			var columnArray = yczd.split(",");
    			 $.each(columnArray, function (i, item) {
    			 	$("#ayGzList").datagrid("hideColumn", item);
    			 });
    			
    		}
    	}
    }
    
    function changeEditGrid() {
    
    	var geshui = '<%=request.getAttribute("gsbz")%>' ;
    	if(geshui==""||geshui==null||geshui==undefined){
    		tip("未获取到个税标准相关数据！");
    		return;
    	}
    	var geshui_obj = {};
    	 
    	 try{
    	    geshui_obj = $.parseJSON(geshui);
    	 }catch(err){
    	 	return;
    	 }
        var grid = $('#ayGzList');
        //var rows=grid.datagrid('getRows');
        var rows = $('#ayGzList').datagrid("getRows");
        if (rows.length < 1) {
            return;
        }
        $.each(rows, function (i, row) {
            $('#ayGzList').datagrid('beginEdit', i);
            //基本工资
            var jbgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'jbgz'});
            //缺勤扣款
            var qqkk = $('#ayGzList').datagrid('getEditor', {index: i, field: 'qqkk'});
            //管理绩效
            var gljx = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gljx'});
            //餐费补助
            var cfbz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'cfbz'});
            //交通补助
            var jtbz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'jtbz'});
            //应发工资总额
            var yfgzze = $('#ayGzList').datagrid('getEditor', {index: i, field: 'yfgzze'});
            //岗位工资
            var gwgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gwgz'});
            //职称工资
            var zcgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'zcgz'});
            //年资工资
            var nzgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'nzgz'});
            //绩效工资
            var jxgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'jxgz'});
            //课时奖励
            var ksjl = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ksjl'});
            //全勤奖
            var qqj = $('#ayGzList').datagrid('getEditor', {index: i, field: 'qqj'});
            //住房补助
            var zfbz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'zfbz'});
            //应纳税所得额
            var ynssde = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ynssde'});
            var mze = $('#ayGzList').datagrid('getEditor', {index: i, field: 'mze'});
            //实纳税所得额
            var snssde = $('#ayGzList').datagrid('getEditor', {index: i, field: 'snssde'});
            //个人承担合计
            var grcdhj = $('#ayGzList').datagrid('getEditor', {index: i, field: 'grcdhj'});
            //税率
            var sl = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sl'});
            //速算扣除
            var sskc = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sskc'});
            //个人所得税
            var grsds = $('#ayGzList').datagrid('getEditor', {index: i, field: 'grsds'});
            //税后工资
            var shgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'shgz'});
            //其他
            var qt = $('#ayGzList').datagrid('getEditor', {index: i, field: 'qt'});
            //实发工资
            var sfgz = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sfgz'});
            //公司承担合计
            var gscdhj = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gscdhj'});
            
            
            
             var ylbxjs = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ylbxjs'});
             var qtsxjs = $('#ayGzList').datagrid('getEditor', {index: i, field: 'qtsxjs'});
             var gjjjs = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gjjjs'});
             var ylbxgscd = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ylbxgscd'});
             var sybxgscdbf1 = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sybxgscdbf1'});
             var ylbxgscdbf1 = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ylbxgscdbf1'});
             var gsbxgscdbf = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gsbxgscdbf'});
             var sybxgscdbf = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sybxgscdbf'});
             var zfgjjgscdbf = $('#ayGzList').datagrid('getEditor', {index: i, field: 'zfgjjgscdbf'});
             var ylbxgrcdbf = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ylbxgrcdbf'});
             var sybxgrcdbf2 = $('#ayGzList').datagrid('getEditor', {index: i, field: 'sybxgrcdbf2'});
             var ylbxgrcdbf2 = $('#ayGzList').datagrid('getEditor', {index: i, field: 'ylbxgrcdbf2'});
             var zfgjjgrcdbf = $('#ayGzList').datagrid('getEditor', {index: i, field: 'zfgjjgrcdbf'});
             var gsylbc = $('#ayGzList').datagrid('getEditor', {index: i, field: 'gsylbc'});
             
             $(ylbxjs.target).attr("disabled", "disabled");
             $(qtsxjs.target).attr("disabled", "disabled");
             $(gjjjs.target).attr("disabled", "disabled");
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
             $(gsylbc.target).attr("disabled", "disabled");
             $(gscdhj.target).attr("disabled", "disabled");
             $(grcdhj.target).attr("disabled", "disabled");
             $(mze.target).attr("disabled", "disabled");
             
            
            //只读
            $(jbgz.target).attr("disabled", "disabled");
            $(qqkk.target).attr("disabled", "disabled");
            $(cfbz.target).attr("disabled", "disabled");
            $(jtbz.target).attr("disabled", "disabled");
            $(gwgz.target).attr("disabled", "disabled");
            $(zcgz.target).attr("disabled", "disabled");
            $(nzgz.target).attr("disabled", "disabled");
            $(zfbz.target).attr("disabled", "disabled");
            $(yfgzze.target).attr("disabled", "disabled");
            $(ynssde.target).attr("disabled", "disabled");
            $(snssde.target).attr("disabled", "disabled");
            $(sl.target).attr("disabled", "disabled");
            $(sskc.target).attr("disabled", "disabled");
            $(grsds.target).attr("disabled", "disabled");
            $(shgz.target).attr("disabled", "disabled");
            $(sfgz.target).attr("disabled", "disabled");
            
            //工资计算
            jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            
            jbgz.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            gwgz.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            zcgz.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row); 
            });
            nzgz.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row); 
            });
            jxgz.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row); 
            });
            ksjl.target.bind('change', function () {//绑定失去焦点事件
                jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            qqj.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row); 
            });
            qqkk.target.bind('change', function () {//绑定失去焦点事件
               jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row); 
            });
            cfbz.target.bind('change', function () {//绑定失去焦点事件
                jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            zfbz.target.bind('change', function () {//绑定失去焦点事件
                jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            gljx.target.bind('change', function () {//绑定失去焦点事件
                jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
            qt.target.bind('change', function () {//绑定失去焦点事件
                jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row);
            });
        });
    }
    
    function jisuangongzi(jbgz,gwgz,zcgz,nzgz,jxgz,gljx,ksjl,qqj,qqkk,cfbz,jtbz,zfbz,yfgzze,grcdhj,ynssde,mze,snssde,sl,sskc,grsds,shgz,qt,sfgz,geshui_obj,row){
    	//应发工资总额
            var v_jbgz = parseFloat($(jbgz.target).val())||0;
            var v_gwgz = parseFloat($(gwgz.target).val())||0;
            var v_zcgz = parseFloat($(zcgz.target).val())||0;
            var v_nzgz = parseFloat($(nzgz.target).val())||0;
            var v_jxgz = parseFloat($(jxgz.target).val())||0;
            var v_gljx = parseFloat($(gljx.target).val())||0;
            var v_ksjl = parseFloat($(ksjl.target).val())||0;
            var v_qqj = parseFloat($(qqj.target).val())||0;
            var v_qqkk = parseFloat($(qqkk.target).val())||0;
            var v_cfbz = parseFloat($(cfbz.target).val())||0;
            var v_jtbz = parseFloat($(jtbz.target).val())||0;
            var v_zfbz = parseFloat($(zfbz.target).val())||0;
            row.yfgzze = v_jbgz + v_gwgz + v_zcgz + v_nzgz + v_jxgz + v_gljx + v_ksjl + v_qqj + v_qqkk + v_cfbz + v_jtbz + v_zfbz;
            $(yfgzze.target).attr("value", row.yfgzze);
            
            //应纳税所得额 = 应发工资总额 - 个人承担合计
            var v_grcdhj = parseFloat($(grcdhj.target).val())||0;
            row.ynssde = row.yfgzze - v_grcdhj;
            $(ynssde.target).attr("value", row.ynssde);
            
            //实纳税所得额 = (应纳税所得额 - 免征额 >=0)?(应纳税所得额 - 免征额) :0
            var v_mze = parseFloat($(mze.target).val())||0;
            row.snssde = 0;
            if(row.ynssde - v_mze>=0 ){
                row.snssde = row.ynssde - v_mze;
            }
            $(snssde.target).attr("value", row.snssde);
            
            //税率及速算扣除
            $.each(geshui_obj, function (i1, item) {
               	if(row.snssde>item.ksje&&row.snssde<=item.jsje){
                    $(sl.target).attr("value", item.sl);
                    $(sskc.target).attr("value",item.sskcs);
               	}
            });
            
            //个人所得税 = 实纳税所得额 * 税率/100 - 速算扣除
            var v_sl = parseFloat($(sl.target).val())||0;
            var v_sskc = parseFloat($(sskc.target).val())||0;
            row.grsds = row.snssde * v_sl / 100 - v_sskc;
            row.grsds = row.grsds.toFixed(2);
            $(grsds.target).attr("value", row.grsds);
            
            //税后工资 = 应纳税所得额 - 个人所得税
            row.shgz = row.ynssde - row.grsds;
            $(shgz.target).attr("value", row.shgz);
            
            //实发工资 = 税后工资 + 其他
            var v_qt = parseFloat($(qt.target).val())||0;
            row.sfgz = row.shgz + v_qt;
            $(sfgz.target).attr("value", row.sfgz);
    }
    
    
    //保存数据
    function saveData(title, addurl, gname) {
        var editIndex = $('#' + gname).datagrid('getRows').length - 1;
        for (var i = 0; i <= editIndex; i++) {
            if ($('#' + gname).datagrid('validateRow', i))
                $('#' + gname).datagrid('endEdit', i);
        }
            var rows = $('#ayGzList').datagrid("getRows");
            alert(JSON.stringify(rows));
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


//导入
        function ImportXls() {
            openuploadwin('Excel导入', 'ayGzController.do?upload', "ayGzList");
        }

//导出
        function ExportXls() {
        	var sjpz = $("#riqiid").val();
            JeecgExcelExport("ayGzController.do?exportXls&sjpzid="+sjpz, "ayGzList");
        }

//模板下载
        function ExportXlsByT() {
            JeecgExcelExport("ayGzController.do?exportXlsByT", "ayGzList");
        }



</script>