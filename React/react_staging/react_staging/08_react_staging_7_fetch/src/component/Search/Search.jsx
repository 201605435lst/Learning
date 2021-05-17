import React, { Component } from "react";
// import axios from 'axios'
import PubSub from "pubsub-js";
export default class search extends Component {
  search = async () => {
    /* 当输入的值发生变化的时候，需要进行消息订阅*/
    PubSub.publish("ListComponentState", {
      isFirst: false, //是否为第一次打开页面
      isLoading: true, //是否处于加载中
    });
    const {
      keyWordElement: { value: keyWord },
    } = this;
    //#region   使用axios发送网络请求
    /* 
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
      */
    //#endregion

    //#region  使用fetch发送网络请求（未优化）
    // fetch(`/api2/search/users?q=${keyWord}`)
    //   .then(
    //     (response) => {
    //       console.log("联系服务器成功了");
    //       return response.json();
    //     },
    //     (error) => {
    //       console.log("联系服务器失败了", error);
    //       return new Promise(() => {});
    //     }
    //   )
    //   .then(
    //     (res) => console.log(res),
    //     (err) => console.log(err)
    //   );
    //#endregion

    //#region  使用fetch发送网络请求（优化）
    // fetch(`/api2/search/users?q=${keyWord}`)
    //   .then((response) => {
    //     console.log("联系服务器成功了");
    //     return response.json();
    //   })
    //   .then((res) => console.log(res))
    //   .catch((error) => console.log("失败了", error));
    //#endregion

    //#region  使用fetch发送网络请求（优化）
            try{
              const response = await fetch(`/api2/search/users?q=${keyWord}`);
              const data = await response.json();
          
              PubSub.publish('ListComponentState',{
                users:data.items,
                isLoading:false,//是否处于加载中
              })
            }catch(err){
              PubSub.publish('ListComponentState',{
                isLoading:false,//是否处于加载中
                err:err.message,//请求请求错误相关的信息
              })
            }
    //#endregion
  };
  render() {
    return (
      <section className="jumbotron">
        <h3 className="jumbotron-heading">搜索git用户</h3>
        <div>
          <input
            ref={(c) => (this.keyWordElement = c)}
            type="text"
            placeholder="请输入关键字点击搜索"
          />
          &nbsp;<button onClick={this.search}>搜索</button>
        </div>
      </section>
    );
  }
}
