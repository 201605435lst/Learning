## 1 .AJAX 的特点

**AJAX 的优点 **

```
1. 可以无需刷新页面而与服务器端进行通信

2. 允许你根据用户事件来更新部分页面内容
```

**AJAX 的缺点**

```
1. 没有浏览历史，不能回退

2. 存在跨域问题(同源)

3. SEO 不友好
```

## 2. HTTP相关问题

```
1. 前后应用从浏览器端向服务器发送HTTP 请求(请求报文)

2. 后台服务器接收到请求后, 调度服务器应用处理请求, 向浏览器端返回HTTP响应(响应报文)

3. 浏览器端接收到响应, 解析显示响应体/调用监视回调
```

## 3.HTTP 请求报文

1. 请求行
   method url
   GET /product_detail?id=2
   POST /login

2. 多个请求头
   Host: www.baidu.com
   Cookie: BAIDUID=AD3B0FA706E; BIDUPSID=AD3B0FA706;
   Content-Type: application/x-www-form-urlencoded 或者application/json

3. 请求体
   username=tom&pwd=123
   {"username": "tom", "pwd": 123}

## 4.HTTP 响应报文
```
响应状态行: status statusText

多个响应头

Content-Type: text/html;charset=utf-8

Set-Cookie: BD_CK_SAM=1;path=/

响应体

html 文本/json 文本/js/css/图片...
```

## 5. post 请求体参数格式
```
Content-Type: application/x-www-form-urlencoded;charset=utf-8
用于键值对参数，参数的键值用=连接, 参数之间用&连接
例如: name=%E5%B0%8F%E6%98%8E&age=12

Content-Type: application/json;charset=utf-8
用于 json 字符串参数
例如: {"name": "%E5%B0%8F%E6%98%8E", "age": 12}

Content-Type: multipart/form-data
用于文件上传请求
```

## 6. 常见的响应状态码
```
200 OK 请求成功。一般用于GET 与POST 请求

201 Created 已创建。成功请求并创建了新的资源

401 Unauthorized 未授权/请求要求用户的身份认证

404 Not Found 服务器无法根据客户端的请求找到资源

500 Internal Server Error 服务器内部错误，无法完成请求
```

## 7 不同类型的请求及其作用
```
GET: 从服务器端读取数据（查）

POST: 向服务器端添加新数据 （增）

PUT: 更新服务器端已经数据 （改）

DELETE: 删除服务器端数据 （删）
```

## 8. API 的分类
```
REST API: restful （Representational State Transfer (资源)表现层状态转化）

(1) 发送请求进行CRUD 哪个操作由请求方式来决定

(2) 同一个请求路径可以进行多个操作

(3) 请求方式会用到GET/POST/PUT/DELETE
```

```
非REST API: restless

(1) 请求方式不决定请求的CRUD 操作

(2) 一个请求路径只对应一个操作

(3) 一般只有GET/POST
```

## 9. 区别 一般http请求 与 ajax请求

```
ajax请求 是一种特别的 http请求

对服务器端来说, 没有任何区别, 区别在浏览器端

浏览器端发请求: 只有XHR 或fetch 发出的才是ajax 请求, 其它所有的都是非ajax 请求

浏览器端接收到响应

(1) 一般请求: 浏览器一般会直接显示响应体数据, 也就是我们常说的刷新/跳转页面

(2) ajax请求: 浏览器不会对界面进行任何更新操作, 只是调用监视的回调函数并传入响应相关数据
```

## 10.REST API   restful

```
发送请求进行CRUD哪个操作由请求方式来决定

同一个请求路径可以进行多个操作

请求方式会用到GET/POST/PUT/DELETE
```

## 11.非REST API  restless

```
请求方式不决定请求的CRUD操作

一个请求路径只对应一个操作

一般只有GET/POST操作
```

## 12.搭建rest接口

```
借助github:json-server库

json-server --watch db.json
```

**test.html**

```
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <button onclick="testGet()">get请求</button>
    <button onclick="testPost()">post请求</button>
    <button onclick="testPut()">put请求</button>
    <button onclick="testDelete()">delete请求</button>
    <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js"></script>
    <script>
      function testGet() {
        axios.get("http://localhost:3000/posts?id=1").then((response) => {
          console.log(response.data);
        });
      }
      function testPost() {
        axios
          .post("http://localhost:3000/posts", {
            title: "json-server11",
            author: "typicode11",
          })
          .then((response) => {
            console.log(response.data);
          });
      }
      function testDelete() {
        axios
          .delete("http://localhost:3000/posts/1"
          )
          .then((response) => {
            console.log(response.data);
          });
      }
      function testPut() {
        axios.put("http://localhost:3000/posts?id=1", {
            title: "json-server22",
            author: "typicode555",
          }).then((response) => {
          console.log(response.data);
        });
      }
    </script>
  </body>
</html>

```

