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





/**
 * EJERCICIOS VARIADOS DE ARRAYS
 */

function repaso1() {

    let  pedirNombres = prompt("Introduce nombres separado por comas : [Carlos,Javier,Raul]");

    let lista = pedirNombres.split(",").map(nombre => nombre.trim());
      
    
    alert(lista[0]);
    alert(lista[lista.length -1]);
    alert("Hay un total de : "+lista.length+" Nombres en la lista");

}


function repaso2(){
    let lista = [];
    let Numero = Number(prompt("Introduce un numero"));

    for(let i = 0; i <= Numero; i++) {

        lista.push(i);
    }

    alert(lista);
    
}


function repaso3(){

     let numeros = [100,34,657,666,59458,12,21,32,23,7563986,674534,7867676,111,777,5,4,3,2];

     // Filtrar numeros

    let pares = numeros.filter(num => num % 2 === 0);

    console.log(pares);

}

function repaso4(){

    let nombres = [];
    option = true;
    while(option) {
        let pedirNombre = prompt("Introduce un nombre");

        if(pedirNombre === "fin") {
            option = false;
        } else {
            nombres.push(pedirNombre);

        }


    }
        // Compara alfabeticamente de A --- Z
    nombres.sort((a,b) => a.localeCompare(b));
    alert(nombres);
}


/**
 * 
 * BLOQUE ||  DE REPASO Métodos slice, splice
 */

function repaso5(){

let codigos = ["HTML", "CSS", "JavaScript", "PHP", "Python"];

codigos.splice(1,1);
console.log(codigos);
console.log("-------------------");
codigos.splice(2,0, "SQL");
console.log(codigos);
console.log("-------------------");
codigos.splice(3,1, "NODE JS");
console.log(codigos);

alert(codigos);

}

function repaso6(){

    let codigos = ["HTML", "CSS", "JavaScript", "PHP", "Python"];

    let codigos2 = codigos.slice(0,3);
    console.log(codigos2+" codigos2");

    let codigos3 = codigos.slice(3,5);
    console.error(codigos3+" codigos3");


}


/**
 * 
 * BLOQUE 3 DE REPASO  Ordenación y cadenas
 */

function repaso7(){

    
    let insertarNum = prompt("Insertar numeros Separaods por(/)");
    let lista = insertarNum.split("/").map(Number)
    console.log(lista);

    lista.sort((a,b) => a - b);

    let resultado = lista.join("-");
    alert("Numeros ordenados: "+ resultado);
    
}


function repaso8(){

    // Ordenar palabras

    let palabras =  ["Mundo", "Adios Javier te veo en Madrid","Buenas tardes"];

    palabras.sort((a,b) => a.length - b.length);
    alert(palabras);
}


/**
 * 
 * BLOQUE 4  Métodos funcionales (map, filter, reduce, find...)
 */

function repaso9(){

        let notas = [];

     for(let i = 0; i < 15; i++) {
        let numeroRandom = Math.random() * 10 + 1;
        notas.push(numeroRandom);

    }
        //  Usa reduce para sumar el conjunto 
    let suma = notas.reduce((acumulador, valor) => acumulador + valor, 0);

    let media = suma / notas.length;
    
    console.info(media.toFixed(2));

    // usar math.max
    let notaMax = Math.max(...notas);

    // Buscar la posicion en la que esta
    let posicion = notas.indexOf(notaMax);

    console.log("Nota más alta:", notaMax.toFixed(2));
    console.log("Posición:", posicion); 
    


}


function repaso10(){
    let palabras = ["hola","dias", "Supermercado", "Santa Maria","Vietnam","Zeus"];

    let largas = palabras.filter(palabra => palabra.length > 6);
    console.log(largas);

        // palabra que termine por a
    let palabraConA = palabras.find(palabra => palabra[palabra.length -1] ==="a");
    console.warn(palabraConA);

    // devolver true si alguna palabra tiene la z
   // let contieneZ = palabras.some(palabra => palabra.toLowerCase().includes("z"));

    let contieneZ = palabras.some(palabra => palabra.includes("z")|| palabra.includes("Z"));
    console.log(contieneZ);


}

function repaso11(){
    let precios = [12.99, 24.5, 7.8, 15.75];

    // usar map 
   // let preciosConIVA = precios.map(precio => precio * 1.10);

    let preciosConIva = precios.map(precio => +(precio * 1.10).toFixed(2));

    // Calcular el precio total
    let gastoTotal = preciosConIva.reduce((acumulador, precio) => acumulador + precio, 0);
    alert(gastoTotal);

    alert("precio normal : "+precios);
    alert("precio IVA : "+preciosConIva);
     

   
}


/**
 * 
 * Bloque 5 – Copia y referencias
 */
    function repaso12(){
        original = [1,2,3];


        // Copia por referencia (ambos apuntan al mismo array)
        let copiaReferencia = original;

        // Copia independiente usando .slice()
        let copiaSlice = original.slice();

        // Modificamos la copia por referencia
        copiaReferencia.push(4);

        // Modificamos la copia creada con .slice()
        copiaSlice.push(99);

        console.log("Original:", original);
        console.log("Copia por referencia:", copiaReferencia);
        console.log("Copia con slice:", copiaSlice);



    }


/**
 * Extra (nivel examen)
 * 
 */

function repasoExamen(){

    let alumnos = [
    {alumno: "Carlos", nota: 6},
    {alumno: "Ana", nota: 8},
    {alumno: "Luis", nota: 7},
    {alumno: "Marta", nota: 9},
    {alumno: "Juan", nota: 5},
    {alumno: "Sofía", nota: 10},
    {alumno: "Pedro", nota: 4},
    {alumno: "Lucía", nota: 6},
    {alumno: "Jorge", nota: 4},
    {alumno: "Laura", nota: 8},
    {alumno: "Diego", nota: 2},
    {alumno: "Elena", nota: 7},
    {alumno: "Miguel", nota: 6},
    {alumno: "Isabel", nota: 8},
    {alumno: "David", nota: 5},
    {alumno: "Carla", nota: 9},
    {alumno: "Alberto", nota: 7},
    {alumno: "Patricia", nota: 6},
    {alumno: "Raúl", nota: 8},
    {alumno: "Verónica", nota: 10},
    ];

    //Crear otro array con filter y pasando parametros
    let aprobados = alumnos.filter(alumno => alumno.nota > 5);
    

    // mostrar aprobados con un forEach
    let mostrar = "Alumnos aprobados : ";
    aprobados.forEach(a => {
        mostrar += a.alumno +" : Nombre" + a.nota+" : nota"+" ";
    });

    alert(mostrar);
}
