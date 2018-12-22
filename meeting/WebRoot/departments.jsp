<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <jsp:include page="pagetop.jsp"></jsp:include>
        <jsp:include page="pageleft.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form action="adddeptname.action" method="post">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" maxlength="20" name="adddepartmentname"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${lookdept}" var="dept">
                    <tr>
                        <td>${dept.departmentid } </td>
                        <td>${dept.departmentname }</td>
                        <td>
                            <!--<a class="clickbutton" href="#">编辑</a>-->
                            <a class="clickbutton" href="deletedept.action?deptid=${dept.departmentid }">删除</a>
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