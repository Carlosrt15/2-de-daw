import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        int numero = 0;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduce números. El cero terminará la ejecución");

        try {
            FileWriter fw = new FileWriter("/app/BBDD/letras.txt", true);

            do {
                if(scn.hasNextInt()) {			
                    numero = scn.nextInt(); 
                    fw.write(numero + "\n");
                }
            } while (numero != 0);

            fw.close();

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        }
    }
}