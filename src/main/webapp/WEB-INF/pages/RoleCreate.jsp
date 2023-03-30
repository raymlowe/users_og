<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Role</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
    <div align="center">
        <h1>New/Edit Role</h1>
        <form:form action="/orbeonrpt/jsp/role/saveNewRole" method="post" modelAttribute="role">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Role Name:</td>
                <td><form:input path="roleName" /></td>
            </tr>
            <tr>
                <td>Role Description</td>
                <td><form:input path="roleDescription" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>