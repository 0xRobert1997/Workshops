<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Employees</title>
    </head>
    <body>
        <h1>Employees!</h1>
    </body>

    <c:choose>
        <c:when test="${randomValue % 2 == 0}">
            <p>Even</p>
        </c:when>
        <c:otherwise>
            <p>Odd</p>
        </c:otherwise>
    </c:choose>
</html>