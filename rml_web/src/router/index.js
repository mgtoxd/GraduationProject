import { createRouter, createWebHistory } from 'vue-router'
import classfication from '../views/classfication'
import index from '../views/index'
const routes = [
  {
    path: '/index',
    name: 'index',
    component: index
  },
  {
    path: '/classfication',
    name: 'classfication',
    component: classfication
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
