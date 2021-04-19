<template>
  <el-row style="margin-top: 50px">
    <el-col :span="18">
      <iframe v-show="showMap" class="w-full" style="height: 900px" src="/static/costomized.html"></iframe>
      <iframe ref="MapRoute" v-show="!showMap" class="w-full" style="height: 900px" src="/static/costomizRoute.html"></iframe>
    </el-col>
    <el-col :span="1"/>
    <el-col v-loading="activity_load" :span="5">
      <el-row>
        <el-col style="height: 800px" :span="24">
          <el-timeline>
            <el-timeline-item @click.native="toDetailRoute(index)"
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
    toDetailRoute(index){
      if (index%2===0){
        return;
      }
      if (this.showMap){
        this.showMap = !this.showMap
      }else {
      }
      this.BtnText='转到地图'
      var list = []
      console.log(index)
      var loc_index = String(index/2).replace(/\.\d+/g, '');
      loc_index = Number(loc_index)
      list.push({
        lng:this.locationList[loc_index].lng,
        lat:this.locationList[loc_index].lat,
      })
      list.push({
        lng:this.locationList[loc_index+1].lng,
        lat:this.locationList[loc_index+1].lat,
      })
      // for (var i = 0;i<this.locationList.length;i++){
      //   list.push({
      //     lng:this.locationList[i].lng,
      //     lat:this.locationList[i].lat,
      //   })
      // }
      this.$refs.MapRoute.contentWindow.postMessage({
        data:{
          list:list
        }
      }, '*');
    },
    async add_step(event) {
      if (!event.data.data){
        return;
      }
      var data = event.data.data;
      if (this.activityExist(data.id)){
        this.$notify({
          title: '标题名称',
          message: '已经选择过这个景点了'
        });
        return;
      }

      console.log(data)
      if (this.activities.length > 0) {
        this.activity_load = true
        var last_loc = this.locationList[this.locationList.length-1]
        await this.$http.get("https://restapi.amap.com/v3/direction/driving?key=219eb3fbb8a5a40e8d74512c7458c0d4&origin="+last_loc.lng+","+last_loc.lat+"&destination="+data.location[0]+","+data.location[1]+"&originid=&destinationid=&extensions=all&strategy=0&waypoints=&avoidpolygons=&avoidroad=").then(
            res => {
              console.log(res.data)
              console.log(res.data.route.paths[0].duration)
              console.log(res.data.route.taxi_cost)
              this.activities.push({
                color: 'green',
                size: 'large',
                icon: 'el-icon-circle-check',
                content: '预计行程时间' + res.data.route.paths[0].duration + '打车预计花费' + res.data.route.taxi_cost + '元',
              })
              this.activity_load = false
            }
        )
      }
      var activity = {
        id: data.id,
        content: data.address,
        // timestamp: this.dateNow.format("YYYY-MM-DD HH:mm")+'至'+this.dateNow.add(data.needMinutes,'m').format("YYYY-MM-DD HH:mm"),
        size: 'large',
        icon:'el-icon-picture-outline-round',
        color: 'blue'
      }
      this.activities.push(activity)

      this.locationList.push({
        lng: data.location[0],
        lat: data.location[1]
      })
    },
    activityExist(id){
      for (var i=0;i<this.activities.length;i++){
        if (id===this.activities[i].id){
          return true;
        }
      }
      return false;
    },
  },

  mounted() {
    window.addEventListener('message', this.add_step);

  },
  data(){
    return{
      activity_load:false,
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

.el-timeline-item >>> .el-timeline-item__node--large{
 width: 30px;
  height: 30px;
}
.el-timeline-item >>> .el-timeline-item__icon{
  font-size: 25px;
}
.el-timeline-item >>> .el-timeline-item__wrapper{
  line-height: 35px;
}
</style>
