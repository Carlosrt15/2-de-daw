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