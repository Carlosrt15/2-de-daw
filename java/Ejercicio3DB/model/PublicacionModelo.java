package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PublicacionModelo {

        public Integer insertarPublicacion(String idpublicacion, String titulo, String autor,int nroedicion, double precio, int stock,String idtipo) throws SQLException, ClassNotFoundException {

            String sql = "INSERT INTO publicacion (idpublicacion,titulo,autor,nroedicion,precio,stock,idtipo) VALUES (?,?,?,?,?,?,?)";

            try (Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setString(1, idpublicacion);
                    ps.setString(2, titulo);
                    ps.setString(3, autor);
                    ps.setInt(4, nroedicion);
                    ps.setDouble(5, precio);
                    ps.setInt(6, stock );
                    ps.setString(7, idtipo);

                    return ps.executeUpdate();
                    

                }

    }


}
