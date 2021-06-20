

## 1. 组件化开发

### 1.1 组件化基本使用

①.js文件

```
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

```

### 1.2 html文件

```
<div id='app'>
    <h2>{{message}}</h2>
    <cpn/>
 </div>
<script src='../js/vue.js'></script>
<script src="./01_组件的基本使用.js"></script>
```

### 1.3 全局组件

```
/* 组件注册 */
Vue.component("cpn", cpn);
```

### 1.4 局部组件注册

```
const cpn2=Vue.extend({
    template:`
    <div>
        <div>我是父组件</div>
        <h2>哈哈哈</h2>
        /*父组件中使用子组件*/
        <cpn1/>
    </div>
    `,
    components:{
        cpn1
    }
})
```

### 1.5 父子组件

```\
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
        /*父组件中使用子组件*/
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
```

### 1.6 局部组件注册的语法糖

```
Vue为了简化这个过程，提供了注册的语法糖。
主要是省去了调用Vue.extend()的步骤，而是可以直接使用一个对象来代替
```

```
/* 创建组件构造器对象 */
new Vue({
  el: "#app",
  data: {
    message: "组件消息",
  },
  /*局部巨剑注册的语法糖 */
  components: {
    cpn: {
      template: `
        <div>
           <h2>我是组件</h2>
     </div>`,
    },
  },
});
```

### 1.7 全局组件注册的语法糖

```
Vue.component("cpn", {
      template: `
        <div>
           <h2>我是组件</h2>
     </div>`,
    });
```

### 1.8 组件模板分离的写法

```
刚才，我们通过语法糖简化了Vue组件的注册过程，另外还有一个地方的写法比较麻烦，就是template模块写法。

如果我们能将其中的HTML分离出来写，然后挂载到对应的组件上，必然结构会变得非常清晰。

Vue提供了两种方案来定义HTML模块内容：

使用<script>标签

使用<template>标签
```

#### 1.8.1 使用script标签

```
<script type="text/x-template" id="cpn">
    <div>
        <h2>我是组件cpn模板分离</h2>
  </div>
</script>
<script src="../../js/vue.js"></script>
```

```
<script>
  // 注册一个全局组件
  Vue.component('cpn',{
      template:'#cpn'
  })
  new Vue({
    el: "#app",
    data: {
      message: "这是一个组件cpn模板分离",
    },
  });
</script>
```

#### 1.8.2 使用template标签

```
<template id="cpn">
    <div>
        <h2>我是组件cpn模板分离第二种写法</h2>
  </div>
</template>
```

```
<script src="../../js/vue.js"></script>
<script>
  // 注册一个全局组件
  Vue.component('cpn',{
      template:'#cpn'
  })
  new Vue({
    el: "#app",
    data: {
      message: "这是一个组件cpn模板分离2",
    },
  });
</script>
```

### 1.9 组件访问vue实例数据（data）

```
组件是一个单独功能模块的封装：
这个模块有属于自己的HTML模板，也应该有属性自己的数据data。
```



<img src="H:\Learning\Vue\01.vue_basic\img\图片1.png" alt="100 100" style="zoom:80%;float:left" />

```
我们发现不能访问，而且即使可以访问，如果将所有的数据都放在Vue实例中，Vue实例就会变的非常臃肿。

结论：Vue组件应该有自己保存数据的地方
```

```
组件自己的数据存放在哪里呢?

组件对象也有一个data属性(也可以有methods等属性，下面我们有用到)

只是这个data属性必须是一个函数

而且这个函数返回一个对象，对象内部保存着数据

```

**每一个组件实例都应该有属于自己的状态，都需要data来保存**

