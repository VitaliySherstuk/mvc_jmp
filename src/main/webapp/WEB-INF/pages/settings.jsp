<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div>
            <table class="table">
                <tr>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Cost</th>
                    <th>New cost</th>
                </tr>
                <c:forEach items="${cars}" var="car">
                    <tr align="center">
                        <td>${car.make}</td>
                        <td>${car.model}</td>
                        <td>${car.year}</td>
                        <td>${car.cost}</td>
                        <td>
                            <div class="find_section">
                                <form method="post" action="/settings/${id}/cost" onclick="return true">
                                    <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost"/>
                                    <input class="button_edit" id="submit" name="submit" type="submit" placeholder="submit"/>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
