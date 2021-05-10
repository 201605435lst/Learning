import React, { Component } from "react";
import Item from "../Item/Item";
import PropTypes from "prop-types";
import "./List.css";
export default class List extends Component {
  /* 对接收的props的进行类型、必要性的限制 */
  static propTypes={
    todos:PropTypes.array.isRequired,
    updateDone:PropTypes.func.isRequired,
    delateTodo:PropTypes.func.isRequired
  }
  render() {
    const { todos, updateDone,delateTodo } = this.props;
    return (
      <ul className="todo-main">
        {todos.map((item) => {
          return <Item key={item.id} updateDone={updateDone} delateTodo={delateTodo} {...item} />;
        })}
      </ul>
    );
  }
}
