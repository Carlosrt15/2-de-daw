function verPassword() {
  let inputPassword = document.getElementById("password");
  let boton = document.getElementById("botonVer");

  if (inputPassword.type === "password") {
    inputPassword.type = "text";
    boton.textContent = "Ocultar";
  } else {
    // Volver a ocultar la contraseña
    inputPassword.type = "password";
    boton.textContent = "Ver";

  }
  inputPassword.style.backgroundColor = "red";

}

var jugador1 = "";
var jugador2 = "";
var turno = 1;

function iniciarPartida() {
  jugador1 = document.getElementById("jugador1").value;
  jugador2 = document.getElementById("jugador2").value;

  if (jugador1 === "" || jugador2 === "") {
    alert("introduce el nombre de los 2 jugadores");
    return;
  }

  let casillas = document.querySelectorAll(".casilla");

  casillas.forEach(casilla => {
    casilla.disabled = false;
    casilla.textContent = "";
    casilla.style.backgroundColor = "";
    casilla.addEventListener("click", marcarCasilla);
  });

}

function bloquearTablero() {
  
    document.querySelectorAll(".casilla").forEach(c => c.disabled = true);
}

function marcarCasillas(event) {
  let boton = event.target;

  if (turno === 1) {


    boton.textContent = "X";
    boton.style.backgroundColor = "lightblue";
    boton.disabled = true;


    if (comprobarGanador("X")) {
      alert(`¡${jugador1} ha ganado!`);
      bloquearTablero();
      return;
    }
    turno = 2;
  } else {

    boton.textContent = "O";
    boton.style.backgroundColor = "lightgreen";
    boton.disabled = true;

    if (comprobarGanador("O")) {
      alert(`¡${jugador2} ha ganado!`);
      bloquearTablero();
      return;
    }
    turno = 1;
  }


}


function comprobarGanador(simbolo) {
    let botones = Array.from(document.querySelectorAll(".casilla"));
    let combinacionesGanadoras = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ];

    return combinacionesGanadoras.some(combinacion =>
        combinacion.every(i => botones[i].textContent === simbolo)
    );
}


