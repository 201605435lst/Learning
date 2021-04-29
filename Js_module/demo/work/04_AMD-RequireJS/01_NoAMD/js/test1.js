(
  /* 定义一个没有依赖的模块 */
  function (window) {
    let data = "这个模块没有依赖";
    function fun() {
      return data
    }
    window.test1={fun}
  }
)(window);
