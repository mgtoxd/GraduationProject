<template>
  <div>
    <el-row id="top_bar" :gutter="30">
      <el-col :span="8">
        <el-row>
          <el-col :span="13">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="6" id="search" style="cursor: pointer">
            <el-row>
              <el-col class="search" :span="8">
                <svg t="1612062724669" class="icon" viewBox="0 0 1024 1024" version="1.1"
                     xmlns="http://www.w3.org/2000/svg" p-id="1844" width="30" height="30">
                  <path
                      d="M785.493333 740.266667l-45.226666 45.226666 139.306666 139.36a32 32 0 0 0 45.28 0 32 32 0 0 0 0-45.28l-139.36-139.306666z"
                      fill="#333333" p-id="1845"></path>
                  <path
                      d="M495.093333 153.76a341.333333 341.333333 0 1 1-241.333333 100 339.093333 339.093333 0 0 1 241.333333-100m0-64a405.333333 405.333333 0 1 0 286.613334 118.72 404.053333 404.053333 0 0 0-286.613334-118.72z"
                      fill="#333333" p-id="1846"></path>
                </svg>
              </el-col>
              <el-col :span="16">
                <p class="search_p CN_bolder">搜索</p>
              </el-col>
            </el-row>
          </el-col>

          <el-col :span="5">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="10">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="4">
            <div class="logo"></div>
          </el-col>
          <el-col :span="8">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="7">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="5" id="menu" @click.native="show_menu">
            <el-row>
              <el-col :span="2" style="height: 1px"></el-col>
              <el-col :span="8"><p class="search_p CN_bolder">菜单</p></el-col>
              <el-col :span="7">
                <div class="MENU">
                  <div></div>
                  <div></div>
                  <div></div>
                </div>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>

      </el-col>
    </el-row>
    <transition
        enter-active-class="menu-enter-active"
        leave-active-class="menu-leave-active">
      <rm_menu style="animation-duration: 500ms;position: absolute;top: 0;left: 0;width: 100%"
               v-if="if_rm_menu"></rm_menu>

    </transition>

  </div>
</template>

<script>
import rm_menu from "./rm_menu";
import {mapMutations, mapState} from "vuex";

export default {
  name: "Bar_top",
  components: {rm_menu},
  methods: {
    ...mapMutations(['show_rm_menu', 'hide_rm_menu']),
    show_menu() {
      // this.menu_class='animated rotateInDownLeft'
      this.show_rm_menu()
      // console.log('ss')
    }
  },
  data() {
    return {
      // menu_class:''
    }
  },
  computed: {
    ...mapState(['if_rm_menu'])
  },


}
</script>

<style scoped>
@import "http://localhost:81/css/Bar_top.css";

</style>