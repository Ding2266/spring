<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	String message_show = basePath + "/pages/message/echo.action "; 
%>
<base href="<%=basePath%>"/>
<script type="text/javascript" src="js/pages/message/message_input.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=message_show %>" >
		<span class="alert-danger">请输入内容：</span><input type="text" id="msg" name="msg"/><br>
		<span class="alert-danger">请选择:</span><input type="checkbox" id="tags" name="tags" value="政治">政治
			 <input type="checkbox" id="tags" name="tags" value="经济">经济
			 <input type="checkbox" id="tags" name="tags" value="文化">文化<br>
			 <input type="submit" value="提交">
			 <input type="reset" value="重置"><br>
		<img src="images/hello.png">	 
	</form>
</body>
</html>