function darError() {
    let formulario = document.getElementById("formularioReserva");
    let errores = [];
    let expediente = document.getElementById("expediente").value;
    let expedienteError = document.getElementById("expedienteError").value;
    let email = document.getElementById("email").value;
    let emailError = document.getElementById("emailError").value;
    let fecha = document.getElementById("fecha").value;
    let fechaError = document.getElementById("fechaError").value;
    let hora = document.getElementById("hora").value;
    let horaError = document.getElementById("horaError").value;

    let textarea = document.getElementById("observaciones").value;
    let textareaError = document.getElementById("observacionesError").value;


    formulario.addEventListener("submit", (e) => {
        expedienteError.textContent = expediente.validationMessage;
        if (!expediente.validity.valid) {
            expediente.classList.add("error-input");
        }
        emailError.textContent = email.validationMessage;
        if (!email.validity.valid) {
            email.classList.add("error-input");
        }

        fechaError.textContent = fecha.validationMessage;
        if (!fecha.validity.valid) {
            fecha.classList.add("error-input");
        }

        horaError.textContent = hora.validationMessage;
        if (!hora.validity.valid) {
            hora.classList.add("error-input");
        }

        textareaError.textContent = textarea.validationMessage;
        if (!textarea.validity.valid) {
            textarea.classList.add("error-input");
        }




    });


}
function noEnviar() {
    const form = document.getElementById("formularioReserva");
    form.addEventListener("submit", (e) => {
        e.preventDefault();
        console.log("Formulario detenido");
    });

}

noEnviar();

darError();


function actualizarContador() {
    let primero = 230;
    let segundo = 250;
    let tomarObservaciones = document.getElementById("observaciones");
    tomarObservaciones.addEventListener("input", (f) => {

        if (tomarObservaciones.value == primero) {
            tomarObservaciones.classList.add("contador-advertencia");
        } else if (tomarObservaciones.value == segundo) {
            tomarObservaciones.classList.remove("contador-advertencia");
            tomarObservaciones.classList.add("contador-error");
        }

        for(let i = 0; tomarObservaciones.value <= 250; i++) {
            alert(i+"interaciones totales");
        }

    });

}

actualizarContador();

