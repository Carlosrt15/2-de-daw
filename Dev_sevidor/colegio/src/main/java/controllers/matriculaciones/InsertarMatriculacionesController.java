package controllers.matriculaciones;
import servicios.IMatriculacionesService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviciosImp.MatriculacionesServiceImp;
import utils.DesplegableUtils;

@WebServlet("/matriculaciones/insertarMatriculacion")
public class InsertarMatriculacionesController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DesplegableUtils.recuperarDesplegableAlumnos(request);
        DesplegableUtils.recuperarDesplegableAsignaturas(request);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idAlumno = request.getParameter("alumno");
        String idAsignatura = request.getParameter("asignatura");
        String tasa = request.getParameter("tasa");
        String fecha = request.getParameter("fecha");

        if (fecha == null || fecha.isEmpty()) {
            fecha = java.time.LocalDate.now().toString();
        }

        IMatriculacionesService service = new MatriculacionesServiceImp();
        int resultado = service.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);

        request.setAttribute("resultado", resultado);

        DesplegableUtils.recuperarDesplegableAlumnos(request);
        DesplegableUtils.recuperarDesplegableAsignaturas(request);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp")
                .forward(request, response);
    }
}
