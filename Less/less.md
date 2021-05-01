## 1.认识less

```
less是一种动态样式语言，属于css预处理器的范畴，它扩展了 CSS 语言，
	增加了变量、Mixin、函数等特性，使 CSS 更易维护和扩展
	LESS 既可以在 客户端 上运行 ，也可以借助Node.js在服务端运行。
```

## 2.less的注释

```
   	以//开头的注释，不会被编译到css文件中
   	以/**/包裹的注释会被编译到css文件中 
```

## 3.less中的变量

```
less中的变量
	使用@来申明一个变量：@pink：pink;
	1.作为普通属性值只来使用：直接使用@pink
	2.作为选择器和属性名：#@{selector的值}的形式
	3.作为URL：@{url}
	4.变量的延迟加载
```

```
@color:red;
@c:center;
@selector:.box;
@h:Height;
/*水平居中*/
@{selector} {
  text-align: @c;
  background-color: #db7093;
  .inner {
          background-color:@color;
          width: 300px;
          @{h}: 500px;
          display: inline-block;
  }
}

```

## 4.less中的嵌套规则

```
  1.基本嵌套规则

  2.&的使用(&代表父标签)
```

## 5.less中的混合

```
  混合就是将一系列属性从一个规则集引入到另一个规则集的方式
  1.普通混合   
  2.不带输出的混合
  3.带参数的混合
  4.带参数并且有默认值的混合
  5.带多个参数的混合
  6.命名参数
  7.匹配模式
  8.arguments变量
```

```
* {
  margin: 0;
  padding: 0;
}
.position(@c,@w,@h:100px) {
  position: absolute;
  background-color: @c;
  width: @w;
  height: @h;
  margin: auto;
}
.box {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  .position(rgb(212, 0, 255),400px,400px);
  .inner1 {
    right: 0;
    top: 0;
    bottom: 0;
    .position(rgb(255, 123, 0),100px,100px);
  }
  .inner2 {
    left: 0;
    top: 0;
    bottom: 0;
    .position(rgb(255, 192, 203),100px);
  }
}
```

**命名参数**

```
* {
    margin: 0;
    padding: 0;
  }
  .position(@c:rgb(255, 192, 203),@w:200px,@h:200px) {
    position: absolute;
    background-color: @c;
    width: @w;
    height: @h;
    bottom: 0;
    top: 0;
    margin: auto;
  }
  .box {
    left: 0;
    right: 0;
    .position(rgb(212, 0, 255),400px,400px);
    .inner1 {
      right: 0;
      .position(rgb(255, 123, 0),100px,100px);
    }
    .inner2 {
      left: 0;
      .position(@w:100px);
    }
  }
```

**匹配模式**（三角形）

```
.trangle(@_,@w,@c){
   width:0px;
   height:0px; 
   overflow: hidden;
}
.trangle(T,@w,@c){
   
    border-width: @w;
    border-style: solid dashed dashed  dashed;
    border-color:  @c  transparent transparent transparent;
}
.trangle(R,@w,@c){
    border-width: @w;
    border-style: dashed solid dashed dashed  ;
    border-color: transparent  @c transparent transparent;
}
.trangle(B,@w,@c){
    border-width: @w;
    border-style:  dashed dashed solid dashed;
    border-color:  transparent transparent @c transparent;
}
.trangle(L,@w,@c){
    border-width: @w;
    border-style: dashed  dashed dashed solid;
    border-color: transparent  transparent transparent @c;
}
```

```

@import "./trangle.less";
.box1{
    .trangle(T,100px,red);
}
.box2{
    .trangle(R,100px,red);
}
.box3{
    .trangle(B,100px,red);
}
.box4{
    .trangle(L,100px,red);
}
```

## 6.继承

实现一个水平居中包含两个大小不一的垂直居中

**1.混合**

**center.less**

```
.center(@c,@w,@w){
    position: absolute;
    top:0;
    bottom:0;
    left:0;
    right: 0;
    margin: auto;
    background-color: @c;
    width: @w;
    height: @w;
}
```

**mix.less**

```
* {
  margin: 0;
  padding: 0;
}
@import './mixin/center.less';
.box {
position: relative;
  width: 300px;
  height: 300px;
  background-color: pink;
  margin: 0 auto;
  .inner {
    &:nth-child(1){
       .center(rgb(255, 215, 192),200px,200px)
    }
    &:nth-child(2){
        .center(#921087,100px,100px)
    }
  }
}

```

**2.继承**

**mix-center.less**

```
.center{
    position: absolute;
    top:0;
    bottom:0;
    left:0;
    right: 0;
    margin: auto;

}
.center:hover{
    background-color: rgb(22, 21, 21) !important;
}

```

**mixin.less**

```
* {
  margin: 0;
  padding: 0;
}
@import "./mixin/minin_center.less";
.box {
  position: relative;
  width: 300px;
  height: 300px;
  background-color: pink;
  margin: 0 auto;
  .inner {
    &:extend(.center all);//继承他的所有属性
    &:nth-child(1) {
        background-color: rgb(47, 0, 255);
        width: 200px;
        height: 200px;
    }
    &:nth-child(2) {
        background-color: rgb(255, 0, 106);
        width: 100px;
        height: 100px;
    }
  }
}

```

## 7.避免编译

```
padding:~"calc(100px+10)"   如果less文件是以这种格式写的，转为css文件时是不会对他进行编译的
```



