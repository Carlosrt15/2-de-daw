<script setup>
const fechaActual = new Date()

const dia = fechaActual.getDate()
const mes = fechaActual.getMonth() + 1
const año = fechaActual.getFullYear()
const hora = fechaActual.getHours()
const minutos = fechaActual.getMinutes()
const segundos = fechaActual.getSeconds()
</script>

<template>
  <div>
    <h1>
      {{ dia }}/{{ mes }}/{{ año }} -
      {{ hora }}:{{ minutos }}:{{ segundos }}
    </h1>
  </div>
</template>

<style scoped>
</style>