<%@ page import="com.employee_servlet_jsp.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>

<head>
    <title>Add Employee</title>

    <link type="text/css" rel="stylesheet" href="style.css">
    <link type="text/css" rel="stylesheet" href="index.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>FooBar CEO</h2>
    </div>
</div>

<div id="container">
    <h3>Add INFO</h3>

    <form action="employee-servlet" method="GET">
        <table>
      
            <input type="hidden" name="command" value="<%=request.getParameter("command") %>" >
            <input type="hidden" name="employeeId" value="<%=request.getParameter("employeeId") %>" >

            <tbody>
            <tr>
                <td><label>Father's name:</label></td>
                <td><input type="text" name="fathersname" /></td>
            </tr>

            <tr>
                <td><label>National Code:</label></td>
                <td><input type="text" name="ncode" /></td>
            </tr>

            <tr>
                <td><label>Phone Number:</label></td>
                <td><input type="text" name="pnumber" /></td>
            </tr>

            <tr>
                <td><label>Address:</label></td>
                <td><input type="text" name="address" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="employee-servlet">Back to List</a>
    </p>
</div>
</body>

</html>











