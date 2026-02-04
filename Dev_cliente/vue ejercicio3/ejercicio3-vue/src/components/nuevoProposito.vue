<script setup>
import ListaPropositos from './listaPropositos.vue'
import { ref } from 'vue'

let propsNuevoProposito = defineProps(['propositos'])
let realizado = ref('NO')
let nuevoProposito = ref('')
const emit = defineEmits(['guardar'])

let guardarProposito = () => {
  emit('guardar', {
    texto: nuevoProposito.value,
    hecho: realizado.value === 'SI',
  })
  realizado.value = 'NO'
  nuevoProposito.value = ''
}
</script>

<template>
  <h2>Nuevo proposito:</h2>
  <input type="text" name="nuevoProposito" id="nuevoProposito" v-model="nuevoProposito" />
  <button type="button" @click="guardarProposito">Nuevo Proposito</button><br /><br />
  <select name="realizado" id="realizado" v-model="realizado">
    <option value="">Selecciona una opcion</option>
    <option value="SI">Cumplido</option>
    <option value="NO">No cumplido</option>
  </select>
  <option value="Si"></option>
</template>

<style scoped></style>
