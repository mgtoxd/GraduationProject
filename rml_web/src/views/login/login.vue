<template >

  <el-col  class="mt-6" :span="6">
    <el-row>
      <el-image style="height: 80px;width: 150px" :fit="'cover'" :src="'http://localhost:81/img/png/logo.png'"></el-image>
      <el-divider style="height: 40px" class="bg-gray-400 place-self-center" direction="vertical"></el-divider>
      <span class="place-self-center text-3xl">登录</span>
    </el-row>

  </el-col>
  <el-col :span="16"/>
  <el-col  class="mt-6" :span="2">
    <el-image style="width: 50px;height: 50px" @click.native="jumpToIndex" :src="$http.getStatic('img/png/false.png')" :fit="'cover'"></el-image>
  </el-col>

<el-row class="mt-9">
  <el-col :span="2"/>
  <el-col :span="9">
    <el-image class="h-80" :src="$http.getStatic('/img/png/test/channel/10.jpg')" :fit="'cover'"></el-image>
  </el-col>
  <el-col :span="1"/>
  <el-col :span="9">
    <div class="w-full h-96 border-2 border-gray-200" style="position: relative">
      <div @click.native="jumpToRegester" style="z-index:20;position: absolute;right: 0;top: 0;height: 70px;width: 70px">
        <svg @click.native="jumpToRegester" t="1618627915732" class="icon" viewBox="0 0 1324 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5009" width="60" height="60"><path d="M447.708881 423.399778a19.447613 19.447613 0 0 0 16.55116-14.068486l45.929469-152.891341a20.68895 20.68895 0 0 0-38.274558-11.378923l-32.688541 109.651436-31.654094-52.963713a20.68895 20.68895 0 0 0-34.343657 0l-31.654094 52.963713-32.688541-109.651436a20.68895 20.68895 0 1 0-38.274557 11.378923l45.722579 152.891341a20.68895 20.68895 0 0 0 16.75805 14.068486h2.482674A20.68895 20.68895 0 0 0 351.712152 413.882861l38.688337-62.06685 37.860778 62.06685a19.447613 19.447613 0 0 0 19.447614 9.516917zM599.979553 423.399778h2.482675A20.68895 20.68895 0 0 0 620.668504 413.882861l37.446999-62.06685 37.860779 62.06685a20.68895 20.68895 0 0 0 36.205663-4.551569l45.72258-152.891341a20.68895 20.68895 0 1 0-38.067669-11.378923l-32.89543 109.651436-31.654094-52.963713a20.68895 20.68895 0 0 0-17.171829-9.723806 20.68895 20.68895 0 0 0-16.964939 9.723806l-31.654093 52.963713-32.895431-109.651436a20.68895 20.68895 0 1 0-38.274558 11.378923l45.929469 152.891341a20.68895 20.68895 0 0 0 15.723602 14.068486zM1032.378611 231.61321a20.68895 20.68895 0 0 0-24.82674 13.447818l-32.895431 109.651436-31.654094-52.963713a20.68895 20.68895 0 0 0-34.136767 0l-31.654094 52.963713-32.895431-109.651436a20.68895 20.68895 0 0 0-24.82674-13.447818 20.68895 20.68895 0 0 0-13.240928 24.826741l45.72258 152.891341a20.68895 20.68895 0 0 0 36.205663 4.551569l37.860778-62.06685 37.65389 62.06685a20.68895 20.68895 0 0 0 17.171828 9.723806h2.482674a20.68895 20.68895 0 0 0 16.55116-14.068486l45.92947-152.891341a20.68895 20.68895 0 0 0-13.447818-25.03363zM415.847897 536.361446a20.68895 20.68895 0 0 0-20.68895-20.68895H289.645302a20.68895 20.68895 0 0 0-20.68895 20.68895v106.341203a20.68895 20.68895 0 0 0 20.68895 20.68895h106.341203a20.68895 20.68895 0 0 0 20.68895-20.68895z m-39.929673 86.479811H310.334252v-66.41153h66.20464zM395.986505 703.528163H289.645302a20.68895 20.68895 0 0 0-20.68895 20.68895v103.44475a20.68895 20.68895 0 0 0 20.68895 20.68895h106.341203a20.68895 20.68895 0 0 0 20.68895-20.68895v-105.306756a20.68895 20.68895 0 0 0-20.68895-18.826944z m-20.68895 106.134314H310.334252v-67.445978h66.20464zM1026.585705 569.670655h-79.652458a20.68895 20.68895 0 0 0 0 39.722785h79.652458a20.68895 20.68895 0 1 0 0-39.722785zM867.280789 569.670655H475.845853a20.68895 20.68895 0 0 0 0 39.722785h391.434936a20.68895 20.68895 0 1 0 0-39.722785zM1026.585705 755.457427h-79.652458a20.68895 20.68895 0 0 0 0 39.929674h79.652458a20.68895 20.68895 0 1 0 0-39.929674zM867.280789 755.457427H475.845853a20.68895 20.68895 0 0 0 0 39.929674h391.434936a20.68895 20.68895 0 0 0 0-39.929674z" p-id="5010"></path><path d="M301.438003 976.001636H75.100889a27.516304 27.516304 0 0 1-27.309414-27.309414V75.204747a27.516304 27.516304 0 0 1 27.309414-27.309414H926.864965a23.999182 23.999182 0 1 0 0-47.791474H75.100889A75.307778 75.307778 0 0 0 0 67.136057v889.624855a75.514668 75.514668 0 0 0 74.68711 67.239088h226.750893a23.999182 23.999182 0 0 0 0-47.998364zM1324.092808 67.136057A75.307778 75.307778 0 0 0 1248.991919 0.103859H1022.654804a23.999182 23.999182 0 1 0 0 47.791474h226.337115a27.516304 27.516304 0 0 1 27.309414 27.309414v873.487475a27.516304 27.516304 0 0 1-27.309414 27.309414H397.227842a23.999182 23.999182 0 1 0 0 47.998364h851.764077A75.514668 75.514668 0 0 0 1324.092808 956.760912v-889.624855z" p-id="5011"></path></svg>
      </div>
      <el-row class="mt-6">
        <el-col :span="2"/>
        <el-col :span="20">
          <el-tabs class="mt-4" v-model="LogType">
            <el-tab-pane class="mt-6" label="邮箱登录" name="email">

              <el-input placeholder="请输入邮箱" v-model="loginInfo.username">
                <template #prepend>
                  <svg t="1618626310090" class="icon" viewBox="0 0 1280 1024" version="1.1"
                       xmlns="http://www.w3.org/2000/svg" p-id="3428" width="20" height="20">
                    <path
                        d="M1200 0H80a80 80 0 0 0-80 80v864a80 80 0 0 0 80 80h1120a80 80 0 0 0 17.6-2 40 40 0 0 0 27.2-10.4v-2.4A80 80 0 0 0 1280 944V80a80 80 0 0 0-80-80zM640 584L90 90h1103.2zM80 188.4L448.8 520 80 887.6z m428.4 383.6l106.4 95.6a40 40 0 0 0 53.2 0l113.2-101.2 346.8 377.6H136.4zM840 512.8l360-320v712z"
                        fill="" p-id="3429"></path>
                  </svg>
                </template>
              </el-input>
              <el-input class="mt-8"  placeholder="请输入密码" v-model="loginInfo.password" show-password>
                <template #prepend>
                  <svg t="1618625500539" class="icon" viewBox="0 0 1024 1024" version="1.1"
                       xmlns="http://www.w3.org/2000/svg"
                       p-id="2609" width="20" height="20">
                    <path
                        d="M602.112 425.984l69.632 0 0-145.408c0-83.968-67.584-153.6-153.6-153.6l-45.056 0c-83.968 0-153.6 67.584-153.6 153.6l0 61.44 65.536 0 0-59.392c0 0 4.096-81.92 81.92-81.92 71.68 0 57.344 0 57.344 0s77.824-4.096 77.824 75.776C602.112 364.544 602.112 425.984 602.112 425.984z"
                        p-id="2610"></path>
                    <path
                        d="M253.952 471.04l0 192.512c0 129.024 104.448 235.52 235.52 235.52l16.384 0c129.024 0 235.52-104.448 235.52-235.52L741.376 471.04 253.952 471.04zM524.288 655.36l0 65.536c0 16.384-12.288 28.672-28.672 28.672s-28.672-12.288-28.672-28.672L466.944 655.36c-16.384-10.24-28.672-28.672-28.672-49.152 0-32.768 26.624-57.344 57.344-57.344 32.768 0 57.344 26.624 57.344 57.344C555.008 626.688 542.72 645.12 524.288 655.36z"
                        p-id="2611"></path>
                  </svg>
                </template>
              </el-input>
            </el-tab-pane>
            <el-tab-pane class="mt-6" label="手机号登录" name="phone">
              <el-input   placeholder="请输入手机号" v-model="loginInfo.username">
                <template #prepend>
                  <svg t="1618626345292" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4213" width="20" height="20"><path d="M768 0 256 0C220.8 0 192 28.8 192 64l0 896c0 35.2 28.8 64 64 64l512 0c35.2 0 64-28.8 64-64L832 64C832 28.8 803.2 0 768 0zM656 32C665.6 32 672 38.4 672 48S665.6 64 656 64 640 57.6 640 48 646.4 32 656 32zM464 32l96 0C569.6 32 576 38.4 576 48 576 57.6 569.6 64 560 64l-96 0C454.4 64 448 57.6 448 48 448 38.4 454.4 32 464 32zM512 992c-25.6 0-48-22.4-48-48S486.4 896 512 896s48 22.4 48 48S537.6 992 512 992zM768 832c0 19.2-12.8 32-32 32L288 864c-19.2 0-32-12.8-32-32L256 128c0-19.2 12.8-32 32-32l448 0c19.2 0 32 12.8 32 32L768 832z" p-id="4214"></path></svg>
                </template>
              </el-input>
              <el-input class="mt-8"  placeholder="请输入密码" v-model="loginInfo.password" show-password>
                <template #prepend>
                  <svg t="1618625500539" class="icon" viewBox="0 0 1024 1024" version="1.1"
                       xmlns="http://www.w3.org/2000/svg"
                       p-id="2609" width="20" height="20">
                    <path
                        d="M602.112 425.984l69.632 0 0-145.408c0-83.968-67.584-153.6-153.6-153.6l-45.056 0c-83.968 0-153.6 67.584-153.6 153.6l0 61.44 65.536 0 0-59.392c0 0 4.096-81.92 81.92-81.92 71.68 0 57.344 0 57.344 0s77.824-4.096 77.824 75.776C602.112 364.544 602.112 425.984 602.112 425.984z"
                        p-id="2610"></path>
                    <path
                        d="M253.952 471.04l0 192.512c0 129.024 104.448 235.52 235.52 235.52l16.384 0c129.024 0 235.52-104.448 235.52-235.52L741.376 471.04 253.952 471.04zM524.288 655.36l0 65.536c0 16.384-12.288 28.672-28.672 28.672s-28.672-12.288-28.672-28.672L466.944 655.36c-16.384-10.24-28.672-28.672-28.672-49.152 0-32.768 26.624-57.344 57.344-57.344 32.768 0 57.344 26.624 57.344 57.344C555.008 626.688 542.72 645.12 524.288 655.36z"
                        p-id="2611"></path>
                  </svg>
                </template>
              </el-input>
            </el-tab-pane>
          </el-tabs>
          <el-row class="mt-10">
            <el-col :span="24">
              <el-button @click="login" class="w-full">登录</el-button>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="2"/>
      </el-row>
      <el-col :span="3"/>

    </div>
  </el-col>
