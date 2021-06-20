/* 创建组件构造器对象 */
new Vue({
  el: "#app",
  data: {
    message: "组件消息",
  },
  /* 组件注册 */
  components: {
    cpn: {
      template: `
        <div>
           <h2>我是组件</h2>
     </div>`,
    },
  },
});
