<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
	<title>Listar Faltas</title>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
	<link rel="stylesheet" href="/colegio/css/tablas.css">
</head>

<body>

<header>
	<h2>Listado de Faltas</h2>
</header>

<%@ include file="/menu.html" %>

<div class="container">

	<div class="form">
		<form action="http://localhost:8080/colegio/faltas/listar" method="post">

			<label for="alumno">Alumno:</label>
			<select name="alumno" id="alumno">
				<option value="">Todos</option>
				<c:forEach items="${listaAlumnos}" var="a">
					<option value="${a.id}">${a.nombre} ${a.apellido}</option>
				</c:forEach>
			</select>

			<label for="asignatura">Asignatura:</label>
			<select name="asignatura" id="asignatura">
				<option value="">Todas</option>
				<c:forEach items="${listaAsignaturas}" var="as">
					<option value="${as.id}">${as.nombre}</option>
				</c:forEach>
			</select>

			<label for="fecha">Fecha desde:</label>
			<input type="date" name="fecha">

			<input type="submit" value="Buscar">
		</form>
	</div>

	<c:if test="${not empty listaFaltas}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Alumno</th>
				<th>Asignatura</th>
				<th>Fecha</th>
				<th>Justificada</th>
			</tr>

			<c:forEach items="${listaFaltas}" var="f">
				<tr>
					<td>${f.idfaltas}</td>
					<td>${f.alumno}</td>
					<td>${f.asignatura}</td>
					<td>${f.fecha}</td>
					<td>
						<c:choose>
							<c:when test="${f.justificada == 1}">Sí</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</div>

</body>
</html>
