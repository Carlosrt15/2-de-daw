package controller;

import java.sql.SQLException;

import model.TipoModelo;

public class TipoController {

    public Integer insertarTipo(String  idTipo, String descripcionTipo) throws SQLException, ClassNotFoundException {

            TipoModelo pm = new TipoModelo();

            return pm.insertarTipo(idTipo, descripcionTipo);

    }

    public void mostrarTipos() throws  SQLException, ClassNotFoundException {

        TipoModelo modelo = new TipoModelo();
        modelo.listarTipos();
    }


    public int actualizarDescripcion(String id, String nuevaDescripcion)
            throws SQLException, ClassNotFoundException {
        TipoModelo modelo = new TipoModelo();
        return modelo.actualizarTipo(id, nuevaDescripcion);
    }

}
