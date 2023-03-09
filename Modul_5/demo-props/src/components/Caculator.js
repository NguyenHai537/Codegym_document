import { Component } from "react";

class Caculator extends Component{
    constructor(props) {
        super(props);
        this.state = {
          firstNumber: 0,
          secondNumber:0,
          result:0
        };
      }

      inputFirstNumber = (e) => {
        this.setState({
            firstNumber:e.target.value
        });
      }

      inputSecondNumber = (e) =>{
        this.setState({
            secondNumber:e.target.value
        });
      }

    //  add = () => {
    //     this.setState({
    //         result:parseInt(this.state.firstNumber) + parseInt(this.state.secondNumber)
    //     })
        
    //  };

    //  sub = () => {
    //     this.setState({
    //         result:parseInt(this.state.firstNumber) - parseInt(this.state.secondNumber)
    //     })
        
    //  };

    //  mul = () => {
    //     this.setState({
    //         result:parseInt(this.state.firstNumber) * parseInt(this.state.secondNumber)
    //     })
        
    //  };

    //  div = () => {
    //     this.setState({
    //         result:parseInt(this.state.firstNumber) / parseInt(this.state.secondNumber)
    //     })
        
    //  };

    handleResult = (e) =>{
        switch (e.target.value){
            case "+":
                this.setState({
                    result:parseInt(this.state.firstNumber) + parseInt(this.state.secondNumber)
                });
                break;
            case "-":
                    this.setState({
                        result:parseInt(this.state.firstNumber) - parseInt(this.state.secondNumber)
                    });
                    break;
             case "*":
                        this.setState({
                            result:parseInt(this.state.firstNumber) * parseInt(this.state.secondNumber)
                        });
                        break;
            case "/":
                            this.setState({
                                result:parseInt(this.state.firstNumber) / parseInt(this.state.secondNumber)
                            });
                            break;
        }
    }
     

      render(){
        return(
            <div>
                <input type={"number"} onChange={this.inputFirstNumber} placeholder="0"></input>
                <input type={"number"} onChange={this.inputSecondNumber} placeholder="0"></input>
                <p>Result: </p>
                <button value ="+" onClick={this.handleResult}>+</button>
                <button value ="-" onClick={this.handleResult}>-</button>
                <button value ="*" onClick={this.handleResult}>*</button>
                <button value ="/" onClick={this.handleResult}>/</button>
                <br/>
                <span>{this.state.result}</span>
            </div>
        )
      }
}

export default Caculator;