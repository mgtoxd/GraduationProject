<template>
  <div>
    <el-row :gutter="30" style="height: 20px" >
      <el-col :span="6"><div class="grid-content bg-purple" style="background-color: black;height: 20px" ></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
    <el-button type="primary">主要按钮</el-button>
    <el-button type="warning">警告按钮</el-button>
  </div>
</template>

<script>
// import "@/static/css/Bar_top.css"
export default {
  name: "Bar_top",
}
</script>

<style scoped>
  @import "http://localhost:81/css/Bar_top.css";

</style>