import React, { Component } from "react";
import axios from 'axios'
import PubSub from 'pubsub-js'
export default class search extends Component {
    search=()=>{
        /* 当输入的值发生变化的时候，需要进行消息订阅*/
        PubSub.publish('ListComponentState',{
          isFirst:false,//是否为第一次打开页面
          isLoading:true,//是否处于加载中
        })
        const {keyWordElement:{value:keyWord}}=this
        axios({
            url:'/api2/search/users',
            method:'get',
            params:{
                q:`${keyWord}`,
            }
        }).then(
            res=>{
              PubSub.publish('ListComponentState',{
                users:res.data.items,
                isLoading:false,//是否处于加载中
              })
            },
            err=>{
              PubSub.publish('ListComponentState',{
                isLoading:false,//是否处于加载中
                err:err.message,//请求请求错误相关的信息
              })
            }
        )
    }
  render() {
    return (
        <section className="jumbotron">
        <h3 className="jumbotron-heading">搜索git用户</h3>
        <div>
          <input ref={(c)=>this.keyWordElement=c} type="text" placeholder="请输入关键字点击搜索" />
          &nbsp;<button onClick={this.search}>搜索</button>
        </div>
      </section>
    )

   
  }
}
