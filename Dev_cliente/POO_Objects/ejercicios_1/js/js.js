function ejercicio1() {

    let cadenaNotas = [];
    
    let entrada = prompt("Introduce notas separado por comos : [Ejemplo: 65,4,76,1]");

    let notas = entrada.split(",").map(Number);


    cadenaNotas.push(notas);
    alert(cadenaNotas);


    let suma = 0;
    for (let nota of notas) {
        suma += nota;
    }
    let media = suma / notas.length;

    console.log("La nota media es: "+media);

    console.log("La nota media (1 decimal) es: "+media.toFixed(1));

    



    

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
alert(Math.max(numeroAleatorio1.toFixed(2),numeroAleatorio2.toFixed(2),numeroAleatorio3.toFixed(2)));

}

function ejercicio7() {



}