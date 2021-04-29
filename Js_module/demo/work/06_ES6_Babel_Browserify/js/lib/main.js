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