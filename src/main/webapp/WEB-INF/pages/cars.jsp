<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div class="find_section">
            <form method="post" action="/cars" onclick="return true">
                <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                <input class="find_section_element" id="car_model" name="model" type="text" placeholder="model"/>
                <input class="find_section_element" id="car_year" name="year" type="text" placeholder="year">
                <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost">
                <input class="find_section_element" id="submit" name="submit" type="submit" placeholder="submit"/>
            </form>
        </div>
    <div>

           <table>
            <tr>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Cost</th>
            </tr>
            <tr>
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.cost}</td>
            </tr>
           </table>

    </div>
    </body>
</html>
