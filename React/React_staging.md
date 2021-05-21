##  1.创建项目

```
react提供了一个用于创建react项目的脚手架库: create-react-app
项目的整体技术架构为:  react + webpack + es6 + eslint
使用脚手架开发的项目的特点: 模块化, 组件化, 工程化
```

## 2.创建项目并启动

```
全局安装：npm i -g create-react-app
第二步，切换到想创项目的目录，使用命令：create-react-app hello-react
```

## 3.todoList案例

**渲染数据、添加、修改状态属性**

app.jsx

```
export default class App extends Component {
  state = {
    todos: [
      { id: '001', name: "篮球", status: true },
      { id: '002', name: "足球", status: true },
      { id: '003', name: "羽毛球", status: true },
    ],
  };
  /* 添加 */
  addTodo=(todo)=>{
    const {todos}=this.state;
    const todoObj=[todo,...todos];
    this.setState({todos:todoObj})
  }
  /* 修改done值 */
  updateDone=(id,status)=>{
    const {todos}=this.state;
    todos.forEach(itemObj=>{
      if(itemObj.id===id){
        itemObj.status=status;
      }
    })
    this.setState({todos})
  }
  render() {
    const { todos } = this.state;
    return (
      <div className="todo-container">
        <div className="todo-wrap">  
          <Header addTodo={this.addTodo}/>
          <List  todos={todos} updateDone={this.updateDone} />
          <Footer />
        </div>
      </div>
    );
  }
}
```

header.jsx

```
export default class Header extends Component {
  handleKeyUp=(event)=>{
    const {target,keyCode}=event
    if(keyCode!==13) return
    if(target.value.trim()==='') {
      alert("输入的内容无效，不能为空");
      target.value='';
      return;
    }
    const objTodo={
      id:nanoid(),
      name:target.value,
      status:false,
    }
    this.props.addTodo(objTodo);
    target.value='';
  }
  render() {
    return (
      <div className="todo-header">
        <input onKeyUp={this.handleKeyUp} type="text" placeholder="请输入你的任务名称，按回车键确认" />
      </div>
    );
  }
}
```

list.jsx

```
export default class List extends Component {
  render() {
      const {todos,updateDone}=this.props
    return (
      <ul className="todo-main">
        {todos.map(item=>{
            return <Item key={item.id} updateDone={updateDone} {...item}/>
        })}
      </ul>
    );
  }
}

```

item.jsx

```
export default class Item extends Component {
  state = { mouse: false };
  /* 鼠标移入移出事件 */
  handleMouse = (flag) => {
    return () => {
      this.setState({ mouse: flag });
    };
  };
  handleChange=(id)=>{
    const {updateDone}=this.props;
    return (event)=>{
      updateDone(id,event.target.checked)
    }
  }
  render() {
    const { id,name, status } = this.props;
    const { mouse } = this.state;
    return (
      <li
        style={{ backgroundColor: mouse ? "#ddd" : "white" }}
        onMouseEnter={this.handleMouse(true)}
        onMouseLeave={this.handleMouse(false)}
      >
        <label>
          <input type="checkbox" defaultChecked={status} onChange={this.handleChange(id)}/>
          <span>{name}</span>
        </label>
        <button className="btn btn-danger" style={{ display:mouse?'block':'none'}}>
          删除
        </button>
      </li>
    );
  }
}
```

## 4.对接收的props的进行类型、必要性的限制

> **安装prop-types**

```
import PropTypes from "prop-types";

 /* 对接收的props的进行类型、必要性的限制 */
  static propTypes={
    todos:PropTypes.array.isRequired,
    updateDone:PropTypes.func.isRequired
  }
```



## 5.react脚手架配置代理总结



### 方法一

> 在package.json中追加如下配置

```json
"proxy":"http://localhost:5000"
```

> 说明：

1. 优点：配置简单，前端请求资源时可以不加任何前缀。
2. 缺点：不能配置多个代理。
3. 工作方式：上述方式配置代理，当请求了3000不存在的资源时，那么该请求会转发给5000 （优先匹配前端资源）

### 方法二

1. 第一步：创建代理配置文件

   ```
   在src下创建配置文件：src/setupProxy.js
   ```

