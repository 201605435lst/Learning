<template>
  <div>
    <router-link to="/home" replace tag="button">Home</router-link>
    <router-link to="/about" replace tag="button">About</router-link>
    <router-link :to="'/user/' + name" replace tag="button">User</router-link>
    <router-link
      :to="{
        path: '/profile',
        query: {
          id: '001',
          name: '张三',
          age: '22'
        }
      }"
      replace
      tag="button"
      >Profile</router-link
    >
    <!-- 通过button按钮点击跳转实现 -->
    <!-- <button @click="homeClick">home</button>
    <button @click="aboutClick">About</button>
    <button @click="userClick">User</button>
    <button @click="profileClick">Profile</button> -->
  <keep-alive>
    <router-view></router-view>
  </keep-alive>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      name: "zhangsan"
    };
  },
  methods: {
    homeClick() {
      // this.$router.push("/home");
      this.$router.replace("/home");
    },
    aboutClick() {
      // this.$router.push("/about");
      this.$router.replace("/about");
    },
    userClick() {
      this.$router.replace("/user/" + this.name);
    },
    profileClick() {
      this.$router.replace({
        path: "/profile",
        query: {
          id: "001",
          name: "张三",
          age: "22"
        }
      });
    }
  }
};
</script>

<style>
.active {
  background-color: rgb(0, 255, 34);
  color: white;
}
</style>
