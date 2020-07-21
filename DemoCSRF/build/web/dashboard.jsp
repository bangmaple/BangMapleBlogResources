<%-- 
    Document   : dashboard
    Created on : Jul 21, 2020, 1:32:20 AM
    Author     : bangmaple
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dateNow" class="java.util.Date" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE eq null}">
            <c:redirect url="index.html"/>
        </c:if>
        <h1>Hello ${sessionScope.ROLE} / ${sessionScope.USER_NAME}!</h1>
        Today: ${pageScope.dateNow}<br/>
        <a href="ChangePasswordController"> Change my password now!</a>
    </body>
</html>
