package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ClientesController;
import model.ClienteDTO;

public class VistaClientes {

  public void menuInsertaCliente() throws ClassNotFoundException, SQLException,
NumberFormatException, IOException {
BufferedReader leer = new BufferedReader(new
InputStreamReader(System.in));
System.out.println("Introduzca por favor el número del cliente: ");
int numeroCliente = Integer.parseInt(leer.readLine());
System.out.println("Introduzca por favor el nombre del cliente: ");
String nombreCliente = leer.readLine();
System.out.println("Introduzca por favor el apellido del contacto: ");
String apellidoContacto = leer.readLine();
System.out.println("Introduzca por favor el nombre del contacto: ");
String nombreContacto = leer.readLine();
System.out.println("Introduzca por favor el telefono del cliente: ");
String telefono = leer.readLine();
System.out.println("Introduzca por favor la dirección del cliente: ");
String direccion1 = leer.readLine();
System.out.println("Introduzca por favor la dirección 2 del cliente: ");
String direccion2 = leer.readLine();
System.out.println("Introduzca por favor la ciudad del cliente: ");
String ciudad = leer.readLine();
System.out.println("Introduzca por favor el estado del cliente: ");

String estado = leer.readLine();
System.out.println("Introduzca por favor el código postal del cliente:");

String codigoPostal = leer.readLine();
System.out.println("Introduzca por favor el pais: ");
String pais = leer.readLine();
System.out.println("Introduzca por favor el id del representante: ");
int representante = 0;
// Esto es para que me la posibilidad de no introducir nada en los campos
// que son números
try {
representante = Integer.parseInt(leer.readLine());
} catch (NumberFormatException e) {
System.out.println("No se ha introducido número de representante deventas");

}
System.out.println("Introduzca por favor crédito (número con decimales):");

Double credito = 0.0;
try {
credito = Double.parseDouble(leer.readLine());
} catch (NumberFormatException e) {
System.out.println("No se ha introducido crédito");
}
ClientesController controladorClientes = new ClientesController();
//Llamada al controlador con los datos recogidos
int resultado = controladorClientes.insertarCliente(numeroCliente,
nombreCliente,
apellidoContacto,
nombreContacto,
telefono,
direccion1,
direccion2,
ciudad,
estado,
codigoPostal,
pais,
representante,
credito);
if (resultado == 1) {
System.out.println("Se ha introducido el registro con éxito");
} else {
System.out.println("Se ha producido un error al introducir el registro");

}
}

public void menuBorrarCliente() throws ClassNotFoundException, SQLException, IOException {

      Scanner scanner = new Scanner(System.in);

      System.out.println("Introduzca el numero del cliente a borrar");
        int numCliente = 0;


          try {
                numCliente = Integer.parseInt(scanner.nextLine());
          } catch (NumberFormatException e) {
            System.out.println("No se ha introducido el numero del cliente");
          }

          ClientesController controladorClientes = new ClientesController();

          String resultado =  
            (controladorClientes.borrarCliente(numCliente).equals(1))? " Cliente borrado con exito":"No se puedo borrar el cliente";
            System.out.println(resultado);

  }


}
