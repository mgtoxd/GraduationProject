import router from "@/router";

function getStatic(url) {
    return 'http://localhost:81/' + url
}
function linkTo (url, data) {
    router.push({path: url, query: data})
}
export default {
    getStatic,
    linkTo
}