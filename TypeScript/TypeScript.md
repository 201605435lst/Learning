## 1.定义类型

### 1.1对象

```
/* [propName:string]:any   表示任意类型的属性 */
let people: { name: string; [propName: string]: any };
people = {
  name: "第一",
  age: "21",
};
```

### 1.2 函数

```
/* 设置函数结构的类型声明 */
let res: (x: number, b: number) => number;
res = function (a: number, b: number): number {
  return a + b;
};
```

### 1.3 数组

```
  /* 表示数组
  let arr:string[]  表示字符串数组
  等价于
  let arr:Array[string]
  */
 let ff:number[]
 ff=[1,2,]
```

### 1.4 元组

```
 /**
  * 元组，固定元素的数组
  */
 let arr:[string,string]
 arr=["A","B"]
```

### 1.5枚举

```
/**
 * 枚举   enum
 */
enum Gendle {
  Male=1,
  Female=2,
}
let i:{name:string,sex:Gendle}
i={
  name:'aaaa',
  sex:Gendle.Male
}
```

### 1.6 &表示同时

```
let a: { name: string } & { age: number };
a = {
  name: "张三",
  age: 15,
};
```

### 1.7 类型的别名(type)

```
/* 类型的别名 */
type age = 1 | 3 | 5 | 6;
let  aaa:age
aaa=3
```

### 1.8定义实例只读属性

```
/* 只读属性*/
class Person{
  readonly name:string ='aaa'
}
let person =new Person()
```

### 1.9  静态实例只读属性

```
/* 静态实例只读属性 */
class Animial{
  static readonly age:number=33
}
let dog=new Animial()
Animial.name
```

