(function (){
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
})()