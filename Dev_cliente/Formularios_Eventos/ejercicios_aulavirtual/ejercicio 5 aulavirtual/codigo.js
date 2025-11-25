function comprobarDni() {

    const letrasDni = [
        "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
        "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L",
        "C", "K", "E"
    ];

    let tomarDni = document.getElementById("dni").value;

    let numero = tomarDni.substring(0, 8); // primeros 8 caracteres
    let letra = tomarDni.substring(8).toUpperCase(); // ultimo caracter letra


    let resto = numero % 23;
    console.log(resto);
    let letraCorrecta = letrasDni[resto];

    if (letra === letraCorrecta) {
        alert("DNI correcto");
    } else {
        alert("DNI incorrecto");

    }
}

function comprobarCorreo() {
    let tomarCorreo = document.getElementById("correo").value;
    let comprobar = /@(gmail\.com|hotmail\.com|calasanzsalamanca\.com)$/i;

    if (comprobar.test(tomarCorreo)) {
        alert("Correo correcto");
    } else {
        alert("Correo incorrecto");
    }
    console.log(tomarCorreo);
}

function comprobarTexto() {
    let tomarTexto1 = document.getElementById("texto1").value;
    let tomarTexto2 = document.getElementById("texto2").value;

    if (tomarTexto1 !== "" && tomarTexto2 !== "") {

        ordenar1 = tomarTexto1.toUpperCase().split('').sort().join('');
        ordenar2 = tomarTexto2.toUpperCase().split('').sort().join('');

        return ordenar1 === ordenar2;



    } else {
        alert("No se han introducido textos");

    }


}

function comprobarAnagrama() {

    let resultado = comprobarTexto();

    if (resultado === true) {
        console.log("Son anagramas");
    } else {
        console.log(" No son anagramas");
    }
}

function selectorDePais() {
    let tomaPais = document.getElementById("Pais").value;
    let tomarCapital = document.getElementById("capitales");

    tomarCapital.innerHTML = "";

    let opciones = [];


    if (tomaPais === "España") {

        opciones = ["Madrid", "Salamanca", "Zaragoza"];

    } else if (tomaPais === "Francia") {
        opciones = ["Paris", "Burdeos", "Niza"];

    } else if (tomaPais === "Irlanda") {
        opciones = ["Dublín", "Cork", "KillKenny"];
    } else {
        alert("Pais no seleccionado");
    }

    opciones.forEach(ciudad => {
        let opcion = document.createElement("option");
        opcion.value = ciudad;
        opcion.textContent = ciudad;
        tomarCapital.appendChild(opcion);
    });

}
