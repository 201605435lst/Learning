## 1.webpack（构建工具、项目构建）

```
构建：将程序写的源代码，经过编译、压缩、语法检查、兼容性处理、生成浏览器可以高效、稳定运行的代码 
构建工具：grunt（js）、gulpjs、webpack
```

1. 什么是webpack?
    - webpack是一个模块打包器。
    - 在webpack看来，前端的所有资源文件都会作为模块处理；（一切皆模块）
    - 他将根据模块的依赖关系进行静态分析，生成相应的静态资源；
2. 五个核心工具
   	- Entry:入口起点(Entry point) 指示webpack应该使用哪个模块，来作为构建其内部依赖图的开始。
   	- Output:output属性告诉webpack在哪里输出他所创建的bundles，以及如何命名这些文件，默认值为./dist。
   	- Loader:loader让webpack能够去处理那些非Javascript文件（webpack自身能够解析javascript）
   	- Plugins:插件则可以用于执行范围更广的任务。插件范围包括，从打包优化和压缩，一直到重新定义环境中的变量等
   	- Mode:模式，有生产模式production和开发模式development
3. 理解Loader
   - webpack本身只能加载JS/JSON模块，如果要加载其他类型的文件(模块),就需要使用对应的loader进行转换/加载
   - Loader本身也是运行在node.js环境中的Javascript模块
   - 它本身是一个函数，接受源文件作为参数，返回转换的结果
   - loader一般以xxx-loader的方式命名，xxx代表了这个loader要做的转换功能，比如json-loader
4. 理解plugins
   - 插件可以完成一些loader不能完成的功能
   - 插件的使用一般是在webpack的配置信息plugins选项中指定
5. 配置文件(默认)
   - webpack.configs:是一个node模块，返回一个json格式的配置信息对象





