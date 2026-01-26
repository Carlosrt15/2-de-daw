const { createApp, ref } = Vue;

createApp({
    setup() {
        let prendas = ref([

        ]);
        let inputPrenda = ref('');
        let inputColor = ref('');
        let inputTalla = ref('');
        let inputPrecio = ref('');

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
            }

        };

        const cambiarPlace = () => {
            inputPrecio.value;
        };

        return {
            prendas,
            inputPrenda,
            inputColor,
            inputTalla,
            inputPrecio,
            agregarPrenda,
            cambiarPlace
        }
    }

}).mount("#app");