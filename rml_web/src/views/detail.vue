<template>
  <el-row v-loading="loading" style="margin-top: 100px">
    <el-col :span="4"/>
    <el-col :span="8" class="pr-9">
      <el-carousel v-if="carload" height="650px">
        <el-carousel-item v-for="(item ,index) in info.contentImgs" :key="index">
          <el-image :src="'/api/static/img/'+item.url" class="w-full h-full" :fit="'cover'"/>
        </el-carousel-item>
      </el-carousel>
    </el-col>
    <el-col class="h-56" :span="8">
      <el-row class="p-3">
        <el-col :span="24">
          <p class="text-4xl font-bold">{{ info.baseInfo.commodName }}</p>
          <span style="word-wrap: normal">{{ info.txt.commodTxt }}</span>
        </el-col>
      </el-row>

      <calendar ref="calendar"></calendar>

    </el-col>
    <el-col :span="4"/>
    <el-col :span="24" v-if="choose_day.special!=null">
      <el-row class="mt-32">
        <el-col :span="4"/>
        <el-col :span="16" class="border-2 border-red-200 bg-yellow-100">
          <el-row>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>出发日期</p>
              <span>{{ choose_month }}</span><span>{{ choose_day.dateInMon }}</span>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>成人</p>
              <el-input-number v-model="manCount" @change="setPrice" :min="0" :max="10"
                               label="描述文字"></el-input-number>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3">
              <p>儿童</p>
              <el-input-number v-model="childCount" @change="setPrice" :min="0" :max="10"
                               label="描述文字"></el-input-number>
            </el-col>
            <el-col :span="4-8" class="w-1/5 p-3"></el-col>
            <el-col :span="9.6" class="w-1/5 flex">
              <el-row class="w-56 self-center">
                <el-col :span="12 " class="flex">
                  <span class=" float-right text-sm self-center">总价</span>
                  <span class="text-yellow-600  self-center text-3xl">{{ totalPrice }}</span>
                </el-col>
                <el-col :span="12">
                  <el-button @click="setOrder">预订</el-button>
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
            <el-tab-pane label="行程展示" name="second">
              <el-row>
                <el-timeline>
                  <el-timeline-item v-for="(item,index) in info.commodTripInfos" :timestamp="item.commodTripTime" placement="top">
                    <el-card>
                      <h4>{{ item.commodTripLocation }}</h4>
                      <p>{{item.commodTripDescribe}}</p>
                    </el-card>
                  </el-timeline-item>
                </el-timeline>
              </el-row>
            </el-tab-pane>
            <el-tab-pane label="评论" name="fourth">
              <el-row v-if="readyComment" class="h-24 flex   items-center" v-for="(item,index) in commentinfo">
                <el-col :span="10">
                  <span v-if="item.txt" >{{item.txt.commentTxt}}</span>
                </el-col>
                <el-col :span="9">
                  <el-row>
                    <el-col :span="3">
                      <span>评分:</span>
                    </el-col>
                    <el-col :span="19">
                      <el-rate disabled v-model="item.commentsInfo.commentsStars"></el-rate>
                    </el-col>
                  </el-row>

                </el-col>
                <el-col :span="4">
                  <span class="text-gray-500">用户:</span><span class="text-xl" v-text="item.ConsumerInfo.conName"></span>
                </el-col>
                <el-col :span="24">
                  <el-divider></el-divider>
                </el-col>
              </el-row>

            </el-tab-pane>
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
import {ElMessage} from "element-plus";

export default {
  name: "detail",
  components: {Calendar},
  computed: {
    ...mapState(['choose_month', 'choose_day']),

  },
  watch: {
    choose_day(newVal, oldVal) {
      this.setPrice()
    }
  },
  data() {
    return {
      readyComment:false,
      carload:false,
      commentinfo:[{
        "commentsInfo": {
          "commentsId": "28bcb6eb-3849-42c0-9f03-b14863e29b11",
          "commodId": "57a1cd6b-0b2e-487c-aa03-b9c38151da0e",
          "commentsStatus": null,
          "commentsConsumerId": "c9c085d0-1671-44c0-9c65-630cba51497a",
          "commentsCategory": null,
          "commentsStars": 5,
          "createDate": "2021-05-07T04:46:05",
          "modifyDate": "2021-05-07T04:46:05",
          "isDeleted": 0
        },
        "txt": {
          "commentTxtId": "42ed885347b03d91e20fdf81b20fc048",
          "commentsId": "28bcb6eb-3849-42c0-9f03-b14863e29b11",
          "commentTxt": "还行还行",
          "createDate": "2021-05-07T04:46:05",
          "modifyDate": "2021-05-07T04:46:05",
          "isDeleted": 0
        },
        "ConsumerInfo": {
          "conId": "c9c085d0-1671-44c0-9c65-630cba51497a",
          "conName": "mtx",
          "conAva": "/api/static/img/2021-5/2f0f90d8-88a5-4588-98fb-256a8283b6e4.gif"
        }
      }],
      loading:false,
      totalPrice: 0,
      manCount: 1,
      childCount: 1,
      activeName: 'second',
      imgs: [
        'img/jpg/demo.jpg',
        'img/jpg/demo.jpg',
        'img/jpg/demo.jpg',
      ],
      info: {
        baseInfo:{},
        txt:{},
        commodTripInfos:{}
      }
    }
  },
  methods: {
    ...mapMutations(['check_if_choose']),
    setOrder(){
      this.$http.post("/api/order/order/addOrder",{
        commodId:this.$route.query.id,
        orderStutas:1,
        orderMemCount:this.manCount+this.childCount,
        bgDate:this.choose_month.replace('年','-0').replace('月','-')+this.choose_day.dateInMon,
        overDate:this.choose_month.replace('年','-0').replace('月','-')+this.choose_day.dateInMon,
        consumerId:JSON.parse(localStorage.getItem('consumerInfo')).conId,
        price:this.totalPrice
      }).then(res=>{
        var data = res.data
        if (data.code===200){
          ElMessage.success({
            message:'预订成功',
            type:'success'
          })
        }else {
          ElMessage.error({
            message:'预定失败'
          })
        }
      })
    },
    handleClick() {
      // console.log(tab, event);
    },
    setPrice() {
      this.totalPrice = (this.manCount + this.childCount)*this.choose_day.price
    }
  },
  created() {
    this.loading = true
    console.log(this.$route.query.id)
    setTimeout(() => {
      this.$refs.calendar.getData(this.$route.query.id)
    }, 200)
    this.$http.get("/api/commod/IndexCommod/GetCommodDetailById",{params:{commodId:this.$route.query.id}}).then(res=>{
      var data = res.data
      if (data.code===200){
        this.info=data.data
        this.loading=false
        this.carload=true
      }
    })
    this.$http.get("/api/comment/comment/listByCommodId",{params:{id:this.$route.query.id}}).then(res=>{
      var data = res.data
      if (data.code===200){
        console.log('do')
        this.commentinfo=data.data
        this.readyComment = true
        this.loading=false
        // this.loading=false
      }
    })

  }
}
</script>

<style scoped>

</style>