function ejercicio6() {

    let notas = [7,3,4,6,8,6,3,6.3,5,7.5,9,10,3.5,2.5,5.5];
    console.log(notas.length);

    let aprobados = notas.filter(nota => nota >= 5);

    alert(notas);
    alert(aprobados);

    // Buscar la posicion 

    let posicion1 = notas.findIndex(nota => nota == 5.5);
    console.log(posicion1);

    let posicion2 = aprobados.findIndex(aprobado => aprobado == 5.5);
    console.log(posicion2);

    alert(aprobados);

    // Comprobar aprobados

     let comprobarAprobado = notas.every(nota => nota[0] >= 5);

        if(comprobarAprobado != true) {
            alert("No todos aprobaron");
        } else {
            alert("Todos aprobaron");
        }

    /*
   A partir de un array que contenga 12 palabras, obtén otro en el que solo se
    ncluyan las que tengan menos de 6 caracteres.
  */

    let palabras = [
  "sol",
  "luna",
  "mar",
  "cielo",
  "montaña",
  "río",
  "bosque",
  "flor",
  "estrella",
  "nube",
  "arena",
  "viento"
];

let menosDe6Caracteres = palabras.filter(palabra => palabra.length < 6);
console.log(menosDe6Caracteres);

// Encontrar posicion de la primera palabra que acabe en 'o'

let recuperarO = palabras.findIndex(palabra => palabra[palabra.length -1] ==="o");


    // Dado un array con 8 números de teléfono, busca si alguno termina en 3.

    const telefonos = [
  "5551234567",
  "5552345678",
  "5553456789",
  "5554567890",
  "5555678901",
  "5556789012",
  "5557890123",
  "5558901234"
];

console.log(telefonos);


}