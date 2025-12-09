<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<title>Borrar Asignatura</title>
</head>
<body>

<h1>Borrar Asignatura</h1>

<form action="/colegio/asignaturas/buscarAsignaturasBorrar" method="post">
    ID Asignatura:
    <input type="text" name="id">
    <input type="submit" value="Buscar">
</form>

<hr>

<c:if test="${not empty listaAsignaturas}">
    <c:forEach var="a" items="${listaAsignaturas}">

        <form action="/colegio/asignaturas/borrarAsignatura" method="post">

            <input type="hidden" name="id" value="${a.id}">

            <b>ID:</b> ${a.id}<br>
            <b>Nombre:</b> ${a.nombre}<br>
            <b>Curso:</b> ${a.curso}<br>
            <b>Tasa:</b> ${a.tasa}<br>
            <b>Activo:</b> ${a.activo}<br>

            <br>
            <input type="submit" value="BORRAR" style="background:red;color:white;">
        </form>

        <hr>

    </c:forEach>
</c:if>

<c:if test="${resultado == 0}">
    <h3 style="color:red;">No se pudo borrar la asignatura</h3>
</c:if>

</body>
</html>
