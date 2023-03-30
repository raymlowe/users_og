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
<jsp:include page="fragments/menu.jsp" />
<body>
    <div align="center">
        <h1>New Group</h1>
        <form:form action="/orbeonrpt/jsp/group/saveNewGroup" method="post" modelAttribute="group">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Group Name:</td>
                <td><form:input path="groupName" /></td>
            </tr>
            <tr>
                <td>Group Description:</td>
                <td><form:input path="groupDescription" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>