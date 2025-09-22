package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ClientesController;
import model.ClienteDTO;

public class VistaClientes {

    public void menuRecuperarNombreTelefono() throws ClassNotFoundException,
              SQLException, IOException {
                 Scanner leer = new Scanner(System.in);
                 System.out.println("Introduzca el nombre del empleado");

                    String nombreEmpleado = leer.nextLine();
            ClientesController controladorClientes = new ClientesController();
           ArrayList <ClienteDTO> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado);

                    // Imprime los resultados 

                  for(ClienteDTO cliente : listaClientes) {
                  System.out.println(cliente.getNombre() +" " + cliente.getPhone());
            }
        }

}
