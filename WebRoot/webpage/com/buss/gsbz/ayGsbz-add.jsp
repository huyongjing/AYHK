<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>个税标准</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="ayGsbzController.do?doAdd" tiptype="1">
    <input id="id" name="id" type="hidden" value="${ayGsbzPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayGsbzPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayGsbzPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayGsbzPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayGsbzPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayGsbzPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayGsbzPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayGsbzPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayGsbzPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayGsbzPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>个税标准</h3>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">等级:</label>
                <div class="col-sm-3">
                    <input id="dj" name="dj" type="text" class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">等级</label>
                </div>
                <label class="col-sm-2 control-label">等级开始金额:</label>
                <div class="col-sm-3">
                    <input id="ksje" name="ksje" type="text" class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">等级开始金额</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">等级结束金额:</label>
                <div class="col-sm-3">
                    <input id="jsje" name="jsje" type="text" class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">等级结束金额</label>
                </div>
                <label class="col-sm-2 control-label">税率:</label>
                <div class="col-sm-3">
                    <input id="sl" name="sl" type="text" class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">税率</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">速算扣除数:</label>
                <div class="col-sm-3">
                    <input id="sskcs" name="sskcs" type="text" class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">速算扣除数</label>
                </div>
                <label class="col-sm-2 control-label">说明:</label>
                <div class="col-sm-3">
                    <input id="sm" name="sm" type="text" class="form-control">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">说明</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
        </div>
    </div>
    <hp:base type="hplusJs" plugins="jqueryMigrate,DatePicker"></hp:base>
</hp:formvalid>
</body>
<script language="JavaScript">
    function afterSubmit(datass) {
        if (datass.success) {
            layer.alert(datass.msg);
        }
    }
</script>
</html>
