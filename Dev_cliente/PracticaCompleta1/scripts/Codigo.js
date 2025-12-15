function verInfo() {
    let recuperarZonaDatos = document.getElementById("zonaDatos");
    recuperarZonaDatos.innerHTML = "";

    let crearH2 = document.createElement('h2');

    crearH2.textContent = 'Información de los artistas';
    recuperarZonaDatos.appendChild(crearH2);

  
    // Funcion parara recuperar los artista y Crear desplegable 
    let select2 = document.createElement("select");
    select2.id = "selectArtistas";
    recuperarZonaDatos.appendChild(select2);

    cargarArtistasEnSelect();



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

function cargarArtistasEnSelect() {
    fetch("http://localhost:3000/artistas")
        .then(respuesta => respuesta.json())
        .then(artistas => {


            artistas.sort((a, b) => a.nombre.localeCompare(b.nombre));

            let select = document.getElementById("selectArtistas");

            let opcionDefault = document.createElement("option");
            opcionDefault.textContent = "Selecciona un artista";
            opcionDefault.value = "";
            select.appendChild(opcionDefault);

            artistas.forEach(artistas => {
                let option =document.createElement("option");
                option.value = artistas.id;
                option.textContent = artistas.nombre;
                select.appendChild(option);
            });
            
        });
}
