import React, { Component } from "react";
import { Route, Link } from "react-router-dom";
import Detail from "./Detail/index";
export default class Message extends Component {
  state = {
    message: [
      { id: "001", title: "消息1" },
      { id: "002", title: "消息2" },
      { id: "003", title: "消息3" },
    ],
  };
  pushShow = (id, title) => {

    // /* push挑转，携带params参数 */
    // this.props.history.push(`/home/message/detail/${id}/${title}`);

    // /*  push跳转，携带search参数 */
    // this.props.history.push(`/home/message/detail/?id=${id}& title=${title}`);

    // /*  push跳转，携带state参数 */
    this.props.history.push('/home/message/detail',{id,title});

  };
  replaceShow = (id, title) => {

    // /* replace挑转，携带params参数 */
    // this.props.history.replace(`/home/message/detail/${id}/${title}`);

    // // /* replace挑转，携带search参数 */
    // this.props.history.replace(`/home/message/detail/?id=${id}& title=${title}`);

    // /* replace挑转，携带state参数 */
    this.props.history.replace('/home/message/detail',{id,title});


  };
  forward=()=>{
this.props.history.goForward()
  }
  back=()=>{
    this.props.history.goBack()
  }
  render() {
    const { message } = this.state;

    return (
      <div>
        <ul>
          {message.map((item) => {
            return (
              <li key={item.id}>
                {/* 向路由组件传递params参数 */}
                {/* <Link to={`/home/message/detail/${item.id}/${item.title}`}>
                  {item.title}
                </Link> */}
                {/* 向路由组件传递search参数 */}
                {/* <Link to={`/home/message/detail/?id=${item.id}&title=${item.title}`} >
                  {item.title}
                </Link> */}
                {/* 向路由组件传递state参数 */}
                <Link
                  to={{
                    pathname: "/home/message/detail",
                    state: { id: item.id, title: item.title },
                  }}
                >
                  {item.title}
                </Link>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button onClick={() => this.pushShow(item.id, item.title)}>
                  push跳转
                </button>
                &nbsp;&nbsp;
                <button onClick={() => this.replaceShow(item.id, item.title)}>
                  replace跳转
                </button>
              </li>
            );
          })}
        </ul>
       
       <button onClick={this.forward}>前进</button>
       <button onClick={this.back}>后退</button>
        {/* 声明接受params参数 */}
        {/* <Route path="/home/message/detail/:id/:title" component={Detail} /> */}

        {/* 接受search参数无需声明,正常注册即可 */}
          {/* <Route path="/home/message/detail" component={Detail} /> */}

        {/* 接收state参数无需声明，正常注册即可 */}
        <Route path="/home/message/detail" component={Detail} />
      </div>
    );
  }
}
