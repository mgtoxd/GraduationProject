<template xmlns:el-col="http://www.w3.org/1999/html">

  <el-row id="index" v-if="loading">

    <el-col :span="3" style="height: 1px"></el-col>
    <!--    轮播图-->
    <el-col :span="18" style="padding-left:15px;padding-right: 15px">
      <el-row :gutter="30" style="margin-top: 50px">
        <el-col class="classfications" :span="4">
          <el-row>
            <el-col class="cursor-pointer"
                    @mouseenter.native="show_classfication_item(index)"
                    @mouseleave.native="hide_classfication_item(index)" v-for="(item,index) in classfications"
                    :key="index" :span="24">
              <el-row class="justify-items-center" @click.native="$http.linkTo('/classfication',{'id':item.id})">
                <el-col :span="12"><span class="font-bold">{{ item.title }}</span></el-col>
                <el-col :span="12">
                  <div class="mt-4">
                    <svg t="1613562809492" class="icon" viewBox="0 0 1024 1024" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" p-id="1373" width="15" height="15">
                      <path
                          d="M711.095467 468.096c-84.821333-142.250667-169.728-284.416-254.634667-426.666667A84.821333 84.821333 0 0 0 339.895467 12.16a85.546667 85.546667 0 0 0-29.098667 117.077333c76.117333 127.573333 152.32 255.146667 228.522667 382.72L310.7968 894.762667a85.589333 85.589333 0 0 0 29.098667 117.077333c40.192 24.234667 92.330667 11.093333 116.565333-29.269333 84.906667-142.250667 169.813333-284.416 254.634667-426.666667 18.986667-31.744 18.986667-56.064 0-87.808z"
                          p-id="1374" fill="#ffffff"></path>
                    </svg>
                  </div>
                </el-col>
              </el-row>

            </el-col>
          </el-row>
        </el-col>
        <el-col class="carouselmap" style="position: relative" :span="20">
          <el-carousel indicator-position="none">
            <el-carousel-item v-for="(item,index) in real_carouselmap" @click.native="jumpToCommodById(item.commodId)" :key="index">
