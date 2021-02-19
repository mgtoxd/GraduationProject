<template>
  <div id="app">
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
export default {
  components: {Footbar, Topbar},
  created() {

    // console.log(this.$route.params.path)
    // this.$router.push('/index')
  },
  mounted() {
    console.log()
    if (this.$route.path=='/'){
      this.$router.push('/index')
    }
  },
  // watch:{
  //   $route:function (to,from){
  //     console.log(to.path);
  //     // this.$router.push('/index')
  //   }
  // },
}
</script>