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


}