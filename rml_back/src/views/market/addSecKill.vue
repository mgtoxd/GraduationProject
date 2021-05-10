<template>
  <el-row >
    <el-col :span="24" class="grid">
      <el-form class="justify-self-center" style="overflow:auto;height: 650px;width: 900px">
        <el-form-item label="秒杀活动名称">
          <el-input type="text" v-model="form.secName"></el-input>
        </el-form-item>
        <el-form-item label="秒杀活动时间">
          <el-date-picker
              v-model="form.secDateTime"
              type="datetime"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-button @click="addSecK">添加</el-button>
      </el-form>
    </el-col>

  </el-row>

</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "addSecKill",
  data(){
    return{
      form:{}
    }
  },
  methods:{
    addSecK(){
      this.form.secDateTime= this.$moment(this.form.secDateTime).add(8,'h').toISOString()
      this.$axios.post("/api/market/SecK/addSecKill",this.form).then(res=>{
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
    }
  }
}
</script>

<style scoped>
.el-form-item ::v-deep .el-form-item__label{
  width: 120px !important;
}

.el-form-item ::v-deep .el-form-item__content{
  margin-left: 120px !important;
}
</style>