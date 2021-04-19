<template>
  <el-row style="margin-top: 100px" >
    <el-col :span="4"/>
    <el-col :span="8" class="pr-9">
      <el-carousel height="650px">
        <el-carousel-item v-for="(item ,index) in imgs" :key="index">
          <el-image :src="$http.getStatic(item)" class="w-full h-full" :fit="'cover'"/>
        </el-carousel-item>
      </el-carousel>
    </el-col>
    <el-col class="h-56" :span="8">
      <el-row class="p-3">
        <el-col :span="24">
          <p class="text-4xl font-bold">{{info.title}}</p>
          <span style="word-wrap: normal">{{info.describe}}</span>
        </el-col>
      </el-row>

      <calendar></calendar>

    </el-col>
    <el-col :span="4"/>
    <el-col :span="24" v-if="choose_day">
      <el-row class="mt-14">
        <el-col :span="4"/>
        <el-col :span="16" class="border-2 border-red-200 bg-yellow-100">
          <el-row>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>出发日期</p>
              <span>{{choose_month}}</span><span>{{choose_day}}</span>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>成人</p>
              <el-input-number v-model="manCount" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>儿童</p>
              <el-input-number v-model="childCount" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3"></el-col>
            <el-col :span="9.6" class="w-1/5 flex">
              <el-row class="w-56 self-center">
                <el-col :span="12 " class="flex">
                  <span class=" float-right text-sm self-center">总价</span>
                  <span class="text-yellow-600  self-center text-3xl">758</span>
                </el-col >
                <el-col :span="12">
                  <el-button>wda</el-button>
                </el-col>
              </el-row>

            </el-col>
          </el-row>
        </el-col>
        <el-col :span="4"/>
      </el-row>
    </el-col>

    <el-col class="mt-32" :span="24">
      <el-row>
        <el-col :span="4"/>
        <el-col :span="16">
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="产品特色" name="first">用户管理</el-tab-pane>
            <el-tab-pane label="行程展示" name="second">
              <el-row>
                <el-timeline>
                  <el-timeline-item timestamp="2018/4/12" placement="top">
                    <el-card>
                      <h4>更新 Github 模板</h4>
                      <p>王小虎 提交于 2018/4/12 20:46</p>
                    </el-card>
                  </el-timeline-item>
                  <el-timeline-item timestamp="2018/4/3" placement="top">
                    <el-card>
                      <h4>更新 Github 模板dddddddddddddddddddddddddddddddddddddddddd</h4>
                      <p>王小虎 提交于 2018/4/3 20:46</p>
                    </el-card>
                  </el-timeline-item>
                  <el-timeline-item timestamp="2018/4/2" placement="top">
                    <el-card>
                      <h4>更新 Github 模板</h4>
                      <p>王小虎 提交于 2018/4/2 20:46</p>
                    </el-card>
                  </el-timeline-item>
                </el-timeline>
              </el-row>
            </el-tab-pane>
            <el-tab-pane label="费用明细" name="third">角色管理</el-tab-pane>
            <el-tab-pane label="评论" name="fourth">定时任务补偿</el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="4"/>
      </el-row>
    </el-col>


  </el-row>
</template>

<script>
import Calendar from "@/components/calendar";
import {mapMutations, mapState} from "vuex";
export default {
  name: "detail",
  components: {Calendar},
  computed:{
    ...mapState(['choose_month','choose_day']),
  },
  data() {
    return {
      manCount:1,
      childCount:1,
      activeName:'second',
      imgs: [
        'img/jpg/demo.jpg',
        'img/jpg/demo.jpg',
        'img/jpg/demo.jpg',
      ],
      info:{
        title:'demo1',
        describe:'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
      }
    }
  },
  methods:{
    ...mapMutations(['check_if_choose']),
    handleClick(){
      console.log(tab, event);
    }
  },
  created() {
    console.log(this.$route.query.id)
  }
}
</script>

<style scoped>

</style>