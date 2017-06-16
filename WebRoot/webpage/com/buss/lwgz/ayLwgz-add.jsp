<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>劳务工资</title>
     <hp:base type="hplusCss"></hp:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table" action="ayLwgzController.do?doAdd" tiptype="1" callback="@Override afterSubmit" >
					<input id="id" name="id" type="hidden" value="${ayLwgzPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayLwgzPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayLwgzPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayLwgzPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayLwgzPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayLwgzPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayLwgzPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayLwgzPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayLwgzPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayLwgzPage.bpmStatus }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayLwgzPage.sjpzid }">
					<input id="zxbm" name="zxbm" type="hidden" value="${ayLwgzPage.zxbm }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayLwgzPage.ygxxid }">
                <div class="row form1">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title text-center">
                            <h3>劳务工资</h3>
                        </div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">姓名:</label>
            <div class="col-sm-3">
					     	 <input id="xm" name="xm" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">身份证号:</label>
            <div class="col-sm-3">
					     	 <input id="sfzh" name="sfzh" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">基本工资:</label>
            <div class="col-sm-3">
					     	 <input id="jbgz" name="jbgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">基本工资</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">补贴:</label>
            <div class="col-sm-3">
					     	 <input id="bt" name="bt" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">补贴</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">合计:</label>
            <div class="col-sm-3">
					     	 <input id="hj" name="hj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合计</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">免征额:</label>
            <div class="col-sm-3">
					     	 <input id="mze" name="mze" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">免征额</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实纳税所得额:</label>
            <div class="col-sm-3">
					     	 <input id="snssde" name="snssde" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实纳税所得额</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">税率:</label>
            <div class="col-sm-3">
					     	 <input id="sl" name="sl" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">个人所得税:</label>
            <div class="col-sm-3">
					     	 <input id="grsds" name="grsds" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人所得税</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">税后工资:</label>
            <div class="col-sm-3">
					     	 <input id="shgz" name="shgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税后工资</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">其他:</label>
            <div class="col-sm-3">
					     	 <input id="qt" name="qt" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实发工资:</label>
            <div class="col-sm-3">
					     	 <input id="sfgz" name="sfgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实发工资</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">银行帐号:</label>
            <div class="col-sm-3">
					     	 <input id="yhzh" name="yhzh" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行帐号</label>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">餐补:</label>
                <div class="col-sm-3">
                 <input id="cb" name="cb" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">餐补</label>
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