2. 编写setupProxy.js配置具体代理规则：

   ```js
   const proxy = require('http-proxy-middleware')
   
   module.exports = function(app) {
     app.use(
       proxy('/api1', {  //api1是需要转发的请求(所有带有/api1前缀的请求都会转发给5000)
         target: 'http://localhost:5000', //配置转发目标地址(能返回数据的服务器地址)
         changeOrigin: true, //控制服务器接收到的请求头中host字段的值
         /*
         	changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:5000
         	changeOrigin设置为false时，服务器收到的请求头中的host为：localhost:3000
         	changeOrigin默认值为false，但我们一般将changeOrigin值设为true
         */
         pathRewrite: {'^/api1': ''} //去除请求前缀，保证交给后台服务器的是正常请求地址(必须配置)
       }),
       proxy('/api2', { 
         target: 'http://localhost:5001',
         changeOrigin: true,
         pathRewrite: {'^/api2': ''}
       })
     )
   }
   ```

> 说明：

1. 优点：可以配置多个代理，可以灵活的控制请求是否走代理。
2. 缺点：配置繁琐，前端请求资源时必须加前缀。

## 6.GitHub搜索案列

> **Index**

```
export default class index extends Component {
  /* 初始化状态 */
    state={
        users:[],
        isFirst:true,//是否为第一次打开页面
        isLoading:false,//是否处于加载中
        err:null,//请求请求错误相关的信息
    }
    updateAppState=(stateObj)=>{
        this.setState(stateObj)
    }
  
  render() {
    return (
      <div className="container">
        <Search updateAppState={this.updateAppState}/>
        <List {...this.state}/>
      </div>
    );
  }
}
```

> **search**

```
 export default class search extends Component {
    search=()=>{
        /* 发送请求通知页面更新状态 */
        this.props.updateAppState({
            isFirst:false,//是否为第一次打开页面
            isLoading:true,//是否处于加载中
        })  
        const {keyWordElement:{value:keyWord}}=this
        axios({
            url:'/api1/search/users',
            method:'get',
            params:{
                q:`${keyWord}`,
            }
        }).then(
            res=>{
                // const {updateAppState}=this.props
                    this.props.updateAppState({
                        isLoading:false,//是否处于加载中
                        users:res.data.items
                    })  
            },
            err=>{
                this.props.updateAppState({
                  isLoading:false,
                  err:err.message
                })  
            }
        )
    }
  render() {
    return (
        <section className="jumbotron">
        <h3 className="jumbotron-heading">搜索git用户</h3>
        <div>
          <input ref={(c)=>this.keyWordElement=c} type="text" placeholder="请输入关键字点击搜索" />
          &nbsp;<button onClick={this.search}>搜索</button>
        </div>
      </section>
    )

   
  }
}
```

> ****

> **List**

```
export default class List extends Component {
   
  render() {
    const { users,isFirst,isLoading,err} =this.props
    return (
      <div className="row">
        {
         isFirst?<h2>欢迎使用，请输入关键字，随后点击搜索</h2>:
         isLoading?<h2>Loading.....</h2>:
         err?<h2>{err}</h2>:
        users.map((userObj) => {
          return (
            <div className="card" key={userObj.id}>
            <a
              rel="noreferrer"
              href={userObj.html_url}
              target="_blank"
            >
              <img
                alt="head_portrait"
                src={userObj.avatar_url}
                style={{ width: "100px" }}
              />
            </a>
            <p className="card-text">{userObj.login}</p>
          </div>
          )
        })}
      </div>
    );
  }
}

```

## 7.GitHub搜索案例—(pubsub-js)

> **index**

```
export default class index extends Component {
  render() {
    return (
      <div className="container">
      
        <Search/>
        
        <List />
        
      </div>
    );
  }
}

```

> **Search**
>
>  ```
>  const {keyWordElement:{value:keyWord}}=this
>  ```

