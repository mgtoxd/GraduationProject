<template>
<el-row class="mt-20">
  <el-col :span="24" class="grid">
    <el-form class="w-96 justify-self-center" ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="form.adminName" @input="checkName" clearable></el-input>
        <el-tag v-if="addLoading" class="el-icon-close" type="danger">用户名不可用</el-tag>
        <el-tag v-if="!addLoading" class="el-icon-check" type="success">用户名可用</el-tag>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.adminPassword" clearable show-password></el-input>
      </el-form-item>
      <el-form-item label="工号">
        <el-input v-model="form.jobnumber" clearable></el-input>
      </el-form-item>
    </el-form>
    <el-button class="w-32 mt-24 justify-self-center " @click="addAdmin" :disabled="addLoading" type="primary">添加管理员</el-button>
  </el-col>
</el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "adminAdd",
  data(){
    return{
      form: {},
      addLoading:true

    }
  },
  methods:{
    addAdmin(){
      this.$axios.post("/api/auth/register/admin",this.form).then(res=>{
        if (res.data.code === 200){
          ElMessage.success({
            message: '添加成功',
            type: 'success'
          });
        }else {
          ElMessage.error({
            message: '添加失败，请联系管理员',
          });
        }
      })
    },
    checkName(){
      this.addLoading = true;
      this.$axios.get("/api/auth/register/adminExist",{
        params:{
          name:this.form.adminName
        },
      }).then(res=>{
        if (res.data.code === 200){
          this.addLoading = false;
          console.log(res)
        }else {

        }
      })
    }
  }
}
</script>

<style scoped>

</style>