<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/colegio/css/index.css">
<link rel="stylesheet" type="text/css"
	href="/colegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/colegio/css/tablas.css">
<title>Modificar Matriculaciones</title>
</head>
<body>

<h1>Modificar Matriculación</h1>

<form action="/colegio/matriculaciones/buscarMatriculacionesModificar" method="post">
    ID Matrícula:
    <input type="text" name="id">
    <input type="submit" value="Buscar">
</form>

<hr>

<c:if test="${not empty listaMatriculaciones}">
    <c:forEach var="m" items="${listaMatriculaciones}">
        <form action="/colegio/matriculaciones/modificarMatriculacion" method="post">

            <input type="hidden" name="id" value="${m.id}">

            Alumno: <b>${m.alumno}</b><br>
            Asignatura nueva ID: <input type="text" name="idAsignatura"><br>
            Fecha: <input type="date" name="fecha" value="${m.fecha}"><br>
            Tasa nueva: <input type="text" name="tasa" value="${m.importe}"><br>

            <input type="submit" value="Guardar Cambios">
        </form>
        <hr>
    </c:forEach>
</c:if>

<c:if test="${resultado == 1}">
    <h3 style="color:green;">Matriculación modificada correctamente</h3>
</c:if>

<c:if test="${resultado == 0}">
    <h3 style="color:red;">Error al modificar matriculación</h3>
</c:if>

</body>
</html>
