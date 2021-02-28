import Vuex from 'vuex'


export default new Vuex.Store({
  state: {
    if_menu_show: false,
  },
  mutations: {
    edit_if_menu_show(state){
      state.if_menu_show = !state.if_menu_show;
    },
  },
  actions: {
  },
  modules: {
  }
})
