import React, { Component } from 'react';
class Color extends Component {
    constructor(props) {
      super(props);
      this.state = {
        color: 'black',
        shape:'Circle'
      };
    }
   
   
    componentDidMount(){
      this.setState({color:'red'});
      this.setState({color:'Rectangle'})
    }
   
    render() {
      return (
        <div>
         <h1>Color: {this.state.color}</h1>
         <h1>Shape:{this.state.shape}</h1>
        </div>
      );
    }
  }
   
  export default Color;