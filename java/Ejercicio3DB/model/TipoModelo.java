
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
}
