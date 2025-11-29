package controllers.Faltas;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;
import dto.FaltasDTO;

@WebServlet("/faltas/actualizarFalta")
public class ActualizarFaltaController extends HttpServlet {

    IFaltasService service = new FaltasServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        FaltasDTO falta = service.obtenerFaltaPorId(id);

        request.setAttribute("falta", falta);

        // SIEMPRE ESTE JSP
        request.getRequestDispatcher("/WEB-INF/vistas/faltas/actualizarFalta.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idfaltas"));
        int alumno = Integer.parseInt(request.getParameter("alumno"));
        int asignatura = Integer.parseInt(request.getParameter("asignatura"));
        String fecha = request.getParameter("fecha");
        int justificada = request.getParameter("justificada") != null ? 1 : 0;

        int resultado = service.actualizarFalta(id, alumno, asignatura, fecha, justificada);

        request.setAttribute("resultado", resultado);

        // SIEMPRE EL MISMO JSP
        request.getRequestDispatcher("/WEB-INF/vistas/faltas/actualizarFalta.jsp")
               .forward(request, response);
    }
}
