





function comenzarAccion(ocurrencias){
    let tomarTexto = document.getElementById("textArea").value;
    
   
    let palabras = [];
    palabras.push(tomarTexto);
    alert(palabras);
    

    let palabrasConx = palabras.some(palabra => palabra.starsWith("x"));

    if(palabrasConx == true){
        console.info("Si hay palabras con x");
    } else {

    }
    
    let palabrasMayor = palabras.every(palabra => palabra.length > 5);

    if(palabrasMayor == true) {
        console.log("Todas las palabras tienen mas de 5 letras")

    } else{

    }

     

}

