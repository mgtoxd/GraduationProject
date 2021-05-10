<template>
<!--  头部-->
  <el-row v-if="log" class="bg-gray-800 h-14">
    <el-col :span="2" class="grid">
      <el-image class="w-18 h-14 justify-self-center" :src="'http://localhost:81/img/png/logo.png'" :fit="'cover'"></el-image>
    </el-col>
    <el-col :span="10" class="flex">
      <p class="font-bold self-center text-white text-2xl">后台管理页面</p>
    </el-col>
  </el-row>
<!--  列表-->
  <el-row v-if="log" class="h-full">
    <el-col :span="2" class="border-2 h-full bg-gray-400">
      <el-row>
        <el-col v-for="(item,index) in this.$router.options.routes" class="grid flex h-16 transition-all duration-200 cursor-pointer hover:bg-gray-800 hover:text-red-100" :span="24">
          <p class="text-2xl justify-self-center self-center" @click.native="routeTo(index)">{{item.title}}</p>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="22">
      <router-view>
      </router-view>
    </el-col>
  </el-row>
<el-row class="w-full grid flex h-full bg-gray-400" v-if="!log">
<div class="bg-white w-5/6 h-96 grid justify-self-center self-center">
  <p class="text-center text-4xl mt-10">后台管理员登录</p>
  <el-form label-width="80px" class="mt-6 mr-5">
    <el-form-item label="用户名:">
      <el-input v-model="adminlogForm.adminName"></el-input>
    </el-form-item>
    <el-form-item label="密码:">
      <el-input show-password v-model="adminlogForm.adminPassword"></el-input>
    </el-form-item>
  </el-form>
  <el-button class="justify-self-center mb-10" @click="AdminLog">登录</el-button>
</div>
</el-row>

</template>

<script>
import {mapState,mapMutations} from "vuex";
import {ElMessage} from "element-plus";


export default {
  name: 'App',
  components: {

  },
  computed:{
    ...mapState(['log'])
  },
  created() {
    console.log(this.$router.options.routes)

  },
  data(){
    return{
      adminlogForm:{
        adminName:'',
        adminPassword:''
      }
    }
  },
  methods:{
    ...mapMutations(['edit_log','edit_admin']),
    AdminLog(){
      this.$axios.post("/api/auth/AdminLogin",this.adminlogForm).then(res=> {
        var data = res.data
        if (data.code===200){
          if (data.data.indexOf('用户')!==-1){
            ElMessage.error({
              message:data.data,
            })
          }
          else {
            this.edit_log(true);
            this.edit_admin({
              token:data.data
            });
          }
        }
      })
    },
    routeTo(id){
      var route = this.$router.options.routes[id];
      this.$router.push({path:route.path})
    }
  }
}
</script>

<style>
html,body,#app{
  height: 100%;
}



</style>
