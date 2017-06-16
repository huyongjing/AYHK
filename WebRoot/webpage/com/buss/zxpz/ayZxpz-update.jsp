<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>地区中心配置</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayZxpzController.do?doUpdate"
             tiptype="1">
    <input id="id" name="id" type="hidden" value="${ayZxpzPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayZxpzPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayZxpzPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayZxpzPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayZxpzPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayZxpzPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayZxpzPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayZxpzPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayZxpzPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayZxpzPage.bpmStatus }">

    <div class="row form1">
        <div class="ibox float-e-margins">
            <div class="ibox-title text-center">
                <h3>地区中心配置</h3>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">中心地区:</label>
            <div class="col-sm-3">
                <input id="zx" name="zx" type="text" readonly="readonly" class="form-control" value='${ayZxpzPage.zx}'>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">中心地区</label>
            </div>
            <label class="col-sm-2 control-label">中心编码:</label>
            <div class="col-sm-3">
            <!--     <input id="zxbm" name="zxbm" type="text" readonly="readonly"   class="form-control" datatype="n" value='${ayZxpzPage.zxbm}'>  --> 
                <t:dictSelect field="zxbm" type="list" id="zxbm" dictTable="T_S_DEPART" readonly="readonly"
                          dictText="departname" dictField="org_code"
                          dictCondition=" where description = 'ay'"
                          defaultVal="${ayZxpzPage.zxbm}" hasLabel="false"
                          title="中心" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">中心编码</label>
            </div>
        </div>
        
        <div class="form-group">
             <label class="col-sm-2 control-label">正式员工免征额:</label>
             <div class="col-sm-3">
                 <input id="zsmze" name="zsmze" type="text" class="form-control" datatype="n"
                        value="${ayZxpzPage.zsmze}">
                 <span class="Validform_checktip"></span>
                 <label class="Validform_label" style="display: none;">正式员工免征额</label>
             </div>
             <label class="col-sm-2 control-label">劳务员工免征额:</label>
             <div class="col-sm-3">
                 <input id="lwmze" name="lwmze" type="text" class="form-control" datatype="n"
                        value="${ayZxpzPage.lwmze}">
                 <span class="Validform_checktip"></span>
                 <label class="Validform_label" style="display: none;">劳务员工免征额</label>
             </div>
         </div>
        <div class="form-group" style="display:none">
            <label class="col-sm-2 control-label">隐藏表头(字段):</label>
            <div class="col-sm-3">
                <input id="yczd" name="yczd" type="text" value="${ayZxpzPage.yczd}" class="form-control" datatype="*">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">隐藏表头</label>
            </div>
        </div>
        
        
    </div>
    <hp:base type="hplusJs" plugins="jqueryMigrate,DatePicker"></hp:base>
</t:formvalid>
</body>
<script src="webpage/com/buss/zxpz/ayZxpz.js"></script>
