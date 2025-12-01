package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

@WebServlet("/tasa")
public class CalcularTasaController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idAlumno = request.getParameter("alumnos");
        String idAsignatura = request.getParameter("asignaturas");

        IMatriculacionesService service = new MatriculacionesServiceImp();
        double tasaFinal = service.calcularTasa(idAlumno, idAsignatura);

        response.getWriter().print(tasaFinal);
    }
}
