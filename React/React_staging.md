## 1.创建项目

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

**安装prop-types**

```
import PropTypes from "prop-types";

 /* 对接收的props的进行类型、必要性的限制 */
  static propTypes={
    todos:PropTypes.array.isRequired,
    updateDone:PropTypes.func.isRequired
  }
```



