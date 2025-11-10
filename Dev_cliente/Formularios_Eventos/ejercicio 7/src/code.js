// --- Asignar clase parrafosNormal a todos los párrafos ---
const parrafos = document.querySelectorAll("p");
parrafos.forEach(p => p.className = "parrafosNormal");

// --- Referencias a elementos ---
const h2 = document.getElementById("titulo1");
const p2 = document.getElementById("p2");
const p5 = document.getElementById("p5");
const inputsTexto = document.querySelectorAll("input[type='text']");
const textoSexo = document.getElementById("textoSexo");
const radios = document.querySelectorAll("input[type='radio']");
const tituloForm = document.getElementById("tituloForm");
const listaPar = document.querySelectorAll("li.par");
const p1 = document.getElementById("p1");

// --- Evento: clic en el primer h2 ---
h2.addEventListener("click", () => {
  // Comprobamos si los párrafos 2 y 5 están visibles
  const visibles = (p2.style.display !== "none" && p5.style.display !== "none");

  if (visibles) {
    p2.style.display = "none";
    p5.style.display = "none";
  } else {
    p2.style.display = "block";
    p5.style.display = "block";
  }

  // Añadir +5 al valor del atributo size de los input tipo texto
  inputsTexto.forEach(input => {
    let sizeActual = parseInt(input.getAttribute("size"));
    input.setAttribute("size", sizeActual + 5);
  });
});

// --- Evento: pasar el ratón por encima del texto “Escoge el sexo” ---
textoSexo.addEventListener("mouseover", () => {
  radios.forEach(radio => {
    radio.removeAttribute("name");
  });
});

// --- Evento: pasar el ratón por encima del título del formulario ---
tituloForm.addEventListener("mouseover", () => {
  radios.forEach(radio => {
    radio.setAttribute("name", "nuevoSexo");
  });
});

// --- Evento: doble clic en el primer párrafo ---
p1.addEventListener("dblclick", () => {
  parrafos.forEach((p, index) => {
    // Posición física: índice + 1
    if ((index + 1) % 3 === 0) {
      p.className = "parrafosEspecial";
    } else {
      p.className = "parrafosNormal";
    }
  });

  // Cambiar color de fondo a los elementos de lista con clase 'par'
  listaPar.forEach(li => {
    li.style.backgroundColor = "#d1c4e9"; // color distinto para notar el cambio
  });
});
