<template>
<el-row class="h-full ">
  <el-col class="bg-gray-200" :span="3">
    <el-row >
      <el-col v-for="(item,index) in routeInfo.children" class="h-10 flex grid hover:bg-gray-300 cursor-pointer" @click.native="routeTo(item.name)" :span="24">
        <p class="text-xl self-center justify-self-center font-bold font-mono">{{item.title}}</p>
      </el-col>
    </el-row>
  </el-col>
  <el-col :span="21">
    <router-view/>
  </el-col>
</el-row>
</template>

<script>
export default {
  name: "twice",
  created() {

  },
  mounted() {
    console.log(this.$route.name)
    this.$router.options.routes.forEach((item,index)=>{
      if (item.name === this.$route.name){
        this.routeInfo = item
        console.log(item)
      }
    })
  },
  data(){
    return{
      routeInfo:{}
    }
  },
  watch:{
    "$route":{
      handler(route){
        this.getList(route)
      }
    }
  },
  methods:{
    getList(route){
      this.$router.options.routes.forEach((item,index)=>{
        if (item.name === route.name){
          this.routeInfo = item
          console.log(item)
        }
      })
    },
    routeTo(name){
      this.$router.push({name:name})
    }
  }
}
</script>

<style scoped>

</style>