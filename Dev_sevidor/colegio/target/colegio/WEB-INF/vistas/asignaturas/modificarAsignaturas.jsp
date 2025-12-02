<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Asignaturas</title>

<!-- SIN pageContext -->
<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">

</head>

<body>

<h1>Modificar Asignaturas</h1>

<h2>Buscar Asignatura</h2>

<form action="http://localhost:8080/colegio/asignaturas/buscarAsignaturasModificar" method="post">

    Id: <input type="text" name="id">
    Nombre: <input type="text" name="nombre">
    Curso: <input type="text" name="curso">
    Tasa > <input type="text" name="tasa">
    Activo: <input type="text" name="activo">

    <input type="submit" value="Buscar">
</form>

<br>


<c:if test="${not empty listaAsignaturas}">
<h2>Resultados</h2>

<c:forEach items="${listaAsignaturas}" var="a">

    <form action="http://localhost:8080/colegio/asignaturas/modificarAsignatura" method="post">

        
        <input type="hidden" name="id" value="${a.id}">

        Nombre: <input type="text" name="nombre" value="${a.nombre}"><br>
        Curso: <input type="number" name="curso" value="${a.curso}"><br>
        Tasa: <input type="number" step="0.01" name="tasa" value="${a.tasa}"><br>
        Activo: <input type="number" name="activo" value="${a.activo}"><br>

        <input type="submit" value="Guardar Cambios">
    </form>

    <hr>

</c:forEach>
</c:if>


<c:if test="${resultado == 1}">
    <h3 style="color:green;">Asignatura modificada correctamente</h3>
</c:if>

<c:if test="${resultado == 0}">
    <h3 style="color:red;">Error al modificar asignatura</h3>
</c:if>

</body>
</html>
