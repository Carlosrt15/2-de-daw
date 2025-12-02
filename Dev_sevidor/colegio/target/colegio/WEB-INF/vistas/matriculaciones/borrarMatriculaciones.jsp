<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<title>Borrar Matriculaciones</title>
</head>
<body>

<h1>Borrar Matriculación</h1>

<form action="http://localhost:8080/colegio/matriculaciones/buscarMatriculacionesBorrar" method="post">
    <input type="submit" value="Mostrar Matriculaciones">
</form>

<hr>

<c:if test="${not empty listaMatriculaciones}">

    <c:forEach var="m" items="${listaMatriculaciones}">

        <form action="http://localhost:8080/colegio/matriculaciones/borrarMatriculacion" method="post">

            <input type="hidden" name="id" value="${m.id}">

            ID: ${m.id} — ${m.alumno} — ${m.asignatura} — Importe: ${m.importe}

            <input type="submit" value="Borrar" style="background:red; color:white;">
        </form>

        <hr>
    </c:forEach>

</c:if>

<c:if test="${resultado == 1}">
    <h3 style="color:green;">Matriculación borrada correctamente</h3>
</c:if>

<c:if test="${resultado == 0}">
    <h3 style="color:red;">Error al borrar matriculación</h3>
</c:if>

</body>
</html>
