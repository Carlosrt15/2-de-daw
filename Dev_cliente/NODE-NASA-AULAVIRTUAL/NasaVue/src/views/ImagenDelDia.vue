<script setup>
import { ref } from 'vue'

const datosImagendia = ref({})
const fechaSeleccionada = ref("")
const mensajeError = ref("")

async function cargarImagen() {

  mensajeError.value = ""
  datosImagendia.value = {}

  let url = "https://api.nasa.gov/planetary/apod?api_key=zgHIbOXqmQM5asONMtc3CA4pfkaPsbal1ugbKXxF"


  if (fechaSeleccionada.value !== "") {
    url += "&date=" + fechaSeleccionada.value
  }

  try {
    const respuesta = await fetch(url)
    const datos = await respuesta.json()

    
    if (datos.error) {
      mensajeError.value = "No hay imagen disponible para esa fecha."
    } else {
      datosImagendia.value = datos
    }

  } catch (error) {
    mensajeError.value = "Error al conectar con la NASA."
  }
}
</script>

<template>
  <div>
    <h1>Imagen del Día - NASA</h1>

    <!-- Input fecha -->
    <input type="date" v-model="fechaSeleccionada">
    <button @click="cargarImagen">Cargar fecha concreta</button>

    <p v-if="mensajeError" style="color:red">
      {{ mensajeError }}
    </p>

    <div v-if="datosImagendia.title">
      <h2>{{ datosImagendia.title }}</h2>
      <p>{{ datosImagendia.date }}</p>
      <p>{{ datosImagendia.explanation }}</p>

      <!-- Si es imagen -->
      <img 
        v-if="datosImagendia.media_type === 'image'" 
        :src="datosImagendia.url" 
        width="500"
      >

      <!-- Si es vídeo -->
      <iframe 
        v-if="datosImagendia.media_type === 'video'"
        :src="datosImagendia.url"
        width="500"
        height="300">
      </iframe>
    </div>

  </div>
</template>

<style scoped>
body {
  background-color: #0b0f1a;
  color: white;
}

h1 {
  text-align: center;
  color: #4fc3f7;
}

table {
  width: 100%;
  border-collapse: collapse;
  background-color: #1c2233;
}

th {
  background-color: #1976d2;
  color: white;
  padding: 10px;
}

td {
  padding: 8px;
  border-bottom: 1px solid #333;
}

tr:hover {
  background-color: #2a324a;
}

button {
  background-color: #4fc3f7;
  border: none;
  padding: 8px 15px;
  color: black;
  cursor: pointer;
  border-radius: 5px;
}

button:hover {
  background-color: #29b6f6;
}

img {
  margin-top: 15px;
  border-radius: 10px;
  max-width: 100%;
}
</style>