```
export default class search extends Component {
    search=()=>{
    
        /* 当输入的值发生变化的时候，需要进行消息订阅*/
        PubSub.publish('ListComponentState',{
          isFirst:false,//是否为第一次打开页面
          isLoading:true,//是否处于加载中
        })
        
        const {keyWordElement:{value:keyWord}}=this
        
        axios({
            url:'/api2/search/users',
            method:'get',
            params:{
                q:`${keyWord}`,
            }
        }).then(
            res=>{
            
              PubSub.publish('ListComponentState',{
                users:res.data.items,
                isLoading:false,//是否处于加载中
              })
              
            },
            err=>{
              PubSub.publish('ListComponentState',{
                isLoading:false,//是否处于加载中
                err:err.message,//请求请求错误相关的信息
              })
            }
        )
    }
  render() {
    return (
        <section className="jumbotron">
        <h3 className="jumbotron-heading">搜索git用户</h3>
        <div>
          <input ref={(c)=>this.keyWordElement=c} type="text" placeholder="请输入关键字点击搜索" />
          &nbsp;<button onClick={this.search}>搜索</button>
        </div>
      </section>
    )

   
  }
}

```

> **List**

```
export default class List extends Component {

  state = {
    users: [],
    isFirst: true, //是否为第一次打开页面
    isLoading: false, //是否处于加载中
    err: null, //请求请求错误相关的信息
  };
  
  /* 组件挂载完毕的勾子 */
  componentDidMount() {
    console.log("disahfi");
    this.token = PubSub.subscribe("ListComponentState", (_,data) => {
      this.setState(data);
    });
  }
  
  componentWillUnmount() {
    PubSub.unsubscribe(this.token);
  }
  
  render() {
    const { users, isFirst, isLoading, err } = this.state;
    return (
      <div className="row">
        {isFirst ? (
          <h2>欢迎使用，请输入关键字，随后点击搜索</h2>
        ) : isLoading ? (
          <h2>Loading.....</h2>
        ) : err ? (
          <h2>{err}</h2>
        ) : (
          users.map((userObj) => {
            return (
              <div className="card" key={userObj.id}>
                <a rel="noreferrer" href={userObj.html_url} target="_blank">
                  <img
                    alt="head_portrait"
                    src={userObj.avatar_url}
                    style={{ width: "100px" }}
                  />
                </a>
                <p className="card-text">{userObj.login}</p>
              </div>
            );
          })
        )}
      </div>
    );
  }
}

```

## 8.GitHub搜索案例-fetch

```
fetch:原生函数，不再使用XmlHttpRequest提交ajax请求
老版本浏览器可能不支持
```

> axios

```
 axios({
            url:'/api2/search/users',
            method:'get',
            params:{
                q:`${keyWord}`,
            }
        }).then(
            res=>{
              PubSub.publish('ListComponentState',{
                users:res.data.items,
                isLoading:false,//是否处于加载中
              })
            },
            err=>{
              PubSub.publish('ListComponentState',{
                isLoading:false,//是否处于加载中
                err:err.message,//请求请求错误相关的信息
              })
            }
        )
```

> fetch(未优化)

```
fetch(`/api2/search/users?q=${keyWord}`)
      .then(
        (response) => {
          console.log("联系服务器成功了");
          return response.json();
        },
        (error) => {
          console.log("联系服务器失败了", error);
          return new Promise(() => {});
        }
      )
      .then(
        (res) => console.log(res),
        (err) => console.log(err)
      );
```

> fetch(优化1)

```
 fetch(`/api2/search/users?q=${keyWord}`)
      .then((response) => {
        console.log("联系服务器成功了");
        return response.json();
      })
      .then((res) => console.log(res))
      .catch((error) => console.log("失败了", error));
```

> fetch(优化2)

```
 try{
    const response = await fetch(`/api2/search/users?q=${keyWord}`);
    const data = await response.json();
          }catch(err){
           console.log("失败了", error)
          }
```

## 9.github搜索案例相关知识点（总结）

```
	1.设计状态时要考虑全面，例如带有网络请求的组件，要考虑请求失败怎么办。
	
	2.ES6小知识点：解构赋值+重命名
	
				let obj = {a:{b:1}}
				
				const {a} = obj; //传统解构赋值
				
				const {a:{b}} = obj; //连续解构赋值
				
				const {a:{b:value}} = obj; //连续解构赋值+重命名
				
	3.消息订阅与发布机制
	
				1.先订阅，再发布（理解：有一种隔空对话的感觉）
				
				2.适用于任意组件间通信
				
				3.要在组件的componentWillUnmount中取消订阅
				
	4.fetch发送请求（关注分离的设计思想）
	
				try {
				
					const response= await fetch(`/api1/search/users2?q=${keyWord}`)
					
					const data = await response.json()
					
					console.log(data);
					
				} catch (error) {
				
					console.log('请求出错',error);
				}
```

