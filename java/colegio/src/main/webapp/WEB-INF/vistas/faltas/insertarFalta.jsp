<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
	<title>Insertar Falta</title>
</head>
<body>
<%@include file="/menu.html" %>

<div class="container">
	<h2>Poner Falta a un Alumno</h2>
	<div class="form">
		<form action="http://localhost:8080/colegio/faltas/insertarFalta" method="post">
			<label for="alumno">Alumno:</label>
			<select name="alumno" id="alumno">
				<c:forEach items="${listaAlumnos}" var="a">
					<option value="${a.id}">${a.nombre} ${a.apellido}</option>
				</c:forEach>
			</select>

			<label for="asignatura">Asignatura:</label>
			<select name="asignatura" id="asignatura">
				<c:forEach items="${listaAsignaturas}" var="as">
					<option value="${as.id}">${as.nombre}</option>
				</c:forEach>
			</select>

			<label for="fecha">Fecha:</label>
			<input type="date" name="fecha" id="fecha">

			<label for="justificada">Justificada:</label>
			<input type="checkbox" name="justificada" value="1">

			<input type="submit" value="Insertar">
		</form>
	</div>

	<c:if test="${not empty resultado}">
		<p>Resultado: ${resultado}</p>
	</c:if>
</div>
</body>
</html>
