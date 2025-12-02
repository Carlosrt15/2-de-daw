package controllers.asignaturas;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;

@WebServlet("/asignaturas/insertarAsignatura")
public class InsertarAsignaturaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignatura.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String tasa = request.getParameter("tasa");
        String activo = request.getParameter("activo");

        
        if (id == null || id.isEmpty() ||
            nombre == null || nombre.isEmpty() ||
            curso == null || curso.isEmpty() ||
            tasa == null || tasa.isEmpty() ||
            activo == null || activo.isEmpty()) {

            request.setAttribute("resultado", -1);
            request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignatura.jsp")
                    .forward(request, response);
            return;
        }

        IAsignaturasService service = new AsignaturasServiceImp();
        int filas = service.insertarAsignatura(
                id,
                nombre,
                Integer.parseInt(curso),
                Double.parseDouble(tasa),
                Integer.parseInt(activo)
        );

        request.setAttribute("resultado", filas);

        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignatura.jsp")
                .forward(request, response);
    }
}
