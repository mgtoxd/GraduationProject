<template>
  <el-row style="margin-top: 50px">
    <el-col :span="5"/>
    <el-col :span="14">
      <el-row>
        <router-view/>
      </el-row>
    </el-col>
    <el-col :span="5"/>
  </el-row>
</template>

<script>
export default {
name: "log",
  created() {
    this.$http.linkTo("/log/login");
  }
}
</script>

<style scoped>

</style>
