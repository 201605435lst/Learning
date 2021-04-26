- [目录](#目录)
  - [1.什么是react](#1什么是react)
  - [2.React的Hello Word](#2react的hello-word)
  - [3.Js的Hello React](#3js的hello-react)
  - [4.真实DOM与虚拟DOM](#4真实dom与虚拟dom)
  - [5.React中使用JSX](#5react中使用jsx)
  - [6.模块与组件、模块化与组件化的区别](#6模块与组件模块化与组件化的区别)
  - [7.函数式组件](#7.函数式组件)
  - [8.类的基本知识](#8.类的基本知识)

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

总结：
1. 类中的构造器不是必须写的，要对实例进行一些初始化的操作，如添加指定属性时才写
2. 如果A类继承了B类，且A类写了构造器，那么A类构造器中的super是必须要写的
3. 类中所定义的方法都是放在了类的原型对象上，供实例去使用

```
<script>
      //创建一个person类
      class Person {
          //person类的构造器
        constructor(name, age) {
            /* 构造方法中的this是谁？ -----类的实例对象 */
          this.name = name;
          this.age = age;
        }
        speak() {
            /*
             speak方法放在了哪里？----类的原型对象上，供实例使用
             通过person实例调用speak时，speak的this就是person实例
            */
          console.log(`我叫${this.name},年龄${this.age}岁`);
        }
      }
      class Student extends Person{
        constructor(name,age,grade){
          super(name, age)
          this.grade=grade;
        }
        speak(){
          console.log(`我叫${this.name},年龄${this.age}岁,我读的是${this.grade}`);
        }
        study(){
          /*  
              speak方法放在了哪里？----类的原型对象上，供实例使用
              通过student实例调用study时，study中的this就是Student实例
          */
          console.log("我很努力的学习");
        }
      }
      /* 总结：
            1.类中的构造器不是必须写的，要对实例进行一些初始化的操作，如添加指定属性时才写
            2.如果A类继承了B类，且A类写了构造器，那么A类构造器中的super是必须要写的
            3.类中所定义的方法都是放在了类的原型对象上，供实例去使用
      
      */
      const  student=new Student("小张",21,"高一")
      console.log(student);
      student.speak()
      student.study()
    </script>
```

## 9.类式组件

```
<script type="text/babel">
    /* 创建类式组件 */
         class MyComponent extends React.Component{
             //render是放在哪里的？------Mycomponent的原型对象上，供实例使用
             //render中的this是谁？------Mycomponent的示列对象<=>Mycomponent组件实例对象
             render(){
                return (<h2>我是用类定义的组件【适用于复杂组件的使用】</h2>)
             }
         } 
     ReactDOM.render(<MyComponent/>,document.getElementById("test"))
     /* 执行了 ReactDOM.render(<MyComponent/>...之后发生了什么？
            1.React解析组件标签，找到了MyComponent组件
            2.发现组件是用类定义的，随后new出该类的实例，并且通过该实例调用到原型上的render方
            3.将render返回的DOM转化为真实的DOM，随后呈现在页面中
      */
    </script>
```

## 10.组件实例三大属性_state

1. state是组件对象最重要的属性, 值是对象(可以包含多个key-value的组合)

2. 组件被称为"状态机", 通过更新组件的state来更新对应的页面显示(重新渲染组件)

```
强烈注意
     1.组件中render方法中的this为组件实例对象
     2.组件自定义的方法中this为undefined，如何解决？
         a)强制绑定this: 通过函数对象的bind()
         b)箭头函数
     3.状态数据，不能直接修改或更新
```

```
<script type="text/babel">
      class Weather extends React.Component {
        constructor(props) {
          /* 此处this指向weather的实例对象 */
          super(props);
          this.state = { isHot: true };
          console.log(this);
          //解决changeWeather中this指向问题
          this.weatherEvent=this.changeWeather.bind(this)
        }
        render() {
          /* 此处this指向weather的实例对象 */
          return (
            <h1 onClick={this.weatherEvent}>
              今天天气很{this.state.isHot ? "炎热" : "凉爽"}
            </h1>
          );
        }
        /* 此处changeWeather不是通过Weather调用的，需考虑this指向 */
        changeWeather(){
          console.log("来了");
          /* 
            changeWeather放在那里？------Weather的原型对象上，供实例使用
            由于changeWeather是作为onClick的回调，所以不是通过实例调用的，是直接调用
            类中的方法默认开启了严格模式，所以changeWeather中的this为undefind，需要考虑this指向
          */
          console.log(this);
        }
      }
      ReactDOM.render(<Weather />, document.getElementById("test"));

    </script>
```

## 11.类中的方法this指向

```
<script>
      class Person{
          constructor(name,age){
              this.name=name
              this.age=age
          }
          speak(){
               /*  
              speak方法放在了哪里？----类的原型对象上，供实例使用
              通过Person实例调用study时，study中的this就是Person实例
                */
              console.log(this);
          }
      }
        const p1=new Person("小明",25)
        p1.speak()//通过实例调用speak方法
        const t1=p1.speak
        t1()//   输出undefind
    </script>
```

## 12.setState的使用

​      **特别提醒，状态必须通过setState来更改状态，且更新是一种合并，不是替换**

```
 <script type="text/babel">
      class Weather extends React.Component {
        /* 构造器调用1次 */
        constructor(props) {
          /* 此处this指向weather的实例对象 */
          super(props);
          this.state = { isHot: true };
          console.log(this);
          //解决changeWeather中this指向问题
          this.weatherEvent=this.changeWeather.bind(this)
        }
        /* render调用i+n次   n是状态更新的次数 */
        render() {
          /* 此处this指向weather的实例对象 */
          return (
            <h1 onClick={this.weatherEvent}>
              今天天气很{this.state.isHot ? "炎热" : "凉爽"}
            </h1>
          );
        }
        /* 此处changeWeather不是通过Weather调用的，需考虑this指向 */
        changeWeather(){
          /* 
            changeWeather放在那里？------Weather的原型对象上，供实例使用
            由于changeWeather是作为onClick的回调，所以不是通过实例调用的，是直接调用
            类中的方法默认开启了严格模式，所以changeWeather中的this为undefind，需要考虑this指向
          */
           const isHot=this.state.isHot;
           /* 特别提醒，状态必须通过setState来更改状态，且更新是一种合并，不是替换 */
           this.setState({isHot:!isHot})
          /* 严重注意：状态不可直接更改，下面这行就是直接更改 */
          // this.state.isHot=!isHot   /* 错误写法 */
        }
      }
      ReactDOM.render(<Weather />, document.getElementById("test"));

    </script>
```

## 13.setState的使用简写

自定义方法
          ①. 要用赋值语句的形式+箭头函数
          ②. 将changeWeather放在了实例自身上，而不是原型上 

​         ③. 箭头函数的this指向外层函数

```
<script type="text/babel">
      class Weather extends React.Component {
        /* 初始化状态 */
          state = { isHot: true };
        render() {
          return (
            <h1 onClick={this.changeWeather}>
              今天天气很{this.state.isHot ? "炎热" : "凉爽"}
            </h1>
          );
        }
        /*
        自定义方法：
          ①.要用赋值语句的形式+箭头函数
          ②.将changeWeather放在了实例自身上，而不是原型上 
        */
        changeWeather=()=>{
          console.log(this);
           const isHot=this.state.isHot;
           this.setState({isHot:!isHot})
        }
      }
      ReactDOM.render(<Weather />, document.getElementById("test"));
    </script>
```

## 14.展开运算符（reduce的使用）

​		1. 展开运算符不能展开对象

```
        /* 计算和 */
        function sum(...numbers){
            return numbers.reduce((preventValue,currentValue)=>{
               return  preventValue+currentValue
            })
        }
        console.log(sum(1,2,3,4,5));

        let Person={name:'小张',age:'20'}
        let Person2={...Person}
        console.log(Person);//相当于给Person2复制了一个Person
        console.log(...Person);//报错，展开语法不能展开对象
```

## 15.组件实例三大属性_props

```
<script type="text/babel">
      /* 创建一个组件 */
      class Person extends React.Component {
        render() {
         //this.props.age=age+1;//此代码会报错，因为props是只读的
         
          const { name, age, sex } = this.props;
          return (
            <ul>
              <li>{name}</li>
              <li>{sex}</li>
              <li>{age+1}</li>
            </ul>
          );
        }
      }
      Person.propTypes={
          name:PropTypes.string.isRequired,//限制name必传，且为字符串
          age:PropTypes.number,//限制age为数字
          sex:PropTypes.string,//限制性别为字符串
          speak:PropTypes.func,//限制speak为函数
      }
      Person.defaultProps={
          age:30,
          sex:'男'
      }

      const p = { name: "小张", age: 26, sex: "男" };
      ReactDOM.render(
        <Person name="小王"  />,
        document.getElementById("test")
      );
      ReactDOM.render(
        <Person name="小明" age={15} sex="男" />,
        document.getElementById("test1")
      );
      ReactDOM.render(<Person {...p} />, document.getElementById("test2"));

      function speak(){
          console.log("我说话了");
      }
    </script>
```

## 16.组件实例三大属性_props简写

```
  static propTypes = {
          name: PropTypes.string.isRequired, //限制name必传，且为字符串
          age: PropTypes.number, //限制age为数字
          sex: PropTypes.string, //限制性别为字符串
          speak: PropTypes.func, //限制speak为函数
        };
        /* 指定标签默认属性值 */
        /* 若不加static,这个属性加在了类的实例上，没有加给类的本身 */
        static defaultProps = {
          age: 30,
          sex: "男",
        };
```

```
 <script type="text/babel">
      /* 创建一个组件 */
      class Person extends React.Component {
       static propTypes = {
          name: PropTypes.string.isRequired, //限制name必传，且为字符串
          age: PropTypes.number, //限制age为数字
          sex: PropTypes.string, //限制性别为字符串
          speak: PropTypes.func, //限制speak为函数
        };
        /* 指定标签默认属性值 */
        /* 若不加static,这个属性加在了类的实例上，没有加给类的本身 */
        static defaultProps = {
          age: 30,
          sex: "男",
        };
        /* 初始化状态 */
        state={}
        
        render() {
          console.log(this);
          const { name, age, sex } = this.props;
          //this.props.age=age+1;//此代码会报错，因为props是只读的
          return (
            <ul>
              <li>{name}</li>
              <li>{sex}</li>
              <li>{age + 1}</li>
            </ul>
          );
        }
      }
      /* 对标签属性进行类型必要性的限制 */

      const p = { name: "小张", age: 26, sex: "男" };
      /* 渲染组件到页面 */
      ReactDOM.render(<Person name="小王" />, document.getElementById("test"));
      ReactDOM.render(
        <Person name="小明" age={15} sex="男" />,
        document.getElementById("test1")
      );
      /*{}在此处是分隔符，...p在此处能够展开对象是因为react.development+babel就可以展开对象了*/
      ReactDOM.render(<Person {...p} />, document.getElementById("test2"));

      function speak() {
        console.log("我说话了");
      }
    </script>
```

## 17.构造器使用(constractor)

 **构造器是否接收props，是否传递给super,取决于：是否希望在构造器中通过this访问props **

```
constructor(props){
          super(props)
          console.log(this.props);//输出Person
        } 
```

```
 constructor(){
          console.log(this.props);//报错
          }
```

```
 constructor() {
          super();
          console.log(this.props); //undefind
          }
```

## 18.函数式组件使用props

```
<script type="text/babel">
      /* 创建一个组件 */
      function Person(props){
          const {name,sex,age}=props
        return (
            <ul>
              <li>{name}</li>
              <li>{sex}</li>
              <li>{age + 1}</li>
            </ul>
          );
      }
      Person.propTypes={
        name: PropTypes.string.isRequired, //限制name必传，且为字符串
        age: PropTypes.number, //限制age为数字
        sex: PropTypes.string, //限制性别为字符串
      }
      Person.defaultProps={
        sex:'男',
        age:18,
      }
      ReactDOM.render(<Person name="小王" />, document.getElementById("test"));
    </script>
```

## 19.解构赋值

**解构赋值**语法是一种 Javascript 表达式。通过**解构赋值,** 可以将属性/值从对象/数组中取出,赋值给其他变量。

```
var a, b, rest;
[a, b] = [10, 20];
console.log(a); // 10
console.log(b); // 20

[a, b, ...rest] = [10, 20, 30, 40, 50];
console.log(a); // 10
console.log(b); // 20
console.log(rest); // [30, 40, 50]

({ a, b } = { a: 10, b: 20 });
console.log(a); // 10
console.log(b); // 20


// Stage 4（已完成）提案中的特性
({a, b, ...rest} = {a: 10, b: 20, c: 30, d: 40});
console.log(a); // 10
console.log(b); // 20
console.log(rest); // {c: 30, d: 40}
```

## 20.组件实例三大属性_refs(字符串形式)

```
 <script type="text/babel">
      /* 创建一个组件MyComponent */
      class MyComponent extends React.Component {
        showData1 = () => {
          console.log(this.refs);
          const input1 = this.refs.input1;
          alert(input1.value);
        };
        showData2 = () => {
          /* 解构赋值 */
          const { input2 } = this.refs;
          alert(input2.value);
        };
        render() {
          return (
            <div>
              <input ref="input1" placeholder="点击按钮提示输入的内容" />
              &nbsp;
              <button onClick={this.showData1}>点我提示左侧输入框的值</button>
              &nbsp;
              <input
                onBlur={this.showData2}
                ref="input2"
                placeholder="失去焦点提示输入的内容"
                ref="input2"
              />
              &nbsp;
            </div>
          );
        }
      }
      ReactDOM.render(<MyComponent />, document.getElementById("test"));
    </script>
```

## 21.组件实例三大属性_refs(回调形式)

```
ref={(c)=>this.input2=c}
```

```
<script type="text/babel">
      /* 创建一个类组件 */
      class MyComponent extends React.Component {
        showData1=()=>{
            console.log(this);
                const {input1}=this
                alert(input1.value)
            }
            showData2=()=>{
                const input2=this.input2
                alert(input2.value)
            }
        render() {
          return (
            <div>
              <input ref={(currentNode)=>this.input1=currentNode} placeholder="请点击按钮提示左侧输入的内容" />
              &nbsp;
              <button onClick={this.showData1}>点击显示左侧的内容</button>&nbsp;
              <input onBlur={this.showData2} ref={(c)=>this.input2=c} placeholder="失去焦点显示输入的内容" />
            </div>
          );
        }
      }
      ReactDOM.render(<MyComponent/>,document.getElementById('test'))
    </script>
```

## 22.回调ref中调用次数的问题(内联函数调用次数多)

```
 <script type="text/babel">
      class MyComponent extends React.Component {
        state = { isHot: false };
        changeWeather = () => {
          const { isHot } = this.state;
          this.setState({ isHot: !isHot });
        };
        showInfo = () => {
          const { input1 } = this;
          console.log(input1.value);
        };
        saveInput=(c)=>{
            this.input1=c
        }
        render() {
          const { isHot } = this.state;
          return (
            <div>
              <h2>今天天气很{isHot ? "炎热" : "寒冷"}</h2>
              {/*<input ref={(c) => (this.input1 = c)} placeholder="请输入" />*/}
              <input ref={this.saveInput} placeholder="请输入" />
              <br />
              <button onClick={this.showInfo}>点击给出提示</button>
              <button onClick={this.changeWeather}>改天天气状况</button>
            </div>
          );
        }
      }
      ReactDOM.render(<MyComponent />, document.getElementById("test"));
    </script>
```

## 23.createRef的使用

```
 <script type="text/babel">
        class Mycomponent extends React.Component{
            myRef=React.createRef()
            myRef1=React.createRef()
            showData=()=>{
                console.log(this.myRef);
                alert(this.myRef.current.value)
            }
            showData1=()=>{
                alert(this.myRef1.current.value)
            }
            render(){
                return (
                    <div>
                        <input ref={this.myRef} placeholder="请输入"/><br/>
                        <button onClick={this.showData}>点击显示输入的</button>
                        <input ref={this.myRef1} onBlur={this.showData1} placeholder="失去焦点显示输入的内容"/>
                    </div>
                )
            }
        }
        ReactDOM.render(<Mycomponent/>,document.getElementById('test'))
    </script>
```

## 24.react中的事件处理

   (1). 通过onXxx属性指定事件处理函数（注意大小写）

​      a.React使用的是自定义（合成）事件，而不是使用的原生的DOM事件------------为了更好的兼容性

​      b.React中的事件是通过事件委托方式处理的（委托给组件最外层的元素）-------为了更高效

（2）通过event.target得到发生事件的DOM元素对象------------不要过度使用ref

```
<script type="text/babel">
      class Mycomponent extends React.Component {
        /* 
         (1).通过onXxx属性指定事件处理函数（注意大小写）
            a.React使用的是自定义（合成）事件，而不是使用的原生的DOM事件------------为了更好的兼容性
            b.React中的事件是通过事件委托方式处理的（委托给组件最外层的元素）-------为了更高效
        （2）通过event.target得到发生事件的DOM元素对象------------不要过度使用ref
         
         */
        myRef = React.createRef();
        showData1 = () => {
          alert(this.myRef.current.value);
        };
        showData2 = (e) => {
          alert(e.target.value);
        };
        render() {
          return (
            <div>
              <input ref={this.myRef} placeholder="请输入" type="input" />
              <br />
              <button onClick={this.showData1}>点击显示输入框的内容</button>
              <input onBlur={this.showData2} placeholder="请输入" />
            </div>
          );
        }
      }
      ReactDOM.render(<Mycomponent />, document.getElementById("test"));
    </script>
```

## 25.非受控组件

```
preventDefault() 方法阻止元素发生默认的行为（例如，当点击提交按钮时阻止对表单的提交）
```

```
 <script type="text/babel">
    class Login extends React.Component{
        handleLogin=(event)=>{
            event.preventDefault()//阻止表单提交
            const {input1,input2}=this
            alert(`这个人的用户名是${input1.value},密码是${input2.value}`)
        }
        render(){
            return (
                <form action="https://wwww.baidu.com" onSubmit={this.handleLogin}>
                    <input ref={(c)=>this.input1=c} name="username"/><br/>
                    <input ref={(c)=>this.input2=c} name="password"/><br/>
                    <button >登录</button>
                </form>
            )
        }
    }
    ReactDOM.render(<Login />,document.getElementById('test'))
    </script>
```

## 26.受控组件

```
<script type="text/babel">
      class Login extends React.Component {
        state = { password: "", username: "" };
        savePassword = (e) => {
          this.setState({ password: e.target.value });
        };
        saveUsername = (e) => {
          this.setState({ username: e.target.value });
        };
        handleLogin = (event) => {
          event.preventDefault();
          const { username, password } = this.state;
          alert(`这个人的用户名是${username},密码是${password}`);
        };
        render() {
          return (
            <form action="https://wwww.baidu.com" onSubmit={this.handleLogin}>
              <input onChange={this.saveUsername} name="username" />
              <br />
              <input onChange={this.savePassword} name="password" />
              <br />
              <button>登录</button>
            </form>
          );
        }
      }
      ReactDOM.render(<Login />, document.getElementById("test"));
    </script>
```

## 27.对象相关的知识

```
 <script>
      let a = "name";
      let obj = {};
      obj[a] = 555;
      console.log(obj); //{name:555}
    </script>
```

## 28.高阶函数_函数柯里化

```
      高阶函数：如果一个函数符合下面两个规范中的任何一个，那该函数就是高阶函数。
          1.若A函数接收的参数是一个函数，那么该函数就是高阶函数
          2.若A函数，调用的返回值依然是一个函数，那么A就可以称为高阶函数
          常见的高阶函数有：Promise、setTimeOut、arr.map()等等
      函数的柯里化：通过函数调用继续返回函数的方式，实现多次接受参数最后统一处理的函数编码形式
       function((a)=>{
              return (b)=>{
                 return (c)=>{
                    return a+b+c
                  }
                }
              })
```

```
<script type="text/babel">
      class Login extends React.Component {
        state = { password: "", username: "" };
        saveData = (valueType) => {
          return (e) => {
            this.setState({ [valueType]: e.target.value });
          };
        };
        handleLogin = (event) => {
          event.preventDefault();
          const { username, password } = this.state;
          alert(`这个人的用户名是${username},密码是${password}`);
        };
        render() {
          return (
            <form action="https://wwww.baidu.com" onSubmit={this.handleLogin}>
              <input onChange={this.saveData("username")} name="username" />
              <br />
              <input onChange={this.saveData("password")} name="password" />
              <br />
              <button>登录</button>
            </form>
          );
        }
      }
      ReactDOM.render(<Login />, document.getElementById("test"));
    </script>
```

## 29.不使用函数柯里化

```
<script type="text/babel">
      class Login extends React.Component {
        state = {
          username: null,
          password: null,
        };
        handleLogin = (e) => {
          e.preventDefault();
          const { username, password } = this.state;
          alert(`当前用户的账号是${username},密码是${password}`);
        };
        saveData = (type, e) => {
          this.setState({ [type]: e.target.value });
        };
        render() {
          return (
            <form action="https://wwww.baidu.com" onSubmit={this.handleLogin}>
              <input
                onChange={(e) => {
                  this.saveData("username", e);
                }}
                placeholder="请输入"
                name="username"
              />
              <br />
              <input
                onChange={(e) => {
                  this.saveData("password", e);
                }}
                placeholder="请输入"
                name="password"
              />
              <br />
              <button>提交</button>
            </form>
          );
        }
      }
      ReactDOM.render(<Login />, document.getElementById("test"));
    </script>
```

## 30.引出生命周期函数

```
 <script type="text/babel">
    /* 创建组件    =====生命周期函数     =====》钩子函数 */
      class Life extends React.Component {
        state = { opacity: 1 };
        /* 卸载组件 */
        destoryComponent = () => {
          ReactDOM.unmountComponentAtNode(document.getElementById("test"));
        };
        //#region
        action = () => {
          setInterval(() => {
            let { opacity } = this.state;
            if (opacity <= 0) opacity = 1;
            opacity -= 0.1;
            this.setState({ opacity });
          }, 200);
        };
        //#endregion
        /* 组件挂载完毕 */
        componentDidMount() {
          this.setIntervalNode = setInterval(() => {
            let { opacity } = this.state;
            if (opacity <= 0) opacity = 1;
            opacity -= 0.1;
            this.setState({ opacity });
          }, 200);
        }
        /* 组件将要卸载 */
        componentWillUnmount() {
          clearInterval(this.setIntervalNode);
        }
        /* 初始化渲染、状态更新之后 */
        render() {
          console.log("render");
          return (
            <div>
              <h2 style={{ opacity: this.state.opacity }}>颜色开始变化</h2>
              <button onClick={this.destoryComponent}>Dom销毁</button>
              <button onClick={this.action}>Dom开始变化</button>
            </div>
          );
        }
      }
      /* 渲染组件 */
      ReactDOM.render(<Life />, document.getElementById("test"));
    </script>
```

