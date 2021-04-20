- [目录](#目录)
  
  - [1.什么是react](#1什么是react)
  
  - [2.React的Hello Word](#2react的hello-word)
  
  - [3.Js的Hello React](#3js的hello-react)
  
  - [4.真实DOM与虚拟DOM](#4真实dom与虚拟dom)
  
  - [5.React中使用JSX](#5react中使用jsx)
  
  - [6.模块与组件、模块化与组件化的区别](#6模块与组件模块化与组件化的区别)
  
  - [7.函数式组件](#7.函数式组件)
  
    

## 1.什么是react

1. **React**是用于构建用户界面的JAvaScript库（是一个将数据渲染为HTML视图的开源JavaScript库）

```
1.发送请求获取数据
2.处理数据（过滤、整理格式等）
3.操作DOM呈现页面
```

2. 谁开发的？

   ​	由Facebook开发，且开源；

3. 为什么要学？

   ```
   原生JavaScript操作Dom繁琐、效率低；
   使用JavaScript直接操作DOM，浏览器会进行大量的重绘重排；
   原生JavaScript没有组件化编码方案，代码复用率低 
   ```

4. React的特点  

   ```
   采用组件化模式、声明式编码，提高开发效率及组件复用率；
   在React Native中可以使用React语法进行移动端开发；
   使用虚拟Dom+优秀的Diffing算法，尽量减少与真实的DoM交互；
   ```

5. 学习React之前你要掌握的JavaScript基础知识

   ```
   判断this的指向
   calss类
   Es6语法规范
   npm包管理器
   原型、原型链
   数组常用语法
   模块化
   ```

## 2.React的Hello Word

```
<body>
    <!-- 贮备好一个“容器” -->
    <div id="app"></div>
    <!-- 引入react核心库 -->
    <script src="../js/react.development.js"></script>
    <!-- 引入react-dom，引入支持react操作DOM -->
    <script src="../js/react-dom.development.js"></script>
    <!-- 引入Babel，用于将jsx转化为js -->
    <script src="../js/babel.min.js"></script>
<script type="text/babel">//此处一定要写babel
/* 1、创建虚拟DOM */
    const  VDOM=<h1>Hello,React</h1>
    /* 渲染虚拟DOM到页面 */
    ReactDOM.render(VDOM,document.getElementById("app"));
</script>
</body>
```

## 3.Js的Hello React

```
<body>
    <!-- 贮备好一个“容器” -->
    <div id="app"></div>
    <!-- 引入react核心库 -->
    <script src="../js/react.development.js"></script>
    <!-- 引入react-dom，引入支持react操作DOM -->
    <script src="../js/react-dom.development.js"></script>

    <script >
      /* 1、创建虚拟DOM */
      const VDOM = React.createElement("h1",{title:"div1"},React.createElement('span',{},"Hello React"))
      /* 渲染虚拟DOM到页面 */
      ReactDOM.render(VDOM, document.getElementById("app"));
    </script>
  </body>
```

## 4.真实DOM与虚拟DOM

  **关于虚拟DOM**:

      1. 本质是Object类型的对象(一般对象)
         2. 虚拟DOM比较“轻”，真实DOM比较“重”，因为虚拟DOM是React内部在使用，无需真实DOM上那么多的属性
         3. 虚拟DOM最终会被React转化为真实DOM呈现在网页上

```
<body>
    <!-- 贮备好一个“容器” -->
    <div id="app"></div>
    <!-- 引入react核心库 -->
    <script src="../js/react.development.js"></script>
    <!-- 引入react-dom，引入支持react操作DOM -->
    <script src="../js/react-dom.development.js"></script>
    <!-- 引入Babel，用于将jsx转化为js -->
    <script src="../js/babel.min.js"></script>

    <script type="text/babel">
      //此处一定要写babel
      /* 1、创建虚拟DOM */
      const VDOM = (
        <h1>
          <span>Hello,React</span>
        </h1>
      );
      const TDOM = document.getElementById("app");
      /* 渲染虚拟DOM到页面 */
      ReactDOM.render(VDOM, document.getElementById("app"));
      console.log("虚拟DOM", VDOM);
      console.log("真实DOM", TDOM);
      console.log(typeof VDOM); //返回Object
      console.log(VDOM instanceof Object); //返回true
    </script>
  </body>
```

## 5.React中使用JSX

​     React 使用 JSX 来替代常规的 JavaScript

​     JSX 是一个看起来很像 XML 的 JavaScript 语法扩展

​     我们不需要一定使用 JSX，但它有以下优点：

```
JSX 执行更快，因为它在编译为 JavaScript 代码后进行了优化。
它是类型安全的，在编译过程中就能发现错误。
使用 JSX 编写模板更加简单快速。
```

```
JSX语法规则：
        1.定义虚拟DOM时，不要写引号；
        2.标签中混入js表达式时需要使用{}
        3.样式的类名指定不要用class,要用className
        4.内联样式，要用style={{key:value}}的形式去写
        5.只有一个根标签；
        6.标签必须闭合
        7.标签首字母：
          （1)若小写字母开头，则将标签改为html对应的同名元素，若html中无对应的同名元素，则报错；
          （2）若大写字母开头，React就会渲染对应的组件，若组件没有定义，则报错；
```

```
 一定注意区分：【js语句（代码）】和【Js表达式】
                1.Js表达式：一个表达式都会产生一个值，可以放在任何一个需要值的地方；
                    下面这些都是表达式：
                        （1)、a
                         (2)、a+b
                         (3)、demo(1)
                         (4)、arr.map()
                         (5)、function test(){}
                2.js语句：
                    下面这些都是语句（代码）
                        （1).if(){}
                        （2).for(){}
                        （3).switch(){case:xxxx}
```

```
<script type="text/babel">
      const myId = "teSt";
      const content = "Hello ReAct";
      //此处一定要写babel
      /* 1、创建虚拟DOM */
      const VDOM = (
       <div>
        <h2 id={myId.toLowerCase()} className="title">
          <span style={{color:"white",fontSize:"29px"}}>{content.toLowerCase()}</span>
        </h2>
        <input type="text"/>
        </div>
      );
      /* 渲染虚拟DOM到页面 */
      ReactDOM.render(VDOM, document.getElementById("test"));
    </script>
```

```
const data = ["Angular", "React", "Vue"];
      /* 1.创建虚拟DOM */
      const VDOM = (
        <div>
          <h2>前端JS框架列表</h2>
          <ul>
            {data.map((item,index) => 
              <li key={index}>{item}</li>
            )}
          </ul>
        </div>
      );
 ReactDOM.render(VDOM,document.getElementById("test"))
```

## 6.模块与组件、模块化与组件化的区别

```
模块：向外提供特定功能的js程序，一般就是一个js文件
作用：复用js，简化js的编写，提高js运行效率
```

```
组件：用来实现局部功能效果的代码和资源的集合（html/css/js/image）
作用：复用编码，简化项目编码，提高运行效率
```

```
模块化：当应用的js都以模块来编写的，这个应用就是一个模块化的应用
```

```
组件化：当应用是以多组件的方式实现，这个应用就是一个组件化的应用
```

## 7.函数式组件

```
<script type="text/babel">
     function MyComponent(){
         console.log(this);//  此处的this是undefined，因为babel编译后开启了严格模式
         return (<h2>我是用函数定义的组件【适用于简单组件的使用】</h2>)
     }
     ReactDOM.render(<MyComponent/>,document.getElementById("test"))
     /* 执行了 ReactDOM.render(<MyComponent/>...之后发生了什么？
            1.React解析组件标签，找到了MyComponent组件
            2.发现组件是使用函数定义的，随后调用该函数，将返回的DOM转化为真实的DOM，随后呈现在页面中
      */
    </script>
```

## 8.类的基本知识

```

```



