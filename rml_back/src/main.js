
import axios from "axios";
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/tailwind.css'

const app = createApp(App)
app.config.globalProperties.$axios = axios
installElementPlus(app)
app.use(store).use(router).mount('#app')
