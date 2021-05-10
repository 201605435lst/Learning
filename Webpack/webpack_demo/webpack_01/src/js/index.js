/* 注意：
        该index.js不同于学习模块化时，那个用于汇总js的文件夹
        模块化技术的index.js只用于汇总各个js模块
        该index.js是webpack的入口文件
        该文件可以用于汇总：js、css、json、图片、音频、视频

*/
//import '@babel/polyfill'//包含es6语法的高级转换
import {sum} from './module1'
import {sub} from './module2'
import module from './module3'
/* 在入口文件中引入json文件，如下写法*/
import  a from '../json/test.json'
/* 在入口文件中引入样式，不用变量接，不用写from */
import '../css/index.less'

console.log(sum(10,2));
console.log(sub(10,2));
console.log(module.mul(10,2));
console.log(module.div(10,2));
console.log(a,typeof a);

