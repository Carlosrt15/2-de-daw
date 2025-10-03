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