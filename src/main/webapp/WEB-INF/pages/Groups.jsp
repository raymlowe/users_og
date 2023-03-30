<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group Screen</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
	<div align="center">
		<h1>Group List</h1>
		
		<table border="1">
			<th>Group Name</th>
			<th>Group Description</th>
			<th>GUID</th>

			<c:forEach var="group" items="${listGroup}">
				<tr>
					<td><a href="/orbeonrpt/jsp/group/modifyGroupRole?id=${group.id}">${group.groupName}</a></td>
					<td>${group.groupDescription}</td>
					<td>${group.id}</td>
					<td><a href="/orbeonrpt/jsp/group/delete?id=${group.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			Create New Group <a href="/orbeonrpt/jsp/group/create">here</a>
		</h4>
	</div>
</body>
</html>