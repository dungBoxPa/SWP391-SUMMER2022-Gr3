<%-- 
    Document   : homepage
    Created on : May 31, 2022, 10:37:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Hello ${sessionScope.role} ${sessionScope.email}
    </body>
</html>
