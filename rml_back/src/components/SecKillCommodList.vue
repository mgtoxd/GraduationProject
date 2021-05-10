<template>
  <el-row v-loading="loading">
    <el-col :span="24">
      <el-table
          :data="tableData"
          border
          style="width: 100%">
        <el-table-column
            prop="commodName"
            label="商品名称"
            width="180">
        </el-table-column>

        <el-table-column
            width="180"
            label="商品图标">
          <template #default="scope">
            <el-image class="w-12 h-12" :src="'/api/static/img/'+scope.row.commodIndexImg"></el-image>
          </template>
        </el-table-column>
        <el-table-column
            width="180"
            label="操作">
          <template #default="scope">
            <el-button @click="del(scope.row)" type="parimary">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "SecKillCommodList",
  data() {
    return{
      secKillId: '',
      loading:false,
    }
  },
  methods: {
    async getData(secKillId) {
      this.loading = true
      this.secKillId = secKillId
      await this.$axios.get("/api/market/SecK/getSecKillCommodBySecKillId",{params:{id:secKillId}}).then(res=>{
        var data = res.data
        if(data.code === 200){
          this.tableData = data.data
        }
      })
      this.loading = false

    }
  }

}
</script>

<style scoped>

</style>