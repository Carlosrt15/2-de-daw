package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.PublicacionController;
import model.PublicacionDTO;

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



        // Metodo actualizar


        public void menuActualizarPublicacion() throws  ClassNotFoundException, SQLException,
            NumberFormatException, IOException {

        System.out.println("---- ACTUALIZAR PUBLICACION ----");
        System.out.println("Introduce la idPublicacion que quieres actualizar:");
        String idpublicacion = sc.nextLine();

        
        System.out.println("Nuevo titulo (Enter para no cambiar):");
        String titulo = sc.nextLine();
        System.out.println("Nuevo autor (Enter para no cambiar):");
        String autor = sc.nextLine();
        System.out.println("Nuevo número de edición (Enter para no cambiar):");
        String nroedicionStr = sc.nextLine();
        System.out.println("Nuevo precio (Enter para no cambiar):");
        String precioStr = sc.nextLine();
        System.out.println("Nuevo stock (Enter para no cambiar):");
        String stockStr = sc.nextLine();
        System.out.println("Nuevo idtipo (Enter para no cambiar):");
        String idtipo = sc.nextLine();

        Integer nroedicion = nroedicionStr.isEmpty() ? null : Integer.parseInt(nroedicionStr);
        Double precio = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);
        Integer stock = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);
        if (idtipo.isEmpty()) idtipo = null;

        PublicacionController controller = new PublicacionController();
        int filas = controller.actualizarPublicacion(idpublicacion, titulo.isEmpty()?null:titulo,
                                                     autor.isEmpty()?null:autor,
                                                     nroedicion, precio, stock, idtipo);

        System.out.println("Filas actualizadas: " + filas);
    }

    public void menuListarPublicaciones() throws SQLException, ClassNotFoundException, IOException{
    System.out.println("---- LISTAR PUBLICACIONES ----");
    System.out.println("idPublicacion (Enter para todos):");
    String idpublicacion = sc.nextLine();
    if (idpublicacion.isEmpty()) idpublicacion = null;

    System.out.println("Titulo (contiene, Enter para todos):");
    String titulo = sc.nextLine();
    if (titulo.isEmpty()) titulo = null;

    System.out.println("Autor (contiene, Enter para todos):");
    String autor = sc.nextLine();
    if (autor.isEmpty()) autor = null;

    System.out.println("Nro edicion (like, Enter para todos):");
    String nroedicionLike = sc.nextLine();
    if (nroedicionLike.isEmpty()) nroedicionLike = null;

    System.out.println("Precio mínimo (Enter para todos):");
    String precioStr = sc.nextLine();
    Double precioMin = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);

    System.out.println("Stock mínimo (Enter para todos):");
    String stockStr = sc.nextLine();
    Integer stockMin = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);

    System.out.println("idTipo (Enter para todos):");
    String idtipo = sc.nextLine();
    if (idtipo.isEmpty()) idtipo = null;

    PublicacionController controller = new PublicacionController();
    List<PublicacionDTO> lista = controller.leerPublicaciones(idpublicacion, titulo, autor,
                                                              nroedicionLike, precioMin, stockMin, idtipo);

    for (PublicacionDTO p : lista) {
        System.out.println(p);
    }
}




}
