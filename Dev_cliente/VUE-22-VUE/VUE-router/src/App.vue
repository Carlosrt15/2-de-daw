<script setup>
import { RouterLink, RouterView } from 'vue-router'

const listaAutores = ref([{
  pais: "España", autores: ["Miguel de Cervantes", "Federico García Lorca", "Arturo Pérez-Reverte", "Javier Castillo", "Carlos Ruiz Zafón"]
}, {
  pais: "Argentina", autores: ["Jorge Luis Borges", "Julio Cortázar", "Ernesto Sabato", "Adolfo Bioy Casares", "Silvina Ocampo"]
}, {
  pais: "México", autores: ["Octavio Paz", "Juan Rulfo", "Carlos Fuentes", "Laura Esquivel", "Elena Poniatowska"]
}, {
  pais: "Chile", autores: ["Pablo Neruda", "Isabel Allende", "Roberto Bolaño", "Gabriela Mistral", "Nicanor Parra"]
}, {
  pais: "Colombia", autores: ["Gabriel García Márquez", "Álvaro Mutis", "Laura Restrepo", "Fernando Vallejo", "Jorge Isaacs"]
}, {
  pais: "Perú", autores: ["Mario Vargas Llosa", "César Vallejo", "Alfredo Bryce Echenique", "Clorinda Matto de Turner", "Ricardo Palma"]
}
])


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
