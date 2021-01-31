<template>
  <div>
    <el-row  :class="menu_root_class" :gutter="50" id="menu_root" style="animation-duration: 300ms; background-color: #31302f;">
      <el-col :span="5">
      </el-col>
      <!--      个人信息-->
      <el-col id="person_inf" :span="4">
        <el-row style="width: 100%;height: 50px">
        </el-row>
        <el-row>
          <p style="color: #e27b5b;height: 20px" class="CN ft_50" v-text="info.name"></p>
          <div class="line"></div>
          <el-row>
            <el-col :span="3" style="height: 1px"></el-col>
            <el-col :span="18">
              <el-image style="width: 200px; height: 200px"
                        :src="info.headUrl"
                        :fit='"cover"'>>
              </el-image>
            </el-col>

            <el-col :span="3" style="height: 1px"></el-col>
          </el-row>
          <el-row class="point" @click.native="jumpToRouter(item.url)" :key="i" v-for="(item,i) in info.list" v-text="item.title">

          </el-row>
        </el-row>

      </el-col>
      <!--      商品分类-->
      <el-col :span="6">
      </el-col>
      <!--      广告-->
      <el-col :span="4">
      </el-col>
      <!--      关闭-->
      <el-col id="shutdown" :span="5">
        <div>
          <el-row style="height: 30px;width: 100%"></el-row>
          <el-row>
            <el-col style="height: 1px" :span="2"></el-col>
            <el-col class="rm_href" :span="8">
              <el-row>
                <el-col :span="10" @click.native="hide_rm_menu"><p class="CN_bolder ft_20 point">关闭</p></el-col>
                <el-col :span="14" @click.native="hide_rm_menu">
                  <svg t="1612080230615" class="icon  point" viewBox="0 0 1024 1024" version="1.1"
                       xmlns="http://www.w3.org/2000/svg" p-id="1855" width="35" height="35">
                    <path
                        fill="white"
                        d="M560.264533 512L512 463.735467l248.9344-248.9344 48.264533 48.264533L560.264533 512l248.9344 248.9344-48.264533 48.264533L512 560.264533l-248.9344 248.9344-48.264533-48.264533L463.735467 512 512 560.264533l-248.9344 248.9344-48.264533-48.264533L463.735467 512 214.801067 263.0656l48.264533-48.264533L512 463.735467l248.9344-248.9344 48.264533 48.264533z"
                        p-id="1856"></path>
                  </svg>
                </el-col>
              </el-row>
            </el-col>
            <el-col style="height: 1px" :span="14"></el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {mapMutations} from "vuex";

export default {
  name: "rm_menu",
  methods: {
    ...mapMutations(['hide_rm_menu']),
    jumpToRouter(url){
      this.hide_rm_menu()
      this.$router.replace(url)
    },

  },
  data() {
    return {
      menu_root_class:'',
      info: {
        name: 'dda马',
        headUrl: 'http://localhost:81/DFS/testhead.jpg',
        list:[
          {
            'title':'购物车',
            'url':'/about'
          },
          {
            'title':'我的订单',
            'url':'/about'
          }
        ]
      }
    }

  }
}
</script>

<style scoped>
@import "http://localhost:81/css/menu.css";
</style>