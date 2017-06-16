<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程配置</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="ayKcpzController.do?doAdd" tiptype="1" callback="@Override afterSubmit">
    <input id="id" name="id" type="hidden" value="${ayKcpzPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayKcpzPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayKcpzPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayKcpzPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayKcpzPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayKcpzPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayKcpzPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayKcpzPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayKcpzPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayKcpzPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>课程配置</h3>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课程编码:</label>
                <div class="col-sm-3">
                    <input id="kcbm" name="kcbm" type="text"
                           class="form-control" >
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">课程编码</label>
                </div>

                <label class="col-sm-2 control-label">课程名称:</label>
                <div class="col-sm-3">
                    <input id="kcmc" name="kcmc" type="text"
                           class="form-control">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">课程名称</label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">中心:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="zx" type="list" id="djzclx" dictTable="AY_ZXPZ"
                                  dictText="zx" dictField="zxbm"
                                  dictCondition=""
                                  defaultVal="" hasLabel="false"
                                  title="中心" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <%--<input id="zx" name="zx" type="text"
                           class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中心</label>
                </div>
                <label class="col-sm-2 control-label">系数:</label>
                <div class="col-sm-3">
                    <input id="xs" name="xs" type="text"
                           class="form-control" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">系数</label>
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
                ,yes: function(index){
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
