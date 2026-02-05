<script setup>
import { ref, computed } from 'vue'

import ListaPropositos from './components/listaPropositos.vue'
import NuevoProposito from './components/nuevoProposito.vue'
import TablaCumplidos from './components/tablaCumplidos.vue'

let listaPropositos = ref([
  { texto: 'No fumar', hecho: true },
  { texto: 'No beber', hecho: false },
  { texto: 'Estudiar  DIW', hecho: true },
])

const cumplidos = computed(() => listaPropositos.value.filter((p) => p.hecho))

let borrarLista = () => {
  listaPropositos.value = []
}
</script>

<template>
  <h1>Propositos de año nuevo:</h1>
  <ListaPropositos :propositos="listaPropositos"></ListaPropositos>
  <hr />
  <NuevoProposito @guardar="listaPropositos.push($event)"></NuevoProposito>
  <button type="button" @click="borrarLista">Borrar Lista</button>
  <hr />
  <TablaCumplidos :cumplidos="cumplidos"> </TablaCumplidos>
</template>

<style>
body {
  background-color: rgb(253, 215, 166);
  color: rgba(13, 129, 91, 0.678);
}
</style>
