<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>社会公积金</title>
	 <hp:base type="hplusCss"></hp:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" styleClass="form-horizontal" layout="table" action="ayShgjjController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${ayShgjjPage.id }">
					<input id="createName" name="createName" type="hidden" value="${ayShgjjPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${ayShgjjPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${ayShgjjPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ayShgjjPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${ayShgjjPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ayShgjjPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayShgjjPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayShgjjPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayShgjjPage.bpmStatus }">
					<input id="ygxxid" name="ygxxid" type="hidden" value="${ayShgjjPage.ygxxid }">
					<input id="sjpzid" name="sjpzid" type="hidden" value="${ayShgjjPage.sjpzid }">

			<div class="row form1">
				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title text-center">
							<h3>社会公积金</h3>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">姓名:</label>
						<div class="col-sm-3">
							<input id="xm" name="xm" type="text" class="form-control" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</div>
						<label class="col-sm-2 control-label">岗位:</label>
						<div class="col-sm-3">
							<input id="gw" name="gw" type="text" class="form-control" value='${ayShgjjPage.gw}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">岗位</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">员工类型:</label>
						<div class="col-sm-3">
							<input id="yglx" name="yglx" type="text" class="form-control" value='${ayShgjjPage.yglx}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">员工类型</label>
						</div>
						<label class="col-sm-2 control-label">养老保险基数:</label>
						<div class="col-sm-3">
							<input id="ylbxjs" name="ylbxjs" type="text" class="form-control" value='${ayShgjjPage.ylbxjs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险基数</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">其他四险基数:</label>
						<div class="col-sm-3">
							<input id="qtsxjs" name="qtsxjs" type="text" value='${ayShgjjPage.qtsxjs}' class="form-control">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他四险基数</label>
						</div>

						<label class="col-sm-2 control-label">公积金基数:</label>
						<div class="col-sm-3">
							<input id="gjjjs" name="gjjjs" type="text" class="form-control" 　value='${ayShgjjPage.gjjjs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公积金基数</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">养老保险公司承担部分:</label>
						<div class="col-sm-3">
							<input id="ylbxgscd" name="ylbxgscd" type="text" class="form-control" 　 value='${ayShgjjPage.ylbxgscd}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险公司承担部分</label>
						</div>

						<label class="col-sm-2 control-label">失业保险公司承担部分:</label>
						<div class="col-sm-3">
							<input id="sybxgscdbf1" name="sybxgscdbf1" type="text" class="form-control" 　value='${ayShgjjPage.sybxgscdbf1}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险公司承担部分</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">医疗保险公司承担部分:</label>
						<div class="col-sm-3">
							<input id="ylbxgscdbf1" name="ylbxgscdbf1" type="text" class="form-control" 　value='${ayShgjjPage.ylbxgscdbf1}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险公司承担部分</label>
						</div>

						<label class="col-sm-2 control-label">工伤保险公司承担部分:</label>
						<div class="col-sm-3">
							<input id="gsbxgscdbf" name="gsbxgscdbf" type="text" class="form-control" 　value='${ayShgjjPage.gsbxgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工伤保险公司承担部分</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">生育保险公司承担部分:</label>
						<div class="col-sm-3">
							<input id="sybxgscdbf" name="sybxgscdbf" type="text" class="form-control" 　value='${ayShgjjPage.sybxgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生育保险公司承担部分</label>
						</div>

						<label class="col-sm-2 control-label">住房公积金公司承担部分:</label>
						<div class="col-sm-3">
							<input id="zfgjjgscdbf" name="zfgjjgscdbf" type="text" class="form-control" 　value='${ayShgjjPage.zfgjjgscdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金公司承担部分</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">养老保险个人承担部分:</label>
						<div class="col-sm-3">
							<input id="ylbxgrcdbf" name="ylbxgrcdbf" type="text" class="form-control" 　value='${ayShgjjPage.ylbxgrcdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">养老保险个人承担部分</label>
						</div>

						<label class="col-sm-2 control-label">失业保险个人承担部分:</label>
						<div class="col-sm-3">
							<input id="sybxgrcdbf2" name="sybxgrcdbf2" type="text" class="form-control" 　value='${ayShgjjPage.sybxgrcdbf2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失业保险个人承担部分</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">医疗保险个人承担部分:</label>
						<div class="col-sm-3">
							<input id="ylbxgrcdbf2" name="ylbxgrcdbf2" type="text" class="form-control" 　value='${ayShgjjPage.ylbxgrcdbf2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">医疗保险个人承担部分</label>
						</div>

						<label class="col-sm-2 control-label">住房公积金个人承担部分:</label>
						<div class="col-sm-3">
							<input id="zfgjjgrcdbf" name="zfgjjgrcdbf" type="text" class="form-control" 　value='${ayShgjjPage.zfgjjgrcdbf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金个人承担部分</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">住房公积金合计:</label>
						<div class="col-sm-3">
							<input id="zfgjjhj" name="zfgjjhj" type="text" class="form-control" 　value='${ayShgjjPage.zfgjjhj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">住房公积金合计</label>
						</div>

						<label class="col-sm-2 control-label">保险合计:</label>
						<div class="col-sm-3">
							<input id="bxhj" name="bxhj" type="text" class="form-control" 　value='${ayShgjjPage.bxhj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险合计</label>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">备注:</label>
						<div class="col-sm-3">
							<input id="bz" name="bz" type="text" class="form-control" value='${ayShgjjPage.bz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</div>

						<label class="col-sm-2 control-label">中心:</label>
						<div class="col-sm-3">
							<input id="zxbm" name="zxbm" type="text" class="form-control" 　value='${ayShgjjPage.zxbm}'>　
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中心</label>
						</div>

					</div>
				</div>
			</div>
			<hp:base type="hplusJs" plugins="jqueryMigrate,DatePicker"></hp:base>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/shgjj/ayShgjj.js"></script>		
