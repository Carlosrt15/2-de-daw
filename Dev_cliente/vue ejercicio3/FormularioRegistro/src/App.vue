<script setup>
import FormularioRegistro from './components/formularioRegistro.vue';
import { ref, computed } from 'vue';



let listaUsuarios = ref([
   {id: 0, nombre:"Carlos", apellidos: "Rodriguez Talegon", edad:24 , mayorEdad: true}
]);

let borrarListaUsuarios = () => {
  listaUsuarios.value = [];
};
</script>

<template>
  <h1>Registro de usuarios </h1>
  <FormularioRegistro></FormularioRegistro>
  
</template>

<style scoped>
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



</style>
