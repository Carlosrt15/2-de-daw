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

table {
  width: 100%;
  border-collapse: collapse; /* Elimina el espacio doble entre bordes */
  margin-top: 20px;
  font-family: sans-serif;
  background-color: #fff;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

th, td {
  padding: 12px 15px;
  text-align: center;
  border: 1px solid #ddd;
}

th {
  background-color: #42b983; /* Color verde típico de Vue */
  color: white;
  text-transform: uppercase;
  font-size: 0.9rem;
  letter-spacing: 1px;
}

/* Efecto cebra para las filas */
tr:nth-child(even) {
  background-color: #f8f8f8;
}

/* Efecto hover para resaltar la fila al pasar el ratón */
tr:hover {
  background-color: #f1f1f1;
  transition: background-color 0.3s ease;
}

h2 {
  color: #2c3e50;
  border-bottom: 2px solid #42b983;
  padding-bottom: 5px;
  display: inline-block;
}


</style>