function darAlta() {

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



  // Crear objeto 

  let nuevoCliente = {

    nombre: nombre,
    apellidos: apellidos,
    DNI: dni,
    fechaNac: fecha,
    Sexo: mostraSexo,
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
      console.log("Cliente dado de alta:" + datosRespuesta);
      alert("Cliente dado de alta correctamente");

    })

    .catch(error => console.error("Error al dar de alta:" + error));
}

function borrarCliente() {

  let tomarDni = document.getElementById("dni").value;

  if (tomarDni === "") {
    alert("Debes meter un DNI para borrar el cliente que deseas eliminar ");
    return;

  }

  let URL = "http://localhost:3000/clientes";

  // buscar dni

  fetch(URL)
    .then(response => response.json())
    .then(clientes => {
      // Busca el cliente cuyo dni coincide con el json
      let cliente = clientes.find(c => c.DNI.toLowerCase() === tomarDni.toLowerCase());


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

function editarDNI() {
  let nombre = document.getElementById("nombre").value;
  let apellidos = document.getElementById("apellidos").value
  let fecha = document.getElementById("fecha").value;

  let sexoSeleccionado = document.querySelector('input[name="sexo"]:checked');
  let sexo = sexoSeleccionado ? sexoSeleccionado.value : "";

  let seleccionadas = document.querySelectorAll('input[name="pref"]:checked');
  let preferencias = Array.from(seleccionadas).map(input => input.value);


  if (!dni) {
    alert(" Debes introducir un DNI para poder editar un cliente.");
    return;
  }

  // Buscar cliente por DNI 
  fetch(`http://localhost:3000/clientes?DNI=${dni}`)
    .then(response => {
      if (!response.ok) throw new Error(`Error al buscar cliente (${response.status})`);
      return response.json();
    })
    .then(data => {
      if (!data || data.length === 0) {
        alert(" No existe ningún cliente con ese DNI. No se puede modificar.");
        throw new Error("Cliente no encontrado");
      }


      let cliente = data[0];

      let clienteModificado = {
        nombre: nombre,
        apellidos: apellidos,
        DNI: dni,
        fechaNac: fecha,
        Sexo: sexo,
        preferencias: preferencias
      };

      // PUT para  el cliente
      return fetch(`http://localhost:3000/clientes/${cliente.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(clienteModificado)
      });
    })
    .then(response => {
      if (!response.ok) throw new Error(`Error al modificar (${response.status})`);
      return response.json();
    })
    .then(data => {
      alert(" Cliente modificado correctamente.");
      console.log("Cliente actualizado:", data);
    })
    .catch(error => {
      console.error("Error al modificar:", error);
    });
}

function cargarClientes() {

  const URL = "http://localhost:3000/clientes";


  fetch(URL)
    .then(respuesta => respuesta.json())
    .then (clientes => {
      let tbody = document.querySelector("#tablaClientes tbody");
      tbody.innerHTML = "";

      clientes.forEach(c =>{
        let fila = `
          <tr>
            <td>${c.id}</td>
            <td>${c.nombre}</td>
            <td>${c.fechaNac}</td>
            <td>${c.Sexo}</td>
          </tr>
        `;
        tbody.innerHTML += fila;
      });


    })

    .catch(err => console.error("Error al cargar los clientes:", err));
}

window.onload = cargarClientes;

/**json-server --watch clientes.json --port 3000 */