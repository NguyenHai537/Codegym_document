import "../App.css";
import { useState} from "react";

export default function QLVS(){
    const[studentList,setStudentList] = useState([]);
    const[form,setForm] = useState({
        name:"",
        phone:"",
        email:""
    });
    const[isValid,setIsValid] = useState(false);
    const[indexSelected,setIndexSelected] = useState(-1);


    const handlerChange = (e) =>{
        let name = e.target.name;
        let value = e.target.value;
       const updatedForm = ({ ...form, [name]: value });
       setForm(updatedForm)
        checkInvalidForm(updatedForm);
    }

    const checkInvalidForm = ({ name, phone, email }) => {
      const value = name && phone && email;
      setIsValid(value);
    };

    const handleSubmit = () =>{   
        if(isValid){
            const newList = studentList;
            if(indexSelected > -1){
                newList.splice(indexSelected,1,form)
                setIndexSelected(-1);
            }else{
                newList.push(form)
            }
           setStudentList(newList);
        }   
              setForm({ name: "", phone: "", email: "" }) ;
        
    }

    const handDelete = (e) =>{
        const index = e.target.value;
        const newList = [...studentList];
        newList.splice(index,1);
        setStudentList(newList);
    }

    const handleSelect = (e) =>{
        const index = e.target.value
        const student = studentList[index] 
        setForm(JSON.parse(JSON.stringify( student)));
        setIndexSelected(index);
    }



    return (
        <div> 
          <div>
              <h1>Student List</h1>
              <div>
                <label>Name: </label>
                <input name="name" value={form.name}  onChange={handlerChange} />
              </div>
              <div>
                <label>Phone: </label>
                <input  name="phone"  value={form.phone} onChange={handlerChange} />
              </div>
              <div>
                <label>Email: </label>
                <input name="email" value={form.email} onChange={handlerChange} />
              </div>
              <button onClick={handleSubmit}>Submit</button>
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
                {studentList.map((student,index) => (
                               <tr>
                               <td>{student.name}</td>
                               <td>{student.phone}</td>
                               <td>{student.email}</td>
                               <td> <button onClick={handleSelect} value={index}>Edit</button>
                               <button onClick={handDelete} value={index}>Delete</button>
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