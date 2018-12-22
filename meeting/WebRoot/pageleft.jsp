<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-sidebar">
<div class="sidebar-menugroup">
               <div class="sidebar-grouptitle">个人中心</div>
               <ul class="sidebar-menu">
                   <li class="sidebar-menuitem"><a href="notifications.action">最新通知</a></li>
                   <li class="sidebar-menuitem active"><a href="mybookings.action">我的预定</a></li>
                   <li class="sidebar-menuitem"><a href="mymeetings.action">我的会议</a></li>
               </ul>
           </div>
           <c:if test="${role==1 }">
           <div class="sidebar-menugroup">
               <div class="sidebar-grouptitle">人员管理</div>
               <ul class="sidebar-menu">
                   <li class="sidebar-menuitem"><a href="departments.action">部门管理</a></li>
                   <li class="sidebar-menuitem"><a href="department.action">员工注册</a></li>
                   <li class="sidebar-menuitem"><a href="approveaccount.action">注册审批</a></li>
                   <li class="sidebar-menuitem"><a href="searchemployees.action">搜索员工</a></li>
               </ul>
           </div>
           </c:if>
           <div class="sidebar-menugroup">
               <div class="sidebar-grouptitle">会议预定</div>
               <ul class="sidebar-menu">
               	<c:if test="${role==1 }">
                   <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
                   </c:if>
                   <li class="sidebar-menuitem"><a href="meetingrooms.action">查看会议室</a></li>
                   <li class="sidebar-menuitem"><a href="bookmeeting.action">预定会议</a></li>
                <c:if test="${role==1 }">   
                   <li class="sidebar-menuitem"><a href="searchmeetings.action">搜索会议</a></li>
               </c:if>
               </ul>
           </div>
       </div>
		               