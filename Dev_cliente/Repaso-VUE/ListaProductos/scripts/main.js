const { createApp, ref, reactive, computed } = Vue;

 createApp({
    setup() {
        const productos = ref([
            { nombre: "Patatas", precio: 12, oferta: false, contador:0 },
            { nombre: "Pescado", precio: 22, oferta: true,contador:1 },
            { nombre: "Red Bull", precio: 2, oferta: false, contador:12 },
            { nombre: "Vodka ", precio: 6, oferta: true,contador:22 }


        ]);

        

        return {
            productos

        };
    }




}).mount("#app");