import router from "@/router";
import axios from "axios";

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