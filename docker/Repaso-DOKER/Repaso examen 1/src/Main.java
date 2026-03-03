import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            // Crear carpeta datos si no existe
            File carpeta = new File("datos");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            // Archivo donde se guardarán los registros
            File archivo = new File("datos/registro.txt");

            // Escribir una nueva línea en el archivo
            FileWriter writer = new FileWriter(archivo, true);
            writer.write("Nueva ejecución del programa\n");
            writer.close();

            System.out.println("Registro actualizado.\n");

            // Leer y mostrar el contenido completo del archivo
            List<String> lineas = Files.readAllLines(Paths.get("datos/registro.txt"));

            System.out.println("Contenido del archivo:");
            for (String linea : lineas) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al manejar el archivo.");
        }
    }
}