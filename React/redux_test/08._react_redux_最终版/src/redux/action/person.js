import {ADDPERSON} from '../constant'

const addPerson=(personObj)=>({
    type:ADDPERSON,
    data:personObj
})
export {
    addPerson,
}
