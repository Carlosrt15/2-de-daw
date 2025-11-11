window.onload = function () {
  const tabla = document.getElementById("tablaDatos");
  tabla.addEventListener(
    "click",
    crearNuevaFila.bind(tabla),
    false
  );
};


//Ejemplo Punto 1.7 de los apuntes
function crearNuevaFila() {
  let numFilas = this.childElementCount;

  let fila = document.createElement("tr");
  fila.id = numFilas;

  let celda1 = document.createElement("td");
  celda1.textContent = numFilas + 1;

  let celda2 = document.createElement("td");
  celda2.textContent = numFilas + 2;

  fila.appendChild(celda1);
  fila.appendChild(celda2);

  fila.addEventListener("click", (event)=>{
    alert("ID:" + event.currentTarget.id)
    event.stopPropagation();
  },
  false
);

this.appendChild(fila);

}


