<script setup>
defineProps({
  cumplidos: Array,
})
</script>

<template>
  <div id="tablaa">
    <table>
      <thead>
        <tr>
          <th>Cumplidos</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(proposito, index) in cumplidos" :key="index">
          <td>{{ proposito.texto }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style>
table {
  border: 3px solid black;
}

th {
  border: 3px solid black;
}

#tablaa {
  display: flex;
  justify-content: center;
  margin-top: 50px;
}
</style>
