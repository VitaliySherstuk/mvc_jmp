<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>

    <body>
    <jsp:include page="header.jsp"/>
    <div>
        <div class="transport_section">
            <h2 align="center">Category</h2>
            <div class="category">
                <a href="/cars">
                    <span>
                        <img src="/resources/img/auto.png" alt="CAR"/>
                    </span>
                </a>
                <h4 align="center">CAR</h4>
            </div>
            <div class="category">
                <a href="">
                    <span>
                        <img src="/resources/img/lorry.png" alt="LORRY"/>
                    </span>
                </a>
                <h4 align="center">LORRY</h4>
            </div>
            <div class="category">
                <a href="">
                    <span>
                        <img src="/resources/img/motto.png" alt="BIKE"/>
                    </span>
                </a>
                <h4 align="center">BIKE</h4>
            </div>
            <div class="category">
                <a href="/inventory">
                    <span>
                        <img src="/resources/img/inv.png" alt="My Inventory"/>
                    </span>
                </a>
                <h4 align="center">INVENTORY</h4>
            </div>
        </div>
    </div>
    </body>
</html>
