<%-- 
    Document   : displayPage
    Created on : May 17, 2018, 11:48:39 AM
    Author     : Hemanth
--%>

<%@page import="java.util.List"%>
<%@page import="com.dss.bean.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% List<Employee> emplist=(List<Employee>)request.getAttribute("list");%>
        <table border="1">
            <thead>
                <tr>
                    <th>name</th>
                    <th>address</th>
                    <th>salary</th>
                </tr>
                
            </thead>
            <tbody>
                <%for (Employee emp : emplist) {           
               %>
               <tr>
                   <td><%=emp.getEmp_name()%></td>
                   <td><%=emp.getEmp_address()%></td>
                   <td><%=emp.getEmp_salary()%></td>
                   <td><a href="EmployeeServlet?action=delete&id=<%=emp.getEmp_id()%>"><button>delete</button></a></td>
                   <td><a href="EmployeeServlet?action=editData&id=<%=emp.getEmp_id()%>"><button>Edit</button></a></td>
    
               </tr>
                <%}%>
            </tbody>
            
        </table>
    </body>
</html>
