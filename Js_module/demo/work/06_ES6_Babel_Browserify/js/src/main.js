/* 引入其他模块 */
import $ from 'jquery'

import {fun1,fun2}from './module1'
import {foo1,foo2}from './module2'
import  module3 from './module3'

$("body").css('background','blue')
fun1();
fun2();
foo1();
foo2();
module3()