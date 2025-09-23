
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoModelo {

    public Integer insertarTipo(String id, String descripcion) throws SQLException, ClassNotFoundException {
    
           
    
             String sql = "INSERT INTO tipo (idtipo, descripcion) VALUES (?, ?)";

             Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = null;
              Integer resultado = null;


              ps = conn.prepareStatement(sql);

              ps.setString(1, id);
              ps.setString(2, descripcion);

              conn.close();
              return resultado;
    }
    
}
