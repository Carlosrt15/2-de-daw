import { createRouter, createWebHistory } from 'vue-router'
import Inicio from '@/views/Inicio.vue'
import Articulos from '@/views/Articulos.vue'
import AcercaDe from '@/views/AcercaDe.vue'
import ArticuloDetalle from '@/views/ArticuloDetalle.vue'
import TablaOwner from '@/views/TablaOwner.vue'


const routes = [
  {path:'/', name:'Inicio', component: Inicio},
  {path:'/articulos', name:'Articulos', component: Articulos},
  {path: '/acercaDe', name: 'AcercaDe', component: AcercaDe},
  {path: '/articulos/:id', component: ArticuloDetalle},
  {path: '/tablaOwner', name:'TablaOwner', component: TablaOwner}

]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})



export default router
