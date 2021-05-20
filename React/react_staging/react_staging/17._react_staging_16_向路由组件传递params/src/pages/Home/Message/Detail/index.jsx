import React, { Component } from 'react'

const dataResults=[
    {id:'001',content:'内容1'},
    {id:'002',content:'内容2'},
    {id:'003',content:'内容3'}
]
export default class Detail extends Component {
  
    render() {
        console.log(this.props);
        const {id,title}=this.props.match.params
        const objResult=dataResults.find(item=>{
            return item.id===id
        })
        return (
            <div>
                <h2>ID:{id}</h2>
                <h2>TITLE:{title}</h2>
                <h2>CONTENT:{objResult.content}</h2>
            </div>
        )
    }
}
