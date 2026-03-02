<script setup>
import { ref, onMounted } from 'vue'

const asteroides = ref([])

onMounted(async () => {
  const respuesta = await fetch(
    'https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=zgHIbOXqmQM5asONMtc3CA4pfkaPsbal1ugbKXxF'
  )

  const datos = await respuesta.json()

  asteroides.value = datos.near_earth_objects
})

// Ordenar por magnitud (de mayor a menor)
function ordenar() {
  asteroides.value.sort(function(a, b) {
    return b.absolute_magnitude_h - a.absolute_magnitude_h
  })
}
</script>

<template>
  <div>
    <h1>Asteroides Cercanos</h1>

    <table border="1">
      <tr>
        <th>Nombre</th>
        <th @click="ordenar">Magnitud</th>
        <th>Peligroso</th>
        <th>Diámetro máx (km)</th>
      </tr>

      <tr v-for="asteroide in asteroides" :key="asteroide.id">
        <td>
          <RouterLink :to="'/asteroide/' + asteroide.id">
            {{ asteroide.name }}
          </RouterLink>
        </td>

        <td>{{ asteroide.absolute_magnitude_h }}</td>

        <td>
          {{ asteroide.is_potentially_hazardous_asteroid ? "Sí" : "No" }}
        </td>

        <td>
          {{ asteroide.estimated_diameter.kilometers.estimated_diameter_max }}
        </td>
      </tr>
    </table>

  </div>
</template>

<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f6f8;
}

h1 {
  color: #333;
}

table {
  width: 100%;
  border-collapse: collapse;
  background: white;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

th, td {
  padding: 10px;
  text-align: left;
}

th {
  background-color: #007bff;
  color: white;
  cursor: pointer;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

button {
  background-color: #007bff;
  color: white;
  padding: 8px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

img {
  margin-top: 15px;
  border-radius: 8px;
}
</style>