<%@ page import="com.employee_servlet_jsp.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Employee Tracker App</title>

    <link type="text/css" rel="stylesheet" href="style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>FooBar CEO</h2>
    </div>
</div>

<div id="container">

    <div id="content">


        <input type="button" value="Add Employee"
               onclick="window.location.href='add-employee-form.jsp'; return false;"
               class="add-student-button"
        />

        <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <td>Update</td>
                <td>Delete</td>
            </tr>

            <c:forEach var="tempEmployee" items="${EL}">


                <c:url var="tempLink" value="employeeinf.jsp">
                    <c:param name="command" value="LOAD" />
                    <c:param name="employeeId" value="${tempEmployee.id}" />
                </c:url>

                <c:url var="deleteLink" value="employee-servlet">
                    <c:param name="command" value="DELETE" />
                    <c:param name="employeeId" value="${tempEmployee.id}" />
                </c:url>

                <tr>
                    <td> ${tempEmployee.firstName} </td>
                    <td> ${tempEmployee.lastName} </td>
                    <td><a href="${tempLink}">Update</a> </td>
                     <td> <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
        <c:url var="tempLink" value="employee-servlet">
            <c:param name="command" value="INF" />
        </c:url>
        <a href="${tempLink}">INFO</a>

    </div>

</div>
</body>


</html>








