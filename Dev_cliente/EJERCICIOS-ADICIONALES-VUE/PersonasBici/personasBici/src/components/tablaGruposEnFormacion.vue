<script setup>
const props = defineProps(['grupos']);


</script>


<template>
<section class="seccion">
    <h2>Grupos en formacion</h2>

    <table v-if="props.grupos.length > 0">
        <thead>
            <tr>
                <th>Grupo</th>
                <th>Día</th>
                <th>Franja</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="grupo in props.grupos" :key="grupo.id">
                <td>{{ grupo.id }}</td>
                <td>{{ grupo.dia }}</td>
                <td>{{ grupo.franja }}</td>

            </tr>
        </tbody>

    </table>
    <p v-else>No hay grupos en formacion</p>
</section>

</template>


<style scoped>
.seccion {
  margin-top: 30px;
  padding: 20px;
  border: 1px solid #ccc;
  background-color: #f5f5f5;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

th, td {
  border: 1px solid #aaa;
  padding: 8px;
  text-align: center;
}

th {
  background-color: #d0eaff;
}

</style>