<template>
  <el-col id="menu" :span="24" style="color: black; background-color: #f5f5f5;height: 1200px">
    <el-row class="mt-5">
      <el-col :span="4" class="h-1"/>
      <el-col :span="16">
        <el-row>
          <el-col :span="21" class="flex">
            <p class="self-center">个人中心</p>

          </el-col>
          <el-col :span="3">
            <el-image @click.native="edit_if_menu_show" :src="$http.getStatic('img/png/false.png')"
                      class="h-10 w-10 self-center cursor-pointer"/>
          </el-col>
        </el-row>
        <el-row class="mt-5">
          <el-col :span="4" style="height: 900px" class="bg-white w-28">
            <el-row class="mt-14">
              <el-col class="mt-7" v-for="(item,index) in link_list" :span="24">
                <p class="ml-4 text-lg " @click="edit_which_menu_item_show(item.id)" :class="[{'text-yellow-600':(index===which_menu_item_show-1)}]" >{{ item.title }}</p>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="18" style="height: 900px" class="bg-white ml-5">
            <person-info v-if="which_menu_item_show === 1"></person-info>
            <order-list v-if="which_menu_item_show === 2"></order-list>
            <change-pwd v-if="which_menu_item_show === 3"></change-pwd>
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
import OrderList from "@/components/menu/orderList";
import ChangePwd from "@/components/menu/changePwd";
// import Avatar from 'vue-avatar'


export default {
  created() {
  },
  components: {
    ChangePwd,
    OrderList,
    PersonInfo
  },
  name: "Menu",
  computed: {
    ...mapState(['if_menu_show','which_menu_item_show'])
  },
  data() {
    return {
      link_list: [
        {
          title: '我的个人中心',
          id:1,
        },
        {
          title: '我的订单',
          id:2,
        },
        {
          title: '修改密码',
          id:3,
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
    ...mapMutations(['edit_if_menu_show','edit_which_menu_item_show']),
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