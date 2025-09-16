/*
 * 2. Escribir un programa que escriba un número aleatorio entero entre 1 y 10
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numRandom = random.nextInt(10) + 1;

        System.out.println(numRandom);


        /*
 * 
 * 3. Escribir un programa que cada vez que se ejecute saque de un nombre de un compañero de
clase. Implementarlo con un array (o lista)
 */

        String names[] = {"Carlos", "Pablo","David", "Felix", "Diego", "Hugo","Adrian"};

            int index = random.nextInt(names.length);
            String randomName = names[index];
            System.out.println(randomName);




            /*
     * Hacer el mismo programa, pero usando enum.

     */
    
    /*
     * Escribir un programa que genere un primer número entero aleatorio y posteriormente genere
20 números enteros aleatorios y vaya comparando estos 20 con el número generado en un
primer lugar. Por pantalla tendrá que salir “El primer número X es [menor | mayor | igual] que
Y"
     */
    
    int randomNumber = random.nextInt(100);
        System.out.println("El primer numero es:  "+ randomNumber);
        
        // Generar 20 numeros aleatorios y comparar

        for(int i = 0; i< 20; i++) {
            int current = random.nextInt(100);

            System.out.println("El numero actual es : "+ current + " el numero comparado es: "+randomNumber+ " // Interacion numero:"+i);

            if (randomNumber < current) {
                System.out.println("Menor que" + current);
            } else if (randomNumber > current) {
                System.out.println("Mayor que "+ current);
            } else {
                System.out.println("igual a " + current);
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        /*
         * 
         *  Escribir un programa para jugar a “piedra, papel, tijera” con el ordenador. El juego funcionará
            de la siguiente manera: El usuario escribirá una de las tres palabras (piedra, papel o tijera) y
            luego el ordenador sacará una aleatoria. Tendrá que salir el mensaje de quién ha ganado
         */

         System.out.println("Escriba (piedra,papel,tijera)");

         String game = scanner.nextLine().toLowerCase();

        String[] opciones = {"piedra","papel","tijera"};

         String ordenador = opciones[random.nextInt(3)];

         System.out.println("Ordenador eligió: "+ ordenador);

         // Determina el resultado

        if (game.equals(ordenador)) {
            System.out.println("Empate");
        } else if (
            (game.equals("piedra") && ordenador.equals("tijera")) ||
            (game.equals("papel")  && ordenador.equals("piedra")) ||
            (game.equals("tijera") && ordenador.equals("papel"))
        ) {
            System.out.println("¡Ganaste!");
        } else if (
            game.equals("piedra") || game.equals("papel") || game.equals("tijera")
        ) {
            System.out.println("Gana el ordenador");
        } else {
            System.out.println("Opción no válida");
        }


           /*
            *   Escribir un programa que detecte números primos hasta 100 (usar el operador módulo %, el
                número primo es aquel que es divisible solo por sí mismo y por 1).

            */


            

            for(int x = 2; x < 100 ; x++) {

                boolean primo = true;

                for(int i = 2; i< x; i++) {
                if (x % i == 0) {
                    primo = false;
                    break;
                    
                }
            }

            if (primo) {
                System.out.println(x + " es primo");
            }



    }
    
        System.out.println("------------------------------------------------------");




         // Escribir un programa que pida dos palabras por consola y compare si son iguales.



            System.out.println("Introduce la primera palabra para comparar si son iguales ");


        String word1 = scanner.nextLine();
        System.out.println("Introduce la segunda palabra ");
        

        String word2 = scanner.nextLine();

        if (word1.equals(word2)) {
            System.out.println("Las palabras son iguales");
            
        } else {
            System.out.println("Las palabras no son iguales");
        }



         

    
    }

}
