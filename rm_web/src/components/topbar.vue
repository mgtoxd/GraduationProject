<template>
  <el-row id="top_bar">
    <transition
        enter-active-class="show_menu"
        leave-active-class="hide_menu">
      <Menu v-if="if_menu_show" style="position: fixed; top: 0; left: 0;width: 100%;z-index: 999"></Menu>
    </transition>
    <el-col :span="2">
    </el-col>
    <!--  搜索-->
    <el-col :span="2" class="search">
      <el-row>
        <!--      图片-->
        <el-col :span="11">
          <el-image :src="search.img_src"
                    :fit="'contain'" style="cursor: pointer">
          </el-image>
        </el-col>
        <el-col :span="2"></el-col>
        <!--      文字-->
        <el-col :span="11">
          <p style="cursor: pointer">{{ search.title }}</p>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="5">
    </el-col>
    <!--    logo-->
    <el-col :span="6" class="logo">
      <el-image :src="logo.src"
                :fit="'contain'">
      </el-image>
    </el-col>
    <el-col :span="5">
    </el-col>
    <!--      菜单-->
    <el-col :span="2" class="search">
      <el-row>
        <!--      文字-->
        <el-col :span="11">
          <p @click="edit_if_menu_show" style="float: right;cursor: pointer">{{ menu.title }}</p>
        </el-col>
        <el-col :span="2"></el-col>
        <!--      图片-->
        <el-col :span="11">
          <el-image @click="edit_if_menu_show" :src="menu.img_src"
                    :fit="'contain'" style="float: left;cursor: pointer">
          </el-image>
        </el-col>

      </el-row>
    </el-col>
    <el-col :span="2">
    </el-col>
  </el-row>
</template>

<script>
import Menu from "./menubar";
import {mapState,mapMutations} from "vuex"

export default {
  name: "topbar",
  components: {Menu},
  computed: mapState([
    "if_menu_show"
  ]),
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
  },
  methods: {
    ...mapMutations(['edit_if_menu_show']),
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/top_bar.css";
</style>