/* eslint-disable no-labels */
/* eslint-disable no-unused-expressions */
/* 引入count的Ui组件 */
import Count from '../../components/Count/index'

import {incrementFnc, decrementFnc, incrementAsyncFnc} from '../../redux/count_action'

/* 引入connect用于连接UI组件与redux */
import {connect} from 'react-redux'
/* 
    1.mapStateToProps函数的返回值是一个对象；
    2.返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
    3.mapStateToProps用于传递状态
*/
const mapStateToProps=state=>{
    return {count:state}
}

const mapDispatchToProps=(dispatch)=>{
    return {
        increment:num=>dispatch(incrementFnc(num)),
        decrement:num=>dispatch(decrementFnc(num)),
        incrementAsync:(num,data)=>dispatch(incrementAsyncFnc(num,data)),
    }
}
/* 使用connect()()创建并暴露一个count的容器组件 */
export default connect(mapStateToProps,mapDispatchToProps)(Count)