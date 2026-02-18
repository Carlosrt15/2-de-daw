<script setup>
import Bibliografia from '@/components/bibliografia.vue';
defineProps(['listaAutores']);
</script>

<template>
    <main>
        <Bibliografia :listaAutores="listaAutores" />
    </main>
</template>