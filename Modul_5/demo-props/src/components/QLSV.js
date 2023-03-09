import "../App.css";
import { Component } from "react";

class Student extends Component{
    constructor(props){
        super(props);
        this.state = {
            studentList:[],
            form: {  name: "", phone: "", email: "" },
            isValid:false,
            indexSelected:-1
        }
    }

    handlerChange = (e) =>{
        this.setState((state) =>{
            const form = state.form
            form[e.target.name] = e.target.value
            return {form}
        },() => this.checkInvalidForm())
    }

    handleSelect = (e) => {
        const index = e.target.value
        const student =this.state.studentList[index] 
        console.log(student)
        this.setState({
            form:JSON.parse(JSON.stringify( student)),
            indexSelected: index
        })
       
    }

    checkInvalidForm = () => {
        const {name,phone,email} = this.state.form
        const value = name && phone && email
        this.setState({
            isValid:value
        })
    }

    handleSubmit = () =>{
      
        if( this.state.isValid){
            const newList = this.state.studentList
            if(this.state.indexSelected > -1){
                newList.splice(this.state.indexSelected,1,this.state.form)
                this.setState({
                    indexSelected:-1
                })

            }else{
                newList.push(this.state.form)

            }
            this.setState({
                studentList:newList
            })
        }
        this.setState({
            form: { name: "", phone: "", email: "" }
        })

    }

    handDelete = (e) =>{
        const index = e.target.value
        const newList = this.state.studentList
        newList.splice(index,1)
        this.setState({
            studentList:newList
        })
    }

   
    render () {
      //  const { studentList, form } = this.state
        return (
          <div> 
            <div>
                <h1>Student List</h1>
                <div>
                  <label>Name: </label>
                  <input name="name" value={this.state.form.name}  onChange={this.handlerChange} />
                </div>
                <div>
                  <label>Phone: </label>
                  <input type="number" name="phone"  value={this.state.form.phone} onChange={this.handlerChange} />
                </div>
                <div>
                  <label>Email: </label>
                  <input name="email" value={this.state.form.email} onChange={this.handlerChange} />
                </div>
                <button onClick={this.handleSubmit}>Submit</button>
                <table>
                  <thead>
                    <tr>
                        
                            <td>Name</td>
                            <td>Phone</td>
                            <td>Email</td>
                            <td>Action</td>
                    </tr>
                  </thead>
                  <tbody>
                  {this.state.studentList.map((student,index) => (
                                 <tr>
                                 <td>{student.name}</td>
                                 <td>{student.phone}</td>
                                 <td>{student.email}</td>
                                 <td> <button onClick={this.handleSelect} value={index}>Edit</button>
                                 <button onClick={this.handDelete} value={index}>Delete</button>
                                 </td>
                                
                             </tr>
                            ))
                            }
                  </tbody>
                </table>
            </div>
          </div>
        )
      }
    }

export default Student;


