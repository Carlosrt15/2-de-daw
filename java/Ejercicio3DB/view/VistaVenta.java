package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.VentaController;

public class VistaVenta {

    Scanner sc = new Scanner(System.in);


    public void menuInsertarVenta() throws ClassNotFoundException, SQLException,
        NumberFormatException, IOException {

            System.out.println("Inserta id de la venta");
            int idventa = sc.nextInt();
            sc.nextLine(); // <-- limpiar el salto de línea
            System.out.println("Inserta el nombre del cliente");
            String cliente = sc.nextLine();
            System.out.println("Iserta la fecha formato (XXXX-XX-XX)");
            String fecha = sc.nextLine();
            sc.nextLine(); // <-- limpiar el salto de línea
            System.out.println("inserta la id del empleado");
              int idempleado = sc.nextInt();
              sc.nextLine(); // <-- limpiar el salto de línea
              System.out.println("Inserta la idplubicaion");
              String idpublicacion = sc.nextLine();
              System.out.println("INtroduce la cantidad");
              int cantidad = sc.nextInt();
              sc.nextLine(); // <-- limpiar el salto de línea
              System.out.println("Introduce el precio");
              Double precio = sc.nextDouble();
              sc.nextLine(); // <-- limpiar el salto de línea
              System.out.println("Ingresa el descuento");
              Double dcto = sc.nextDouble();
              sc.nextLine(); // <-- limpiar el salto de línea
              System.out.println("Ingresa el impuesto");
              Double impuesto = sc.nextDouble();


            VentaController controller = new VentaController();
            Integer filas = controller.insertarVenta(idventa, cliente, fecha, idempleado, idpublicacion, cantidad, idventa, idempleado, cantidad);


            System.out.println("Filas insertadas : "+filas);


    }        

}
