const { createApp, ref, reactive, computed } = Vue;


createApp({
    setup() {
        // dato reactivo 
        const contador = ref(0);

        // suma
        const sumar = () => {
            contador.value++;
        };

        const restar = () => {
            if (contador.value > 0) {
                contador.value--;
            }

        };

        return {
            contador,
            sumar,
            restar
        };
    }
}).mount("#app");