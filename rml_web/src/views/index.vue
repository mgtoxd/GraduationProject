<template xmlns:el-col="http://www.w3.org/1999/html">

  <el-row id="index">

    <el-col :span="3" style="height: 1px"></el-col>
<!--    轮播图-->
    <el-col :span="18" style="padding-left:15px;padding-right: 15px">
      <el-row :gutter="30" style="margin-top: 50px">
        <el-col class="classfications" :span="4">
          <el-row>
            <el-col class="cursor-pointer" @click.native="$http.linkTo(item.link,{'title':item.title})" @mouseenter.native="show_classfication_item(index)"
                    @mouseleave.native="hide_classfication_item(index)" v-for="(item,index) in classfications"
                    :key="index" :span="24">
              <el-row class="text-center">
                <el-col :span="12"><span>{{ item.title }}</span></el-col>
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


              <div v-if="item.show" class="hover_class" style="">
                <el-row>
                  <el-col v-for="(item_product,index) in item.items" :key="index" :span="8">
                    <p>{{ item_product.title }}</p>
                  </el-col>
                </el-row>
              </div>
            </el-col>
          </el-row>
        </el-col>
        <el-col class="carouselmap" style="position: relative" :span="20">
          <el-carousel indicator-position="none">
            <el-carousel-item v-for="(item,index) in carouselmap" :key="index">
              <el-image
                  class=""
                  :src="item.img_src"
                  :fit="'cover'"
                  style="height: 100%;width: 100%">
              </el-image>
            </el-carousel-item>
          </el-carousel>
        </el-col>
        <el-col class="add_under_carousel" :span="24">
          <el-row>

            <el-col :span="4">
              <el-row>
                <el-col class="table_item" :key="index" v-for="(item,index) in add_under_carousel_table" :span="8">
                  <el-row>
                    <el-col :span="6" style="height: 1px"></el-col>
                    <el-col :span="12">
                      <el-image

                          :src="item.img_src">
                      </el-image>
                    </el-col>
                    <el-col :span="6" style="height: 1px"></el-col>
                    <el-col class="title" :span="24">
                      <p v-text="item.title"></p>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="1" style="height: 1px"/>
            <el-col :span="19">
              <el-row :gutter="50">
                <el-col  v-for="(item,index) in add_under_carousel_add" :key="index" :span="8">
                  <el-image style="height: 180px;width: 100%" :src="item.img_src" :fit="'cover'"
                  />
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
                  <p class="" v-text="seckill.title"></p>
                </el-col>
                <el-col :span="22" style="height: 1px"/>
                <el-col :span="24">
                  <el-divider></el-divider>
                </el-col>
                <el-col :span="24" style="height: 50px"/>
                <el-col :span="24">
                  <el-row :gutter="30">
                    <!--                    秒杀计时器-->
                    <el-col :span="4" >
                      <el-row class="timer">
                        <el-col :span="24" style="height: 30px"/>
                        <el-col :span="24" class="flex justify-center"><p class="title" v-text="seckill.time+'场'"></p></el-col>
                        <el-col :span="24" class="flex justify-center">
                          <el-image style="height: 80px" :src="seckill.img_src" :fit="'contain'"/>
                        </el-col>
                        <el-col :span="24" style="height: 40px"/>
                        <el-col :span="2" style="height: 1px"/>
                        <el-col :span="6" class="num"><span>00</span></el-col>
                        <el-col :span="1" class="colon"><span>:</span></el-col>
                        <el-col :span="6" class="num"><span>00</span></el-col>
                        <el-col :span="1" class="colon"><span>:</span></el-col>
                        <el-col :span="6" class="num"><span>00</span></el-col>
                        <el-col :span="2" style="height: 1px"/>
                        <el-col :span="24" style="height: 50px"/>
                      </el-row>
                    </el-col>
                    <!--                    秒杀商品-->
                    <el-col class="bg-indexPro transform " :span="4"
                            v-for="(item,index) in seckill.item" :key="index">
                      <el-row class="sec_product hover:scale-105 hover:shadow" >
                        <el-col :span="24" style="height: 30px"/>
                        <el-col :span="24" class="flex justify-center">
                          <el-image :src="item.img_src" :fit="'contain'"/>
                        </el-col>
                        <el-col :span="24" style="height: 25px"/>
                        <el-col :span="24" class="sec_title"><p v-text="item.title"></p></el-col>
                        <el-col :span="24" class="sec_describe"><p v-text="item.describe"></p></el-col>
                        <el-col :span="12" class="sec_price"><p v-text="item.price"></p></el-col>
                        <el-col :span="12" class="sec_oldprice"><p v-text="item.old_price"></p></el-col>
                        <el-col :span="24" style="height: 60px"/>
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
              <el-image  :src="banner_under_special.img_src" class="h-32 w-full" :fit="'cover'"/>
            </el-col>
          </el-row>
          <!--          栏目-->
          <div class="mt-10" :key="index" v-for="(item,index) in channel.items">
            <el-row>
              <el-col class=" leading-10 mt-2.5 mb-2.5 text-2xl"><p>{{item.title}}</p></el-col>
            </el-row>
            <el-row :gutter="20">
