<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
       <div class="login-form">
        <form method='post' name='RegistrationForm' action="/registration/user">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='name' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password'/></td>
                </tr>
                <tr><input id="submit" name="submit" type="submit"/></tr>
            </table>
        </form>
        </div>
    </body>
</html>
