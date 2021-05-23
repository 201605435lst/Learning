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