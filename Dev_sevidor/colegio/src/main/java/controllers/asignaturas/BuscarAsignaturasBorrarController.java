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

@WebServlet("/asignaturas/buscarAsignaturasBorrar")
public class BuscarAsignaturasBorrarController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        IAsignaturasService service = new AsignaturasServiceImp();

        
        ArrayList<AsignaturaDTO> lista = service.buscarAsignaturas(id, "", "", "", "");

        request.setAttribute("listaAsignaturas", lista);

        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/borrarAsignaturas.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
