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



createApp({
    setup() {
        const visible = ref(false);

        const mostrar = () => {
            visible.value = true;

        };
        const ocultar = () => {
            visible.value = false;
        };
        return {
            visible,
            mostrar,
            ocultar
        };
    }
    
     // llamar igual que la id asignada al div 
}).mount("#texto");

// formulario que sabe si escribiste  

createApp({
    setup() {
     const texto = ref("");

     return {
        texto
     };
    }
}).mount("#input");