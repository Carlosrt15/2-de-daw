package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AlumnoDTO;

/**
 * Servlet implementation class pruebaconexion
 */
@WebServlet("/pruebaconexion")
public class pruebaconexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(pruebaconexion.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pruebaconexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		ResultSet alumnos = null;
		ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
		connection = DBUtils.conexion(); //Usamos el metodo recien creado
		
		try {
		Statement statement = connection.createStatement();
		alumnos = statement.executeQuery("SELECT * FROM alumnos");
		while(alumnos.next()) {
		AlumnoDTO a = new AlumnoDTO(alumnos.getInt(1),
		alumnos.getString(2), alumnos.getString(3));
		logger.debug("Contenido de alumno " + a.getNombre() + ""+ a.getId());
		
		listaAlumnos.add(a);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.setAttribute("listaAlumnos", listaAlumnos);
		RequestDispatcher d =
		getServletContext().getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp");
		d.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
