<script setup>
import {  computed } from 'vue';

const props = defineProps(['usuarios']);


const mayoresEdad = computed(()=>
    props.usuarios.filter(
        u => u.edad >= 18
    )
)

</script>



<template>
<h3>Mayores de 18 </h3>

<ul v-if="mayoresEdad.length">

<li v-for="u in mayoresEdad" :key="u.id">
    {{ u.nombre }} -- {{ u.edad }} años
</li>

</ul>


</template>


<style scoped>
li{
    color: rgb(236, 142, 20);
}

</style>