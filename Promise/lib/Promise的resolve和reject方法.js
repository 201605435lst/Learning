/*
自定义Promise函数
*/

//Es5：匿名函数自调用或者自调用函数表达式IFFE
(function (params) {
  const PENDING = 'pending';
  const RESOLVED = 'resolved';
  const REJECRED = 'rejected';

  /*
    Promise构造函数
    excutor；执行器函数（同步）
    */
  function Promise(excutor) {
    const _this = this;
    _this.status = PENDING; //给promise对象指定status属性初始值为pending
    _this.data = undefined; //给promise对象指定一个用于存储结构数据的属性
    _this.calbacks = []; //每个元素的结构：{onResolved（）{}，onRejected(){}}
    function resolve(value) {
      //如果当前状态不是pending,直接结束
      if (_this.status !== PENDING) {
        return;
      }
      //将状态改为resolved
      _this.status = RESOLVED;
      //保存value数据
      _this.data = value;
      //如果有执行callback函数，立即异步执行回调函数onResolved
      if (_this.calbacks.length > 0) {
        setTimeout(() => {
          //放入队列中执行所有成功的回调
          _this.calbacks.forEach((calbacksObj) => {
            calbacksObj.onResolved(value);
          });
        });
      }
    }
    function reject(reason) {
      //如果当前状态不是pending,直接结束
      if (_this.status !== PENDING) {
        return;
      }
      //将状态改为rejected
      _this.status = REJECRED;
      //保存value数据
      _this.data = reason;
      //如果有执行callback函数，立即异步执行回调函数，onRejected
      if (_this.calbacks.length > 0) {
        setTimeout(() => {
          //放入队列中执行所有失败的回调
          _this.calbacks.forEach((calbacksObj) => {
            calbacksObj.onRejected(reason);
          });
        });
      }
    }
    try {
      //立即同步执行excutor
      excutor(resolve, reject);
    } catch (error) {
      //如果执行器抛出异常，promise对象变为rejected状态
      reject(error);
    }
  }
  /* 
      ①、Promise原型对象的then()
      ②、指定成功和失败的回调函数
      ③、返回一个新的promise对象
      ④、返回的结果由onResolved或者onRejected结果决定
 */

  Promise.prototype.then = function (onResolved, onRejected) {
    /* 总之，typeof和instanceof都是用来判断变量类型的，两者的区别在于：
            1、typeof判断所有变量的类型，返回值有number，boolean，string，function，object，undefined。
            2、typeof对于丰富的对象实例，只能返回"Object"字符串。
            3、instanceof用来判断对象，代码形式为obj1 instanceof obj2（obj1是否是obj2的实例），obj2必须为对象，否则会报错！其返回值为布尔值。
            4、instanceof可以对不同的对象实例进行判断，判断方法是根据对象的原型链依次向下查询，如果obj2的原型属性存在obj1的原型链上，（obj1 instanceof obj2）值为true。
 */
    const _this = this;
    /* 指定回调函数的默认值（必须是函数） 
       ①、 成功的回调继续向下传递的办法就是定义一个返回value的函数，
      ②、失败的回调继续向下传递的办法就是定义一个抛出reason的函数  
    
    */
    onResolved = typeof onResolved === 'function' ? onResolved : (value) => value; //向后传递成功的value
    onRejected =
      typeof onRejected === 'function'
        ? onRejected
        : (reason) => {
            throw reason; //向后传递失败的reason
          };
    /* 返回一个新的promise */
    return new Promise((resolve, reject) => {
      /* 调用指定回调函数处理,根据return的promise的结果，改变promise的状态 */
      function handle(callback) {
        /* 返回的结果由onResolved或者onRejected结果决定(三种情况)
           1、如果抛出异常，return的promise就会失败，reason就是error;
           2、如果回调函数返回的不是promise,return的promise就会成功，value就是返回的值;
           3、如果返回的是promise,return的promise结果就是这个promise的结果
        */
        try {
          const result = callback(_this.data);
          /* 3、如果返回的是promise,return的promise结果就是这个promise的结果 */
          if (result instanceof Promise) {
            /* 
            result.then(
              (value) => resolve(value), //当promise成功时，让return 的promise也成功
              (reject) => reject(value), //当promise失败时，让return 的promise也失败
            ); */

            /* 简写形式 */
            result.then(resolve, reject);
            /* 注：简写 
            function fn() {}
            div.onclick = function (event) {
              fn(event);
            }; */
            /*  等同于*/
            div.onclick = fn;
      
          } else {
            resolve(result);
            /* 2、如果回调函数返回的不是promise,return的promise就会成功，value就是返回的值*/
          }
        } catch (error) {
          /* 1、如果抛出异常，return的promise就会失败，reason就是error */
          reject(error);
        }
      }
      //当前状态还是pending状态，将回调函数保存起来
      if (_this.status === PENDING) {
        _this.calbacks.push({
          onResolved(value) {
            handle(onResolved);
          },
          onRejected(reason) {
            handle(onRejected);
          },
        });
      } else if (_this.status === RESOLVED) {
        //如果当前是resolved状态，异步执行onResolved并改变return的promise状态
        setTimeout(() => {
          handle(onResolved);
        });
      } else {
        //如果当前是rejected状态，异步执行onRejected并改变return的promise状态
        setTimeout(() => {
          handle(onRejected);
        });
      }
    });
  };
  /* 
 Promise原型对象的catch()
 指定失败的回调函数
 返回一个新的promise对象
 */
  Promise.prototype.catch = function (onRejected) {
    return this.then(undefined, onRejected);
  };
  /*
 Promise函数对象的resolve方法 
 返回一个指定结果的成功的promise
 */
  Promise.resolve = function (value) {
    //返回一个成功的promise
    return new Promise((resolve,reject)=>{
      /* 会出现以下两种情况 */
      if(value instanceof Promise){
        /* 如果是promise,使用value的结果作为promise的结果 */
        value.then(resolve,reject)
      }else{
        /* 如果不是promise =>promise变为成功，数据是value */
        resolve(value)
      }
    })
  };
  /*
 Promise函数对象的reject方法 
 返回一个指定reason的失败的promise
 */
  Promise.reject = function (reason) {
    //返回一个失败的promise
    return new Promise((resolve,reject)=>{
      reject(reason)
    })
  };
  /*
 Promise函数对象的all方法 
 返回一个promise，只有当所有promise都成功时才成功，否则只要有一个失败都是失败的
 */
  Promise.all = function (promises) {};
  /*
 Promise函数对象的race方法 
 返回一个promise，其结果由第一个完成的promise决定
 */
  Promise.race = function (promises) {};
  window.Promise = Promise;
})(window);
