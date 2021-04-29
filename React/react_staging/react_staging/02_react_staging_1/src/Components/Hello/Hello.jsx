/* 创建组件Hello */
import React, { Component } from "react";
import  './Hello.css'
export default class Hello extends Component {
  render() {
    return <h2 className="hello">你好，我是Hello子组件</h2>;
  }
}
