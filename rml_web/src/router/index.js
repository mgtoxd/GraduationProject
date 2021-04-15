import { createRouter, createWebHistory } from 'vue-router'
import classfication from '../views/classfication'
import index from '../views/index'
import product from "@/views/product";
import detail from "@/views/detail";
import personInfo from "@/components/menu/personInfo";
import costomized from "@/views/costomized";
import log from "@/views/login/log";
import login from "@/views/login/login";
import regester from "@/views/login/regester";
const routes = [
  {
    path: '/index',
    name: 'index',
    component: index
  },
  {
    path: '/log',
    name: 'log',
    component: log,
    children:[
      {
        path:'login',
        component: login,
      },
      {
        path:'regester',
        component: regester,
      }
    ]
  },
  {
    path: '/costomized',
    name: 'costomized',
    component: costomized
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
