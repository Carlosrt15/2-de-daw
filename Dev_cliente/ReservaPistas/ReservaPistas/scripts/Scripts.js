function nuevoCalendario() {

    let formularioDeporte = document.getElementById("deporte").value;

    if(formularioDeporte === "") {
        alert("Esta vacio");
    }

    
}
let generado = true;

function cambiarColor() {

    // Se debe suponer que ya se abria generado todo de eso la variable generado true 

    let casilla1 = document.getElementById("casilla1");
    let casilla2 = document.getElementById("casilla2");
    let casilla3 = document.getElementById("casilla3");
    let casilla4 = document.getElementById("casilla4");
    let casilla5 = document.getElementById("casilla5");
    let casilla6 = document.getElementById("casilla6");
    let casilla7 = document.getElementById("casilla7");
    let casilla8 = document.getElementById("casilla8");
    let casilla9 = document.getElementById("casilla9");
    let casilla10 = document.getElementById("casilla10");
    let casilla11 = document.getElementById("casilla11");
    let casilla12= document.getElementById("casilla12");
    let casilla13 = document.getElementById("casilla13");
    let casilla14 = document.getElementById("casilla14");     
    let casilla15 = document.getElementById("casilla15");
    let casilla17 = document.getElementById("casilla17");
    let casilla18 = document.getElementById("casilla18");
    let casilla19 = document.getElementById("casilla19");
    let casilla20 = document.getElementById("casilla20");
    let casilla21 = document.getElementById("casilla21");
    let casilla22= document.getElementById("casilla22");
    let casilla23 = document.getElementById("casilla23");
    let casilla24 = document.getElementById("casilla24");
    let casilla25 = document.getElementById("casilla25");
    let casilla26 = document.getElementById("casilla26");
    let casilla27 = document.getElementById("casilla27");
    let casilla28 = document.getElementById("casilla28");
    let casilla29 = document.getElementById("casilla29");
    let casilla30 = document.getElementById("casilla30");
    let casilla16 = document.getElementById("casilla16");
    

    if(generado === true){
        
    casilla1.setAttribute('class','casillaSeleccionada'); 
     casilla2.setAttribute('class','casillaSeleccionada');  
     casilla3.setAttribute('class','casillaSeleccionada');   
     casilla4.setAttribute('class','casillaSeleccionada');  
     casilla5.setAttribute('class','casillaSeleccionada');   
     casilla6.setAttribute('class','casillaSeleccionada');   
     casilla7.setAttribute('class','casillaSeleccionada');   
     casilla8.setAttribute('class','casillaSeleccionada');   
     casilla9.setAttribute('class','casillaSeleccionada');   
     casilla10.setAttribute('class','casillaSeleccionada');   
     casilla11.setAttribute('class','casillaSeleccionada');   
        casilla12.setAttribute('class','casillaSeleccionada');  
     casilla13.setAttribute('class','casillaSeleccionada');   
     casilla14.setAttribute('class','casillaSeleccionada');  
     casilla16.setAttribute('class','casillaSeleccionada');        
     casilla15.setAttribute('class','casillaSeleccionada');  
        casilla17.setAttribute('class','casillaSeleccionada');   
     casilla18.setAttribute('class','casillaSeleccionada');   
        casilla19.setAttribute('class','casillaSeleccionada');   
     casilla20.setAttribute('class','casillaSeleccionada');   
     casilla21.setAttribute('class','casillaSeleccionada');   
     casilla22.setAttribute('class','casillaSeleccionada');  
     casilla23.setAttribute('class','casillaSeleccionada');   
        casilla24.setAttribute('class','casillaSeleccionada');   
     casilla25.setAttribute('class','casillaSeleccionada');  
     casilla26.setAttribute('class','casillaSeleccionada');   
        casilla27.setAttribute('class','casillaSeleccionada');  
        casilla28.setAttribute('class','casillaSeleccionada');  
        casilla29.setAttribute('class','casillaSeleccionada');
        casilla30.setAttribute('class','casillaSeleccionada');    

    } else if(generado === false) {

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
