import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("BBDD/letras.txt", true);
            writer.write("A\n");
            writer.close();
            System.out.println("Letra guardada correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }
}