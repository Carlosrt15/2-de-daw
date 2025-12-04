package controllers.matriculaciones;

import java.io.IOException;

import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/matriculaciones/modificarMatriculacion")
public class ModificarMatriculacionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idMatricula = request.getParameter("id");
        String idAsignatura = request.getParameter("idAsignatura");
        String fecha = request.getParameter("fecha");
        String tasa = request.getParameter("tasa");

        IMatriculacionesService service = new MatriculacionesServiceImp();
        int resultado = service.modificarMatriculacion(idMatricula, idAsignatura, fecha, tasa);

        request.setAttribute("resultado", resultado);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/modificarMatriculaciones.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
