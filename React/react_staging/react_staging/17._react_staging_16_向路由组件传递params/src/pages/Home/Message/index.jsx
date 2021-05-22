import React, { Component } from "react";
import { Route, Link } from "react-router-dom";
import Detail from './Detail/index'
export default class Message extends Component {
  state = {
    message: [
      { id: "001", title: "消息1" },
      { id: "002", title: "消息2" },
      { id: "003", title: "消息3" },
    ],
  };
  render() {
    const { message } = this.state;

    return (
      <div>
        <ul>
          {message.map((item) => {
            return (
              <li key={item.id}>

                {/* 向路由组件传递params参数 */}
                <Link to={`/home/message/detail/${item.id}/${item.title}`}>{item.title}</Link>

              </li>
            );
          })}
        </ul>

        <Route path="/home/message/detail/:id/:title" component={Detail}/>
        
      </div>
    );
  }
}
