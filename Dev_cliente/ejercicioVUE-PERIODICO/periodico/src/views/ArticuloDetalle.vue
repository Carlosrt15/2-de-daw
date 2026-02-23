<script>
export default {
  data() {
    return {
      articulo: null
    }
  },
  mounted() {
    const id = this.$route.params.id

    fetch('https://jsonplaceholder.typicode.com/posts/' + id)
      .then(res => res.json())
      .then(data => {
        this.articulo = data
      })
  }
}
</script>

<template>
  <div v-if="articulo">
    <h1>{{ articulo.title }}</h1>
    <p>{{ articulo.body }}</p>
  </div>
</template>