```
  <body>
    <div id="div">
      <h2>{{message}}</h2>
      <cpn/>
    </div>
    <template id="cpn">
        <div >
            <h2>{{title}}</h2>
            当前计数为：{{counter}}<br>
            <button @click="increment">+</button>
            <button @click="decrement">-</button>
        </div>
    </template>
    <script src="../../js/vue.js"></script>
    <script>
        Vue.component('cpn',{
            template:'#cpn',
            data(){
                return {
                    counter:0,
                    title:'计数器'
                }
            },
            methods:{
                increment(){
                    this.counter++;
                },
                decrement(){
                    this.counter--; 
                }
            }
        })
      new Vue({
        el: "div",
        data: {
          message: "这是vue实例中的属性",
        },
      });
    </script>
  </body>
```

### 1.10 父子组件的通信

#### 1.10.1 父传子（props）

```
 <body>
    <div id="app">
      <h2>{{message}}</h2>
      <cpn :ctitle="title"/>
    </div>
    <template id="cpn">
        <h2>{{ctitle}}</h2>
    </template>
    <script src="../../js/vue.js"></script>
    <script>
        let cpn={
        template:'#cpn',
        props:{
            ctitle:{type:String,default:null}
        }
        }
      new Vue({
        el: "#app",
        data: {
          title: "父组件的标题",
          message:"我是父组件"
        },
        components:{
            cpn
        }
      });
    </script>
  </body>
```

#### 1.10.2 props数据验证

<img src="H:\Learning\Vue\01.vue_basic\img\图片2.png" alt="lef" style="zoom:80%;float:left" />

**注意：传递值的时候，如果参数中有大写字母，需要写成-分割**

```
<cpn :c-title="title"/>

props:{
		cTitle:{type:String,default:null}
}
```

#### 1.10.3 子传父

**事件不能写成驼峰标识**

```
<body>
    <div id="app">
      <h2>{{message}}</h2>
      <cpn @info-message="btnClick"></cpn>
    </div>
    <template id="cpn">
        <div>
            <button v-for="item in categories" @click="btnClick(item)">{{item.name}}</button>
        </div>
    </template>
    <script src="../../js/vue.js"></script>
    <script>
        const cpn={
            template:'#cpn',
            data(){
                return{
                    categories:[
                        {id:'aaa',name:'热门推荐'},
                        {id:'bbb',name:'手机数码'},
                        {id:'ccc',name:'家用加电'},
                        {id:'ddd',name:'电脑办公'}
                    ]
                }
            },
            methods:{
                btnClick(item){
                    this.$emit("info-message",item)
                }
            }
        }
      new Vue({
        el: "#app",
        data: {
          message: "这是一个列表",
        },
        components:{
            cpn
        },
        methods:{
                btnClick(item){
                    console.log(item);
                }
            }
      });
    </script>
  </body>
```

### 1.11 v-model与v-bind

**理解：v-model是对值的绑定**

```
<input v-model="message">
```

**相当于**

**理解：v-bind是对属性的绑定**

```
<input :value="message" @input="通过事件改变值"
```

## 2.插槽（slot）

### 2.1 插槽的基本使用

```
<body>
    <div id="app">
      <cpn><button>我是父组件</button> </cpn>
      <cpn></cpn>
    </div>
    <template id="cpn">
     <div>
        <div>我是cpn组件</div>
        <!-- 默认的一个span标签 -->
        <slot><span>我是默认的span标签</span></slot>
     </div>
    </template>
    <script src="../js/vue.js"></script>
    <script>
        const cpn={
            template:'#cpn',
        }
      new Vue({
        el: "#app",
        data: {
          message: "这是一个列表",
        },
        components:{
            cpn
        }
      });
    </script>
  </body>
```

**效果图**

<img src="H:\Learning\Vue\01.vue_basic\img\Snipaste_2021-06-05_22-31-14.png" alt="he" style="zoom:80%;float:left" />

### 2.2具名插槽的使用

**一个不带 `name` 的 `<slot>` 出口会带有隐含的名字“default”。**

