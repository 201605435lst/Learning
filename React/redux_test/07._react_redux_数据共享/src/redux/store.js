/* 该文件专门用于暴露一个store对象，整个应用只有一个srore对象 */
//引入createStore，专门用于创建redux中最为核心的store对象
import {createStore,applyMiddleware,combineReducers} from 'redux'

//引入为Count组件服务的reducer
import count from './reducer/count'

//引入为People组件服务的reducer
import {addPerson} from './reducer/person'

/* 引入redux-thunk，用于支持异步action */
import thunk from 'redux-thunk'

/*
 汇总所有的reducer变为一个总的reducer 
 combineReducers调用的时候传入的那个对象就是redux里面保存的那个总状态对象 
*/
const allReducer=combineReducers({
    sum:count,
    peoplelist:addPerson,
})
export default createStore(allReducer,applyMiddleware(thunk))