<script setup>
import FormularioCitas from "./FormularioCitas.vue";

const props = defineProps({
  citas: Object,
  diaSeleccionado: Number,
});

const emit = defineEmits(["seleccionar-dia", "guardar-cita"]);

const calendario = [
  [1, 2, 3, 4, 5, 6, 7],
  [8, 9, 10, 11, 12, 13, 14],
  [15, 16, 17, 18, 19, 20, 21],
  [22, 23, 24, 25, 26, 27, 28],
];

function reenviarCita(datos) {
  emit("guardar-cita", datos)
}

</script>

<template>
  <div class="calendario">
    <h2>Febrero 2021</h2>

    <table>
      <thead>
        <tr>
          <th>Lun</th>
          <th>Mar</th>
          <th>Mié</th>
          <th>Jue</th>
          <th>Vie</th>
          <th>Sáb</th>
          <th>Dom</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(semana, i) in calendario" :key="i">
          <td
            v-for="dia in semana"
            :key="dia"
            :class="{
              conCita: citas[dia],
              seleccionado: diaSeleccionado === dia,
            }"
            @dblclick="$emit('seleccionar-dia', dia)"
          >
            {{ dia }}
          </td>
        </tr>
      </tbody>
    </table>

    <FormularioCitas @guardar-cita="reenviarCita" />

  </div>
</template>

<style scoped>
.calendario {
  width: 60%;
}

.conCita {
  color: red;
  font-size: 1.2em;
  font-weight: bold;
}

.seleccionado {
  background-color: #b6f2b6;
}
</style>
