<script setup>
import { onMounted, ref } from "vue";

// 1. Declaramos los 3 estados reactivos
const clientes = ref([]);
const vehiculos = ref([]);
const reparaciones = ref([]);

// 2. Tus 3 funciones fetch por separado
const obtenerClientes = async () => {
  try {
    const response = await fetch("http://localhost:3000/clientes");
    clientes.value = await response.json();
  } catch (error) {
    console.error("Error clientes:", error);
  }
};

const obtenerVehiculos = async () => {
  try {
    const response = await fetch("http://localhost:3000/vehiculos");
    vehiculos.value = await response.json();
  } catch (error) {
    console.error("Error vehiculos:", error);
  }
};

const obtenerReparaciones = async () => {
  try {
    const response = await fetch("http://localhost:3000/reparaciones");
    reparaciones.value = await response.json();
  } catch (error) {
    console.error("Error reparaciones:", error);
  }
};

// 3. La lógica para cruzar los datos
const obtenerTotalReparaciones = (clienteId) => {
  const misCochesIds = vehiculos.value
    .filter((v) => Number(v.clienteId) === Number(clienteId))
    .map((v) => Number(v.id));

  const total = reparaciones.value.filter((rep) =>
    misCochesIds.includes(Number(rep.vehiculoId)) &&
    rep.finalizada === true
  ).length;

  return total;
};

// 4. Llamamos a las 3 funciones al iniciar
onMounted(async () => {
  await obtenerClientes();
   await obtenerVehiculos();
  await obtenerReparaciones();
});
</script>

<template>
  <h2>Clientes</h2>

  <div>
    <table>
      <tr>
        <th>Nombre</th>
        <th>Total reparaciones</th>
      </tr>
      <tr v-for="c in clientes" :key="c.id">
        <td>{{ c.nombre }}</td>
        <td>{{ obtenerTotalReparaciones(c.id) }}</td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse; /* Elimina el espacio doble entre bordes */
  margin-top: 20px;
  font-family: sans-serif;
  background-color: #fff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

th,
td {
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
