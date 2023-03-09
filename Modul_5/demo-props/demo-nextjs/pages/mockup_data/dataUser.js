import axios from "axios";
import {  useEffect, useState } from "react";

export default function getUsers(){
    const [users,setUsers] = useState([]);

    useEffect(()=>{
        axios
        .get(`http://localhost:3001/api/users`)
        .then(res => {
          const newList = res.data;
          setUsers(newList);
        })
        .catch(error => console.log(error));
    },[])

        return (
          <div>
            <h1>Users</h1>
            <ul>
              {users.map(user => (
                <li key={user.id}> {user.name} </li>
              ))}
            </ul>
          </div>
        );
      
    }

    
    
   
