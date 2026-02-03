<script setup>
defineProps(['propositos'])
import { ref } from 'vue'
</script>

<template>
  <h2>Lista:</h2>
  <span>{{ propositos }}</span>

  <ul v-if="propositos.length > 0">
    <li v-for="(proposito, index) in propositos" :key="index">
      {{ proposito.texto }} --- {{ proposito.hecho }}
    </li>
  </ul>
  <p v-else>La lista de propositos está vacia</p>
</template>

<style scoped></style>
