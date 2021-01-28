<template>
  <div>
    <h3>当前count为: {{ this.$store.state.count }}</h3>
    <button @click="btnHandler1">+1</button>
    <button @click="btnHandlern">+n</button>
    <button @click="btnHandler1As">+1 Async</button>
  </div>

</template>

<script>
export default {
  name: "Addition",
  data(){
    return{

    }
  },
  methods: {
    btnHandler1(){
      this.$store.commit("add")
    },
    btnHandlern(){
      this.$store.commit("addN",3)
    },
    btnHandler1As(){
      this.$store.dispatch("addAsync")
    }
  }
}
</script>

<style scoped>

</style>

