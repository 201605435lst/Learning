"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
/* 统一暴露 */
function foo1() {
  console.log("foo1-----module2");
}
function foo2() {
  console.log("foo2-----module2");
}
exports.foo1 = foo1;
exports.foo2 = foo2;