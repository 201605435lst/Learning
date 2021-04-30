(
    /* 定义一个有依赖的模块 */
    function (window,test1) {
      function fun() {
        console.log(test1.fun());
      }
      window.test2={fun}
    }
  )(window,test1);