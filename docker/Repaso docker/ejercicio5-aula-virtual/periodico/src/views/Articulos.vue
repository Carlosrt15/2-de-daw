<script setup>
import { ref, onMounted } from 'vue'

const articulos = ref([])

onMounted(() => {
  fetch('https://jsonplaceholder.typicode.com/posts')
    .then(res => res.json())
    .then(data => {
      articulos.value = data
    })
})
</script>

<template>
  <div>
    <h1>Artículos</h1>

    <ul>
      <li v-for="articulo in articulos" :key="articulo.id">
        <router-link :to="'/articulos/' + articulo.id">
          {{ articulo.title }}
        </router-link>
      </li>
    </ul>
  </div>
</template>