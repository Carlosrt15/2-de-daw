const {createApp, ref, reactive} = Vue;

const propositos = createApp({
    setup() {

        const nuevoProposito = ref("");

        const Proposito = ref([
            {texto:"Hacer deporte",hecho:true},
            {texto:"Hacer dieta",hecho:false},
            {texto:"No Fumar",hecho:true},
            {texto:"No Beber Alcohol",hecho:true}
            
        ]);
        return {
            Proposito,
            nuevoProposito
        }
    }
});