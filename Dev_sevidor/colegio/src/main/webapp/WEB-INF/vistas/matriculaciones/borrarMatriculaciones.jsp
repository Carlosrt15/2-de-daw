<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/colegio/css/index.css">
<link rel="stylesheet" type="text/css"
	href="/colegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/colegio/css/tablas.css">
<title>Borrar Matriculación</title>
</head>
<body>

<h1>Borrar Matriculación</h1>

<form action="/colegio/matriculaciones/buscarMatriculacionesBorrar" method="post">
    ID Matrícula:
    <input type="text" name="id">
    <input type="submit" value="Buscar">
</form>

<hr>

<c:if test="${not empty listaMatriculaciones}">
    <c:forEach var="m" items="${listaMatriculaciones}">
        
        <form action="/colegio/matriculaciones/borrarMatriculacion" method="post">

            <input type="hidden" name="id" value="${m.id}">

            <b>ID:</b> ${m.id}<br>
            <b>Alumno:</b> ${m.alumno}<br>
            <b>Asignatura:</b> ${m.asignatura}<br>
            <b>Fecha:</b> ${m.fecha}<br>
            <b>Importe:</b> ${m.importe}<br>
            <b>Activo:</b> ${m.activo}<br>

            <br>
            <input type="submit" value="BORRAR" style="background:red; color:white;">
        </form>

        <hr>
    </c:forEach>
</c:if>

<c:if test="${resultado == 1}">
    <h3 style="color:green;">Matriculación borrada correctamente</h3>
</c:if>

<c:if test="${resultado == 0}">
    <h3 style="color:red;">Error al borrar la matriculación</h3>
</c:if>

</body>
</html>
