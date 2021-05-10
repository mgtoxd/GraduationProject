<template>
  <div id="classfication">
    <el-row>
      <el-col style="height: 750px" class="" :span="24">
        <el-carousel v-if="loadin" arrow="never" indicator-position="none" style="height: 750px" >
          <el-carousel-item class="cursor-pointer" style="height: 750px" @click="$http.linkTo('/detail',{id:item.baseInfo.commodId})"  v-for="(item,index) in head_image" :key="index">
            <div class="relative bg-cover w-full h-full " :style="{'background-image': 'url(/api/static/img/'+item.baseInfo.commodIndexImg+')'}">
              <el-row class="absolute bg-black w-full bg-opacity-50 " style="bottom: 0;left: 0">
                <el-col class="grid" :span="24">
                  <p class="justify-self-center text-white truncate w-4/5 text-center ">{{ item.baseInfo.commodName }}</p>
                </el-col>
              </el-row>
            </div>
          </el-carousel-item>
        </el-carousel>
      </el-col>
      <el-col style="background-color: #f5f5f5"  :span="24">
        <el-row  class=" h-full">
          <el-col :span="4" class="h-1"/>
          <el-col :span="16">
            <el-row  :gutter="'50'">
              <el-col class="mt-10 cursor-pointer " v-for="(item,index) in product" :key="index" :span="item.row?24:12" @click.native="$http.linkTo('/detail',{id:item.baseInfo.commodId})">
                <el-row>
                  <el-col :span="24">
                    <div class="relative bg-cover w-full h-48 " :style="{'background-image': 'url(/api/static/img/'+item.baseInfo.commodIndexImg+')'}">
                      <el-row class="absolute bg-black w-full bg-opacity-50 " style="bottom: 0;left: 0">
                        <el-col class="grid" :span="24">
                          <p class="justify-self-center text-white truncate w-4/5 text-center ">{{ item.baseInfo.commodName }}</p>
                        </el-col>
                      </el-row>
                    </div>
                  </el-col>
                  <el-col class="h-28 bg-white flex" :span="16">
                    <div class="ml-12 self-center">
                      <p class="font-bold text-3xl " style="display: -webkit-box;	-webkit-box-orient: vertical;	-webkit-line-clamp: 1;	overflow: hidden;">{{item.baseInfo.commodName}}</p>
                      <p class="text-gray-600 " style="display: -webkit-box;	-webkit-box-orient: vertical;	-webkit-line-clamp: 2;	overflow: hidden;">{{item.baseInfo.commodDescription}}</p>
                    </div>
                  </el-col>
                  <el-col class="h-28 bg-white flex" :span="8">
                    <div class="self-center mt-3" style="color: #ff6700">
                      <span class="text-3xl" >{{item.price.commodPrice}}</span>
                      <span class="">元</span>
                    </div>

                  </el-col>
                </el-row>
              </el-col>

            </el-row>
          </el-col>
          <el-col :span="4" class="h-1"/>
        </el-row>

      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  created() {
    console.log(this.$route.query)
    if (this.$route.query.id){
      this.id = this.$route.query.id
      this.$http.get("/api/commod/search/listByClassify",{params:{id:this.$route.query.id}}).then(res=>{
        var data = res.data
        if (data.code===200){
          data.data.forEach((item,index)=>{
            if (index<5){
              this.head_image.push(item)
            }
            if (index===0){
              item.row=true
            }
          })
          this.product = data.data
        }
        this.loadin = true
      })
    }else if (this.$route.query.search){
      this.search = this.$route.query.search
      this.$http.get("/api/commod/search/searchByName",{params:{name:this.$route.query.search}}).then(res=>{
        var data = res.data
        if (data.code===200){
          data.data.forEach((item,index)=>{
            if (index<5){
              this.head_image.push(item)
            }
            if (index===0){
              item.row=true
            }
          })
          this.product = data.data
        }
        this.loadin = true
      })
    }

  },
  name: "classfication",
  data(){
    return{
      loadin:false,
      id:'',
      title:'wdad',
      head_image:[],
      product:[
        {
          row:true,
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },
        {
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },
        {
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        },{
          "baseInfo": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodName": "北京八达岭长城一日游",
            "commodDescription": "【国企品质】年接待量上百万人次的国企品牌，服务标准化，行程透明化。\n【自有场站】地处天安门广场前门箭楼下，集购票、候车、发车三位一体\n【定制线路】晚出发，不早起，酒店享用完早餐出发正当时；一站直达八达岭，真正纯玩无购物。",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0,
            "commodIndexImg": "2021-5/aca7af92-1bad-426f-a4bc-28d4c7f95cf4.jpg"
          },
          "price": {
            "commodId": "8c4bb41b-f1db-4209-83b3-80dd84bbcfaf",
            "commodPrice": "60",
            "createDate": "2021-05-03T14:49:39",
            "modifyDate": "2021-05-03T14:49:39",
            "isDeleted": 0
          }
        }
      ]
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/classfication.css";

</style>