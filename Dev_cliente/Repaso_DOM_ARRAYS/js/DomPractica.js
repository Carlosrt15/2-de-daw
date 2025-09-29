function cambiaColoresTabla() {

        // Tomar la tabla

     const tabla = document.getElementById('userTable');

     const ths = tabla.querySelectorAll('th');

     // Asigarn evento a todos los th

     ths.forEach((th, index) => {
        th.onclick = function() {

            // Selecionar tr
            const filas = tabla.querySelectorAll('tbody tr');

            // Limpiar colores previos
            filas.forEach(filas => {
                filas.cells[index].style.backgroundColor = '';
            });

            //Colorear los td de la columna clikeada
            filas.forEach(filas => {
                filas.cells[index].style.backgroundColor = 'lightblue';
            });

            

        }

     });
     


}



function cambiarSelect() {
    const nameInput = document.getElementById("name");
    const ageInput = document.getElementById("age");
    const  citySelect = document.getElementById("city");

    citySelect.addEventListener("change",function(){
        const ciudad = citySelect.value;

        // Quitar los colores
        nameInput.style.backgroundColor = "";
        ageInput.style.backgroundColor = "";

        // Cambiar colores segun la opcion de la cioudad

        if (ciudad === "Madrid") {
            nameInput.style.backgroundColor = "Red";
            ageInput.style.backgroundColor = "Red";
        } else if (ciudad === "Barcelona") {
            nameInput.style.backgroundColor = "Green";
            ageInput.style.backgroundColor = "Green";

        } else if (ciudad === "Valencia") {
            nameInput.style.backgroundColor = "lightpink";
            ageInput.style.backgroundColor = "lightpink";
        }
    });


}

document.addEventListener("DOMContentLoaded",function(){
    cambiaColoresTabla();
});

document.addEventListener("DOMContentLoaded",function(){
    cambiarSelect();
});