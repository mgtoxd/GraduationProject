<template>
  <el-row>
    <!--  弹窗代码开始-->
    <!--    分类弹窗-->
    <el-dialog title="分类信息" v-model="ClassifyDialogVisible">
      <el-form v-loading="classifyLoading" class="w-96 justify-self-center" ref="form" label-width="80px">
        <el-form-item label="分类">
          <el-select v-model="classifyForm.classifyIds" multiple placeholder="请选择分类">
            <el-option v-for="(item,index) in classifyList" :label="item.classifyName"
                       :value="item.classifyId"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="ClassifyDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updateClassify">提交</el-button>
        </span>
      </template>
    </el-dialog>

    <!--价格信息弹窗-->
    <el-dialog title="价格信息" v-model="price.dialogVisible">
      <el-form v-loading="price.loading" style="width: 500px" class="justify-self-center" label-width="80px">
        <el-form-item label="日常价格">
          <el-input type="text" v-model="price.form.commodPrice"></el-input>
        </el-form-item>
        <el-form-item label="特殊价格">
          <el-row :gutter="100" v-for="(item,index) in price.speDataPrice">
            <el-col :span="12">
              <el-row>
                <el-col :span="5"><span>日期:</span></el-col>
                <el-col :span="17">
                  <el-date-picker
                      v-model="item.commodDateSpecial"
                      type="date"
                      placeholder="选择日期">
                  </el-date-picker>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="12">
              <el-row>
                <el-col :span="5"><span>价格:</span></el-col>
                <el-col :span="19">
                  <el-input type="text" v-model="item.commodPriceSpecial"></el-input>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-form-item>
        <el-button type="primary" @click="addSpecialDataPrice">添加特殊价格日期</el-button>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="price.dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updatePrice">提交</el-button>
        </span>
      </template>
    </el-dialog>


    <!--库存信息弹窗-->
    <el-dialog title="库存信息" v-model="sku.dialogVisible">
      <el-form v-loading="sku.loading" style="width: 500px" class="justify-self-center" label-width="80px">
        <el-form-item v-for="(item,index) in sku.skuList" v-show="item.date===null" label="日常库存">
          最大库存<el-input type="text" v-model="item.stock"></el-input>
          最小库存<el-input type="text" v-model="item.lowStock"></el-input>
        </el-form-item>
        <el-form-item label="特殊库存">
          <el-row :gutter="100" v-for="(item,index) in sku.skuList" v-show="item.date!==null">
            <el-col :span="12">
              <el-row>
                <el-col :span="5"><span>日期:</span></el-col>
                <el-col :span="17">
                  <el-date-picker
                      v-model="item.date"
                      type="date"
                      placeholder="选择日期">
                  </el-date-picker>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="12">
              <el-row>
                <el-col :span="10"><span>最大库存:</span></el-col>
                <el-col :span="14">
                  <el-input type="text" v-model="item.stock"></el-input>
                </el-col>
                <el-col :span="10"><span>最低库存:</span></el-col>
                <el-col :span="14">
                  <el-input type="text" v-model="item.lowStock"></el-input>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-form-item>
        <el-button type="primary" @click="addSpeSku">添加特殊价格日期</el-button>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="sku.dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updateSku">提交</el-button>
        </span>
      </template>
    </el-dialog>

    <!--行程信息弹窗-->
    <el-dialog title="行程信息" v-model="trip.dialogVisible">
      <el-form v-loading="trip.loading" style="width: 500px" class="justify-self-center" label-width="80px">
        <el-form-item v-for="(item,index) in trip.tripList" :label="'行程'">
          <el-input class="mt-3" placeholder="请输入景点名称" v-model="item.commodTripLocation"  clearable></el-input>
          <el-input class="mt-3" placeholder="请输入景点描述" type="textarea" v-model="item.commodTripDescribe"  clearable></el-input>
          <el-input class="mt-3 mb-3" placeholder="请输入景点所花时间" v-model="item.commodTripTime"  clearable>
            <template #append>开始-结束</template>
          </el-input>
        </el-form-item>
        <el-button type="primary" @click="addTrip">添加行程</el-button>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="sku.dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updateTrip">提交</el-button>
        </span>
      </template>
    </el-dialog>

    <!--    营销弹窗-->
    <el-dialog title="上传至营销模块" v-model="market.MarketDialogVisible">
      <el-tabs v-model="market.activeMarket" type="card" >
        <el-tab-pane label="首页图片" name="IndexImg">
          <IndexImgAdd ref="marketIndexImg" class="w-full h-full"/>
        </el-tab-pane>
        <el-tab-pane label="秒杀活动" name="secKill">秒杀活动</el-tab-pane>
      </el-tabs>
    </el-dialog>
