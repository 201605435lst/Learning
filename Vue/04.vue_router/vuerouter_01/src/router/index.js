/* 配置路由相关信息 */
import VueRouter from "vue-router";
import Vue from "vue";

const About = () => import("../components/About.vue");
const Home = () => import("../components/Home.vue");
const User = () => import("../components/User.vue");
const HomeMessage = () => import("../components/Home/HomeMessage.vue");
const HomeInfo = () => import("../components/Home/HomeInfo.vue");
const profile = () => import("../components/Profile.vue");
/* 通过vue.use(插件) ,安装插件 */
Vue.use(VueRouter);

/* 创建VueRouter对象 */
const routes = [
  {
    path: "",
    redirect: "/home"
  },
  {
    meta: { title: "Home" },
    path: "/home",
    component: Home,
    children: [
      {
        meta: { title: "Home消息" },
        path: "message",
        component: HomeMessage
      },
      {
        meta: { title: "Home信息" },
        path: "info",
        component: HomeInfo
      }
    ]
  },
  {
    meta: { title: "About" },
    path: "/about",
    component: About
  },
  {
    meta: { title: "UserName" },
    path: "/user/:userName",
    component: User
  },
  {
    meta: { title: "profile" },
    path: "/profile",
    component: profile
  }
];
var router = new VueRouter({
  mode: "history",
  routes,
  linkActiveClass: "active"
});
router.beforeEach((to, from, next) => {
  /* 从from跳转到to组件 */
  document.title = to.matched[0].meta.title;
  next();
  console.log(to);
});
export default router;
