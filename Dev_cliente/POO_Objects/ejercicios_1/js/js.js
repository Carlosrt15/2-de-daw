function ejercicio1() {


    let entrada = prompt("Introduce notas separadas por comas: [Ejemplo: 65.4,76.2,89.9,70.5]");
    let notas = entrada.split(",").map(Number);


    let respuesta = prompt("¿Quieres redondear las notas hacia arriba? (sí/no)").toLowerCase();
    let notasRedondeadas = [];

    if (respuesta === "sí" || respuesta === "si") {
        notasRedondeadas = notas.map(n => Math.ceil(n));
        console.log("Redondeadas hacia arriba:", notasRedondeadas);
        console.log("La menor nota es:", Math.min(...notasRedondeadas));

    } else {
        notasRedondeadas = notas.map(n => Math.floor(n));
        console.log("Redondeadas hacia abajo:", notasRedondeadas);
        console.log("La mayor nota es:", Math.max(...notasRedondeadas));
    }

    let suma = 0;
    
    for (let nota of notasRedondeadas) suma += nota;
    let media = suma / notasRedondeadas.length;

    alert("Notas redondeadas: " + notasRedondeadas.join(", "));
    alert("Nota media (3 decimales): " + media.toFixed(3));
}



function ejercicio2() {

    pedirNumero = Number(prompt("Introduce un numero"));


    if(!isNaN(pedirNumero) && pedirNumero % 1 === 0) {
        cubo = pedirNumero * pedirNumero * pedirNumero;
        alert(cubo+ " : es el cubo de : "+pedirNumero);

    } else {
        alert(" El valor introducido no es un numero o no es un numero entero")
    }
}

function ejercicio3(){
    let letra = "TRWAGMYFPDXBNJZSQVHLCKE";
    let pedirNumerosDni = prompt("Introduce los 8 digitos del DNI");
    pedirNumerosDni = Number(pedirNumerosDni);

    if(pedirNumerosDni >= 0 && pedirNumerosDni <= 99999999) {
        let letraDni = letra[pedirNumerosDni % 23];
        alert("La letra es :" + letraDni);

    } else {
        alert("DNI invalido. Debe tener 8 digitos");
    }

    
}

var cadena = "Hola Soy Felix RODRIGUEZ, tengo 24 años de Edad.";

function ejercicio4(cadena) {
    let resultado =  cadena.toLowerCase();
    
    let nuevaCadena = "";

    for(let i = 0; i < resultado.length; i++) {
        if(i % 2 === 0) {
            nuevaCadena += resultado[i];
        }

    }

    let busqueda = nuevaCadena.includes("aviko");

    console.warn(busqueda);

    

}

/*
Ejercicios de Math
------------------
*******************
/**************** */

function ejercicio5(){
    let numeroAleatorio = Math.random() * (200 - 10) +10;

    console.log(numeroAleatorio.toFixed(0));
}

function ejercicio6(){
let numeroAleatorio1 = Math.random() * (100 - 1) +1;
let numeroAleatorio2 = Math.random() * (100 - 1) +1;
let numeroAleatorio3 = Math.random() * (100 - 1) +1;

//Mostrar el mayor Math.max
alert(Math.max(numeroAleatorio1.toFixed(2),numeroAleatorio2.toFixed(2),numeroAleatorio3.toFixed(2)));

}

