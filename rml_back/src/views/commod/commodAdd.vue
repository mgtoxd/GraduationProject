<template>
  <el-row class="mt-20">
    <el-col :span="24" class="grid">
      <el-form style="overflow:auto;height: 650px;width: 900px" class="pr-5 grid justify-self-center" ref="form" :model="form" label-width="80px">
        <el-form-item label="商品名称">
          <el-input v-model="form.commodName"  clearable></el-input>
        </el-form-item>
        <el-form-item label="商品简要描述">
          <el-input type="textarea" v-model="form.commodDescription"  clearable></el-input>
        </el-form-item>
        <el-form-item label="页面展示图片">
          <el-upload
              class="avatar-uploader"
              action="/api/static/fileUpload"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
          >
            <img v-if="commodIndexImg" :src="commodIndexImg" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="轮播图片">
          <el-upload
              class="upload-demo"
              action="/api/static/fileUpload"
              :on-change="changeUrls"
              list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="日常价格">
          <el-input type="textarea" v-model="form.commodPrice"  clearable></el-input>
        </el-form-item>
        <el-divider></el-divider>
        <el-form-item class="" v-for="(item,index) in form.trips" :label="'行程'+(index+1)">
          <el-input class="mt-3" placeholder="请输入景点名称" v-model="item.commodTripLocation"  clearable></el-input>
          <el-input class="mt-3" placeholder="请输入景点描述" type="textarea" v-model="item.commodTripDescribe"  clearable></el-input>
          <el-input class="mt-3 mb-3" placeholder="请输入景点所花时间" v-model="item.commodTripTime"  clearable>
            <template #append>开始-结束</template>
          </el-input>
        </el-form-item>
        <el-button class="justify-self-center" type="primary" @click="addTrip">添加行程</el-button>
        <el-divider></el-divider>
        <el-form-item class="mt-6"  label="类别">
          <el-select v-model="form.classifyIds" multiple  placeholder="请选择活动区域">
            <el-option v-for="(item,index) in classifyList" :label="item.classifyName" :value="item.classifyId"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="商品详细描述">
          <el-input type="textarea" v-model="form.commodTxt"  clearable></el-input>
        </el-form-item>

        <el-form-item label="商品默认库存(每日)">
          <el-input-number v-model="form.stock" :min="1" label="描述文字"></el-input-number>
        </el-form-item>

        <el-form-item label="商品默认最小库存(每日)">
          <el-input-number v-model="form.lowStock" :min="1" label="描述文字"></el-input-number>
        </el-form-item>
      </el-form>
      <el-button class="w-32 mt-24 justify-self-center " @click="addCommod"  type="primary">添加商品
      </el-button>
    </el-col>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "commodAdd",
  created() {
    this.$axios.get("/api/commod/classify/page",{
      params:{
        count:1,
        size:100
      }
    }).then(res=>{
      var data = res.data
      if (data.code===200){
        this.classifyList = data.data
      }
    })
  },
  data() {
    return {
      commodIndexImg:'',
      classifyList:[],
      dialogImageUrl: '',
      dialogVisible: false,
      caroulurls:[],
      form: {
        trips:[{},],
        caroulurls:[],
        stock:1,
        lowStock:1
      }
    }
  },
  methods:{
    addTrip(){
      this.form.trips.push({})
    },
    handleAvatarSuccess(res, file) {
      //获取返回的路径
      console.log(res)
      this.commodIndexImg = "/api/static/img/" + res;
      this.form.commodIndexImg = res;
    },
    load(){},
    addCommod(){

      this.caroulurls.forEach((item,index)=>{
        this.form.caroulurls.push(
          item.response
        )
      })
      this.form.trips.forEach((item,index)=>{
        item.commodTripSort=index
      })
      this.$axios.post("/api/commod/Commod/setCommod",this.form).then(res=>{
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

    changeUrls(file, fileList){
      console.log(file);
      console.log(fileList);
      this.caroulurls = fileList;
    },
  }
}
</script>

<style scoped>
.el-form-item >>> .el-form-item__label{
  width: 120px !important;
}

.el-form-item >>> .el-form-item__content{
  margin-left: 120px !important;
}
</style>