## 13.XHR的理解和使用--XMLHttpRequest

```
XMLHttpRequest（XHR）对象用于与服务器交互。通过 XMLHttpRequest 可以在不刷新页面的情况下请求特定 URL，获取数据。这允许网页在不影响用户操作的情况下，更新页面的局部内容。XMLHttpRequest 在 AJAX 编程中被大量使用。
```

```
使用XMLHttpRequest(XHR)对象可以与服务器交互，也就是发送Ajax请求。

前端可以获取得到的数据，而无需让整个的页面刷新。

这使得web页面可以只更新页面的局部，而不影响用户的操作。
```

## 14.区别一般http请求与ajax请求

```
ajax请求是一种特别的http请求

对服务器来说，没有任何区别，区别在浏览器端

浏览器发送请求，只有XHR或fetch发出的才是ajax请求，其他的都是非ajax请求

浏览器端接受到的相应：

		一般请求：浏览器一般会直接显示响应体数据，也就是我们常说的刷新/跳转页面
		
		ajax请求：浏览器不会对界面进行任何的更新操作，只是调用监视的回调函数病传入相应相关数据
		
	
```

## 15.XHR的理解和使用

```
XMLHttpRequest():创建XHR对象的构造函数

status:相应状态码

statusText:相应状态文本

readyState:表示请求状态的只读属性
	0：初始
	1：open（）之后
	2：send（）之后
	3：请求中
	4：请求完成
	
onreadystatechange:绑定readyState改变的监听

responseType:指定相应数据类型，如果是json，得到响应数据后自动解析响应

response:响应体数据，类型取决于responseType的指定

timeout:指定请求超时时间，默认为0代表没有限制

ontimeout:绑定超时的监听
```



## 16.简单axios书写

```
<body>
    <button onclick="testGet()">get请求</button>
    <button onclick="testPost()">post请求</button>
    <button onclick="testPut()">put请求</button>
    <button onclick="testDelete()">delete请求</button>
    <script>
      function testGet() {
        axios({
          url: "http://localhost:3000/posts",
          method: "GET",
          params: {
            id: 2,
          },
        }).then(
          (response) => {
            console.log(response);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
      function testPost() {
        axios({
          url: "http://localhost:3000/posts",
          method: "POST",
          data: {
            title: "json-server1",
            author: "typicode1",
          },
        }).then(
          (response) => {
            console.log(response);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
      /* 发送put请求 */
      function testPut() {
        axios({
          url: "http://localhost:3000/posts/2",
          method: "PUT",
          data: {
            title: "json-server1==========",
            author: "typicode1============",
          },
        }).then(
          (response) => {
            console.log(response);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
      /* 发送delete请求 */
      function testDelete() {
        axios({
          url: "http://localhost:3000/posts/2",
          method: "delete",
        }).then(
          (response) => {
            console.log(response);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
    </script>
  </body>
```

```
       /* 
            1.函数的返回值为promise,成功的结果为response,异常的结果为error
            2.能处理多种类型的请求：GET/POST/PUT/DELETE
            3.函数的参数为一个配置对象
                {
                    url:'',//请求地址
                    method:'',//请求方式
                    params:{},//GET/DELETE请求的query参数
                    data:{},//POST或DELETE请求的请求体参数
                }
            4.相应json数据，自动解析为js
        
        */
 function axios({ url, method = "GET", params = {}, data = {} }) {

        /* 处理method */
        method=method.toUpperCase()

        /* 返回一个promise对象 */
        return new Promise((resolve, reject) => {

          /* 处理url,拼接params参数 */
          let queryString = "";

          Object.keys(params).forEach((key) => {
            queryString += `${key}=${params[key]}&`;
          });

          if (queryString) {
            queryString = queryString.substring(0, queryString.length - 1);
            url = url + "?" + queryString;
          }

          var xhr = new XMLHttpRequest();

          /* 打开连接（初始化请求，没有请求） */
          xhr.open(method, url);

          /* 发送请求 */
          if (method === "GET" || method === "DELETE") {
            /* send是异步 */
            xhr.send();
          } else if(method === "POST" || method === "PUT") {
            xhr.setRequestHeader(
              "Content-Type",
              "application/json;charset=utf-8"
            );
            xhr.send(JSON.stringify(data));
          }

          /* 绑定状态改变的监听 */
          xhr.onreadystatechange = function () {
            /* 如果请求没有完成，直接结束 */
            if (xhr.readyState !== 4) {
              return;
            }

            /* 如果相应状态码在[200,300)之间代表成功，否则失败 */

            const { status, statusText } = xhr;
            if (status >= 200 && status <= 299) {
              const response = {
                data: JSON.parse(xhr.response),
                status,
                statusText,
              };

              /* 如果成功了，调用resolve */

              resolve(response);
            } else {
              /* 如果失败了，调用reject */
              reject(new Error("request error status is" + status));
            }
          };
        });
      }
   
```

