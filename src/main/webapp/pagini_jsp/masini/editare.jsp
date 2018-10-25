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

<h2> Aici Editezi Masini </h2>

<form action="/web/cars/modifica" method="post">
    <input type="hidden" name="id" value="${MASINA_EDITATA.id }">
    Make: <input name="in_make" value="${MASINA_EDITATA.make }"><br>
    Model: <input name="in_model" value="${MASINA_EDITATA.model }"><br>
    <input type="submit">
</form>

</body>
</html>