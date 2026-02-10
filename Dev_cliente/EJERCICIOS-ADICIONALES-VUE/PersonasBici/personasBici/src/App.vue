<script setup>
import { ref } from 'vue'
import FormularioPreferencias from './components/formularioPreferencias.vue';



let altaUsuarios = ref([
  {nombre:"Carlos", disponibilidad:"tarde", diaSemana:"lunes"}
]);

const agregarUsuario = (nuevoUsuario) => {
  altaUsuarios.value.push(nuevoUsuario);
};

</script>

<template>
  <h1>Lista de personas en bici</h1>
  <FormularioPreferencias :onSubmit="agregarUsuario"></FormularioPreferencias>
</template>

<style scoped></style>
