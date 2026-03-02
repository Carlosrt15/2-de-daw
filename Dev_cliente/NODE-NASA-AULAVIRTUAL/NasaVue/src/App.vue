<script setup>
import MenuHorizontal from './components/MenuHorizontal.vue';

</script>

<template>
  <div id="superior">
  <h1>Centro Avanzado de Observación Espacial (CAOE) </h1>
    </div>

    <div>
      <MenuHorizontal></MenuHorizontal>
    </div>
    
  
</template>

<style scoped>
#superior {
  /* Fijar en la parte de arriba */
  position: sticky;
  top: 0;
  width: 100%;
  z-index: 1000;

  /* Diseño y Alineación */
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.8rem 5%;
  box-sizing: border-box; /* Evita que el padding ensanche el div */

  /* Estética: Cristal Esmerilado (Glassmorphism) */
  background-color: rgba(255, 255, 255, 0.8); 
  backdrop-filter: blur(12px); 
  -webkit-backdrop-filter: blur(12px);
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05);
}

/* Estilo para los enlaces de navegación */
#superior nav a {
  text-decoration: none;
  color: #333;
  margin-left: 20px;
  font-weight: 500;
  transition: color 0.3s ease;
}

#superior nav a:hover {
  color: #007bff; /* Color de énfasis al pasar el ratón */
}

</style>
