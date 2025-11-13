// ejercicio 1

function ejercicio1() {

    let aviso = document.getElementsByTagName("button")[0];
    let pararAviso = document.getElementsByTagName("button")[1];

    let intervalo;

    // evento para el botón Aviso
    aviso.addEventListener("click", (e) => {
        // solo crear el intervalo si no hay uno activo
        if (!intervalo) {
            intervalo = setInterval(() => {
                alert("Este sábado a las 3 son las 2");
            }, 5000);
            console.log("click en Aviso");
        }
    });


    // evento para el botón Parar Aviso
    pararAviso.addEventListener("click", (a) => {
        clearInterval(intervalo);
        intervalo = null; // limpia la variable
        console.log("click en Parar Aviso");
    });


}

function dni() {
    let toamrP = document.getElementsByTagName("p")[0];
    let tomarBody = document.getElementsByTagName("body")[0];



    tomarBody.addEventListener("keydown", (e) => {
        console.log("Se pulso tecla");
        let tecla = e.key;
        alert(tecla);

        let a0 = "T";
        let a1 = "R";
        let a2 = "W";
        let a3 = "A";
        let a4 = "G";
        let a5 = "M";
        let a6 = "Y";
        let a7 = "F";
        let a8 = "P";
        let a9 = "D";
        let a10 = "X";
        let a11 = "B";
        let a12 = "N";
        let a13 = "J";
        let a14 = "Z";
        let a15 = "S";
        let a16 = "Q";
        let a17 = "V";
        let a18 = "H";
        let a19 = "L";
        let a20 = "C";
        let a21 = "K";
        let a22 = "E";




    });


}
dni();

ejercicio1();