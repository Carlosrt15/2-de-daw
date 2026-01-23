const { createApp, ref, reactive, computed } = Vue;

 createApp({
    setup() {
        let productos = ref([
            {id:1, nombre: "Patatas", precio: 12, oferta: false, contador:0 },
            {id: 2, nombre: "Pescado", precio: 22, oferta: true,contador:1 },
            {id:3, nombre: "Red Bull", precio: 2, oferta: false, contador:12 },
            {id:4, nombre: "Vodka ", precio: 6, oferta: true,contador:22 }


        ]);

        

        return {
            productos

        };
    }


    
    
    

}).mount("#app");

console.log(productos);