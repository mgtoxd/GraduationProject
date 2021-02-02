<template>
  <div  @touchmove.prevent @mousewheel.prevent>
    <el-row :class="menu_root_class" :gutter="50" id="menu_root"
            style=" background-color: #31302f;z-index = 999">
      <el-col :span="5">
      </el-col>
      <!--      个人信息-->
      <transition
          enter-active-class="menu_item_in"
      >
        <el-col style="animation-delay: 0.5s" v-show="all_show" id="person_inf" :span="4">
          <el-row style="width: 100%;height: 35px">
          </el-row>
          <el-row>
            <p style="color: #e27b5b;height: 13px" class="CN ft_40" v-text="info.name"></p>
            <div class="line"></div>
<!--            图片-->
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
            <el-row class="point" @click.native="jumpToRouter(item.url)" :key="i" v-for="(item,i) in info.list"
                    v-text="item.title">

            </el-row>
          </el-row>
        </el-col>
      </transition>
      <!--      商品分类-->
      <transition
          enter-active-class="menu_item_in"
      >
        <el-col v-show="all_show" style="animation-delay: 0.7s" :span="6" id="store">
          <el-row style="width: 100%;height: 35px">
          </el-row>
          <el-row>
            <p style="color: #e27b5b;height: 13px" class="CN ft_40" v-text="'商城'"></p>
            <div class="line"></div>
            <!--            商城带下拉菜单-->
            <el-row style="color: lightgray" :key="i"
                    v-for="(item,i) in store.list" v-if="item.hasChild"
            >
              <div class="point CN_lighter ft_20 rm_href" @click="show_childs(item)">
                <el-col class="" :span="4">
                  <p v-text="item.title"></p>
                </el-col>
                <el-col :span="13">
                  <div class="line" style="margin-top: 30px"></div>
                </el-col>
                <el-col :span="7">
                  <svg t="1612149729043" class="icon" viewBox="0 0 1024 1024" version="1.1"
                       xmlns="http://www.w3.org/2000/svg" p-id="1883" width="15" height="15">
                    <path d="M270.387 27.273l484.233 485.222-485.222 484.233z" p-id="1884" fill="#ffffff"></path>
                  </svg>
                </el-col>
              </div>
              <!--              二级菜单-->
              <transition
                  enter-active-class="store-seconed-enter"
                  leave-active-class="store-seconed-leave"
              >
                <div v-if="item.if_show_child">
                  <el-col v-if="item.if_show_child" :span="24" class="point CN_lighter ft_20 rm_href"
                          v-for="(child_item,child_i) in item.childs"
                          :key="child_i">
                    <el-row>
                      <el-col :span="18" style="height: 1px"></el-col>
                      <el-col :span="6">
                        <p v-text="child_item.title"></p>
                      </el-col>
                    </el-row>

                  </el-col>
                </div>
              </transition>
            </el-row>
            <div class="line"></div>
            <!--            商城无下拉菜单-->
            <el-row v-for="(item, i) in this.store.list" v-if="!item.hasChild" :key="i">
              <div class="point CN_lighter ft_20 rm_href" @click="jumpToRouter(item.url)">
                <p v-text="item.title"></p>
              </div>
            </el-row>
          </el-row>
        </el-col>
      </transition>
      <!--      广告-->
      <transition
          enter-active-class="menu_item_in"
      >
        <el-col id="ad" v-show="all_show" style="animation-delay: 0.9s" :span="4">
          <div class="ad_img">
            <el-image
                :src="ad_src"
                :fit="'cover'"
            >
            </el-image>
          </div>

        </el-col>
      </transition>
      <!--      关闭-->
      <el-col id="shutdown" :span="5">
        <div>
          <el-row style="height: 20px;width: 100%"></el-row>
          <el-row>

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
              <el-col style="height: 1px" :span="2"></el-col>
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
  mounted: function () {
    this.all_show = true
  },
  name: "rm_menu",
  methods: {
    ...mapMutations(['hide_rm_menu']),
    jumpToRouter(url) {
      this.hide_rm_menu()
      this.$router.replace(url)
    },
    show_childs(item) {
      console.log('dadad')
      item.if_show_child = !item.if_show_child
    }

  },
  data() {
    return {
      all_show: false,
      menu_root_class: '',
      ad_src: 'http://localhost:81/DFS/ad.png',
      store: {
        list: [
          {
            'title': '地区',
            'hasChild': true,
            'if_show_child': false,
            childs: [
              {
                'title': '中国',
              },
              {
                'title': '亚洲',
              },
              {
                'title': '美洲',
              },
            ]
          },
          {
            'title': '年龄',
            'hasChild': true,
            'if_show_child': false,
            childs: [
              {
                'title': '10+',
              },
              {
                'title': '20+',
              },
              {
                'title': '30+',
              },
            ]
          },
          {
            'title': '关于',
            'url': '/About'
          },
        ]
      },
      info: {
        name: 'dda马',
        headUrl: 'http://localhost:81/DFS/testhead.jpg',
        list: [
          {
            'title': '购物车',
            'url': '/about'
          },
          {
            'title': '我的订单',
            'url': '/about'
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