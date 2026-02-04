<script setup>
defineProps(['propositos'])
import { ref } from 'vue'
</script>

<template>
  <h2>Lista:</h2>

  <ul v-if="propositos.length > 0">
    <li
      v-for="(proposito, index) in propositos"
      :key="index"
      :class="proposito.hecho ? 'Verdadero' : 'Falso'"
    >
      {{ proposito.texto }} --- {{ proposito.hecho ? 'Cumplido' : 'No cumplido' }}
    </li>
  </ul>
  <p v-else>La lista de propositos está vacia</p>
</template>

<style scoped>
.Verdadero {
  color: green;
}

.Falso {
  color: red;
}
</style>
