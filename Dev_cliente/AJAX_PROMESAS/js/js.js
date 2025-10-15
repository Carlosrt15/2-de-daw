function recuperarDatos() {
  let idUser = document.getElementById("idUser").value;

  if (isNaN(idUser) || idUser == "") {
    // El usuario debe introducir un numero
    alert("Debes introducir un numero");
  } else {
    fetch("https://jsonplaceholder.typicode.com/posts?" + "userId=" + idUser)
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error(
            "Error HTTP:" + response.status + "(" + response.statusText + ")"
          );
        }
      })

      .then((infoPosts) => {
        // Mpstrar si hay resultados
        if (infoPosts.length > 0) {
          mostrarDatos(infoPosts);
        } else {
          alert("No hay resultados con esa ID :" + idUser);
          limpiarTabla();
        }
      })

      .catch((error) => {
        console.error(error);
        alert("Error en la llamada a la API" + error.message);
      });
  }
}

function mostrarDatos(infoPosts) {
  let tbody = document.getElementsByTagName("tbody")[0];
  tbody.innerHTML = "";

  infoPosts.forEach((post) => {
    const newPost = document.createElement("tr");
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

function recuperaUsuarios() {
  fetch("https://jsonplaceholder.typicode.com/users")
    .then((response) => response.json()) // Convertir respuesta a JSON
    .then((usuarios) => {
      alert(usuarios.map((u) => u.name).join(",")); // Mostrar nombre
      alert(usuarios.map((u) => u.email).join(",")); // Mostrar correo
    })

    .catch((error) => {
      alert("Error en la Api" + error.message);
    });
}


function recuperarTareas() {
    fetch("https://jsonplaceholder.typicode.com/todos")
    .then((response) => response.json()) 

    .then((todos) => {
      // Mostrar un cantidad deseada
      const primeros = todos.slice(0,20);  // en concreto solo mostrara los 20 primeros

      alert(primeros.map((u) => u.title).join(",")); 
      alert(primeros.map((u) => u.id).join(",")); 

    })

    .catch((error) => {
      alert("Error en la Api" + error.message);
    });
}
