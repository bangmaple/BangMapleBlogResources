<%-- 
    Document   : error
    Created on : Jul 21, 2020, 1:47:44 AM
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
        <h1>ERROR!</h1>
        ${requestScope.ERROR}<br/>
        <a href="index.html">Click here to go back to login page!</a>
    </body>
</html>
