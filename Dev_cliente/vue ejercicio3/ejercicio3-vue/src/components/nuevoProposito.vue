<script setup>
import ListaPropositos from './listaPropositos.vue'
import { ref } from 'vue'

let propsNuevoProposito = defineProps(['propositos'])
let realizado = ref('')
let nuevoProposito = ref('')

let guardarProposito = () => {
  propsNuevoProposito.propositos.push({
    texto: nuevoProposito.value,
    hecho: false,
  })
}
</script>

<template>
  <h2>Nuevo proposito:</h2>
  <input type="text" name="nuevoProposito" id="nuevoProposito" v-model="nuevoProposito" />
  <button type="button" @click="guardarProposito">Nuevo Proposito</button>
  <select name="realizado" id="realizado" v-model="realizado"></select>
  <option value="Si"></option>
</template>

<style scoped></style>