<!--              <el-image-->
<!--                  :src="'/api/static/img/'+item.imgUrl"-->
<!--                  :fit="'cover'"-->
<!--                  style="height: 100%;width: 100%">-->
<!--              </el-image>-->
              <div :style="{'background-image': 'url(/api/static/img/'+item.imgUrl+')'}" class="bg-cover w-full h-full cursor-pointer" >
                <el-row>
                  <el-col :span="15" class="h-1"/>
                  <el-col :span="9">
                    <p class="mt-24 text-4xl font-bold font-serif text-white">{{item.commodName}}</p>
                  </el-col>
                </el-row>
              </div>
            </el-carousel-item>
          </el-carousel>
        </el-col>
        <el-col class="add_under_carousel" :span="24">
          <el-row>

            <el-col @click.native="$http.linkTo('/costomized')" class="border-2 border-yellow-500 grid cursor-pointer transform hover:scale-110 duration-200   flex bg-cover" style="background-image: url('http://localhost:81/img/jpg/costomize.jpg')" :span="4">
              <p class="self-center justify-self-center text-white text-2xl">定制你的旅行</p>
            </el-col>
            <el-col :span="1" style="height: 1px"/>
            <el-col :span="19">
              <el-row :gutter="50">
                <el-col class=" cursor-pointer" v-for="(item,index) in carouselmap" :key="index" v-show="item.posName==='轮播图下小专题'" @click.native="jumpToCommodById(item.commodId)" :span="8">
                  <div class="relative bg-cover w-full  transform hover:scale-110 duration-200  " style="height: 180px" :style="{'background-image': 'url(/api/static/img/'+item.imgUrl+')'}">
                      <el-row class="absolute bg-black w-full bg-opacity-50 " style="bottom: 0;left: 0">
                        <el-col class="grid" :span="24">
                          <p class="justify-self-center text-white truncate w-4/5 text-center ">{{ item.commodName }}</p>
                        </el-col>
                      </el-row>
                  </div>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="24" style="height: 50px"/>
      </el-row>
    </el-col>
    <el-col :span="3" style="height: 1px"></el-col>
    <el-col :span="24" style="height: 100px"/>
    <!--    专栏-->
    <el-col class="special_column" :span="24">
      <el-row>
        <el-col :span="3" style="height: 1px"/>
        <el-col :span="18">
          <!--          秒杀-->
          <el-row>
            <el-col :span="24" class="seckill">
              <el-row>
                <el-col :span="2" class="leading-10 mt-2.5 mb-2.5 text-2xl">
                  <p class="" v-text="'秒杀'"></p>
                </el-col>
                <el-col :span="22" style="height: 1px"/>
                <el-col :span="24">
                  <el-divider></el-divider>
                </el-col>
                <el-col :span="24" style="height: 50px"/>
                <el-col :span="24">
                  <el-row :gutter="30">
                    <!--                    秒杀计时器-->
                    <el-col :span="4">
                      <el-row class="timer">
                        <el-col :span="24" style="height: 30px"/>
                        <el-col :span="24" class="flex justify-center"><p class="title" v-text="getHMS(secKill.info.secDateTime)+'场'"></p>
                        </el-col>
                        <el-col :span="24" class="flex justify-center">
                          <el-image style="height: 80px" :src="$http.getStatic('/img/png/seckill.png')" :fit="'contain'"/>
                        </el-col>
                        <el-col :span="24" style="height: 40px"/>
                        <el-col :span="2" style="height: 1px"/>
                        <el-col :span="6" class="num"><span v-text="secKill.countDownTime.hour<10?'0'+secKill.countDownTime.hour:secKill.countDownTime.hour"></span></el-col>
                        <el-col :span="1" class="colon"><span>:</span></el-col>
                        <el-col :span="6" class="num"><span v-text="secKill.countDownTime.minute<10?'0'+secKill.countDownTime.minute:secKill.countDownTime.minute"></span></el-col>
                        <el-col :span="1" class="colon"><span>:</span></el-col>
                        <el-col :span="6" class="num"><span v-text="secKill.countDownTime.seconed<10?'0'+secKill.countDownTime.seconed:secKill.countDownTime.seconed"></span></el-col>
                        <el-col :span="2" style="height: 1px"/>
                        <el-col :span="24" style="height: 50px"/>
                      </el-row>
                    </el-col>
                    <!--                    秒杀商品-->
                    <el-col class="bg-indexPro transform " style="background-color:#f1f1f1" :span="4"
                            v-for="(item,index) in secKill.items" :key="index">
                      <el-row class="sec_product hover:scale-105 hover:shadow">
                        <el-col :span="24" style="height: 30px"/>
                        <el-col :span="3" style="height: 1px"/>
                        <el-col :span="18" class="flex justify-center">
                          <el-image :src="'/api/static/img/'+item.commodIndexImg" :fit="'cover'"/>
                        </el-col>
                        <el-col :span="3" style="height: 1px"/>
                        <el-col :span="24" style="height: 25px"/>
                        <el-col :span="24" class="sec_title font-bold "><p class="truncate" v-text="item.commodName"></p></el-col>
                        <el-col :span="24" class="h-6 sec_describe"><p style="display: -webkit-box;	-webkit-box-orient: vertical;	-webkit-line-clamp: 3;	overflow: hidden;" v-text="item.commodDescription"></p></el-col>
                        <el-col :span="12" class="sec_price mt-8 text-red-600 text-xl"><p v-text="item.secPrice"></p></el-col>
                        <el-col :span="1" style="height: 1px"/>
                        <el-col :span="11" class="sec_price mt-8 text-red-600 text-xl" style="text-align: left"><span>元</span></el-col>
                        <el-col :span="24" style="height: 10px"/>
                      </el-row>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
          <!--    广告条幅-->
          <el-row>
            <el-col class="mt-12" :span="24">
              <el-image  class="h-32 w-full cursor-pointer" v-for="(item,index) in carouselmap" v-show="item.posName==='横幅'" @click.native="jumpToCommodById(item.commodId)" :src="'/api/static/img/'+item.imgUrl"  :fit="'cover'"/>
            </el-col>
          </el-row>
          <!--          栏目-->
          <div class="mt-10" :key="index" v-for="(item,index) in channel.items">
            <el-row>
              <el-col class=" leading-10 mt-2.5 mb-2.5 text-2xl"><p>{{ item.specColumnTitle }}</p></el-col>
            </el-row>
            <el-row :gutter="20">
              <!--              封皮-->
              <el-col :span="5" style="height: 620px">
                <el-image :src="'/api/static/img/'+item.specColumnImgUrl" :fit="'cover'" class="h-full w-full pb-1.5 pt-1.5  transform hover:scale-105 duration-200 "/>
              </el-col>
              <el-col :span="19" style="height: 620px">
                <el-row :gutter="40">
                  <el-col :key="index" @click.native="jumpToCommodById(item_pro.commodId)"  v-for="(item_pro,index) in item.items" :span="6">
                    <div class="relative bg-cover w-full  bg-opacity-50 cursor-pointer transform hover:scale-110 duration-200 " style="height: 300px; margin-top: 5px" :style="{'background-image': 'url(/api/static/img/'+item_pro.specColumnCommodImgUrl+')'}">
                      <el-row class="absolute bg-black w-full" style="bottom: 0;left: 0">
                        <el-col class="grid" :span="24">
                          <p class="justify-self-center text-white truncate w-4/5 text-center ">{{ item_pro.commodName }}</p>
                        </el-col>
                      </el-row>
                    </div>
