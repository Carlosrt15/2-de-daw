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

@WebServlet("/matriculaciones/buscarMatriculacionesBorrar")
public class BuscarMatriculacionesBorrarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IMatriculacionesService service = new MatriculacionesServiceImp();
        ArrayList<MatriculacionDTO> lista = service.listarMatriculaciones();

        request.setAttribute("listaMatriculaciones", lista);

        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp")
                .forward(request, response);
    }
}
