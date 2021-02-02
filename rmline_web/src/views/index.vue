<template>
  <div>
    <bar_top id="bar_top"></bar_top>
    <div style="position: fixed;top: 0;left: 0;width: 100%;">
      <video ref="video" @click="video_click" style="position: fixed;top: 0;left: 0;width: 100%;object-fit: cover; z-index: -1"  :poster="video.poster_src" autoplay>
        <source :src="video.src" type="video/mp4">
      </video>
      <div style="position: fixed;bottom: 30px;right: 50px;background-color:white;  width: 300px;">
        dadadad
      </div>
    </div>
  </div>
</template>

<script>
import Bar_top from "@/components/Bar_top_index";

export default {
  mounted() {
    this.$refs.video.controls=false;
  },
  name: "index",
  components: {Bar_top},
  data() {
    return {
      video: {
        poster_src: 'http://localhost:81/DFS/ad.png',
        src: 'http://localhost:81/DFS/sanpiterberg.mp4'
      }
    }
  },
  methods:{
    video_click(){

      if (this.$refs.video.paused){
        this.$refs.video.play();
      }else {
        this.$refs.video.pause();
      }
    }
  }
}
</script>

<style scoped>
  @import "http://localhost:81/css/index.css";
</style>