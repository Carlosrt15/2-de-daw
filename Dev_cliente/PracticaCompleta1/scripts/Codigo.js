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
                let option = document.createElement("option");
                option.value = artistas.id;
                option.textContent = artistas.nombre;
                select.appendChild(option);
            });

        });
}

function gestionArtistas() {
    let recuperarZonaDatos = document.getElementById("zonaDatos");
    recuperarZonaDatos.innerHTML = "";

    let h2 = document.createElement("h2");
    h2.textContent = "Gestion de Artistas";
    recuperarZonaDatos.appendChild(h2);

    //Crear select 
    let select = document.createElement("select");

    let default2 = document.createElement("option");
    default2.textContent = "Selecciona una opcion CRUD";
    default2.value = ""
    select.appendChild(default2);

    let alta = document.createElement("option");
    alta.textContent = "Dar Alta";
    alta.value = "Alta"
    select.appendChild(alta);

    let Baja = document.createElement("option");
    Baja.textContent = "Dar Baja";
    Baja.value = "Baja"
    select.appendChild(Baja);

    let modificar = document.createElement("option");
    modificar.textContent = "Modificar";
    modificar.value = "Modificar"
    select.appendChild(modificar);

    recuperarZonaDatos.appendChild(select);

    select.id = "Select";

    let br1 = document.createElement("br");
    let br2 = document.createElement("br");

    recuperarZonaDatos.appendChild(br2);
    recuperarZonaDatos.appendChild(br1);

    //Crear el boton
    let crearBoton = document.createElement("button");
    crearBoton.textContent = "Efectuar Accion del CRUD";
    crearBoton.id = "BtnCrud";
    recuperarZonaDatos.appendChild(crearBoton);

    // tomar los select


    let tomarBtn = document.getElementById("BtnCrud");



    tomarBtn.addEventListener("click", () => {
        let tomarSelect = document.getElementById("Select").value;

        if (tomarSelect === "Alta") {
            console.log("Alta");
        } else if (tomarSelect === "Baja") {
            console.log("Baja");
        } else if (tomarSelect === "Modificar") {
            console.log("Modificar");
        } else {

        }

    });




}

