package controllers.asignaturas;

import java.io.IOException;

import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/asignaturas/modificarAsignatura")
public class ModificarAsignaturaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String tasa = request.getParameter("tasa");
        String activo = request.getParameter("activo");

        IAsignaturasService service = new AsignaturasServiceImp();
        int resultado = service.actualizarAsignatura(
                id,
                nombre,
                Integer.parseInt(curso),
                Double.parseDouble(tasa),
                Integer.parseInt(activo)
        );

        request.setAttribute("resultado", resultado);

        // Volver al mismo JSP
        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/modificarAsignaturas.jsp")
                .forward(request, response);
    }
}
