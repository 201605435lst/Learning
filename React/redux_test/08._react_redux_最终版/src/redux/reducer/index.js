/* 该文件汇总所有的reducer */

/* 引入汇总的reducer */
import { combineReducers } from "redux";

//引入为Count组件服务的reducer
import count from "./count";

//引入为Persion组件服务的reducer
import { person } from "./person";

/*
 汇总所有的reducer变为一个总的reducer 
 combineReducers调用的时候传入的那个对象就是redux里面保存的那个总状态对象 
*/
export default combineReducers({
  count,
  person,
});
