<script setup>

const props = defineProps(['grupos']);
</script>



<template>
  <section class="seccion">
    <h2>Grupos formados</h2>

    <table v-if="props.grupos.length > 0">
      <thead>
        <tr>
          <th>Grupo</th>
          <th>Día</th>
          <th>Franja</th>
          <th>Participantes</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="grupo in props.grupos" :key="grupo.id">
          <td>{{ grupo.id }}</td>
          <td>{{ grupo.dia }}</td>
          <td>{{ grupo.franja }}</td>
          <td>
            {{ grupo.participantes.join(',') }}
          </td>

        </tr>
      </tbody>


    </table>
    <p v-else>No hay grupos formados todavia</p>
  </section>

</template>


<style scoped>
.seccion {
  margin-top: 30px;
  padding: 20px;
  border: 1px solid #ccc;
  background-color: #e8f7e8;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

th,
td {
  border: 1px solid #777;
  padding: 8px;
  text-align: center;
}

th {
  background-color: #b9e6b9;
}
</style>