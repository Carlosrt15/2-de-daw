function Comprobar() {
    let tomarEjemplo = document.getElementById("campoEjemplo").value;
    let tomarTlfn = document.getElementById("tlfn").value;
    let tomarObs =  document.getElementById("observaciones").value;
    let tomarRadio = document.querySelector('input[name="prepago"]:checked');
    let tomarCompania = document.querySelector('input[name="compania"]:checked');
    // Puede estar vacio
    let tomarFranjaHoraria = document.querySelector('input[name="franja"]:checked');


    // comprobar que todos lo campos tiene un valor 
        if(tomarCompania != "" && tomarTlfn != "" && tomarObs != "" && tomarRadio != ""&& tomarEjemplo != ""){
            alert("los campos a excepcion de el checkbox tienen valor o fueron seleccionados ");
        } else {
            alert("Hay campos sin seleccionar o vacios ");

            //Continuar aqui 
            
        }

}

