
import axios from "axios";
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import './assets/tailwind.css'
import moment from 'moment';
moment.locale('zh-cn');

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$moment = moment
installElementPlus(app)
app.use(store).use(router).mount('#app')
