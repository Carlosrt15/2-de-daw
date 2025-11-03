

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
    let textoModifica = document.getElementById('textArea').value;

}


function ordenarPalabras(texto) {
    let textoOrdena = document.getElementById('textArea').value;

}


function calcularOcurrencias(texto) {

    let textoOcu = document.getElementById('textArea').value;

    let palabras = textoOcu.split(',');

    let tieneX = palabras.some(p => p.startsWith("x"));

    if (tieneX === true) {
        console.log("Hay palabras que empiezan por X");
    };


    let palabrasMas5 = palabras.every(p => p.length > 5);

    if (palabrasMas5 === true) {
        console.log("Todas tienen mas de 5 letras");
    };


}



