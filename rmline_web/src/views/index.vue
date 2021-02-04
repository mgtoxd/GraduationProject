<template>
  <div id="index">
    <bar_top id="bar_top"></bar_top>
    <div style="position: fixed;top: 0;left: 0;width: 100%;">
      <video ref="video" @click="video_click" v-bind:style="{ height : tableHeight+'px' }" style="position: fixed;top: 0;left: 0;width: 100%;object-fit: cover; z-index: 0;"  :poster="video.poster_src" autoplay>
        <source :src="video.src" type="video/mp4">
      </video>
    </div>
<!--    进度条与控件-->
    <div class="progress_bar" >
      <el-row>
        <el-col :span="3"></el-col>
        <el-col :span="14"></el-col>
        <el-col :span="4">
          <el-row></el-row>
        </el-col>
        <el-col :span="3"></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import Bar_top from "@/components/Bar_top_index";

export default {
  created() {
    //监听浏览器高度
    this.getHeight()
    window.addEventListener("resize", this.resize_video);

  },
  mounted() {
    this.$refs.video.controls=false;
    this.$refs.video.addEventListener('timeupdate',this.get_video_progress)
  },
  destroyed() {
    window.removeEventListener("resize", this.resize_video);
  },
  name: "index",
  components: {Bar_top},
  data() {
    return {
      tableHeight: 1000,
      video: {
        poster_src: 'http://localhost:81/DFS/ad.png',
        src: 'http://localhost:81/DFS/sanpiterberg.mp4'
      }
    }
  },
  methods:{
    get_video_progress(){
      // console.log(this.$refs.video.currentTime);
    },
    //点击暂停与开始
    video_click(){

      if (this.$refs.video.paused){
        this.$refs.video.play();
      }else {
        this.$refs.video.pause();
      }
    },
    //改变video高度
    resize_video() {
      this.getHeight();
    },
    getHeight() {
      // 获取浏览器高度  768 1080一般笔记本浏览器高度
      // console.log(window.innerHeight)
      this.tableHeight = window.innerHeight
    },

  },
  computed:{

  }
}
</script>

<style scoped>
  @import "http://localhost:81/css/index.css";
</style>