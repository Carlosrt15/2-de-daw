function nuevoCalendario() {

    let formularioDeporte = document.getElementById("deporte").value;

    if(formularioDeporte === "") {
        alert("Esta vacio");
    }

    
}
let generado = true;

function cambiarColor(casilla) {

    if(generado) {
        casilla.className = "casillaSeleccionada";
    }
    
}

function aside(){

    let aside = document.getElementById("divAvisos")
    let html = "<p> </p>";

}

function parte5() {
    let numeroAleatorio = Math.floor(Math.random() * 40) + 1;
    let formularioDeporte2 = document.getElementById("deporte").value;
    let avisas = document.getElementById("divAvisos").value;

    let reservas = {
        deporte: formularioDeporte2,
        numeroReservas: numeroAleatorio
        };
        let URL = "http:localhost:3000/datos/reservas";
        let iniciar = {
            method: 'POST',
            body: JSON.stringify(reservas),
            headers: { 'Content-Type' : 'application/json'}
        };
    
    
    let completo = false;
    completo = true;
    if(completo === true){

        alert("Todo esta completo");

        fetch(URL,iniciar)
        .then(r => r.json())

        let td = document.getElementsByTagName("td");
        td.innerHtml = ""; 
        formularioDeporte2.innerHtml = "";
        avisas.innerHtml = "";
        
        



    }


}
