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