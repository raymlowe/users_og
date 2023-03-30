<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role Screen</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
	<div align="center">
		<h1>Role List</h1>
		
		<table border="1">
			<th>Role Name</th>
			<th>Role Description</th>
			<th>GUID</th>

			<c:forEach var="role" items="${listRole}">
				<tr>
					<td>${role.roleName}</td>
					<td>${role.roleDescription}</td>
					<td>${role.id}</td>
					<td><a href="/orbeonrpt/jsp/role/delete?id=${role.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			Create New Role <a href="/orbeonrpt/jsp/role/create">here</a>
		</h4>
	</div>
</body>
</html>