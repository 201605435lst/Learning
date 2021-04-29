/**
 * IIFE模式: 匿名函数自调用(闭包)
 * IIFE : immediately-invoked function expression(立即调用函数表达式)
 * 作用: 数据是私有的, 外部只能通过暴露的方法操作
 * 问题: 如果当前这个模块依赖另一个模块怎么办?
 */
//IIFE模式
(function (window) {
  let data = "IIFE模式";
  function foo1() {
    console.log(`fool1() ${data}`);
  }
  function foo2() {
    console.log(`fool2() ${data}`);
    foo3()
  }
  function foo3() {
    console.log(`fool3() 被 fool2() 调用`);
  }
  window.module1 = { foo1, foo2 };
})(window);
