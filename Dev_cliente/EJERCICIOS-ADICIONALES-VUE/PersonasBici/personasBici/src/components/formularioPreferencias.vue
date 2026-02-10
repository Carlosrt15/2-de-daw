<script setup>
import { ref } from 'vue'

const props = defineProps(['onSubmit', 'bloqueadas']);

let nombreUsuario = ref("");
let etapaUsuario = ref("");
let diaUsuario = ref("");




const crearUsuario = () => {
    // crear variable para luego añadir en el app.vue
    const nuevoUsuario = {
        nombre: nombreUsuario.value,
        disponibilidad: etapaUsuario.value,
        diaSemana: diaUsuario.value
    };

    props.onSubmit(nuevoUsuario);
    // Limpiar los campos despues

    nombreUsuario.value = "";
    etapaUsuario.value = "";
    diaUsuario.value = "";
}

const franjaBloqueada = (franja) => {
    return props.bloqueadas.some(
        b => b.dia === diaUsuario.value && b.franja === franja
    )
}

</script>


<template>

    <form @submit.prevent="crearUsuario">

        <label for="nombre">Nombre</label>
        <input type="text" placeholder="Introduce tu nombre" required v-model="nombreUsuario"><br><br>

        <select name="etapa" id="etapa" required v-model="etapaUsuario">
            <option value="mañana" :disabled="franjaBloqueada('mañana')">
                mañana
            </option>

            <option value="tarde" :disabled="franjaBloqueada('tarde')">
                tarde
            </option>

            <option value="noche" :disabled="franjaBloqueada('noche')">
                noche
            </option>
        </select><br><br>

        <select name="dia" id="dia" required v-model="diaUsuario">
            <option value="lunes">lunes</option>
            <option value="martes">martes</option>
            <option value="miercoles">miercoles</option>
            <option value="jueves">jueves</option>
            <option value="viernes">viernes</option>
            <option value="sabado">sabado</option>
            <option value="domingo">domingo</option>
        </select><br><br>

        <button type="submit">Enviar</button>

    </form>


</template>


<style scoped>
form {
    background-color: aquamarine;
}
</style>