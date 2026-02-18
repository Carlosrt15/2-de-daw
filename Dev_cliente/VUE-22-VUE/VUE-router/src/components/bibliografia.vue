<script setup>
import casaDeLibro from './casaDeLibro.vue';

</script>
<template>
    <h1>Bibliografía por países</h1>

    <ol>
        <li>España
            <ul>
                <li>Miguel de Cervantes</li>
                <li>Federico García Lorca</li>
                <li>Arturo Pérez-Reverte</li>
                <li>Javier Castillo</li>
                <li>Carlos Ruiz Zafón</li>
            </ul>
        </li>

        <li>Argentina
            <ul>
                <li>Jorge Luis Borges</li>
                <li>Julio Cortázar</li>
                <li>Ernesto Sabato</li>
                <li>Adolfo Bioy Casares</li>
                <li>Silvina Ocampo</li>
            </ul>
        </li>

        <li>México
            <ul>
                <li>Octavio Paz</li>
                <li>Juan Rulfo</li>
                <li>Carlos Fuentes</li>
                <li>Laura Esquivel</li>
                <li>Elena Poniatowska</li>
            </ul>
        </li>

        <li>Chile
            <ul>
                <li>Pablo Neruda</li>
                <li>Isabel Allende</li>
                <li>Roberto Bolaño</li>
                <li>Gabriela Mistral</li>
                <li>Nicanor Parra</li>
            </ul>
        </li>

        <li>Colombia
            <ul>
                <li>Gabriel García Márquez</li>
                <li>Álvaro Mutis</li>
                <li>Laura Restrepo</li>
                <li>Fernando Vallejo</li>
                <li>Jorge Isaacs</li>
            </ul>
        </li>

        <li>Perú
            <ul>
                <li>Mario Vargas Llosa</li>
                <li>César Vallejo</li>
                <li>José María Arguedas</li>
                <li>Alfredo Bryce Echenique</li>
                <li>Clorinda Matto de Turner</li>
            </ul>
        </li>

        <li>Francia
            <ul>
                <li>Victor Hugo</li>
                <li>Gustave Flaubert</li>
                <li>Albert Camus</li>
                <li>Émile Zola</li>
                <li>Antoine de Saint-Exupéry</li>
            </ul>
        </li>

        <li>Reino Unido
            <ul>
                <li>William Shakespeare</li>
                <li>Jane Austen</li>
                <li>George Orwell</li>
                <li>J.K. Rowling</li>
                <li>Agatha Christie</li>
            </ul>
        </li>

        <li>Estados Unidos
            <ul>
                <li>Ernest Hemingway</li>
                <li>Mark Twain</li>
                <li>Edgar Allan Poe</li>
                <li>Stephen King</li>
                <li>Toni Morrison</li>
            </ul>
        </li>

        <li>Italia
            <ul>
                <li>Dante Alighieri</li>
                <li>Umberto Eco</li>
                <li>Italo Calvino</li>
                <li>Alessandro Manzoni</li>
                <li>Giovanni Boccaccio</li>
            </ul>
        </li>
    </ol>


    <casaDeLibro />

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
    /* centra horizontalmente */
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

/* numeración bonita */
ol {
    counter-reset: item;
}

ol>li::marker {
    color: #2c7be5;
    font-weight: bold;
}
</style>
