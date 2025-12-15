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

function tomarNombre() {
  const errores = [];

  let tomarCampoNombre = document.getElementById("Nombre");

  if (tomarCampoNombre === "") {
    errores.push("Nombre");

  } else {
    alert(tomarCampoNombre);
  }

  console.log(errores);
}

