package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteModelo {
       
        public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
                String telefono, String direccion1, String direccion2, String ciudad, String estado,
                
                String codigoPostal, String pais, int representante, Double credito) throws SQLException, ClassNotFoundException {

                    String sql = "INSERT INTO customers "
    + "(customerNumber, customerName, contactLastName, contactFirstName, phone, "
    + "addressLine1, addressLine2, city, state, postalCode, country, "
    + "salesRepEmployeeNumber, creditLimit) "
    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


                    Connection conn = ConexionDB.getConnection();
                    PreparedStatement ps = null;
                    Integer resultado = null;

                    ps = conn.prepareStatement(sql);

                    ps.setInt(1, numerocliente);
                    ps.setString(2, nombreCliente);
                    ps.setString(3, apellidoContacto);
                    ps.setString(4, nombreContacto);
                    ps.setString(5, telefono);
                    ps.setString(6, direccion1);
                    ps.setString(7, direccion2);
                    ps.setString(8, ciudad);
                    ps.setString(9, estado);
                    ps.setString(10, codigoPostal);
                    ps.setString(11, pais);
                    ps.setInt(12, representante);
                    ps.setDouble(13, credito);
                    resultado = ps.executeUpdate(); //Devolverá un entero que nos informará
                    // sobre el número de columnas afectadas (en este caso si ha sido 1 significará que
                    //la inserción ha sido correcta).
                        conn.close();
                        return resultado;

                }
                
            {
            }


            public Integer borrarCliente(int customerNumber) throws ClassNotFoundException,
                SQLException {
                    String sql = "DELETE FROM customers where customerNumber = ?";

                        Connection conn = ConexionDB.getConnection();
                        PreparedStatement ps = null;
                        Integer resultado =  null;

                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, customerNumber);

                        resultado = ps.executeUpdate();
                        conn.close();

                        return resultado;
                }
        
        
}
