<template>
  <el-col id="menu" :span="24" style="color: black; background-color: #f5f5f5;height: 1200px">
    <el-row class="mt-11">
      <el-col :span="4" class="h-1"/>
      <el-col :span="16">
        <el-row>
          <el-col :span="21" class="flex">
            <p class="self-center">个人中心</p>

          </el-col>
          <el-col :span="3">
            <el-image @click.native="edit_if_menu_show" :src="$http.getStatic('img/png/false.png')"
                      class="h-14 w-14 self-center cursor-pointer"/>
          </el-col>
        </el-row>
        <el-row class="mt-5">
          <el-col :span="4" style="height: 900px" class="bg-white w-28">
            <el-row class="mt-14">
              <el-col class="mt-7" v-for="(item,index) in link_list" :span="24">
                <p class="ml-4 text-lg">{{ item.title }}</p>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="18" style="height: 900px" class="bg-white ml-5">
            <person-info></person-info>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="4" class="h-1 "/>
    </el-row>
  </el-col>
</template>

<script>
import {mapMutations} from "vuex";
import {mapState} from "vuex";
import PersonInfo from "@/components/menu/personInfo";
// import Avatar from 'vue-avatar'


export default {
  created() {
    // this.$http.linkTo("/personInfo")
  },
  components: {
    PersonInfo
    // Avatar
  },
  name: "Menu",
  computed: {
    ...mapState(['if_menu_show'])
  },
  data() {
    return {
      link_list: [
        {
          title: '我的订单',
          link: 'order'
        },
        {
          title: '我的个人资料',
          link: 'personInfo'
        },
      ],
      userInfo: {
        name: '满天星',
        avatar: '',
        item: [
          {
            'title': '购物车',
            'src': 'http://localhost:81/img/png/shop.png'
          },
          {
            'title': '我的订单',
            'src': 'http://localhost:81/img/png/order.png'
          }
        ]
      },
    }
  },

  methods: {
    ...mapMutations(['edit_if_menu_show']),
    hide_navi() {
      this.activeName = -1;
    },
    load() {
      this.count += 2
    },
    jump_link(path, query) {
      this.$router.push({
        path: path,
        query: query
      })
      this.edit_if_menu_show()
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/menu_bar.css";
</style>