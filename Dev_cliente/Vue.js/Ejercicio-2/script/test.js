const { createApp, ref, reactive } = Vue;

const elemento = createApp({
    setup() {

        const elemento1 = ref("tabla");

        return {
            elemento1
        };
    }
});


const elemento2 = createApp({
    setup() {
        const personas = ref([
            { dni: "70960901J", nombre: "Carlos", apellidos: "Rodríguez" },
            { dni: "70955901Z", nombre: "Nerea", apellidos: "Santós" }

        ]);

        return {
            personas
        };
    }

});