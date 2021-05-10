<template>
<el-row class="mt-20">
  <el-col class="h-72 flex" :span="12">
    <el-col :span="2" class="h-1"/>
    <el-col class="self-center" :span="10"><el-image class="h-48 w-48" style="border-radius: 50%" :src="info.conAva"  :fit="'cover'"/></el-col>
    <el-col class="self-center ml-6" :span="12">
      <div>
        <p>{{info.conName}}</p>
        <p>欢迎光临</p>
      </div>
    </el-col>
  </el-col>
  <el-col class="h-72 justify-center flex"  :span="12">
    <div class="self-center">
      <p>账户安全:<span class="text-green-600">安全</span></p>
      <div class="h-3"></div>
      <p>绑定手机:{{info.conPhoneNum}}</p>
      <div class="h-3"></div>
      <p>绑定邮箱:{{info.conEmail}}</p>
    </div>
  </el-col>
  <el-col :span="1" class="h-1"/>
  <el-col :span="22"><el-divider></el-divider></el-col>
  <el-col :span="1" class="h-1"/>
  <el-col :span="1" class="h-1"/>
  <el-col :span="21">
    <el-row class="ml-10">
      <el-col :span="12" class="flex mt-16">
        <el-image :src="$http.getStatic('img/png/portal-icon-1.png')"/>
        <div class="self-center ml-3">
          <span class="text-2xl">待支付订单数:</span>
          <span class="text-2xl">{{orderInfo.wzf}}</span>
          <p class="mt-1 ">查看待支付订单></p>
        </div>
      </el-col>
      <el-col :span="12" class="flex mt-16">
        <el-image :src="$http.getStatic('img/png/portal-icon-2.png')"/>
        <div class="self-center ml-3">
          <span class="text-2xl">已支付订单数:</span>
          <span class="text-2xl">{{orderInfo.yzfwsy}}</span>
          <p class="mt-1 ">查看已支付订单></p>
        </div>
      </el-col>
      <el-col :span="12" class="flex mt-16">
        <el-image :src="$http.getStatic('img/png/portal-icon-3.png')"/>
        <div class="self-center ml-3">
          <span class="text-2xl">待评价商品数:</span>
          <span class="text-2xl">{{orderInfo.ysywpl}}</span>
          <p class="mt-1 ">查看待评价商品></p>
        </div>
      </el-col>
      <el-col :span="12" class="flex mt-16">
        <el-image :src="$http.getStatic('img/png/portal-icon-4.png')"/>
        <div class="self-center ml-3">
          <span class="text-2xl">喜欢的商品:</span>
          <p class="mt-1 ">查看喜欢的商品></p>
        </div>
      </el-col>
    </el-row>
  </el-col>
  <el-col :span="2" class="h-1"/>
</el-row>
</template>

<script>
export default {
name: "personInfo",
  created() {
    var ConsumerInfo = JSON.parse(localStorage.getItem('consumerInfo'))
    this.info = ConsumerInfo
    this.$http.get("/api/order/order/getOrderClassInfoBytoken").then(res=>{
      var data = res.data
      if (data.code === 200){
        this.orderInfo = data.data
      }
    })
  },
  data(){
    return{
      orderInfo:{
      },
      info:{
        phone:'15304769009',
        email:'2359971480@qq.com'

      }
    }
  }
}
</script>

<style scoped>

</style>