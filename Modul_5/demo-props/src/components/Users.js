import { useEffect, useState } from "react";
import {  useNavigate } from "react-router-dom";
import "../App.css";

export default function Users(){
    const  navigate = useNavigate();
    const [users,setUsers] = useState([])


    useEffect(() => {
        const UserList = JSON.parse(localStorage.getItem('users'));
        setUsers(UserList);
        // fetch('https://jsonplaceholder.typicode.com/users')
        // .then(response => response.json())
        // .then( (json) =>{
        //      console.log(json);
        //      localStorage.setItem('users',JSON.stringify(json));
        //      setUsers(json)
        // }           
        //     )

    },[])

    function handleDelete(e){
        const id = e.target.value;
        const newList  = users;
        newList.splice(id,1);
        localStorage.setItem("users",JSON.stringify(newList));
        navigate(`/`);
    }
   

      return(
        <div>
            <h2>User List</h2>
            <button onClick={() => navigate (`/addUser`)}>Add New User</button>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map( (user,index)=>(
                        
                        <tr>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                            <button onClick={() => navigate (`/editUser/${user.id}`)} >Edit</button>
                            <button onClick={handleDelete} value={index}>Delete</button>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
      )
}