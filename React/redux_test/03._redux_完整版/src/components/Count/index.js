import React, { Component } from "react";
import store from "../../redux/store";
import { incrementFnc, decrementFnc } from "../../redux/count_action";

export default class Count extends Component {
  // componentDidMount(){
  //   /* 监测redux中状态的变化，只要变化，就会调用render */
  //   store.subscribe(()=>{
  //     this.setState({})
  //   })
  // }
  increment = () => {
    const { value } = this.selectoption;
    store.dispatch(incrementFnc(value*1));
  };
  decrement = () => {
    const { value } = this.selectoption;
    store.dispatch(decrementFnc(value*1));
  };
  incrementOfAdd = () => {
    const { value } = this.selectoption;
    const count = store.getState();
    if (count % 2 !== 0) {
      store.dispatch(incrementFnc(value*1));
    }
  };
  incrementOfAsync = () => {
    const { value } = this.selectoption;
    setTimeout(() => {
      store.dispatch(incrementFnc(value*1));
    }, 500);
  };
  render() {
    return (
      <div>
        <h2>当前求和值为：{store.getState()}</h2>
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
