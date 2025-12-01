package controllers.Faltas;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;

@WebServlet("/faltas/insertar")
public class InsertarFaltaController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vistas/faltas/insertarFalta.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int alumno = Integer.parseInt(request.getParameter("alumno"));
        int asignatura = Integer.parseInt(request.getParameter("asignatura"));
        String fecha = request.getParameter("fecha");
        int justificada = request.getParameter("justificada") != null ? 1 : 0;

        IFaltasService service = new FaltasServiceImp();
        int resultado = service.insertarFalta(alumno, asignatura, fecha, justificada);

        request.setAttribute("resultado", resultado);

        request.getRequestDispatcher("/WEB-INF/vistas/faltas/insertarFalta.jsp")
                .forward(request, response);
    }
}

