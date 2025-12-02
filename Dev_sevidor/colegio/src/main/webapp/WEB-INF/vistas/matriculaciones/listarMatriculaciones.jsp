<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Matriculaciones</title>

<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">

</head>
<body>

<h1>Listado de Matriculaciones</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Alumno</th>
        <th>Asignatura</th>
        <th>Fecha</th>
        <th>Importe</th>
        <th>Activo</th>
    </tr>

    <c:forEach var="m" items="${listaMatriculaciones}">
        <tr>
            <td>${m.id}</td>
            <td>${m.alumno}</td>
            <td>${m.asignatura}</td>
            <td>${m.fecha}</td>
            <td>${m.importe}</td>
            <td>${m.activo}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
