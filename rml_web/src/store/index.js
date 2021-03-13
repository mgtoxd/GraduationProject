import Vuex from 'vuex'


export default new Vuex.Store({
  state: {
    if_menu_show: false,
    menu_cover_link:''
  },
  mutations: {
    edit_if_menu_show(state){
      state.if_menu_show = !state.if_menu_show;
    },
    edit_menu_cover_link(state,link){
      state.menu_cover_link = link;
    },
  },
  actions: {
  },
  modules: {
  }
})
