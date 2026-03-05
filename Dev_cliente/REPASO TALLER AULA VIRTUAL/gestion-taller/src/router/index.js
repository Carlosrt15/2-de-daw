import ClientesView from '@/view/ClientesView.vue';
import PanelView from '@/view/PanelView.vue';
import RepacionesView from '@/view/RepacionesView.vue';
import VehiculosView from '@/view/VehiculosView.vue';
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {path:'/panel', name: 'Panel', component:PanelView},
  {path:'/clientes', name: 'Clientes', component:ClientesView},
  {path:'/vehiculos', name: 'Vehiculos', component:VehiculosView},
  {path:'/reparaciones', name: 'Reparaciones', component:RepacionesView},
];


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
