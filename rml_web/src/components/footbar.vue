<template>
  <el-row id="foot_bar">
    <el-col :span="3" class="h-0.5"/>

    <el-col :span="18">
<!--      分栏-->
      <el-row class="">
        <el-col class="flex justify-center"  :key="index" v-for="(item,index) in service.items" :span="5-8" style="width: 20%"  >
          <div>
            <el-image :src="item.img_src" class="h-7 w-7"/>
          </div>
          <span class="ml-2.5" v-text="item.title"/>
        </el-col>
        <el-divider class="mt-14"/>
      </el-row>
    </el-col>

    <el-col :span="3"/>
  </el-row>
</template>

<script>
export default {
  name: "footbar",
  data(){
    return{
      service:{
        items:[
          {
            title:'安全',
            img_src:this.$http.getStatic('img/png/safe.png'),
            link:''
          },
          {
            title:'安全',
            img_src:this.$http.getStatic('img/png/safe.png'),
            link:''
          },
          {
            title:'安全',
            img_src:this.$http.getStatic('img/png/safe.png'),
            link:''
          },
          {
            title:'安全',
            img_src:this.$http.getStatic('img/png/safe.png'),
            link:''
          },
          {
            title:'安全',
            img_src:this.$http.getStatic('img/png/safe.png'),
            link:''
          },
        ]
      }
    }
  }
}
</script>

<style scoped>
 @import "http://localhost:81/css/foot_bar.css";
</style>