<template>
  <div id="app">
    <Topbar></Topbar>
    <router-view>
    </router-view>
    <footbar></footbar>

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
    this.$router.push('/index')
  }
}
</script>