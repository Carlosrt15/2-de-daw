const { createApp, ref, reactive } = Vue; 

const elemento = createApp({
   setup() {
    
    const input = ref(0);

    return {
        input
    };
   } 
});