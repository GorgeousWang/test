<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showusers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		显示所有用户信息 <a href="add.jsp">添加</a>
  		<table border="1" width="80%" align="center">
  				<tr><th>编号</th><th>用户名</th><th>密码</th><th>删除</th></tr>
  				<c:forEach items="${requestScope.users }" var="user" varStatus="status">
  					<tr><th>${status.index+1 } </th><th>${user.username }</th><th>${user.password }</th><th><a href="showUsersServlet?method=delete&id=${user.id }" onclick="confirm('确认删除?')">删除</a></th><th><a href="showUsersServlet?method=update&id=${user.id }" >修改</a></th></tr>
  				</c:forEach>
  		
  		
  		</table>
  
  
  
  
  </body>
</html>
