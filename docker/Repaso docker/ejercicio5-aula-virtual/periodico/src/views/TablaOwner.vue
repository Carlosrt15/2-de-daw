<script setup>
import { ref } from 'vue';

const listaOwners = ref([
    {id:1, name: "Carlos", edad: 25, puesto: "CEO" },
    { id: 2, name: "Ana", edad: 30, puesto: "Redactora" },
    { id: 3, name: "Luis", edad: 28, puesto: "Editor" }

])

</script>

<template>

    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Puesto</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="owner in listaOwners" :key="owner.id">
                <td>{{ owner.name }}</td>
                <td>{{ owner.edad }}</td>
                <td>{{ owner.puesto }}</td>
            </tr>
        </tbody>
    </table>

</template>


<style scoped>
table {
    width: 100%;
    /* Tabla ocupa todo el ancho */
    border-collapse: collapse;
    /* Bordes únicos, no dobles */
    margin: 15px 0;
    /* Espacio alrededor de la tabla */
    font-family: sans-serif;
}

table th,
table td {
    border: 1px solid #ddd;
    /* Borde gris claro */
    padding: 12px;
    /* Espacio interno en celdas */
    text-align: left;
    /* Alineación del texto */
}

table th {
    background-color: #f2f2f2;
    color: #333;
    font-weight: bold;
}
</style>