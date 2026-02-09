<script setup>

const calendario = [
  [1, 2, 3, 4, 5, 6, 7],
  [8, 9, 10, 11, 12, 13, 14],
  [15, 16, 17, 18, 19, 20, 21],
  [22, 23, 24, 25, 26, 27, 28]
]

</script>

<template>
  <div id="app">
    <div class="contenedor">
      <!-- Calendario -->
      <div class="calendario">
        <h2>Febrero 2021</h2>
        <table>
          <thead>
            <tr>
              <th>Lun</th>
              <th>Mar</th>
              <th>Mié</th>
              <th>Jue</th>
              <th>Vie</th>
              <th>Sáb</th>
              <th>Dom</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(semana, i) in calendario" :key="i">
              <td v-for="(dia, j) in semana" :key="j">
                {{ dia }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- Caja de citas -->
      <div class="citas">
        <h2>Citas</h2>
        <p>
          
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
