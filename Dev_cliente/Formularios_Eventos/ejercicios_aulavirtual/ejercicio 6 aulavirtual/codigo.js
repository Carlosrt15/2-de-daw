function colorAmarillo(){
        // Tomar sin value da error
    let tomaColor = document.getElementById("color");
    console.log(tomaColor);

    tomaColor.value = "#f6b73c";
    console.log(tomaColor.value +" El color  ");

}

function validarCampoVacio(){
    let tomarNombre = document.getElementById("nombre");
    let tomarFecha = document.getElementById("fecha");
    let tomarTlfn = document.getElementById("telefono");
    let tomarBuscar = document.getElementById("buscar"); 

    validarCampo(tomarNombre);
    validarCampo(tomarFecha);
    validarCampo(tomarTlfn);
    validarCampo(tomarBuscar);
    


}

function validarCampo(campo) {
    if(campo.value.trim() === "") {
        campo.classList.add('vacio');
    } else {
        campo.classList.remove('vacio');
    }
}


function validarCampoVacio(){
    let tomarNombre = document.getElementById("nombre");
    let tomarFecha = document.getElementById("fecha");
    let tomarTlfn = document.getElementById("telefono");
    let tomarBuscar = document.getElementById("buscar"); 
    let colorFavorito = document.getElementById("colorFavorito").value;

    validarCampo(tomarNombre, /^[a-zA-Z\s]+$/, "labelNombre", colorFavorito); 
    validarCampo(tomarFecha, /^\d{4}-\d{2}-\d{2}$/, "labelFecha", colorFavorito); 
    validarCampo(tomarTlfn, /^\d{9}$/, "labelTelefono", colorFavorito); // 9 dígitos
    validarCampo(tomarBuscar, /.+/, "labelBuscar", colorFavorito); // cualquier texto
}

function validarCampo(campo, regex, labelId, colorFavorito) {
    let label = document.getElementById(labelId);

    if(campo.value.trim() === "") {
        campo.classList.add('vacio');
        campo.classList.remove('incorrecto');
        label.style.color = ""; 

    } else if(!regex.test(campo.value.trim())) {
        campo.classList.remove('vacio');
        campo.classList.add('incorrecto');
        campo.style.borderColor = colorFavorito;
        label.style.color = colorFavorito;
    } else {
        campo.classList.remove('vacio');
        campo.classList.remove('incorrecto');
        campo.style.borderColor = "";
        label.style.color = "";
    }
}

function coloreaLabel(){
    let labels = document.querySelectorAll("label");

    labels.forEach(label => {
        let id = label.getAttribute("for");
        let input = document.getElementById(id);

            label.addEventListener("mouseover", () => {
                input.classList.add("resaltado");
            });

            label.addEventListener("mouseout", ()=> {
                input.classList.remove("resaltado");
            });
    });
}

coloreaLabel();

validarCampoVacio();