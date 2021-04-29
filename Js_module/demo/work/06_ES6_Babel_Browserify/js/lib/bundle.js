(function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
'use strict';

var _module = require('./module1');

var _module2 = require('./module2');

var _module3 = require('./module3');

var _module4 = _interopRequireDefault(_module3);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

console.log((0, _module.fun1)()); /* 引入其他模块 */

console.log((0, _module.fun2)());
console.log((0, _module2.foo1)());
console.log((0, _module2.foo2)());
(0, _module4.default)();
},{"./module1":2,"./module2":3,"./module3":4}],2:[function(require,module,exports){
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
},{}],3:[function(require,module,exports){
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
},{}],4:[function(require,module,exports){
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

/* 默认暴露---可以暴露任意数据类型，暴露什么数据接收到的就是什么数据 */
exports.default = function () {
  console.log("我是默认暴露的箭头函数函数");
};
},{}]},{},[1]);
