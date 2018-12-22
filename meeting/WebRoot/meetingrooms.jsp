<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <jsp:include page="pagetop.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="pageleft.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                  	<s:iterator value="list" var="list">
                    <tr>
                        <td><s:property value="#list.roomnum"/></td>
                        <td><s:property value="#list.roomname"/></td>
                        <td><s:property value="#list.capacity"/></td>
                        <td>
                        <s:if test="#list.status==0">启用</s:if>
                        <s:if test="#list.status==1">停用</s:if>
                        
                        </td>
                        <td>
                            <a class="clickbutton" href="roomdetails.action?roomnum=<s:property value="#list.roomnum"/>">查看详情</a>
                        </td>
                    </tr>
                    </s:iterator>
                     
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