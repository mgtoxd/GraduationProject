<template>
  <el-row>
    <el-dialog title="评论" v-model="commentDialog">
      <el-form>
        <el-form-item label="打分">
          <el-rate v-model="commentForm.commentsStars"></el-rate>
        </el-form-item>
        <el-form-item label="评论内容">
          <el-input type="text" v-model="commentForm.commentTxt"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="addComment">提交</el-button>
    </el-dialog>


    <el-col class="mt-14" :span="24">
      <p class="ml-14 text-3xl">我的订单</p>
    </el-col>
    <el-col class="ml-14 mt-8 flex" :span="24">
      <span class="ml-3 mr-3 self-center text-lg text-gray-500">全部订单</span>
      <el-divider class="h-10" direction="vertical"></el-divider>
      <span class="ml-3 mr-3 self-center text-lg text-gray-500">待支付</span>
      <el-divider class="h-10" direction="vertical"></el-divider>
      <span class="ml-3 mr-3 self-center text-lg text-gray-500">待消费</span>
    </el-col>
    <el-col v-for="(item,index) in orderList" class="border-gray-400 border-2" :span="24">
      <el-row class="bg-gray-300">
        <el-col :span="6">
          <span v-text="item.orderInfo.createDate.split('T')[0]"></span>
        </el-col>
        <el-col :span="10">
          <span>订单号:</span><span v-text="item.orderInfo.id"></span>
        </el-col>
        <el-col v-if="item.orderInfo.orderStutas===1" :span="8">
          <p class="float-right cursor-pointer" @click.native="pay(item.orderInfo.id,item.orderInfo.price,item.commodInfo.commodName,item.commodInfo.commodDescription)" type="warning">未支付>>前往支付</p>
        </el-col>
        <el-col v-if="item.orderInfo.orderStutas===2" :span="8">
          <p class="float-right cursor-pointer" @click.native="use(item.orderInfo.id)" type="primary">已支付未使用>>前往使用</p>
        </el-col>
        <el-col v-if="item.orderInfo.orderStutas===3" :span="8">
          <p class="float-right cursor-pointer" @click.native="comment(item.commodInfo)" type="success">已使用未评论>>前往评论</p>
        </el-col>
        <el-col v-if="item.orderInfo.orderStutas===4" :span="8">
          <el-link class="float-right" type="info">被管理员取消</el-link>
        </el-col>
      </el-row>
      <el-row>
        <el-col class="flex grid" :span="3">
          <el-image v-if="item.commodInfo" :src="'/api/static/img/'+item.commodInfo.commodIndexImg"
                    class="w-24 justify-self-center h-24 self-center" fit="cover"></el-image>
        </el-col>
        <el-col :span="8">
          <p v-if="item.commodInfo" class="w-full truncate text-xl font-bold ">{{ item.commodInfo.commodName }}</p>
          <p v-if="item.commodInfo" class="overflow-x-auto h-16 break-normal text-sm text-gray-400">{{ item.commodInfo.commodDescription }}</p>
        </el-col>
        <el-col class="grid flex" :span="2">
          <div class="justify-self-center self-center">
            <span>人数:</span>
            <span v-text="item.orderInfo.orderMemCount"></span>
          </div>
        </el-col>
        <el-col class="grid flex" :span="3">
          <div class="justify-self-center self-center">
            <span>价格:</span>
            <span v-text="item.orderInfo.price"></span>
          </div>
        </el-col>
        <el-col class="grid flex" :span="4">
          <div class="justify-self-center self-center">
            <p>出发日期:</p>
            <span v-text="item.orderInfo.bgDate"></span>
          </div>
        </el-col>
      </el-row>
    </el-col>
  </el-row>
  <el-row>
    <el-col class="h-64" :span="24" ref="form" v-html="form">

    </el-col>
  </el-row>
</template>

<script>
import { h } from 'vue';
import {ElMessage} from "element-plus";
export default {

  name: "orderList",
  data() {
    return {
      commentForm:{
        commentsStars:1,
        commodId:'',
        commentTxt:''
      },
      commentDialog:false,
      form:'',
      orderList: [
      ]
    }
  },
  created() {
    this.getData()
  },
  methods: {
    use(val){
      this.$http.get("/api/order/order/useOrder",{params:{id:val}}).then(res=>{
        this.getData()
      })
    },
    pay(out_trade_no,total_amount,subject,body){
      console.log('pay')
      this.$http.post('/api/pay/pay/payy',{
        out_trade_no:out_trade_no,
        total_amount:total_amount,
        subject:subject,
        body:body
      }).then(res=>{
        //  this.htmls = res;
        document.querySelector('body').innerHTML = res.data;

        const div = document.createElement('div') // 创建div
        div.innerHTML = res.data // 将返回的form 放入div
        document.body.appendChild(div)
        document.forms[0].submit()
      })
    },
    getData() {
      this.$http.get("/api/order/order/listOrderInfoBytoken").then(res => {
        var data = res.data
        if (data.code === 200) {
          this.orderList = data.data
        }
      })
    },
    comment(val){
      // console.log('wdada')
      // console.log(val.commodId)
      this.commentForm.commodId = val.commodId
      this.commentDialog = true
    },
    addComment(){
      this.$http.post("/api/comment/comment/addComment",this.commentForm).then(res=>{
        var data = res.data
        if (data.code===200){
          ElMessage.success({
            message:'评论成功',
            type:'success'
          })
        }else {
          ElMessage.error({
            message:'评论失败'
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>