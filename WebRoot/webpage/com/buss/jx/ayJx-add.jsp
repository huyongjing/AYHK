<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>绩效表</title>
     <hp:base type="hplusCss"></hp:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table" action="ayJxController.do?doAdd" tiptype="1" callback="@Override afterSubmit" >
					<input id="id" name="id" type="hidden" value="${ayJxPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayJxPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayJxPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayJxPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayJxPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayJxPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayJxPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayJxPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayJxPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayJxPage.bpmStatus }">
					<input id="zxbm" name="zxbm" type="hidden" value="${ayJxPage.zxbm }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayJxPage.sjpzid }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayJxPage.ygxxid }">
                <div class="row form1">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title text-center">
                            <h3>绩效表</h3>
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
                <label class="col-sm-2 control-label">实际课时总数:</label>
            <div class="col-sm-3">
					     	 <input id="sjkszs" name="sjkszs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际课时总数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">绩效系数:</label>
            <div class="col-sm-3">
					     	 <input id="jxxs" name="jxxs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效系数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">绩效课时数:</label>
            <div class="col-sm-3">
					     	 <input id="jxkss" name="jxkss" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效课时数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">cpep评估:</label>
            <div class="col-sm-3">
					     	 <input id="cpep" name="cpep" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">cpep评估</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">c评估系数:</label>
            <div class="col-sm-3">
					     	 <input id="cpgxs" name="cpgxs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">c评估系数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">c评估课时:</label>
            <div class="col-sm-3">
					     	 <input id="cpgks" name="cpgks" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">c评估课时</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">VB评估:</label>
            <div class="col-sm-3">
					     	 <input id="vbpg" name="vbpg" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">VB评估</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">v评估系数:</label>
            <div class="col-sm-3">
					     	 <input id="vpgxs" name="vpgxs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">v评估系数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">v评估课时:</label>
            <div class="col-sm-3">
					     	 <input id="vpgks" name="vpgks" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">v评估课时</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时总数:</label>
            <div class="col-sm-3">
					     	 <input id="kszs" name="kszs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时总数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">达标课时数:</label>
            <div class="col-sm-3">
					     	 <input id="dbkss" name="dbkss" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">达标课时数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">达标奖金:</label>
            <div class="col-sm-3">
					     	 <input id="dbjj" name="dbjj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">达标奖金</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">超出课时数:</label>
            <div class="col-sm-3">
					     	 <input id="cckss" name="cckss" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">超出课时数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">第一档课时数:</label>
            <div class="col-sm-3">
					     	 <input id="dydkss" name="dydkss" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第一档课时数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时费:</label>
            <div class="col-sm-3">
					     	 <input id="ksf" name="ksf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时奖金:</label>
            <div class="col-sm-3">
					     	 <input id="ksjj" name="ksjj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">第二档课时数:</label>
            <div class="col-sm-3">
					     	 <input id="dedkss2" name="dedkss2" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第二档课时数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时费:</label>
            <div class="col-sm-3">
					     	 <input id="ksf2" name="ksf2" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时奖金:</label>
            <div class="col-sm-3">
					     	 <input id="ksjj2" name="ksjj2" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">第三档课时数:</label>
            <div class="col-sm-3">
					     	 <input id="dsdkss3" name="dsdkss3" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三档课时数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时费:</label>
            <div class="col-sm-3">
					     	 <input id="ksf3" name="ksf3" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时奖金:</label>
            <div class="col-sm-3">
					     	 <input id="ksjj3" name="ksjj3" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时费合计:</label>
            <div class="col-sm-3">
					     	 <input id="ksfhj" name="ksfhj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费合计</label>
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
