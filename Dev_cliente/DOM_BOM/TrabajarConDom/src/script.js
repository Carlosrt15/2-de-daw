"use strict"

/*ejercicio2*/

function ejercicio2(){
    let tomarPrimera = document.getElementById("seccionPrimera");
    let primerParrafo = tomarPrimera.querySelector("p");
    //Mostrar el contenido 
    alert(primerParrafo.textContent+"Primer elemento");

   //  mostrar 3 elemento
   
  let tomar3elemento = tomarPrimera.getElementsByTagName('p')[2];
  alert(tomar3elemento.textContent+"tercer elemento");

// lista 
let tomarLista = document.getElementById("seccionSegunda");
    let ultimoElemento = tomarLista.getElementsByTagName("ul")[0];
    alert(ultimoElemento.lastChild.textContent);

}