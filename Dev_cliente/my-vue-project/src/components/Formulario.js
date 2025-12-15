export default {
  data() {
    return {
      form: {
        nombre: "",
        mensaje: "",
      },
    };
  },

  methods: {
    enviarFormulario() {
      console.log("Formulario enviado:", this.form);
      alert("Enviado correctamente");
    },
  },
};
