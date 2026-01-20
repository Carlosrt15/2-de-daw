const { createApp, ref, reactive, computed } = Vue;


createApp({
    setup() {
        const texto = ref("Hola desde Vue");

        return {
            texto
        };

    }


}).mount("#ap1");