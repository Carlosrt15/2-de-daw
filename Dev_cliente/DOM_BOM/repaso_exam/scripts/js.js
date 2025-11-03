// Dado un array de números, crea uno nuevo con cada número multiplicado por 2.
function ejercicio1() {
  const numeros = [1, 2, 3, 4, 5];

  let numerosx2 = numeros.map((numero) => numero * 2);

  const nombres = ["ana", "juan", "pedro", "maria"];

  let mayus = nombres.map((nombre) => nombre.toUpperCase());

  const nombres2 = ["sol", "carmen", "leo", "andres", "luz"];

  let masCuatroLetra = nombres2.filter((nombre) => nombre.length > 4);

  alert(mayus);
  alert(masCuatroLetra);
  alert(numerosx2);
}

function ejercicio2() {
  const productos = [
    { nombre: "Camiseta", precio: 50 },
    { nombre: "Zapatillas", precio: 120 },
    { nombre: "Pantalón", precio: 200 },
  ];

  let productosMayor = productos.filter((producto) => producto.precio > 100);

  let descuentoAplicado = productosMayor.map((producto) => {
    return {
      nombre: producto.nombre,
      precioDescuento: producto.precio * 0.9,
    };
  });

  alert(JSON.stringify(descuentoAplicado, null, 2));

  //-----------------------------------------------------------------
  //-----------------------------------------------------------------

  // De volver nombres de mas de 18 años edad
  const personas = [
    { nombre: "Luis", edad: 17 },
    { nombre: "María", edad: 22 },
    { nombre: "Carlos", edad: 15 },
    { nombre: "Laura", edad: 19 },
  ];

  let mayoriaEdad = personas.filter((p) => p.edad > 18);
  let mayorEdad = mayoriaEdad.map((p) => {
    return {
      nombre: p.nombre,
    };
  });

  alert(JSON.stringify(mayorEdad));

  //-----------------------------------------------------------------
  //-----------------------------------------------------------------

  // Crea un nuevo array con los cuadrados de los números impares.
  const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9];

  let numerosImpares = numeros.filter((numero) => numero % 2 !== 0);

  let cuadrado = numerosImpares.map((numero) => numero * numero);
  alert(cuadrado);
}

function ejercicio3() {
  // Usa reduce para obtener la suma total de los números.
  const numeros = [10, 20, 30, 40];

  let suma = numeros.reduce((a, n) => a + n, 0);
  alert(suma);

  //-----------------------------------------------------------------
  //-----------------------------------------------------------------

  // Calcula el promedio de edades del grupo.
  const grupo = [
    { nombre: "Ana", edad: 18 },
    { nombre: "Pedro", edad: 22 },
    { nombre: "Lucía", edad: 24 },
    { nombre: "Marta", edad: 20 },
  ];

  let mediaEdad = grupo.reduce((a, n) => a + n.edad, 0);

  let mediaFinal = mediaEdad / grupo.length;
  alert(mediaFinal);

  //-----------------------------------------------------------------
  //-----------------------------------------------------------------

  // Usa find para obtener el producto con nombre "Tablet".
  const productos = [
    { nombre: "Laptop", precio: 1000 },
    { nombre: "Tablet", precio: 500 },
    { nombre: "Celular", precio: 700 },
  ];

  const buscar = "Tablet";

  let busqueda = productos.find(
    (producto) => producto.nombre.toLowerCase() === buscar.toLowerCase()
  );
  alert(JSON.stringify(busqueda));

  //-----------------------------------------------------------------
  //-----------------------------------------------------------------

  // Usa some y every:
  // - ¿Hay algún número mayor a 100?
  // - ¿Son todos positivos?
  const numeros2 = [10, 20, 30, 150];

  let algunos = numeros2.some((numero) => numero > 100);
  console.log(algunos);

  if (algunos === true) {
    alert("si, algún numero es > 100");
  } else {
    alert("No hay ningun numero > 100");
  }

  let positivos = numeros2.every((numero) => numero > 0);

  if (positivos === true) {
    alert("Todos los numeros son > 0 ");
  }
}

