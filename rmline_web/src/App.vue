<template>
  <div>
    <h1 class="animated bounceInDown">hello world</h1>
    <my-add></my-add>


    <p>------------</p>


    <my-sub></my-sub>
  </div>

</template>

<script>
  import Addition from "@/components/Addition";
  import Subtraction from "@/components/Subtraction";
  export default {

    data(){
      return{

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