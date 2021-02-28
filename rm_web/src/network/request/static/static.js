import router from "@/router";
export default {
    install (Vue, options) {
        Vue.prototype.$getStatic = function (url) {
            return 'http://localhost:81/'+url
        }
        Vue.prototype.$linkTo = function (url,data) {
            console.log(data)
            router.push({path: url, query: data})
        }
    }
}