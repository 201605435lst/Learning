/* 组件 */
import React, { Component } from "react";

import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import List from "./components/List/List";
import "./App.css";
export default class App extends Component {
  state = {
    todos: [
      { id: '001', name: "篮球", status: true },
      { id: '002', name: "足球", status: true },
      { id: '003', name: "羽毛球", status: true },
    ],
  };
  addTodo=(todo)=>{
    const {todos}=this.state;
    const todoObj=[todo,...todos];
    this.setState({todos:todoObj})
  }
  render() {
    const { todos } = this.state;
    return (
      <div className="todo-container">
        <div className="todo-wrap">  
          <Header addTodo={this.addTodo}/>
          <List todos={todos} />
          <Footer />
        </div>
      </div>
    );
  }
}
