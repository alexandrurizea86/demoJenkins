<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h2> Toate Masinile </h2>

<ul>


    <c:forEach items="${DIN_DB }" var="x">
        <li>
                ${x.id } ${x.make } ${x.model }
            <a href="/web/cars/modifica/${x.id }">Editeaza</a>

            <a href="/web/cars/sterge/${x.id }">Sterge</a>
        </li>
    </c:forEach>
</ul>


</body>
</html>