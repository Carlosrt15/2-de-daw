<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Asignatura</title>

<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">
</head>

<body>

<h1>Insertar Asignatura</h1>

<form action="http://localhost:8080/colegio/asignaturas/insertarAsignatura" method="post">

    <label>Id:</label>
    <input type="text" name="id" required><br><br>

    <label>Nombre:</label>
    <input type="text" name="nombre" required><br><br>

    <label>Curso:</label>
    <input type="number" name="curso" required><br><br>

    <label>Tasa:</label>
    <input type="number" step="0.01" name="tasa" required><br><br>

    <label>Activo:</label>
    <input type="number" name="activo" placeholder="1 = Sí / 0 = No" required><br><br>

    <input type="submit" value="Insertar">
</form>

<br>

<c:if test="${resultado == 1}">
    <h2 style="color:green;">Asignatura insertada correctamente</h2>
</c:if>

<c:if test="${resultado == 0}">
    <h2 style="color:red;">Error al insertar asignatura</h2>
</c:if>

<c:if test="${resultado == -1}">
    <h2 style="color:red;">Debe rellenar todos los campos</h2>
</c:if>

</body>
</html>
