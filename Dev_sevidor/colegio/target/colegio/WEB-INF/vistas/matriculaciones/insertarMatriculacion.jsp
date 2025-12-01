<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insertar Matriculación</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<h1>Insertar Matriculación</h1>

<form action="http://localhost:8080/colegio/matriculaciones/insertarMatriculacion" method="post">

    <label>Alumno</label>
    <select id="alumno" name="alumno" required>
        <option value="">Seleccione un alumno</option>
        <c:forEach items="${desplegableAlumnos}" var="a">
            <option value="${a.id}">${a.descripcion}</option>
        </c:forEach>
    </select><br>

    <label>Asignatura</label>
    <select id="asignatura" name="asignatura" required>
        <option value="">Seleccione una asignatura</option>
        <c:forEach items="${desplegableAsignaturas}" var="as">
            <option value="${as.id}">${as.descripcion}</option>
        </c:forEach>
    </select><br>

    <label>Tasa (€)</label>
    <input type="number" id="tasa" name="tasa" readonly><br>

    <label>Fecha</label>
    <input type="date" name="fecha"><br>

    <input type="submit" value="Insertar">
</form>

<script>
$(document).on('change', '#alumno, #asignatura', function () {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/colegio/tasa",
        data: {
            alumnos: $("#alumno").val(),
            asignaturas: $("#asignatura").val()
        },
        success: function (data) {
            $("#tasa").val(data);
        }
    });
});
</script>

<c:if test="${not empty resultado}">
    <c:choose>
        <c:when test="${resultado > 0}">
            <h2 style="color:green">Matriculación insertada correctamente</h2>
        </c:when>
        <c:otherwise>
            <h2 style="color:red">Error al insertar</h2>
        </c:otherwise>
    </c:choose>
</c:if>

</body>
</html>
