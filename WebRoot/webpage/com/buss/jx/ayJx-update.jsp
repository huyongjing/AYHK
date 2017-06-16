<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>绩效表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ayJxController.do?doUpdate" tiptype="1" >
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
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.xm}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实际课时总数:
							</label>
						</td>
						<td class="value">
						     	 <input id="sjkszs" name="sjkszs" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.sjkszs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际课时总数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								绩效系数:
							</label>
						</td>
						<td class="value">
						     	 <input id="jxxs" name="jxxs" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.jxxs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效系数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								绩效课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="jxkss" name="jxkss" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.jxkss}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">绩效课时数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								cpep评估:
							</label>
						</td>
						<td class="value">
						     	 <input id="cpep" name="cpep" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.cpep}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">cpep评估</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								c评估系数:
							</label>
						</td>
						<td class="value">
						     	 <input id="cpgxs" name="cpgxs" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.cpgxs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">c评估系数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								c评估课时:
							</label>
						</td>
						<td class="value">
						     	 <input id="cpgks" name="cpgks" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.cpgks}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">c评估课时</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								VB评估:
							</label>
						</td>
						<td class="value">
						     	 <input id="vbpg" name="vbpg" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.vbpg}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">VB评估</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								v评估系数:
							</label>
						</td>
						<td class="value">
						     	 <input id="vpgxs" name="vpgxs" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.vpgxs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">v评估系数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								v评估课时:
							</label>
						</td>
						<td class="value">
						     	 <input id="vpgks" name="vpgks" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.vpgks}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">v评估课时</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课时总数:
							</label>
						</td>
						<td class="value">
						     	 <input id="kszs" name="kszs" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.kszs}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时总数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								达标课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="dbkss" name="dbkss" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.dbkss}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">达标课时数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								达标奖金:
							</label>
						</td>
						<td class="value">
						     	 <input id="dbjj" name="dbjj" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.dbjj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">达标奖金</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								超出课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="cckss" name="cckss" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.cckss}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">超出课时数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								第一档课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="dydkss" name="dydkss" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.dydkss}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第一档课时数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								课时费:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksf" name="ksf" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksf}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课时奖金:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksjj" name="ksjj" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksjj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								第二档课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="dedkss2" name="dedkss2" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.dedkss2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第二档课时数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课时费:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksf2" name="ksf2" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksf2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								课时奖金:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksjj2" name="ksjj2" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksjj2}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								第三档课时数:
							</label>
						</td>
						<td class="value">
						     	 <input id="dsdkss3" name="dsdkss3" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.dsdkss3}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三档课时数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								课时费:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksf3" name="ksf3" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksf3}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								课时奖金:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksjj3" name="ksjj3" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksjj3}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时奖金</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								课时费合计:
							</label>
						</td>
						<td class="value">
						     	 <input id="ksfhj" name="ksfhj" type="text" style="width: 150px" class="inputxt"  value='${ayJxPage.ksfhj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">课时费合计</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/jx/ayJx.js"></script>		
