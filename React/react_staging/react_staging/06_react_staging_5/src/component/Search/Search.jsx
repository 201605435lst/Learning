import React, { Component } from "react";
import axios from 'axios'
export default class search extends Component {
    search=()=>{
        /* 发送请求通知页面更新状态 */
        this.props.updateAppState({
            isFirst:false,//是否为第一次打开页面
            isLoading:true,//是否处于加载中
        })  
        const {keyWordElement:{value:keyWord}}=this
        axios({
            url:'/api1/search/users',
            method:'get',
            params:{
                q:`${keyWord}`,
            }
        }).then(
            res=>{
                // const {updateAppState}=this.props
                    this.props.updateAppState({
                        isLoading:false,//是否处于加载中
                        users:res.data.items
                    })  
            },
            err=>{
                this.props.updateAppState({
                  isLoading:false,
                  err:err.message
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
