package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaModelo {

    public Integer insertarVenta(int idventa, String cliente, String fecha, int idempleado, String idpublicacion, int cantidad,
			double precio, double dcto, double impuesto) throws SQLException, ClassNotFoundException {

                String sql = "INSERT INTO  venta (idventa, cliente, fecha,idempleado,idpublicacion,cantidad,precio,dcto,impuesto) VALUES (?, ?, ?,?,?,?,?,?,?)";


                try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setInt(1, idventa);
                    ps.setString(2, cliente);
                    ps.setString(3, fecha);
                    ps.setInt(4, idempleado);
                    ps.setString(5, idpublicacion);
                    ps.setInt(6, cantidad);
                    ps.setDouble(7, precio);
                    ps.setDouble(8, dcto);
                    ps.setDouble(9, impuesto);


                    return ps.executeUpdate();


                }
    }



}
