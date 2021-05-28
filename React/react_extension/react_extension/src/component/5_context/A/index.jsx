import B from '../B'
import React, { Component } from 'react'
const MyContext = React.createContext()
const {Provider} = MyContext

export default class A extends Component {
    state={name:'校长',age:23}
    render() {
        const {name,age}=this.state
        return (
            <div className="a">
                <h2>我是A组件：我的名字是{name}</h2> 
                <h2>我是A组件：我的年龄是{age}</h2> 
                <Provider value={name,age}>
                <B {...this.state}/>
                </Provider>
   
            </div>
        )
    }
}
