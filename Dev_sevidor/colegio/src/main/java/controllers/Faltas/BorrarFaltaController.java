package controllers.Faltas;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;

@WebServlet("/faltas/borrar")
public class BorrarFaltaController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vistas/faltas/borrarFalta.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idfaltas"));

        IFaltasService service = new FaltasServiceImp();
        int resultado = service.borrarFalta(id);

        request.setAttribute("resultado", resultado);

        request.getRequestDispatcher("/WEB-INF/vistas/faltas/borrarFalta.jsp")
                .forward(request, response);
    }
}
