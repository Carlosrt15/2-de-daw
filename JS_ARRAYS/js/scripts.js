function insertarNombres() {

    let nombreLargo = [];
    let nombreCorto = [];

    for(let i = 0; i < 5; i++) {


    let nombreInsertado = prompt("Introduce un Nombre");

    if(nombreInsertado.length < 5) {
        nombreCorto.push(nombreInsertado);

    } else {
        nombreLargo.push(nombreInsertado);
    }


    }

    console.log(nombreLargo + " Nombre largo");
    console.log(nombreCorto + " Nombre corto");


    

    
}


// Ejercici 1 de arrays

function ejercicio1() {

    let numeros = [];

    let opcion = false;

    while(!opcion) {

     let introduceNumero = (prompt("Introduce un numero"));
     

     let introducePersona = prompt("Introduce un Nombre");   

     let check = confirm("Confirmas el nombre : "+ introducePersona+ " Confirmas el numero: " +introduceNumero);

        if(check == true) {

            if(introduceNumero >= 0 ){
                    numeros.splice(introduceNumero,0,introducePersona);
            } else {
                numeros.push(introducePersona);

            }

        } else {

            if(introduceNumero >= 0) {
                  numeros.splice(introduceNumero,1);  

            } else if(introduceNumero < 0){
                numeros.shift();


            }

        } 

        if(isNaN(introduceNumero)) {
            opcion = true;

            console.log(numeros);
        }
    }

}

function ejercicio2 () {

    let cosas = ["tela","bies", "hilo", "tijeras","máquina de coser", "botón"];

    cosas.splice(1,1);
    console.log(cosas);

    cosas.splice(3,0,"hilo torzal");
    console.log(cosas);

    cosas.splice(3,3, "Cuter rotatorio", "mesa de corte");
    console.log(cosas);

    let a1 = cosas.slice(0,3);
    console.log(a1);

    let a2 = cosas.slice(3,6);
    console.warn(a2);

    a2.splice(0,0,"remalladora");
    console.warn(a2);

    a2.splice(0,0,"remalladora");

a2.splice(-1,0,"cinta métrica");
    
console.log("Contenido de los 3 arrays");

console.log("---------------------------------");
console.log(cosas +" Contenido cosas");
console.log(a1+ "  Contenido a1");
console.log(a2 + "  Contenido a2");

}

/*
Ejercicio 3
*/
function ejercicio3() {
     let cosas = ["Almeria", "Salamanca", "León", "Madrid", "Berlin","Kansas", "Estados Unidos ",""];


    cosas.sort(function(a,b) {
    return b.length - a.length; // de mayor a menor segun la cantidad
   
});
    console.warn(cosas);
    alert(cosas);
}