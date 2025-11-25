<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
	<link rel="stylesheet" href="/colegio/css/tablas.css">
	<title>Actualizar Faltas</title>
</head>
<body>
<%@include file="/menu.html" %>

<div class="container">
	<h2>Actualizar Faltas</h2>

	<c:forEach items="${listaFaltas}" var="f">
		<div class="form">
			<form action="http://localhost:8080/colegio/faltas/actualizarFalta" method="post">
				<input type="hidden" name="idfaltas" value="${f.idfaltas}">

				<label for="alumno">Alumno:</label>
				<select name="alumno">
					<c:forEach items="${listaAlumnos}" var="a">
						<option value="${a.id}" <c:if test="${a.id == f.alumno}">selected</c:if>>
							${a.nombre} ${a.apellido}
						</option>
					</c:forEach>
				</select>

				<label for="asignatura">Asignatura:</label>
				<select name="asignatura">
					<c:forEach items="${listaAsignaturas}" var="as">
						<option value="${as.id}" <c:if test="${as.id == f.asignatura}">selected</c:if>>
							${as.nombre}
						</option>
					</c:forEach>
				</select>

				<label for="fecha">Fecha:</label>
				<input type="date" name="fecha" value="${f.fecha}">

				<label for="justificada">Justificada:</label>
				<input type="checkbox" name="justificada" value="1" <c:if test="${f.jusftificada == 1}">checked</c:if>>

				<input type="submit" value="Actualizar">
			</form>
		</div>
	</c:forEach>
</div>
</body>
</html>
