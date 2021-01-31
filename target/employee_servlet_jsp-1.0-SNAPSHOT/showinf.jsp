<%@ page import="com.employee_servlet_jsp.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>EmployeeINF list</title>

    <link type="text/css" rel="stylesheet" href="style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Employee Information</h2>
    </div>
</div>

<div id="container">

    <div id="content">
        <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Father's Name</th>
                <th>National Code</th>
                <th>Phone Number</th>
                <th>Address</th>
            </tr>

            <c:forEach var="inf" items="${ELINF}">

                <tr>
                    <td> ${inf.firstName} </td>
                    <td> ${inf.lastName} </td>
                    <td> ${inf.employeeINF.fathersName} </td>
                    <td> ${inf.employeeINF.nationalCode} </td>
                    <td> ${inf.employeeINF.phoneNumber} </td>
                    <td> ${inf.employeeINF.address}</td>
                </tr>
            </c:forEach>

        </table>
        <c:url var="tempLink" value="employee-servlet">
            <c:param name="command" value="LIST" />
        </c:url>
                    <a href="${tempLink}">back</a>
    </div>

</div>
</body>
</html>








