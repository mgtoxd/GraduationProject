<template>
<el-row>
  <el-col class="mt-14" :span="24">
    <p class="ml-14 text-3xl">我的订单</p>
  </el-col>
  <el-col class="ml-14 mt-8 flex" :span="24">
    <span class="ml-3 mr-3 self-center text-lg text-gray-500">全部订单</span>
    <el-divider class="h-10" direction="vertical"></el-divider>
    <span class="ml-3 mr-3 self-center text-lg text-gray-500">待支付</span>
    <el-divider class="h-10" direction="vertical"></el-divider>
    <span class="ml-3 mr-3 self-center text-lg text-gray-500">待消费</span>


  </el-col>
</el-row>
</template>

<script>
export default {
name: "orderList"
}
</script>

<style scoped>

</style>