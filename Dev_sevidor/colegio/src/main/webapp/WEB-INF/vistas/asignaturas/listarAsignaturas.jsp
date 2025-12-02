<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Asignaturas</title>

<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">
</head>

<body>

<h1>Listado de Asignaturas</h1>

<form action="http://localhost:8080/colegio/asignaturas/listarAsignaturas" method="post">

    Id: <input type="text" name="id">
    Nombre: <input type="text" name="nombre">
    Curso: <input type="text" name="curso">
    Tasa > <input type="text" name="tasa">
    Activo (1 o 0): <input type="text" name="activo">

    <input type="submit" value="Buscar">
</form>

<br><br>

<c:if test="${not empty listaAsignaturas}">
<table border="1">
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Curso</th>
        <th>Tasa</th>
        <th>Activo</th>
    </tr>

    <c:forEach items="${listaAsignaturas}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.nombre}</td>
            <td>${a.curso}</td>
            <td>${a.tasa}</td>
            <td>${a.activo}</td>
        </tr>
    </c:forEach>

</table>
</c:if>

</body>
</html>
