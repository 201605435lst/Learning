/* 组件 */
import React, { Component } from "react";

import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import List from "./components/List/List";
import "./App.css";
export default class App extends Component {
  /* 状态在哪里，操作状态的方法就在哪里 */

  /* 初始化状态 */
  state = {
    todos: [
      { id: "001", name: "篮球", status: true },
      { id: "002", name: "足球", status: true },
      { id: "003", name: "羽毛球", status: true },
    ],
  };
  /* 添加一个todo，接收的是一个todo对象 */
  addTodo = (todo) => {
    const { todos } = this.state;
    const todoObj = [todo, ...todos];
    this.setState({ todos: todoObj });
  };
  /* 修改done值 */
  updateDone = (id, status) => {
    const { todos } = this.state;
    todos.forEach((itemObj) => {
      if (itemObj.id === id) {
        itemObj.status = status;
      }
    });
    this.setState({ todos });
  };
  /*删除todo值 */
  delateTodo = (id) => {
    const { todos } = this.state;
    const newTodos=todos.filter((todoObj) => {
      return todoObj.id !== id;
    });
    this.setState({ todos:newTodos });
  };
  render() {
    const { todos } = this.state;
    return (
      <div className="todo-container">
        <div className="todo-wrap">
          <Header addTodo={this.addTodo} />
          <List todos={todos} updateDone={this.updateDone} delateTodo={this.delateTodo} />
          <Footer  todos={todos} />
        </div>
      </div>
    );
  }
}
