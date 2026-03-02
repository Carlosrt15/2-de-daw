import AcercaDelCentro from '@/views/AcercaDelCentro.vue'
import AsteroidesCercanos from '@/views/AsteroidesCercanos.vue'
import BusquedaPorId from '@/views/BusquedaPorId.vue'
import DetalleDelAsteroide from '@/views/DetalleDelAsteroide.vue'
import ImagenDelDia from '@/views/ImagenDelDia.vue'
import PanelPrincipal from '@/views/PanelPrincipal.vue'
import { createRouter, createWebHistory } from 'vue-router'


const routes = [
  { path: "/", name:"PanelPrincipal", component:PanelPrincipal},
  { path: "/astCercano", name:"AsteroideCercano", component:AsteroidesCercanos},
  { path: "/busquedaID", name:"BusquedaPorId", component:BusquedaPorId},
    { path: "/imagen", name:"ImagenDelDia", component:ImagenDelDia},
     { path: "/acercaDe", name:"AcercaDe", component:AcercaDelCentro},
    { path: "/asteroide/:id", name:"DetalleAsteroide", component:DetalleDelAsteroide},

]
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes,
})

export default router
