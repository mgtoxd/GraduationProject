import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/tailwind.css'
import getStatic from './network/request/static/static'
import moment from 'moment'

const app = createApp(App)
installElementPlus(app)
moment.locale('zh-cn')
app.config.globalProperties.$http = getStatic
app.config.globalProperties.$timeFormat = moment
app.config.devtools = true
app.use(store).use(router).mount('#app')


