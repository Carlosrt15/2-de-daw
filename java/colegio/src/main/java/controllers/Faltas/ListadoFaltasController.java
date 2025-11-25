package controllers.Faltas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IFaltasService;
import serviciosImp.FaltasServiceImp;
import dto.FaltasDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/faltas/listadoFaltas")
public class ListadoFaltasController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListadoFaltasController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IFaltasService service = new FaltasServiceImp();

        try {
            ArrayList<FaltasDTO> lista = service.obtenerTodasFaltas();
            request.setAttribute("listaFaltas", lista);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/faltas/listadoFaltas.jsp");
        d.forward(request, response);
    }
}
