<template>
  <el-row class="mt-6">
    <el-dialog title="收货地址" v-model="dialogFormVisible">
      <el-form class="w-96 justify-self-center" ref="form" :model="adminForm" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="adminForm.adminName" disabled></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="adminForm.adminPassword" clearable show-password></el-input>
        </el-form-item>
        <el-form-item label="工号">
          <el-input v-model="adminForm.jobnumber" clearable></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="updateAdmin">提交</el-button>
        </span>
      </template>
    </el-dialog>



    <el-col :span="2" style="height: 1px"/>
    <el-col :span="20">
      <el-table
          :data="tableData"
          border
          style="width: 100%">
        <el-table-column
            prop="adminName"
            label="用户名"
            width="180">
        </el-table-column>
        <el-table-column
            prop="jobnumber"
            label="工号"
            width="180">
        </el-table-column>
        <el-table-column
            prop="date"
            label="最近修改时间">
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
    <el-col :span="2" style="height: 1px"/>
    <el-col :span="14"/>
    <el-col :span="10">
      <el-pagination
          background
          layout="prev, pager, next"
          :total="total"
      @current-change = getAdminData>
      </el-pagination>
    </el-col>
  </el-row>

</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "admin",
  created() {
    this.getAdminData(1)
  },
  data() {
    return {
      tableData: [],
      total:0,
      adminForm:{},
      dialogFormVisible : false,
      currentPage:1
    }
  },
  methods:{
    getAdminData(val){
      this.currentPage = val;
      this.$axios.get("/api/auth/admin/page",{
        params:{
          count:val,
          size:10
        }
      }).then(res=>{
        if (res.data.code===200){
          this.tableData = res.data.data.list;
          this.total = res.data.data.pageNum*10+10;
        }
      })
    },
    update(val){
      this.adminForm.adminId = val.adminId;
      this.adminForm.adminName = val.adminName
      this.dialogFormVisible=true;
    },
    updateAdmin(){
      this.dialogFormVisible = false;
      this.$axios.post("/api/auth/admin/updateAdmin",this.adminForm)
      .then(res=>{
        if (res.data.code === 200){
          ElMessage.success({
            message: '修改成功',
            type: 'success'
          });
          this.getAdminData(this.currentPage)
        }else {
          ElMessage.error({
            message: '修改失败，请联系管理员',
          });
        }
      })
    },
    del(val){
      this.$axios.get("/api/auth/admin/deleteAdmin",{
        params:{
          id:val.adminId
        }
      })
          .then(res=>{
            if (res.data.code === 200){
              ElMessage.success({
                message: '删除成功',
                type: 'success'
              });
              this.getAdminData(this.currentPage)
            }else {
              ElMessage.error({
                message: '删除失败，请联系管理员',
              });
            }
          })
    }
  }
}
</script>

<style scoped>

</style>