<template>
  <el-col class="mt-6" :span="6">
    <el-row>
      <el-image style="height: 80px;width: 150px" :fit="'cover'" :src="'http://localhost:81/img/png/logo.png'"></el-image>
      <el-divider style="height: 40px" class="bg-gray-400 place-self-center" direction="vertical"></el-divider>
      <span class="place-self-center text-3xl">注册</span>
    </el-row>
  </el-col>
  <el-col :span="16"/>
  <el-col class="mt-6" :span="2" >
    <el-image style="width: 50px;height: 50px" @click.native="jumpToIndex" :src="$http.getStatic('img/png/false.png')"
              :fit="'cover'"></el-image>
  </el-col>


  <el-col :span="4"/>
  <el-col :span="15">
    <div class="w-full border-2 border-gray-200" style="position: relative;height: 1000px">
      <div @click.native="jumpToLog" style="z-index:20;position: absolute;right: 0;top: 0;height: 70px;width: 70px">
        <svg t="1618643500763" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
             p-id="1861" width="70" height="70">
          <path
              d="M832 896H298.666667a104.533333 104.533333 0 0 1-106.666667-102.4v-101.973333h53.333333v102.826666A52.48 52.48 0 0 0 298.666667 845.653333h533.333333a52.48 52.48 0 0 0 53.333333-51.2V229.546667a52.48 52.48 0 0 0-53.333333-51.2H298.666667a52.48 52.48 0 0 0-53.333334 51.2v102.826666H192V229.546667A104.533333 104.533333 0 0 1 298.666667 128h533.333333A104.533333 104.533333 0 0 1 938.666667 229.546667v564.906666A104.533333 104.533333 0 0 1 832 896zM601.173333 352a25.6 25.6 0 0 1 0-36.693333 27.733333 27.733333 0 0 1 37.546667 0l184.32 177.066666a30.293333 30.293333 0 0 1 0 39.253334L640 708.693333a27.733333 27.733333 0 0 1-37.546667 0 25.173333 25.173333 0 0 1 0-36.266666l139.946667-134.826667H112.213333a25.6 25.6 0 1 1 0-51.2h628.906667z"
              p-id="1862"></path>
        </svg>
      </div>
      <el-row class="mt-6">
        <el-col :span="2"/>
        <el-col :span="18">
          <el-row class="formList">
            <el-col :span="6" class="grid"><span class="place-self-center">昵称：</span></el-col>
            <el-col :span="18">
              <el-input
                  placeholder="请填写昵称"
                  v-model="resData.conName">
              </el-input>
            </el-col>

            <el-col :span="6" class="grid"><span class="place-self-center">头像：</span></el-col>
            <el-col :span="18">
              <el-upload
                  class="avatar-uploader"
                  action="/api/static/fileUpload"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess"
              >
                <img v-if="resData.conAva" :src="resData.conAva" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
            </el-col>

            <el-col :span="6" class="grid"><span class="place-self-center">邮箱：</span></el-col>
            <el-col :span="18">
              <el-input
                  placeholder="请填写邮箱"
                  v-model="resData.conEmail">
              </el-input>
            </el-col>

            <el-col :span="6" class="grid"><span class="place-self-center">手机号：</span></el-col>
            <el-col :span="18">
              <el-input
                  placeholder="请填写手机号"
                  v-model="resData.conPhoneNum">
              </el-input>
            </el-col>
            <el-col :span="6" class="grid"><span class="place-self-center">密码：</span></el-col>
            <el-col :span="18">
              <el-input
                  show-password
                  placeholder="请填写密码"
                  v-model="resData.conPassword">
              </el-input>
            </el-col>


            <el-col :span="6" class="grid"><span class="place-self-center">性别：</span></el-col>
            <el-col :span="18">
              <el-radio v-model="resData.conSex" label="男">男</el-radio>
              <el-radio v-model="resData.conSex" label="女">女</el-radio>
            </el-col>
            <el-col :span="6" class="grid"><span class="place-self-center">生日：</span></el-col>
            <el-col :span="18">
            <el-date-picker
                v-model="resData.conBirthday"
                type="date"
                format="YYYY-MM-DD"
                placeholder="选择日期">
            </el-date-picker>
            </el-col>

            <el-col :span="6" class="grid"><span class="place-self-center">国籍：</span></el-col>
            <el-col :span="18">
              <el-select v-model="resData.conNation" placeholder="请选择国籍">
                <el-option
                    :label="'中国'"
                    :value="'中国'">
                </el-option>
              </el-select>
            </el-col>

            <el-col v-if="resData.conNation==='中国'" :span="6" class="grid"><span class="place-self-center">身份证号：</span>
            </el-col>
            <el-col v-if="resData.conNation==='中国'" :span="18">
              <el-input
                  placeholder="请填写身份证号"
                  v-model="resData.conCardId">
              </el-input>
            </el-col>

            <el-col v-if="resData.conNation==='中国'" :span="6" class="grid"><span class="place-self-center">民族：</span>
            </el-col>
            <el-col v-if="resData.conNation==='中国'" :span="18">
              <el-input
                  placeholder="请填写民族"
                  v-model="resData.conNationality">
              </el-input>
            </el-col>
            <el-col class="grid" :span="24">
              <el-button @click="addCon" class="justify-self-center">注册</el-button>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="4"/>
      </el-row>
    </div>
  </el-col>
  <el-col :span="5"/>

</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "regester",
  methods: {
    addCon(){
      this.resData.conBirthday.setHours(this.resData.conBirthday.getHours()+8)
      this.$http.post("/api/auth/register/consumer",this.resData)
      .then(res=>{
        console.log(res)
        if (res.data.code === 200){
          ElMessage.success({
            message: '注册成功',
            type: 'success'
          });
        }else if (res.data.code === 250) {
          ElMessage.error({
            message: '该邮箱和手机号已经注册',
          });
        }
      })
    },
    jumpToIndex() {
      this.$http.linkTo("/")
    },
    handleAvatarSuccess(res, file) {
      //获取返回的路径
      console.log(res)
      this.resData.conAva = "/api/static/img/" + res;
    },
    jumpToLog() {
      this.$http.linkTo("/log/login")
    }
  },
  data() {
    return {
      resData:{},
    }
  }
}
</script>

<style scoped>
.formList >>> .el-col {
  margin-top: 20px;
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
