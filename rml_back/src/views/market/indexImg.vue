<template>
  <el-row>
    <!--    修改弹窗-->
    <el-dialog title="修改" v-model="update.dialogVisible">
      <el-form v-loading="update.loading" style="width: 500px" class="justify-self-center" label-width="80px">
        <el-form-item :label="'商品图标'">
          <el-upload
              class="avatar-uploader"
              action="/api/static/fileUpload"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
          >
            <img v-if="update.form.imgUrl" :src="'/api/static/img/' + update.form.imgUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item :label="'商品介绍'">
          <el-input v-model="update.form.introduce"></el-input>
        </el-form-item>
        <el-form-item :label="'商品位置'">
          <el-select v-model="update.form.comPos" clearable placeholder="选择位置">
            <el-option
                v-for="signItem in IndexPosSignList"
                :key="signItem.posId"
                :label="signItem.posName"
                :value="signItem.posId">
            </el-option>
          </el-select>
        </el-form-item>

      </el-form>
      <el-button @click="updateIndexImg">提交修改</el-button>
    </el-dialog>
    <el-col :span="2"/>
    <el-col :span="20">
      <el-table
          v-loading="loading"
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
            <el-image class="w-12 h-12" :src="'/api/static/img/'+scope.row.imgUrl"></el-image>
          </template>
        </el-table-column>
        <el-table-column
            prop="introduce"
            label="商品介绍"
        >
        </el-table-column>
        <el-table-column
            prop="posName"
            label="商品位置"
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
import IndexImgAdd from "@/components/IndexImgAdd";
import {ElMessage} from "element-plus";

export default {
  name: "indexImg",
  components: {IndexImgAdd},
  async created() {
    await this.getdata()
  },
  data() {
    return {
      IndexPosSignList:[],
      update:{
        dialogVisible:false,
        loading:false,
        form:{},
        IndexPosSignList:[]
      },
      loading: true,
      PosMarkInfo: [],
      tableData: [],
      IndexImgDialogVisible: false,

    }
  },
  methods: {
    updateIndexImg(){
      this.$axios.post("/api/market/index/updateIndexShowCommod",this.update.form).then(res=>{
        var data = res.data
        if(data.code === 200){
          ElMessage.success({
            message: '修改成功',
            type: 'success'
          });
        } else {
          ElMessage.error({
            message: '修改失败，请联系管理员',
          });
        }
      })
    },
    showUpdateDialog(val){
      this.update ={
        dialogVisible:true,
        loading:false,
        form:val,
      }
    },
    handleAvatarSuccess(res){
      this.update.form.imgUrl = res
    },
    async getdata(){
      this.loading = true
      await this.$axios.get("/api/market/index/getIndexPosList", {}).then(res => {
        var data = res.data
        if (data.code === 200) {
          this.PosMarkInfo = data.data
        }
      })
      await this.$axios.get("/api/market/index/getIndexList", {}).then(res => {
        var data = res.data
        if (data.code === 200) {
          this.tableData = data.data
        }
      })
      await this.$axios.get("/api/market/index/getIndexPosList", {}).then(res => {
        var data = res.data
        if (data.code === 200) {
          this.IndexPosSignList = data.data
        }
      })
      this.loading = false
    },
    del(val){
      this.$axios.get("/api/market/index/removeInfoByindexShowCommodId",{params:{id:val.indexShowCommodId}}).then(res=>{
        var data = res.data
        if(data.code === 200){
          ElMessage.success({
            message: '删除成功',
            type: 'success'
          });
        } else {
          ElMessage.error({
            message: '删除失败，请联系管理员',
          });
        }
      this.getdata()
      })

    },
  }
}
</script>

<style scoped>
::v-deep .el-button:focus {
  outline: none !important;
}
.avatar-uploader .el-upload {
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