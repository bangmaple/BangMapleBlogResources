<%-- 
    Document   : changePassword
    Created on : Jul 21, 2020, 2:08:37 AM
    Author     : bangmaple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER_NAME}!</h1><br/>
        <h2>Change your password!</h2><br/>
        Please input your new password!<br/>
        <form action="ChangePasswordController" method="POST">
            Current username: <input type="text" name="txtUsername" value="${sessionScope.USER_NAME}" readonly="true"/><br/>
            New password: <input type="password" name="txtPasswordChange"/><br/>
            <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}"/>
            <input type="submit" name="btnAction" value="Change password now!"/>
        </form>
    </body>
</html>
