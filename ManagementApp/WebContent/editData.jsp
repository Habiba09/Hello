<%-- 
    Document   : editData
    Created on : May 21, 2018, 11:47:09 AM
    Author     : Hemanth
--%>

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
        <%Employee emp=(Employee)request.getAttribute("empdata");%>
        <form action="EmployeeServlet?action=update&id=<%=emp.getEmp_id()%>">
        <table>
            <tbody>
                <tr>
                    
                    <td>enter new name</td>
                    <td><input type="text" name="name1" value="<%=emp.getEmp_name()%>"></td> 
                </tr>
                <tr>
                    
                    <td>enter new address</td>
                    <td><input type="text" name="address" value="<%=emp.getEmp_address()%>"></td> 
                </tr>
                <tr>
                    
                    <td>enter new salary</td>
                    <td><input type="text" name="sal" value="<%=emp.getEmp_salary()%>"></td> 
                </tr>
                
                <tr>
                    
                  
                    <td><input type="submit" value="update"></td> 
                </tr>
            </tbody>
            
            
        </table>
        </form>
    </body>
</html>
