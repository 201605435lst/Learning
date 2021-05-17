import React, { Component } from "react";
import List from "./component/List/List";
import Search from "./component/Search/Search";
export default class index extends Component {
  render() {
    return (
      <div className="container">
        <Search/>
        <List />
      </div>
    );
  }
}
