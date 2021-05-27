import React, { Component } from "react";
import {nanoid} from 'nanoid';
import {connect} from 'react-redux';

import {person} from '../../redux/action/person';
 class Person extends Component {
  add = () => {
    const name = this.nameNode.value;
    const age = this.ageNode.value;
    let person={
      id:nanoid(),
      name,age
    }
    this.props.addPerson(person)
    this.nameNode.value=''
    this.ageNode.value=''
  };
  render() {
    return (
      <div>
        <h2>我是person组件</h2><br/>
        <h2>当前求和为{this.props.count}</h2>
        <div>
          姓名：{" "}
          <input
            ref={(c) => (this.nameNode = c)}
            placeholder="请输入您的姓名"
          />
          <br />
          年龄：
          <input ref={(c) => (this.ageNode = c)} placeholder="请输入您的年龄" />
          <br />
          <button onClick={this.add}>添加</button>
          <ul>
            {
              this.props.peopleList.map(item=>{
                return <li key={item.id}>姓名：{item.name}----年龄:{item.age}</li>
              })
            }
          </ul>
        </div>
      </div>
    );
  }
}
export default connect(
  state=>({peopleList:state.peoplelist,count:state.sum}),
  {
      addPerson:person
  }
)(Person)