<!--                    <el-image :src="'/api/static/img/'+item_pro.specColumnCommodImgUrl" style="height: 300px" :fit="'cover'"-->
<!--                              class="w-full pb-1.5 pt-1.5 hover:scale-105 hover:shadow"></el-image>-->
                  </el-col>
                  <el-col :span="6">
                    <div style="background-color: #fff;height: 300px" class="w-full h-full    pb-1.5 pt-1.5">
                      <el-row class="flex justify-center mt-14 font-bold text-3xl" style="color: #c53030">
                        <p>查看更多</p>
                      </el-row>
                      <el-row class="flex justify-center">
                        <el-image :src="$http.getStatic('img/png/more.png')" class="w-20 h-20 mt-20"></el-image>
                      </el-row>
                    </div>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
          </div>
          <el-row style="height: 100px"/>
        </el-col>
        <el-col :span="3" style="height: 1px"/>
      </el-row>
    </el-col>

  </el-row>
</template>

<script>
export default {
  async created() {
    this.loading = false
    await this.$http.get("/api/market/index/getIndexList",{}).then(res=>{
      var data = res.data
      if (data.code===200){
        this.carouselmap = data.data
        this.carouselmap.forEach((item,index)=>{
          if (item.posName==='首页轮播'){
            this.real_carouselmap.push(item)
          }
        })
      }
    })
    this.$http.get("/api/market/SecK/getClosestSecKillId").then(res=>{
      var data = res.data
      if (data.code===200){
        this.secKill.info = data.data
        this.$http.get("/api/market/SecK/getSecKillCommodBySecKillId",{params:{id:this.secKill.info.secKillId}}).then(res=>{
          var data = res.data
          if (data.code===200){
            this.secKill.items = data.data

          }
        })
      }
    })

    this.$http.get("/api/market/SpecialColumn/getIndexSpecialColumn",{}).then(res=>{
      var data = res.data
      if (data.code===200){
        this.channel.items = data.data
      }
    })
    this.loading = true
  },
  name: "index",
  data() {
    return {
      secKill:{
        countDownTime:{},
        info:{},
        items:[]
      },
      loading:false,
      real_carouselmap:[],
      carouselmap: [],
      classfications: [
        {
          title: '周末游',
          id:'a2dbd6b5c03535a74840c640fea9c922',
          show: false,
        },
        {
          title: '跟团游',
          id:'62d85d87f9fce9e304349953fa027013',
          show: false,

        },
        {
          title: '自由行',
          show: false,
          id:'51a7281f5b0ff4a0cf3cc8b913faf709'
        },
        {
          title: '私家团',
          show: false,
          id:'aee865a0d58ab611d5d2d810f9716875'
        },
        {
          title: '主题游',
          show: false,
          id:'a2dbd6b5c03535a74840c640fea9c922'
        },
        {
          title: '情侣游',
          show: false,
          id:'6a2c6533c2c8ecac7b24f6d7e2594246'
        }, {
          title: '高端游',
          show: false,
          id:'d54f03a248ef3b29830066cbf24b839a'
        },
        {
          title: '邮轮游',
          show: false,
          id:'f9c8e98268543cdb36aa7e00cba20b39'
        },
        {
          title: '出境游',
          show: false,
          id:'119ecd30f15644b0f8a9b59ab2c7c4f7'
        },
        {
          title: '长线游',
          show: false,
          id:'32a4e9797127199a085dd6014a2fd689'
        },


      ],
      add_under_carousel_add: [],
      banner_under_special: {
        img_src: this.$http.getStatic('img/jpg/river-5978743.jpg'),
        link: ""
      },
      channel: {
        more_img: this.$http.getStatic('img/more.png'),
        items: [
          {
            title: '跟团游',
            link: '',
            cover: {
              img_src: this.$http.getStatic('img/test/channel/1.jpg'),
              link: ''
            },
            items: [
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/2.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/3.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/4.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/6.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/7.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/9.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/8.jpg')
              },
            ]
          },
          {
            title: '情侣游',
            link: '',
            cover: {
              img_src: this.$http.getStatic('img/test/channel/8.jpg'),
              link: ''
            },
            items: [
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/12.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/2.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/10.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/3.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/4.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/6.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/11.jpg')
              },
            ]
          },
          {
            title: '出国游',
            link: '',
            cover: {
              img_src: this.$http.getStatic('img/test/channel/10.jpg'),
              link: ''
            },
            items: [
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/5.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/7.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/9.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/12.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/3.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/1.jpg')
              },
              {
                title: '',
                describe: '',
                price: '',
                link: '',
                src: this.$http.getStatic('img/test/channel/4.jpg')
              },
            ]
          }
        ]

      }
    }
  },
  methods: {
    show_classfication_item(i) {
      // this.classfications[i].show = true;
    },
    hide_classfication_item(i) {
      // this.classfications[i].show = false;
    },
    jumpToCommodById(val){
      this.$router.push({path:'/detail',query:{id:val}})
    },
    getHMS(val){
      var time = this.$timeFormat(val)

      window.setInterval(() => {
        setTimeout(()=>{
          var now = this.$timeFormat()
          var diffMinute = time.diff(now,'minute')%60<0?0:time.diff(now,'minute')%60
          var diffSeconed = time.diff(now,'second')%60<0?0:time.diff(now,'second')%60
          var diffHour = time.diff(now,'hour')<0?0:time.diff(now,'hour')
          if (diffSeconed!==0){
            this.secKill.countDownTime={
              hour:diffHour,
              minute:diffMinute,
              seconed:diffSeconed
            }
          }

          console.log(this.secKill.countDownTime)
        }, 500)






      }, 500)


      return (time.hours()<10?'0'+time.hour():time.hour())+':'+(time.minute()<10?'0'+time.minute():time.minute())+':'+(time.second()<10?'0'+time.second():time.second())
    }
  }

}
</script>

<style scoped>
@import "http://localhost:81/css/index.css";
</style>
