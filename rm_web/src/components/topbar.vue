<template>
  <el-row id="top_bar">
    <el-col :span="2">
    </el-col>
    <!--  搜索-->
    <el-col :span="2" class="search">
      <el-row>
        <!--      图片-->
        <el-col :span="11">
          <el-image :src="search.img_src"
                    :fit="'contain'">
          </el-image>
        </el-col>
        <el-col :span="2"></el-col>
        <!--      文字-->
        <el-col :span="11">
          <p>{{ search.title }}</p>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="7">
    </el-col>
    <!--    logo-->
    <el-col :span="2" class="logo">
      <el-image :src="logo.src"
                :fit="'contain'">
      </el-image>
    </el-col>
    <el-col :span="7">
    </el-col>
    <!--      菜单-->
    <el-col :span="2" class="search">
      <el-row>
        <!--      文字-->
        <el-col :span="11">
          <p style="float: right">{{ menu.title }}</p>
        </el-col>
        <el-col :span="2"></el-col>
        <!--      图片-->
        <el-col :span="11">
          <el-image :src="menu.img_src"
                    :fit="'contain'" style="float: left">
          </el-image>
        </el-col>

      </el-row>
    </el-col>
    <el-col :span="2">
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "topbar",
  data() {
    return {
      search: {
        title: '搜索',
        img_src: 'http://localhost:81/img/png/search.png'
      },
      menu: {
        title: '菜单',
        img_src: 'http://localhost:81/img/png/menu.png'
      },
      logo: {
        src: 'http://localhost:81/img/png/logo.png'
      }
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/top_bar.css";
</style>