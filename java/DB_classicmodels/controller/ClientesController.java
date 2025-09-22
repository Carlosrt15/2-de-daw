package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ClienteDTO;
import model.ClienteModelo;

public class ClientesController {
    
    public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
                String telefono, String direccion1, String direccion2, String ciudad, String estado,
                
                String codigoPostal, String pais, int representante, Double credito) throws SQLException, ClassNotFoundException {

                    ClienteModelo cm = new ClienteModelo();

                    return cm.insertarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, 
                    
                                direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante, credito);

                }


                public Integer borrarCliente(int customerNumber) throws ClassNotFoundException,
                    SQLException {
                       ClienteModelo cm = new ClienteModelo();
                       return  cm.borrarCliente(customerNumber);

                    }

}
