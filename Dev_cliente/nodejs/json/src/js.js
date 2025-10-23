function mostrarAnimales(){

   fetch("http://localhost:3000/animales")
   .then(respuesta => respuesta.json())

   .then(datos => {
    // map para mapear por la propiedad nombre
        let filtrarNombre = datos.map(a => a.Nombre);
        alert(filtrarNombre);
   })
   
   .catch (error => console.log( "Error al cargar los datos",error));
    
}