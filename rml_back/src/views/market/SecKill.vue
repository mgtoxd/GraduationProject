<template>
  <el-row>
    <el-dialog title="秒杀活动所有商品" v-model="SecKillCommodListDialogVisible">
      <SecKillCommodList ref="SecKillCommodList" class="w-full h-full"/>
    </el-dialog>
    <el-col :span="2"/>
    <el-col :span="20">
      <el-table
          v-loading="loading"
          :data="tableData"
          border
          style="width: 100%">
        <el-table-column
            prop="secDateTime"
            label="秒杀活动时间"
            width="180">
        </el-table-column>
        <el-table-column
            label="活动商品"
            width="180">
          <template #default="scope">
            <el-button @click="showCommodList(scope.row)" type="text" size="small">查看</el-button>
          </template>
        </el-table-column>
        <el-table-column
            prop="secName"
            label="秒杀活动名称"
        >
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="100">
          <template #default="scope">
            <el-button @click="showUpdateDialog(scope.row)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
    <el-col :span="2"/>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";
import SecKillCommodList from "@/components/SecKillCommodList";

export default {
  name: "SecKill",
  components: {SecKillCommodList},
  data() {
    return {
      loading:false,
      SecKillCommodListDialogVisible:false,
      tableData:[]
    }
  },
  created() {
    this.getData()
  },
  methods:{
    showCommodList(val){
      this.SecKillCommodListDialogVisible=true
      this.$refs.SecKillCommodList.getData(val.secKillId)
    },
    async getData(){
      this.loading = true
      await this.$axios.get("/api/market/SecK/listSecKill").then(res => {
        if (res.data.code === 200) {
          this.tableData = res.data.data
        }
      })
      this.loading = false
    },
    del(val){
      this.$axios.get("/api/market/SecK/removeSecKill",{params:{id:val.secKillId}}).then(res => {
        if (res.data.code === 200){
          ElMessage.success({
            message: '删除成功',
            type: 'success'
          });
        }else {
          ElMessage.error({
            message: '删除失败，请联系管理员',
          });
        }
        this.getData()
      })
    }
  }
}
</script>

<style scoped>

</style>