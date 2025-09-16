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
            System.out.println("empate");
         } else if (game.equals("piedra") &&) {
            
         }

    }
    
    

    
}
