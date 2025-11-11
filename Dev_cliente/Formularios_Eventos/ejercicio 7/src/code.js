
const parrafos = document.querySelectorAll("p");
parrafos.forEach(p => p.className = "parrafosNormal");


const h2 = document.getElementById("titulo1");
const p2 = document.getElementById("p2");
const p5 = document.getElementById("p5");
const inputsTexto = document.querySelectorAll("input[type='text']");
const textoSexo = document.getElementById("textoSexo");
const radios = document.querySelectorAll("input[type='radio']");
const tituloForm = document.getElementById("tituloForm");
const listaPar = document.querySelectorAll("li.par");
const p1 = document.getElementById("p1");


h2.addEventListener("click", () => {

  const visibles = (p2.style.display !== "none" && p5.style.display !== "none");

  if (visibles) {
    p2.style.display = "none";
    p5.style.display = "none";
  } else {
    p2.style.display = "block";
    p5.style.display = "block";
  }


  inputsTexto.forEach(input => {
    let sizeActual = parseInt(input.getAttribute("size"));
    input.setAttribute("size", sizeActual + 5);
  });
});


textoSexo.addEventListener("mouseover", () => {
  radios.forEach(radio => {
    radio.removeAttribute("name");
  });
});


tituloForm.addEventListener("mouseover", () => {
  radios.forEach(radio => {
    radio.setAttribute("name", "nuevoSexo");
  });
});


p1.addEventListener("dblclick", () => {
  parrafos.forEach((p, index) => {
    // Posición física: índice + 1
    if ((index + 1) % 3 === 0) {
      p.className = "parrafosEspecial";
    } else {
      p.className = "parrafosNormal";
    }
  });


  listaPar.forEach(li => {
    li.style.backgroundColor = "#d1c4e9";
  });
});




//--------------------------------------------------------------------
//----------------------------------------------------------------------
//-----------------------------------------------------------------------

 let turno = true
//  ejercicio 1 de formulario  Y Eventos
function ejercicio1_2() {
  let primerP = document.querySelector('p');
  let primerh1 = document.querySelector('h1');

  // Variable fuera del eschucha si no falla  
 

  function cambiarColor() {
    if (turno) {
      primerh1.style.color = 'red';

    } else {
      primerh1.style.color = 'black';

    }
    turno = !turno;
   primerP.removeEventListener("dblclick", cambiarColor);
    console.log("Listener eliminado ");
  }
    primerP.addEventListener("dblclick", cambiarColor);
}
       
      
      
        
    
    



ejercicio1_2();


/*Ejercicio 2 eventos y formularios */

function bodyy(){
  let tomarCuerpo = document.getElementsByTagName('body')[0];

  let mostrar = document.getElementsByTagName('span')[0];

  tomarCuerpo.addEventListener('mouseover', (e) =>{
    mostrar.innerHTML = `y: ${e.pageY}, x: ${e.pageX}`;
      
  });
}

function mostrarKey(){
  let tomarCuerpo = document.getElementsByTagName('body')[0];
 

  tomarCuerpo.addEventListener('keydown', (letra) =>{
    alert(letra.keyCode);
    // preguntar Sonia
    alert(letra.key);

  });

}
mostrarKey();

bodyy();