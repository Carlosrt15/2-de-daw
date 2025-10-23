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

// Crear objeto 

let nuevoCliente = {

    nombre: nombre,
    apellidos: apellidos,
    DNI: dni,
    fechaNac: fecha,
    Sexo: sexo,
    preferencias: preferencias
};

//  Configurar petiucion 

    let URL = "http://localhost:3000/clientes";
    let init = {
      method: 'POST',
      body: JSON.stringify(nuevoCliente),
      headers: { 'Content-Type': 'application/json' }
    };

    fetch(URL, init)
    .then(response => response.json())
    .then(datosRespuesta => {
        console.log("Cliente dado de alta:"+ datosRespuesta);
      alert("Cliente dado de alta correctamente");

    })

        .catch(error => console.error("Error al dar de alta:"+ error));
}
    

/**json-server --watch clientes.json --port 3000 */


function borrarCliente(){

  let tomarDni = document.getElementById("dni").value;

  if(tomarDni === "") {
  alert("Debes meter un DNI para borrar el cliente que deseas eliminar ");
  return;

  }

  let URL = "http://localhost:3000/clientes";

  // buscar dni

  fetch(URL)
   .then(response => response.json())
    .then(clientes => {
    // Busca el cliente cuyo dni coincide con el json
      let cliente = clientes.find (c => c.DNI.toLowerCase() === tomarDni.toLowerCase());

      
      // Enviar el DELETE

      return fetch(`${URL}/${cliente.id}`, { method: 'DELETE' });
      
  })

  
    .then(response => {
      if (response && response.ok) {
        alert("cliente fue borrado");
      }
    })

    .catch(error => console.error("No se pudo borrar al cliente:", error));
    

    
}