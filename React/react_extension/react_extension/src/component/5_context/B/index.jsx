import React, { Component } from 'react'

import C from '../C'
export default class B extends Component {
    render() {
        const {name,age}=this.props
        return (
            <div className="b">
                <h2>我是B组件：显示A组件的名字是{name}</h2> 
                <h2>我是B组件：显示A组件的年龄是{age}</h2> 
                <C/>
            </div>
        )
    }
}
