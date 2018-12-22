<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
           <strong></strong>
                
            </div>
        </div>
        <div class="page-body">
          
            <div class="page-content">
                <div class="content-nav">
                    登录
                </div>
                <form action="login.action" method="post">
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                        	<c:if test="${remind!=null }">
                        	<tr>
                        	<td colspan="2">${remind}</td>
                        	</tr>
                        	</c:if>
                        
                        
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input id="accountname" name="login.accountname" type="text" value="wangxh"/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="new" type="password" name="login.password" value="123456"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="登录" class="clickbutton" />
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系QQ2278892914
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>