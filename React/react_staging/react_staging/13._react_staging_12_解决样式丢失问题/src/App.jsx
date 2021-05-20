import React, { Component } from "react";
import { Route, Switch } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Header from "./component/Header";
import Test from './pages/Test';
import MyNavLink from "./component/MyNavLink";
export default class App extends Component {
  render() {
    return (
      <div>
        <div className="row">
          <div className="col-xs-offset-2 col-xs-8">
            <div className="page-header">
              <Header />
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-xs-2 col-xs-offset-2">
            <div className="list-group">
              {/*原生html中，靠a标签跳转不同的页面*/}
              {/* <a className="list-group-item active" href="./about.html">
                About
              </a>
              <a className="list-group-item" href="./home.html">
                Home
              </a> */}
              {/* 在react中靠路由链接实现切换组件---编写路由链接 */}
              <MyNavLink to="/aa/home">Home</MyNavLink>
              <MyNavLink to="/aa/about">About</MyNavLink>
            </div>
          </div>
          <div className="col-xs-6">
            <div className="panel">
              <div className="panel-body">
                <Switch>
                  {/* 注册路由 */}
                  <Route path="/aa/home" component={Home} />
                  <Route path="/aa/about" component={About} />
                  <Route path="/aa/about" component={Test} />
                </Switch>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
