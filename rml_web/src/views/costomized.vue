<template>
  <el-row style="margin-top: 50px">
    <el-col :span="18">
      <iframe v-show="showMap" class="w-full" style="height: 900px" src="/static/costomized.html"></iframe>
      <iframe ref="MapRoute" v-show="!showMap" class="w-full" style="height: 900px" src="/static/costomizRoute.html"></iframe>
    </el-col>
    <el-col :span="1"/>
    <el-col :span="5">
      <el-row>
        <el-col style="height: 800px" :span="24">
          <el-timeline>
            <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :icon="activity.icon"
                :type="activity.type"
                :color="activity.color"
                :size="activity.size"
                :timestamp="activity.timestamp">
              {{activity.content}}
            </el-timeline-item>
          </el-timeline>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-button type="primary" @click="changeMap">{{ BtnText }}</el-button>
        </el-col>
      </el-row>
    </el-col>

  </el-row>
</template>

<script>


export default {
  created() {

  },
  methods:{
    changeMap(){
      if (this.showMap){
        this.BtnText='转到地图'
        var list = []
        for (var i = 0;i<this.locationList.length;i++){
          list.push({
            lng:this.locationList[i].lng,
            lat:this.locationList[i].lat,
          })
        }
        this.$refs.MapRoute.contentWindow.postMessage({
          data:{
            list:list
          }
        }, '*');
      }else {
        this.BtnText='生成路线规划'
      }
      this.showMap = !this.showMap
    },
    add_step(event){
      var data = event.data.data;
      console.log(data)
      var activity = {
        id:data.id,
        content: data.address,
        // timestamp: this.dateNow.format("YYYY-MM-DD HH:mm")+'至'+this.dateNow.add(data.needMinutes,'m').format("YYYY-MM-DD HH:mm"),
        size: 'large',
      }
      this.activities.push(activity)
      this.locationList.push({
        lng:data.location[0],
        lat:data.location[1]
      })
    }
  },
  mounted() {
    window.addEventListener('message', this.add_step);

  },
  data(){
    return{
      locationList:[],
      showMap: true,
      dateNow: this.$timeFormat('20210501T0801'),
      activities: [],
      BtnText:'生成路线规划'
    }
  }

}
</script>

<style scoped>

</style>
