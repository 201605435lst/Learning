/**
 * 使用module.exports = value向外暴露一个对象
 */
module.exports={
    message:'使用module.exports = value向外暴露一个对象',
    fun(){
        console.log(this.message);
    }
}