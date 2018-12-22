<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="regslist" var = "list">
                   
                    <tr>
                        <td><s:property value="#list.employeename"/></td>
                        <td><s:property value="#list.username"/></td>
                        <td><s:property value="#list.phone"/></td>
                        <td><s:property value="#list.email"/></td>
                        <td>
                            <a class="clickbutton" href="approvestaff.action?username=<s:property value='#list.username'/>">通过</a>
                            <a class="clickbutton" href="refusestaff.action?username=<s:property value='#list.username'/>">不通过</a>
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