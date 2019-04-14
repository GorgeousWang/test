<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	    var xmlHttpRequest = null;
	    function autoCalc()
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
	    			var num1 = document.getElementById("num1").value;
	    			var num2 = document.getElementById("num2").value;
	    			
	    			xmlHttpRequest.open("GET","calcServlet?num1="+num1+"&num2="+num2,true);//准备向服务器建立连接通过open方法
	    			xmlHttpRequest.onreadystatechange = ajaxCallFunction;//当服务器给客户端发送一个状态我就调用该方法一次
	    			xmlHttpRequest.send(null);
	    			
	    	}
	    }
	
	
		function ajaxCallFunction()
		{
				if(xmlHttpRequest.readyState==4)
				{
					if(xmlHttpRequest.status==200)
					{
						var resposeText = xmlHttpRequest.responseText;
						document.getElementById("total").value=resposeText;
					}
				}
		}
	</script>

  </head>
  
  <body>
  		相加(失去焦点自动刷新)<input type="text" name="num1" id="num1">+<input type="text" name ="num2"	 id="num2" onblur="autoCalc()">=<input id="total" type="text" name="sum">
  
  
  
  
  </body>
</html>
