package controllers.Faltas;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;

@WebServlet("/faltas/listarFaltas")
public class ListarFaltasController extends HttpServlet {

    private IFaltasService service = new FaltasServiceImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listaFaltas", service.obtenerTodasFaltas());

        RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/vistas/faltas/listarFaltas.jsp");
        d.forward(request, response);
    }
}

