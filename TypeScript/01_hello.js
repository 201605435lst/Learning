console.log("Hello");
var aa;
aa = 2;
function sum(a, b) {
    return a + b;
}
var gg;
/* [propName:string]:any   表示任意类型的属性 */
var people;
people = {
    name: "第一",
    age: "21"
};
/* 设置函数结构的类型声明 */
var res;
res = function (a, b) {
    return a + b;
};
/* 表示数组
  let arr:string[]  表示字符串数组
  等价于
  let arr:Array[string]
  */
var ff;
ff = [1, 2];
/**
 * 元组，固定元素的数组
 */
var arr;
arr = ["A", "B"];
/**
 * 枚举   enum
 */
var Gendle;
(function (Gendle) {
    Gendle[Gendle["Male"] = 1] = "Male";
    Gendle[Gendle["Female"] = 2] = "Female";
})(Gendle || (Gendle = {}));
var i;
i = {
    name: "aaaa",
    sex: Gendle.Male
};
/* &表示同时 */
var a;
a = {
    name: "张三",
    age: 15
};
var aaa;
aaa = 3;
/* 只读属性*/
var Person = /** @class */ (function () {
    function Person() {
        this.name = 'aaa';
    }
    return Person;
}());
var person = new Person();
/* 静态实例只读属性 */
var Animial = /** @class */ (function () {
    function Animial() {
    }
    Animial.age = 33;
    return Animial;
}());
var dog = new Animial();
console.log(Animial.age);
/* super */
