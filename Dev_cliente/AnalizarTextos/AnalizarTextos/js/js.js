

function comenzarAccion(accion){
    // Tomar el campo donde escribe
    let texto = document.getElementById("textArea").value;
    let palabras = texto.split(" ").filter(p => p.length > 0);


    // selecionar 3 opciones 

    switch(accion) {

        case "modificar":
            let cambiarPalabra = palabras.map(palabra => palabra + "ria");
            console.log(cambiarPalabra);


            let ultimas10 = cambiarPalabra.slice(-10);
            alert(ultimas10);


        break;

        case "palabras":
            


        break;


        case "ocurrencias":
        // let textoMinus = texto.toLowerCase();
        // let siHayX = textoMinus.split(" ").some(letra => letra[0] === "x");

        // if(siHayX) {
        //     console.log("hay x");
        //     let masde5 = textoMinus.split(" ").every(palabra => palabra.length >= 5);
        //     if(masde5) {
        //         console.log("Todas las palabras tienen mas de 5 caracteres")
        //     }
        // }
        let hayX = palabras.some(p => p.toLowerCase().startsWith("x"));
        if(hayX) {
            console.log("Hay palabras que comienzan con 'X'");

        }
        let todasMas5 = palabras.every(p => p.length > 5);
        if (todasMas5) {
                    console.log("Todas las palabras tienen más de 5 letras");
                }

        break;
    }





}





