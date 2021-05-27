import React, { Component } from "react";

export default class Person extends Component {
  add = () => {
    const name = this.nameNode.value;
    const age = this.ageNode.value;
    console.log(age, name);
  };
  render() {
    return (
      <div>
        <h2>我是person组件</h2>
        <div>
          姓名：{" "}
          <input
            ref={(c) => (this.nameNode = c)}
            placeholder="请输入您的姓名"
          />
          <br />
          年龄：
          <input ref={(c) => (this.ageNode = c)} placeholder="请输入您的年龄" />
          <br />
          <button onClick={this.add}>添加</button>
          <ul>
            <li>姓名：----年龄</li>
            <li>姓名：----年龄</li>
            <li>姓名：----年龄</li>
            <li>姓名：----年龄</li>
          </ul>
        </div>
      </div>
    );
  }
}
