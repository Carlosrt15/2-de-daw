const { createApp, ref, reactive, computed } = Vue;

// ref una cosa
// reactive cojunto cosas tipo array

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
                personas.push({nombre: nombreAñadir.value});
                nombreAñadir.value ="";
            }
        }
       
        return {
            personas,
            nombreAñadir,
            añadirPersona
            
        };



    }


}).mount("#lista");




