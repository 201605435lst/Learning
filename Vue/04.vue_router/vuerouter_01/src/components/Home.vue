<template>
  <div>
    <div>我是home组件</div>
    {{ message }}
    <hr />
    <router-link to="/home/message" tag="button" replace>消息</router-link>
    <router-link to="/home/info" tag="button" replace>信息</router-link>
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      message: "Hello",
      path: "/home/message"
    };
  },
  activated() {
    this.$router.replace(this.path);
  },
  beforeRouteLeave(to, from, next) {
    this.path = this.$route.path;
    next()
  }
};
</script>

<style></style>
