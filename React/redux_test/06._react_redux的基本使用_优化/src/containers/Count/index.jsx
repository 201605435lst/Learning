/* eslint-disable no-labels */
/* eslint-disable no-unused-expressions */
/* 引入count的Ui组件 */

import React, { Component } from "react";

import {
    incrementFnc,
    decrementFnc,
    incrementAsyncFnc,
  } from "../../redux/count_action";

/* 引入connect用于连接UI组件与redux */
import { connect } from "react-redux";

class Count extends Component {

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
  render() {
    console.log(this.props);
    return (
      <div>
        <h2>当前求和值为：{this.props.count}</h2>
        <br />
        <select ref={(c) => (this.selectoption = c)}>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
        </select>
        <br />
        <button onClick={this.increment}>+</button>
        <button onClick={this.decrement}>-</button>
        <button onClick={this.incrementOfAdd}>奇数加</button>
        <button onClick={this.incrementOfAsync}>异步加</button>
      </div>
    );
  }
}
/* 使用connect()()创建并暴露一个count的容器组件 */
export default connect(

state => ({ count: state }),
 {
  increment: incrementFnc,
  decrement: decrementFnc,
  incrementAsync: incrementAsyncFnc,
}
)(Count);
