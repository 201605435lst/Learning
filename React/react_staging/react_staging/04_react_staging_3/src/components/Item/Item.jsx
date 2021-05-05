import React, { Component } from "react";
import './Item.css';
export default class Item extends Component {
  render() {
      const {name,status}=this.props
    return (
      <li>
        <label>
          <input type="checkbox"  defaultChecked={status}/>
          <span>{name}</span>
        </label>
        <button className="btn btn-danger" style={{ display: "none" }}>
          删除
        </button>
      </li>
    );
  }
}
