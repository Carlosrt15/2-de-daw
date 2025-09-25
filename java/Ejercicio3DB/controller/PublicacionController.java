package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.ConexionDB;
import model.PublicacionDTO;
import model.PublicacionModelo;

public class PublicacionController {

    public Integer insertarPublicacion(String idpublicacion, String titulo, String autor,int nroedicion, double precio, int stock,String idtipo) throws SQLException, ClassNotFoundException {

            PublicacionModelo pm = new PublicacionModelo();
                return pm.insertarPublicacion(idpublicacion, titulo, autor, nroedicion, precio, stock, idtipo);




}

public int actualizarPublicacion(
        String idpublicacion,
        String titulo,
        String autor,
        Integer nroedicion,
        Double precio,
        Integer stock,
        String idtipo
) throws SQLException, ClassNotFoundException {

    String sql = "UPDATE publicacion SET "
               + "titulo = IFNULL(?, titulo), "
               + "autor = IFNULL(?, autor), "
               + "nroedicion = IFNULL(?, nroedicion), "
               + "precio = IFNULL(?, precio), "
               + "stock = IFNULL(?, stock), "
               + "idtipo = IFNULL(?, idtipo) "
               + "WHERE idpublicacion = ?";

    try (Connection conn = ConexionDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, titulo);
        ps.setString(2, autor);
        if (nroedicion == null) ps.setNull(3, java.sql.Types.INTEGER);
        else ps.setInt(3, nroedicion);

        if (precio == null) ps.setNull(4, java.sql.Types.DOUBLE);
        else ps.setDouble(4, precio);

        if (stock == null) ps.setNull(5, java.sql.Types.INTEGER);
        else ps.setInt(5, stock);

        ps.setString(6, idtipo);
        ps.setString(7, idpublicacion);

        return ps.executeUpdate();
    }
}

public List<PublicacionDTO> leerPublicaciones(String idpublicacion, String titulo, String autor,
     String nroedicionLike, Double precioMin,
        Integer stockMin, String idtipo)
            throws SQLException, ClassNotFoundException {
                
    PublicacionModelo pm = new PublicacionModelo();
    return pm.leerPublicaciones(idpublicacion, titulo, autor, nroedicionLike, precioMin, stockMin, idtipo);
}




    


}




