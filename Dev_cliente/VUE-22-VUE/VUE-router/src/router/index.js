import BibliografiaView from '@/views/bibliografiaView.vue'
import TextoView from '@/views/textoView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/bibliografia',
      name: 'bibliografia',
      component: BibliografiaView,
    },
    {
      path: '/ruta/:id',
      name: 'texto',
      component: TextoView
    }

  ],
})

export default router
