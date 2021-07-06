(function () {
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
})();
