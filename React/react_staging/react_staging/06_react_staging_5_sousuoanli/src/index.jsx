import React, { Component } from "react";
import List from "./component/List/List";
import Search from "./component/Search/Search";
export default class index extends Component {
  /* 初始化状态 */
    state={
        users:[],
        isFirst:true,//是否为第一次打开页面
        isLoading:false,//是否处于加载中
        err:null,//请求请求错误相关的信息
    }
    updateAppState=(stateObj)=>{
        this.setState(stateObj)
    }
  
  render() {
    return (
      <div className="container">
        <Search updateAppState={this.updateAppState}/>
        <List {...this.state}/>
      </div>
    );
  }
}
