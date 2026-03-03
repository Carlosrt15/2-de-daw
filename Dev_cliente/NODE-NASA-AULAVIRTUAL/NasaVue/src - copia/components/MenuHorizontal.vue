<script setup>

</script>

<template>
<h2>Menu Horizontal</h2>
<nav>
    <ul>
        <li><RouterLink to="/">Panel Principal</RouterLink></li>
        <li><RouterLink to="/imagen">Imagen del dia</RouterLink></li>
        <li><RouterLink to="/astCercano">Asteroides Cercanos</RouterLink></li>
        <li> <RouterLink to="busquedaID">Busqueda por ID</RouterLink></li>
        <li> <RouterLink to="acercaDe">Acerca del centro</RouterLink> </li>
    </ul>
</nav>
<RouterView></RouterView>

</template>

<style scoped>

</style>