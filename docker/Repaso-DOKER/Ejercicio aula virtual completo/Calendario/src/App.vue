<template>
  <div class="contenedor">
    <Calendario
      :citas="citas"
      :diaSeleccionado="diaSeleccionado"
      @seleccionar-dia="diaSeleccionado = $event"
      @guardar-cita="guardarCita"
    />

    <CajaCitas
      :dia="diaSeleccionado"
      :cita="citas[diaSeleccionado]"
    />
  </div>
</template>

<script setup>
import { ref } from "vue"
import Calendario from "./components/Calendario.vue"
import CajaCitas from "./components/CajaCitas.vue"

const citas = ref({})
const diaSeleccionado = ref(null)

function guardarCita({ dia, texto }) {
  citas.value[dia] = texto
}
</script>


<style>
.contenedor {
  display: flex;
  padding: 20px;
  gap: 20px;
}
</style>
