/* 1、改文件用于创建一个为Count服务的reducer，reducer的本质就是一个函数
    2、reducer函数会接受到两个参数，分别为：之前的状态（preState）,动作对象（action)
*/
const initData=0

export default function countReducer(preState=initData,action) {
    /* 从action对象中获取type和data */
    const {type,data}=action
    switch (type) {
        case 'increment':
          return preState+data;
          case 'decrement':
            return preState-data;
        default:
           return preState;
    }
}