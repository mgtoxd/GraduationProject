<template>
  <div>
    <h1 class="animated bounceInDown">hello world</h1>
    <my-add></my-add>


    <p ref="p">------------</p>


    <my-sub></my-sub>
    <div :style="styleObj1" style="height: 2000px">

    </div>
    <h1 ref="p2" :class="classObj">hello world</h1>
  </div>


</template>

<script>
  import Addition from "@/components/Addition";
  import Subtraction from "@/components/Subtraction";
  export default {
    mounted() {
      window.addEventListener("scroll",this.getScroll)
    },
    destroyed() {
      window.removeEventListener("scroll",this.getScroll)
    },
    methods:{
      getScroll(){
        let scrollTop = window.pageYOffset|| document.documentElement.scrollTop || document.body.scrollTop;
        if (scrollTop>this.$refs.p.offsetHeight){
          this.styleObj1 = {'background-color':'green'}
        }
        if (scrollTop>this.$refs.p2.offsetTop-window.innerHeight	){
          this.classObj = 'animated bounceInDown'
        }
        console.log(this.$refs.p2.offsetTop-window.innerHeight	+" "+scrollTop)
      }
    },
    data(){
      return{
        styleObj1:{
          'background-color':'black',
        },
        classObj:'',
      };
    },
    components:{
      Subtraction,
      Addition,
      'my-add':Addition,
      'my-sub':Subtraction
    }
  };
</script>