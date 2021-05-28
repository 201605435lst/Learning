import React from "react";

export default function Demo() {

  const [count, changeCount] = React.useState(100);

  const [userName, changeUserName] = React.useState("张三");
  function add() {
    // changeCount(count+10)  //第一种写法
    changeCount(count=>count+1)
  };
  function name(){
    changeUserName("李四")
  }
  return (
    <div>
      <h2>当前的和为:{count}</h2>
      <br />
      <h2>当前的名字为:{userName}</h2>
      <br />
      <button onClick={add}>点我加10</button>
      <button onClick={name}>点我改名字</button>
    </div>
  );
}
