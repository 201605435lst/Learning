/* 
 * 使用exports.xxx = value向外暴露一个对象
 */
exports.fun2={
    data:'使用exports.xxx = value向外暴露一个对象',
    func(){
        console.log(this.data);
    }
}
exports.func3=function(){
    console.log("使用exports.xxx = value向外暴露一个函数");
}
exports.arr=[3,43,5,3,54,56]