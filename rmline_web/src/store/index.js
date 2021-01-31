import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count:1,
    if_rm_menu:false,
  },
  mutations: {
    show_rm_menu(state){
      state.if_rm_menu = true
    },
    hide_rm_menu(state){
      state.if_rm_menu = false
    },
    add(state){
      state.count++;
    },
    addN(state,step){
      state.count+=step;
    },
    sub(state){
      state.count--;
    },
    subN(state,step){
      state.count-=step;
    }
  },
  actions: {
    addAsync(context){
      setTimeout(()=>{
        context.commit("add")
      },1000)
    }
  },
  modules: {
  }
})
