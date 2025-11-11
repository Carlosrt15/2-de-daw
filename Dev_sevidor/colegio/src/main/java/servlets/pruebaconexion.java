package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		try {
			//Con esta linea formazamos que se cargue el driver de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/colegio";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(dbURL, username,
			password);
			//Ya tenemos la conexio hecha a la BBDD
			logger.info("Conexion con la BBDD establecida");
			Statement statement = connection.createStatement();
			alumnos = statement.executeQuery("SELECT * FROM alumnos");
			while(alumnos.next()) {
			AlumnoDTO a = new AlumnoDTO(alumnos.getInt(1),
			alumnos.getString(2), alumnos.getString(3));
			logger.debug("Contenido de alumno " + a.getNombre() + " " +
					a.getId());
					listaAlumnos.add(a);
					}
					} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
					}
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
