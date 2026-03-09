<script setup>
import { ref } from 'vue';
import axios from 'axios';


const nuevaSerie = ref({
    nombre: '',
    numCapitulos: 0,
    personajesInput: '', 
    temporadas: 0,
    sinopsis: ''
});

const enviarFormulario = async () => {
    try {
      
        const personajesArray = nuevaSerie.value.personajesInput
            .split(',')
            .map(p => p.trim())
            .filter(p => p !== ""); 

     
        const datosAEnviar = {
            nombre: nuevaSerie.value.nombre,
            numCapitulos: Number(nuevaSerie.value.numCapitulos),
            personajes: personajesArray,
            temporadas: Number(nuevaSerie.value.temporadas),
            sinopsis: nuevaSerie.value.sinopsis,
            valoraciones: [] 
        };

      
        const res = await axios.post('http://localhost:3000/series', datosAEnviar);
        
        alert('Serie guardada con éxito');

        nuevaSerie.value = { nombre: '', numCapitulos: 0, personajesInput: '', temporadas: 0, sinopsis: '' };

    } catch (error) {
        console.error("Error al guardar:", error);
    }
};
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