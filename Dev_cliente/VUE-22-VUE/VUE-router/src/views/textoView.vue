<script setup>
import { useRoute } from 'vue-router'
import { computed } from 'vue'

const route = useRoute()

const textos = [
    "Este es el texto 1",
    "Este es el texto 2",
    "Este es el texto 3"
]

const mensaje = computed(() => {
    const id = parseInt(route.params.id)

    if (id >= 1 && id <= 3) {
        return textos[id - 1]
    } else {
        return "No hay valor almacenado para " + route.params.id
    }
})
</script>

<template>
    <h1>{{ mensaje }}</h1>
</template>
