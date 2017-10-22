<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	String photo_input_url = basePath + "/pages/photo/upload.action "; 
%>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=photo_input_url %>" method="post" enctype="multipart/form-data">
		请输入内容：<input type="text" id="msg" name="msg"/><br>
		请选择照片：<input type="file" id="photo" name="photo"/><br>
			 <input type="submit" value="提交">
			 <input type="reset" value="重置"><br>
	</form>
</body>
</html>