<!--              封皮-->
              <el-col :span="5" style="height: 620px">
                <el-image :src="item.cover.img_src" class="h-full w-full pb-1.5 pt-1.5"/>
              </el-col>
              <el-col :span="19" style="height: 620px">
                <el-row :gutter="40">
                  <el-col  :key="index" v-for="(item_pro,index) in item.items" :span="6">
                    <el-image  :src="item_pro.src" style="height: 300px" class="w-full pb-1.5 pt-1.5 hover:scale-105 hover:shadow"></el-image>
                  </el-col>
                  <el-col :span="6" >
                    <div style="background-color: #fff;height: 300px"  class="w-full h-full    pb-1.5 pt-1.5">
                      <el-row class="flex justify-center mt-14 font-bold text-3xl" style="color: #c53030">
                        <p>查看更多</p>
                      </el-row>
                      <el-row class="flex justify-center">
                        <el-image :src="channel.more_img" class="w-20 h-20 mt-20" ></el-image>
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
  name: "index",
  data() {
    return {
      carouselmap: [
        {
          img_src: this.$http.getStatic('img/png/1.png'),
          link: ''
        },
        {
          img_src: this.$http.getStatic('img/png/2.png'),
          link: ''
        },
      ],
      classfications: [
        {
          title: 'gogo',
          link: '/classfication',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'da2222dda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },

          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        }, {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },
        {
          title: 'gogo',
          link: '',
          show: false,
          items: [
            {
              title: 'dawwadda',
              img_src: '',
              link: ''
            },
            {
              title: 'adad',
              img_src: '',
              link: ''
            },
          ]
        },


      ],
      add_under_carousel_table: [
        {
          title: '限时秒杀',
          img_src: this.$http.getStatic('img/png/seckill.png'),
        },
        {
          title: '1',
          img_src: '',
        },
        {
          title: '1',
          img_src: '',
        },
        {
          title: '1',
          img_src: '',
        },
        {
          title: '1',
          img_src: '',
        },
        {
          title: '1',
          img_src: '',
        },
      ],
      add_under_carousel_add: [
        {
          img_src: 'http://localhost:81/img/jpg/william-christen-hB_nkwIw5f4-unsplash.jpg',
          link: ''
        },
        {
          img_src: 'http://localhost:81/img/jpg/william-christen-hB_nkwIw5f4-unsplash.jpg',
          link: ''
        },
        {
          img_src: 'http://localhost:81/img/jpg/william-christen-hB_nkwIw5f4-unsplash.jpg',
          link: ''
        },
      ],
      seckill: {
        title: '限时秒杀',
        time: '10:00',
        img_src: this.$http.getStatic('img/png/seckill.png'),
        item: [
          {
            img_src: ' http://localhost:81/img/png/seckill.png',
            title: 'title',
            describe: '描述',
            price: '156',
            old_price: '158'
          },
          {
            img_src: ' http://localhost:81/img/png/seckill.png',
            title: 'title',
            describe: '描述',
            price: '156',
            old_price: '158'
          },
        ]
      },
      banner_under_special: {
        img_src: this.$http.getStatic('img/jpg/river-5978743.jpg'),
        link: ""
      },
      channel: {
        more_img:this.$http.getStatic('img/png/more.png'),
        items:[
          {
            title:'跟团游',
            link:'',
            cover:{
              img_src:'',
              link:''
            },
            items:[
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
            ]
          },
          {
            title:'情侣游',
            link:'',
            cover:{
              img_src:'',
              link:''
            },
            items:[
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
            ]
          },
          {
            title:'出国游',
            link:'',
            cover:{
              img_src:'',
              link:''
            },
            items:[
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
              {
                title:'',
                describe:'',
                price:'',
                link:'',
                src:''
              },
            ]
          }
        ]

    }
    }
  },
  methods: {
    show_classfication_item(i) {
      this.classfications[i].show = true;
    },
    hide_classfication_item(i) {
      this.classfications[i].show = false;
    }
  }

}
</script>

<style scoped>
@import "http://localhost:81/css/index.css";
</style>
