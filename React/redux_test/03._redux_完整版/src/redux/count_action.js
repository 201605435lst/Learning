
import {INCREMENT, DECREMENT} from './constant'
/*为count组件生成action对象  */
const incrementFnc=data=>({type:INCREMENT,data})
const decrementFnc=data=>({type:DECREMENT,data})
export {
    incrementFnc,
    decrementFnc,
}