import { ADDPERSON } from "../constant";
const initState = [{ id: "001", name: "公司", age: 10 }];
const addPerson = (preState = initState, action) => {
  const { type, data } = action;
  switch (type) {
    case ADDPERSON:
      return [data,...preState];

    default:
      return preState;
  }
};
export { addPerson };
