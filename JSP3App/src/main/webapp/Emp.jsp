<%-- 
    Document   : Emp
    Created on : Oct 2, 2025, 3:31:28 PM
    Author     : DELL
--%>
<jsp:useBean id="emp" class="jsp.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/>
</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (emp.validate()) {
        %><h2>
            Empno = <%=emp.getEmpno()%> <br/>
            Ename = <%=emp.getEname()%><br/>
            Salary = <%=emp.getSalary()%><br/>
        </h2>
        <%
        } else {
            {%>
        <jsp:forward page="EmpForm.jsp"/>
        <%
                         }%>
    </body>
</html>
