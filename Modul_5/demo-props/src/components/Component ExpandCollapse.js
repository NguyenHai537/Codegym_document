import { render } from "@testing-library/react";
import { Component } from "react";

class ExpandCollapse extends Component{
    constructor(props) {
        super(props);
        this.state = {
            isExpand: false
        };
      }
    

    handler = () =>{
       
        switch(this.state.isExpand){
            case false:
                this.setState({
                    isExpand:true
                })
                break;
                case true:
                    this.setState({
                        isExpand:false
                    })
                    break;
        }
    };

    render(){
        if (this.state.isExpand == false) {
            return(
                <div>
                    <h1>Conditional Rendering</h1>
                        <button onClick={this.handler}>Xem Gioi Thieu</button>
                </div>
            ) 
        }
        if (this.state.isExpand == true) {
            return(
                <div>
                    <h1>Conditional Rendering</h1>
                        <button onClick={this.handler}>Dong Gioi Thieu</button>
                        <h1>Gioi Thieu</h1>
                        <p>Nguyen Thanh Hai- CodeGym- C0922i1</p>
                </div>
            ) 
        }
      
      }
}

export default  ExpandCollapse;
