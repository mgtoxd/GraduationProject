<template>
  <el-row style="margin-top: 80px">
    <el-col :span="4" class="h-1"/>
    <el-col :span="10" class="pro_list">
      <span class="text-lg" v-for="(item,index) in info.pro_list">{{ item.title }}<el-divider
          v-if="index<info.pro_list.length-1" direction="vertical"/></span>
    </el-col>
    <el-col :span="6">
      <el-button type="primary"  style="color: black" class="bg-red-400 border-0 float-right" @click="$http.linkTo('/detail',{id:id})">立即购买</el-button>
    </el-col>
    <el-col :span="4" class="h-1 mb-24"/>
    <el-col  v-for="(item,index) in info.img_list " :span="24">
      <el-image style="height: 100%" :src="$http.getStatic(item)"></el-image>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "product",
  data() {
    return {
      id:5,
      info: {

        pro_list: [
          {
            id:7,
            title: this.$route.query.title,
            link: ''
          },
          {
            id:8,
            title: 'this.$route.query.title',
            link: ''
          },

        ],
        img_list: [
          'img/jpg/demo.jpg',
          'img/jpg/demo.jpg',

        ]
      }
    }
  }
}
</script>

<style scoped>
.pro_list :first-child {
  font-weight: bolder;
  font-size: xx-large;
}

</style>