function mostrarAnimales(){
    const tomarValor = document.getElementById("animales").value;
    

    if(tomarValor == "") {
        alert("Necesitas seleccionar un animal para mostrarlo..");
    } else {
        // Peticion fetch api
        fetch("http://localhost:3000/animales")
        .then(response => response.json())
        .then(data => {

                // filtrar por tipo
            let filtrados = data.map(a => a.Tipo === tomarValor);
            mostrarTabla(filtrados); // llamamos a la funcion de mostrar

           
            
        })

        .catch(error => console.error( "Error al cargar los datos",error));
       

    }

    
   


}

function mostrarTabla(animales){
     let tabla = "<table border='1'><tr><th>Nombre</th><th>Ubicación</th><th>Observación</th></tr>";

     animales.forEach(a => {
        tabla += `
        <tr>
        <td>${a.Nombre} </td>
        <td>${a.Ubicacion} </td>
        <td>${a.Ubicacion} </td>
        
        </tr>
        `;
         });
        tabla += "</table>";

         document.getElementById("resultado").innerHTML = tabla;


}