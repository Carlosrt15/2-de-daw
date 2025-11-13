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

function dni(){
    let toamrP = document.getElementsByTagName("p")[0];
    let tomarBody = document.getElementsByTagName("body")[0];
    


    tomarBody.addEventListener("keydown",(e)=> {
        console.log("Se pulso tecla");
        let tecla = e.key;
        alert(tecla);

    });


}
dni();

ejercicio1();