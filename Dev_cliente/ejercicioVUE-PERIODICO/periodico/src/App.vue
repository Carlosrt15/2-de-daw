<script setup>
import Lateral from './components/Lateral.vue';
import router from './router';


</script>

<template>
  <h1>Salamanca 24/h</h1>
  <h3>Bienvenidos al Periodico Local</h3>
  <div class="layaout">
  <Lateral></Lateral>
  <div class="contenido">
  <router-view></router-view>
  </div>
  </div>
</template>


<style scoped>
h1 {
    width: 100%;
    text-align: center;
    background-color: rgb(243, 95, 95);
    padding: 20px 0;
    margin: 0;
    background-color: rgb(83, 140, 247);
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
body{
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.contenido{
  flex: 1;
  display: flex;
  justify-content: center;   /* centra horizontal */
  align-items: center;       /* centra vertical */
  min-height: 100vh;
}
.layaout{
  display: flex;
  min-height: 100vh;
}
</style>
