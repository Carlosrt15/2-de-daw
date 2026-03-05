<script setup>
import {  ref,computed, onMounted } from 'vue';

const libros = ref([]);


const obtenerlibros = async () => {
    const response = await fetch('http://localhost:3000/libros');
    libros.value = await response.json();
}


onMounted(async () => {
    await obtenerlibros();
});
</script>

<template>

    <h2>Libros</h2>

        <div>
            <table>
                <tr>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Año</th>
                    <th>Estado</th>
                </tr>
                <tr v-for="libro in libros" :key="libro.id">
                    <td>{{ libro.titulo }}</td>
                    <td>{{libro.autor}} </td>
                    <td>{{libro.anio}}</td>
                    <td> <span v-if="libro.prestado">Prestado</span>
                        <span v-else>Disponible</span>
                    </td>
                </tr>
            </table>
        </div>

</template>

<style scoped></style>