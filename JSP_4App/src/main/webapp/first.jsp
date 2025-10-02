<%-- 
    Document   : first
    Created on : Oct 2, 2025, 6:53:50 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! First</h1>
        <jsp:forward page="second.jsp">
            <jsp:param name="user" value="Dhruvi"/>
        </jsp:forward>
    </body>
</html>
