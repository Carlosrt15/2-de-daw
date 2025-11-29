<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
	<title>Borrar Falta</title>
	<link rel="stylesheet" href="/colegio/css/index.css">
	<link rel="stylesheet" href="/colegio/css/formularios.css">
</head>

<body>

<header>
	<h2>Borrar Falta</h2>
</header>

<%@ include file="/menu.html" %>

<div class="container">
<div class="form">

	<form action="http://localhost:8080/colegio/faltas/borrar" method="post">
		<div id="formulario">

			<label for="idfaltas">ID de la falta:</label>
			<input type="number" id="idfaltas" name="idfaltas">

			<input type="submit" value="Borrar">
		</div>
	</form>

	<c:if test="${resultado == 1}">
		<b>Falta borrada correctamente</b>
	</c:if>

</div>
</div>

</body>
</html>
