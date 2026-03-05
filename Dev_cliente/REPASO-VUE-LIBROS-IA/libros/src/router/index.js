import InicioView from '@/views/InicioView.vue';
import LibrosView from '@/views/LibrosView.vue';
import NuevoLibroView from '@/views/NuevoLibroView.vue';
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {path:'/' , name: 'Inicio', component: InicioView },
    {path:'/Libros' , name: 'Libros', component: LibrosView },
    {path:'/NuevoLibro' , name: 'NuevoLibro', component: NuevoLibroView },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
