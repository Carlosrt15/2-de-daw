function verInfo() {
    let recuperarZonaDatos = document.getElementById("zonaDatos");
    recuperarZonaDatos.innerHTML = "";

    let crearH2 = document.createElement('h2');

    crearH2.textContent = 'Información de los artistas';
    recuperarZonaDatos.appendChild(crearH2);

    // Crear tabla ---------------------------
    let tabla = document.createElement("table");
    let thead = document.createElement("thead");
    let filaCabecera = document.createElement("tr");

    let thConcierto = document.createElement("th");
    thConcierto.textContent = "Concierto";

    let thLugar = document.createElement("th");
    thLugar.textContent = "Lugar";

    let thFecha = document.createElement("th");
    thFecha.textContent = "Fecha";

    filaCabecera.appendChild(thConcierto);
    filaCabecera.appendChild(thLugar);
    filaCabecera.appendChild(thFecha);
    thead.appendChild(filaCabecera);
    tabla.appendChild(thead);

    let tbody = document.createElement("tbody");
    tabla.appendChild(tbody);

    recuperarZonaDatos.appendChild(tabla);





}

