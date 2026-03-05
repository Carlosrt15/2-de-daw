<script setup>
import {  ref,computed, onMounted } from 'vue';

const libros = ref([]);


const obtenerlibros = async () => {
    const response = await fetch('http://localhost:3000/libros');
    libros.value = await response.json();
}

// Cambiar el estado del libro 
const cambiarEstado = async (libro) => {
    await fetch(`http://localhost:3000/libros/${libro.id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            prestado: !libro.prestado
        })
    });
    // Refresca al llamr otra vez a la funcion
    await obtenerlibros();
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
                    <th>Accion modificar</th>
                </tr>
                <tr v-for="libro in libros" :key="libro.id">
                    <td>{{ libro.titulo }}</td>
                    <td>{{libro.autor}} </td>
                    <td>{{libro.anio}}</td>
                    <td> <span v-if="libro.prestado">Prestado</span>
                        <span v-else>Disponible</span>
                    </td>
                    <td>
                        <button @click="cambiarEstado(libro)">
                            Cambiar estado
                        </button>
                    
                    </td>
                </tr>
            </table>
        </div>

</template>

<style scoped></style>