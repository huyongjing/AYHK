<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>填报系数</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="ayTbxsController.do?doAdd" tiptype="1" callback="@Override afterSubmit">
    <input id="id" name="id" type="hidden" value="${ayTbxsPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayTbxsPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayTbxsPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayTbxsPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayTbxsPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayTbxsPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayTbxsPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayTbxsPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayTbxsPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayTbxsPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>填报系数</h3>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">中心:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="zx" type="list" id="djzclx" dictTable="AY_ZXPZ"
                                  dictText="zx" dictField="zxbm"
                                  dictCondition=""
                                  defaultVal="" hasLabel="false"
                                  title="中心" extendJson="{'class':'form-control'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中心</label>
                </div>

                <label class="col-sm-2 control-label">养老保险公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="ylbxgscd" name="ylbxgscd" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">养老保险公司承担部分</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">失业保险公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="sybxgscdbf1" name="sybxgscdbf1" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">失业保险公司承担部分</label>
                </div>

                <label class="col-sm-2 control-label">医疗保险公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="ylbxgscdbf1" name="ylbxgscdbf1" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">医疗保险公司承担部分</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">工伤保险公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="gsbxgscdbf" name="gsbxgscdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">工伤保险公司承担部分</label>
                </div>

                <label class="col-sm-2 control-label">生育保险公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="sybxgscdbf" name="sybxgscdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">生育保险公司承担部分</label>

                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">住房公积金公司承担部分:</label>
                <div class="col-sm-3">
                    <input id="zfgjjgscdbf" name="zfgjjgscdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">住房公积金公司承担部分</label>
                </div>

                <label class="col-sm-2 control-label">养老保险个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="ylbxgrcdbf" name="ylbxgrcdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">养老保险个人承担部分</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">失业保险个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="sybxgrcdbf2" name="sybxgrcdbf2" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">失业保险个人承担部分</label>
                </div>

                <label class="col-sm-2 control-label">医疗保险个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="ylbxgrcdbf2" name="ylbxgrcdbf2" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">医疗保险个人承担部分</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">工伤保险个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="gsbxgrcdbf" name="gsbxgrcdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">工伤保险个人承担部分</label>
                </div>

                <label class="col-sm-2 control-label">生育保险个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="sybxgrcdbf" name="sybxgrcdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">生育保险个人承担部分</label>

                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">住房公积金个人承担部分:</label>
                <div class="col-sm-3">
                    <input id="zfgjjgrcdbf" name="zfgjjgrcdbf" type="text" class="form-control"
                           datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">住房公积金个人承担部分</label>
                </div>

                <label class="col-sm-2 control-label">个人医疗补充保险:</label>
                <div class="col-sm-3">
                    <input id="gsylbc" name="gsylbc" type="text" class="form-control" datatype="/^\d+(\.\d{0,2})?$/">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">个人医疗补充保险</label>

                </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label">户口类型:</label>
            <div class="col-sm-3">
                <t:dictSelect field="hklx" type="list" id="hklx" typeGroupCode="hklx"
                              defaultVal="" hasLabel="false"
                              title="户口类型" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">户口类型</label>
            </div>
            <!-- 
                <label class="col-sm-2 control-label">系数类型:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="xzxs" type="list" id="xzxs" typeGroupCode="xzxs" 
                              defaultVal="" hasLabel="false"
                              title="系数类型" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">系数类型</label>
                </div>
 -->

            </div>
            
            <div class="form-group">
                <label class="col-sm-2 control-label">备注:</label>
                <div class="col-sm-3">
                    <input id="bz" name="bz" type="text" class="form-control">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">备注</label>
                </div>


            </div>
            
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
    }
</script>
</html>
