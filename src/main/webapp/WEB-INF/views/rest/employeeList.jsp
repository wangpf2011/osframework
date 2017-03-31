<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>人员列表</title>
		<script type="text/javascript">
			function deleteProducts(){
				//提交form
				document.itemsForm.action="${pageContext.request.contextPath }/products/deleteProducts.action";
				document.itemsForm.submit();
			}
			function queryProducts(){
				//提交form
				document.itemsForm.action="${pageContext.request.contextPath }/products/queryProducts.action";
				document.itemsForm.submit();
			}
		</script>
	</head>
	<body> 
		当前用户：${username }，
		<c:if test="${username!=null }">
			<a href="${pageContext.request.contextPath }/logout.action">退出</a>
		</c:if>
		<form name="itemsForm" action="${pageContext.request.contextPath }/products/queryProducts.action" method="post">
			查询条件：
			<table width="100%" border=1>
				<tr>
					<td>
						商品名称：<input name="productsCustom.name" />
						商品类型：
						<select name="producttype">
							<c:forEach items="${productstypes }" var="productstype">
								<option value="${productstype.key }">${productstype.value }</option>		
							</c:forEach>
						</select>
					</td>
					<td>
						<input type="button" value="查询" onclick="queryProducts()"/>
						<input type="button" value="批量删除" onclick="deleteProducts()"/>
					</td>
				</tr>
			</table>
			商品列表：
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
							<td><a href="${pageContext.request.contextPath }/emps/editProducts.action?id=${emp.id}">Edit</a></td>
							<td><a href="${pageContext.request.contextPath }/emps/editProducts.action?id=${emp.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</form>
	</body>
</html>