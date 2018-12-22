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
        <div class="page-body">
            <jsp:include page="pageleft.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form action="updatemeetingroom.action" method="post">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <c:forEach items="#{list }"  var="list">
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                	<input type="hidden" name="mt.roomid" value="${list.roomid}" >
                                    <input id="roomnumber" type="text"  maxlength="10" value="${list.roomnum }" name="mt.roomnum"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="capacity" type="text"  maxlength="20" name="mt.roomname" value="${list.roomname }"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" type="text" name="mt.capacity" value="${list.capacity }"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td name="mt.status">
                                    <c:choose >
                                    	<c:when test="${list.status==0 }">启用</c:when>
                                    	<c:when test="${list.status==1 }">停用</c:when>
                                    </c:choose>
                                    <input type="radio" id="status" name="mt.status" checked="checked" value="1"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="mt.status"/><label for="status" value="1">停用</label>
                                   
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" name="mt.description" maxlength="200" rows="5" cols="60" >${list.description }</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
                                    <input type="reset" value="重置" class="clickbutton"/>
                                </td>
                            </tr>
                                </td>
                            </tr>
                        </table>
                        </c:forEach>
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