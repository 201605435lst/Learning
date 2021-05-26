## 1.redux

#### 1.1 Redux是什么

```
redux是一个专门用于做状态管理的JS库(不是react插件库)。

它可以用在react, angular, vue等项目中, 但基本与react配合使用。

作用: 集中式管理react应用中多个组件共享的状态
```

#### 1.2 Redux的核心概念

> **action**

```
1. 动作的对象

2. 包含2个属性

           type：标识属性, 值为字符串, 唯一, 必要属性

           data：数据属性, 值类型任意, 可选属性

3. 例子：{ type: 'ADD_STUDENT',data:{name: 'tom',age:18} }
```

> **reducer**

```
1. 用于初始化状态、加工状态。

2. 加工时，根据旧的state和action， 产生新的state的纯函数。
```

> **store**

```
1. 将state、action、reducer联系在一起的对象

2. 如何得到此对象?

    1) import {createStore} from 'redux'

    2) import reducer from './reducers'

    3) const store = createStore(reducer)

3. 此对象的功能?

    1) getState(): 得到state

    2) dispatch(action): 分发action, 触发reducer调用, 产生新的state

    3) subscribe(listener): 注册监听, 当产生了新的state时, 自动调用
```

#### 1.3 miniRedux的使用

> **count_reducer.js**

```
/* 1、该文件用于创建一个为Count服务的reducer，reducer的本质就是一个函数

    2、reducer函数会接受到两个参数，分别为：之前的状态（preState）,动作对象（action)
*/
const initData=0

export default function countReducer(preState=initData,action) {

    /* 从action对象中获取type和data */
    
    const {type,data}=action
    
    switch (type) {
    
        case 'increment':
        
          return preState+data;
          
          case 'decrement':
          
            return preState-data;
            
        default:
        
           return preState;
    }
}
```

> **store.js**

```
/* 该文件专门用于暴露一个store对象，整个应用只有一个srore对象 */

//引入createStore，专门用于创建redux中最为核心的store对象

import {createStore} from 'redux'

//引入为Count组件服务的reducer

import countReducer from './count_reducer'

export default createStore(countReducer)
```

> **Count.jsx**

1. 监测redux中状态的变化，只要变化，就会调用render

```
  componentDidMount(){
  
    /* 监测redux中状态的变化，只要变化，就会调用render */
    
    store.subscribe(()=>{
      this.setState({})
    })
  }
  
  increment = () => {
    const { value } = this.selectoption;
    
    store.dispatch({
      type:'increment',
      data:value*1,
    })
  };
```

2. 在入口文件中全局监测redux的状态变化

```
import React from 'react'

import ReactDOM from 'react-dom'

import App from './App.jsx'

import store from './redux/store'

ReactDOM.render(<App/>,document.getElementById('root'))

store.subscribe(()=>{

    ReactDOM.render(<App/>,document.getElementById('root'))
})
```

#### 1.4 异步action版

```
	 (1).明确：延迟的动作不想交给组件自身，想交给action
	 
	 (2).何时需要异步action：想要对状态进行操作，但是具体的数据靠异步任务返回。
	 
	 (3).具体编码：
	 
	 			1).yarn add redux-thunk，并配置在store中
	 			
	 			2).创建action的函数不再返回一般对象，而是一个函数，该函数中写异步任务。
	 			
	 			3).异步任务有结果后，分发一个同步的action去真正操作数据。
	 			
	 (4).备注：异步action不是必须要写的，完全可以自己等待异步任务的结果了再去分发同步action。
```

```

import { INCREMENT, DECREMENT } from "./constant";

/*为count组件生成action对象  */

/* 同步action，就是指action的值为object类型的一般对象 */

const incrementFnc = (data) => ({ type: INCREMENT, data });
const decrementFnc = (data) => ({ type: DECREMENT, data });

/* 异步action，就是指action的值为函数,异步action中一般都会调用同步action */
const incrementAsyncFnc = (data, time) => {
    
  return (dispatch) => {
    setTimeout(() => {
      console.log(time);
      dispatch(incrementFnc(data));
    }, time);
  };
};
export { incrementFnc, decrementFnc, incrementAsyncFnc };

```

> **store.js**

```
/* 该文件专门用于暴露一个store对象，整个应用只有一个srore对象 */

//引入createStore，专门用于创建redux中最为核心的store对象

import {
      createStore,
      applyMiddleware,
} from 'redux'

//引入为Count组件服务的reducer

import countReducer from './count_reducer'

/* 引入redux-thunk，用于支持异步action */

import thunk from 'redux-thunk'

export default createStore(countReducer,applyMiddleware(thunk))
```

#### 1.5 React-redux的基本使用

> **components/count**

```
  increment = () => {
    const { value } = this.selectoption;
    this.props.increment(value*1)
  };
  decrement = () => {
    const { value } = this.selectoption;
    this.props.decrement(value*1)
  };
  incrementOfAdd =  () => {
    const { value } = this.selectoption;
    const {count}=this.props
    if(count % 2!==0){
      this.props.increment(value*1)
    }
    
  };
  incrementOfAsync = () => {
    const { value } = this.selectoption;
    this.props.incrementAsync(value*1,500)
  };


```

> **containers/count**

```
/* eslint-disable no-labels */
/* eslint-disable no-unused-expressions */
/* 引入count的Ui组件 */
import Count from '../../components/Count/index'

import {incrementFnc, decrementFnc, incrementAsyncFnc} from '../../redux/count_action'

/* 引入connect用于连接UI组件与redux */
import {connect} from 'react-redux'
/* 
    1.mapStateToProps函数的返回值是一个对象；
    2.返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
    3.mapStateToProps用于传递状态
*/
const mapStateToProps=state=>{
    return {count:state}
}

const mapDispatchToProps=(dispatch)=>{
    return {
        increment:num=>dispatch(incrementFnc(num)),
        decrement:num=>dispatch(decrementFnc(num)),
        incrementAsync:(num,data)=>dispatch(incrementAsyncFnc(num,data)),
    }
}
/* 使用connect()()创建并暴露一个count的容器组件 */
export default connect(mapStateToProps,mapDispatchToProps)(Count)
```

> **App.jsx**

```
import React, { Component } from 'react'
import Count from './containers/Count'
import store from './redux/store'
export default class App extends Component {
    render() {
        return (
            <div>
                {/* 给容器组件传递store */}
               <Count store={store}/>
            </div>
        )
    }
}
```

> **简写**

```
const mapStateToProps=state=>{
    return {count:state}
}

const mapDispatchToProps=(dispatch)=>{
    return {
        increment:num=>dispatch(incrementFnc(num)),
        decrement:num=>dispatch(decrementFnc(num)),
        incrementAsync:(num,data)=>dispatch(incrementAsyncFnc(num,data)),
    }
}
```

```
export default connect(

state => ({ count: state }),

 {
  increment: incrementFnc,
  decrement: decrementFnc,
  incrementAsync: incrementAsyncFnc,
}
)(Count);
```

> **provider在入口文件中的使用**

```
import store from "./redux/store";

import { Provider } from "react-redux";

ReactDOM.render(

  <Provider store={store}>
    <App />
  </Provider>,

  document.getElementById("root")
  
);
```

