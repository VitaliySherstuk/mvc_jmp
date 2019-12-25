<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Order</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       <div class="car_card">
        <table>
            <tr>
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
            </tr>
            <tr>
                <td><img src="/resources/img/motto.png" alt="car"></td>
            </tr>
            <tr>
                <td>${user.phone}</td>
                <td>${user.name}</td>
            </tr>
            <tr><td>${car.cost}$</td></tr>
        </table>
       </div>
    </body>
</html>