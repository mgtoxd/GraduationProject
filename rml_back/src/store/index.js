import { createStore } from 'vuex'

export default createStore({
  state: {
    admin:{},
    log:false
  },
  mutations: {
    edit_admin(state,param){
      state.admin=param
    },
    edit_log(state,param){
      state.log=param
    },
  },
  actions: {
  },
  modules: {
  }
})
