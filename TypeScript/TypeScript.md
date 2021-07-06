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

## 2  类

```
  class Animal {
    name: string = "aaa";
    constructor(name: string) {
      this.name = name;
    }
    bark() {
      console.log("在叫");
    }
  }
  class Dog extends Animal {
      age:number
    constructor(name:string,age:number){
        /* 如果在父类中也写了构造函数，在子类的构造函数中必须对父类的构造函数进行调用 */
        super(name);
        this.age=age;
    }

    /* 在类的方法中，super相当于当前类的父类 */
    bark() {
      super.bark();
    }
  }
  let dog = new Dog("小狗",12);
  dog.bark();
```

### 2.1 在类的方法中，super相当于当前类的父类

```
  class Dog extends Animal {
    /* 在类的方法中，super相当于当前类的父类 */
    bark() {
      super.bark();
    }
  }
```

### 2.2 如果在父类中也写了构造函数，在子类的构造函数中必须对父类的构造函数进行调用

```
  class Dog extends Animal {
      age:number
    constructor(name:string,age:number){
        /* 如果在父类中也写了构造函数，在子类的构造函数中必须对父类的构造函数进行调用 */
        super(name);
        this.age=age;
    }

  let dog = new Dog("小狗",12);

```

## 3 抽象类

```
/**
   * 以abstract类开头的是抽象类
   * 抽象类和其他类区别不大，只是不能用来创建对象
   * 抽象类就是专门用来被继承的类
   * */
  abstract class Animal {
    name: string = "aaa";
    constructor(name: string) {
      this.name = name;
    }
    bark() {
      console.log("在叫");
    }
    /**
     * 定义一个抽象方法
     * 抽象方法使用abstract开头，没有方法体
     * 抽象方法只能定义在抽象类中，子类必须对抽象方法进行重写
     */
    abstract sleep():void
  }
  class Dog extends Animal {
    sleep(): void {
        console.log("在睡觉");
    }
    bark() {
      super.bark();
    }
  }
  let dog = new Dog("小狗");
  dog.bark();
```

###  3.1 抽象类

- 以abstract类开头的是抽象类

   * 抽象类和其他类区别不大，只是不能用来创建对象
   * 抽象类就是专门用来被继承的类

```
  /**
   * 以abstract类开头的是抽象类
   * 抽象类和其他类区别不大，只是不能用来创建对象
   * 抽象类就是专门用来被继承的类
   * */
  abstract class Animal {
    name: string = "aaa";
    constructor(name: string) {
      this.name = name;
    }
    bark() {
      console.log("在叫");
    }
  }
  class Dog extends Animal {
    bark() {
      super.bark();
    }
  }
  let dog = new Dog("小狗");
  dog.bark();
```

### 3.2 抽象方法

```
/**
 * 定义一个抽象方法
 * 抽象方法使用abstract开头，没有方法体
 * 抽象方法只能定义在抽象类中，子类必须对抽象方法进行重写
 */
abstract sleep():void
```

## 4 接口

- 接口用来定义一个类的接口
- 用来定义一个类中应该包含哪些属性和方法
- 同时，接口还能当做类型声明去使用
- 接口可以在定义类的时候限制类的结构 接口中的所有属性都不能有实际的值 接口中只定义对象的结构，而不考虑实际值
- 接口中的所有方法都是抽象方法

```
/* 描述一个对象的类型 */
  type people = {
    name: string;
    age: number;
    [propname: string]: any;
  };
  const person: people = {
    name: "aaa",
    age: 23,
  };
  /**
   * 接口用来定义一个类的接口
   * 用来定义一个类中应该包含哪些属性和方法
   * 同时，接口还能当做类型声明去使用
   * 接口可以在定义类的时候限制类的结构
   * 接口中的所有属性都不能有实际的值
   * 接口中只定义对象的结构，而不考虑实际值
   * 接口中的所有方法都是抽象方法
   */
  interface myInterface {
    name: string;
    sex: string;
  }
  const person2: myInterface = {
    name: "aaa",
    sex: "男",
  };

  /**
   * 定义类时，可以使类去实现一个接口
   * 实现接口就是事类满足接口的要求
   */
  interface myInter {
    name: string;
    talk():void
  }
  class inter implements  myInter{
      name: string;
      talk(): void {
          console.log("实现接口");
          
      }

  }
```

### 4.1定义类时，可以使类去实现一个接口

```
 /**
   * 定义类时，可以使类去实现一个接口
   * 实现接口就是事类满足接口的要求
   */
  interface myInter {
    name: string;
    talk():void
  }
  class inter implements  myInter{
      name: string;
      talk(): void {
          console.log("实现接口");
          
      }
```

## 5 属性封装

```
class A{
    private name:string
    private age:number
    constructor(name:string,age:number){
        this.name=name;
        this.age=age
    }
    get _name(){
        return this.name;
    }
    set _name(name:string){
    this.name=name
    }
}
let a=new A("aaa",12)
console.log(a);
console.log(a._name);
```



