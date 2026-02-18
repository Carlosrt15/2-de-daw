<script setup>
import router from './router';

</script>

<template>
  <h1>You did it!</h1>
  <p>
    Visit <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to read the
    documentation
  </p>

  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">about</RouterLink>
    <RouterLink to="/deportes">Deportes</RouterLink>
  </nav>
</template>

<style scoped></style>
