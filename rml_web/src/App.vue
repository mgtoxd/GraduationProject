<template>
  <div id="app" class="app" style="height: 100vh;overflow-x: hidden;">
    <el-backtop target=".app"></el-backtop>

    <Topbar style="position: fixed; top: 0; left: 0;width: 100%;z-index: 998"></Topbar>
    <router-view>
    </router-view>
    <footbar style="margin-top: 50px"></footbar>

  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
}

</style>
<script>
import Topbar from "./components/topbar";
import Footbar from "./components/footbar";
import {getCurrentInstance} from "vue";

export default {
  components: {Footbar, Topbar},
  created() {
    // const {appContext} = getCurrentInstance()
    // const glb_func = appContext.$glb_func.getStatic();
    // console.log(glb_func('wdadaw'))
    console.log(this.$http.getStatic("wdadwa"))
    // console.log(this.$route.params.path)
    // this.$router.push('/index')
  },
  mounted() {
    // console.log()
    // if (this.$route.path === '/') {
    //   // this.$router.push('/index')
    // }
  },
  watch:{
    $route:function (to,from){
      console.log(to.path);
      if (to.path==='/'){
        this.$router.push('/index')
      }

    }
  },
}
</script>