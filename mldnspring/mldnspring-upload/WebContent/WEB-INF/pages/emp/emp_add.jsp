<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	String emp_add = basePath + "pages/emp/emp_add.action"; 
%>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>请输入员工信息：</h2><hr>
	<form action="<%=emp_add %>" >
		 <table>
		 	<tr>
		 		<td>员工编号：</td>
		 		<td><input type="text" name="empno" id="empno" value="7369"/></td>
		 	</tr>
		 	<tr>
		 		<td>员工姓名：</td>
		 		<td><input type="text" name="ename" id="ename" value="SMITH"/></td>
		 	</tr>
		 	<tr>
		 		<td>员工工资：</td>
		 		<td><input type="text" name="salary" id="salary" value="11.11"/></td>
		 	</tr>
		 	<tr>
		 		<td>雇佣日期：</td>
		 		<td><input type="text" name="hiredate" id="hiredate" value="1989-9-9"/></td>
		 	</tr>
		 	<tr>
		 		<td>员工等级：</td>
		 		<td><input type="text" name="level" id="level" value="1"/></td>
		 	</tr>
		 	<tr>
		 		<td>部门编号：</td>
		 		<td><input type="text" name="dept.deptno" id="dept.deptno" value="10"/></td>
		 	</tr>
		 	<tr>
		 		<td>部门名称：</td>
		 		<td><input type="text" name="dept.dname" id="dept.dname" value="财务部"/></td>
		 	</tr>
		 	<tr>
		 		<td>部门成立时间：</td>
		 		<td><input type="text" name="dept.createdate" id="dept.createdate" value="1999-9-9"/></td>
		 	</tr>
		 	
		 	<tr>
		 		<td><input type="submit" value="提交"/></td>
		 		<td><input type="reset" value="重置"/></td>
		 	</tr>
		 </table>
	</form>
</body>
</html>