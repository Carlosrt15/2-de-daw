<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>

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

			<label for="alumno">Alumno:</label>
			<select id="alumno" name="alumno">
				<c:forEach items="${listaAlumnos}" var="a">
					<option value="${a.id}">${a.nombre} ${a.apellido}</option>
				</c:forEach>
			</select>

			<label for="asignatura">Asignatura:</label>
			<select id="asignatura" name="asignatura">
				<c:forEach items="${listaAsignaturas}" var="as">
					<option value="${as.id}">${as.nombre}</option>
				</c:forEach>
			</select>

			<label for="fecha">Fecha:</label>
			<input type="date" id="fecha" name="fecha">

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
