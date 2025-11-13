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

    const letrasDni = [
        "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
        "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L",
        "C", "K", "E"
    ];

    tomarBody.addEventListener("keydown", (e) => {
        console.log("Se pulso tecla");
        let tecla = e.key.toUpperCase();
        alert(tecla);

        if (letrasDni.includes(tecla)) {


            let resultado = [];

            for (let i = 1; i <= 9999; i++) {
                let total = i % 23;
                if (letrasDni[total] === tecla) {
                    resultado.push(tecla);
                }

            }
            toamrP.innerHTML = `el resultado es:  ${resultado}`;
            console.log("entra aqui1");

        } else {
            toamrP.innerHTML = "";
            console.log("entra aqui2");
        }

    });

        // no se muestra bien o 
}
dni();

ejercicio1();