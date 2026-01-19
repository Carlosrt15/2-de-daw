const { createApp, ref, reactive, computed } = Vue;


createApp({
  setup() {
    // Propiedades reactivas
    
    const nuevoProp = ref("");
    const propositos = reactive([
      { texto: "Hacer deporte", hecho: false },
      { texto: "Comer más sano", hecho: false },
      { texto: "Viajar más", hecho: true }
    ]);
    

    // Añadir propósito
    const anadirProposito = () => {
      if (nuevoProp.value.trim() !== "") {
        propositos.push({
          texto: nuevoProp.value,
          hecho: false
        });
        nuevoProp.value = "";
      }
    };

    // Borrar un propósito (doble click)
    const borrarProposito = (index) => {
      propositos.splice(index, 1);
    };

    // Borrar todos con confirmación
    const borrarTodos = () => {
      if (confirm("¿Seguro que quieres borrar todos los propósitos?")) {
        propositos.splice(0);
      }
    };
    // saber los propositos true que
    const hechos = computed(() => {
      return propositos.filter(p => p.hecho).length
    });
    // cambia style dependiendo de la cantidad de propositos
    const titulo = computed(() => {
      if(hechos.value > 5) {
        return "cRosa";
      } else if (hechos.value > 3){
        return "cAmarillo";
      } else {
        return "";
      }
    });
    cons tipoProposito = computed(() =>

    return {
      nuevoProp,
      propositos,
      anadirProposito,
      borrarProposito,
      borrarTodos,
      hechos,
      titulo
    };

    
  }



 
}).mount("#app");
