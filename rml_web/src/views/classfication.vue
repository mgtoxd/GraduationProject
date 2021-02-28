<template>
  <div id="classfication">
    <el-col :span="2" style="height: 1px"></el-col>
    <el-col :span="20">
      <h1>{{title}}</h1>
    </el-col>
    <el-col :span="2" style="height: 1px"></el-col>
  </div>
</template>

<script>
export default {
  created() {
    console.log(this.$route.query)
    this.title = this.$route.query.title
  },
  name: "classfication",
  data(){
    return{
      title:'wdad',
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/classfication.css";

</style>