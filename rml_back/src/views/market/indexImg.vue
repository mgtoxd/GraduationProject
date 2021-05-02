<template>
<el-row>
  <el-col :span="20"/>
  <el-col :span="4">
    <el-button type="primary" @click="showAddDialog" class="el-icon-plus" round></el-button>
  </el-col>
  <el-col :span="2"/>
  <el-col :span="20">
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
          <el-image class="w-12 h-12" :src="getImg(scope.row.commodIndexImg)"></el-image>
        </template>
      </el-table-column>
      <el-table-column
          label="分类信息"
          width="100">
        <template #default="scope">
          <el-button @click="showClassify(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column
          label="价格信息"
          width="100">
        <template #default="scope">
          <el-button @click="showPrice(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column
          label="库存信息"
          width="100">
        <template #default="scope">
          <el-button @click="showSku(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column
          label="行程信息"
          width="100">
        <template #default="scope">
          <el-button @click="showTrip(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column
          prop="commodDescription"
          label="简要描述">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template #default="scope">
          <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-col>
  <el-col :span="2"/>
</el-row>
</template>

<script>
import IndexImgAdd from "@/components/IndexImgAdd";
export default {
name: "indexImg",
  components: {IndexImgAdd},
  data(){
  return{
    IndexImgDialogVisible:false
  }
  },
  methods:{
    showAddDialog(){
      this.IndexImgDialogVisible=true
    }
  }
}
</script>

<style scoped>
::v-deep .el-button:focus{
  outline: none !important;
}
</style>