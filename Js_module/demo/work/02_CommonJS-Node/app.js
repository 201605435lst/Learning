/* 将其他的模块汇集到这个模块 */
let uniq=require('uniq')
let module1=require('./module/module1')
let module2=require('./module/module2')
let module3=require('./module/module3')

module1.fun()

module2()

module3.fun2.func()

module3.func3()
let arr=module3.arr
let result=uniq(arr)
console.log(result);