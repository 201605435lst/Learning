/* 创建组件构造器对象 */
let cpn = Vue.extend({
  template: `
    <div>
       <h2>我是标签</h2>
 </div>`,
});

/* 组件注册 */
Vue.component("cpn", cpn);

new Vue({
  el: "#app",
  data: {
    message: "你好",
  },
});
