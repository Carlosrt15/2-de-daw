const {createApp, ref, computed, reactie} = Vue;

createApp({
    setup() {

        const alumnos = ref([
            {id: 1, nombre:"Carlos", faltas: 0, apto: true},
            {id: 2, nombre:"Elena", faltas: 2, apto: false},
            {id: 3, nombre:"Javier", faltas: 12, apto: true},
            {id: 4, nombre:"Maria", faltas: 4, apto: false},
        ]);


        return {
            alumnos,

        };
    }





}).mount("#app");
