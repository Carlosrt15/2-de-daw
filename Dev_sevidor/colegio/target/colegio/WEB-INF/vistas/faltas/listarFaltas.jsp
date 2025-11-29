<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
                            <c:when test="${f.jusftificada == 1}">Sí</c:when>
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
