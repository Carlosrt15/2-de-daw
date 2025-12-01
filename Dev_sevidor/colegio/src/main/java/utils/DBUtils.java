package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* ============================================================
 *        VERSIÓN ANTIGUA (JNDI) — COMENTADA
 * 
 *        Esta versión NO funciona si no configuras un recurso
 *        JNDI en Tomcat llamado "jdbc/colegio".
 * 
 *        La dejamos aquí por si algún día quieres reactivarla.
 * ============================================================

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

    public static Connection conexion() {
        Connection connection = null;
        Context ctx = null;
        DataSource ds = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/colegio");
            connection = ds.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

============================================================
 * FIN VERSIÓN ANTIGUA
 * ============================================================
 */



/* ============================================================
 *        VERSIÓN NUEVA (RECOMENDADA)
 *        Funciona SIEMPRE, sin configuración de Tomcat.
 *        Puedes poner tu usuario y contraseña aquí.
 * ============================================================
 */

public class DBUtils {

    // Cambia estos valores a los de tu MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/colegio?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";        
    private static final String PASSWORD = "PracticaRoot";    // ← Casa Contraseña

    public static Connection conexion() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return con;
    }
}
