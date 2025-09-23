package controller;

import java.sql.SQLException;

import model.PublicacionModelo;

public class PublicacionController {

    public Integer insertarPublicacion(String idpublicacion, String titulo, String autor,int nroedicion, double precio, int stock,String idtipo) throws SQLException, ClassNotFoundException {

            PublicacionModelo pm = new PublicacionModelo();
                return pm.insertarPublicacion(idpublicacion, titulo, autor, nroedicion, precio, stock, idtipo);




}


}