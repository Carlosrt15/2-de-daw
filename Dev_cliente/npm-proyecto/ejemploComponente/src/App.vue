<template>
  <footer></footer>

  <h1>{{ mensaje }}</h1>
  <br />
  <h2>{{ mensaje2 }}</h2>
  <hr />

  <span>Libros disponibles:</span>
  <ListaLibros :libros="libros" />

  <hr />

  <PiePagina :tel-user="telefono" dir="C/Arriba 25" />
</template>

<script>
import { ref } from 'vue'
import PiePagina from './components/PiePagina.vue'
import ListaLibros from './components/ListaLibros.vue'

export default {
  name: 'App',
  components: {
    PiePagina,
    ListaLibros,
  },
  setup() {
    const mensaje2 = ref('Creador por Carlos en Vue')
    const mensaje = ref('Librería Mi Mundo de Papel')
    const telefono = ref(923451111)
    const libros = ref([
      { titulo: 'La villa de las telas' },
      { titulo: 'La isla de las tormentas' },
      { titulo: 'Dime quien soy' },
      { titulo: 'Juego de espadas' },
    ])

    const mostrarAlerta = () => {
      alert('Número de libros almacenados: ' + libros.value.length)
    }

    return {
      mensaje,
      telefono,
      libros,
      mostrarAlerta,
      mensaje2,
    }
  },
}
</script>

<style>
h1 {
  text-align: center;
  background-color: aquamarine;
}

h2 {
  text-align: center;
  background-color: aquamarine;
}
</style>
