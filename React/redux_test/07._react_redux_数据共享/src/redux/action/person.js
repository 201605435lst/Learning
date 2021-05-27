import {ADDPERSON} from '../constant'

const person=(personObj)=>({
    type:ADDPERSON,
    data:personObj
})
export {
    person,
}
