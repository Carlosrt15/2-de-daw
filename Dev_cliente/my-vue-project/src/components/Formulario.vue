<template>
  <form @submit.prevent="enviarFormulario">
      <div>
          <label for="Nombre">Nombre</label>
          <input v-model="form.nombre" type="text" id="Nombre" />
      </div>

      <div>
        <label for="Mensaje">Mensaje:</label>
        <textarea v-model="form.mensaje" id="Mensaje" placeholder="Aqui saldra la respuesta"></textarea>
      </div>
      <br><br>

      <button type="button" id="boton" onclick="tomarNombre()">Boton</button>

  </form>
</template>

<script src="./Formulario.js"></script>

<style>
form {
  display: flex;
  flex-direction: column;
  width: 300px;
  gap: 10px;
  background-color: aquamarine;
}
</style>
