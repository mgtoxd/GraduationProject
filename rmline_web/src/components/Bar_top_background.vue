<template>
  <div>
    <el-row id="top_bar" :gutter="30">
      <el-col :span="8">
        <el-row>
          <el-col :span="13">
            <div style="height: 1px"></div>
          </el-col>
          <el-col :span="6" style="cursor: pointer" :class="search_class" @mouseenter.native="search_over" @mouseleave.native="search_leave">
            <el-row>
              <el-col :span="8">
                <div class="search"></div>
              </el-col>
              <el-col :span="16">
                <p class="search_p">Search</p>
              </el-col>
            </el-row>
          </el-col>

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
          <el-col :span="5" style="cursor: pointer" :class="menu_class" @mouseenter.native="menu_over()" @mouseleave.native="menu_leave()">
            <el-row>
              <el-col :span="10"><p class="search_p">MENU</p></el-col>
              <el-col :span="7">
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
name: "Bar_top_background"
}
</script>

<style scoped>

</style>