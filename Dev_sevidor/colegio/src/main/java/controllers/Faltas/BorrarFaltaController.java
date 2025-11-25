package controllers.Faltas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;

import java.io.IOException;

@WebServlet("/faltas/borrarFalta")
public class BorrarFaltaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BorrarFaltaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/faltas/borrarFalta.jsp");
        d.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        IFaltasService service = new FaltasServiceImp();
        service.borrarFalta(id, 0, 0, "", 0);

        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/faltas/borrarFalta.jsp");
        d.forward(request, response);
    }
}
