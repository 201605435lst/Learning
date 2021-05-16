import React, { Component } from "react";
import axios from "axios";
export default class index extends Component {
  studentInfo = () => {
    axios({
      url: "http://localhost:3000/app1/students",
      method: "get",
    }).then(
      (res) => {
        console.log(res.data);
      },
      (error) => {
        console.log(error.message);
      }
    );
  };
  cartInfo=()=>{
    axios({
        url: "http://localhost:3000/app2/cars",
        method: "get",
      }).then(
        (res) => {
          console.log(res.data);
        },
        (error) => {
          console.log(error.message);
        }
      );
  }
  render() {
    return (
      <div>
        <div>
          <button onClick={this.studentInfo}>点击我获取学生列表信息</button>
        </div>
        <div>
          <button onClick={this.cartInfo}>点击我获取汽车列表信息</button>
        </div>
      </div>
    );
  }
}
