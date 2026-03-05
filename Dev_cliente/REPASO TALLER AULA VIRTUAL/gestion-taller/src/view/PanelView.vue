<script setup>
import { computed, onMounted, ref } from 'vue';


const clientes = ref([]);
const vehiculos = ref([]);
const reparacionesPendientes = ref([]);

// Funcion para traer los datos del json server

const obtenerDatosCliente = async () => {
    try{
        const response = await fetch('http://localhost:3000/clientes');
        clientes.value = await response.json();
    } catch (error) {
        console.error("Erorr al conectar al JSON Server:", error);
    }
}

const obtenerDatosvehiculos = async () => {
    try{
        const response = await fetch('http://localhost:3000/vehiculos');
        vehiculos.value = await response.json();
    } catch (error) {
        console.error("Erorr al conectar al JSON Server:", error);
    }
}

const obtenerDatosreparacionesPendientes = async () => {
    try{
        const response = await fetch('http://localhost:3000/reparaciones');
        reparacionesPendientes.value = await response.json();
    } catch (error) {
        console.error("Erorr al conectar al JSON Server:", error);
    }
}

let totalvehiculos = computed(() => vehiculos.value.length);
let totalClientes = computed(() => clientes.value.length);
let totalreparacionesPendientes = computed(() => reparacionesPendientes.value.length);
    

    // Ejecutar carga cuando el componente se monte

    onMounted(()=>{
        obtenerDatosCliente(); 
        obtenerDatosvehiculos(); 
        obtenerDatosreparacionesPendientes();
    });
</script>

<template>
    <h2>Panel</h2>

    <table>
        <tr>
            <th>Clientes</th>
            <th>Vehículos</th>
            <th>reparaciones pendientes</th>
        </tr>
        <tr>
            <td>{{ totalClientes }}</td>
            <td>{{ totalvehiculos }}</td>
            <td>{{ totalreparacionesPendientes }}</td>

        </tr>
    </table>


</template>

<style scoped>

</style>