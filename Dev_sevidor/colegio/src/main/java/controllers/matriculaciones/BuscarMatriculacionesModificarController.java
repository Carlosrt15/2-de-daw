package controllers.matriculaciones;

import java.io.IOException;
import java.util.ArrayList;

import dto.MatriculacionDTO;
import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/matriculaciones/buscarMatriculacionesModificar")
public class BuscarMatriculacionesModificarController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        IMatriculacionesService service = new MatriculacionesServiceImp();
        MatriculacionDTO m = service.buscarPorId(id);

        ArrayList<MatriculacionDTO> lista = new ArrayList<>();
        if (m != null) lista.add(m);

        request.setAttribute("listaMatriculaciones", lista);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/modificarMatriculaciones.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
