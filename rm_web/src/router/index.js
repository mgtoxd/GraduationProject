import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index'
import classfication from '../views/classfication'
Vue.use(VueRouter)

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

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
