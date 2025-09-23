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



}
