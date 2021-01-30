<template>
  <div>
    <el-row id="top_bar" :gutter="30">
      <el-col :span="8">
        <el-row>
          <el-col :span="13">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="2">
            <div class="search"></div>
          </el-col>
          <el-col :span="4"><p class="search_p">Search</p></el-col>
          <el-col :span="5">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="10">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="4">
            <div class="logo"></div>
          </el-col>
          <el-col :span="8">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="7">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="5" :class="menu_class" @mouseenter.native="menu_over()" @mouseleave.native="menu_leave()">
            <el-row>
              <el-col :span="10"><p class="search_p">MENU</p></el-col>
              <el-col  :span="7">
                <div class="MENU">
                  <div></div>
                  <div></div>
                  <div></div>
                </div>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <div style="height: 1px"></div>
          </el-col>
        </el-row>

      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {

  name: "Bar_top",
  methods:{
    menu_over(){
      this.menu_class='animated rubberBand'
    },
    menu_leave(){
      this.menu_class=''
    },

  },
  data(){
    return{
      menu_class:''

    }
  }

}
</script>

<style scoped>


</style>