<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>header</title>
        <meta charset="UTF-8" content="text/html;charset=UTF-8">
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div class="header">
            <div class="category_link">
                <p><a href="/home"><spring:message code="header.home"/></a></p>
            </div>
            <div class="category_link">
                <p><a href="/cars"><spring:message code="header.cars"/></a></p>
            </div>
            <div class="category_link">
                <p><a href="/inventory"><spring:message code="header.inventory"/></a></p>
            </div>
            <div style="float:right">
                <form  action="/logout" method="post">
                    <button style="float:right;" type="submit"><spring:message code="header.logout"/></button>
                </form>
                <c:if test="${userNameStatus}">
                    <div class="user_name_block">${userName}</div>
                </c:if>
            </div>
        </div>
    <body>
</html>