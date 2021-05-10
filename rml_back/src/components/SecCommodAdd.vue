<template>
<el-row>
  <el-col :span="2"/>
  <el-col v-loading="loading"  class="grid" :span="20">
    <el-form class="w-96 justify-self-center" ref="form" label-width="80px">
      <el-form-item label="秒杀活动">
        <el-select v-model="form.secId" clearable placeholder="选择活动">
          <el-option
              v-for="Item in IndexPosSignList"
              :key="Item.secKillId"
              :label="Item.secName"
              :value="Item.secKillId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="秒杀价格">
        <el-input-number v-model="form.secPrice" :min="1" label="描述文字"></el-input-number>
      </el-form-item>
      <el-button @click="setSKCommod"> 提交</el-button>
    </el-form>
  </el-col>
  <el-col :span="2"/>
</el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "SecKillAdd",
  data(){
    return{
      comId:'',
      form:{
        secPrice:50
      },
      secKillList:[],
      IndexPosSignList:[
        {
          "secDateTime": "2021-05-04T02:00:00",
          "secStatus": null,
          "createDate": "2021-05-04T08:55:38",
          "modifyDate": "2021-05-04T08:55:38",
          "isDeleted": 0,
          "secKillId": "5693f04abffc8a9a726dc3eb13ecd312",
          "secName": "21年5月4日10点场"
        }
      ],
      loading:false,
    }
  },
  methods:{
    setSKCommod(){
      var data = this.form
      data.comId = this.comId
      this.$axios.post("/api/market/SecK/addOrUpdateSecCommod",this.form).then(res=>{
        var data = res.data
        if (data.code === 200) {
          ElMessage.success({
            message: '成功',
            type: 'success'
          });
        } else {
          ElMessage.error({
            message: '失败，请联系管理员',
          });
        }
      })
    },
    async getData(commodId){
      this.comId = commodId
      this.form ={
        secPrice:50
      }
      await this.$axios.get("/api/market/SecK/getSecByCommodId",{params:{id:commodId}}).then(res=>{
        var data = res.data
        if (data.code === 200){
          this.form = data.data
        }
      })
      await this.$axios.get("/api/market/SecK/listSecKill",{}).then(res=>{
        var data = res.data
        if (data.code === 200){
          this.IndexPosSignList = data.data
          console.log(this.IndexPosSignList)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>