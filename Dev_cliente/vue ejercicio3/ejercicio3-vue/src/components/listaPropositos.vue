<script setup>
defineProps(['propositos'])
</script>

<template>
  <h2>Lista:</h2>
  <span>{{ propositos }}</span>

  <ul v-if="propositos.length > 0"></ul>
</template>

<style scoped></style>
