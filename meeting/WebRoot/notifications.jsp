<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
       <jsp:include page="pagetop.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="pageleft.jsp"/>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 最新通知        
                </div>
                <div style="float: right:150px;color: red;">你是第${visitcount }位访客</div>
                <table class="listtable">
                    <caption>
                        未来30天我要参加的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th style="width:100px">操作</th>
                    </tr>
                    <c:forEach items="${list01}" var = "list">
                    <tr>
                        <td>${list.meetingname }</td>
                        <td>${list.roomname }</td>
                        <td>${list.starttime }</td>
                        <td>${list.endtime }</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.action?meetingid=${list.meetingid }">查看详情</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <table class="listtable">
                    <caption>
                        已取消的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th>取消原因</th>
                        <th style="width:100px">操作</th>
                    </tr>
                    <c:forEach items="${list02 }" var="list">
                    <tr>
                        <td>${list.meetingname }</td>
                        <td>${list.roomname }</td>
                        <td>${list.starttime }</td>
                        <td>${list.endtime }</td>
                        <td>${list.canceledreason }</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.action?meetingid=${list.meetingid }">查看详情</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系QQ2278892914
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>