<template>
  <div id="classfication">
    <el-row>
      <el-col style="height: 750px" class="mt-20" :span="24">
        <el-carousel arrow="never" indicator-position="none" style="height: 750px" >
          <el-carousel-item class="cursor-pointer" style="height: 750px"  v-for="(item,index) in head_image" :key="index">
            <el-image :src="item.img_src" style="height: 750px" :fit="'cover'"/>
          </el-carousel-item>
        </el-carousel>
      </el-col>
      <el-col style="background-color: #f5f5f5"  :span="24">
        <el-row  class=" h-full">
          <el-col :span="4" class="h-1"/>
          <el-col :span="16">
            <el-row :gutter="40" class="mt-20" v-for="(item_p,index) in product" :key="index" >
              <el-col :span="24">
                <p class="text-3xl font-bold">{{item_p.title}}</p>
              </el-col>
              <el-col class="mt-10 cursor-pointer " v-for="(item,index) in item_p.item" :key="index" :span="item.row?24:12" @click.native="$http.linkTo('/product',{title:item.link})">
                <el-row>
                  <el-col :span="24">
                    <el-image class="w-full h-full"  :src="item.img_src" style="height: 350px;margin-bottom: 0"  :fit="'cover'"/>
                  </el-col>
                  <el-col class="h-28 bg-white flex" :span="16">
                    <div class="ml-12 self-center">
                      <p class="font-bold text-3xl">{{item.title}}</p>
                      <p class="text-gray-600">{{item.describe}}</p>
                    </div>
                  </el-col>
                  <el-col class="h-28 bg-white flex" :span="8">
                    <div class="self-center mt-3" style="color: #ff6700">
                      <span class="text-3xl" >{{item.price}}</span>
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
    this.title = this.$route.query.title
  },
  name: "classfication",
  data(){
    return{
      title:'wdad',
      head_image:[
        {
          img_src:this.$http.getStatic('img/jpg/demo.jpg'),
          link:''
        },
        {
          img_src:this.$http.getStatic('img/jpg/demo.jpg'),
          link:''
        },
        {
          img_src:this.$http.getStatic('img/jpg/demo.jpg'),
          link:''
        },
        {
          img_src:this.$http.getStatic('img/jpg/demo.jpg'),
          link:''
        },
      ],
      product:[
        {
          title:'title1',
          item:[
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'demo1',
              describe:'描述',
              price:'500',
              row:true,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
          ]
        },
        {
          title:'title2',
          item:[
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:true,
            },
            {
              title:'demo',
              img_src:this.$http.getStatic('img/jpg/demo.jpg'),
              link:'',
              describe:'描述',
              price:'500',
              row:false,
            },
          ]
        },
      ]
    }
  }
}
</script>

<style scoped>
@import "http://localhost:81/css/classfication.css";

</style>