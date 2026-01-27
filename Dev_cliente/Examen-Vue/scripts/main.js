const { createApp, ref, computed } = Vue;

createApp({
    setup() {

        
        const prendas = ref([]);

        const inputPrenda = ref('');
        const inputColor = ref('');
        const inputTalla = ref('');
        const inputPrecio = ref('');

        
        const cambiarPlace = ref(0);

        // --- MÉTODOS ---

        const agregarPrenda = () => {
            if (inputPrenda.value && inputColor.value && inputTalla.value && inputPrecio.value) {
                prendas.value.push({
                    prenda: inputPrenda.value,
                    color: inputColor.value,
                    talla: inputTalla.value,
                    precio: inputPrecio.value
                });

                // limpiar inputs
                inputPrenda.value = '';
                inputColor.value = '';
                inputTalla.value = '';
                inputPrecio.value = '';
                cambiarPlace.value = 0;
            }
        };

        const venderPrenda = (index) => {
            prendas.value.splice(index, 1);
        };

        
        const prendasDisponibles = computed(() => {
            return prendas.value;
        });

        
        return {
            prendas,
            prendasDisponibles,
            inputPrenda,
            inputColor,
            inputTalla,
            inputPrecio,
            cambiarPlace,
            agregarPrenda,
            venderPrenda
        };
    }
}).mount("#app");
