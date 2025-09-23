package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.TipoController;

public class VistaTipo {

    Scanner sc = new Scanner(System.in);

    public void menuInsertarTipo() throws ClassNotFoundException, SQLException,
        NumberFormatException, IOException {
        System.out.println("Introduzca La id (Maximo 3 cracteres)");
        String idTipo = sc.nextLine();
        System.out.println("Introduzca La descripcion");
        String descripcionTipo = sc.nextLine();

        TipoController controller = new TipoController();
        Integer filas = controller.insertarTipo(idTipo, descripcionTipo);

        System.out.println("Filas insertadas: " +filas);
       
    }

    public void menuListarTipos() throws ClassNotFoundException, SQLException {
    TipoController controller = new TipoController();


        controller.mostrarTipos();


    }


    public void menuActualizarDescripcion() throws ClassNotFoundException, SQLException {
    System.out.print("Introduzca el id del tipo a actualizar: ");
    String id = sc.nextLine();

    System.out.print("Introduzca la nueva descripción: ");
    String nuevaDescripcion = sc.nextLine();

    TipoController controller = new TipoController();
    int filas = controller.actualizarDescripcion(id, nuevaDescripcion);

    if (filas > 0) {
        System.out.println("Descripción actualizada correctamente.");
    } else {
        System.out.println("No se encontró un registro con ese id.");
    }

}


}
