<script setup>
import {  ref,computed, onMounted } from 'vue';

/**npx json-server --watch data.json  */

const libros = ref([]);


// funcion obtener libros json server

const obtenerlibros = async () => {
    const response = await fetch('http://localhost:3000/libros');
    libros.value = await response.json();
}

let totalLibros = computed(()=> libros.value.length);

let prestados = computed(() =>
    libros.value.filter(libro => libro.prestado).length
);

let disponibles = computed(() =>
    libros.value.filter(libro => !libro.prestado).length
);


// Ejecutar al cargar componenete

// await necesita declarar async

onMounted( async()=> {
    await obtenerlibros();
});

</script>

<template>

    <h2>Inicio</h2>

    <div>
        <p>Total Libros: {{ totalLibros }}</p>
        <p>Prestados: {{ prestados }}</p>
        <p>Disponibles: {{ disponibles }}</p>
    </div>

</template>

<style scoped></style>