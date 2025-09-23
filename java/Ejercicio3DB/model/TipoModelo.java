
package model;

import java.nio.channels.Pipe.SourceChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoModelo {

    public Integer insertarTipo(String id, String descripcion) throws SQLException, ClassNotFoundException {
    
           
    
             String sql = "INSERT INTO tipo (idtipo, descripcion) VALUES (?, ?)";

           try(Connection conn = ConexionDB.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, id);
              ps.setString(2, descripcion);

              // Ejecutar cuantas filas se insertaron
              return ps.executeUpdate();

             }
             


              

              

              
              
    }


    public void listarTipos() throws SQLException, ClassNotFoundException {
        String sql = "SELECT idtipo, descripcion FROM tipo";

        try (Connection conn = ConexionDB.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()) {

                System.out.println("--- Lista de tipos ----");

                while (rs.next()) {
                  String id = rs.getString("idtipo");
                  String descripcion = rs.getString("descripcion");
                  
                  System.out.println("ID: " + id + " |Descripcion: " +descripcion);
                }
              }
              
    }

    public int actualizarTipo(String id, String nuevaDescripcion) throws SQLException, ClassNotFoundException {

      String sql = "UPDATE tipo SET descripcion = ? WHERE idtipo = ?";

      try(Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

          ps.setString(1, nuevaDescripcion);
          ps.setString(2, id);

          // Ejecutar upadate

          return ps.executeUpdate();

        }

      }
      
    
}
