<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const asteroide = ref({})

onMounted(async () => {

  const id = route.params.id

  const respuesta = await fetch(
    'https://api.nasa.gov/neo/rest/v1/neo/' + id + '?api_key=zgHIbOXqmQM5asONMtc3CA4pfkaPsbal1ugbKXxF'
  )

  const datos = await respuesta.json()

  asteroide.value = datos
})

function volver() {
  router.push('/astCercano')
}
</script>

<template>
  <div>
    <h1>Detalle del Asteroide</h1>

    <div v-if="asteroide.name">

      <p><strong>Nombre:</strong> {{ asteroide.name }}</p>

      <p>
        <strong>URL NASA:</strong>
        <a :href="asteroide.nasa_jpl_url" target="_blank">
          Ver en NASA
        </a>
      </p>

      <p><strong>Magnitud absoluta:</strong> {{ asteroide.absolute_magnitude_h }}</p>

      <p>
        <strong>Diámetro mínimo (km):</strong>
        {{ asteroide.estimated_diameter.kilometers.estimated_diameter_min }}
      </p>

      <p>
        <strong>Diámetro máximo (km):</strong>
        {{ asteroide.estimated_diameter.kilometers.estimated_diameter_max }}
      </p>

      <p>
        <strong>¿Es potencialmente peligroso?</strong>
        {{ asteroide.is_potentially_hazardous_asteroid ? "Sí" : "No" }}
      </p>

      <p>
        <strong>Número de aproximaciones:</strong>
        {{ asteroide.close_approach_data.length }}
      </p>

      <!-- Primera aproximación -->
      <div v-if="asteroide.close_approach_data.length > 0">
        <h3>Primera aproximación</h3>

        <p>
          <strong>Fecha:</strong>
          {{ asteroide.close_approach_data[0].close_approach_date }}
        </p>

        <p>
          <strong>Velocidad (km/h):</strong>
          {{ asteroide.close_approach_data[0].relative_velocity.kilometers_per_hour }}
        </p>

        <p>
          <strong>Distancia mínima (km):</strong>
          {{ asteroide.close_approach_data[0].miss_distance.kilometers }}
        </p>
      </div>

      <br>
      <button @click="volver">Volver al listado</button>

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