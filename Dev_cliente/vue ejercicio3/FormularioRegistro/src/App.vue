<script setup>
import { ref } from 'vue';
import FormularioRegistro from './components/formularioRegistro.vue';
import MostrarMayoresEdad from './components/mostrarMayoresEdad.vue';




let listaUsuarios = ref([
   {id: 0, nombre:"Carlos", apellidos: "Rodriguez Talegon", edad:24 , mayorEdad: true, coche:"Mercedes", sexo:"hombre"}
]);

let borrarListaUsuarios = () => {
  listaUsuarios.value = [];
};

const agregarUsuario = (usuario) => {
  listaUsuarios.value.push(usuario);
}
</script>

<template>
  <h1>Registro de usuarios </h1>
  <FormularioRegistro @nuevoUsuario="agregarUsuario"></FormularioRegistro>
<br><br>

<div class="tabla-contenedor">
  <table v-if="listaUsuarios.length">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Edad</th>
        <th>Mayor de edad</th>
        <th>Coche</th>
        <th>Sexo</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="usuario in listaUsuarios" :key="usuario.id"
      :class="usuario.mayorEdad ?'mayorEdad':'menorEdad'"
      >
        <td>{{ usuario.id }}</td>
        <td>{{ usuario.nombre }}</td>
        <td>{{ usuario.apellidos }}</td>
        <td>{{ usuario.edad }}</td>
        <td>{{ usuario.mayorEdad ? 'Sí' : 'No' }}</td>
        <td>{{ usuario.coche }}</td>
        <td>{{ usuario.sexo }}</td>
      </tr>
    </tbody>
  </table>

  <p v-else>No hay usuarios registrados</p>
</div>

<MostrarMayoresEdad :usuarios="listaUsuarios"> </MostrarMayoresEdad>

  
</template>

<style >
body {
  margin: 0;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background: linear-gradient(135deg, #667eea, #764ba2);
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

button {
  width: 100%;
  padding: 0.7rem;
  margin-top: 1rem;
  border: none;
  border-radius: 6px;
  background: #667eea;
  color: white;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background 0.3s, transform 0.1s;
}

button:hover {
  background: #5a67d8;
}

button:active {
  transform: scale(0.97);
}


.tabla-contenedor {
  
  position: absolute;
  top: 1.5rem;
  right: 1.5rem;
  width: 700px;
}



table {
  width: 100%;
  border-collapse: collapse;
  background-color: white;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

thead {
  background: linear-gradient(135deg, #667eea, #764ba2);
  color: white;
}

th, td {
  padding: 0.75rem 1rem;
  text-align: center;
}

th {
  font-size: 0.9rem;
  letter-spacing: 0.05em;
}

tbody tr {
  transition: background 0.2s;
}

tbody tr:hover {
  background-color: #f2f4ff;
}

tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}


.menorEdad {

  color: rgb(248, 83, 54);

}

.mayorEdad {

color: rgb(111, 233, 148);
}


</style>
