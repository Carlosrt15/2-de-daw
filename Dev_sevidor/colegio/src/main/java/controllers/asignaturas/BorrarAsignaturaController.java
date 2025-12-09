package controllers.asignaturas;

import java.io.IOException;

import servicios.IAsignaturasService;
import serviciosImp.AsignaturasServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/asignaturas/borrarAsignatura")
public class BorrarAsignaturaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("DEBUG: Borrando asignatura con id = " + id);

        IAsignaturasService service = new AsignaturasServiceImp();
        int resultado = service.borrarAsignatura(id);

        System.out.println("DEBUG: Resultado borrar asignatura = " + resultado);

        if (resultado == 1) {
            
            response.sendRedirect(request.getContextPath() + "/asignaturas/listarAsignaturas");
            return;
        }

       
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("/WEB-INF/vistas/asignaturas/borrarAsignaturas.jsp")
               .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
