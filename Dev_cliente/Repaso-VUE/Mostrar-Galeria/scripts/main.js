const { createApp, ref, reactive, computed } = Vue;

createApp({
    setup() {
        const imagenes = ref([
            {nombre:"AC2", url:"./img/AC2.jpg", seleccionada: false},
            {nombre:"AC3", url:"./img/AC3.jpg", seleccionada: false}
        ]);

        const seleccionar = (imagenSeleccionada) => {
            for (let imagen of imagenes.value) {
                imagen.seleccionada = false;
            }
            imagenSeleccionada.seleccionada = true;
        }
        
        return {
            imagenes,
            seleccionar
            

        }

    }
}).mount("#galeria");