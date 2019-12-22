<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="find_section">
            <h3>car search</h3>
            <form method="post" action="/cars/car" onclick="return true">
                <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                <input class="button_submit" id="submit" name="submit" type="submit" value="search" placeholder="submit"/>
            </form>
        </div>
    <c:if test="${isVisible}">
    <div>
           <table class="table">
            <tr>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Cost</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr align="center">
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.cost}</td>
                </tr>
            </c:forEach>
           </table>
    </c:if>
    </div>
    </body>
</html>
