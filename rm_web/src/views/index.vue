<template>
  <el-row id="index">

    <el-col :span="3" style="height: 1px"></el-col>
    <el-col :span="18">
      <el-row :gutter="30" style="margin-top: 50px">
        <el-col class="classfications" :span="4">
          <el-row>
            <el-col @mouseenter.native="show_classfication_item(index)"
                    @mouseleave.native="hide_classfication_item(index)" v-for="(item,index) in classfications"
                    :key="index" :span="24">
              <span>{{ item.title }}</span>
              <svg t="1613562809492" class="icon" viewBox="0 0 1024 1024" version="1.1"
                   xmlns="http://www.w3.org/2000/svg" p-id="1373" width="15" height="15">
                <path
                    d="M711.095467 468.096c-84.821333-142.250667-169.728-284.416-254.634667-426.666667A84.821333 84.821333 0 0 0 339.895467 12.16a85.546667 85.546667 0 0 0-29.098667 117.077333c76.117333 127.573333 152.32 255.146667 228.522667 382.72L310.7968 894.762667a85.589333 85.589333 0 0 0 29.098667 117.077333c40.192 24.234667 92.330667 11.093333 116.565333-29.269333 84.906667-142.250667 169.813333-284.416 254.634667-426.666667 18.986667-31.744 18.986667-56.064 0-87.808z"
                    p-id="1374" fill="#ffffff"></path>
              </svg>
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
                  :src="item.img_src"
                  :fit="'cover'"
                  style="height: 100%">

              </el-image>
            </el-carousel-item>
          </el-carousel>
        </el-col>
        <el-col class="add_under_carousel" :span="24">
          <el-row :gutter="20">
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
                    <el-col :span="24">
                      {{item.title}}
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="20">
              <el-row>
                <el-col :span="8">
                  周边游
                </el-col>
                <el-col :span="8">
                  周边游
                </el-col>
                <el-col :span="8">
                  周边游
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-col>

        <el-col class="trip_link" :span="12">
          长途游
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="3" style="height: 1px"></el-col>
  </el-row>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      carouselmap: [
        {
          img_src: 'http://localhost:81/img/png/1.png',
          link: ''
        },
        {
          img_src: 'http://localhost:81/img/png/2.png',
          link: ''
        },
      ],
      classfications: [
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
          title: '1',
          img_src:'http://localhost:81/img/png/seckill.png',
        },
        {
          title: '1',
          img_src:'',
        },
        {
          title: '1',
          img_src:'',
        },
        {
          title: '1',
          img_src:'',
        },
        {
          title: '1',
          img_src:'',
        },
        {
          title: '1',
          img_src:'',
        },
      ]
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
