package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JugadorRepository {

    public List<String> obtenerCartas(String nombre) {
        List<String> cartas = new ArrayList<>();

        try {
        	InputStream input = getClass().getResourceAsStream("/cartas.txt");

            if (input == null) {
                System.out.println("❌ No se encontró el archivo cartas.txt");
                return cartas;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(nombre + "-")) {
                    cartas.add(linea.split("-")[1]);
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartas;
    }
}
