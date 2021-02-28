import axios from "axios";
export function request(config,url){
    let req = axios.create({
        baseURL:url,
        timeout:5000
    });
    return req(config)
}
    //调用
request({
    url:'dadada',
}).then(res=>{
    console.log(res)
})