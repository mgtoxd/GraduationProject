<template>
<el-row style="margin-right: 10%;margin-left: 10%">

  <el-col :span="24">
    <el-form class="w-96 justify-self-center" ref="form" label-width="80px">
      <el-form-item :label="'专栏'+(index+1)" v-for="(item,index) in form.List">
        <el-row>
          <el-col :span="20">
            <el-upload
                class="avatar-uploader"
                action="/api/static/fileUpload"
                :show-file-list="false"
                :on-success="(response, file, fileList)=>handleImgSuccess(response, file, fileList,item)"
            >
              <el-image v-if="item.specColumnCommodImgUrl" :src="'/api/static/img/' + item.specColumnCommodImgUrl" class="avatar"/>
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-input type="text" placeholder="介绍" v-model="item.introduce"></el-input>
            <el-select v-model="item.specColumnId" clearable placeholder="选择位置">
              <el-option
                  v-for="signItem in SpecialColList"
                  :key="signItem.specColumnId"
                  :label="signItem.specColumnTitle"
                  :value="signItem.specColumnId">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            <el-button type="danger" @click="removePos(item)">删除</el-button>
          </el-col>
        </el-row>

        <el-divider></el-divider>
      </el-form-item>
      <el-button type="primary" @click="addSpeColumn">增加专栏信息</el-button>
      <el-button type="primary" @click="setSpeColumnCommod">提交</el-button>
    </el-form>
  </el-col>

</el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "SpecialColumnAdd",
  methods:{
    handleImgSuccess(response, file, fileList, item){
      item.specColumnCommodImgUrl = response
    },
    addSpeColumn(){
      this.form.List.push({
        commodId:this.id
      })
    },
    setSpeColumnCommod(){
      this.$axios.post("/api/market/SpecialColumn/addOrUpdateSpecColumnCommodList",this.form.List).then(res=>{
        var data = res.data
        if(data.code === 200){
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

    getData(commodId){
      this.id = commodId
      this.$axios.get("/api/market/SpecialColumn/listSpecColumn").then(res=>{
        var data = res.data
        if (data.code === 200){
          this.SpecialColList = data.data
        }
      })
      this.$axios.get("/api/market/SpecialColumn/listSpecColumnCommodBycommodId",{params:{id:this.id}}).then(res=>{
        var data = res.data
        if (data.code === 200){
          this.form.List = data.data
        }
      })
    }
  },
  created() {

  },
  data(){
    return{
      id:'',
      SpecialColList:[],
      form:{
        List:[
          {}
        ]
      }
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