<template>
  <div>
    <h3>当前count为: {{count}}</h3>
    <button @click="sub">-1</button>
    <button @click="subN(3)">-N</button>
  </div>

</template>

<script>
import{mapState,mapMutations,mapActions,mapGetters} from 'vuex'
export default {
  name: "Subtraction",
  data(){
    return{

    }
  },
  computed:{
    ...mapState(['count']),
    // ...mapState(['sub','subN'])
  },
  methods:{
    ...mapMutations(['sub',"subN"]),
    sN(){
      this.subN(3);
    }
  }
}
</script>

<style scoped>


</style>
