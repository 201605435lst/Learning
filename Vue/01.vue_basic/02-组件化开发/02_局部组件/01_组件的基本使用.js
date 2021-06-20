/* 创建组件构造器对象 */
let cpn = Vue.extend({
  template: `
    <div>
       <h2>我是局部组件</h2>
 </div>`,
});

new Vue({
  el: "#app",
  data: {
    message: "局部组件",
  },
  /* 组件注册 */
  components: {
    cpn: cpn,
  },
});
