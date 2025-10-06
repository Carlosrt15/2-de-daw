function ejercicio1(){

    let vacio = [];
    let opcion = true;

    while(opcion) {

        let pedirNumero = (prompt("Introduce un numero, deja vacio para detener el programa"));

            if(pedirNumero === "" || isNaN(Number(pedirNumero))) {
                alert("Terminaste el programa");
                 opcion = false;

                 // Recorrer el array de menor a mayor
                 const numerosOrdenados = vacio.sort((a,b) => a - b);
                 alert(numerosOrdenados);

            } else {
                vacio.push(pedirNumero);

            }
                      

    }
}


function ejercicio2() {

let palabras = [];

for(let i = 0; i < 2; i++) {
    let introducirPalabra = prompt("Introduce 2 palabras");
    palabras.push(introducirPalabra);
    
}

let palabra1 = palabras[0];
let palabra2 = palabras[1];

if (palabra1.length === palabra2.length) {
        alert("Las dos palabras tienen el mismo número de letras");
    } else if (palabra1.length > palabra2.length) {
        let diferencia = palabra1.length - palabra2.length;
        alert("La primera palabra tiene " + diferencia + " letras más que la segunda");
    } else {
        let diferencia = palabra2.length - palabra1.length;
        alert("La segunda palabra tiene " + diferencia + " letras más que la primera");
    }


}


function ejercicio3() {

  let entrada = prompt("Introduce tres números separados por '&':");
let numeros = entrada.split("&").map(Number);

let [a, b, c] = numeros;

if (a === b && b === c) {
  alert("Los tres números son iguales");
} else if (a === b || a === c || b === c) {
  alert("Solo dos números son iguales");
} else {
  alert("Los tres son diferentes. El mayor es: " + Math.max(a, b, c));
}


    
}

function ejercicio4() {

    let par = [];
    let impar = [];

    let pedirNumero = Number(prompt("introudce un numero"));

    for(let i = 0; i <= pedirNumero; i++) {
        if(i % 2 === 0) {
            par.push(i)

        } else {
            impar.push(i);
        }

    }
    alert(par+ " : Son los numeros par");

    alert(impar+ " : Son los numeros impar");


}

function iaejercicio5(){
    let vacio1 = [];

    for(let i = 0; i <= 5; i++) {
        let pedirNumero = Number(prompt("Introduce un numero : "+i));
        vacio1.push(pedirNumero);
    }
    // recorrer array al reves
    alert( vacio1.sort((a,b) => a- b));


}

function iaejercicio6(){
let numeros = [];

for(let i = 0; i <= 3; i++) {
 let pedirNums = Number(prompt("Introduce 3 numeros :  "+i));
 numeros.push(pedirNums);

}
let maximo = Math.max(...numeros);
let min = Math.min(...numeros);

alert(maximo+ "  el mayor");
alert(min+ "  el menor");

}

function iaejercicio7(){

    
    
    let duplicado = [1,1,1,4,6,6,6,7,8,8,8,12,12,11];
    let unico = [];
    // Eliminar duplicados

    for(let i = 0; i < duplicado.length; i++) {
            if(unico.indexOf(duplicado[i]) === -1) {
                unico.push(duplicado[i]);
                
            }

    }

    alert("Array sin duplicados: "+ unico);

    let cantidadDuplicados = duplicado.length - unico.length;

    alert("HABIA "+cantidadDuplicados+ " numeros duplicados total");


}

function AulaScript1(){

    let dias = new Array(7), num;
    dias[0] = "Domingo";
    dias[1] = "Lunes";
    dias[2] = "Martes";
    dias[3] = "Miercoles";
    dias[4] = "Jueves";
    dias[5] = "Viernes";
    dias[6] = "Sabado";
    num = parseInt(prompt("Numero del día"));
    alert("El dia es "+dias[num]);
}

function preExam() {
    
}



/**
 * EJERCICIOS VARIADOS DE ARRAYS
 */

function repaso1() {

    

}