import React from "react";
import ReactDOM from "react-dom";

export default function Demo() {
  const [count, changeCount] = React.useState(100);

  const [userName, changeUserName] = React.useState("张三");

 const myRef=React.useRef()

  function add() {
    changeCount(count + 10); //第一种写法
  }
  //   /* 需求1：当名字发生变化时检测值的变化 */
  //   React.useEffect(() => {
  //     console.log("@@@发生变化了");
  //   }, []);

  /* 需求2：组件挂在会页面的值隔一秒加1 */
  React.useEffect(() => {
    let timer = setInterval(() => {
      changeCount((count) => count + 1);
    }, 1000);
    return () => {
      clearInterval(timer);
    };
  }, []);

  function unMount() {
    ReactDOM.unmountComponentAtNode(document.getElementById("root"));
  }
function show(){
    alert(myRef.current.value)
}

  function name() {
    changeUserName("李四");
  }
  return (
    <div>
        <input ref={myRef}></input>
      <h2>当前的和为:{count}</h2>
      <br />
      <h2>当前的名字为:{userName}</h2>
      <br />
      <button onClick={add}>点我加10</button>
      <button onClick={name}>点我改名字</button>
      <button onClick={unMount}>卸载组件</button>
      <button onClick={show}>点我弹出提示输入的数字</button>
    </div>
  );
}
