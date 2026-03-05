<script setup>
import MenuLateral from './components/MenuLateral.vue';

</script>

<template>
  <h1>Talleres Hérnandez - Gestión Interna</h1>

  <MenuLateral></MenuLateral>
  
</template>

<style scoped>
/* 1. Reset básico para que todo encaje bien */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body {
  background-color: #f4f7f6; /* Gris muy claro de fondo */
  color: #333;
}

/* 2. Cabecera (Header) */
header {
  background-color: #1a252f; /* Azul marino profesional */
  color: white;
  padding: 1.5rem;
  text-align: center;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

header h1 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

/* 3. Menú de Navegación */
nav {
  display: flex;
  justify-content: center;
  gap: 20px;
}

nav a {
  color: #bdc3c7;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s;
}

nav a:hover, .router-link-active {
  color: #3498db; /* Azul brillante para el enlace activo */
}

/* 4. Zona Central (Requisito 80% ancho) */
main {
  width: 80%;
  margin: 2rem auto; /* Centra horizontalmente */
  background: white;
  min-height: 70vh;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
}

/* 5. Pie de página (Footer) */
footer {
  background-color: #2c3e50;
  color: #ecf0f1;
  padding: 1.5rem;
  text-align: center;
  margin-top: auto;
}

footer a {
  color: #3498db;
  text-decoration: none;
  margin: 0 10px;
}

/* 6. Estilos rápidos para tablas o formularios que pongas dentro */
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 1rem;
}

th, td {
  padding: 12px;
  border-bottom: 1px solid #eee;
  text-align: left;
}

th {
  background-color: #f8f9fa;
}

</style>
