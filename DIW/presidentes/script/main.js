document.addEventListener('DOMContentLoaded', function () {

  /* Guardamos los elementos HTML */
  const boton = document.getElementById('btn-menu');
  const fondoEnlace = document.getElementById('fondo-enlace');
  const barraLateral = document.getElementById('barra-lateral-izquierda');

  if (boton) {
    /* Click en el botón menú */
    boton.addEventListener('click', function (e) {
      e.preventDefault();
      fondoEnlace.classList.toggle('active');
      barraLateral.classList.toggle('active');
    });
  }

  /* Click en el fondo oscuro para cerrar */
  if (fondoEnlace) {
    fondoEnlace.addEventListener('click', function (e) {
      e.preventDefault();
      fondoEnlace.classList.toggle('active');
      barraLateral.classList.toggle('active');
    });
  }

});
