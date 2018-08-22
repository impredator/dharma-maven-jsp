<%@page contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<body>
<h1>${hello}</h1>

<form name="bmiForm" action="bmi" method="POST">
    <table>
        <tr>
            <td>Your Weight (kg) :</td>
            <td><input type="text" name="weight"/></td>
        </tr>
        <tr>
            <td>Your Height (m) :</td>
            <td><input type="text" name="height"/></td>
        </tr>
        <th><input type="submit" value="Submit" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset"/></th>
    </table>
    <h2>${bmiResult}</h2>
</form>

</body>
</html>
