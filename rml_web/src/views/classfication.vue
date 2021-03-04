<template>
  <div id="classfication">
    <el-row>
      <el-col :span="3" style="height: 1px"></el-col>
      <el-col class="bg-blue-100 h-48" :span="18">

      </el-col>
      <el-col :span="3" style="height: 1px"></el-col>
    </el-row>

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