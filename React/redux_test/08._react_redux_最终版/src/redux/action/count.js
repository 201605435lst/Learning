import { INCREMENT, DECREMENT } from "../constant";

/*为count组件生成action对象  */

/* 同步action，就是指action的值为object类型的一般对象 */

const increment = (data) => ({ type: INCREMENT, data });
const decrement = (data) => ({ type: DECREMENT, data });

/* 异步action，就是指action的值为函数,异步action中一般都会调用同步action */
const incrementAsync = (data, time) => {  
  return (dispatch) => {
    setTimeout(() => {
      dispatch(increment(data));
    }, time);
  };
};
export { increment, decrement, incrementAsync };
