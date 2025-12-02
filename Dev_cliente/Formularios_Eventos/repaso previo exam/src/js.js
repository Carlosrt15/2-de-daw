let idAviso;

function aviso() {
    let tomarAviso = document.getElementById("btnAviso");
    let pararAviso = document.getElementById("btnParar");

    //Crea el aviso 

    tomarAviso.addEventListener("click", () => {

        if (!idAviso) {
            idAviso = setInterval(() => {
                alert("interavlo cada 5 segundos");

            }, 5000);
        }

    });

    pararAviso.addEventListener("click", () => {
        clearInterval(idAviso);
        idAviso = null;
    });

}

aviso();

function letraDni() {
    let tomarLetra = document.getElementById("infoTecla");
    const letrasDni = [
        "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
        "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L",
        "C", "K", "E"
    ];

    document.addEventListener("keydown", (event) => {
        let tecla = event.key.toLocaleUpperCase();

        if (!/^[A-Z]$/.test(tecla)) {
            tomarLetra.innerHTML = "";
            return;
        }

        let coincide = [];

        for (let i = 1; i <= 9999; i++) {
            let numero = i.toString().padStart(4, "0");
            let letraCorrecta = letrasDni[i % 23];

            if (letraCorrecta === tecla) {
                coincide.push(numero + letraCorrecta);
            }
        }
        tomarLetra.innerHTML = `
            <strong>Letra pulsada:</strong> ${tecla}<br>
            <strong>Total DNIs encontrados:</strong> ${coincide.length}<br>
            <strong>DNIs:</strong><br>
            ${coincide.join(", ")}
        `;


    });


}
letraDni();


function cambiarColor(){
    let tomarCuerpo = document.getElementsByTagName("body")[0];

    tomarCuerpo.addEventListener("dblclick", () => {
        tomarCuerpo.classList.add("Rojo");


    });
}
cambiarColor();

function ValidarForm(){
    let tomarDni = document.getElementById("dni").value;
    let validarDni = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i; // Valida DNI bien 

    if(validarDni.test(tomarDni)) {

    } else {
        alert("El dni introducido no es valido");
        return false;
    }

    let letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    let numero = tomarDni.substring(0,8);
    let letra =  tomarDni.substring(8).toUpperCase();
    let letraCorrecta = letras[numero % 23];

    if(letra === letraCorrecta) {
        alert("Dni Correcto");
    } else{
        alert("Dni la letra no coincide");
    }
    // Validar Correo 

    let TomarCorreo = document.getElementById("email").value;
    
    let ValidacionCorreo = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // Correo Normal
    let ValidarCorreoClasanz =  /^[a-zA-Z0-9._%+-]+@(gmail\.com|hotmail\.com|calasanzsalamanca\.com)$/i;

    if(!ValidarCorreoClasanz.test(TomarCorreo)) {
        return false;
    }


    

}

