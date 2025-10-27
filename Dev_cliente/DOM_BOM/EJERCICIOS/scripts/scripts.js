function cambiarTexto() {

    let modificarTexto = document.getElementById("tituloPrincipal");
    let modificarColor = document.getElementById("parrafoIntro");

    if(modificarTexto) {
    modificarTexto.innerHTML = "DOM Manipulado con Éxito";
    }else {
        alert("No existe ningun titulo");
    }


    // Modificar color
    modificarColor.style.backgroundColor = "lightblue";



        // modifica el borde de la caja
    let primeraCaja = document.querySelector(".caja");

    primeraCaja.style.border = " 2px solid red";



    // tomar todos los li y cambiar su color
    let todosItems = document.querySelectorAll(".item");

   todosItems.forEach(item => {
    item.style.color = "blue";
   });

   //Seleccionar una imagen 

   let imagen = document.querySelector("#imagenDemo");

    imagen.src = "nueva_imagen.png";
    imagen.alt = "Nueva Imagen Cargada";
    
     

}