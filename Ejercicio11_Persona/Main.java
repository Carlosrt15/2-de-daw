import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        

        System.out.println("Introduce un nombre");
        String nombre = sc.nextLine();

        System.out.println("Introduce la edad");
        int edad = sc.nextInt();

        Person persona = new Person(nombre, edad);

        // Mostrar edad
        System.out.println("Persona creada:");
        System.out.println("Nombre: " +persona.getName());
        System.out.println("Años: "+persona.getYears());
        sc.close();




    }
}
