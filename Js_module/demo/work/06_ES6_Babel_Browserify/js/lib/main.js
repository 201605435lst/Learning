'use strict';

var _jquery = require('jquery');

var _jquery2 = _interopRequireDefault(_jquery);

var _module = require('./module1');

var _module2 = require('./module2');

var _module3 = require('./module3');

var _module4 = _interopRequireDefault(_module3);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

/* 引入其他模块 */
(0, _jquery2.default)("body").css('background', 'blue');
(0, _module.fun1)();
(0, _module.fun2)();
(0, _module2.foo1)();
(0, _module2.foo2)();
(0, _module4.default)();