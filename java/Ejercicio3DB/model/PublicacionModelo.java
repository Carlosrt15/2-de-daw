package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



    public List<PublicacionDTO> leerPublicaciones(
            String idpublicacion,
            String titulo,
            String autor,
            String nroedicionLike,
            Double precioMin,
            Integer stockMin,
            String idtipo
    ) throws SQLException, ClassNotFoundException {

        StringBuilder sql = new StringBuilder(
            "SELECT p.idpublicacion, p.titulo, p.autor, p.nroedicion, " +
            "p.precio, p.stock, p.idtipo, t.descripcion " +
            "FROM publicacion p JOIN tipo t ON p.idtipo = t.idtipo " +
            "WHERE 1=1"
        );

        List<Object> params = new ArrayList<>();

        if (idpublicacion != null) { sql.append(" AND p.idpublicacion = ?"); params.add(idpublicacion); }
        if (titulo != null)        { sql.append(" AND p.titulo LIKE ?");      params.add("%" + titulo + "%"); }
        if (autor != null)         { sql.append(" AND p.autor LIKE ?");       params.add("%" + autor + "%"); }
        if (nroedicionLike != null){ sql.append(" AND p.nroedicion LIKE ?");  params.add("%" + nroedicionLike + "%"); }
        if (precioMin != null)     { sql.append(" AND p.precio >= ?");        params.add(precioMin); }
        if (stockMin != null)      { sql.append(" AND p.stock >= ?");         params.add(stockMin); }
        if (idtipo != null)        { sql.append(" AND p.idtipo = ?");         params.add(idtipo); }

        List<PublicacionDTO> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PublicacionDTO dto = new PublicacionDTO(
                    rs.getString("idpublicacion"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("nroedicion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("idtipo")
                );
                // podemos guardar la descripción en un nuevo campo o mostrarla aparte
                dto.setDescripcionTipo(rs.getString("descripcion"));
                lista.add(dto);
            }
        }
        return lista;
    }


}
