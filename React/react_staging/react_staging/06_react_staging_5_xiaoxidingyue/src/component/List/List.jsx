import React, { Component } from "react";
import "./List.css";
import PubSub from 'pubsub-js'
export default class List extends Component {
  state={
    users:[],
    isFirst:true,//是否为第一次打开页面
    isLoading:false,//是否处于加载中
    err:null,//请求请求错误相关的信息
  }
  /* 组件挂载完毕的勾子 */
  componentDidMount(){
  this.token=   PubSub.publish("ListComponentState",(_,data)=>{
      this.setState(data)
    })
  }
  componentWillUnmount(){
    PubSub.unsubscribe(this.token)
  }
  render() {
 
    const { users,isFirst,isLoading,err} =this.state
    return (
      <div className="row">
        {
         isFirst?<h2>欢迎使用，请输入关键字，随后点击搜索</h2>:
         isLoading?<h2>Loading.....</h2>:
         err?<h2>{err}</h2>:
        users.map((userObj) => {
          return (
            <div className="card" key={userObj.id}>
            <a
              rel="noreferrer"
              href={userObj.html_url}
              target="_blank"
            >
              <img
                alt="head_portrait"
                src={userObj.avatar_url}
                style={{ width: "100px" }}
              />
            </a>
            <p className="card-text">{userObj.login}</p>
          </div>
          )
        })}
      </div>
    );
  }
}
