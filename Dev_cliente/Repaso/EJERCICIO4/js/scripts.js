function multiplicar() {

    const n1 = Number(document.getElementById("numero1").value);
    const n2 = Number(document.getElementById("numero2").value);

    if(isNaN(n1) || n1 <= 0) {

        alert("El primer valor debe ser numérico y positivo");
        document.getElementById("numero1").value = "";
            return;
    }


    if(isNaN(n2) || n2 <= 0) {

        alert("El segundo valor debe ser numérico y positivo");
        document.getElementById("numero2").value = "";
            return;
    }

    document.getElementById("resultado").value = n1 * n2 ;

}





function dividir() {

    const n1 = Number(document.getElementById("numero1").value);
    const n2 = Number(document.getElementById("numero2").value);

    if(isNaN(n1) || n1 <= 0) {

        alert("El primer valor debe ser numérico y positivo");
        document.getElementById("numero1").value = "";
            return;
    }


    if(isNaN(n2) || n2 <= 0) {

        alert("El segundo valor debe ser numérico y positivo");
        document.getElementById("numero2").value = "";
            return;
    }

    document.getElementById("resultado").value = n1 / n2 ;

}