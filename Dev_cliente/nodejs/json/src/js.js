function mostrarAnimales(){

   fetch("http://localhost:3000/animales")
   .then(respuesta => respuesta.json())

   .then(datos => {
        let filtrarNombre = datos.map(a => a.Nombre);
        alert(filtrarNombre);
   })
   
   .catch (error => console.error( "Error al cargar los datos",error));
    


}