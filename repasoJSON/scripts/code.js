function Enviar() {
    let name = document.getElementById("nombre").value;
    let surname = document.getElementById("apellidos").value;
    let years = document.getElementById("edad").value;
    let iditf = document.getElementById("dni").value;

    let sexo = document.querySelector('input[name="sexo"]:checked').value;

    var Persona = {

        nombre: name,
        apellidos: surname,
        edad: years,
        dni: iditf,
        genero: sexo
    };




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


function Mostrar() {
    let resumen = document.getElementById("resultado");

    fetch("http://localhost:3000/personas")
        .then(respuesta => respuesta.json())
        .then(datos => {
            let html = "";
            let hora = new Date();
            datos.forEach(p => {
                html += `<p>Nombre: ${p.nombre} - Sexo: ${p.sexo} - Edad:${p.edad}</p>
                
                <h2>${hora.toLocaleDateString('es-Es')}</h2>`
            });
            resumen.innerHTML = html;
        })
        .catch(err => { console.error(err); });


}


function Borrar() {
    let name = document.getElementById("nombre").value;
    let iditf = document.getElementById("dni").value;

    fetch("http://localhost:3000/personas")
        .then(res => res.json())
        .then(personas => {
            name;
            iditf;
            let filtrar = personas.find(p => p.nombre === name && p.dni === iditf);

            if (!filtrar) {
                console.log("⚠️ Persona no encontrada");
                return;

            }

            return fetch(`http://localhost:3000/personas/${filtrar.id}`, {
                method: "DELETE"
            });
        })

        .then(res => {
            if (res && !res.ok) throw new Error("Error al eliminar");
            if (res) console.log("Persona eliminada correctamente");
        })
        .catch(error => console.error(" Error:", error));



}


function Modificar() {
  let name = document.getElementById("nombre").value;
  let surname = document.getElementById("apellidos").value;
  let years = document.getElementById("edad").value;
  let iditf = document.getElementById("dni").value;
  let sexo = document.querySelector('input[name="sexo"]:checked').value;

  var Persona = {
    nombre: name,
    apellidos: surname,
    edad: years,
    dni: iditf,
    genero: sexo
  };

  fetch("http://localhost:3000/personas")
    .then(res => res.json())
    .then(personas => {
      const persona = personas.find(p => p.dni === iditf);
      if (!persona) return alert("No existe ese DNI");

      return fetch(`http://localhost:3000/personas/${persona.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(Persona)
      });
    })
    .then(res => res && res.ok && alert("Persona modificada"))
    .catch(err => console.error("Error:", err));
}
