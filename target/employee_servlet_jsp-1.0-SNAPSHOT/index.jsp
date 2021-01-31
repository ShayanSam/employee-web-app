<!DOCTYPE html>
<html>

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
    <h3>Add Employee</h3>

    <form action="employee-servlet" method="GET">

        <input type="hidden" name="command" value="ADD" />

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><input type="text" name="firstName" /></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><input type="text" name="lastName" /></td>
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











