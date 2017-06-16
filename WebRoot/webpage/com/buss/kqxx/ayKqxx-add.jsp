<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>考勤信息表</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table"
              action="ayKqxxController.do?doAdd" tiptype="1" callback="@Override afterSubmit">
<input id="id" name="id" type="hidden" value="${ayKqxxPage.id }">
<input id="createName" name="createName" type="hidden" value="${ayKqxxPage.createName }">
<input id="createBy" name="createBy" type="hidden" value="${ayKqxxPage.createBy }">
<input id="createDate" name="createDate" type="hidden" value="${ayKqxxPage.createDate }">
<input id="updateName" name="updateName" type="hidden" value="${ayKqxxPage.updateName }">
<input id="updateBy" name="updateBy" type="hidden" value="${ayKqxxPage.updateBy }">
<input id="updateDate" name="updateDate" type="hidden" value="${ayKqxxPage.updateDate }">
<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayKqxxPage.sysOrgCode }">
<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayKqxxPage.sysCompanyCode }">
<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayKqxxPage.bpmStatus }">
<div class="row form1">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title text-center">
                <h3>考勤信息表</h3>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名:</label>
            <div class="col-sm-3">
                <input id="xm" name="xm" type="text" class="form-control" datatype="*">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">姓名</label>
            </div>
            <label class="col-sm-2 control-label">员工类型:</label>
            <div class="col-sm-3">
                <input id="yglx" name="yglx" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">员工类型</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">当月应出勤:</label>
            <div class="col-sm-3">
                <input id="dyycq" name="dyycq" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">当月应出勤</label>
            </div>
            <label class="col-sm-2 control-label">实际出勤:</label>
            <div class="col-sm-3">
                <input id="sjcq" name="sjcq" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际出勤</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">出差:</label>
            <div class="col-sm-3">
                <input id="cc" name="cc" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">出差</label>
            </div>
            <label class="col-sm-2 control-label">计薪日:</label>
            <div class="col-sm-3">
                <input id="jxr" name="jxr" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">计薪日</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">餐补:</label>
            <div class="col-sm-3">
                <input id="cb" name="cb" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">餐补</label>
            </div>
            <label class="col-sm-2 control-label">交通补:</label>
            <div class="col-sm-3">
                <input id="jtb" name="jtb" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">交通补</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">住房补贴标准:</label>
            <div class="col-sm-3">
                <input id="zfbtbz" name="zfbtbz" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">住房补贴标准</label>
            </div>
            <label class="col-sm-2 control-label">住房补:</label>
            <div class="col-sm-3">
                <input id="zfb" name="zfb" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">住房补</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">法定假或公休带薪假:</label>
            <div class="col-sm-3">
                <input id="fdj" name="fdj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">法定假或公休带薪假</label>
            </div>
            <label class="col-sm-2 control-label">未入职或离职:</label>
            <div class="col-sm-3">
                <input id="wrz" name="wrz" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">未入职或离职</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">病假 :</label>
            <div class="col-sm-3">
                <input id="bj" name="bj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">病假 </label>
            </div>
            <label class="col-sm-2 control-label">事假 :</label>
            <div class="col-sm-3">
                <input id="sj" name="sj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">事假 </label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">调休:</label>
            <div class="col-sm-3">
                <input id="tx" name="tx" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">调休</label>
            </div>
            <label class="col-sm-2 control-label">带薪年假:</label>
            <div class="col-sm-3">
                <input id="dxnj" name="dxnj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">带薪年假</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">当年年假:</label>
            <div class="col-sm-3">
                <input id="dnnj" name="dnnj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">当年年假</label>
            </div>
            <label class="col-sm-2 control-label">当年剩余年假:</label>
            <div class="col-sm-3">
                <input id="dnsynj" name="dnsynj" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">当年剩余年假</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">加班日期:</label>
            <div class="col-sm-3">
                <input id="jbrq" name="jbrq" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">加班日期</label>
            </div>
            <label class="col-sm-2 control-label">加班事由:</label>
            <div class="col-sm-3">
                <input id="jbsy" name="jbsy" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">加班事由</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">加班天数:</label>
            <div class="col-sm-3">
                <input id="jbts" name="jbts" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">加班天数</label>
            </div>
            <label class="col-sm-2 control-label">剩余加班:</label>
            <div class="col-sm-3">
                <input id="syjb" name="syjb" type="text" class="form-control">
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">剩余加班</label>
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">备注:</label>
            <div class="col-sm-8">
                <textarea id="bz" name="bz" type="text" class="form-control"></textarea>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">备注</label>
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
