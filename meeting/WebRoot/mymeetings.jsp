<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <jsp:include page="pagetop.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="pageleft.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list01}"  var = "list">
                    <tr>
                        <td>${list.meetingname }</td>
                        <td>${list.roomname }</td>
                        <td>${list.starttime }</td>
                        <td>${list.endtime }</td>
                        <td>${list.reservationtime }</td>
                        <td>王晓华</td>
                        <td>
                            <a class="clickbutton" href="mymeetingdetails.action?meetingid=${list.meetingid }">查看详情</a>
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