<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
	<jsp:include page="fragments/menu.jsp" />
	<div align="center">
		<h1>Edit User</h1>
		<form:form action="/orbeonrpt/jsp/user/updateUser" method="post"
			modelAttribute="user">
			<table class="update_element">
				<form:hidden path="id" />
				<form:hidden path="userId" />
				<tr>
					<td>UserID</td>
					<td>${user.userId}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>User Type</td>
					<td><form:input path="userType" /></td>
				</tr>
				<tr>
					<td>Is Active</td>
					<td><form:input path="isActive" /></td>
				</tr>
				<tr>
					<td>GUID</td>
					<td>${user.id}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update" class="update_button"></td>
				</tr>
			</table>
		</form:form>

		<h2>Existing Groups</h2>
		<table border="1">
			<th>Group Name</th>
			<th>Group Description</th>
			<th>GUID</th>
			<c:forEach var="userGroup" items="${userGroups}">
				<tr>
					<td>${userGroup.groupName}</td>
					<td><c:out value="${userGroup.groupDescription}" /></td>
					<td><c:out value="${userGroup.id}" /></td>
					<td><a
						href="/orbeonrpt/jsp/user/removeUserFromGroup/${user.id}/${userGroup.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>

		<h2>Addable Groups</h2>

		<table border="1">
			<th>Group Name</th>
			<th>Group Description</th>
			<th>GUID</th>
			<c:forEach var="availableGroup" items="${groupsAvailable}">
				<tr>
					<td>${availableGroup.groupName}</td>
					<td>${availableGroup.groupDescription}</td>
					<td>${availableGroup.id}</td>
					<td><a
						href="/orbeonrpt/jsp/user/addUserToGroup/${user.id}/${availableGroup.id}">Add</a></td>
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>