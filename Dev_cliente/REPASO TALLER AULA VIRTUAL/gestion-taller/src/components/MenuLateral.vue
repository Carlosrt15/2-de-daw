<template>
  <div class="wrapper">
    
    <header>
      <h1>Talleres Hernández – Gestión Interna</h1>
      <nav>
        <RouterLink to="/panel">Panel</RouterLink> |
        <RouterLink to="/vehiculos">Vehículos</RouterLink> |
        <RouterLink to="/reparaciones">Reparaciones</RouterLink> |
        <RouterLink to="/clientes">Clientes</RouterLink>
      </nav>
    </header>

    
    <main class="central">
      <RouterView />
    </main>

    
    <footer>
      <p>Contacto: info@tallereshernandez.com - Tel: 555-1234</p>
      <a href="#">Instagram</a> | <a href="#">Facebook</a>
    </footer>
  </div>
</template>

<style scoped>
/* Estructura básica */
.wrapper {
  display: flex;
  flex-direction: column;
  align-items: center; /* Centra el contenido */
  min-height: 100vh;
}

header, footer {
  width: 100%;
  text-align: center;
  background: #eee;
  padding: 10px;
}

/* Requisito: Zona central al 80% */
.central {
  width: 80%;
  flex: 1; /* Ocupa el espacio restante */
  background: #fff;
  padding: 20px;
  border-left: 1px solid #ccc;
  border-right: 1px solid #ccc;
}

nav {
  margin-top: 10px;
}
</style>