## 10.React路由



### 10.1相关理解

#### 10.1.1 SPA的理解

```
单页Web应用（single page web application,SPA）

整个应用只有一个完整的页面

单击页面中的链接不会刷新页面，只会做页面的局部刷新

数据都需要通过ajax请求获取，并在前端异步展现

```

#### 10.1.2 路由的理解

> 1. 什么是路由？

```
一个路由就是一个映射关系{key:value}

key为路径，value可能是function或component
```

> 2. 路由分类

```
后端路由

			1）理解：value是function用来处理客户端提交的请求
			
			2）注册路由：router.get(path,function(req,res))
			
			3)祖册过程：当node接收到一个请求时，根据请求路径找到匹配的路由，调用路由中的函数来处理请求，返回响应数据
			
前端路由：

			1）浏览器端路由，value是component，用于展示页面内容
			
			2）注册路由：<Route path="/test" component={Test}>
			
			3)工作过程：当浏览器的path变为/test时，当前路由组件就会变为Test组件
```

#### 10.1.4 react-router-dom的理解

```
React的一个插件库

专门用来实现一个SPA应用

基于react的项目基本都会用到此库
```

### 10.2路由的基本使用

```
1.明确好界面中的导航区、展示区

2.导航区的a标签改为Link标签

      <Link to="/xxxxx">Demo</Link>

3.展示区写Route标签进行路径的匹配

      <Route path='/xxxx' component={Demo}/>

4.<App>的最外侧包裹了一个<BrowserRouter>或<HashRouter>
```

> 安装

```
yarn add react-router-dom
```

> 原生html中，靠a标签跳转不同的页面

```
 <a className="list-group-item active" href="./about.html">
    About
</a>
<a className="list-group-item" href="./home.html">
    Home
</a>        
```

> 在react中靠路由链接实现切换组件---编写路由链接

```
<Link className="list-group-item active" to="/home">
  Home
</Link>
<Link className="list-group-item " to="/about">
  About
</Link>
```

>  注册路由 

```
<Route path="/home" component={Home} />
<Route path="/about" component={About} />
```

```
import {BrowserRouter} from 'react-router-dom' 
 ReactDOM.render(
        <BrowserRouter>
            <App/>
        </BrowserRouter>,
    document.getElementById('root'))
```

### 10.3 路由组件与一般组件

```
		1.写法不同：
		
					一般组件：<Demo/>
					
					路由组件：<Route path="/demo" component={Demo}/>
					
		2.存放位置不同：
		
					一般组件：components
					
					路由组件：pages
					
		3.接收到的props不同：
		
					一般组件：写组件标签时传递了什么，就能收到什么
					
					路由组件：接收到三个固定的属性
					
										history:
													go: ƒ go(n)
													goBack: ƒ goBack()
													goForward: ƒ goForward()
													push: ƒ push(path, state)
													replace: ƒ replace(path, state)
													
										location:
													pathname: "/about"
													search: ""
													state: undefined
													
										match:
													params: {}
													path: "/about"
													url: "/about"
```

### 10.4 NavLink的使用

> **activeClassName—给NavLink加类名**

```
  	 <NavLink activeClassName="atColor" className="list-group-item " to="/home">
        Home
      </NavLink>
      <NavLink activeClassName="atColor" className="list-group-item " to="/about">
        About
      </NavLink>
```

### 10.5 NavLink与封装NavLink

```
NavLink可以实现路由链接的高亮，通过activeClassName指定样式

标签题内容是一个特殊的标签属性

通过this.props.children可以获取标签体内容
```

### 10.6 Switch的使用

```
        <Switch>
          {/* 注册路由 */}
          <Route path="/home" component={Home} />
          <Route path="/about" component={About} />
          <Route path="/about" component={Test} />
        </Switch>
```

