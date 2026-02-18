<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <h1>Ejemplos vue router y vistas</h1>

  <nav>
    <RouterLink to="/bibliografia">Bibliografía</RouterLink>
    |
  </nav>
  <RouterView />
</template>

<style scoped></style>
