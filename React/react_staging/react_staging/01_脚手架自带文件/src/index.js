import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
/* 分析页面的性能 */
import reportWebVitals from "./reportWebVitals";

ReactDOM.render(
  /* 检查代码不合理的地方------------ React.StrictMode*/
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);  

reportWebVitals();
