import { createRouter, createWebHistory } from 'vue-router'
import commod from "@/views/commod";
import twice from "@/views/twice";
import adminAdd from "@/views/member/adminAdd";
import admin from "@/views/member/admin";
import consumer from "@/views/member/consumer";
import commodAdd from "@/views/commod/commodAdd";
import commodList from "@/views/commod/commodList";
import indexImg from "@/views/market/indexImg";

const routes = [
  {
    path: '/commod',
    name: 'commod',
    title:'商品管理',
    component: twice,
    children:[
      {
        path: 'commodAdd',
        name: 'commodAdd',
        title: '商品添加',
        component: commodAdd
      },
      {
        path: 'commodList',
        name: 'commodList',
        title: '商品列表',
        component: commodList
      },
    ]
  },
  {
    path: '/order',
    name: 'order',
    title:'订单管理',
    component: twice,
    children:[
      {
        path: '/com',
        name: 'com',
        component: commod
      }
    ]
  },
  {
    path: '/member',
    name: 'member',
    title:'用户管理',
    component: twice,
    children:[
      {
        path: 'adminAdd',
        name: 'adminAdd',
        title: '管理员用户添加',
        component: adminAdd
      },
      {
        path: 'admin',
        name: 'admin',
        title: '管理员用户管理',
        component: admin
      },{
        path: 'consumer',
        name: 'consumer',
        title: '消费者用户管理',
        component: consumer
      }
    ]
  },
  {
    path: '/market',
    name: 'market',
    title:'营销管理',
    component: twice,
    children:[
      {
        path: 'indexImg',
        name: 'indexImg',
        title: '首页图片管理',
        component: indexImg
      }
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
