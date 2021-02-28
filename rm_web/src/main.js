import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
// import ElementUI from 'element-ui';
// import locale from 'element-ui/lib/locale/lang/zh-CN'
// import 'element-ui/lib/theme-chalk/index.css';
import 'element-plus/lib/theme-chalk/index.css';
import locale from 'element-plus/lib/locale/lang/zh-cn'
import ElementPlus from 'element-plus';
import VideoPlayer from 'vue-video-player'
import 'tailwindcss/tailwind.css'
import getStatic from './network/request/static/static'

require('video.js/dist/video-js.css')
require('vue-video-player/src/custom-theme.css')
Vue.use(getStatic)

Vue.use(ElementPlus, { locale })
Vue.use(VideoPlayer)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
