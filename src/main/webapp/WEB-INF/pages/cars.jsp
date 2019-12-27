<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
        <script src="/resources/js/order.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="find_section">
            <h3>car search</h3>
            <form method="post" action="/cars/car" onclick="return true">
                <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                <input class="find_section_element" id="car_model" name="model" type="text" placeholder="model"/>
                <input class="find_section_element" id="car_year" name="year" type="text" placeholder="year"/>
                <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost"/>
                <select name="order" class="find_section_element" style="width:8%;">
                    <option selected disabled>Order</option>
                    <option value="make">Make</option>
                    <option value="model">Model</option>
                    <option value="year">Year</option>
                    <option value="cost">Cost</option>
                </select>
                <input class="button_submit" id="submit" name="submit" type="submit" value="search" placeholder="submit"/>
            </form>
        </div>
    <c:if test="${isVisible}">
    <div>
           <table id="cars" class="table">
            <tr>
                <th></th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Cost</th>
                <th>Buy</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr align="center">
                    <td>${car.img}</td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.cost}</td>
                    <td>
                        <form method="get" action="/orders/car/${car.id}" onclick="return true">
                            <input class="button_edit" id="submit" name="submit" type="submit" placeholder="submit"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>

           </table>
    </c:if>
    </div>
    </body>
</html>
