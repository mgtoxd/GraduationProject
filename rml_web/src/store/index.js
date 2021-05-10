import Vuex from 'vuex'


export default new Vuex.Store({
  state: {
    which_menu_item_show:1,
    if_menu_show: false,
    menu_cover_link:'',
    token:'',
    if_log: false,
    choose_day:{},
    choose_month:''
  },
  mutations: {
    edit_if_log(state,params){
      state.if_log=params
    },
    edit_choose_day(state,day){
      state.choose_day=day
    },
    edit_choose_month(state,month){
      state.choose_month=month
    },
    change_if_log(state){
      state.if_menu_show = !state.if_menu_show;
    },
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
