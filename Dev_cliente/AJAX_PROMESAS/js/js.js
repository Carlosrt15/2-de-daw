function recuperarDatos() {

    let idUser = document.getElementById("idUser").value;
    if(isNaN(idUser) || idUser == "") {

        alert("Debes introducir un numero");
    } else {
        fetch("https://jsonplaceholder.typicode.com/posts?" + "userId=" + idUser)
        .then((response) => {
            if(response.ok) {
            return response.json();
            } else {
                throw new Error("Error HTTP:" + response.status + "(" + response.statusText + ")");

            }
        })

        .then((infoPosts) => {
            // Mpstrar si hay resultados
            if(infoPosts.length > 0) {
            mostrarDatos(infoPosts);
            } else {
                alert("No hay resultados con esa ID :"+ idUser);
                limpiarTabla();
            }
        })

        .catch((error) => {
             console.error(error);
                alert("Error en la llamada a la API" +error.message);
        });
    }
    
}

function mostrarDatos(infoPosts) {

    let tbody = document.getElementsByTagName("tbody")[0];
    tbody.innerHTML = "";

    infoPosts.forEach((post) => {
        const  newPost = document.createElement("tr");
        newPost.innerHTML = `
                            <td>${post.userId}</td>
                            <td>${post.id}</td>
                            <td>${post.title}</td>
                            <td>${post.body}</td>`;

                tbody.appendChild(newPost);         
                       
                         
        
    });

}

function limpiarTabla() {
    let tbody = document.getElementsByTagName("tbody")[0];
    tbody.innerHTML = "";
}