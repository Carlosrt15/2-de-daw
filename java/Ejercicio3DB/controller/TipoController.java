package controller;

import java.sql.SQLException;

import model.TipoModelo;

public class TipoController {

    public Integer insertarTipo(String  idTipo, String descripcionTipo) throws SQLException, ClassNotFoundException {

            TipoModelo pm = new TipoModelo();

            return pm.insertarTipo(idTipo, descripcionTipo);

    }

}
