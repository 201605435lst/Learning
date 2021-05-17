import React, { Component } from "react";
import{ nanoid} from 'nanoid';
import PropTypes from 'prop-types'
import './Header.css';
export default class Header extends Component {
  /* 对接收的props的进行类型、必要性的限制 */
  static propTypes={
    addTodo:PropTypes.func.isRequired
  }
 /*  键盘事件的回调 */
  handleKeyUp=(event)=>{
    const {target,keyCode}=event
    if(keyCode!==13) return
    if(target.value.trim()==='') {
      alert("输入的内容无效，不能为空");
      target.value='';
      return;
    }
    const objTodo={
      id:nanoid(),
      name:target.value,
      status:false,
    }
    this.props.addTodo(objTodo);
    target.value='';
  }
  render() {
    return (
      <div className="todo-header">
        <input onKeyUp={this.handleKeyUp} type="text" placeholder="请输入你的任务名称，按回车键确认" />
      </div>
    );
  }
}
