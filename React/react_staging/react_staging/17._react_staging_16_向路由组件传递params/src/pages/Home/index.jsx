import React, { Component } from "react";
import { Redirect, Route,Switch } from "react-router-dom";
import MyNavLink from '../../component/MyNavLink/index'
import Message from "./Message/index";
import News from "./News/index";
export default class Home extends Component {
  render() {
    return (
      <div>
        <h2>Home组件内容</h2>
        <div>
          <ul className="nav nav-tabs">
            <li>
              <MyNavLink to="/home/news">News</MyNavLink>
            </li>
            <li>
              <MyNavLink to="/home/message">Message</MyNavLink>
            </li>
          </ul>
          <div>
            <Switch>
              <Route path="/home/news" component={News}></Route>
              <Route path="/home/message" component={Message}></Route>
              <Redirect to="/home/news" />
            </Switch>
          </div>
        </div>
      </div>
    );
  }
}
