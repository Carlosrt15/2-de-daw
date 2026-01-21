const {createApp, ref, reactive} = Vue;

const app = createApp({
    setup() {
        let estilosBorde = ref(true,true,true);

        let datosImagenes = ref([
            {
            url:"./img/Colise1.jpg",
            nombre:"Colise1",
            contador: 0
            },
            {
            url:"./img/Colise1.jpg",
            nombre:"Colise2",
            contador: 0
            },
            {
            url:"./img/Grecia3.jpg",
            nombre:"Postureo Grecia",
            contador: 0
            }
        ]);

        let cambiarEstiloBorde = (index) => {
            estilosBorde[index] = !estilosBorde[index];
        }
        return {
            datosImagenes,
            estilosBorde,
            cambiarEstiloBorde
        }
    }
}).mount("#app");