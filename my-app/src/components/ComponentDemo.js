import React from "react"

export default class ComponentDemo extends React.Component {

   
    print1() {
        console.log("this is print");
    }

    render() {
        this.print1();
        return (
            <>
               <h1>H1</h1>
               <h2>h2</h2>
            </>
        
          )
    
        }

}

