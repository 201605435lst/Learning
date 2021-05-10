/* 统一暴露 */
function foo1() {
  console.log("foo1-----module2");
}
function foo2() {
  console.log("foo2-----module2");
}
export { foo1, foo2 }; //export { foo1 as foo1, foo2 as foo2 };

