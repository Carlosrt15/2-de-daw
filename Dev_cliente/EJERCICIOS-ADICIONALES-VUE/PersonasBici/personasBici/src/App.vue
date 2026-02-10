<script setup>
import { computed, ref } from 'vue'
import FormularioPreferencias from './components/formularioPreferencias.vue';
import TablaGruposEnFormacion from './components/tablaGruposEnFormacion.vue';
import TablaGrupoFormados from './components/tablaGrupoFormados.vue';

const combinacionBloqueada = computed(()=>{

    return gruposFormados.value.map(g => ({
      dia: g.dia,
      franja: g.franja
    }));
});



const agregarUsuario = (nuevoUsuario) => {
  // Buscar grupo existente
  let grupo = gruposEnFormacion.value.find(
    g =>
      g.dia === nuevoUsuario.diaSemana &&
      g.franja === nuevoUsuario.disponibilidad
  );

  if (!grupo) {
    // Crear nuevo grupo
    grupo = {
      id: siguienteId++,
      dia: nuevoUsuario.diaSemana,
      franja: nuevoUsuario.disponibilidad,
      participantes: []
    };
    gruposEnFormacion.value.push(grupo);
  }

  // Añadir usuario
  grupo.participantes.push(nuevoUsuario.nombre);

  // Si llega a 5 → mover a grupos formados
  if (grupo.participantes.length === 5) {
    gruposFormados.value.push(grupo);
    gruposEnFormacion.value = gruposEnFormacion.value.filter(g => g !== grupo);
  }
};


// Grupos

const gruposEnFormacion = ref([]);
const gruposFormados = ref([]);
let siguienteId = 1;




</script>

<template>
  <h1>Lista de personas en bici</h1>
  <FormularioPreferencias :onSubmit="agregarUsuario" :bloqueadas="combinacionBloqueada"></FormularioPreferencias>
  <TablaGruposEnFormacion :grupos="gruposEnFormacion"></TablaGruposEnFormacion>
  <TablaGrupoFormados :grupos="gruposFormados"></TablaGrupoFormados>
</template>

<style scoped></style>
