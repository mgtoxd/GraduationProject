import Vuex from 'vuex'


export default new Vuex.Store({
  state: {
    which_menu_item_show:1,
    if_menu_show: false,
    menu_cover_link:'',
  },
  mutations: {
    edit_if_menu_show(state){
      state.if_menu_show = !state.if_menu_show;
    },
    edit_menu_cover_link(state,link){
      state.menu_cover_link = link;
    },
    edit_which_menu_item_show(state,id){
      state.which_menu_item_show = id
    }
  },
  actions: {
  },
  modules: {
  }
})
