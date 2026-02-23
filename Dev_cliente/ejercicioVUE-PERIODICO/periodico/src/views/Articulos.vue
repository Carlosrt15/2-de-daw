<script>
export default {
  data() {
    return {
      articulos: []
    }
  },
  mounted() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(res => res.json())
      .then(data => {
        this.articulos = data
      })
  }
}
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