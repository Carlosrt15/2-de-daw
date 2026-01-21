const { createApp, ref, reactive, computed } = Vue;

// ref una cosa
// reactive varias cosas tipo: array

createApp({
    setup() {

        const personas = reactive([
            { nombre: "Carlos" },
            { nombre: "Ana" },
            { nombre: "Javier" },
            { nombre: "Teresa" }

        ]);

        // Añadir persona al array mediente boton 
        let nombreAñadir = ref("");

        let añadirPersona = () => {
            if (nombreAñadir.value !== "") {
                personas.push({ nombre: nombreAñadir.value });
                nombreAñadir.value = "";
            }
        }

        //Borrar
        const borraPersona = () => {
            const index = personas.findIndex(
                p => p.nombre === nombreAñadir.value);

            if (index !== -1) {
                personas.splice(index, 1);
                nombreAñadir.value = "";
            }
        };

        return {
            personas,
            nombreAñadir,
            añadirPersona,
            borraPersona

        };



    }


}).mount("#lista");




