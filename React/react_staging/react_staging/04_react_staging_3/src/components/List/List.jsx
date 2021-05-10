import React, { Component } from "react";
import Item from "../Item/Item";
import './List.css';
export default class List extends Component {
  render() {
      const {todos}=this.props
    return (
      <ul className="todo-main">
        {todos.map(item=>{
            console.log(item);
            return <Item key={item.id}  {...item}/>
        })}
      </ul>
    );
  }
}
