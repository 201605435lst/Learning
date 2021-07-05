```
// 这里是获取到的图片base64编码,这里只是个例子哈，要自行编码图片替换这里才能测试看到效果



  const imgUrl = 'data:image/png;base64,...'



  // 如果浏览器支持msSaveOrOpenBlob方法（也就是使用IE浏览器的时候），那么调用该方法去下载图片



  if (window.navigator.msSaveOrOpenBlob) {



    var bstr = atob(imgUrl.split(',')[1])



    var n = bstr.length



    var u8arr = new Uint8Array(n)



    while (n--) {



      u8arr[n] = bstr.charCodeAt(n)



    }



    var blob = new Blob([u8arr])



    window.navigator.msSaveOrOpenBlob(blob, 'chart-download' + '.' + 'png')



  } else {



    // 这里就按照chrome等新版浏览器来处理



    const a = document.createElement('a')



    a.href = imgUrl



    a.setAttribute('download', 'chart-download')



    a.click()



  }
```

以上。