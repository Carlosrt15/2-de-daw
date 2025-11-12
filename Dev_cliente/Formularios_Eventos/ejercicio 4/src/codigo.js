function Comprobar() {
    let tomarEjemplo = document.getElementById("campoEjemplo").value;
    let tomarTlfn = document.getElementById("tlfn").value;
    let tomarObs = document.getElementById("observaciones").value;
    let tomarRadio = document.querySelector('input[name="prepago"]:checked');
    let tomarCompania = document.getElementById("compania").value;
    // Puede estar vacio
    let tomarFranjaHoraria = document.querySelector('input[name="franja"]:checked');

    //  Mostrar valor
    let mostrar1 = tomarRadio.value;
    let mostrar2 =  tomarFranjaHoraria.value;


    // comprobar que todos lo campos tiene un valor 

    let faltan = [];

    if (tomarEjemplo === "") faltan.push("Ejemplo");
    if (tomarTlfn === "") faltan.push("Teléfono");
    if (tomarObs === "") faltan.push("Observaciones");
    if (!tomarRadio) faltan.push("Prepago");
    if (tomarCompania === "") faltan.push("Compañía");
    if (!tomarFranjaHoraria) faltan.push("Horario");

    if (faltan.length === 0) {
        alert("los campos a excepciol de checbox tienen contenido");
            alert(tomarCompania + tomarTlfn + tomarObs + mostrar1 +  tomarEjemplo + mostrar2);
    } else {
        alert("Algunos campos estan vacios: " +faltan.join(","));
    }

}

