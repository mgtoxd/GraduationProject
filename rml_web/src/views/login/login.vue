<template>

  <el-col :span="5">
    <el-divider class="h-14 bg-gray-400" direction="vertical"></el-divider>
    <span>登录</span>
  </el-col>
  <el-col :span="19"/>
  <el-col :span="3"/>
  <el-col :span="10">
    <el-image class="h-80" :src="$http.getStatic('/img/png/1.png')" :fit="'cover'">

    </el-image>
  </el-col>
  <el-col :span="2"/>
  <el-col :span="8">
    <div class="w-full h-96 border-4 border-black">

    </div>
  </el-col>
  <el-col :span="1"/>
</template>

<script>
export default {
name: "login"
}
</script>

<style scoped>

</style>
