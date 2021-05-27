import React, { Component } from 'react'

export default class Demo extends Component {
    state={count:0}
    add=()=>{
        // const {count}=this.state
        // /* 更新状态后的回调 */
        // this.setState({count:count+1},()=>{
        //     console.log(this.state.count);
        // })
        this.setState((state,props)=>{
            console.log(props);
            return {count:state.count+55}
        })
    }
    render() {
        return (
            <div>
                <h2>当前的和是：{this.state.count}</h2>
                <br/>
                <button onClick={this.add}>点击加1</button>
            </div>
        )
    }
}
