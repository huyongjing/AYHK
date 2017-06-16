<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>员工基本信息</title>
    <hp:base type="hplusCss"></hp:base>
    <script type="text/javascript">
        //编写自定义JS代码
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" styleClass="form-horizontal" usePlugin="password" layout="table"
             action="ayYgjbxxController.do?doUpdate" tiptype="1">
    <input id="id" name="id" type="hidden" value="${ayYgjbxxPage.id }">
    <input id="createName" name="createName" type="hidden" value="${ayYgjbxxPage.createName }">
    <input id="createBy" name="createBy" type="hidden" value="${ayYgjbxxPage.createBy }">
    <input id="createDate" name="createDate" type="hidden" value="${ayYgjbxxPage.createDate }">
    <input id="updateName" name="updateName" type="hidden" value="${ayYgjbxxPage.updateName }">
    <input id="updateBy" name="updateBy" type="hidden" value="${ayYgjbxxPage.updateBy }">
    <input id="updateDate" name="updateDate" type="hidden" value="${ayYgjbxxPage.updateDate }">
    <input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ayYgjbxxPage.sysOrgCode }">
    <input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ayYgjbxxPage.sysCompanyCode }">
    <input id="bpmStatus" name="bpmStatus" type="hidden" value="${ayYgjbxxPage.bpmStatus }">
    <div class="row form1">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title text-center">
                    <h3>员工基本信息</h3>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-3">
                    <input id="xm" name="xm" type="text" class="form-control" datatype="*" value='${ayYgjbxxPage.xm}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">姓名</label>
                </div>
                <label class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-3">
                    <c:if test="${ayYgjbxxPage.xb=='男性'}"><input type="radio" checked value="${ayYgjbxxPage.xb}" id=""
                                                                 name="xb">男性</label>
                        <input type="radio" value="女性" id="" name="xb">女性</label>
                    </c:if>
                    <c:if test="${ayYgjbxxPage.xb=='女性'}">
                        <input type="radio" value="男性" id="" name="xb">男性</label>
                        <input type="radio" value="${ayYgjbxxPage.xb}" id="" checked name="xb">女性</label>
                    </c:if>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">性别</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">身份证号:</label>
                <div class="col-sm-3">
                    <input id="sfzh" name="sfzh" type="text" class="form-control" value='${ayYgjbxxPage.sfzh}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">身份证号</label>
                </div>
                <label class="col-sm-2 control-label">生日:</label>
                <div class="col-sm-3">
                    <input id="sr" name="sr" type="text" readonly="readonly" class="form-control" class="Wdate"
                           onClick="WdatePicker()" value='${ayYgjbxxPage.sr}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">生日</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">职位:</label>
                <div class="col-sm-3">
                    <input id="zw" name="zw" type="text" class="form-control" value='${ayYgjbxxPage.zw}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">职位</label>
                </div>
                <label class="col-sm-2 control-label">入职日期:</label>
                <div class="col-sm-3">
                    <input id="rzrq" name="rzrq" type="text" readonly="readonly" class="form-control" class="Wdate"
                           onClick="WdatePicker()" value='${ayYgjbxxPage.rzrq}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">入职日期</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">在职状态:</label>
                <div class="col-sm-3">
               <!--      <input id="zzzt" name="zzzt" type="text" class="form-control" value='${ayYgjbxxPage.zzzt}'>  -->
                    <t:dictSelect field="zzzt" type="list" id="zzzt" typeGroupCode="zzzt" readonly = "readonly"
                              defaultVal="${ayYgjbxxPage.zzzt}" hasLabel="false"
                              title="在职状态" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">在职状态</label>
                </div>
                <label class="col-sm-2 control-label">婚姻状况:</label>
                <div class="col-sm-3">
                    <c:if test="${ayYgjbxxPage.hyzk=='未婚'}"><input type="radio" checked value="${ayYgjbxxPage.hyzk}"
                                                                   id="" name="hyzk">未婚</label>
                        <input type="radio" value="已婚" id="" name="hyzk">已婚</label>
                    </c:if>
                    <c:if test="${ayYgjbxxPage.hyzk=='已婚'}">
                        <input type="radio" value="男" id="" name="hyzk">未婚</label>
                        <input type="radio" value="${ayYgjbxxPage.hyzk}" id="" checked name="hyzk">已婚</label>
                    </c:if>
                        <%--
                        <label class="radio-inline">
                            <input type="radio" checked="" value="未婚" id="" name="hyzk">未婚</label>
                        <label class="radio-inline">
                            <input type="radio" value="已婚" id="" name="hyzk">已婚</label>--%>
                        <%-- <t:dictSelect field="hyzk" type="list" id="hyzk"
                                       typeGroupCode="hyzk" defaultVal="" hasLabel="false"
                                       title="婚姻状况" extendJson="{class:form-control}"></t:dictSelect>--%>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">婚姻状况</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">填写人:</label>
                <div class="col-sm-3">
                    <input id="txr" name="txr" type="text" class="form-control" value='${ayYgjbxxPage.txr}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">填写人</label>
                </div>
                <label class="col-sm-2 control-label">填表时间:</label>
                <div class="col-sm-3">
                    <input id="tbsj" name="tbsj" type="text" class="form-control" class="Wdate" onClick="WdatePicker()"
                           readonly="readonly" value='${ayYgjbxxPage.tbsj}'>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">填表时间</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">中心:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="zxbm" type="list" id="djzclx" dictTable="AY_ZXPZ"
                                  dictText="zx" dictField="zxbm"
                                  dictCondition=""
                                  defaultVal="${ayYgjbxxPage.zxbm}" hasLabel="false"
                                  title="中心" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中心</label>
                </div>
                <label class="col-sm-2 control-label">员工类型:</label>
                <div class="col-sm-3">
                  <!--   <input id="yglx" name="yglx" type="text" class="form-control"
                           value="${ayYgjbxxPage.yglx}">  -->
                            <t:dictSelect field="yglx" type="list" id="yglx" typeGroupCode="yglx"
                              defaultVal="${ayYgjbxxPage.yglx}" hasLabel="false"
                              title="员工类型" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">员工类型</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">银行帐号:</label>
                <div class="col-sm-3">
                    <input id="yhzh" name="yhzh" type="text" class="form-control" style="width: 180px"
                           value="${ayYgjbxxPage.yhzh}"></input>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">银行帐号</label>
                </div>
              <!--   <label class="col-sm-2 control-label">深户:</label>
                <div class="col-sm-3">
                    <t:dictSelect field="sfsh" type="list" id="sfsh" typeGroupCode="yesorno"
                                  defaultVal="${ayYgjbxxPage.sfsh}" hasLabel="false"
                                  title="深户" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">深户</label>
                     -->
                   <label class="col-sm-2 control-label">户口类型:</label>
	            <div class="col-sm-3">
	                <t:dictSelect field="sfsh" type="list" id="sfsh" typeGroupCode="hklx"
	                              defaultVal="${ayYgjbxxPage.sfsh}" hasLabel="false"
	                              title="户口类型" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
	                <span class="Validform_checktip"></span>
	                <label class="Validform_label" style="display: none;">户口类型</label>
	            </div>
            
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">入职转正日期:</label>
                <div class="col-sm-3">
                    <input id="rzzzrq" name="rzzzrq" type="text" readonly="readonly" class="form-control" class="Wdate"
                           onClick="WdatePicker()" value="${ayYgjbxxPage.rzzzrq}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">入职转正日期</label>
                </div>
                <label class="col-sm-2 control-label">合同到期日:</label>
                <div class="col-sm-3">
                    <input id="htdqr" name="htdqr" type="text" readonly="readonly" class="form-control" class="Wdate"
                           onClick="WdatePicker()" value="${ayYgjbxxPage.htdqr}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">合同到期日</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">合同续签时间:</label>
                <div class="col-sm-3">
                    <input id="htxqsj" name="htxqsj" type="text" readonly="readonly" class="form-control" class="Wdate"
                           onClick="WdatePicker()" value="${ayYgjbxxPage.htxqsj}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">合同续签时间</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">基本工资:</label>
                        <div class="col-sm-3">
                            <input id="jbgz" name="jbgz" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.jbgz}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">基本工资</label>
                        </div>
                        <label class="col-sm-2 control-label">岗位工资:</label>
                        <div class="col-sm-3">
                            <input id="gwgz" name="gwgz" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.gwgz}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">岗位工资</label>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职称工资:</label>
                        <div class="col-sm-3">
                            <input id="zcgz" name="zcgz" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.zcgz}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">职称工资</label>
                        </div>
                        <label class="col-sm-2 control-label">年资工资:</label>
                        <div class="col-sm-3">
                            <input id="nzgz" name="nzgz" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.nzgz}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">年资工资</label>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">养老保险基数:</label>
                        <div class="col-sm-3">
                            <input id="ylbxjs" name="ylbxjs" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.ylbxjs}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">养老保险基数</label>
                        </div>
                        <label class="col-sm-2 control-label">其他四险基数:</label>
                        <div class="col-sm-3">
                            <input id="qtsxjs" name="qtsxjs" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.qtsxjs}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">其他四险基数</label>
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公积金基数:</label>
                        <div class="col-sm-3">
                            <input id="gjjjs" name="gjjjs" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.gjjjs}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">公积金基数</label>
                        </div>
                        <label class="col-sm-2 control-label">住房补贴:</label>
                        <div class="col-sm-3">
                            <input id="zfbt" name="zfbt" type="text" class="form-control" datatype="n"
                                   value="${ayYgjbxxPage.zfbt}">
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">住房补贴</label>
                        </div>
                    </div>
                    <!-- 
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择系数:</label>
                        <div class="col-sm-3">
                            <t:dictSelect field="xzxs" type="list" id="xzxs" typeGroupCode="xzxs"
                         defaultVal="${ayYgjbxxPage.xzxs}" hasLabel="false"
                         title="选择系数" extendJson="{'class':'form-control','datatype':'*'}"></t:dictSelect>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">选择系数</label>
                        </div>
                    </div>
                     -->
                </div>
            </div>
            
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">餐费补助（天）:</label>
                <div class="col-sm-3">
                    <input id="cfbz" name="cfbz" type="text" class="form-control" datatype="n" value="${ayYgjbxxPage.cfbz}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">餐费补助</label>
                </div>
                <label class="col-sm-2 control-label">交通补助（月）:</label>
                <div class="col-sm-3">
                    <input id="jtbz" name="jtbz" type="text" class="form-control" datatype="n"
                           value="${ayYgjbxxPage.jtbz}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">交通补助</label>
                </div>
            </div>
            
            
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">通讯补助（月）:</label>
                <div class="col-sm-3">
                    <input id="txbz" name="txbz" type="text" class="form-control" datatype="n" value="${ayYgjbxxPage.txbz}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">通讯补助</label>
                </div>
                <label class="col-sm-2 control-label">出差补助（天）:</label>
                <div class="col-sm-3">
                    <input id="ccbz" name="ccbz" type="text" class="form-control" datatype="n"
                           value="${ayYgjbxxPage.ccbz}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">出差补助</label>
                </div>
            </div>
            
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">其他补贴:</label>
                <div class="col-sm-3">
                    <input id="qtbt" name="qtbt" type="text" class="form-control" datatype="n" value="${ayYgjbxxPage.qtbt}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">其他补贴</label>
                </div>
                <label class="col-sm-2 control-label">其他</label>
                <div class="col-sm-3">
                    <input id="qt" name="qt" type="text" class="form-control" datatype="n"
                           value="${ayYgjbxxPage.qt}">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">其他</label>
                </div>
            </div>
            
            <div class="hr-line-dashed"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label">备注:</label>
                <div class="col-sm-8">
                    <textarea id="bz" name="bz" type="text" class="form-control"
                              style="height: 100px">${ayYgjbxxPage.bz}</textarea>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">备注</label>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <hp:base type="hplusJs" plugins="jqueryMigrate,DatePicker"></hp:base>
        </div>
    </div>
</t:formvalid>
</body>
</html>
