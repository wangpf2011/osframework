<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查询商品列表</title>
		<script type="text/javascript">
			function editProductsAllSubmit(){
				//提交form
				document.itemsForm.action="${pageContext.request.contextPath }/products/editProductsAllSubmit";
				document.itemsForm.submit();
			}
			function queryProducts(){
				//提交form
				document.itemsForm.action="${pageContext.request.contextPath }/products/queryProducts";
				document.itemsForm.submit();
			}
		</script>
	</head>
	<body> 
		<form name="itemsForm" action="${pageContext.request.contextPath }/products/queryProducts" method="post">
			查询条件：
			<table width="100%" border=1>
				<tr>
					<td>
						商品名称：<input name="productsCustom.name" />
					</td>
					<td>
						<input type="button" value="查询" onclick="queryProducts()"/>
						<input type="button" value="批量修改提交" onclick="editProductsAllSubmit()"/>
					</td>
				</tr>
			</table>
			商品列表：
			<table width="100%" border=1>
				<tr>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>生产日期</td>
					<td>商品描述</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${productsList}" var="product" varStatus="status">
					<tr>	
						<td><input name="productsList[${status.index }].name" value="${product.name }"/></td>
						<td><input name="productsList[${status.index }].price" value="${product.price }"/></td>
						<td><input name="productsList[${status.index }].createtime" value="<fmt:formatDate value="${product.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
						<td><input name="productsList[${status.index }].detail" value="${product.detail }"/></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>