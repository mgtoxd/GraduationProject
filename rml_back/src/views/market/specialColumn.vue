<template>
  <el-row style="margin-left: 10%;margin-right: 10%" v-loading="loading">
    <el-dialog title="添加专栏" v-model="SpecialColumnDialogVisible">
      <SpecialColumnAdd ref="SpecialColumnAdd" class="w-full h-full"/>
    </el-dialog>
    <el-dialog title="专栏所有商品" v-model="SpecialColumnCommodListDialogVisible">
      <SpecialColumnCommodList ref="SpecialColumnCommodList" class="w-full h-full"/>
    </el-dialog>
    <el-col :span="20" class="h-1"/>
    <el-col :span="4">
      <el-button @click="SpecialColumnDialogVisible = true" type="primary">＋</el-button>
    </el-col>
    <el-col :span="24">
      <el-table
          :data="tableData"
          border
          style="width: 100%">
        <el-table-column
            prop="specColumnTitle"
            label="名称"
            width="180">
        </el-table-column>
        <el-table-column
            label="图片"
            width="180">
          <template #default="scope">
            <el-image class="w-12 h-12" :src="'/api/static/img/'+scope.row.specColumnImgUrl"></el-image>
          </template>
        </el-table-column>
        <el-table-column
            label="商品">
          <template #default="scope">
            <el-button @click="showCommodList(scope.row)" type="text" size="small">查看</el-button>
          </template>
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button @click="toMarket(scope.row)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
import SpecialColumnAdd from "@/components/SpecialColumnAdd";
import SpecialColumnCommodList from "@/components/SpecialColumnCommodList";
import {ElMessage} from "element-plus";

export default {
  name: "specialColumn",
  components: {SpecialColumnCommodList, SpecialColumnAdd},
  async created() {
    await this.getData()
  },
  data() {
    return {
      SpecialColumnDialogVisible: false,
      SpecialColumnCommodListDialogVisible:false,
      loading:false
    }
  },
  methods: {
    del(val){
      this.$axios.get("/api/market/SpecialColumn/removeSpecialColumnCommodById",{params:{id:val.specColumnId}}).then(res=>{
        var data = res.data
        if (data.code === 200) {
          ElMessage.success({
            message: '删除成功',
            type: 'success'
          });
        } else {
          ElMessage.error({
            message: '删除失败，请联系管理员',
          });
        }
        this.getData()
      })
    },
    async getData(){
      this.loading = true
      await this.$axios.get("/api/market/SpecialColumn/listSpecColumn").then(res=>{
        var data = res.data
        if (data.code === 200){
          this.tableData = data.data
        }
      })
      this.loading = false
    },
    showCommodList(val){
      this.SpecialColumnCommodListDialogVisible = true
      setTimeout(()=>{
        this.$refs.SpecialColumnCommodList.getData(val.specColumnId)
      },100)

    }
  }
}
</script>

<style scoped>

</style>