<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Group</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
	<div align="center">
		<h1>Edit Group</h1>		
		<form:form action="/orbeonrpt/jsp/group/update" method="post" modelAttribute="group">
			<table class="update_element">
				<form:hidden path="id" />
				<form:hidden path="groupName" />
				<tr>
					<td>Group Name</td><td>${group.groupName}</td>
				</tr>
				<tr>
					<td>Description</td><td><form:input path="groupDescription"/></td>
				</tr>
				<tr>
					<td>ID</td><td>${group.id}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Update" class="update_button"></td>
				</tr>
			</table>
		</form:form>
		
		<h2>Existing Roles</h2>
		<table border="1">
			<th>Role Name</th>
			<th>Role Description</th>
			<th>GUID</th>
			<c:forEach var="existingRole" items="${existingRoles}">
				<tr>
					<td>${existingRole.roleName}</td>
					<td><c:out value="${existingRole.roleDescription}" /></td>
					<td><c:out value="${existingRole.id}" /></td>
					<td class="button_styled"><a href="/orbeonrpt/jsp/group/removeRoleFromGroup/${group.id}/${existingRole.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<h2>Addable Roles</h2>

		<table border="1">
			<th>Role Name</th>
			<th>Role Description</th>
			<th>GUID</th>
			<c:forEach var="addableRole" items="${addableRoles}">
				<tr>
					<td>${addableRole.roleName}</td>
					<td>${addableRole.roleDescription}</td>
					<td>${addableRole.id}</td>
					<td class="button_styled"><a href="/orbeonrpt/jsp/group/addRoleToGroup/${group.id}/${addableRole.id}">Add</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>


