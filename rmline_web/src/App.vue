<template>
  <div>
    <Bar_top v-if="showTopBar" :class="TopBarClass"
             style="animation-duration: 0.5s;position: fixed;top: 0;left: 0;width: 100%"></Bar_top>
    <div style="height: 3000px">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Bar_top from "@/components/Bar_top";
import {mapMutations} from "vuex";

export default {
  mounted() {
    window.addEventListener("scroll", this.getScroll)
  },
  destroyed() {
    window.removeEventListener("scroll", this.getScroll)
  },
  methods: {
    ...mapMutations(['hide_rm_menu']),
    getScroll() {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
      this.TopBarClass = ''
      if (scrollTop > 0) {
        this.TopBarClass = 'animated fadeInDown'
        this.showTopBar = true;
      } else if (scrollTop === 0) {
        this.TopBarClass = 'animated fadeOutUp'
        setTimeout(function () {
          this.showTopBar = false;
        }, 500)
      }
    }
  },
  data() {
    return {
      showTopBar: false,
      TopBarClass: ''
    }
  },

  components: {Bar_top}
};
</script>

<style>
@import "font/font.css";
@import "http://localhost:81/css/public.css";


body {
  margin: 0;
  padding: 0;
}
</style>