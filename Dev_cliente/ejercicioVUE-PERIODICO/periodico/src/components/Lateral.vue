<script setup>

</script>


<template>
<div class="lateral">

    <h2>Periodico</h2>
    <RouterLink to="/">Inicio</RouterLink>
    <RouterLink to="/articulos">Artículos</RouterLink>
     <RouterLink to="/acercaDe">Acerca de</RouterLink>
     <RouterLink to="/tablaOwner">Tabla del Owner</RouterLink>


</div>

</template>

<style scoped>
.lateral {
  width: 200px;
  background: #559af3;
  color: rgb(240, 130, 27);
  height: 100vh;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.lateral a {
  color: rgb(185, 91, 3);
  text-decoration: none;
  margin: 10px 0;
}
</style>