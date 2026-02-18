import BibliografiaView from '@/views/bibliografiaView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/bibliografia',
      name: 'bibliografia',
      component: BibliografiaView,
    }

  ],
})

export default router
