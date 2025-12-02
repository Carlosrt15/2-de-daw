package controllers.matriculaciones;

import java.io.IOException;

import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/matriculaciones/borrarMatriculacion")
public class BorrarMatriculacionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        IMatriculacionesService service = new MatriculacionesServiceImp();
        int resultado = service.borrarMatriculacion(id);

        request.setAttribute("resultado", resultado);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp")
                .forward(request, response);
    }
}
