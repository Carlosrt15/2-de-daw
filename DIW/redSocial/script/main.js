document.addEventListener('DOMContentLoaded', function () {

  const boton = document.getElementById('btn-menu');
  const fondo = document.getElementById('fondo-enlace');
  const barra = document.getElementById('barra-lateral-izquierda');

  boton.addEventListener('click', function (e) {
    e.preventDefault();
    fondo.classList.toggle('active');
    barra.classList.toggle('active');
  });

  fondo.addEventListener('click', function (e) {
    e.preventDefault();
    fondo.classList.toggle('active');
    barra.classList.toggle('active');
  });

});
