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
    h2.textContent = "Gestión de Artistas";
    recuperarZonaDatos.appendChild(h2);

    // Select CRUD
    let select = document.createElement("select");
    select.id = "Select";

    let default2 = document.createElement("option");
    default2.textContent = "Selecciona una opción CRUD";
    default2.value = "";
    select.appendChild(default2);

    let alta = document.createElement("option");
    alta.textContent = "Dar Alta";
    alta.value = "Alta";
    select.appendChild(alta);

    let baja = document.createElement("option");
    baja.textContent = "Dar Baja";
    baja.value = "Baja";
    select.appendChild(baja);

    let modificar = document.createElement("option");
    modificar.textContent = "Modificar";
    modificar.value = "Modificar";
    select.appendChild(modificar);

    recuperarZonaDatos.appendChild(select);

    recuperarZonaDatos.appendChild(document.createElement("br"));
    recuperarZonaDatos.appendChild(document.createElement("br"));

    // Botón CRUD
    let crearBoton = document.createElement("button");
    crearBoton.textContent = "Efectuar Acción del CRUD";
    crearBoton.id = "BtnCrud";
    recuperarZonaDatos.appendChild(crearBoton);

    // Contenedor formulario
    let contenedorForm = document.createElement("div");
    contenedorForm.id = "contenedorForm";
    contenedorForm.style.marginTop = "20px";
    recuperarZonaDatos.appendChild(contenedorForm);

    // Formulario genérico
    let form = document.createElement("form");
    form.id = "formCrud";
    form.style.display = "none";

    let h3 = document.createElement("h3");
    h3.id = "tituloForm";

    let inputId = document.createElement("input");
    inputId.id = "idArtista";
    inputId.placeholder = "ID del artista";

    let inputNombre = document.createElement("input");
    inputNombre.id = "nombreArtista";
    inputNombre.placeholder = "Nombre del artista";

    let inputGenero = document.createElement("input");
    inputGenero.id = "generoArtista";
    inputGenero.placeholder = "Género musical";

    let btnSubmit = document.createElement("button");
    btnSubmit.type = "submit";
    btnSubmit.id = "btnSubmit";

    form.append(
        h3,
        inputId, document.createElement("br"),
        inputNombre, document.createElement("br"),
        inputGenero, document.createElement("br"),
        btnSubmit
    );

    contenedorForm.appendChild(form);

    // Evento botón CRUD
    crearBoton.addEventListener("click", () => {
        let opcion = document.getElementById("Select").value;

        form.style.display = "block";

        inputId.style.display = "none";
        inputNombre.style.display = "none";
        inputGenero.style.display = "none";

        if (opcion === "Alta") {
            h3.textContent = "Alta de Artista";
            inputNombre.style.display = "block";
            inputGenero.style.display = "block";
            btnSubmit.textContent = "Guardar";

        } else if (opcion === "Baja") {
            h3.textContent = "Baja de Artista";
            inputId.style.display = "block";
            btnSubmit.textContent = "Eliminar";

        } else if (opcion === "Modificar") {
            h3.textContent = "Modificar Artista";
            inputId.style.display = "block";
            inputNombre.style.display = "block";
            inputGenero.style.display = "block";
            btnSubmit.textContent = "Modificar";

        } else {
            form.style.display = "none";
            alert("Selecciona una opción CRUD");
        }
    });

    // Submit formulario
    form.addEventListener("submit", (e) => {
        e.preventDefault();

        let opcion = document.getElementById("Select").value;
        let id = inputId.value;
        let nombre = inputNombre.value;
        let genero = inputGenero.value;

        if (opcion === "Alta") {
            console.log("ALTA", nombre, genero);
        }

        if (opcion === "Baja") {
            console.log("BAJA", id);
        }

        if (opcion === "Modificar") {
            console.log("MODIFICAR", id, nombre, genero);
        }

        form.reset();
    });
}