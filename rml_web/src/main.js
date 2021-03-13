import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/tailwind.css'
import getStatic from './network/request/static/static'

const app = createApp(App)
installElementPlus(app)
app.config.globalProperties.$http = getStatic
app.config.devtools = true
app.use(store).use(router).mount('#app')


