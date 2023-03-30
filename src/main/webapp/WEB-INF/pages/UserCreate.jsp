<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/menu.jsp" />
    <div align="center">
        <h1>New/Edit User</h1>
        <form:form action="/orbeonrpt/jsp/user/saveNewUser" method="post" modelAttribute="user">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>userId:</td>
                <td><form:input path="userId" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td>User Type:</td>
                <td><form:input path="userType" /></td>
            </tr>
            <tr>
                <td>Is Active: (Y or N)</td>
                <td><form:input path="isActive" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>