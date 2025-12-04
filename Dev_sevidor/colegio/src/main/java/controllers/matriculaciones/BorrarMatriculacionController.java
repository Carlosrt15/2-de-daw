package controllers.matriculaciones;

import java.io.IOException;

import servicios.IMatriculacionesService;
import serviciosImp.MatriculacionesServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/matriculaciones/borrarMatriculacion")
public class BorrarMatriculacionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String id = request.getParameter("id");
        System.out.println("DEBUG borrarMatriculacion → ID recibido: " + id);

     
        IMatriculacionesService service = new MatriculacionesServiceImp();
        int resultado = service.borrarMatriculacion(id);

        System.out.println("DEBUG borrarMatriculacion → Resultado UPDATE: " + resultado);

       
        if (resultado == 1) {
            response.sendRedirect(request.getContextPath() + "/matriculaciones/listarMatriculaciones");
            return;
        }

        
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp")
               .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        doPost(req, resp);
    }
}
