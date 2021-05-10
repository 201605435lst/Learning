import React, { Component } from "react";
import "./Footer.css";
export default class Footer extends Component {
  handleAllchecked=(e)=>{
    this.props.updateAllstatus(e.target.checked)
  }
  clearAllchecked=()=>{
    this.props.clearAllchecked()
  }
  render() {
    const { todos } = this.props;
    /* 获取全部 */
    const todosCount = todos.length;
    /* 获取已完成的 cur就是遍历的每一个todo*/
    const doneCount = todos.reduce(
      (pre, todo) => pre + (todo.status ? 1 : 0),
      0
    );

    return (
      <div className="todo-footer">
        <label>
          <input
            type="checkbox"
            onChange={this.handleAllchecked}
            checked={todosCount === doneCount && todosCount>0? true : false}
          />
        </label>
        <span>
          <span>已完成{doneCount}</span> / 全部{todosCount}
        </span>
        <button onClick={this.clearAllchecked} className="btn btn-danger">清除已完成任务</button>
      </div>
    );
  }
}
