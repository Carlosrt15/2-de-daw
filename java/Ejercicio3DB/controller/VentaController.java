package controller;

public class VentaController {

    public Integer insertarVenta(int idventa, String cliente, String fecha, int idempleado, String idpublicacion, int cantidad,
			double precio, double dcto, double impuesto) throws SQLException, ClassNotFoundException {

                    VentaModelo vm = new VentaModelo();

                       return vm.insertarVenta(); 



    }

}