function repasoNombres() {
  const personas = [
    { nombre: "Carlos", sexo: "M", edad: 25 },
    { nombre: "Luis", sexo: "M", edad: 32 },
    { nombre: "Jorge", sexo: "M", edad: 41 },
    { nombre: "Andrés", sexo: "M", edad: 22 },
    { nombre: "Miguel", sexo: "M", edad: 36 },
    { nombre: "Pedro", sexo: "M", edad: 29 },
    { nombre: "Ricardo", sexo: "M", edad: 45 },
    { nombre: "Tomás", sexo: "M", edad: 27 },
    { nombre: "Sebastián", sexo: "M", edad: 33 },
    { nombre: "Diego", sexo: "M", edad: 38 },
    { nombre: "Manuel", sexo: "M", edad: 24 },
    { nombre: "Alejandro", sexo: "M", edad: 30 },
    { nombre: "Fernando", sexo: "M", edad: 50 },
    { nombre: "Iván", sexo: "M", edad: 21 },
    { nombre: "Héctor", sexo: "M", edad: 26 },
    { nombre: "Raúl", sexo: "M", edad: 35 },
    { nombre: "Gabriel", sexo: "M", edad: 28 },
    { nombre: "Pablo", sexo: "M", edad: 40 },
    { nombre: "Oscar", sexo: "M", edad: 31 },
    { nombre: "Daniel", sexo: "M", edad: 23 },
    { nombre: "Laura", sexo: "F", edad: 18 },
    { nombre: "Ana", sexo: "F", edad: 26 },
    { nombre: "María", sexo: "F", edad: 34 },
    { nombre: "Lucía", sexo: "F", edad: 22 },
    { nombre: "Sofía", sexo: "F", edad: 29 },
    { nombre: "Isabel", sexo: "F", edad: 40 },
    { nombre: "Valeria", sexo: "F", edad: 31 },
    { nombre: "Camila", sexo: "F", edad: 27 },
    { nombre: "Paula", sexo: "F", edad: 36 },
    { nombre: "Andrea", sexo: "F", edad: 24 },
    { nombre: "Carla", sexo: "F", edad: 33 },
    { nombre: "Natalia", sexo: "F", edad: 45 },
    { nombre: "Fernanda", sexo: "F", edad: 21 },
    { nombre: "Patricia", sexo: "F", edad: 38 },
    { nombre: "Verónica", sexo: "F", edad: 30 },
    { nombre: "Daniela", sexo: "F", edad: 25 },
    { nombre: "Mónica", sexo: "F", edad: 50 },
    { nombre: "Alejandra", sexo: "F", edad: 28 },
    { nombre: "Claudia", sexo: "F", edad: 35 },
    { nombre: "Estefanía", sexo: "F", edad: 23 },
  ];

  let primeraPersonaMayor37 = personas.find(persona => persona.edad > 37);

  let Mostrar = JSON.stringify(primeraPersonaMayor37);
  alert(Mostrar, null, 2);

}



function DarAltaPersona() {
  let nombre = document.getElementById("nombre").value;
  let edad = document.getElementById("edad").value;
  let dni = document.getElementById("dni").value;
  let sexo = document.querySelector('input[name="sexo"]:checked').value;

  const Persona = {
    nombre: nombre,
    edad: edad,
    sexo: sexo,
    dni: dni
  };
  alert(JSON.stringify(Persona));

  // Crear la introducion de datos al servidor 

  fetch("http://localhost:3000/personas", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(Persona)
  })
    .then(respuesta => respuesta.json())
    .catch(error => {
      console.error("Error al enviar", error);
    });









}

function MostrarPersona() {
  fetch("http://localhost:3000/personas")
    .then(respuesta => respuesta.json())
    .then(datos => {
      let html = "";
      datos.forEach(p => {
        html += `<p>${p.nombre}  Nombre - ${p.sexo} Sexo - ${p.edad} años - ${p.dni} - DNI </p>`;
      });
      document.getElementById("resumen").innerHTML = html;
    })
    .catch(err => { console.error(err); });



}

function BorarPersona() {

  let tomarDni = document.getElementById("dni").value;

  if (tomarDni === "") {
    alert("Debes meter un DNI majete..");
    return;
  }


  fetch("http://localhost:3000/personas")
    .then(response => response.json())
    .then(personas => {
      let persona = personas.find(d => d.dni.toLowerCase() === tomarDni.toLowerCase());

      return fetch(`http://localhost:3000/personas/${persona.id}`, { method: 'DELETE' });

    })

    .then(response => {
      if (response && response.ok) {
        alert("cliente fue borrado");
      }
    })

    .catch(error => console.error("No se pudo borrar al cliente:", error));



}