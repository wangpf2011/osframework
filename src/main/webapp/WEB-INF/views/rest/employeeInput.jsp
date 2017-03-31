<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加人员信息</title>
	</head>
	<body> 	
		<form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">
			<table width="100%" border=1>
				<c:if test="${employee.id == null }">
					<tr>
						<td>LastName</td>
						<!--path属性对应html表单标签的name属性值-->
						<td><form:input path="lastName"/></td>
					</tr>
				</c:if>
				<c:if test="${employee.id == null }">
					<form:hidden path="id"/>
					<input type="hidden" name="_method" value="PUT"/>
				</c:if>
				<tr>
					<td>Email</td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<%
						Map<String, String> genders = new HashMap<String, String>();
						genders.put("1", "Male");
						genders.put("0", "Female");
						request.setAttribute("genders", genders);
					%>
					<td><form:radiobuttons path="gender" items="${genders }"/></td>
				</tr>
				<tr>
					<td>Department</td>
					<td>
						<form:select path="departId.id" items="${departments }" itemLabel="depatName" itemValue="id"></form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交"/></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>