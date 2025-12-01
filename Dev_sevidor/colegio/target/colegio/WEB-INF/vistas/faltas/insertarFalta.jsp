<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
	<title>Insertar Falta</title>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
</head>

<body>

<header>
	<h2>Inserción de Falta</h2>
</header>

<%@ include file="/menu.html" %>

<div class="container">
<div class="form">

	<form action="http://localhost:8080/colegio/faltas/insertar" method="post">
		<div id="formulario">

			<label for="alumno">ID Alumno:</label>
			<input type="number" id="alumno" name="alumno" required>

			<label for="asignatura">ID Asignatura:</label>
			<input type="number" id="asignatura" name="asignatura" required>

			<label for="fecha">Fecha:</label>
			<input type="date" id="fecha" name="fecha" required>

			<label for="justificada">Justificada:</label>
			<input type="checkbox" id="justificada" name="justificada">

			<input type="submit" value="Enviar">
		</div>
	</form>

	<c:if test="${resultado == 1}">
		<b>Falta insertada correctamente</b>
	</c:if>

</div>
</div>

</body>
</html>
