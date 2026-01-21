const { createApp, ref, reactive } = Vue;

const app = createApp({
    setup() {


        let estilosBorde = ref([true, true, true]);
        let nombreTemporal = ref(["", "", ""]);

        let datosImagenes = ref([
            {
                url: "./img/Colise1.jpg",
                nombre: "Colise1",
                contador: 0
            },
            {
                url: "./img/Colise1.jpg",
                nombre: "Colise2",
                contador: 0
            },

            {
                url: "./img/Grecia3.jpg",
                nombre: "Postureo Grecia",
                contador: 0
            }
        ]);

        let cambiarEstiloBorde = (index) => {
            estilosBorde.value[index] = !estilosBorde.value[index];
        };

        let aumentarContador = (index) => {
            datosImagenes.value[index].contador++;
        };

        let cambiarNombre = (index) => {
           datosImagenes.value[index].nombre = nombreTemporal.value[index];
           nombreTemporal.value[index] = "";

        };
        return {
            datosImagenes,
            estilosBorde,
            cambiarEstiloBorde,
            aumentarContador,
            nombreTemporal,
            cambiarNombre
        }
    }
}).mount("#app");