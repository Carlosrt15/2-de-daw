<script setup>
import MenuLateral from './components/MenuLateral.vue';

</script>

<template>
  <header><h1>Bilblioteca DAW - Gestión</h1>
    <hr>
    </header>


  <MenuLateral></MenuLateral>

  <RouterView></RouterView>


    <footer>
      <hr>
      <h3>Aplicación realizada con Vue - DAW </h3>
    </footer>
  
 
</template>

<style scoped></style>
