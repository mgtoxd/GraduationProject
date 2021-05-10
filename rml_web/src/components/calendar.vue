<template>
  <el-row class="border-2 border-gray-200">
    <el-col :span="24">
      <el-row class="month_row h-14">
        <el-col @click.native="chooseMonth(index)" :class="activeMonth===index?'bg-red-500':''" v-for="(item,index) in calender.month" class="grid place-items-center" :span="5">
          <span  class="font-bold">{{ item.date }}</span>
        </el-col>

      </el-row>
      <el-row class="h-14">
        <el-col :span="2-7" class="mt-col-24-7 text-center">周一</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周二</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周三</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周四</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周五</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周六</el-col>
        <el-col :span="2-7" class="mt-col-24-7 text-center">周日</el-col>
      </el-row>
      <el-row>
        <el-col @click.native="chooseDate(index)" :class="item.date?'hover:bg-blue-300 cursor-pointer':'' , index===activeDate?'bg-blue-500 ':''" :span="2-7" class="mt-col-24-7 text-center h-20 " v-for="(item,index) in calender.day">
          <p class="text-sm" v-text="item.festival?item.festival:' '"></p>
          <span class="text-base font-bold">{{item.dateInMon}}</span>
          <p class="text-sm" :class="item.special?'text-red-500':'text-black'">{{item.price}}</p>
        </el-col>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
import {mapMutations} from "vuex";

export default {
  computed:{

  },
  created() {
    // for (var i = 1;i<30;i++){
    //   this.calender.day.push({
    //     date: i+'',
    //     price: 345,
    //     festival: '清明',
    //     special: false
    //   })
    // }

  },
  name: "calendar",
  data() {
    return {
      commodId:'',
      activeDate: '',
      activeMonth:0,
      calender: {
        month:[
          {
            val:'2021-05',
            date:'2021年5月',
          },
          {
            val:'2021-06',
            date:'2021年6月',
          },
          {
            val:'2021-07',
            date:'2021年7月',
          }
        ],
        day:[{
          date: '',
          price: '',
          festival:'',
          special:false,
        },
          {
            date: '',
            price: '',
            festival:'',
            special:false,
          },
          {
            date: '',
            price: '',
            festival:'',
            special:false,
          },]
      }
    }

  },
  methods:{
    ...mapMutations(['edit_choose_day','edit_choose_month']),
    chooseDate(index){
      if (this.calender.day[index].dateInMon){
        this.activeDate=index;
        this.edit_choose_day(this.calender.day[index])
        this.edit_choose_month
      }

    },
    chooseMonth(index){
      this.activeMonth = index;
      this.edit_choose_month(this.calender.month[index].date)
      this.getData(this.commodId)
    },
    getData(commodId){
      this.commodId = commodId
      this.$http.get("/api/commod/Calendar/listCalenderByCommodIdAndYearMon",{params:{commodId:commodId,YearMon:this.calender.month[this.activeMonth].val}}).then(res=>{
        var data = res.data
        if (data.code===200){
          this.calender.day = data.data
        }
      })
    }
  }
}
</script>

<style scoped>
.month_row >>> .el-col {
  margin-left: auto;
  margin-right: auto;
}

.mt-col-24-7 {
  width: 14%;
}
</style>