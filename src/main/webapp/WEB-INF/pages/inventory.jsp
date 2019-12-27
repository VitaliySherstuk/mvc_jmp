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
                <h3>Add car</h3>
                <form method="post" action="/inventory/car" onclick="return true">
                    <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                    <input class="find_section_element" id="car_model" name="model" type="text" placeholder="model"/>
                    <input class="find_section_element" id="car_year" name="year" type="text" placeholder="year"/>
                    <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost"/>
                    <input class="button_submit" id="submit" name="submit" type="submit" value="Add" placeholder="submit"/>
                </form>
            </div>

<c:if test="${isVisible}">
                <div>
                <h3 style="margin-left: 5%;">Your cars</h3>
                    <table class="table">
                        <tr>
                            <th></th>
                            <th>Make</th>
                            <th>Model</th>
                            <th>Year</th>
                            <th>Cost</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${cars}" var="car">
                            <tr align="center">
                                <td><img src="${car.img}" alt="car"></td>
                                <td>${car.make}</td>
                                <td>${car.model}</td>
                                <td>${car.year}</td>
                                <td>${car.cost}</td>
                                <td>
                                    <form method="get" action="/settings/${car.id}" onclick="return true">
                                        <input class="button_edit" id="submit" name="update" type="submit" placeholder="submit"/>
                                    </form>
                                </td>
                                <td>
                                    <form method="get" action="/cars/removed/${car.id}" onclick="return true">
                                        <input class="button_edit" id="submit" name="delete" type="submit" placeholder="submit"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
</c:if>
    </body>
</html>
