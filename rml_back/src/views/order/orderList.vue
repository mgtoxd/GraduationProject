<template>
<el-row>
  <el-col :span="2" class="h-5"/>
  <el-col :span="20">
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          prop="id"
          label="订单id"
          width="180">
      </el-table-column>

      <el-table-column
          prop="commodId"
          width="180"
          label="商品id">

      </el-table-column>
      <el-table-column
          prop="orderStutas"
          label="订单状态码"
          width="100">

      </el-table-column>
      <el-table-column
          prop="price"
          label="价格信息"
          width="100">

      </el-table-column>
      <el-table-column
          prop="bgDate"
          label="日期信息"
          >

      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template #default="scope">
          <el-button @click="cancel(scope.row)" type="text" size="small">取消</el-button>
          <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-col>
  <el-col :span="2" class="h-1"/>
</el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "orderList",
  data(){
    return{
      tableData:[],
    }
  },
  methods:{
    cancel(val){
      this.$axios.get("/api/order/order/cancelOrder",{params:{id:val.id}}).then(res=>{
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
        this.getData()
      })
    },
    del(val){
      this.$axios.get("/api/order/order/deleteOrder",{params:{id:val.id}}).then(res=>{
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
        this.getData()
      })
    },
    getData(){
      this.$axios.get("/api/order/order/listOrderInfo").then(res=>{
        var data = res.data
        if (data.code===200){
          this.tableData = data.data;
        }
      })
    }
  },
  created() {
    this.getData()
  }
}
</script>

<style scoped>

</style>