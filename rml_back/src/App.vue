<template>
<!--  头部-->
  <el-row class="bg-gray-800 h-14">
    <el-col :span="2" class="grid">
      <el-image class="w-18 h-14 justify-self-center" :src="'http://localhost:81/img/png/logo.png'" :fit="'cover'"></el-image>
    </el-col>
    <el-col :span="10" class="flex">
      <p class="font-bold self-center text-white text-2xl">后台管理页面</p>
    </el-col>
  </el-row>
<!--  列表-->
  <el-row class="h-full">
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

</template>

<script>


export default {
  name: 'App',
  components: {

  },
  created() {
    console.log(this.$router.options.routes)
  },
  data(){
    return{

    }
  },
  methods:{
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
