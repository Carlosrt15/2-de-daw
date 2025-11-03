function boton1() {
  let idTimeout = setTimeout(() => {
    alert("Hola usuarios pasados 5 segundos");
  }, 5000);

  let idTimeout2 = setTimeout(() => {
    alert("Hola usuarios pasados 7 segundos");
  }, 7000);
}

let i = 1;
let intervalo = null;

function boton2() {
  if (intervalo === null) {
     intervalo = setInterval(() => {
      console.log("Intervalo cada 3 segundos");
      i++
    }, 3000);
  } else {
    console.log("Quitando...");
    clearInterval(intervalo);
    intervalo = null;

    i = 1;
  }
}

/**Ejercicio 9 */

function mostrarVentana(){

   let ventanaNueva = window.open("", "pop-up", "toolbar=No,width=500,height=300,menubar=No,scrollbars=No,screenY=300,screenX=300");

   ventanaNueva.document.write(`
    <html>
      <head>
        <title>Ventana emergente</title>
      </head>
      <body style="display:flex; align-items:center; justify-content:center; height:100%; margin:0;">
        <button onclick="window.close()">Cerrar ventana</button>
      </body>
    </html>
  `);

}