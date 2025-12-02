package controllers.asignaturas;

import java.io.IOException;
import java.util.ArrayList;

import dto.AsignaturaDTO;
import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/asignaturas/listarAsignaturas")
public class ListarAsignaturasController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Solo muestra el formulario vacío
        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/listarAsignaturas.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String tasa = request.getParameter("tasa");
        String activo = request.getParameter("activo");

        IAsignaturasService service = new AsignaturasServiceImp();
        ArrayList<AsignaturaDTO> lista = service.buscarAsignaturas(id, nombre, curso, tasa, activo);

        request.setAttribute("listaAsignaturas", lista);

        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/listarAsignaturas.jsp")
                .forward(request, response);
    }
}
