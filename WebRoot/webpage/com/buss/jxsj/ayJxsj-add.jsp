<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>绩效时间表</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="ayJxsjController.do?doAdd" tiptype="1" callback="@Override afterSubmit">
    <input id="id" name="id" type="hidden" value="${ayJxsjPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayJxsjPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayJxsjPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayJxsjPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayJxsjPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayJxsjPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayJxsjPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayJxsjPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayJxsjPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayJxsjPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>时间配置表</h3>
                </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label">中心编码:</label>
                <div class="col-sm-3">
                    <t:dictSelect datatype="*" field="zxbm" type="list" id="zxbm1" dictTable="AY_ZXPZ" readonly="readonly"
                                  dictText="zx" dictField="zxbm"
                                  dictCondition=""
                                  defaultVal="${defaultzxbm}" hasLabel="false"
                                  title="中心" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                     <input id="zxbm" name="zxbm" type="hidden" class="inputxt"  value='${defaultzxbm}'> 
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中心编码</label>
                </div>
                <label class="col-sm-2 control-label">年份:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="year" extendJson="{'class':'form-control'}" type="list" id="year"
                                  typeGroupCode="year" defaultVal="" hasLabel="false" title=""
                                  datatype="*"></t:dictSelect>

                        <%-- <input id="year" name="year" type="text" class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">年份</label>
                </div>

            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">月份:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="month" extendJson="{'class':'form-control'}" type="list" id="month"
                                  typeGroupCode="month" defaultVal="" hasLabel="false" title=""
                                  datatype="*"></t:dictSelect>

                        <%-- <input id="month" name="month" type="text" class="form-control">--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">月份</label>
                </div>
                <label class="col-sm-2 control-label">达标课时数:</label>
            		<div class="col-sm-3">
                <input id="dbkss" name="dbkss" type="text" class="form-control" datatype="n" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">达标课时数</label>
            </div>
                
                
            </div>
             <div class="form-group">
                 <label class="col-sm-2 control-label">第一档课时费:</label>
            		<div class="col-sm-3">
                <input id="ksf" name="ksf" type="text" class="form-control" datatype="n" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">第一档课时费</label>
            </div>
            
             <label class="col-sm-2 control-label">第二档课时费:</label>
            		<div class="col-sm-3">
                <input id="ksf2" name="ksf2" type="text" class="form-control" datatype="n" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">第二档课时费</label>
            </div>
            
            </div>
            
            <div class="form-group">
                 <label class="col-sm-2 control-label">第三档课时费:</label>
            		<div class="col-sm-3">
                <input id="ksf3" name="ksf3" type="text" class="form-control" datatype="n" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">第三档课时费</label>
            </div>
            <label class="col-sm-2 control-label">达标奖金:</label>
            		<div class="col-sm-3">
                <input id="dbjj" name="dbjj" type="text" class="form-control" datatype="n" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">达标奖金</label>
            </div>
            
        </div>
        
        <div class="form-group">
                 <label class="col-sm-2 control-label">当月应出勤:</label>
            		<div class="col-sm-3">
                <input id="dyycq" name="dyycq" type="text" class="form-control" datatype="*" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">当月应出勤</label>
            </div>
            <label class="col-sm-2 control-label">法定假期:</label>
            		<div class="col-sm-3">
                <input id="fdj" name="fdj" type="text" class="form-control" datatype="*" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">法定假期</label>
            </div>
        
    </div>
    <!-- 
    <div class="form-group">
                
             <label class="col-sm-2 control-label">餐费补助(每天):</label>
         		<div class="col-sm-3">
                <input id="cf" name="cf" type="text" class="form-control" datatype="*" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">餐费补助</label>
            </div>
            <label class="col-sm-2 control-label">交通补助(每月):</label>
            		<div class="col-sm-3">
                <input id="jt" name="jt" type="text" class="form-control" datatype="*" />
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">交通补助</label>
            </div>
             -->
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
