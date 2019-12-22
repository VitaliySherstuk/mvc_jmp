<%@ page contentType="text/html;charset=UTF-8" %>
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
            <div>
                <form style="float:right" action="/logout" method="post">
                    <button type="submit">Logout</button>
                </form>
            </div>
        </div>
    <body>
</html>