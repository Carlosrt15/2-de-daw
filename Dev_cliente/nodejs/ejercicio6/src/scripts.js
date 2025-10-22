function darAlta(){

let nombre = document.getElementById("nombre").value;
let apellidos = document.getElementById("apellidos").value;
let dni = document.getElementById("dni").value;
let fecha = document.getElementById("fecha").value;

// mostrar sexo
let sexo = document.querySelector('input[name="sexo"]:checked');
let mostraSexo = sexo.value

// mostrar checkboxes
let seleccionadas = document.querySelectorAll('input[name="pref"]:checked');

let preferencias = Array.from(seleccionadas).map(input => input.value);

console.log(nombre,apellidos,dni,fecha,mostraSexo,preferencias);




}