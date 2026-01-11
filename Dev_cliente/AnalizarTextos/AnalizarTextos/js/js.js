

function comenzarAccion(accion) {

    const texto = document.getElementById('textArea').value;

    switch (accion) {
        case 'modificar':
            modificarTexto(texto);
            break;

        case 'palabras':
            ordenarPalabras(texto);
            break;
        case 'ocurrencias':
            calcularOcurrencias(texto);
            break;
        default:
            console.log("no reconoce");
    }


}


function modificarTexto(texto) {
    let modificarTexto = document.getElementById('textArea').value;

    let dividir = modificarTexto.split(',');
    let cambiarFinal = dividir.map(p => p.slice(0, -1) + "ria");
    console.log(cambiarFinal);

    // Recuperar las ultimas 10 palabras
    let ultimas = cambiarFinal.slice(-10);
    alert(ultimas);

}


function ordenarPalabras(texto) {
    let textoOrdena = document.getElementById('textArea').value;



}


function calcularOcurrencias(texto) {
    
    let calcularOcurrencia = document.getElementById('textArea').value;


    let dividir = calcularOcurrencia.split(','); 
    let empiezaPorX = dividir.some(p => p.startsWith("x"));

    // sin usar startsWith 
    // let empiezaPorX = dividir.some(p => p[0] ==="x");

     if(empiezaPorX === true){
        console.log("Hay palabras con x");
     }

     let palabrasMayores = dividir.every(p => p.length > 5);

     if(palabrasMayores === true && empiezaPorX === true) {
        console.log("Todas las palabras son > 5");

     }

}



