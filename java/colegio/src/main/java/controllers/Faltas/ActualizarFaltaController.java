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

@WebServlet("/faltas/actualizarFalta")
public class ActualizarFaltaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ActualizarFaltaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/faltas/actualizarFalta.jsp");
        d.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int alumno = Integer.parseInt(request.getParameter("alumno"));
        int asignatura = Integer.parseInt(request.getParameter("asignatura"));
        String fecha = request.getParameter("fecha");
        int justificada = request.getParameter("justificada") != null ? 1 : 0;

        IFaltasService service = new FaltasServiceImp();
        service.actualizarFalta(id, alumno, asignatura, fecha, justificada);

        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/faltas/actualizarFalta.jsp");
        d.forward(request, response);
    }
}
