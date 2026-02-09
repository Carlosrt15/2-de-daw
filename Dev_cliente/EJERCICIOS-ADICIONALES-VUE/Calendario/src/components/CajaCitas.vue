<script setup>
defineProps({
  dia: Number,
  cita: String
})
</script>



<template>
  <div class="citas">
    <h2>Citas del día {{ dia ?? "-" }}</h2>

    <p v-if="cita">
      {{ cita }}
    </p>
    <p v-else>
      No hay citas para este día.
    </p>
  </div>
</template>



<style scoped>
.citas {
  width: 40%;
  border: 1px solid #ccc;
  padding: 20px;
}
</style>
