import { useEffect, useState } from "react";
import {  useNavigate } from "react-router-dom";
import "../App.css";
import { Formik } from "formik";  

export default function AddUser(){
    const [users,setUsers] = useState([]);
    const  navigate = useNavigate();

    const REGEX = {
        email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
      };

    const[user,setUser] = useState({
    id:"",
    name:"",
    email:"" });

    useEffect(() =>{
        const UserList = [...(JSON.parse(localStorage.getItem('users')))];
     setUsers(UserList);
    },[])
  
    const handlerChange = (e) =>{
        let name = e.target.name;
        let value = e.target.value;
        let newID = users[users.length - 1].id + 1;
       setUser({
        ...user,
        "id":newID,
        [name]:value
       })
    }

    function handleValidate() {
        const errors = {};
        if (!user.email) {
          errors.email = "Required";
        } else if (!REGEX.email.test(user.email)) {
          errors.email = "Invalid email address";
        }
       
        return errors;
      }

    function handleSubmit(e){
        if(user.id && user.name && user.email){
            const newList  = users;
            newList.push(user);
            localStorage.setItem("users",JSON.stringify(newList));
            navigate(`/`);
        }else{
            alert("Khong du du lieu, vui long nhap lai")
        }
    }

    return (
        <div> 
          <div>
              <h1>User</h1>
              <Formik
            initialValues={user}
            validate={handleValidate}
            onSubmit={handleSubmit}
            >
              {/* <div>
                <label>Name: </label>
                <input  name="name"   onChange={handlerChange} />
              </div>
              <div>
                <label>Email: </label>
                <input name="email" onChange={handlerChange} />
              </div>
              <button type="submit">Submit</button> */}

                {({ errors, handleSubmit }) => (
              <form onSubmit={handleSubmit}>
                <div>
                    <label>Name</label>
                    <input
                    type="text"
                    name="name"
                    onChange={handlerChange}
                  />
                </div>
                <div
                  className={`custom-input ${
                    errors.email ? "custom-input-error" : ""
                  }`}
                >
                  <label>Email</label>
                  <input
                    type="email"
                    name="email"
                    value={user.email || ""}
                    onChange={handlerChange}
                  />
                  <p className="error">{errors.email}</p>
                </div>

        
                <button type="submit">Submit</button>
              </form>
            )}
              </Formik>
          </div>
         
        </div>
    )
    
}