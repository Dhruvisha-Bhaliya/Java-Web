<%-- 
    Document   : SamplePractise
    Created on : Oct 2, 2025, 3:38:55 PM
    Author     : DELL
--%>

<%@page contentType="text/html" import="java.io.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            int x = 5;
            int y = 10;
            String fname;
            String lname;
            String fullname;
        %>

        <!--        Java Logic-->
        <%
            int sum = x + y;
            out.println("The sum is " + sum);
            fname = request.getParameter("fname");
            lname = request.getParameter("lname");
            fullname = fname + "" + lname;
        %>

        <h2>Full Name: <%=fullname%>

        <%@include file="included.jsp" %>
        <h1>
            Current date is <%= new java.util.Date()%>
        </h1>
    </body>
</html>
<!--http://localhost:8080/JSP4App/SamplePractise.jsp?fname=John&lname=Doe-->