<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>header</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div class="header">
            <div class="category_link">
                <p><a href="/home">HOME</a></p>
            </div>
            <div class="category_link">
                <p><a href="/cars">CARS</a></p>
            </div>
            <div class="category_link">
                <p><a href="/inventory">INVENTORY</a></p>
            </div>
            <div style="float:right">
                <form  action="/logout" method="post">
                    <button type="submit">Logout</button>
                </form>
                <c:if test="${userNameStatus}">
                    <div style="float:right;"><h5>${userName}</h5></div>
                </c:if>
            </div>
        </div>
    <body>
</html>