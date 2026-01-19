/**
 * Esta primera línea es la desestructuración del objeto Vue, equivalente a escribir:
 *    const createApp = Vue.createApp;
 *    const ref = Vue.ref;
 *    const computed = Vue.computed;
 * Ó equivalente a usar directamente Vue.createApp(), Vue.ref(), Vue.computed()
 * La desectructuración extrae propiedades del objeto global Vue y crea constantes locales con esos nombres. 
 * No es código de Vue, es JavaScript puro y Vue es solo el objeto del que sacamos los métodos.
*/
const { createApp, ref, computed } = Vue; 

const appClases = createApp({
  setup() {
    const clasesH21 = ref("fondoVerdeCentrado textoXNegritaXLarge");
    const negrita = ref(true);
    const blanco = ref(true);
    const fondoVerde = ref(true);
    const fondo1 = ref("fondoAzulDerecha");
    const texto1 = ref("textoXNegritaXLarge");
    let valor = ref(0);

    return {
      clasesH21,
      negrita,
      blanco,
      fondoVerde,
      fondo1,
      texto1,
      valor
    };
  }
});

const appComputed = createApp({
  setup() {
    let valor = ref(0);

    const incrementarValor = () => {
      valor.value++;
    };

    const decrementarValor = () => {
      valor.value--;
    };

    const asignarClase = computed(() => {
      return valor.value >= 25
        ? 'fondoVerdeCentrado textoXNegritaXLarge'
        : 'textoBlancoNegrita fondoAzulDerecha';
    });

    return {
      valor,
      incrementarValor,
      decrementarValor,
      asignarClase
    };
  }
});