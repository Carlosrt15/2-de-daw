<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const articulo = ref(null)
const route = useRoute()

onMounted(() => {
  const id = route.params.id

  fetch('https://jsonplaceholder.typicode.com/posts/' + id)
    .then(res => res.json())
    .then(data => {
      articulo.value = data
    })
})
</script>

<template>
  <div v-if="articulo">
    <h1>{{ articulo.title }}</h1>
    <p>{{ articulo.body }}</p>
    <p>{{ articulo.id }}</p>
  </div>
</template>