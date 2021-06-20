
/* 子组件 */
const cpn1=Vue.extend({
    template:`
    <div>
        <div>我是子组件</div>
        <h2>哈哈哈</h2>
    </div>
    `,
})
/* 父组件 */
const cpn2=Vue.extend({
    template:`
    <div>
        <div>我是父组件</div>
        <h2>哈哈哈</h2>
        <cpn1/>
    </div>
    `,
    components:{
        cpn1
    }
})
new Vue({
    el:'#app',
    data: {
        message: "局部组件",
      },
    components:{
        cpn2
    }
})