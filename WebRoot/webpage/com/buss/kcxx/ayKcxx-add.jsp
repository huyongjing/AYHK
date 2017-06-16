<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程信息</title>
    <hp:base type="hplusCss"></hp:base>

</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table" action="ayKcxxController.do?doAdd" tiptype="1" callback="@Override afterSubmit">
<input id="id" name="id" type="hidden" value="${ayKcxxPage.id }">
<input id="createName" name="createName" type="hidden" value="${ayKcxxPage.createName }">
<input id="createBy" name="createBy" type="hidden" value="${ayKcxxPage.createBy }">
<input id="createDate" name="createDate" type="hidden" value="${ayKcxxPage.createDate }">
<input id="updateName" name="updateName" type="hidden" value="${ayKcxxPage.updateName }">
<input id="updateBy" name="updateBy" type="hidden" value="${ayKcxxPage.updateBy }">
<input id="updateDate" name="updateDate" type="hidden" value="${ayKcxxPage.updateDate }">
<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayKcxxPage.sysOrgCode }">
<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayKcxxPage.sysCompanyCode }">
<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayKcxxPage.bpmStatus }">
<div class="row form1">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title text-center">
                <h3>课程信息</h3>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">课程名:</label>
            <div class="col-sm-3">
                <input id="kcmc" name="kcmc" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">课程名</label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">课程系数:</label>
            <div class="col-sm-3">
                <input id="kcxs" name="kcxs" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">课程系数</label>
            </div>
        </div>
    </div>
    </hp:formvalid>
</body>
<script language="JavaScript">
    function afterSubmit(datass) {
        if (datass.success) {
            layer.open({
                icon: 1,
                content: datass.msg
                , yes: function (index) {
                    var win = frameElement.api.opener;
                    win.reloadTable();
                    frameElement.api.close();
                    //parent.windowapi.reload();
                    //parent.windowapi.close();
                    layer.close(index);
                }
            });
        }
    }
</script>
</html>
