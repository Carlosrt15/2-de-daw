<script setup>
import { ref } from 'vue'
import ListaPropositos from './components/listaPropositos.vue'
import NuevoProposito from './components/nuevoProposito.vue'

let listaPropositos = ref([
  { texto: 'No fumar', hecho: true },
  { texto: 'No beber', hecho: false },
])
</script>

<template>
  <h1>Propositos de año nuevo:</h1>
  <ListaPropositos :propositos="listaPropositos"></ListaPropositos>
  <hr />
  <NuevoProposito :propositos="listaPropositos"></NuevoProposito>
</template>

<style scoped></style>
