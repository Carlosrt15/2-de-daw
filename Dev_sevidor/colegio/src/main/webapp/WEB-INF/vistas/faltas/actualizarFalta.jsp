<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
    <title>Actualizar Falta</title>
    <link rel="stylesheet" href="/colegio/css/index.css">
    <link rel="stylesheet" href="/colegio/css/formularios.css">
</head>
<body>

<header>
    <h2>Actualizar Falta</h2>
</header>

<%@ include file="/menu.html" %>

<div class="container">
<div class="form">

    <form action="http://localhost:8080/colegio/faltas/actualizarFalta" method="post">

        <input type="hidden" name="idfaltas" value="${falta.idfaltas}">

        <label>Alumno:</label>
        <input type="number" name="alumno" value="${falta.alumno}">

        <label>Asignatura:</label>
        <input type="number" name="asignatura" value="${falta.asignatura}">

        <label>Fecha:</label>
        <input type="date" name="fecha" value="${falta.fecha}">

        <label>Justificada:</label>
        <input type="checkbox" name="justificada"
               <c:if test="${falta.justificada == 1}">checked</c:if> >

        <input type="submit" value="Actualizar Falta">

    </form>

    <c:if test="${resultado == 1}">
        <b>Falta actualizada correctamente</b>
    </c:if>

</div>
</div>

</body>
</html>
