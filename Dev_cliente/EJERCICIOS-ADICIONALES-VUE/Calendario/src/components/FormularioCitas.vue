<script setup>
import { ref } from "vue"

const emit = defineEmits(["guardar-cita"])

const dia = ref(1)
const texto = ref("")

function enviar() {
  emit("guardar-cita", {
    dia: dia.value,
    texto: texto.value
  })
  texto.value = ""
}
</script>


<template>
  <form class="formulario" @submit.prevent="enviar">
    <select v-model.number="dia">
      <option v-for="d in 28" :key="d" :value="d">
        {{ d }}
      </option>
    </select>

    <input
      type="text"
      v-model="texto"
      maxlength="75"
      required
    />

    <button>Guardar cita</button>
  </form>
</template>



<style scoped>
.formulario {
  margin-top: 15px;
}
</style>
