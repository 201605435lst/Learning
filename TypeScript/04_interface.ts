(function () {
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
})();
