import "./css/css.css";
import React, { Component } from "react";
const MyContext = React.createContext();
const { Provider, Consumer } = MyContext;
export default class A extends Component {
  state = { name: "校长", age: 23 };
  render() {
    const { name, age } = this.state;
    return (
      <div className="a">
        <h2>我是A组件：我的名字是{name}</h2>
        <h2>我是A组件：我的年龄是{age}</h2>
        <Provider value={{ name, age }}>
          <B />
        </Provider>
      </div>
    );
  }
}
class B extends Component {
  render() {
    const { name, age } = this.props;
    return (
      <div className="b">
        <h2>我是B组件：显示A组件的名字是{name}</h2>
        <h2>我是B组件：显示A组件的年龄是{age}</h2>
        <C />
      </div>
    );
  }
}
class C extends Component {
  static contextType = MyContext;

  render() {
    const { name, age } = this.context;
    return (
      <div className="c">
        <h2>我是C组件：显示A组件的名字是{name}</h2>
        <h2>我是C组件：显示A组件的年龄是{age}</h2>
        <D />
      </div>
    );
  }
}
function D() {
  return (
    <Consumer>
      {(value) => {
        return (
          <div className="d">
            <h2>我是D组件：显示A组件的名字是{value.name}</h2>
            <h2>我是D组件：显示A组件的年龄是{value.age}</h2>
          </div>
        );
      }}
    </Consumer>
  );
}
