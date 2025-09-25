package model;

public class VentaModelo {

    public Integer insertarVenta(int idventa, String cliente, String fecha, int idempleado, String idpublicacion, int cantidad,
			double precio, double dcto, double impuesto) throws SQLException, ClassNotFoundException {

                String sql = "INSERT INTO  venta (idventa, cliente, fecha,idempleado,idpublicacion,cantidad,precio,dcto,impuesto) VALUES (?, ?, ?,?,?,?,?,?,?)";


                try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.preparedStatement(sql)) {



                    return ps.executeQuery();
                }

    }



}
