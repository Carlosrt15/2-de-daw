function mostrarAnimales(){
    const tomarValor = document.getElementById("animales").value;
    

    if(tomarValor == "") {
        alert("Necesitas seleccionar un animal para mostrarlo..");
    } else {
        // Peticion fetch api
        fetch("http://localhost:3000/animales")
        .then(response => response.json())
        .then(data => {

            const filtrados = data.filter(a => a.Tipo === tomarValor);
            console.log("Animales encontrados");
            console.log(filtrados);
        })


        .catch(error => console.error( "Error al cargar los datos",error));
       

    }

    



}