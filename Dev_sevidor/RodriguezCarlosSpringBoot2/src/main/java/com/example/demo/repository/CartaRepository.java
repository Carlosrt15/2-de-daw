package com.example.demo.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.service.Carta;


@Repository
public class CartaRepository {

    
    private static final String FILE_PATH = "src/main/resources/BBDD.txt";

    public Optional<Carta> buscarPorNombre(String nombreBuscado) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(FILE_PATH));

            for (String linea : lineas) {
                String[] partes = linea.split("-");
                if (partes.length == 4) {
                    String nombre = partes[0].trim();
                    if (nombre.equalsIgnoreCase(nombreBuscado)) {
                        double coste = Double.parseDouble(partes[1]);
                        double dano = Double.parseDouble(partes[2]);
                        double vida = Double.parseDouble(partes[3]);
                        return Optional.of(new Carta(nombre, coste, dano, vida));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}