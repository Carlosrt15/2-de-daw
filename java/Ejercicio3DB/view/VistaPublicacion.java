package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.PublicacionController;

public class VistaPublicacion {

    Scanner sc = new Scanner(System.in);

    public void menuInsertarPublicacion() throws  ClassNotFoundException, SQLException,
        NumberFormatException, IOException {

            System.out.println("Inserta la idPublicacion");
            String idpublicacion = sc.nextLine();
            System.out.println("Inserta el titulo");
            String titulo = sc.nextLine();
            System.out.println("Inserta el autor");
            String autor = sc.nextLine();
            System.out.println("Inserta el numero de edicion");
            int nroedicion = sc.nextInt();
            System.out.println("Inserta el precio ");
            double precio = sc.nextDouble();
            System.out.println("Inserta el numero de stock");
            int stock = sc.nextInt();
           
            String idtipo = "COM";

            PublicacionController controller = new PublicacionController();
            Integer filas = controller.insertarPublicacion(idpublicacion, titulo, autor, nroedicion, precio, stock, idtipo);

            System.out.println("Filas insertadas: " +filas);
        }



}
