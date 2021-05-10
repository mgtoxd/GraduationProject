import router from "@/router";
import axios from "axios";
import store from '@/store/index';

axios.interceptors.request.use((config)=>{
    console.log("--",config);
    console.log(store.state.if_log)
    if (localStorage.getItem('token')) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
        config.headers.token = localStorage.getItem('token');
        //　config.headers['Authorization'] = token;
    }
    if(!config.hasOwnProperty('showError')){
        config.showError = true
    }
    return config;
},(err)=>{
    console.log(error)
    // 发生错误做的一些事情
    return Promise.reject(error);
})

function getStatic(url) {
    return 'http://localhost:81/' + url
}
function linkTo (url, data) {
    router.push({path: url, query: data})
}
function post(url,data) {
    return axios.post(url,data)
}
function get(url,data) {
    return axios.get(url,data)
}
export default {
    getStatic,
    linkTo,
    post,
    get,
}