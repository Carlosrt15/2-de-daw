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

        let eliminarBoton = document.getElementById("eliminar");
        eliminarBoton.addEventListener("click", (h) => {
            toamrP.innerHTML = "";
        });

    });

    // no se muestra bien o 
}


function randomColor() {
    let body = document.getElementsByTagName("body")[0];

    body.addEventListener("dblclick", (j) => {
        body.style.backgroundColor = "red";
    });

}
randomColor();
dni();

ejercicio1();


/**Ejercicio 4 */ // ------------------------------------------------

function comprobarString() {
    let pedirString = prompt("Introduce una cadena de texto ");

    // busca 10 digitos seguidos
    let regular = /[A-Za-z0-9]{10}/;


    //let regularFinal =/[A-Za-z0-9]{10}$/ el $ es para el final;

    if (regular.test(pedirString)) {
        alert("cumple con los 10 digitos seguidos");
    } else {
        alert("No cumple con los 10 digitos seguidos");


    }

    // pedir fecha 

    let pedirFecha = prompt("Introduce una fecha DD-MM-AAAA");

    let regularFecha = /[0-9]{2}-[0-9]{2}-[0-9]{4}/; // de 4 digitos
    //let regularFecha2 = /[0-9]{2}-[0-9]{2}-[0-9]{2}/; // con guiones

    if (regularFecha.test(pedirFecha)) {
        alert(" Si cumple con la fecha");
    } else {
        alert("No cumple con la fecha");


    }

    // pedir correo

    let pedirCorreo = prompt("Introduce un correo electronico");

    // dominio sea es, com, net u org    (parentesis para literales o agrupar)
    let comprobarCorreo = /[\dA-z]+[\DA-z]+\.(es|com|net|org)/; // si usas [] es que busca la letra exacta en los .es , etc..


    if (comprobarCorreo.test(pedirCorreo)) {
        alert("Si es un correo valido");
    } else {
        alert("No es un correo valido");
    }



}

comprobarString();