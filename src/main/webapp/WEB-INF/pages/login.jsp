<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
       <div class="login-form">
        <form method='post' name='loginForm' action="/j_spring_security_check">

                    <table>
                        <tr>
                            <td>User:</td>
                            <td><input type='text' name='username' value=''></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' name='password'/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="float: right;">
                                <label for="remember">Remember me</label>
                                <input type="checkbox" id="remember" name="remember-me" /></td>
                        </tr>
                        <tr>
                            <td colspan='2'><button name="submit" type="submit"
                                                    value="submit">Login</button></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="float: right"><a href="/registration">Sign up</a></td>
                        </tr>
                    </table>

                </form>
            </div>
    </body>
</html>
