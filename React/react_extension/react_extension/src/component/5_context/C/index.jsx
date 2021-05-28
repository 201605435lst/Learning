import React, { Component } from 'react'

export default class C extends Component {
    render() {
        return (
            <div className="c">
                <h2>我是C组件：显示A组件的名字是{}</h2> 
                <h2>我是C组件：显示A组件的年龄是{}</h2> 
            </div>
        )
    }
}