</el-row>


</template>

<script>
import {ElMessage} from "element-plus";
import {mapMutations} from "vuex";

export default {
  name: "login",
  methods: {
    ...mapMutations(['edit_if_log']),
    getToken(){
      return localStorage.getItem('token')
    },
    login(){
      this.$http.post("/api/auth/ConsumerLogin",{
        type:this.LogType,
        user:this.loginInfo.username,
        password:this.loginInfo.password
      }).then(res=>{
        var data = res.data
        if (data.code===200){
          if (data.data.indexOf('用户')!==-1){
            ElMessage.error({
              message:data.data,
            })
          }else {
            this.edit_if_log(true)
            localStorage.setItem('token',data.data)
            ElMessage.success({
              message:'登陆成功',
              type:'success'
            })
            this.$http.get("/api/auth/consumer/getConsumerInfoByToken",{params:{token:this.getToken()}}).then(res=>{
              var data = res.data
              if (data.code===200){
                localStorage.setItem('consumerInfo',JSON.stringify(data.data))
              }
            })
            this.$http.linkTo("/")

          }
        }
      })
    },
    jumpToIndex() {
      this.$http.linkTo("/")
    },
    jumpToRegester(){
      this.$http.linkTo("/log/regester")
    }
  },
  data() {
    return {
      loginInfo: {
        username: '',
        password: ''
      },
      LogType: 'email'
    }
  }
}
</script>

<style scoped>
.el-input-group--prepend >>>.el-input__inner{
   height: 3rem;
 }
</style>
