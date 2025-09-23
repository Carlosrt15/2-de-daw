package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private  static String URL = "jdbc:mysql://localhost:3306/libreria";
    private  static String USER = "root";
    private  static String PASSWORD = "";

    public static Connection getConnection(){
        Connection conn = null;

        try {
            // Cargar el driver (opcional en Java 6+ si el jar está en el classpath)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexión establecida correctamente");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(" Driver JDBC no encontrado: " + e.getMessage());
        }
        return conn;

    }

}
