<script setup>
import { ref, computed } from 'vue';
let nombreUsuario = ref('');
let apellidosUsuario = ref('');
let edadUsuario = ref();



</script>

<template>

    <form action="">
        <label for="nombre" >Nombre</label>
        <input type="text" v-model="nombreUsuario" placeholder="Introduce tu nombre"><br><br>
        <label for="apellidos">Apellidos</label>
        <input type="text" v-model="apellidosUsuario" placeholder="Introduce tus apellidos"><br><br>
        <label for="edad">Edad</label>
        <input type="number" v-model="edadUsuario">


    </form>



</template>

<style scoped>
form {
  background: #ffffff;
  padding: 2rem;
  width: 320px;
  border-radius: 14px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.15);
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

label {
  font-size: 0.9rem;
  font-weight: 600;
  color: #444;
}

input {
  padding: 0.6rem 0.8rem;
  border-radius: 8px;
  border: 1px solid #ccc;
  font-size: 0.95rem;
  transition: border 0.3s, box-shadow 0.3s;
}

input:focus {
  outline: none;
  border-color: #6b73ff;
  box-shadow: 0 0 0 2px rgba(107, 115, 255, 0.2);
}

button {
  margin-top: 0.5rem;
  padding: 0.7rem;
  border-radius: 8px;
  border: none;
  background: linear-gradient(135deg, #6b73ff, #000dff);
  color: white;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: transform 0.1s, box-shadow 0.2s;
}

button:hover {
  box-shadow: 0 8px 20px rgba(0, 13, 255, 0.3);
}

button:active {
  transform: scale(0.96);
}

</style>