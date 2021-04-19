## 1、什么是react

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

## 3.真实DOM与虚拟DOM

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

## 4.React中使用JSX

​     React 使用 JSX 来替代常规的 JavaScript

​     JSX 是一个看起来很像 XML 的 JavaScript 语法扩展

​     我们不需要一定使用 JSX，但它有以下优点：

```
JSX 执行更快，因为它在编译为 JavaScript 代码后进行了优化。
它是类型安全的，在编译过程中就能发现错误。
使用 JSX 编写模板更加简单快速。
```



