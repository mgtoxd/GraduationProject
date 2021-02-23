<template>
  <el-col id="menu" :span="24" style="background-color: #4f4f4f;height: 1200px">
    <el-row :gutter="30">
      <el-col :span="3">

      </el-col>
      <!--      用户信息-->
      <el-col :span="7">
        <el-row>
          <el-col style="border-bottom: 2px white solid" :span="24">
            <p>个人信息</p>
          </el-col>
          <el-col style="margin-top: 20px" :span="12">
            <Avatar :username="userInfo.name"
                    :src="userInfo.avatar"
                    background-color="#ccc"
                    color="#fff"
                    style="height: 180px;width: 180px"
                    :inline="true">
            </Avatar>
          </el-col>
          <el-col :span="12">
            <el-row>
              <el-col :span="24">
                <p>满天星</p>
              </el-col>
              <el-col :span="24">
                <p>个人信息管理</p>
              </el-col>
            </el-row>
          </el-col>
          <el-col v-for="(item,i) in userInfo.item" :span="24" :key="i" style="margin-top: 20px">
            <div>
              <span v-text="item.title"></span>
              <el-image class="item_icon" :src="item.src"></el-image>
            </div>


          </el-col>
        </el-row>

      </el-col>
      <!--      导航-->
      <el-col :span="7">
        <el-row>
          <el-col style="border-bottom: 2px white solid" :span="24">
            <p>导航</p>
          </el-col>
          <el-col style="margin-top: 50px" :span="24">
            <el-collapse v-model="activeName"  accordion>
              <el-collapse-item v-for="(item,i) in navigation"  :key="i" :name="i" :title="item.title">
                <ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto;height: 80px">
                  <li v-for="i in item.item" @click="jump_link('/classfication',{title:i.title})"  class="infinite-list-item">{{ i.title }}</li>
                </ul>
              </el-collapse-item>
            </el-collapse>
          </el-col>

        </el-row>
      </el-col>
      <!--      广告-->
      <el-col :span="4">
        <el-image
            style="margin-top: 50px"
            :src="add.src">

        </el-image>
      </el-col>
      <!--      关闭菜单栏-->
      <el-col class="hide" :span="3">
        <el-row>
          <el-col :span="3">
            <el-image @click.native="edit_if_menu_show"
                      :src="'http://localhost:81/img/png/hide_menu.png'">
            </el-image>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-col>
</template>

<script>
import {mapMutations} from "vuex";
import {mapState} from "vuex";
import Avatar from 'vue-avatar'

export default {
  components: {
    Avatar
  },

  name: "Menu",
  computed: {
    ...mapState(['if_menu_show'])
  },
  data() {
    return {
      activeName:0,
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
      add: {
        src: 'http://localhost:81/img/png/menu_add.png',
        link: ''
      },
      navigation:[
        {
          title:'地区',
          item:[
            {
              title:'中国',
              link: ''
            },
            {
              title:'美国',
              link: ''
            }
          ]
        },
        {
          title:'年龄',
          item: [
            {
              title:'10+',
              link: ''
            },
            {
              title:'20+',
              link: ''
            }
          ]
        }
      ]
    }
  },
  methods: {
    ...mapMutations(['edit_if_menu_show']),
    hide_navi(){
      this.activeName=-1;
    },
    load () {
      this.count += 2
    },
    jump_link(path,query){
      this.$router.push({
        path:path,
        query:query
      })
      this.edit_if_menu_show()
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/menu_bar.css";
</style>