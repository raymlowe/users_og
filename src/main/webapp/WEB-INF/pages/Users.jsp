<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Screen</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
	<div align="center">
		<h1>User List</h1>
		
		<table border="1">
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Telephone</th>
			<th>Type</th>
			<th>Active Status</th>
			<th>GUID</th>

			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><a href="/orbeonrpt/jsp/user/modifyUserGroup?userId=${user.userId}">${user.userId}</a></td>
					<td>${user.firstName} &nbsp;${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.userType}</td>
					<td>${user.isActive}</td>
					<td>${user.id}</td>
					<td><a href="../user/delete?id=${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			Create New User <a href="/orbeonrpt/jsp/user/create">here</a>
		</h4>
	</div>
</body>
</html>