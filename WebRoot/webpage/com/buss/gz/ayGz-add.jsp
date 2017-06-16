<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工资表</title>
     <hp:base type="hplusCss"></hp:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <hp:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table" action="ayGzController.do?doAdd" tiptype="1" callback="@Override afterSubmit" >
					<input id="id" name="id" type="hidden" value="${ayGzPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayGzPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayGzPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayGzPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayGzPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayGzPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayGzPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayGzPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayGzPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayGzPage.bpmStatus }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayGzPage.sjpzid }">
					<input id="zxbm" name="zxbm" type="hidden" value="${ayGzPage.zxbm }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayGzPage.ygxxid }">
                <div class="row form1">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title text-center">
                            <h3>工资表</h3>
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
                <label class="col-sm-2 control-label">岗位:</label>
            <div class="col-sm-3">
					     	 <input id="gw" name="gw" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">员工类型:</label>
            <div class="col-sm-3">
					     	 <input id="yglx" name="yglx" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">员工类型</label>
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
                <label class="col-sm-2 control-label">岗位工资:</label>
            <div class="col-sm-3">
					     	 <input id="gwgz" name="gwgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位工资</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">职称工资:</label>
            <div class="col-sm-3">
					     	 <input id="zcgz" name="zcgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职称工资</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">年资工资:</label>
            <div class="col-sm-3">
					     	 <input id="nzgz" name="nzgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年资工资</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">绩效工资:</label>
            <div class="col-sm-3">
					     	 <input id="jxgz" name="jxgz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效工资</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">管理绩效:</label>
            <div class="col-sm-3">
					     	 <input id="gljx" name="gljx" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理绩效</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">课时奖励:</label>
            <div class="col-sm-3">
					     	 <input id="ksjl" name="ksjl" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖励</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">全勤奖:</label>
            <div class="col-sm-3">
					     	 <input id="qqj" name="qqj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">全勤奖</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">缺勤扣款:</label>
            <div class="col-sm-3">
					     	 <input id="qqkk" name="qqkk" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">缺勤扣款</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">餐费补助:</label>
            <div class="col-sm-3">
					     	 <input id="cfbz" name="cfbz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">餐费补助</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">交通补助:</label>
            <div class="col-sm-3">
					     	 <input id="jtbz" name="jtbz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交通补助</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">住房补助:</label>
            <div class="col-sm-3">
					     	 <input id="zfbz" name="zfbz" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房补助</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">应发工资总额:</label>
            <div class="col-sm-3">
					     	 <input id="yfgzze" name="yfgzze" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应发工资总额</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">养老保险基数:</label>
            <div class="col-sm-3">
					     	 <input id="ylbxjs" name="ylbxjs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险基数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">其他四险基数:</label>
            <div class="col-sm-3">
					     	 <input id="qtsxjs" name="qtsxjs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他四险基数</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">公积金基数:</label>
            <div class="col-sm-3">
					     	 <input id="gjjjs" name="gjjjs" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公积金基数</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">养老保险公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="ylbxgscd" name="ylbxgscd" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险公司承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">失业保险公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="sybxgscdbf1" name="sybxgscdbf1" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险公司承担部分</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">医疗保险公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="ylbxgscdbf1" name="ylbxgscdbf1" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险公司承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">工伤保险公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="gsbxgscdbf" name="gsbxgscdbf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工伤保险公司承担部分</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">生育保险公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="sybxgscdbf" name="sybxgscdbf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生育保险公司承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">住房公积金公司承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="zfgjjgscdbf" name="zfgjjgscdbf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金公司承担部分</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">养老保险个人承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="ylbxgrcdbf" name="ylbxgrcdbf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险个人承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">失业保险个人承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="sybxgrcdbf2" name="sybxgrcdbf2" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险个人承担部分</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">医疗保险个人承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="ylbxgrcdbf2" name="ylbxgrcdbf2" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险个人承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">个人医疗补充保险:</label>
            <div class="col-sm-3">
					     	 <input id="gsylbc" name="gsylbc" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人医疗补充保险</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">住房公积金个人承担部分:</label>
            <div class="col-sm-3">
					     	 <input id="zfgjjgrcdbf" name="zfgjjgrcdbf" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金个人承担部分</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">公司承担合计:</label>
            <div class="col-sm-3">
					     	 <input id="gscdhj" name="gscdhj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司承担合计</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">个人承担合计:</label>
            <div class="col-sm-3">
					     	 <input id="grcdhj" name="grcdhj" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">个人承担合计</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">应纳税所得额:</label>
            <div class="col-sm-3">
					     	 <input id="ynssde" name="ynssde" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应纳税所得额</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">免征额:</label>
            <div class="col-sm-3">
					     	 <input id="mze" name="mze" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">免征额</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实纳税所得额:</label>
            <div class="col-sm-3">
					     	 <input id="snssde" name="snssde" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实纳税所得额</label>
                </div>
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label">税率:</label>
            <div class="col-sm-3">
					     	 <input id="sl" name="sl" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">速算扣除:</label>
            <div class="col-sm-3">
					     	 <input id="sskc" name="sskc" type="text"  class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">速算扣除</label>
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
                    <label class="col-sm-2 control-label">银行帐号:</label>
                <div class="col-sm-3">
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
