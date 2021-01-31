import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import animated from 'animate.css'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


Vue.use(Element)
Vue.use(animated)
Vue.config.productionTip = false

router.afterEach((to, from, next) => {
    window.scrollTo(0, 0);
});

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
