<template>
  <el-row>
    <el-col :span="24">
      <el-form class="w-96 justify-self-center" ref="form" label-width="80px">
        <el-form-item label="专栏名称">
          <el-input type="text" v-model="form.specColumnTitle"></el-input>
        </el-form-item>
        <el-form-item label="专栏图片">
          <el-upload
              class="avatar-uploader"
              action="/api/static/fileUpload"
              :show-file-list="false"
              :on-success="handleImgSuccess"
          >
            <img v-if="form.specColumnImgUrl" :src="'/api/static/img/' + form.specColumnImgUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-button type="primary" @click="setSKCommod"> 提交</el-button>
      </el-form>
    </el-col>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "SpecialColumnAdd",
  data(){
    return{
      form:{
      }
    }
  },
  methods:{
    handleImgSuccess(res){
      this.form.specColumnImgUrl = res
    },
    setSKCommod(){
      this.$axios.post("/api/market/SpecialColumn/addSpecialColumn",this.form).then(res=>{
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
    }
  }
}
</script>

<style scoped>
avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>