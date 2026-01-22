const { createApp, ref, computed, reactive } = Vue;


createApp({
    setup() {
        const propositos = ref([
            { nombre: "No fumar", cumplido: true, contador:0 },
            { nombre: "No beber", cumplido: true ,contador:0 },
            { nombre: "No comer dulce", cumplido: false ,contador:0 },
            { nombre: "Ir al Gym ", cumplido: true, contador:0 }

        ]);
        
        return {
            propositos,

        }
    }
}).mount("#app");