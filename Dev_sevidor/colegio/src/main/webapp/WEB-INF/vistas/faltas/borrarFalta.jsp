<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
	<link rel="stylesheet" href="/colegio/css/tablas.css">
	<title>Borrar Faltas</title>
</head>
<body>
<%@include file="/menu.html" %>

<div class="container">
	<h2>Borrar Faltas</h2>

	<c:if test="${empty listaFaltas}">
		<p>No hay resultados con esos filtros</p>
	</c:if>

	<c:if test="${not empty listaFaltas}">
		<table>
			<tr>
				<th>ID</th>
				<th>Alumno</th>
				<th>Asignatura</th>
				<th>Fecha</th>
				<th>Justificada</th>
				<th>Borrar</th>
			</tr>
			<c:forEach items="${listaFaltas}" var="f">
				<tr>
					<td>${f.idfaltas}</td>
					<td>${f.alumno}</td>
					<td>${f.asignatura}</td>
					<td>${f.fecha}</td>
					<td><c:choose>
						<c:when test="${f.jusftificada == 1}">Sí</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
					<td>
						<form action="http://localhost:8080/colegio/faltas/borrarFalta" method="post">
							<input type="hidden" name="idfaltas" value="${f.idfaltas}">
							<input type="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
</body>
</html>
