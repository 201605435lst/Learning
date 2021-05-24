import { INCREMENT, DECREMENT } from "./constant";

/*为count组件生成action对象  */

/* 同步action，就是指action的值为object类型的一般对象 */

const incrementFnc = (data) => ({ type: INCREMENT, data });
const decrementFnc = (data) => ({ type: DECREMENT, data });

/* 异步action，就是指action的值为函数,异步action中一般都会调用同步action */
const incrementAsyncFnc = (data, time) => {
    
  return () => {
    setTimeout((dispatch) => {
      console.log(time);
      dispatch(incrementFnc(data));
    }, time);
  };
};
export { incrementFnc, decrementFnc, incrementAsyncFnc };
