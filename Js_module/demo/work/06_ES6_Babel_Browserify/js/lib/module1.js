"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.fun1 = fun1;
exports.fun2 = fun2;

/* 暴露模块    分别暴露 */
function fun1() {
  console.log("module1---------fun1");
}
function fun2() {
  console.log("module1---------fun2");
}
var arr = exports.arr = [4, 5, 2, 5];
var obj = exports.obj = { name: "刘" };