import java.io.IOException;
import java.sql.SQLException;
import view.VistaVenta;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Hola mundo");

        VistaVenta vv = new VistaVenta();
     // VistaPublicacion vp = new VistaPublicacion();
       // VistaTipo vt = new VistaTipo();

      //  vt.menuInsertarTipo();

      //  vt.menuListarTipos();

       // vt.menuActualizarDescripcion();
       //vp.menuInsertarPublicacion();
       //vp.menuActualizarPublicacion();
      // vp.menuListarPublicaciones();

        vv.menuInsertarVenta();




    }
}
