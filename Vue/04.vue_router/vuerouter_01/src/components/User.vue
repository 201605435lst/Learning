<template>
  <div>
      <h2>我是用户组件</h2>
      <h2>当前的用户是{{name}}</h2>
  </div>
</template>

<script>
export default {
    name:'User',
    computed:{
        name(){
            return this.$route.params.userName;
        }
    },
}
</script>

<style>

</style>