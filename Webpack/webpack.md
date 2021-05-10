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



## 2.webpack安装

```
npm install -g webpack webpack-cli
npm install webpack webpack -D
```

## 3.path.resolve(_dirname,'')

```
当前模块的目录名。 相当于 __filename 的 path.dirname()
示例，从 /Users/mjr 运行 node example.js：
	console.log(__dirname);
// 打印: /Users/mjr
console.log(path.dirname(__filename));
// 打印: /Users/mjr
```

## 4.入口文件的模块引入

```
/* 注意：
        该index.js不同于学习模块化时，那个用于汇总js的文件夹
        模块化技术的index.js只用于汇总各个js模块
        该index.js是webpack的入口文件
        该文件可以用于汇总：js、css、json、图片、音频、视频
*/
import {sum} from './module1'
import {sub} from './module2'
import module from './module3'
/* 在入口文件中引入json文件，如下写法*/
import  a from '../json/test.json'
/* 在入口文件中引入样式，不用变量接，不用写from */
import '../css/index.less'

console.log(sum(10,2));
console.log(sub(10,2));
console.log(module.mul(10,2));
console.log(module.div(10,2));
console.log(a,typeof a);
```

## 5.入口文件的配置信息(webpack.config.js)

```
const path=require("path")
module.exports = {
    entry: './src/js/index.js',//入口文件
    // entry:{
    //     main:'./src/js/index.js',
    // },
    output:{
        path:path.resolve(__dirname,'./dist'),
        filename:'js/index.js'
    },
    mode: 'development',
  };
```

## 6.如何找到自己需要的loader

**使用style-loader，css-loader,less-loader**

```
const path = require("path");
module.exports = {
  entry: "./src/js/index.js", //入口文件
  // entry:{
  //     main:'./src/js/index.js',
  // },
  output: {
    path: path.resolve(__dirname, "./dist"),
    filename: "js/index.js",
  },
 
  mode: "development",
  /* 所有的loader都要在module对象中的rules属性中，rules是一个数组 ，数组中的每一个对象就是一个loader*/
  /* loader特点：下载后无需引入，只需声明 */
  module: {
    rules: [
        /* 解析less，不完美 */
      {
        test: /\.less$/i,//匹配所有的less文件
        use: [
          "style-loader",//用于在html文档中创建一个style标签，将样式塞进去
          "css-loader",//将less编译后的css转换成CommonJs的一个模块
          "less-loader",//使用less-loader，将less编译为css，但不生成单独的css文件，在内存中
        ],
      },
    ],
  },
};

```

```
1.在webpack.config.js中引入
2.需要安装  npm install css-loader style-loader less-loader --save-dev
```

**使用eslint-loader**

```
 //js语法检查
 {
        enforce: "pre",
        test: /\.js$/, //匹配所有js文件
        exclude: /node_modules/, //除了node_modules模块
        use: ["eslint-loader"],
      },
```

```
eslint检查的规则：0  忽略   1  警告   2 错误
```

**package.json配置**

```
 "eslintConfig": {
    "parserOptions": {
      "ecmaVersion": 6, //支持es6
      "sourceType": "module"   //使用es6模块化
    },
    "env": {
      "browser": true,//支持浏览器环境，能够使用windows上的全局变量
      "node": true//支持服务器环境，能够使用node上的global上的全局变量
    },
    "globals": {//声明使用的全局变量，这样即使没有定义也不会报错了
      "$": "readonly"//$代表只读变量
    },
    "rules": {  //eslint检查的规则：0  忽略   1  警告   2 错误
      "no-console": 0,  //不检查console.log
      "eqeqeq": 0,
      "no-alert": 0
    },
    "extends": "eslint:recommended"//使用eslint推荐使用的默认规则https://cn.eslint.org/docs/rules
  }
```

## 7.安装loader（babel-loader)

此 package 允许你使用 [Babel](https://github.com/babel/babel) 和 [webpack](https://github.com/webpack/webpack) 转译 `JavaScript` 文件

```
npm install -D babel-loader @babel/core @babel/preset-env webpack
```

## 8.babel/polyfill（兼容性处理）

在入口文件中引入

```
import '@babel/polyfill'//包含es6语法的高级转换,不管编码人员用了哪些新语法，全部的新语法都转换了
```

```
npm install @babel/polyfill
```

## 9.借助按需引入core-js（兼容性处理）

```
npm install core-js
```

```
 /* js兼容性处理 */
      {
        test: /\.m?js$/,
        exclude: /(node_modules)/,
        use: {
          loader: "babel-loader",
          options: {
            presets: [
              [
                "@babel/preset-env",
                {
                  useBuiltIns: "usage", //按需引入需要使用polyfill
                  corejs: { version: 3 }, //解决不能够找到corejs的问题
                  targets: {
                    //指定兼容性处理哪些浏览器
                    chrome: "58",
                    ie: "9",
                  },
                },
              ],
            ],
            cacheDirectory: true, //开启babel缓存
          },
        },
      },
```





