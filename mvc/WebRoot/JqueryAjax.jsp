<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JqueryAjax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js">
	
	$(function(){
	alert(1);
		/* 	$("#num2").blur(function(){
						$.ajax({
							type:"POST",
							url:"calcServlet",
							dataType:"html",
							data:{"num1":$("#num1").val(),"num2":$("#num2").val()},
							success:function(returnData)
							{
								$("#total").val(returnData);
							}
				});
			}); */
			$("#num2").blur(function(){
			$.get("calcServlet",{"num1":$("#num1").val(),"num2":$("#num2").val()},function(returnData){
			$("#total").val(returnData);
			});
			});
	});
	</script>
	
  </head>
  
  <body>
  	相加(失去焦点自动刷新)<input type="text" name="num1" id="num1">+<input type="text" name ="num2"	 id="num2" >=<input id="total" type="text" name="sum">
  
  
  
  </body>
</html>
