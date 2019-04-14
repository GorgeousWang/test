<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  		<script type="text/javascript">
        var xmlHttpRequest = null;
  		function isExistsUsername()
  		
  		{
  		//ActiveXObject IE
	    	if(window.ActiveXObject)
	    	{
	    			//这是一个IE浏览器
	    			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	    	}
	    	else if(window.XMLHttpRequest)  //IE浏览器之外的浏览器
	    	{
	    			xmlHttpRequest = new XMLHttpRequest();
	    			
	    	}
	    	if(xmlHttpRequest!=null)
	    	{
	    			var username = document.getElementById("username").value;
	    			
	    			xmlHttpRequest.open("GET","registerServlet?username="+username,true);//准备向服务器建立连接通过open方法
	    			xmlHttpRequest.onreadystatechange = ajaxCallFunction;//当服务器给客户端发送一个状态我就调用该方法一次
	    			xmlHttpRequest.send(null);
	    			
	    			//如果用post提交呢
	    			//xmlHttpRequest.open("GET","registerServlet",true);//准备向服务器建立连接通过open方法
	    			//xmlHttpRequest.onreadystatechange = ajaxCallFunction;//当服务器给客户端发送一个状态我就调用该方法一次
	    			//xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//post请求必须设置header
	    			//xmlHttpRequest.send("username=",username);
	    			
	    			
	    	}
  		}
  				function ajaxCallFunction()
		{
				if(xmlHttpRequest.readyState==4)
				{
					if(xmlHttpRequest.status==200)
					{
						var resposeText = xmlHttpRequest.responseText;
						if(resposeText=="true")
						{
								document.getElementById("div1").innerHTML="<p style='color:red'>此用户已存在</p>";
								document.getElementById("register").disabled = true;
						}
						else
						{
							document.getElementById("div1").innerHTML="";
							document.getElementById("register").disabled=false;
						}
					}
				}
		}
  		</script>
  <body>
  注册信息：
  <form action="registerServlet" enctype="application/x-www-form-urlencoded">
    	用户名:<input id="username" type="text" name="username"  onblur="isExistsUsername()"><br>
    	<div id="div1"></div>
    	密   码:<input type="text" name="password"><br>
    	地   址:<input type="text" name="address"><br>
    	<input id="register" type="submit" value="注册">
  </form>
  
  
  
  
  
  
  
  
  </body>
</html>
