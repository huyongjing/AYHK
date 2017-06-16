<%--
  Created by IntelliJ IDEA.
  User: caozengling
  Date: 2017/3/9
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>企业当前数据申报工作</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <hp:base type="listformCss"/>
    <hp:base type="listformJs"/>
    <t:base type="tools,DatePicker"></t:base>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <!--  <div class="row">
         <div class="col-sm-12">
             <div class="ibox-content">
                 <div align="center"><h1>当前数据申报工作</h1></div>
             </div>
         </div>
     </div> -->
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-title">
                    <h4>当前课程中心数据填报</h4>
                </div>
                <div class="ibox-content">
                    <%--<table class="table table-bordered">
                        <c:forEach var="item" items="${datalist}"  varStatus="i">
                            <c:if test="${i.count==1 }">
                                <tr>
                                    <td style="width: 60%;">
                                        <a href="sjsCorporationCompanyInfoController.do?goAdd&companyId=${item.companyid}" title="点击提交企业基本信息表">
                                            <span  style="color:red">${item.name}</span></a>
                                    </td>
                                    <td>
                                            &lt;%&ndash; <c:if test="${frjbxxtj==null}">
                                            <span style="color:red">未提交</span>
                                            </c:if>
                                            <c:if test="${frjbxxtj!=null}">
                                            <span style="color:#1b37ff">已提交</span>
                                            </c:if> &ndash;%&gt;
                                    </td>

                                    <td>
                                        <c:if test="${item.tjsj!=null}">
                                            <span style="color:#1b37ff">更新时间：${item.tjsj}</span>
                                        </c:if>
                                    </td>

                                </tr>
                            </c:if>
                            <c:if test="${i.count>1 }">
                                <tr>
                                    <td style="width: 60%;">
                                        <a id="ybbqid" href="sjsCollectInfoController.do?goAdd&reportid=${item.reportid}" title="点击提交企业经营状况及需求信息采集表_月报 " ><span style="color:red">${item.name}</span></a>
                                    </td>
                                    <td>
                                        <c:if test="${item.tjzt=='0'}">
                                            <span style="color:red">未提交</span>
                                        </c:if>
                                        <c:if test="${item.tjzt=='1'}">
                                            <span style="color:#1b37ff">已提交</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${empty item.tjsj}">
                                            <span style="color:red"></span>
                                        </c:if>
                                        <c:if test="${not empty item.tjsj}">
                                            <span style="color:#1b37ff">提交时间：${item.tjsj}</span>
                                        </c:if>
                                    </td>


                                </tr>
                            </c:if>

                        </c:forEach>
                        &lt;%&ndash; </c:if> &ndash;%&gt;
                        <c:if test="${fn:length(datalist)  <= 0 }">
                            <tr>
                                <td><span style="color: red;font: 16px;">暂无可提交数据</span></td>
                            </tr>
                        </c:if>

                    </table>--%>
                    <table class="table table-bordered">
                        <c:forEach var="item" items="${datalist}" varStatus="i">
                            <tr>
                                <td style="width: 60%;">
                                    <a href="" title="点击提交企业基本信息表">
                                        <span style="color:red">2016年3月</span></a>
                                </td>
                                <td>
                                        ${item.zx}
                                </td>
                                <td>
                                    <a title="点击提交课程信息" onclick="tjkc();">
                                        <span style="color:red">点击提交</span></a>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 60%;">
                                    <a id="ybbqid" href="" title="点击提交企业经营状况及需求信息采集表_月报 "><span
                                            style="color:red"></span></a>
                                </td>
                                <td>
                                    <c:if test="">
                                        <span style="color:red">未提交</span>
                                    </c:if>
                                    <c:if test="">
                                        <span style="color:#1b37ff">已提交</span>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="">
                                        <span style="color:red"></span>
                                    </c:if>
                                    <c:if test="">
                                        <span style="color:#1b37ff">提交时间：</span>
                                    </c:if>
                                </td>
                            </tr>
                            <%-- </c:if> --%>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <span style="color:red;font-size:18px;"><b>注&nbsp;&nbsp;意：</b></span><br>
    <span style="color:black;font-size:16px;">“课程信息维护表”每个中心对应中心员工,并填报数据。</span><br>
    <span></span><br>
    <span style="color: black;font-size:16px;margin-left: 20px;">${sjsCjxxtzPage}</span>
</div>
<script language="JavaScript">

    var json = '${allCenters}';
    var jsonObject = JSON.parse(json);
    alert(jsonObject[1]);
    $("#kcmc").html(jsonObject[1]);
    //转换函数
        function tjkc() {
            createwindow("员工基本信息","ayKcxxController.do?list","800","600");
        }

    //获取当前时间
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        return currentdate;
    }

</script>
</body>
</html>
