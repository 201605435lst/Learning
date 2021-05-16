import React, { Component } from "react";
import "./Item.css";
export default class Item extends Component {

  state = { mouse: false };
  /* 鼠标移入移出事件 */
  handleMouse = (flag) => {
    return () => {
      this.setState({ mouse: flag });
    };
  };
  handleChange=(id)=>{
    const {updateDone}=this.props;
    return (event)=>{
      updateDone(id,event.target.checked)
    }
  }
  delateTodo=(id)=>{
    this.props.delateTodo(id)
  }
  render() {
    const { id,name, status } = this.props;
    const { mouse } = this.state;
    return (
      <li
        style={{ backgroundColor: mouse ? "#ddd" : "white" }}
        onMouseEnter={this.handleMouse(true)}
        onMouseLeave={this.handleMouse(false)}
      >
        <label>
          <input type="checkbox" checked={status} onChange={this.handleChange(id)}/>
          <span>{name}</span>
        </label>
        <button className="btn btn-danger" style={{ display:mouse?'block':'none'}} onClick={()=>this.delateTodo(id)}>
          删除
        </button>
      </li>
    );
  }
}
