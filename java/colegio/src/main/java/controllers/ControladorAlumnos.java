package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.AlumnoDTO;
import dao.IAlumnosDAO;

/**
 * Servlet implementation class ControladorAlumnos
 */
@WebServlet("/alumnos/ha")

public class ControladorAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse
    		response) throws ServletException, IOException {
    		IAlumnosDAO alumnosDao = new daoImp.AlumnosDAOImpl();
    		ArrayList<AlumnoDTO> listaAlumnos;
			listaAlumnos = alumnosDao.obtenerTodosAlumnos();
			request.setAttribute("listaAlumnos", listaAlumnos);
			RequestDispatcher d =
			getServletContext().getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp");
			d.forward(request, response);
    		
    		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
