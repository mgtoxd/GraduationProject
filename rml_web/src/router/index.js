import { createRouter, createWebHistory } from 'vue-router'
import classfication from '../views/classfication'
import index from '../views/index'
import product from "@/views/product";
import detail from "@/views/detail";
import personInfo from "@/components/menu/personInfo";
const routes = [
  {
    path: '/index',
    name: 'index',
    component: index
  },
  {
    path: '/detail',
    name: 'detail',
    component: detail
  },
  {
    path: '/classfication',
    name: 'classfication',
    component: classfication
  },
  {
    path: '/product',
    name: 'product',
    component: product
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
