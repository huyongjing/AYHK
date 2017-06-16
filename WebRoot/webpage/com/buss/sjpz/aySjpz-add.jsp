<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>时间配置表</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="aySjpzController.do?doAdd" tiptype="1" callback="@Override afterSubmit" >
    <input id="id" name="id" type="hidden" value="${aySjpzPage.id }">
    <input id="createName" name="createName" type="hidden" value="${aySjpzPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${aySjpzPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${aySjpzPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${aySjpzPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${aySjpzPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${aySjpzPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${aySjpzPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${aySjpzPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${aySjpzPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>时间配置表</h3>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">年份:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="year" extendJson="{'class':'form-control'}" type="list" id="year" typeGroupCode="year" defaultVal="" hasLabel="false" title="" datatype="*"></t:dictSelect>

                   <%-- <input id="year" name="year" type="text" class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">年份</label>
                </div>


                <label class="col-sm-2 control-label">月份:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="month" extendJson="{'class':'form-control'}" type="list" id="month" typeGroupCode="month" defaultVal="" hasLabel="false" title="" datatype="*"></t:dictSelect>

                   <%-- <input id="month" name="month" type="text" class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">月份</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">中心编码:</label>
                <div class="col-sm-3">
                    <t:dictSelect  datatype="*" field="zxbm" type="list" id="zxbm" dictTable="AY_ZXPZ"
                                  dictText="zx" dictField="zxbm"
                                  dictCondition=""
                                  defaultVal="" hasLabel="false"
                                  title="中心" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <%--<input id="zxbm" name="zxbm" type="text" class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中心编码</label>
                </div>
            </div>
        </div>
    </div>
    <hp:base type="hplusJs" plugins="jqueryMigrate,DatePicker"></hp:base>
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
        openwindow("课程管理","ayKcxxController.do?list","","800","600");
    }
</script>
</html>
