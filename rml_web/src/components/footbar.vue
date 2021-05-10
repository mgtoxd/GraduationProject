<template>
  <el-row id="foot_bar">
    <el-col :span="3" class="h-0.5"/>
    <el-col :span="18">
      <el-row>
        <el-col class="flex" :span="4" v-for="(item,index) in service">
          <div class="self-center">
            <p >{{item.title}}</p>
            <el-row class="mt-6">
              <el-col class="mt-3" :span="24" v-for="(item_item,index) in item.items">
                <p class="text-sm text-gray-600">{{item_item.title}}</p>
              </el-col>
            </el-row>
          </div>

        </el-col>
        <el-col :span="2">
          <el-divider class="h-full" direction="vertical"></el-divider>
        </el-col>
        <el-col :span="6">
          <el-image class="w-96" src="http://localhost:81/img/png/logo.png" fit="cover"/>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="3"/>
  </el-row>
</template>

<script>
export default {
  name: "footbar",
  data() {
    return {
      service:[
        {
          title:'帮助中心',
          items:[
            {title:'账户管理'},
            {title:'购物指南'},
            {title:'订单操作'}
          ]
        },
        {
          title:'服务支持',
          items:[
            {title:'售后政策'},
            {title:'自助服务'},
            {title:'相关下载'}
          ]
        },
        {
          title:'关于我们',
          items:[
            {title:'了解我们'},
            {title:'加入我们'},
            {title:'联系我们'}
          ]
        },
        {
          title:'加盟合作',
          items:[
            {title:'分销联盟'},
            {title:'广告业务'},
            {title:'代理合作'}
          ]
        }
      ]
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/foot_bar.css";
</style>