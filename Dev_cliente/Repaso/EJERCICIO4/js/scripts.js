function multiplicar() {

    const n1 = Number(document.getElementById("numero1").value);
    const n2 = Number(document.getElementById("numero2").value);

    if (isNaN(n1) || n1 <= 0) {

        alert("El primer valor debe ser numérico y positivo");
        document.getElementById("numero1").value = "";
        return;
    }


    if (isNaN(n2) || n2 <= 0) {

        alert("El segundo valor debe ser numérico y positivo");
        document.getElementById("numero2").value = "";
        return;
    }

    document.getElementById("resultado").value = n1 * n2;

}





function dividir() {

    const n1 = Number(document.getElementById("numero1").value);
    const n2 = Number(document.getElementById("numero2").value);

    if (isNaN(n1) || n1 <= 0) {

        alert("El primer valor debe ser numérico y positivo");
        document.getElementById("numero1").value = "";
        return;
    }


    if (isNaN(n2) || n2 <= 0) {

        alert("El segundo valor debe ser numérico y positivo");
        document.getElementById("numero2").value = "";
        return;
    }

    document.getElementById("resultado").value = n1 / n2;

}


function sumar() {

    const n1 = Number(document.getElementById("numero1").value);
    const n2 = Number(document.getElementById("numero2").value);

    if (isNaN(n1) || n1 <= 0) {

        alert("El primer valor debe ser numérico y positivo");
        document.getElementById("numero1").value = "";
        return;
    }


    if (isNaN(n2) || n2 <= 0) {

        alert("El segundo valor debe ser numérico y positivo");
        document.getElementById("numero2").value = "";
        return;
    }

    document.getElementById("resultado").value = n1 + n2;

}


function PedirNumero() {

    let numero = Number(prompt("Inserta un numero"));

    const numeroAleatorio = Math.floor(Math.random() * 100) + 1;

    while (numero != numeroAleatorio) {

        if (numero < numeroAleatorio) {
            alert("mas alto");

        } else if (numero > numeroAleatorio) {

            alert("mas bajo");
        } else if (isNaN(numero)) {

            alert("Eso no es un numero");
        }
        console.log(numeroAleatorio);
        numero = Number(prompt("Inserta un numero"));

    }

    alert("acertaste");






}



function ejercicio5(){

    let coloresIntroducidos = [];

    let contadorRojo = 0;
    let contadorVerde = 0;
    let contadorOtrocolor = 0;

   let option = false;
    while(!option ) {

        let pedirColorUsuario = prompt("Introduce un color");

        switch(pedirColorUsuario) {
                case "rojo":
                    coloresIntroducidos.push(pedirColorUsuario);    
                    option = true;
                    contadorRojo++;
                    break;

                    case "verde":
                        contadorVerde++;
                        coloresIntroducidos.push(pedirColorUsuario); 
                        continue;

                        default :
                            contadorOtrocolor++;
                           coloresIntroducidos.push(pedirColorUsuario); 

        }



    }
    let longitudColores = coloresIntroducidos.length;
    alert(coloresIntroducidos + " Metiste esta cantidad de colores: "+ longitudColores);
    alert("El rojo: "+contadorRojo+ " contador de verde: "+contadorVerde+ " otros colores: "+contadorOtrocolor);



}