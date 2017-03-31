<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>人员列表</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".delete").click(function() {
					var href = $(this).attr("href");
					$("form").attr("action", href).submit();
					return false;
				});
			})
		</script>
	</head>
	<body> 
		<form action="" method="POST">
			<input type="hidden" name="_method" value="DELETE">
		</form>
		用户列表：
		<table width="100%" border=1>
			<tr>
				<td>ID</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Gender</td>
				<td>Department</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:if test="${empty employees}">
				<tr>
					<td colspan="7">没有任务员工信息</td>
				</tr>
			</c:if>
			<c:if test="${empty employees}">
				<c:forEach items="${employees}" var="emp">
					<tr>	
						<td>${emp.id }</td>
						<td>${emp.lastName }</td>
						<td>${emp.email }</td>
						<td>${emp.gender == 0? 'Female':'Male' }</td>
						<td>${emp.departId.depatName }</td>
						<td><a href="${pageContext.request.contextPath }/emp/${emp.id}">Edit</a></td>
						<td><a class="delete" href="${pageContext.request.contextPath }/emp/${emp.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a href="${pageContext.request.contextPath }/emp">Add New Employee</a>
	</body>
</html>