<!--弹窗结束-->
    <el-col :span="2" style="height: 1px"/>
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
            prop="date"
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
            <el-button @click="toMarket(scope.row)" type="text" size="small">营销</el-button>
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
          @current-change=getCommodBaseData>
      </el-pagination>
    </el-col>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";
import IndexImgAdd from "@/components/IndexImgAdd";

export default {
  name: "commodList",
  components: {IndexImgAdd},
  data() {
    return {
      market:{
        activeMarket:"IndexImg",
        MarketDialogVisible:false,
      },
      classifyLoading: true,
      tableData: [],
      total: 1,
      ClassifyDialogVisible: false,
      classifyForm: {},
      classifyList: [],
      price: {
        form:{},
        dialogVisible: false,
        loading: false,
        speDataPrice: []
      },
      sku: {
        form:{},
        dialogVisible: false,
        loading: false,
        skuList:[]
      },
      trip: {
        form:{},
        dialogVisible: false,
        loading: false,
        skuList:[]
      }

    }
  },
  methods: {
    getImg(path) {
      return '/api/static/img/' + path.toString()
    },
    toMarket(val) {
      this.market.MarketDialogVisible = true
      setTimeout(()=>{
        this.$refs.marketIndexImg.getData(val.commodId)
      },100)

    },
    updateClassify() {
      this.$axios.post("/api/commod/classify/changeClassifyByCommodId", this.classifyForm).then(res => {
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
      console.log(this.classifyForm)
    },
    async showClassify(val) {
      this.classifyForm.classifyIds = []
      this.ClassifyDialogVisible = true
      this.classifyForm.commodId = val.commodId
      this.classifyLoading = true
      await this.$axios.get("/api/commod/classify/listClassifyById", {params: {id: val.commodId}}).then(res => {
        var data = res.data
        if (data.code === 200) {
          data.data.forEach((item, index) => {
            this.classifyForm.classifyIds.push(item.classifyId)
          })
        }
      })
      await this.$axios.get("/api/commod/classify/page", {
        params: {
          count: 1,
          size: 100
        }
      }).then(res => {
        var data = res.data
        if (data.code === 200) {
          this.classifyList = data.data
        }
      })
      this.classifyLoading = false;
    },
    getCommodBaseData(val) {
      this.$axios.get("/api/commod/Commod/pageBase", {
        params: {
          count: val,
          size: 10
        }
      }).then(res => {
        var data = res.data
        this.tableData = data.data.list
        this.total = data.data.pageNum * 10 + 10
      })
    },
    addSpecialDataPrice(){
      this.price.speDataPrice.push({
        commodId:this.price.commodId
      })
    },
    showPrice(val) {
      this.price = {
        form:{},
        dialogVisible: false,
        loading: false,
        speDataPrice: []
      }
      this.price.dialogVisible = true
      this.$axios.get("/api/commod/price/getPriceByCommodId",{params:{id:val.commodId}}).then(res=>{
        var data = res.data
        if (data.code === 200){
          this.price.commodId = val.commodId
          this.price.form.commodPrice =data.data.Price.commodPrice
          this.price.speDataPrice = data.data.DatePriceList
        }
      })
    },
    updatePrice(){
      this.$axios.post("/api/commod/price/setCommodPriceDate",{
        commodId:this.price.commodId,
        commodPrice:this.price.form.commodPrice,
        commodPriceDateList:this.price.speDataPrice
      }).then(res=>{
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
    showSku(val){
      this.sku={
        form:{},
        dialogVisible: false,
        loading: false,
        speDataPrice: []
      }
      this.sku.dialogVisible = true
      this.sku.id = val.commodId
      this.$axios.get("/api/commod/sku/getSkuInfoByCommodId",{params:{id:val.commodId}}).then(res=>{
        var data = res.data
        if (data.code===200){
          this.sku.skuList=data.data
        }
      })
    },
    addSpeSku(){
      this.sku.skuList.push({
        commodId:this.sku.id
      })
    },
    updateSku(){
      this.$axios.post("/api/commod/sku/setSkuInfo",{
        id:this.sku.id,
        skuList:this.sku.skuList
      }).then(res=>{
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
    showTrip(val){
      this.trip.dialogVisible=true
      this.trip.id = val.commodId
      this.$axios.get("/api/commod/trip/getTripInfoByCommodId",{params:{id:val.commodId}}).then(res=>{
        var data = res.data
        if (data.code===200){
          this.trip.tripList = data.data;
        }
      })
    },
    addTrip(){
      this.trip.tripList.push({
        commodId:this.trip.id,
        commodTripSort:this.trip.tripList.length
      })
    },
    updateTrip(){
      this.$axios.post("/api/commod/trip/setTripInfoByCommodId",this.trip.tripList).then(res=>{
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
    }
  },
  created() {
    this.getCommodBaseData(1)
  }
}
</script>

<style scoped>
::v-deep button:focus{
  outline: none;
}
</style>