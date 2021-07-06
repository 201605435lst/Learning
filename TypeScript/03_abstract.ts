(function () {
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
})();
