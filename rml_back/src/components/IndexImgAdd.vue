<template>
  <el-row>
    <el-col :span="2"/>
    <el-col v-loading="loading" :span="20" class="grid">
      <el-form class="w-96 justify-self-center" ref="form" label-width="80px">
        <el-form-item :label="'位置'+(index+1)" v-for="(item,index) in form.posList">
          <el-row>
            <el-col :span="20">
              <el-upload
                  class="avatar-uploader"
                  action="/api/static/fileUpload"
                  :show-file-list="false"
                  :on-success="(response, file, fileList)=>handleAvatarSuccess(response, file, fileList,item)"
              >
                <img v-if="item.imgUrl" :src="'/api/static/img/' + item.imgUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
              <el-input type="text" placeholder="介绍" v-model="item.introduce"></el-input>
              <el-select v-model="item.comPos" clearable placeholder="选择位置">
                <el-option
                    v-for="signItem in form.IndexPosSignList"
                    :key="signItem.posId"
                    :label="signItem.posName"
                    :value="signItem.posId">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="4">
              <el-button type="danger" @click="removePos(item)">删除</el-button>
            </el-col>
          </el-row>

          <el-divider></el-divider>
        </el-form-item>
        <el-button type="primary" @click="addPos">增加位置</el-button>
        <el-button type="primary" @click="setPosList">提交</el-button>
      </el-form>
    </el-col>
    <el-col :span="2"/>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "IndexImgAdd",
  data() {
    return {
      id: '',
      loading: false,
      form: {
        IndexPosSignList: [
          {
            "secDateTime": "2021-05-04T02:00:00",
            "secStatus": null,
            "createDate": "2021-05-04T08:55:38",
            "modifyDate": "2021-05-04T08:55:38",
            "isDeleted": 0,
            "secKillId": "daawda",
            "secName": "21年5月4日9点场"
          }
        ],
        img_src: '',
        introduce: '',
        com_pos: '',
        posList: []
      }
    }
  },
  created() {
  },
  mounted() {
  },
  methods: {
    async getData(id) {
      this.id = id
      this.loading = true
      this.form.posList = []
      await this.$axios.get("/api/market/index/getIndexInfoByCommodId", {params: {id: this.id}}).then(res => {
        var data = res.data
        this.form.posList = data.data
      })
      await this.$axios.get("/api/market/index/getIndexPosList", {}).then(res => {
        var data = res.data
        if (data.code === 200) {
          this.form.IndexPosSignList = data.data
          console.log(this.form.IndexPosSignList )
        }
      })
      this.loading = false
    },
    addPos() {
      this.form.posList.push({
        commodId: this.id,
      })
    },
    setPosList() {
      this.$axios.post("/api/market/index/addIndexInfo", this.form.posList).then(res => {
        var data = res.data
        if (data.code === 200) {
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
    handleAvatarSuccess(response, file, fileList, item) {
      console.log('dwaawd')
      item.imgUrl = response;
      console.log(item)
    },
    removePos(val) {
      this.$axios.get("/api/market/index/removeInfoByindexShowCommodId", {params:{id: val.indexShowCommodId}}).then(res=>{
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
    }
  },

}
</script>

<style scoped>
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