<template>
  <el-row style="margin-top: 100px" >
    <el-col :span="4"/>
    <el-col :span="8" class="pr-9">
      <el-carousel height="600px">
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
      <el-row>

      </el-row>
    </el-col>
    <el-col :span="4"/>
    <el-col :span="24">
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
export default {
  name: "detail",
  data() {
    return {
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