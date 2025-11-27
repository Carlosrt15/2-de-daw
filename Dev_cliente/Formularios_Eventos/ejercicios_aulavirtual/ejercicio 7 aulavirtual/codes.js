function valoresIncompatibles() {
    let condicion = false;
    let opcionApartamento = document.getElementById("alojamiento").value;
    let tomarMontana =  document.getElementById("montana");
     let tomarMeseta =  document.getElementById("meseta");
       
    if (opcionApartamento === "apartamento") {
        condicion = true;
    }

    if(tomarMeseta.cheked && tomarMontana.cheked && condicion === true) {


    }



}
valoresIncompatibles();