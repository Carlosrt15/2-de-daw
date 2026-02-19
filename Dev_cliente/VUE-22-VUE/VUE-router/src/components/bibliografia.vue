<script setup>
import CasaDeLibro from './casaDeLibro.vue'

defineProps(['listaAutores'])
</script>

<template>
    <h1>Bibliografía por países</h1>

    <ol>
        <li v-for="(item, index) in listaAutores" :key="index">
            {{ item.pais }}
            <ul>
                <li v-for="(autor, idx) in item.autores" :key="idx">
                    {{ autor }}
                </li>
            </ul>
        </li>
    </ol>

    <CasaDeLibro />
</template>

<style scoped>
body {
    background: #f4f6f8;
    font-family: "Segoe UI", Arial, sans-serif;
}

/* contenedor */
ol {
    max-width: 600px;
    margin: 40px auto;
    padding: 30px;
    background: white;
    border-radius: 14px;
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.12);
}

/* titulo */
h1 {
    text-align: center;
    color: #2c3e50;
    margin-top: 30px;
    letter-spacing: 1px;
}

/* países */
ol>li {
    font-weight: bold;
    font-size: 18px;
    margin-bottom: 18px;
    color: #34495e;
}

/* lista de escritores */
ul {
    margin-top: 8px;
    padding-left: 25px;
}

/* cada escritor */
ul li {
    font-weight: normal;
    font-size: 15px;
    margin: 4px 0;
    color: #555;
    transition: all .2s ease;
}

/* efecto hover */
ul li:hover {
    color: #2c7be5;
    transform: translateX(4px);
}

ol>li::marker {
    color: #2c7be5;
    font-weight: bold;
}
</style>