**注意 **`v-slot` 只能添加在 `<template>` 上** (只有[一种例外情况](https://cn.vuejs.org/v2/guide/components-slots.html#独占默认插槽的缩写语法))，这一点和已经废弃的 [`slot` attribute](https://cn.vuejs.org/v2/guide/components-slots.html#废弃了的语法) 不同。

```
<body>
    <div id="app">
        <hr>
        <cpn></cpn>
        <hr>
      <cpn>
       <template v-slot:center>
        <input />
       </template>
      </cpn>
    </div>
    <template id="cpn">
     <div>
        <div>我是cpn组件</div>
        <!-- 默认的一个span标签 -->
        <slot  name="left"><button>左边</button></slot>
        <slot  name="center"><button>中间</button></slot>
        <slot  name="right"><button>右边</button></slot>
     </div>
    </template>
    <script src="../js/vue.js"></script>
    <script>
        const cpn={
            template:'#cpn',
        }
      new Vue({
        el: "#app",
        data: {
          message: "这是一个列表",
        },
        components:{
            cpn
        }
      });
    </script>
  </body>
```

**效果**

<img src="H:\Learning\Vue\01.vue_basic\img\插槽.png" style="zoom:85%;float:left" />

### 2.3作用域插槽的使用（已废弃）

**父组件替换插槽的标签，但是内容由子组件来提供。**

```
在父组件使用我们的子组件时，从子组件中拿到数据：

我们通过<template slot-scope="slotProps">获取到slotProps属性

在通过slotProps.data就可以获取到刚才我们传入的data了

```

**slot-scope="slotProps"中的名字是随意的**

```
 <body>
    <div id="app">
      <cpn></cpn>
      <hr>
      <cpn>
          <template slot-scope="slot">
              <ul v-for="(item,index) in slot.datas">
                  <li>{{index}}-{{item}}</li>
              </ul>
          </template>
      </cpn>
    </div>
    <template id="cpn">
      <div>
        <slot :datas="infos">
            <ul>
              <li v-for="item in infos">{{item}}</li>
            </ul></slot >
      </div>
    </template>
    <script src="../js/vue.js"></script>
    <script>
      new Vue({
        el: "#app",
        data: {
          message: "这是一个列表",
        },
        components: {
          cpn: {
            template: "#cpn",
            data() {
              return {
                infos: ["java", "vue", "C#", "C++"],
              };
            },
          },
        },
      });
    </script>
  </body>
```

**效果**

<img src="H:\Learning\Vue\01.vue_basic\img\Snipaste_2021-06-05_23-25-09.png" style="zoom:80%;float:left" />

### 2.4 作用域插槽的使用（新）

```
  <body>
    <div id="app">
      <cpn></cpn>
      <hr>
      <cpn>
          <template v-slot:default="slopProps">
              <ul v-for="(item,index) in slopProps.datas">
                  <li>{{index}}=={{item}}</li>
              </ul>
          </template>
      </cpn>
    </div>
    <template id="cpn">
      <div>
        <slot :datas="infos">
            <ul>
              <li v-for="item in infos">{{item}}</li>
            </ul></slot >
      </div>
    </template>
    <script src="../js/vue.js"></script>
    <script>
      new Vue({
        el: "#app",
        data: {
          message: "这是一个列表",
        },
        components: {
          cpn: {
            template: "#cpn",
            data() {
              return {
                infos: ["java", "vue", "C#", "C++",'react'],
              };
            },
          },
        },
      });
    </script>
  </body>
```

#### 2.4.1独占默认插槽的缩写语法

在上述情况下，当被提供的内容*只有*默认插槽时，组件的标签才可以被当作插槽的模板来使用。这样我们就可以把 `v-slot` 直接用在组件上：

```
<current-user v-slot:default="slotProps">
  {{ slotProps.user.firstName }}
</current-user>
```

这种写法还可以更简单。就像假定未指明的内容对应默认插槽一样，不带参数的 `v-slot` 被假定对应默认插槽：

```
<current-user v-slot="slotProps">
  {{ slotProps.user.firstName }}
</current-user>
```

注意默认插槽的缩写语法**不能**和具名插槽混用，因为它会导致作用域不明确：

```
<!-- 无效，会导致警告 -->
<current-user v-slot="slotProps">
  {{ slotProps.user.firstName }}
  <template v-slot:other="otherSlotProps">
    slotProps is NOT available here
  </template>
</current-user>
```

只要出现多个插槽，请始终为*所有的*插槽使用完整的基于 `<template>` 的语法：

```
<current-user>
  <template v-slot:default="slotProps">
    {{ slotProps.user.firstName }}
  </template>

  <template v-slot:other="otherSlotProps">
    ...
  </template>
</current-user>
```

#### 2.4.2具名插槽的缩写

跟 `v-on` 和 `v-bind` 一样，`v-slot` 也有缩写，即把参数之前的所有内容 (`v-slot:`) 替换为字符 `#`。例如 `v-slot:header` 可以被重写为 `#header`：

```
<base-layout>
  <template #header>
    <h1>Here might be a page title</h1>
  </template>

  <p>A paragraph for the main content.</p>
  <p>And another one.</p>

  <template #footer>
    <p>Here's some contact info</p>
  </template>
</base-layout>
```

然而，和其它指令一样，该缩写只在其有参数的时候才可用。这意味着以下语法是无效的：

```
<!-- 这样会触发一个警告 -->
<current-user #="{ user }">
  {{ user.firstName }}
</current-user>
```

如果你希望使用缩写的话，你必须始终以明确插槽名取而代之：

```
<current-user #default="{ user }">
  {{ user.firstName }}
</current-user>
```

## 3.webpack

```
webpack ./src/main.js -o ./dist/bundle.js
```

## 4. vue-cli2



### 4.1 runtime-compile和runtime-only的区别

#### 4.1.1runtime-compile

```
template(模板)==》ast(抽象语法树)=》render（函数）=》vdom(虚拟dom)=>真实dom
```

```
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})
```

#### 4.1.2runtime-only

```
render（函数）=》vdom(虚拟dom)=>真实dom
```

**①.性能更高**

**②.代码量少**

```
.vue中的template的模板是由vue-template-compiler解析成render函数的
```

```
new Vue({
  el: '#app',
  render: h => h(App)
})
```

```
  /* 对象字面量中定义函数 */
  const obj={
    bbb:function(){

    },
    //等价于
    bbb(){

    }
  }
```

```
new Vue({
  el: '#app',
  render () {
    return (<div>
      <App/>
    </div>
    )
  }
})
```

## 5 vue-cli3

### 5.1 箭头函数

```
  /* 对象字面量中定义函数 */
  const obj={
    bbb:function(){

    },
    //等价于
    bbb(){

    }
  }
```

```
箭头函数的this是如何查找的呢？

向外层作用域一层一层查找this，直到有this的定义
```

## 6.vue-router

- ### 路由对象属性

  - **$route.path**
  
    - 类型: `string`
  
      字符串，对应当前路由的路径，总是解析为绝对路径，如 `"/foo/bar"`。
  
  - **$route.params**
  
    - 类型: `Object`
  
      一个 key/value 对象，包含了动态片段和全匹配片段，如果没有路由参数，就是一个空对象。
  
  - **$route.query**
  
    - 类型: `Object`
  
      一个 key/value 对象，表示 URL 查询参数。例如，对于路径 `/foo?user=1`，则有 `$route.query.user == 1`，如果没有查询参数，则是个空对象。
  
  - **$route.hash**
  
    - 类型: `string`
  
      当前路由的 hash 值 (带 `#`) ，如果没有 hash 值，则为空字符串。
  
  - **$route.fullPath**
  
    - 类型: `string`
  
      完成解析后的 URL，包含查询参数和 hash 的完整路径。
  
  - **$route.matched**
  
    - 类型: `Array<RouteRecord>`
  
    一个数组，包含当前路由的所有嵌套路径片段的**路由记录** 。路由记录就是 `routes` 配置数组中的对象副本 (还有在 `children` 数组)。
  
    ```js
    const router = new VueRouter({
      routes: [
        // 下面的对象就是路由记录
        {
          path: '/foo',
          component: Foo,
          children: [
            // 这也是个路由记录
            { path: 'bar', component: Bar }
          ]
        }
      ]
    })
    ```
  
    当 URL 为 `/foo/bar`，`$route.matched` 将会是一个包含从上到下的所有对象 (副本)。
  
  - **$route.name**
  
    当前路由的名称，如果有的话。(查看[命名路由](https://router.vuejs.org/zh/guide/essentials/named-routes.html))
  
  - **$route.redirectedFrom**
  
    如果存在重定向，即为重定向来源的路由的名字。(参阅[重定向和别名](https://router.vuejs.org/zh/guide/essentials/redirect-and-alias.html))
  
  
  
  ### 注入的属性
  
  通过在 Vue 根实例的 `router` 配置传入 router 实例，下面这些属性成员会被注入到每个子组件。
  
  - **this.$router**
  
    router 实例。
  
  - **this.$route**
  
    当前激活的[路由信息对象](https://router.vuejs.org/zh/api/#路由对象)。这个属性是只读的，里面的属性是 immutable (不可变) 的，不过你可以 watch (监测变化) 它。

### 6.1VueRouter的基本使用

```
/* 配置路由相关信息 */
import  VueRouter from "vue-router";
import  Vue from 'vue'

import About from '../components/About.vue'
import Home from '../components/Home.vue'

/* 通过vue.use(插件) ,安装插件 */
Vue.use(VueRouter)

/* 创建VueRouter对象 */
const routes=[
      {
        path:'/home',
        component:Home,
      },
      {
        path:'/about',
        component:About,
      }
]
var router=new VueRouter({
  routes
})
export default router
```

```
<template>
  <div>
  <router-link to="/home">Home</router-link>  
  <router-link to="/about">About</router-link>   

    <router-view></router-view>
  </div>
</template>
```



### 6.2 默认首页路径—重定向（redirect）

```
/* 创建VueRouter对象 */
const routes = [
  {
    path:"",
    redirect: '/home'
  },
  {
    path: "/home",
    component: Home
  },
  {
    path: "/about",
    component: About
  }
];
```

### 6.3  router-link属性

####  6.3.1 html5的history模式 —mode

- 类型: `string`

- 默认值: `"hash" (浏览器环境) | "abstract" (Node.js 环境)`

- 可选值: `"hash" | "history" | "abstract"`

  配置路由模式:

  - `hash`: 使用 URL hash 值来作路由。支持所有浏览器，包括不支持 HTML5 History Api 的浏览器。
  - `history`: 依赖 HTML5 History API 和服务器配置。查看 [HTML5 History 模式](https://router.vuejs.org/zh/guide/essentials/history-mode.html)。
  - `abstract`: 支持所有 JavaScript 运行环境，如 Node.js 服务器端。**如果发现没有浏览器的 API，路由会自动强制进入这个模式。**

```
var router = new VueRouter({
  mode:'history',
  routes
});
```

#### 6.3.2 active-class

```
var router = new VueRouter({
  mode:'history',
  routes,
  linkActiveClass:'active'
});
```

```
active-class
类型: string

默认值: "router-link-active"

设置链接激活时使用的 CSS 类名。默认值可以通过路由的构造选项 linkActiveClass 来全局配置。
```

#### 6.3.3 tag

```
类型: string

默认值: "a"

有时候想要 <router-link> 渲染成某种标签，例如 <li>。 于是我们使用 tag prop 类指定何种标签，同样它还是会监听点击，触发导航。
```

#### 6.3.4 replace

```
类型: boolean

默认值: false

设置 replace 属性的话，当点击时，会调用 router.replace() 而不是 router.push()，于是导航后不会留下 history 记录。
```

```
  <router-link to="/home" replace tag="button">Home</router-link>  
  <router-link to="/about" replace tag="button">About</router-link>   
```

### 6.4 通过代码跳转路由

```
<button @click="homeClick">home</button>
<button @click="aboutClick">About</button>
```

```
methods: {
    homeClick() {
      // this.$router.push("/home");
      this.$router.replace("/home");
    },
    aboutClick() {
      // this.$router.push("/about");
      this.$router.replace("/about");
    }
}
```

### 6.5动态路由

```
 <router-link :to="'/user/'+name" replace tag="button">User</router-link>   
```

```
  {
    path: "/user/:userName",
    component: User
  }
```

```
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
```

### 6.6 路由的懒加载

```
const About =()=> import("../components/About.vue");
const Home =()=> import("../components/Home.vue");
const User =()=> import("../components/User.vue");
```

### 6.7 嵌套路由

**要注意，以 `/` 开头的嵌套路径会被当作根路径。 这让你充分的使用嵌套组件而无须设置嵌套的路径。**

```
{
  path: "/home",
  component: Home,
  children: [
    {
      path: "",
      redirect: "home-message"
    },
    {
      path: "home-message",
      component: HomeMessage
    },
    {
      path: "home-info",
      component: HomeInfo
    }
  ]
},
```

```
<template>
  <div>
    <div>我是home组件</div>
    {{message}}
    <hr>
    
    <router-link to="/home/home-message" tag="button" replace>消息</router-link>
    
    <router-link to="/home/home-info" tag="button" replace>信息</router-link>
    
    <router-view></router-view>
  </div>
</template>
```

### 6.8 参数的传递

#### 6.8.1 params的类型

- 配置路由格式:/router/:id
- 传递的方式：在path后面跟上对应的值
- 传递后形成的路径：/router/123

##### 6.8.1.1 使用router-link

```
<router-link :to="'/user/'+name" replace tag="button">User</router-link> 
```

```
{
  path: "/user/:userName",
  component: User
}
```

##### 6.8.1.2通过点击跳转

```
userClick(){
    this.$router.replace('/user/'+this.name)
 }
```

#### 6.8.2 query的类型

- 配置路由的格式：/router，也就是普通配置
- 传递的方式：对象中使用query的key作为传递方式
- 传递后形成的路径：/router?id=123

**绑定属性的时候，使用v-bind才能把:to="{}"中的{}当做一个对象**

##### 6.8.2.1 使用router-link

```
 <router-link 
  :to="{
    path:'/profile',
    query:{
      id:'001',
      name:'张三',
      age:'22',
    }
  }" 
  replace
  tag="button">Profile</router-link>   
```

```
    <h2>个人信息页面</h2>
    <h4>{{this.$route.query.id}}</h4>
    <h4>{{this.$route.query.name}}</h4>
    <h4>{{this.$route.query.age}}</h4>
```

##### 6.8.2.2通过点击跳转

```
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
```

### 6.9 全局导航守卫--全局前置守卫

> **meta--元数据(描述数据的数据）**

```
  {
    meta: { title: "About" },
    path: "/about",
    component: About
  },
```

```
var router = new VueRouter({
  mode: "history",
  routes,
  linkActiveClass: "active"
});
router.beforeEach((to, from, next) => {
  /* 从from跳转到to组件 */
  document.title = to.matched[0].meta.title;
  next();
});
```

#### 6.9.1 当meta是字符串的时候

<img src="H:\Learning\Vue\01.vue_basic\img\meta.png" alt=" " style="zoom:90%;float:left" />

#### 6.9.2当meta是对象的时候

<img src="H:\Learning\Vue\01.vue_basic\img\meta_w.png" style="zoom:90%;float:left" />

### 6.10 keep-live的使用

```
<keep-alive>
  <router-view></router-view>
</keep-alive>
```

>  临时存储当前子路由下的路径

```
data() {
    return {
      message: "Hello",
      path: "/home/message"
    };
  },
```

>结合beforeRouteLeave使用

```
  activated() {
    this.$router.replace(this.path);
  },
  beforeRouteLeave(to, from, next) {
    this.path = this.$route.path;
    next()
  }
```

>子路由不需要重定向路由

```
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
```

<img src="H:\Learning\Vue\01.vue_basic\img\route-alivev.png" style="zoom:90%;float:left" />